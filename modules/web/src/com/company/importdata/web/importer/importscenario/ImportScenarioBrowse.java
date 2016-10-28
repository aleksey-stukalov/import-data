package com.company.importdata.web.importer.importscenario;

import com.company.importdata.entity.importer.ImportLog;
import com.company.importdata.entity.importer.ImportScenario;
import com.company.importdata.entity.importer.LogRecordLevel;
import com.company.importdata.service.importer.ImporterService;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.app.core.file.FileUploadDialog;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.config.WindowConfig;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.web.App;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class ImportScenarioBrowse extends AbstractLookup {

    @Inject
    private ImporterService importerService;

    @Inject
    private CollectionDatasource<ImportScenario, UUID> importFilesDs;

    @Inject
    private Button btnImport;

    @Inject
    private Metadata metadata;

    @Inject
    private DataManager dataManager;

    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        btnImport.setEnabled(importFilesDs.getItem() != null);
        importFilesDs.addItemChangeListener(e -> btnImport.setEnabled(e.getItem() != null));
    }

    public void onBtnImportClick() {
        WindowConfig windowConfig = AppBeans.get(WindowConfig.NAME);

        final FileUploadDialog dialog = (FileUploadDialog) App.getInstance().getWindowManager().
                openWindow(windowConfig.getWindowInfo("fileUploadDialog"), WindowManager.OpenType.DIALOG);

        final ImportScenario scenario = importFilesDs.getItem();

        dialog.addCloseListener(actionId -> {
                    if (COMMIT_ACTION_ID.equals(actionId)) {
                        FileUploadingAPI fileUploading = AppBeans.get(FileUploadingAPI.NAME);
                        FileDescriptor descriptor = fileUploading.getFileDescriptor(dialog.getFileId(), dialog.getFileName());
                        try {
                            fileUploading.putFileIntoStorage(dialog.getFileId(), descriptor);
                            descriptor = dataManager.commit(descriptor);

                            ImportLog log = metadata.create(ImportLog.class);
                            log.setImportScenario(scenario);
                            log.setFile(descriptor);
                            log = dataManager.commit(log);
                            log = importerService.doImport(log, null, true);

                            showCompletionMessage(log);

                        } catch (FileStorageException e) {
                            Log log = LogFactory.getLog(this.getClass());
                            log.error("File upload has failed", e);
                            showNotification("File upload has failed", NotificationType.ERROR);
                        }
                    }
                });
    }

    private void showCompletionMessage(ImportLog log) {
        long errorCount = log.getRecords().stream().filter(r -> r.getLevel().equals(LogRecordLevel.ERROR)).count();
        long warnCount = log.getRecords().stream().filter(r -> r.getLevel().equals(LogRecordLevel.WARN)).count();

        if ((errorCount + warnCount) == 0) {
            showOptionDialog("Import Result"
                    ,"<font color=\"green\">Import has been successfully finished with no warnings/errors</font>"
                    ,MessageType.CONFIRMATION_HTML
                    ,new Action[] {
                            new DialogAction(DialogAction.Type.OK, true)
                    });
        } else {
            showOptionDialog("Import Result"
                    ,String.format("<font color=\"red\">Import has been finished with %s ERRORS and %s WARNINGS</br>" +
                            "Click OK to see import log</font>", errorCount, warnCount)
                    ,MessageType.WARNING_HTML
                    ,new Action[] {
                            new DialogAction(DialogAction.Type.OK, true) {
                                @Override
                                public void actionPerform(Component component) {
                                    super.actionPerform(component);
                                    openWindow("importdata$ImportLog.browse", WindowManager.OpenType.NEW_TAB,
                                            ParamsMap.of("selectLogItem", log));
                                }
                            }
                            ,new DialogAction(DialogAction.Type.CANCEL)
                    });
        }
    }

    public Component generateTemplateCell(ImportScenario entity) {
        if (entity.getTemplate() != null) {
            final ExportDisplay exportDisplay = AppBeans.get(ExportDisplay.NAME);
            Button button = componentsFactory.createComponent(Button.class);
            button.setStyleName("link");
            button.setAction(new AbstractAction("download") {
                @Override
                public void actionPerform(Component component) {
                    exportDisplay.show(entity.getTemplate());
                }

                @Override
                public String getCaption() {
                    return entity.getTemplate().getName();
                }
            });
            return button;
        }

        return null;
    }

}
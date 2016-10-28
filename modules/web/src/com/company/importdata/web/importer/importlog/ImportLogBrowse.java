package com.company.importdata.web.importer.importlog;

import com.company.importdata.entity.importer.ImportLog;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.WindowParam;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;

public class ImportLogBrowse extends AbstractLookup {

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private GroupTable<ImportLog> importLogsTable;

    @WindowParam(name = "selectLogItem")
    private ImportLog selectLogItem;

    @Override
    public void ready() {
        super.ready();

        if (selectLogItem != null) {
            importLogsTable.sortBy(importLogsTable.getDatasource().getMetaClass().getPropertyPath("started"), false);
            importLogsTable.expandPath(selectLogItem);
            importLogsTable.setSelected(selectLogItem);
        }
    }

    public Component generateFileCell(ImportLog entity) {
        if (entity.getFile() != null) {
            final ExportDisplay exportDisplay = AppBeans.get(ExportDisplay.NAME);
            Button button = componentsFactory.createComponent(Button.class);
            button.setStyleName("link");
            button.setAction(new AbstractAction("download") {
                @Override
                public void actionPerform(Component component) {
                    exportDisplay.show(entity.getFile());
                }

                @Override
                public String getCaption() {
                    return entity.getFile().getName();
                }
            });
            return button;
        }

        return null;
    }
}
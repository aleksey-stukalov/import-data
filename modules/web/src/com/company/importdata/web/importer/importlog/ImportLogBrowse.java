package com.company.importdata.web.importer.importlog;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.components.AbstractAction;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Component;
import com.company.importdata.entity.importer.ImportLog;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;

public class ImportLogBrowse extends AbstractLookup {

    @Inject
    private ComponentsFactory componentsFactory;

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
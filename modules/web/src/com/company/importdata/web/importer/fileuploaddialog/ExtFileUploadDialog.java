package com.company.importdata.web.importer.fileuploaddialog;

import com.haulmont.cuba.gui.app.core.file.FileUploadDialog;
import com.haulmont.cuba.gui.components.ResizableTextArea;

import javax.inject.Inject;

public class ExtFileUploadDialog extends FileUploadDialog {

    @Inject
    private ResizableTextArea comments;

    public String getComment() {
        return comments.getValue();
    }
}

/*
 * TODO Copyright
 */

package com.company.importdata.importer;

import com.company.importdata.entity.importer.ImportLog;
import com.haulmont.cuba.core.entity.FileDescriptor;

import java.util.Map;

/**
 * Created by aleksey on 20/10/2016.
 */
public interface ImporterAPI {

    /**
     *
     * @param fileDescriptor Descriptor of the file to import from
     */
    void setFileDescriptor(FileDescriptor fileDescriptor);

    /**
     * @param params
     * @return Number of entities persisted
     */
    ImportLog doImport(ImportLog log, Map<String, Object> params);

}

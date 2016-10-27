/*
 * TODO Copyright
 */

package com.company.importdata.web.importer.datasources;


import com.company.importdata.entity.importer.Importer;
import com.company.importdata.service.importer.ImporterService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.data.impl.CustomCollectionDatasource;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by aleksey on 20/10/2016.
 */
public class ImportersDatasource extends CustomCollectionDatasource<Importer, UUID> {

    private ImporterService importerService = AppBeans.get(ImporterService.NAME);

    @Override
    protected Collection<Importer> getEntities(Map<String, Object> params) {
        return importerService.getImporters();
    }
}

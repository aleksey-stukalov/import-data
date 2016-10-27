package com.company.importdata.entity.importer;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.FileDescriptor;

@NamePattern("%s - %s|started,finished")
@Table(name = "IMPORTDATA_IMPORT_LOG")
@Entity(name = "importdata$ImportLog")
public class ImportLog extends StandardEntity {
    private static final long serialVersionUID = -1784817362652283170L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FILE_ID")
    protected FileDescriptor file;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTED")
    protected Date started;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISHED")
    protected Date finished;

    @Column(name = "ENTITIES_PROCESSED")
    protected Integer entitiesProcessed;

    @OneToMany(mappedBy = "importLog")
    protected List<ImportLogRecord> records;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMPORT_SCENARIO_ID")
    protected ImportScenario importScenario;

    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public FileDescriptor getFile() {
        return file;
    }


    public void setImportScenario(ImportScenario importScenario) {
        this.importScenario = importScenario;
    }

    public ImportScenario getImportScenario() {
        return importScenario;
    }





    public void setEntitiesProcessed(Integer entitiesProcessed) {
        this.entitiesProcessed = entitiesProcessed;
    }

    public Integer getEntitiesProcessed() {
        return entitiesProcessed;
    }


    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getStarted() {
        return started;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public Date getFinished() {
        return finished;
    }

    public void setRecords(List<ImportLogRecord> records) {
        this.records = records;
    }

    public List<ImportLogRecord> getRecords() {
        return records;
    }


}
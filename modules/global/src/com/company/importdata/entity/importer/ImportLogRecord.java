package com.company.importdata.entity.importer;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s: %s|level,message")
@Table(name = "IMPORTDATA_IMPORT_LOG_RECORD")
@Entity(name = "importdata$ImportLogRecord")
public class ImportLogRecord extends StandardEntity {
    private static final long serialVersionUID = -2593406807214063152L;

    @Column(name = "MESSAGE", nullable = false)
    protected String message;

    @Column(name = "LEVEL_", nullable = false)
    protected String level;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIME_", nullable = false)
    protected Date time;

    @Lob
    @Column(name = "STACKTRACE")
    protected String stacktrace;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMPORT_LOG_ID")
    protected ImportLog importLog;

    public void setImportLog(ImportLog importLog) {
        this.importLog = importLog;
    }

    public ImportLog getImportLog() {
        return importLog;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setLevel(LogRecordLevel level) {
        this.level = level == null ? null : level.getId();
    }

    public LogRecordLevel getLevel() {
        return level == null ? null : LogRecordLevel.fromId(level);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public String getStacktrace() {
        return stacktrace;
    }


}
alter table IMPORTDATA_LOG_RECORD add constraint FK_IMPORTDATA_LOG_RECORD_IMPORT_LOG foreign key (IMPORT_LOG_ID) references IMPORTDATA_IMPORT_LOG(ID);
create index IDX_IMPORTDATA_LOG_RECORD_IMPORT_LOG on IMPORTDATA_LOG_RECORD (IMPORT_LOG_ID);
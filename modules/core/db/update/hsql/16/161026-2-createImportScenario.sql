alter table IMPORTDATA_IMPORT_SCENARIO add constraint FK_IMPORTDATA_IMPORT_SCENARIO_TEMPLATE foreign key (TEMPLATE_ID) references SYS_FILE(ID);
create index IDX_IMPORTDATA_IMPORT_SCENARIO_TEMPLATE on IMPORTDATA_IMPORT_SCENARIO (TEMPLATE_ID);

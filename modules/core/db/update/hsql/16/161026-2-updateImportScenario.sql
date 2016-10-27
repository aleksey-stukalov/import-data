alter table IMPORTDATA_IMPORT_SCENARIO add column IMPORTER_BEAN_NAME varchar(255) default '' not null ;
alter table IMPORTDATA_IMPORT_SCENARIO drop column IMPORTER_NAME cascade ;

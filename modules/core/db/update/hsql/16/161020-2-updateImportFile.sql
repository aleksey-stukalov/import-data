alter table IMPORTDATA_IMPORT_FILE add column IMPORTER_NAME varchar(255) default '' not null ;
alter table IMPORTDATA_IMPORT_FILE add column IMPORTER_DESCRIPTION longvarchar ;
alter table IMPORTDATA_IMPORT_FILE alter column COMMENT_ set data type longvarchar ;

alter table IMPORTDATA_IMPORT_SCENARIO add column NAME varchar(255) default '' not null ;
alter table IMPORTDATA_IMPORT_SCENARIO drop column IMPORTER_DESCRIPTION cascade ;

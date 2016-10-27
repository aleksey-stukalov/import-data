-- alter table IMPORTDATA_IMPORT_LOG add column FILE_NAME_ID varchar(36) ^
-- update IMPORTDATA_IMPORT_LOG set FILE_NAME_ID = <default_value> ;
-- alter table IMPORTDATA_IMPORT_LOG alter column FILE_NAME_ID set not null ;
alter table IMPORTDATA_IMPORT_LOG add column FILE_NAME_ID varchar(36) not null ;
alter table IMPORTDATA_IMPORT_LOG add column IMPORT_SCENARIO_ID varchar(36) ;
alter table IMPORTDATA_IMPORT_LOG drop column IMPORT_FILE_ID cascade ;
alter table IMPORTDATA_IMPORT_LOG alter column STARTED set null ;
alter table IMPORTDATA_IMPORT_LOG alter column FINISHED set null ;

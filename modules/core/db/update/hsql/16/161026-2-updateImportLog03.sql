-- alter table IMPORTDATA_IMPORT_LOG add column FILE_ID varchar(36) ^
-- update IMPORTDATA_IMPORT_LOG set FILE_ID = <default_value> ;
-- alter table IMPORTDATA_IMPORT_LOG alter column FILE_ID set not null ;
alter table IMPORTDATA_IMPORT_LOG add column FILE_ID varchar(36) not null ;
alter table IMPORTDATA_IMPORT_LOG drop column FILE_NAME_ID cascade ;

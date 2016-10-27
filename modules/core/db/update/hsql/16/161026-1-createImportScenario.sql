create table IMPORTDATA_IMPORT_SCENARIO (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEMPLATE_ID varchar(36) not null,
    COMMENT_ longvarchar,
    IMPORTER_NAME varchar(255) not null,
    IMPORTER_DESCRIPTION longvarchar,
    --
    primary key (ID)
);

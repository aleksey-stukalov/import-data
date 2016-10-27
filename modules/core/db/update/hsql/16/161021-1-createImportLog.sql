create table IMPORTDATA_IMPORT_LOG (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STARTED timestamp not null,
    FINISHED timestamp not null,
    ENTITIES_PROCESSED integer,
    IMPORT_FILE_ID varchar(36),
    --
    primary key (ID)
);

-- begin IMPORTDATA_CUSTOMER
create table IMPORTDATA_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(50) not null,
    SECOND_NAME varchar(50) not null,
    DOCUMENT_NUMBER varchar(50) not null,
    DESCRIPTION longvarchar,
    PRIORITY integer,
    --
    primary key (ID)
)^
-- end IMPORTDATA_CUSTOMER

-- begin IMPORTDATA_IMPORT_LOG
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
    FILE_ID varchar(36) not null,
    STARTED timestamp,
    FINISHED timestamp,
    ENTITIES_PROCESSED integer,
    IMPORT_SCENARIO_ID varchar(36),
    COMMENT_ longvarchar,
    --
    primary key (ID)
)^
-- end IMPORTDATA_IMPORT_LOG
-- begin IMPORTDATA_IMPORT_SCENARIO
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
    NAME varchar(255) not null,
    TEMPLATE_ID varchar(36) not null,
    COMMENT_ longvarchar,
    IMPORTER_BEAN_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end IMPORTDATA_IMPORT_SCENARIO
-- begin IMPORTDATA_IMPORT_LOG_RECORD
create table IMPORTDATA_IMPORT_LOG_RECORD (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MESSAGE varchar(255) not null,
    LEVEL_ varchar(50) not null,
    TIME_ timestamp not null,
    STACKTRACE longvarchar,
    IMPORT_LOG_ID varchar(36),
    --
    primary key (ID)
)^
-- end IMPORTDATA_IMPORT_LOG_RECORD

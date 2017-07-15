-- begin SAMPLE_HOST
create table SAMPLE_HOST (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    IP_ADDRESS inet,
    --
    primary key (ID)
)^
-- end SAMPLE_HOST

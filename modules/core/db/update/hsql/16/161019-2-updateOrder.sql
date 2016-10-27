alter table IMPORTDATA_ORDER drop column CODE cascade ;
alter table IMPORTDATA_ORDER add column CODE varchar(255) default '' not null ;

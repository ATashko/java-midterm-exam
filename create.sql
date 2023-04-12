create table if not exists PATIENTS
(id int primary key,
name varchar(255),
lastName varchar (255),
address varchar (255),
DNI int,
dischargedDate varchar);

create table if not exists DENTISTS
(id int primary key,
lastName varchar (255),
name varchar(255),
license int);


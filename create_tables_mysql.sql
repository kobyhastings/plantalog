/*
Table Creation File, MySQL
Project: Plantalog
Authors: Aaron Eisenberg
Date: 5/7/15
*/

drop database if exists Plantalog;
create database Plantalog;

use Plantalog;

create table Users (
	user_id char(9) primary key,
	name varchar(25),
	password varchar(500),
	email varchar(50),
	user_since timestamp,
	user_type char(1)
);

create table Views (
	date_time timestamp DEFAULT CURRENT_TIMESTAMP,
	user_id char(9),
	specimen_id char(9),
	primary key(date_time, user_id, specimen_id)
);

create table SpecimenRegion (
	region_name varchar(25) primary key,
	description text
);

create table Specimen (
	plant_id varchar(9),
	specimen_id varchar(9),
	notes text,
	latitude float(9,6) check((latitude > -90) AND (latitude < 90)),
	longitude float(9,6) check((longitude > -180) AND (longitude < 180)),
	when_added timestamp DEFAULT CURRENT_TIMESTAMP,
	lives_in varchar(25),
	primary key(plant_id, specimen_id),
	constraint lives_in_exists foreign key(lives_in) references SpecimenRegion(region_name) on delete set null
);

create table Plant (
	plant_id char(9) primary key,
	cultivar varchar(50),
	sci_name varchar(50),
	com_name varchar(50),
	notes text
);

create table PlantImage (
	plant_id char(9),
	image_id char(9),
	path varchar(100),
	caption text,
	primary key(plant_id, image_id),
	constraint plant_id_exists foreign key(plant_id) references Plant(plant_id) on delete cascade
);

grant usage on *.* to plantalog@localhost identified by 'plantalogpw'; 
grant all privileges on Plantalog.* to plantalog@localhost;

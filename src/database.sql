CREATE DATABASE lecoinbon;

\c lecoinbon

create table users (
 	id serial PRIMARY KEY ,
	name VARCHAR, 
	family_name VARCHAR,
	login VARCHAR,
	password VARCHAR
);

insert into users (name, family_name, login, password) VALUES ( 'Rachid', 'Bimboum', 'rachid34', 'tactac');
insert into users (name, family_name, login, password) VALUES ( 'Sofiane', 'Nasri', 'sofiane59', 'bim');
insert into users (name, family_name, login, password) VALUES ( 'Bernadette', 'Cambier', 'berna11', 'sert78');
insert into users (name, family_name, login, password) VALUES ( 'Christophe', 'Mermoz', 'chris62', 'erc78');


create table annonces ( 
	id serial PRIMARY KEY, 
	titre VARCHAR NOT NULL,
	description VARCHAR NOT NULL, 
	owner_id INT default null REFERENCES users,
	created DATE default null,
	activated BOOLEAN
) ;

create table categories ( 
	id serial PRIMARY KEY, 
	category_name VARCHAR,
	annonce_id INT default null REFERENCES annonces
) ;

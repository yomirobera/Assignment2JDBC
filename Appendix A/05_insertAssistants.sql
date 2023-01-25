-- Database: SuperheroesDb

-- DROP DATABASE IF EXISTS "SuperheroesDb";

CREATE DATABASE "SuperheroesDb"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Norwegian_Norway.1252'
    LC_CTYPE = 'Norwegian_Norway.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	

/*05*/
/* Inserting data into Assistant */
INSERT INTO Assistant (Name, SuperheroId) VALUES (
	'Jessie Pinkman', 3),
	('John Kane', 2),
	('Maria Johnson', 1);
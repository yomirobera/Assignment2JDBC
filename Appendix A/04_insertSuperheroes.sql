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
	

/*04*/
/* Insert data into superhero*/
INSERT INTO Superhero (Name, Alias, Origin) VALUES (
	'Spiderman','Peter Parker','NYC'),
	('Hulk','Mark Raffalo','LA'),
	('Heisnberg','Walter White','Albuquerque');
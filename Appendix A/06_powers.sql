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
	

/*06*/
/* Inserting Data into power table */
INSERT INTO Power (Name, Description) VALUES (
	'Flying','The uperhero has the ability to fly'),
	('Teleportation','Thesuperhero has the ability to teleport'),
	('Super Strength','the superhero has super strength'),
	('Cook Crystals','The sperhero has super intelligence');
	
/* Assigning superheroes their powers */
/* Spider-man has multiple powers and the cook crystals power is used by multiple superheroes.*/
INSERT INTO PowerSuperhero (SuperheroId, PowerId) VALUES (1, 1);
INSERT INTO PowerSuperhero (SuperheroId, PowerId) VALUES (1, 4);
INSERT INTO PowerSuperhero (SuperheroId, PowerId) VALUES (1, 2);
INSERT INTO PowerSuperhero (SuperheroId, PowerId) VALUES (3, 4);

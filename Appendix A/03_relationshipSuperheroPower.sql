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
	

/* 03_relationshipheroPower */
/*Foreign key constraints for Superhero and power with alter table statments*/
ALTER TABLE PowerSuperhero 
ADD FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id);
ALTER TABLE PowerSuperhero
ADD FOREIGN KEY (PowerId) REFERENCES Power(Id);
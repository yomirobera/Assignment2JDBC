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
	
/* Appendix A scripts to create a Superheroes Database */
/*Creating Superhero table*/

CREATE TABLE Superhero (
	Id serial PRIMARY KEY,
	Name VARCHAR (50) NOT NULL,
	Alias VARCHAR (25) NOT NULL,
	Origin VARCHAR (100) NOT NULL
);

/*Creating assistant table*/
CREATE TABLE Assistant (
	Id serial PRIMARY KEY,
	Name VARCHAR(50) NOT NULL
);

/*Creating Power table */
CREATE TABLE Power (
	Id serial PRIMARY KEY,
	Name VARCHAR (50) NOT NULL,
	Description VARCHAR (50) NOT NULL
);
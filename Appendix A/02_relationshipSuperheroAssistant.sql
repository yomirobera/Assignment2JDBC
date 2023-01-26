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
	
/*O2_relationshipSuperheroAssistant.sql */
/* Creating a relationship between superhero and assistant by using the ALTER SQL KEYWORD
foreign key and constraint for the relationship between these two tables.*/

ALTER TABLE Assistant 
ADD COLUMN SuperheroId INT REFERENCES Superhero(Id);

ALTER TABLE Assistant ADD CONSTRAINT fkAssistantSuperhero
FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id);


/* Creating a relationship between superhero and power. This is done by creating a linking table called 
PowerSuperhero. This is because many to many relationship
*/
CREATE TABLE PowerSuperhero(
	SuperheroId INT REFERENCES Superhero(Id),
	PowerId INT REFERENCES Power(Id),
	PRIMARY KEY (SuperheroId, PowerId)
);
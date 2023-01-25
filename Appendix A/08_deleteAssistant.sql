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
	


/*08
First it is important to drop foreign key constraint the re-add we 
use the CASCADE Keyword to specify hat when a referenced row is deleted, 
row(s) referencing it should be automatically deleted as well.*/
/* Deleting data */
//
ALTER TABLE Assistant
DROP CONSTRAINT fkAssistantSuperhero,

ADD CONSTRAINT fkAssistantSuperhero
FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id)
ON DELETE CASCADE;

/* Now we can run the following command */
DELETE FROM Assistant
WHERE Assistant(Id) = 1;
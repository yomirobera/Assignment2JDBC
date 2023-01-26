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
 Deleting data
*/
ALTER TABLE Assistant
DROP CONSTRAINT fkAssistantSuperhero,

ADD CONSTRAINT fkAssistantSuperhero
FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id)
ON DELETE CASCADE;

/* Run the following command */
DELETE FROM Assistant
WHERE Assistant(Id) = 1;
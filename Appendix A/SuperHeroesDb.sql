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

/*O2_relationshipSuperheroAssistant.sql */
/* Creating a relationship between superhero and assistant by using the ALTER SQL KEYWORD
foreign key and constraint for the relationship between these two tables.*/

ALTER TABLE Assistant 
ADD COLUMN SuperheroId INT REFERENCES Superhero(Id);

ALTER TABLE Assistant ADD CONSTRAINT fkAssistantSuperhero
FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id);


/* Creating a relationship between superhero and power. This is done by creating a linking table called 
PowerSuperhero. This is beacuse many to many relationship
*/
CREATE TABLE PowerSuperhero(
	SuperheroId INT REFERENCES Superhero(Id),
	PowerId INT REFERENCES Power(Id),
	PRIMARY KEY (SuperheroId, PowerId)
);
/* 03_relationshipheroPower */
/*Foreign key constraints for Superhero and power with alter table statments*/
ALTER TABLE PowerSuperhero 
ADD FOREIGN KEY (SuperheroId) REFERENCES Superhero(Id);
ALTER TABLE PowerSuperhero
ADD FOREIGN KEY (PowerId) REFERENCES Power(Id);

/* Insert data into superhero*/
INSERT INTO Superhero (Name, Alias, Origin) VALUES (
	'Spiderman','Peter Parker','NYC'),
	('Hulk','Mark Raffalo','LA'),
	('Heisnberg','Walter White','Albuquerque');

/* Inserting data into Assistant */
INSERT INTO Assistant (Name, SuperheroId) VALUES (
	'Jessie Pinkman',(SELECT Id FROM Superhero WHERE Name = 'Heisnberg')),
	('John Kane',(SELECT Id FROM Superhero WHERE Name = 'Hulk')),
	('Maria Johnson',(SELECT Id FROM Superhero WHERE Name = 'Spiderman'));

/*06*/
/* Inserting Data into power table */
INSERT INTO Power (Name, Description) VALUES (
	'Flying','The uperhero has the ability to fly'),
	('Teleportation','Thesuperhero has the ability to teleport'),
	('Super Strength','the superhero has super strength'),
	('Cook Crystals','The sperhero has super intelligence');
	
/* Assigning superheroes their powers */
/* Spiderman has multiple powers and the cook crystals power is used by multiple superheroes.*/
INSERT INTO PowerSuperhero (SuperheroId,PowerId) VALUES(
(SELECT Id FROM Superhero WHERE Name = 'Spiderman'), 
(SELECT id FROM Power WHERE Name = 'Flying')),

((SELECT Id FROM Superhero WHERE Name = 'Spiderman'), 
(SELECT id FROM Power WHERE Name = 'Cook Crystals')),

((SELECT Id FROM Superhero WHERE Name = 'Spiderman'), 
(SELECT id FROM Power WHERE Name = 'Teleportation')),

((SELECT Id FROM Superhero WHERE Name = 'Heisnberg'),
(SELECT id FROM Power WHERE Name = 'Cook Crystals'));

/* 07 Update */
SELECT Superhero SET Name = 'Spooderman' WHERE Name = 'Spiderman';


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

	
	
												 





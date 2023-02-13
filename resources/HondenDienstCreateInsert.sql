CREATE SCHEMA HondenDienst;

USE HondenDienst;

CREATE TABLE `Klant` (
  `klantnummer` int NOT NULL AUTO_INCREMENT,
  `voorletters` varchar(10) NOT NULL,
  `tussenvoegsel` varchar(10) DEFAULT NULL,
  `achternaam` varchar(45) NOT NULL,
  `telefoon` varchar(10) NOT NULL,
  PRIMARY KEY (`klantnummer`)
);


CREATE TABLE `Hond` (
  `chipnummer` varchar(10) NOT NULL,
  `hondnaam` varchar(45) NOT NULL,
  `ras` varchar(45) NOT NULL,
  `klantnummer` int NOT NULL,
  PRIMARY KEY (`chipnummer`),
  KEY `fk_Hond_Klant1_idx` (`klantnummer`),
  CONSTRAINT `fk_Hond_Klant1` FOREIGN KEY (`klantnummer`) REFERENCES `Klant` (`klantnummer`)
) ;

CREATE TABLE `Medewerker` (
  `medewerkercode` varchar(3) NOT NULL,
  `medewerkervoornaam` varchar(45) NOT NULL,
  `medewerkerachternaam` varchar(45) NOT NULL,
  `startjaar` int NOT NULL,
  PRIMARY KEY (`medewerkercode`)
);

CREATE TABLE `Wandeling` (
  `wandelingId` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NOT NULL,
  `duur` DECIMAL(3,1) NOT NULL,
  `medewerkercode` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`wandelingId`),
  
  CONSTRAINT `fk_Wandeling_Medewerker1`
    FOREIGN KEY (`medewerkercode`)
    REFERENCES `Medewerker` (`medewerkercode`)
);

CREATE TABLE HondInWandeling (
	`wandelingId` INT NOT NULL,
	`chipnummer` VARCHAR(10) NOT NULL,
    PRIMARY KEY (wandelingId, chipnummer),
	CONSTRAINT `fk_Uitlaatbeurt_Hond`
		FOREIGN KEY (`chipnummer`)
		REFERENCES `Hond` (`chipnummer`),
        CONSTRAINT `fk_Uitlaatbeurt_Id`
		FOREIGN KEY (`wandelingId`)
		REFERENCES `Wandeling` (`wandelingId`)
    );

INSERT INTO `Klant`(voorletters,tussenvoegsel,achternaam,telefoon)  VALUES 
('G','de','Boer','0612345678'),
('MJW',NULL,'Willemsen','0611223344'),
('A','van','Veen','0623456172'),
('J',NULL,'Long','0612131415'),
('T',NULL,'Hartman','0656347263');

INSERT INTO `Hond` VALUES 
('48-345-5','Chipo','Mix',1),
('47-745-5','Gingy','Mix',1),
('48-335-5','Fred','Spaniel',4),
('47-674-0','Woolly','Dobermann',3),
('48-986-0','Spank','Jack Russell',2);

INSERT INTO `Medewerker` VALUES 
('GL','Gertjan', 'Laan', 2012),
('JC','Jacqueline', 'Courtois', 2018),
('MF','Martin' ,'Fowler', 2019),
('JW', 'Johnny', 'Walker', 2003);

INSERT INTO `Wandeling`(datum, duur, medewerkercode) VALUES 
('2016-01-02',2.0,'JC'),
('2016-01-03',3.0,'GL'),
('2016-01-05',2.5,'MF');

INSERT INTO HondInWandeling VALUES 
(1, '48-345-5'), 
(1, '47-745-5'), 
(2, '48-345-5'), 
(2, '47-745-5'), 
(2, '48-335-5'), 
(2, '47-674-0'), 
(3, '48-345-5'), 
(3, '47-745-5'), 
(3, '48-335-5'), 
(3, '48-986-0');

    
-- Gebruiker definiëren en toegang verlenen
CREATE USER 'userHondenDienst'@'localhost' IDENTIFIED BY 'pwHondenDienst';
GRANT ALL PRIVILEGES ON HondenDienst.* TO 'userHondenDienst'@'localhost';
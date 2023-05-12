-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bank
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `banks`
--

DROP TABLE IF EXISTS `banks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banks` (
  `idbanks` int NOT NULL,
  `lenRIB` int DEFAULT NULL,
  `nomBank` varchar(45) NOT NULL,
  PRIMARY KEY (`idbanks`),
  UNIQUE KEY `idbanks_UNIQUE` (`idbanks`),
  UNIQUE KEY `nomBank_UNIQUE` (`nomBank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banks`
--

LOCK TABLES `banks` WRITE;
/*!40000 ALTER TABLE `banks` DISABLE KEYS */;
INSERT INTO `banks` VALUES (123456,16,'Banque de Tunisie'),(234567,16,'Banque Nationale Agricole'),(345678,16,'Attijari Bank'),(456789,16,'Société Tunisienne de Banque'),(567890,16,'Banque de l\'Habitat');
/*!40000 ALTER TABLE `banks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comptebanquaire`
--

DROP TABLE IF EXISTS `comptebanquaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comptebanquaire` (
  `RIB` varchar(16) NOT NULL,
  `Solde` double DEFAULT NULL,
  `Prop` int DEFAULT NULL,
  `Type` varchar(45) NOT NULL,
  `idBank` int NOT NULL,
  PRIMARY KEY (`RIB`),
  UNIQUE KEY `RIB_UNIQUE` (`RIB`),
  KEY `bank_idx` (`idBank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comptebanquaire`
--

LOCK TABLES `comptebanquaire` WRITE;
/*!40000 ALTER TABLE `comptebanquaire` DISABLE KEYS */;
INSERT INTO `comptebanquaire` VALUES ('1254643352583056',6284,1,'Compte Courant',234567),('1480872723171809',30594,1,'Compte Courant',123456),('1569895769891130',250,1,'Compte Courant',345678),('1710568473836803',45390,10,'Compte Epargne',456789),('1943018092140172',39056,6,'Compte Epargne',567890),('2259178934632464',10876,7,'Compte Courant',234567),('2320663022259558',41352,4,'Compte Epargne',234567),('2629301573830122',20036,18,'Compte Courant',123456),('2824111448988263',12668,15,'Compte Courant',123456),('3012585485235704',16383,13,'Compte Courant',456789),('3388483426797444',9934,1,'Compte Courant',456789),('3410484725668934',27791,14,'Compte Epargne',123456),('3456784698720002',0,77,'Compte Courant',123456),('3528168016109748',2500,7,'Compte Epargne',123456),('3529831127475590',250,20,'Compte Epargne',345678),('376778221260315',0,9,'Compte Courant',567890),('377599040575155',3000,13,'Compte Courant',456789),('3792870236187146',10169,5,'Compte Courant',123456),('4043221970691157',1500,5,'Compte Epargne',123456),('4076219293583821',40351,16,'Compte Epargne',456789),('4556075080425416',2000,10,'Compte Epargne',123456),('4556696873861434',1000,15,'Compte Epargne',567890),('4783892947201051',49897,8,'Compte Courant',345678),('4878088947699399',23495,11,'Compte Courant',456789),('4913711721486825',0,4,'Compte Epargne',567890),('4916718511642572',65,1,'Compte Courant',567890),('4916754564315141',5000,16,'Compte Epargne',123456),('4949882013564541',45206,12,'Compte Epargne',234567),('5135676559265262',23118,9,'Compte Epargne',123456),('5251431578809256',0,11,'Compte Courant',123456),('5260023047289131',500,8,'Compte Courant',123456),('5264652660960215',200,18,'Compte Epargne',345678),('5356469565410337',400,14,'Compte Courant',345678),('5369847317110235',10000,6,'Compte Courant',123456),('5408549268505625',13270,17,'Compte Epargne',456789),('5733825587640363',34705,10,'Compte Courant',345678);
/*!40000 ALTER TABLE `comptebanquaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MDP` varchar(45) NOT NULL,
  `Login` varchar(45) NOT NULL,
  `Nom` varchar(45) DEFAULT NULL,
  `Prenom` varchar(45) DEFAULT NULL,
  `Adr` varchar(45) DEFAULT NULL,
  `Tel` int DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Type` varchar(45) NOT NULL DEFAULT 'client',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `Login_UNIQUE` (`Login`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'+sKbnvQO/SA8WReZSBvmPw==','client','Name','F-name','--',96,'yassinmanita@email.com','client'),(2,'+sKbnvQO/SA8WReZSBvmPw==','banker','Name','F-name','--',96,'yassinmanita@email.com','banquier'),(3,'+sKbnvQO/SA8WReZSBvmPw==','admin','Name','F-name','--',420,'yassinmanita@email.com','admin'),(4,'GwQJUG+pPcyuuXouCy8vzQ==','user1','Smith','John','123 Main St',5551234,'jsmith@email.com','client'),(5,'ddHQLuLIHw9qIOC6tZWyoQ==','user2','Johnson','Sarah','456 Elm St',5555678,'sjohnson@email.com','admin'),(6,'+w5bBLxtNML5RaT+1mJyyw==','user3','Davis','David','789 Oak St',5552468,'ddavis@email.com','banquier'),(7,'5DEqo5e4S58ZzwcrSGz5YA==','user4','Wilson','Jennifer','321 Maple St',5557890,'jwilson@email.com','client'),(8,'Tbx8vDMFo3R4Diz/FDA1Hw==','user5','Taylor','Robert','654 Pine St',5553456,'rtaylor@email.com','admin'),(9,'Ybc3LnH5n61oxig0e2eI4g==','user6','Brown','Jessica','987 Cedar St',5556789,'jbrown@email.com','banquier'),(10,'5rTV2idOnHkoxVa8jZu8AQ==','user7','Miller','Michael','654 Elm St',5551234,'mmiller@email.com','client'),(11,'hvYiAMQmd5eiE6pFIwHErg==','user8','Moore','Emily','321 Oak St',5555678,'emoore@email.com','admin'),(12,'CDLe5cFq9j/BBVGfLBCbwQ==','user9','Garcia','Maria','789 Maple St',5552468,'mgarcia@email.com','banquier'),(13,'ShbFEws+wm7DRd6yzAIk8w==','user10','Lee','David','123 Pine St',5557890,'dlee@email.com','client'),(14,'M2TAfUaqhdKFW986Uo/Jzg==','user11','Gonzalez','Isabella','456 Cedar St',5553456,'igonzalez@email.com','admin'),(15,'OmwrKeNAk9CoIzccDmGAsQ==','user12','Harris','William','789 Elm St',5556789,'wharris@email.com','banquier'),(16,'7OYMxGoFdFx82NlvqTW7tw==','user13','Clark','Olivia','654 Oak St',5551234,'oclark@email.com','client'),(17,'Kgv3b1I+h8ioaG545Lks1g==','user14','Jackson','Ethan','321 Maple St',5555678,'ejackson@email.com','admin'),(18,'9sisICYa5ieQZV5DvtTNKQ==','user15','Lewis','Sophia','789 Pine St',5552468,'slewis@email.com','banquier'),(19,'LAlk1cPgMSxQXgw/JUShTQ==','user16','Walker','Mia','123 Cedar St',5557890,'mwalker@email.com','client'),(20,'cPUbFxwCOQkht+P6U4SIyQ==','user17','Green','Alexander','456 Elm St',5553456,'agreen@email.com','admin'),(21,'TVVeDFGMRx+Q0nWDgl6vVw==','user18','Lopez','Emma','789 Oak St',5556789,'elopez@email.com','banquier'),(22,'9f9mJI1VsDxt+ISLxY7hKg==','user19','King','James','654 Maple St',5551234,'jking@email.com','client');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-13  0:57:12

CREATE DATABASE  IF NOT EXISTS `company` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `company`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `clientIDPK` int NOT NULL AUTO_INCREMENT,
  `clientID` varchar(20) DEFAULT NULL,
  `clientPassword` varchar(20) DEFAULT NULL,
  `clientName` varchar(45) DEFAULT NULL,
  `clientIDNumber` varchar(10) DEFAULT NULL,
  `clientMobile` varchar(10) DEFAULT NULL,
  `clientPhone` varchar(45) DEFAULT NULL,
  `clientEmail` varchar(45) DEFAULT NULL,
  `clientAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`clientIDPK`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'abcc','12345','aaaa','','000','123','',''),(2,'teacher',NULL,'teacher',NULL,NULL,NULL,NULL,NULL),(4,'ttt','456','aaaa',NULL,'11','77',NULL,'台北'),(5,'dsa','sww','ddd',NULL,'35','242',NULL,'eqte'),(6,'rhj','353','hh',NULL,'735','464',NULL,'reye'),(7,'aa','aa','aa-name',NULL,'aa','aa',NULL,'aa'),(8,'zzz','zzz','qq',NULL,'zzz','zzz',NULL,'zzz'),(9,'bhtre','12345','ee',NULL,'','',NULL,''),(10,'zxc','zxc','測試',NULL,'0933222666','02-23456789',NULL,'Taipei'),(11,'asdf','sergf','Test2','A230035676','0922987333','03-2344456','sfg@sfg','Taipei Taiwan'),(12,'ghjk','louk','ddd','','','','',''),(13,'tutuo','uiooo','dfg','','','','',''),(14,'uoupip','hjkio','aaddf','','','','',''),(15,'jttutjt','ttyyyy','ee','','','','',''),(16,'abcd','abcd','中文','','0922999888','','',''),(17,'ooooo','ppppp','ooName','A123456789','0922334455','02-2345678','name@yahoo.com','Taipei'),(18,'pppp','0000','poiuy','','0988777666','','','');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-14  9:41:45

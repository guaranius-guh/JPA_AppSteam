-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: db_appsteam
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `age_range`
--

DROP TABLE IF EXISTS `age_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `age_range` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ager` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `age_range`
--

LOCK TABLES `age_range` WRITE;
/*!40000 ALTER TABLE `age_range` DISABLE KEYS */;
INSERT INTO `age_range` VALUES (1,'18+'),(2,'16+'),(3,'14+'),(4,'12+'),(5,'Livre');
/*!40000 ALTER TABLE `age_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `developer`
--

DROP TABLE IF EXISTS `developer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `developer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `developer`
--

LOCK TABLES `developer` WRITE;
/*!40000 ALTER TABLE `developer` DISABLE KEYS */;
INSERT INTO `developer` VALUES (1,'Rockstar Games','Estados Unidos'),(2,'Ubisoft','França'),(3,'Remedy Entertainment','Finlândia');
/*!40000 ALTER TABLE `developer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `value` double NOT NULL,
  `id_age_range` bigint DEFAULT NULL,
  `id_developer` bigint DEFAULT NULL,
  `id_genre` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhgvemug4hcrnespj5ru476mh4` (`id_age_range`),
  KEY `FKcdlxbnlm1mep5u7l5avaun4qe` (`id_developer`),
  KEY `FKb0b08j92jk2g4g6je297hjmu0` (`id_genre`),
  CONSTRAINT `FKb0b08j92jk2g4g6je297hjmu0` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`id`),
  CONSTRAINT `FKcdlxbnlm1mep5u7l5avaun4qe` FOREIGN KEY (`id_developer`) REFERENCES `developer` (`id`),
  CONSTRAINT `FKhgvemug4hcrnespj5ru476mh4` FOREIGN KEY (`id_age_range`) REFERENCES `age_range` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1546970/header.jpg?t=1676922433','Grand Theft Auto III','2001-10-22',299,1,1,1),(2,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1546990/header.jpg?t=1676922450','Grand Theft Auto Vice City','2002-10-29',299,1,1,1),(3,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1547000/header.jpg?t=1676922466','Grand Theft Auto San Andreas','2004-10-26',299,1,1,1),(4,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/1174180/header.jpg?t=1720558643','Red Dead Redemption 2','2019-12-05',299,1,1,1),(5,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/359550/header.jpg?t=1731968067','Rainbow Six Siege','2015-12-01',99,4,2,2),(6,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/243470/header.jpg?t=1692817688','Watch Dogs','2014-05-26',99,1,2,1),(7,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/447040/header.jpg?t=1692817739','Watch Dogs 2','2016-11-29',149,1,2,1),(8,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2239550/header.jpg?t=1716280027','Watch Dogs Legion','2023-01-26',249,1,2,1),(9,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/2698940/header.jpg?t=1732580162','The Crew Motorfest',NULL,0,5,2,4),(10,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/870780/header.jpg?t=1726554320','Control','2020-08-27',149,2,3,1),(11,'https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/108710/header.jpg?t=1726554283','Alan Wake','2012-02-16',29,3,3,1);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Ação'),(2,'FPS'),(3,'Esporte'),(4,'Corrida'),(5,'Plataforma');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn4pb12f3y8ktduy8fnc2xlln1` (`role_id`),
  CONSTRAINT `FKn4pb12f3y8ktduy8fnc2xlln1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '','Gustavo Henrique Antonius','$2a$10$cwzO6hRjs46CRL1/jCTus.B88CO1i.f04yz0m1ep8qlNdqAkpHzYe','gustavo',2),(2,_binary '','Leanderson','$2a$10$yrPygl0zg62dQuxpNjwSyue2WCi7i1uwddPyVwTkCCwvu2dGMk4nu','leanderson',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_ADMIN','Administrador'),(2,'ROLE_USER','Usuário');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-27 19:53:54

-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: highland
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `price_update_detail`
--

DROP TABLE IF EXISTS `price_update_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_update_detail` (
  `price_update_detail_id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `price_new` int DEFAULT NULL,
  `price_old` int DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  PRIMARY KEY (`price_update_detail_id`),
  KEY `FKqqg6x7ou2wg76hybqnfmtnkcd` (`product_id`),
  KEY `FKnj2eq1uaj86owx8uuyndsocmt` (`created_by`),
  CONSTRAINT `FKnj2eq1uaj86owx8uuyndsocmt` FOREIGN KEY (`created_by`) REFERENCES `staff` (`staff_id`),
  CONSTRAINT `FKqqg6x7ou2wg76hybqnfmtnkcd` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_update_detail`
--

LOCK TABLES `price_update_detail` WRITE;
/*!40000 ALTER TABLE `price_update_detail` DISABLE KEYS */;
INSERT INTO `price_update_detail` VALUES (2,'2024-03-21 06:14:23',1,45000,45000,'JD6U86','2024-03-21 06:14:23',1),(3,'2024-03-21 06:19:28',1,45000,45000,'GQ9650','2024-03-21 06:19:28',1),(4,'2024-03-21 06:21:59',1,29000,29000,'D4O7YF','2024-03-21 06:21:59',1),(5,'2024-03-21 06:22:46',1,29000,29000,'VO9JLW','2024-03-21 06:22:46',1),(6,'2024-03-21 06:23:47',1,29000,29000,'ZZDS01','2024-03-21 06:23:47',1),(7,'2024-03-21 06:25:59',1,54000,54000,'KMQ643','2024-03-21 06:25:59',1),(8,'2024-03-21 06:26:45',1,45000,45000,'6YHHCR','2024-03-21 06:26:45',1),(9,'2024-03-21 08:45:28',1,45000,45000,'B6R2RG','2024-03-21 08:45:28',1);
/*!40000 ALTER TABLE `price_update_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01 10:09:27

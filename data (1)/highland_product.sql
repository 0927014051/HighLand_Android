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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` varchar(255) NOT NULL,
  `category_id` bigint DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_by` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK7l29ekt1x29jup80y2iigimyy` (`category_id`),
  KEY `FK6oxuma80sjforyoiieifnu9ds` (`created_by`),
  KEY `FKog9fb4kj4jbis5xpw890tp6us` (`updated_by`),
  CONSTRAINT `FK6oxuma80sjforyoiieifnu9ds` FOREIGN KEY (`created_by`) REFERENCES `staff` (`staff_id`),
  CONSTRAINT `FK7l29ekt1x29jup80y2iigimyy` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `FKog9fb4kj4jbis5xpw890tp6us` FOREIGN KEY (`updated_by`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('FCDMHT',2,'2024-04-07 16:07:24',1,'cà phê đá','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/0f2d95cc-e46c-4a51-8755-2681e46833f6jpg?alt=media','PHIN SỮA ĐÁ','Active','2024-04-08 04:15:24',1),('FHOL6K',1,'2024-04-08 04:05:37',1,'tra','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/928e39ac-03ec-4ef8-9324-513f63d44acdjpg?alt=media','TRÀ THẠCH VẢI','Active','2024-04-08 04:05:37',1),('K9N1NJ',1,'2024-04-07 14:37:54',1,'Trà Quả Mọng Anh Đào là sự kết hợp giữa trà thơm cùng quả mọng chua ngọt, thêm đài quả ngâm giòn giòn, đánh tan cơn khát.','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/d2894012-34cb-4b53-8732-2086f6b5d920jpg?alt=media','TRÀ QUẢ MỌNG ANH ĐÀO','Active','2024-04-08 03:46:42',1),('U1556B',1,'2024-04-07 13:56:39',1,'description 10000000','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/be04ab4d-227c-43ed-9210-eba452a15a0djpg?alt=media','Cameramel ','Active','2024-04-07 14:00:25',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-13  2:35:00

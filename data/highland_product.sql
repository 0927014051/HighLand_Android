-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: highland
-- ------------------------------------------------------
-- Server version	8.4.0

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
INSERT INTO `product` VALUES ('9XBWAY',3,'2024-04-08 03:52:49',1,'Vị thơm của trà hòa quyện cùng với vị béo ngậy của đậu đỏ','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/abe7b321-7bef-4d5d-9422-eee1782ce255jpg?alt=media','Trà xanh đậu đỏ ','Active','2024-04-23 05:23:01',1),('A40XV7',2,'2024-04-08 03:50:26',1,'Đậm đà hương vị cà phê tao cảm giác tỉnh táo cho một ngày làm việc hiệu quả','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/66de83b2-ac5a-4b0f-8650-9c11c7003b19png?alt=media','PHIN đen đá','Active','2024-04-23 05:25:03',1),('AKO985',5,'2024-04-23 06:05:24',1,'Bánh ngon!!!','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/f6479179-6b4d-4c98-bbee-a53f86d8837apng?alt=media','Bánh mousse đào','Active','2024-04-23 06:05:24',1),('C2D0R0',4,'2024-04-26 06:16:14',2,'Vị kem béo ngậy hòa quyện cùng với vị đắng nhẹ của chocolate tạo nên hương vị thơm ngon khó cưỡng','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/193b3081-1c09-42dc-98ef-82b5ae24ff3bjpg?alt=media','Freeze chocolate','Active','2024-04-26 06:16:14',2),('C2JVP0',2,'2024-04-08 03:48:33',1,'Đậm đà hương vị cà phê hòa quyện cùng vị sữa béo ngậy','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/16c01e83-6428-4189-9659-cf4eb09edb5ajpg?alt=media','Sữa đá','Unactive','2024-04-26 06:09:38',2),('FBLR1X',5,'2024-04-23 06:07:38',1,'Bánh so-co-la ngon','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/71feacc4-6a98-4e3e-bb5e-8f423831f373png?alt=media','Bánh So-co-la','Active','2024-04-23 07:43:35',1),('GM990D',1,'2024-04-08 03:35:50',1,'Đậm đà hương vị cà phê hòa quyện cùng vị sữa béo ngậy','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/69c231d4-cd09-42aa-85a9-cac86c4ce496jpg?alt=media','PHIN sữa đá','Active','2024-04-23 05:49:50',1),('HBTHUR',3,'2024-04-23 06:00:04',1,'Hương vị thơm ngát của ổi hồng cùng với đị đậm của trà tạo nên hương vị ngon khó cưỡng','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/853cc692-2219-4fc1-a35a-1f44454d94c7jpg?alt=media','Trà ổi hồng','Active','2024-04-23 06:00:54',1),('JAMKTC',3,'2024-04-08 03:54:50',1,'Đậm vị trà thơm vị đào','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/888ae58c-1177-45cd-8449-f91a13b5ce0cjpg?alt=media','Trà thạch đào','Active','2024-04-23 05:50:22',1),('JFTDJQ',4,'2024-04-26 06:14:28',2,'Vị trà đạm đà hòa quyện cùng vị kem mát lạnh','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/728bffc6-a811-41f5-b456-6d2d17fb236bjpg?alt=media','Freeze trà','Active','2024-04-26 06:14:28',2),('OOCC4O',3,'2024-04-08 03:56:28',1,'Đậm vị trà thơm vị trái cây nhiệt đới ','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/15a98964-5ecf-44f2-972e-bedf13ff0e23jpg?alt=media','Trà quả mọng','Active','2024-04-23 05:51:39',1),('Q7CYYT',5,'2024-04-23 06:06:43',1,'Thơm vị cacao, bánh mềm và xốp','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/5bcc0a03-c6cf-4dce-adfd-0ea9cd74990epng?alt=media','Bánh cacao','Active','2024-04-26 06:08:33',2),('QKC10G',1,'2024-04-08 04:04:45',1,'Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Choco ngọt tan mang đến hương vị mới lạ, không thể hấp dẫn hơn!','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/3477c964-93b7-44fb-b73e-7c425ae598fejpg?alt=media','Phindi Kem Sữa','Active','2024-04-23 05:52:38',1),('RDGCIL',3,'2024-04-08 03:59:20',1,'Vị thơm ngon béo ngậy của hạt sen hòa quyện cùng vị trà lài thơm ngát ','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/9059bf04-d0f2-43be-85e0-4668c6a30669jpg?alt=media','Trà sen vàng','Active','2024-04-23 05:52:55',1),('WFWQOH',1,'2024-04-08 04:02:28',1,'Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Choco ngọt tan mang đến hương vị mới lạ, không thể hấp dẫn hơn!','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/d414b639-6aaa-4575-817a-eebd127ba686jpg?alt=media','Phindi Choco','Active','2024-04-23 05:53:32',1),('ZZRAYU',3,'2024-04-08 03:53:44',1,'Đậm vị trà thơm vị vải','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/f45f71ec-e542-442c-967f-dea3d13f06efjpg?alt=media','Trà thạch vải đỏ','Active','2024-04-23 05:54:08',1);
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

-- Dump completed on 2024-06-11 22:48:23

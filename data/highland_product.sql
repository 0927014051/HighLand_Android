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
INSERT INTO `product` VALUES ('6YHHCR',6,'2024-03-21 06:26:45',1,'Vị trà đậm đà kết hợp cùng những miếng đào thơm ngon mọng nước cùng thạch đào giòn dai. Thêm vào ít sữa để gia tăng vị béo.','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/32336e8f-9b91-45a0-9e4d-891eb59aabe9jpg?alt=media','TRÀ THẠCH ĐÀO','Active','2024-03-21 06:26:45',1),('B6R2RG',4,'2024-03-21 08:45:28',1,'Hồng trà sữa là sự kết hợp giữa hồng trà (trà đen) với sữa tươi, thêm các loại topping như trân châu, thạch, pudding, tạo nên một đồ uống luôn có mặt trong menu các quán. Đây được coi là loại trà sữa truyền thống và phổ biến nhất. Bạn có thể thay thế nước cốt hồng trà bằng các loại hồng trà khác nhau, mang đến hương vị đặc sắc','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/bf07f314-21ca-4cef-8ac1-f4f53cd19e73jpeg?alt=media','HỒNG TRÀ SỮA','Active','2024-03-21 08:45:28',1),('D4O7YF',3,'2024-03-21 06:21:59',1,'Hương vị cà phê Việt Nam đích thực! Từng hạt cà phê hảo hạng được chọn bằng tay, phối trộn độc đáo giữa hạt Robusta từ cao nguyên Việt Nam, thêm Arabica thơm lừng. Kết hợp với nước sôi từng giọt cà phê được chiết xuất từ Phin truyền thống, hoà cùng sữa đặc sánh tạo nên ly Phin Sữa Nóng – Đậm đà chất Phin.!','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/9566e5fa-71ad-4f82-84b5-a3691c55eae9jpg?alt=media','PHIN SỮA NÓNG','Active','2024-03-21 06:21:59',1),('GQ9650',3,'2024-03-21 06:19:28',1,'PhinDi Choco - Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Choco ngọt tan mang đến hương vị mới lạ, không thể hấp dẫn hơn!','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/2ad87434-54aa-4ef9-8433-99cd38b6f303jpg?alt=media','PHINDI CHOCO','Active','2024-03-21 06:19:28',1),('JD6U86',3,'2024-03-21 06:14:23',1,'PhinDi Kem Sữa - Cà phê Phin thế hệ mới với chất Phin êm hơn, kết hợp cùng Kem Sữa béo ngậy mang đến hương vị mới lạ, không thể hấp dẫn hơn!','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/26b9ed08-5d3e-4f3e-b337-4a5b3bcb1195jpg?alt=media','PHINDI KEM SỮA','Active','2024-03-21 06:14:23',1),('KMQ643',6,'2024-03-21 06:25:59',1,'Một trải nghiệm thú vị khác! Sự hài hòa giữa vị trà cao cấp, vị sả thanh mát và những miếng đào thơm ngon mọng nước sẽ mang đến cho bạn một thức uống tuyệt vời.','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/49c89985-3a99-4699-9953-a87ebb27e9e9jpg?alt=media','TRÀ THANH ĐÀO','Active','2024-03-21 06:25:59',1),('VO9JLW',3,'2024-03-21 06:22:46',1,'Dành cho những tín đồ cà phê đích thực! Hương vị cà phê truyền thống được phối trộn độc đáo tại Highlands. Cà phê đậm đà pha từ Phin, cho thêm 1 thìa đường, mang đến vị cà phê đậm đà chất Phin. ','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/47ec82db-6e4d-47ab-937e-f831eb6ad6e9jpg?alt=media','PHIN ĐEN NÓNG','Active','2024-03-21 06:22:46',1),('ZZDS01',3,'2024-03-21 06:23:47',1,'Dành cho những tín đồ cà phê đích thực! Hương vị cà phê truyền thống được phối trộn độc đáo tại Highlands. Cà phê đậm đà pha hoàn toàn từ Phin, cho thêm 1 thìa đường, một ít đá viên mát lạnh, tạo nên Phin Đen Đá mang vị cà phê đậm đà chất Phin. . ','https://firebasestorage.googleapis.com/v0/b/image-highland-6ae35.appspot.com/o/9be4a72f-e609-4585-8a14-21509fec3cffjpg?alt=media','PHIN ĐEN ĐÁ','Active','2024-03-21 06:23:47',1);
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

-- Dump completed on 2024-04-01 10:09:28

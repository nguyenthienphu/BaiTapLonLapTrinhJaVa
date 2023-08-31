-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: moteldb
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `user_role` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `host_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_key_user_host_idx` (`host_id`),
  CONSTRAINT `foreign_key_user_host` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','orivinabon159','$2a$10$m9CVPX40qAOQj.96az4i2epkBimRDCkSpCDE6y/ukHqPgCpSVUNEe','https://res.cloudinary.com/de4ynzwro/image/upload/v1692115945/li8lg8f0k7vzxpl8h9f4.png',NULL,'ROLE_USER',NULL),(7,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','admin','$2a$10$Mq2Tj8SRxPWKpR.ThEQ7b.IGC26efJzJyerR9QWZNx.RvR0uz5fXO','https://res.cloudinary.com/de4ynzwro/image/upload/v1691773549/u0nrdtbfzt0lfkwzwloi.png',NULL,'ROLE_ADMIN',NULL),(8,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','host','$2a$10$/wX39v37uV/tt/WaMYt0VezJpZ4afW2Rwm1CcrmsgUZ7RqjR8KqzW','https://res.cloudinary.com/de4ynzwro/image/upload/v1692625504/fj8qbcfxxtvdqvynfz5q.png',NULL,'ROLE_HOST',1),(9,'Phú','Nguyễn Thiên1','orivinabon159@gmail.com','0901197277','admin2','$2a$10$/YecnOQLyhQWb0Thna8oP.RXTOppXW0b0.Bqku5ccMoiEcDVcBvNq','https://res.cloudinary.com/de4ynzwro/image/upload/v1692691858/ciyo5tst0okjy7lnn1xn.png',NULL,'ROLE_ADMIN',NULL),(10,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','host1','$2a$10$Khj0S6YkNqD58RJrnwnEXuuRyW4DvVTOfVdyZyfAk0SgoMMczfIwO','https://res.cloudinary.com/de4ynzwro/image/upload/v1692702129/pizmx034sgfuzwtriert.png',NULL,'ROLE_HOST',4),(11,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','host2','$2a$10$2et1s3g5cy4Q3.lYXDzPJuapIY9flzX7wMwNBxEmB69sqNrAF8wl.','https://res.cloudinary.com/de4ynzwro/image/upload/v1692702129/u6rqliwhpgyd5mkt2bpf.png',NULL,'ROLE_HOST',2),(12,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','host3','$2a$10$zhJO6eMAjplt43YVt0oqVOZq/bl79OLQqxRfErmeduasB3WtTTlt6','https://res.cloudinary.com/de4ynzwro/image/upload/v1692702186/kvxselxtkbbiycahdybw.png',NULL,'ROLE_HOST',3),(13,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','khachhang','$2a$10$1obMBiJa8.UcdU2Nux25heOdsj4jrnGzW30UTpFZfriBJLdaPdYIy','https://res.cloudinary.com/de4ynzwro/image/upload/v1692702217/vw3jjbjumoovq4mowv8u.png',NULL,'ROLE_ADMIN',NULL),(14,'Phú','Nguyễn Thiên','orivinabon159@gmail.com','0901197277','hosttesst','$2a$10$e3KpVMZlJXQVVucFAtbqqujMyedpBQ3i7qrbzPBY9aAvtULgGSrTi','https://res.cloudinary.com/de4ynzwro/image/upload/v1693414682/rvznmjbbrtd6qosjndxp.png',NULL,'ROLE_HOST',3);
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

-- Dump completed on 2023-08-31 12:38:20

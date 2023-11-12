-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: elm
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `orderdetailet`
--

DROP TABLE IF EXISTS `orderdetailet`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetailet`
(
    `odId`     int               NOT NULL AUTO_INCREMENT COMMENT '订单明细编号',
    `orderId`  int               NOT NULL COMMENT '所属订单编号',
    `foodId`   int               NOT NULL COMMENT '食品编号',
    `quantity` int               NOT NULL COMMENT '数量',
    `isDelete` TINYINT default 0 not null comment '是否删除',
    PRIMARY KEY (`odId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 81
  DEFAULT CHARSET = utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetailet`
--

LOCK TABLES `orderdetailet` WRITE;
/*!40000 ALTER TABLE `orderdetailet`
    DISABLE KEYS */;
INSERT INTO `orderdetailet`
VALUES (1, 2, 1, 1, 0),
       (2, 2, 2, 1, 0),
       (3, 3, 1, 2, 0),
       (4, 5, 1, 2, 0),
       (5, 6, 1, 2, 0),
       (6, 7, 1, 2, 0),
       (7, 7, 2, 3, 0),
       (8, 7, 3, 1, 0),
       (9, 7, 4, 1, 0),
       (10, 8, 1, 1, 0),
       (11, 9, 1, 2, 0),
       (12, 10, 10, 2, 0),
       (13, 10, 12, 3, 0),
       (14, 11, 1, 2, 0),
       (15, 12, 1, 7, 0),
       (16, 13, 1, 2, 0),
       (17, 14, 1, 3, 0),
       (18, 14, 2, 3, 0),
       (19, 15, 1, 3, 0),
       (20, 15, 2, 2, 0),
       (21, 15, 7, 2, 0),
       (22, 16, 1, 1, 0),
       (23, 17, 2, 2, 0),
       (24, 18, 1, 1, 0),
       (25, 19, 10, 4, 0),
       (26, 20, 2, 7, 0),
       (27, 21, 1, 2, 0),
       (28, 22, 1, 10, 0),
       (29, 23, 1, 4, 0),
       (30, 24, 10, 2, 0),
       (31, 25, 2, 2, 0),
       (32, 26, 2, 4, 0),
       (33, 26, 1, 1, 0),
       (34, 27, 1, 3, 0),
       (35, 28, 10, 1, 0),
       (36, 28, 11, 1, 0),
       (37, 28, 12, 1, 0),
       (38, 29, 12, 29, 0),
       (39, 30, 1, 2, 0),
       (40, 31, 1, 1, 0),
       (41, 32, 1, 3, 0),
       (42, 32, 7, 2, 0),
       (43, 33, 1, 3, 0),
       (44, 34, 10, 1, 0),
       (45, 34, 12, 2, 0),
       (46, 35, 1, 3, 0),
       (47, 35, 2, 22, 0),
       (48, 36, 1, 1, 0),
       (49, 37, 1, 2, 0),
       (50, 38, 10, 2, 0),
       (51, 39, 10, 4, 0),
       (52, 40, 11, 4, 0),
       (53, 41, 1, 2, 0),
       (54, 42, 1, 3, 0),
       (55, 43, 2, 2, 0),
       (56, 44, 1, 2, 0),
       (57, 45, 1, 3, 0),
       (58, 46, 1, 3, 0),
       (59, 47, 10, 4, 0),
       (60, 48, 1, 2, 0),
       (61, 49, 11, 4, 0),
       (62, 50, 1, 1, 0),
       (63, 51, 10, 2, 0),
       (64, 52, 1, 1, 0),
       (65, 53, 1, 2, 0),
       (66, 54, 1, 2, 0),
       (67, 55, 1, 2, 0),
       (68, 56, 1, 2, 0),
       (69, 57, 1, 2, 0),
       (70, 64, 1, 1, 0),
       (71, 65, 1, 2, 0),
       (72, 66, 1, 2, 0),
       (73, 67, 1, 3, 0),
       (74, 68, 1, 4, 0),
       (75, 69, 1, 1, 0),
       (76, 70, 1, 2, 0),
       (77, 71, 13, 2, 0),
       (78, 72, 1, 1, 0),
       (79, 73, 1, 2, 0),
       (80, 74, 1, 1, 0);
/*!40000 ALTER TABLE `orderdetailet`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2023-09-14 21:38:56

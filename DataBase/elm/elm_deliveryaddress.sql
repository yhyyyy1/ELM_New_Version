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
-- Table structure for table `deliveryaddress`
--

DROP TABLE IF EXISTS `deliveryaddress`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliveryaddress`
(
    `daId`        int               NOT NULL AUTO_INCREMENT COMMENT '送货地址编号',
    `contactName` varchar(20)       NOT NULL COMMENT '联系人姓名',
    `contactSex`  int               NOT NULL COMMENT '联系人性别',
    `contactTel`  varchar(20)       NOT NULL COMMENT '联系人电话',
    `address`     varchar(100)      NOT NULL COMMENT '送货地址',
    `userId`      varchar(20)       NOT NULL COMMENT '所属用户编号',
    `isDelete`    TINYINT default 0 not null comment '是否删除',
    PRIMARY KEY (`daId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryaddress`
--

LOCK TABLES `deliveryaddress` WRITE;
/*!40000 ALTER TABLE `deliveryaddress`
    DISABLE KEYS */;
INSERT INTO `deliveryaddress`
VALUES (1, '张三丰', 1, '11111111111', '沈阳市浑南新区彩霞街1-56号', '11111111111', 0),
       (2, '习近平', 1, '12345671111', '北京市中南海', '12345671111', 0),
       (3, '特没谱', 1, '12345672222', '美国华盛顿白宫', '12345672222', 0),
       (5, 'yhy', 1, '123', '1233', '11111111111', 0),
       (6, 'jjn', 1, '123', '123', '11111111111', 0),
       (7, '1区3qqq', 1, '12', '12', '1', 0),
       (8, '1', 1, '1', '1', '1', 0),
       (9, 'zjh', 1, '18880320148', '123', '18880320148', 0),
       (10, '123', 1, '123', '123', '1', 0),
       (11, 'qqq', 1, 'qq', 'q', '1', 0),
       (12, 'aaa', 1, '111111', '11111', '110', 0),
       (13, 'hhh', 1, '1', '1', '110', 0);
/*!40000 ALTER TABLE `deliveryaddress`
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

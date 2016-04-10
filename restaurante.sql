-- MySQL dump 10.13  Distrib 5.6.27, for Linux (x86_64)
--
-- Host: localhost    Database: restaurante
-- ------------------------------------------------------
-- Server version	5.6.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `desc_item` varchar(255) DEFAULT NULL,
  `preco_item` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Pizza Média',25),(2,'Macarrão',15),(3,'Porção Batata Frita',15.5),(4,'Estrogonofe de Frango',10),(5,'Salada Mista',5),(6,'Coca-Cola 600 ML',3.5);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` int(11) NOT NULL,
  `qtd_item` int(11) NOT NULL,
  `valor` double NOT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `pedido_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oalnikndojweunw777eactoo5` (`item_id`),
  KEY `FK_4ql24iphly75cwd5vx596mx8v` (`pedido_id`),
  CONSTRAINT `FK_4ql24iphly75cwd5vx596mx8v` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FK_oalnikndojweunw777eactoo5` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
INSERT INTO `item_pedido` VALUES (1,0,1,25,1,1),(2,0,2,30,2,1),(3,0,2,30,2,3),(4,0,1,25,1,3),(5,0,2,30,2,4),(6,0,1,25,1,4),(7,0,1,15,2,4),(8,0,2,50,1,5),(9,0,6,90,2,6),(10,0,2,50,1,7),(11,0,1,15,2,7),(12,0,1,25,1,6),(13,0,1,25,1,8),(14,0,1,15,2,8),(15,0,1,25,1,9),(16,0,2,30,2,9),(17,0,1,15,2,9),(18,0,1,15,2,10),(23,0,1,15,2,11),(24,0,1,15.5,3,11),(25,0,2,50,1,12),(26,0,3,10.5,6,12),(27,0,2,30,2,13),(28,0,2,7,6,13),(29,0,1,25,1,14),(30,0,1,3.5,6,14),(31,0,3,15,5,15),(32,0,5,77.5,3,14),(33,0,4,40,4,16),(36,0,2,50,1,18),(37,0,1,3.5,6,18),(38,0,1,3.5,6,18),(39,0,2,20,4,19),(42,0,5,125,1,20);
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesa` (
  `id` bigint(20) NOT NULL,
  `estado` int(11) NOT NULL,
  `num_cadeiras` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,1,2),(2,1,4),(3,1,6);
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papeis`
--

DROP TABLE IF EXISTS `papeis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `papeis` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `papel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papeis`
--

LOCK TABLES `papeis` WRITE;
/*!40000 ALTER TABLE `papeis` DISABLE KEYS */;
INSERT INTO `papeis` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_COZINHEIRO'),(4,'ROLE_PEDIDO');
/*!40000 ALTER TABLE `papeis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `valor` double NOT NULL,
  `mesa_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ggr7xsngdre4c8yvogbbanpci` (`mesa_id`),
  CONSTRAINT `FK_ggr7xsngdre4c8yvogbbanpci` FOREIGN KEY (`mesa_id`) REFERENCES `mesa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2015-11-29 20:50:18',0,55,1),(2,'2015-11-29 20:59:06',0,0,1),(3,'2015-11-29 21:03:33',0,55,1),(4,'2015-11-29 21:23:08',0,70,1),(5,'2015-11-29 22:10:05',0,50,1),(6,'2015-11-29 22:13:26',0,115,1),(7,'2015-11-29 22:14:09',0,65,2),(8,'2015-11-29 23:13:35',0,40,1),(9,'2015-11-29 23:29:53',0,70,3),(10,'2015-11-29 23:43:10',0,37,1),(11,'2015-11-30 00:20:24',0,30.5,3),(12,'2015-11-30 13:28:23',0,60.5,2),(13,'2015-11-30 13:33:24',0,37,3),(14,'2015-11-30 13:33:33',0,106,1),(15,'2015-11-30 13:33:36',0,15,2),(16,'2016-02-27 19:43:22',0,40,1),(17,'2016-02-27 19:51:08',0,0,1),(18,'2016-04-05 21:18:19',0,57,1),(19,'2016-04-09 00:55:59',0,20,1),(20,'2016-04-09 01:25:12',0,125,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_papel`
--

DROP TABLE IF EXISTS `usuario_papel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_papel` (
  `papel_id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  KEY `FK_175yg7q33fygwg98s58ck5cjk` (`usuario_id`),
  KEY `FK_cgnr5my023wlksdak4bd08vjk` (`papel_id`),
  CONSTRAINT `FK_175yg7q33fygwg98s58ck5cjk` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FK_cgnr5my023wlksdak4bd08vjk` FOREIGN KEY (`papel_id`) REFERENCES `papeis` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_papel`
--

LOCK TABLES `usuario_papel` WRITE;
/*!40000 ALTER TABLE `usuario_papel` DISABLE KEYS */;
INSERT INTO `usuario_papel` VALUES (1,1),(2,1),(3,1),(4,1),(2,2);
/*!40000 ALTER TABLE `usuario_papel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ativo` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1,'d4nilo','1234'),(2,1,'alex','1234');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10 12:07:26

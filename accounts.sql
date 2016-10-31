-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: accounts
-- ------------------------------------------------------
-- Server version	5.5.53-0ubuntu0.14.04.1

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
-- Table structure for table `follows`
--

DROP TABLE IF EXISTS `follows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follows` (
  `user_id` int(11) NOT NULL,
  `follower_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`follower_user_id`),
  KEY `follows_fk2` (`follower_user_id`),
  CONSTRAINT `follows_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `follows_fk2` FOREIGN KEY (`follower_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follows`
--

LOCK TABLES `follows` WRITE;
/*!40000 ALTER TABLE `follows` DISABLE KEYS */;
INSERT INTO `follows` VALUES (5,4),(6,4),(7,4),(8,4),(9,4),(10,4),(11,4),(7,5),(8,5),(9,5),(10,5),(4,6),(5,6),(4,7),(5,8),(6,8),(7,8),(10,8),(11,8),(4,11),(6,11),(10,11);
/*!40000 ALTER TABLE `follows` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tweets`
--

DROP TABLE IF EXISTS `tweets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tweets` (
  `tweet_id` int(11) NOT NULL AUTO_INCREMENT,
  `tweet` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`tweet_id`),
  KEY `tweets_fk1` (`user_id`),
  CONSTRAINT `tweets_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tweets`
--

LOCK TABLES `tweets` WRITE;
/*!40000 ALTER TABLE `tweets` DISABLE KEYS */;
INSERT INTO `tweets` VALUES (1,'aaaaa',4,'2016-10-26 20:50:32'),(2,'Hello, it\'s pretty late at night.',6,'2016-10-27 09:49:44'),(3,'This looks good.',6,'2016-10-27 10:01:15'),(4,'We need more test down here!',6,'2016-10-27 10:05:19'),(5,'Just woke up, start work on the challenge again!',6,'2016-10-27 14:24:44'),(6,'I am using 5.',5,'2016-10-27 15:36:03'),(7,'Hello.',5,'2016-10-27 15:36:08'),(8,'New updates again!',5,'2016-10-27 16:17:01'),(9,'This is a test message.',6,'2016-10-27 16:19:53'),(10,'Hello, I am a new user for this twit channel.',8,'2016-10-27 16:21:22'),(11,'Hi, this is Chaoran here for testing',4,'2016-10-27 16:32:21'),(12,'This is a second test message!',8,'2016-10-27 16:35:48'),(13,'Hello!',4,'2016-10-27 16:44:52'),(14,'I\'m writing this message on an iphone',5,'2016-10-27 19:12:02'),(15,'Please use a browser to test',4,'2016-10-27 19:15:42'),(16,'Turn on cookies in order for your phone to work',4,'2016-10-28 03:14:23'),(17,'halo',8,'2016-10-28 03:17:39'),(18,'aaaaa',8,'2016-10-28 15:03:56'),(19,'hi',8,'2016-10-28 15:16:34'),(20,'Added twitter responsive bootstrap support',5,'2016-10-28 15:31:39'),(21,'tweet',8,'2016-10-28 20:04:02'),(22,'abcdefg',11,'2016-10-29 03:17:14');
/*!40000 ALTER TABLE `tweets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'superchaoran@gmail.com','$2a$11$ZRALREiIn7fTg5YOcR2M5eYGXGUafDGEvh8g/tsnA2IrxwF7JN0hi'),(5,'user0@gmail.com','$2a$11$rcVfsyYUEiYN8SpLDuAv8.R19zsMrDbu16xfWk2U1ICUDcvA24HKC'),(6,'user1@gmail.com','$2a$11$T2cAgr7skE.MYQvwUIZ5uOZU4DceflaneCVuReVlpTm7.aqpKFNYa'),(7,'user2@gmail.com','$2a$11$zEeOq.xLG1PIrfTel6arvu1mhiP6SYpEgxIEP0qEUMvcaNT.5RLbO'),(8,'user3@gmail.com','$2a$11$fiqzirnH/3ms.A2fkyMyJ.8WLUC2ejIoHHNiqzQM7G2auxZ8DYaL2'),(9,'Hello@gmail.com','$2a$11$oC87fOWedfQbTCfC7fFBf.Guo2lJaeFcR4VN7IQY137auqPl6HG3y'),(10,'111@gmail.com','$2a$11$U.sPEU7ICowirtYVU8AH3OWzUJTeUuH5vg6VEXsgNAAyLGn7r3oOu'),(11,'lzhao31@illinois.edu','$2a$11$/QJYNHoZOHUP5WMpDdcqMe2znZv5TgTR2SZqeoWuK426iWQ2JV/rG');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1);
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

-- Dump completed on 2016-10-31 10:11:03

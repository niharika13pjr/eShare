-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: eShare
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `Registration`
--

DROP TABLE IF EXISTS `Registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Registration` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `regdate` datetime NOT NULL,
  `verifyUser` tinyint(1) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `sharedCount` int(11) DEFAULT NULL,
  `receivedCount` int(11) DEFAULT NULL,
  `verificationCode` varchar(45) NOT NULL,
  `userScore` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` date NOT NULL,
  `dppath` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Registration`
--

LOCK TABLES `Registration` WRITE;
/*!40000 ALTER TABLE `Registration` DISABLE KEYS */;
INSERT INTO `Registration` VALUES (2,'meeet','pari','123','nih','416991469','2016-04-26 00:00:00',1,'meetparikh94@gmail.com',NULL,NULL,'cglik3c367',NULL,'Male','1994-04-04',NULL);
/*!40000 ALTER TABLE `Registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `booktitle` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `publisher` varchar(45) NOT NULL,
  `additionVolume` varchar(45) NOT NULL,
  `booked` tinyint(2) NOT NULL,
  `rentedPrice` double NOT NULL,
  `purchasePrice` double NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `paymentType` varchar(45) NOT NULL,
  `ISBNnumber` varchar(45) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`bookID`),
  KEY `userID` (`userID`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2,'bui','ni','nhi','n',0,5,5,'hey','Cash','123',2),(3,'vdff','ut','uuib','bi',0,8,8,'bui','Cash','124',2),(4,'yu','gyub','ubg','bgu',0,1,1,'','Cash','123',2),(5,'uy','oin','hi','nhi',0,5,5,'heljdia','Cash','12',2),(6,'thisisBook','agatha','pearson','1',0,100,560,'ffd','Cash','123321',2),(7,'software engineering','meet','pearson','1',0,50,70,'hello','Cash','123',2);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookuser`
--

DROP TABLE IF EXISTS `bookuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookuser` (
  `userID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`bookID`),
  KEY `bookID` (`bookID`),
  CONSTRAINT `bookuser_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`),
  CONSTRAINT `bookuser_ibfk_2` FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookuser`
--

LOCK TABLES `bookuser` WRITE;
/*!40000 ALTER TABLE `bookuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cloth`
--

DROP TABLE IF EXISTS `cloth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cloth` (
  `clothID` int(11) NOT NULL AUTO_INCREMENT,
  `clothType` varchar(45) NOT NULL,
  `brandName` varchar(45) NOT NULL,
  `shoplocation` varchar(100) NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `currentclothCount` int(11) NOT NULL,
  `offerStartDate` datetime NOT NULL,
  `offerValidUpto` datetime NOT NULL,
  `quantityShare` int(11) NOT NULL,
  `link` varchar(45) NOT NULL,
  `userID` int(11) NOT NULL,
  `clothstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`clothID`),
  KEY `userID` (`userID`),
  CONSTRAINT `cloth_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`),
  CONSTRAINT `userID` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cloth`
--

LOCK TABLES `cloth` WRITE;
/*!40000 ALTER TABLE `cloth` DISABLE KEYS */;
INSERT INTO `cloth` VALUES (2,'pants','pepe','albany','new',3,'2016-04-22 14:07:11','2016-04-27 14:07:12',3,'fffj',2,1),(3,'qq','q','q','q',1,'2016-12-31 12:59:00','2017-12-31 00:59:00',1,'1',2,1);
/*!40000 ALTER TABLE `cloth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothconfirmation`
--

DROP TABLE IF EXISTS `clothconfirmation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clothconfirmation` (
  `clothID` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`clothID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothconfirmation`
--

LOCK TABLES `clothconfirmation` WRITE;
/*!40000 ALTER TABLE `clothconfirmation` DISABLE KEYS */;
/*!40000 ALTER TABLE `clothconfirmation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clothuser`
--

DROP TABLE IF EXISTS `clothuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clothuser` (
  `userID` int(11) NOT NULL,
  `clothID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`clothID`),
  KEY `clothID` (`clothID`),
  CONSTRAINT `clothuser_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`),
  CONSTRAINT `clothuser_ibfk_2` FOREIGN KEY (`clothID`) REFERENCES `cloth` (`clothID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clothuser`
--

LOCK TABLES `clothuser` WRITE;
/*!40000 ALTER TABLE `clothuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `clothuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `foodID` int(11) NOT NULL AUTO_INCREMENT,
  `foodType` varchar(45) NOT NULL,
  `foodPrice` double NOT NULL,
  `peopleNeeded` int(11) NOT NULL,
  `currentfoodCount` int(11) NOT NULL,
  `priceperPerson` double NOT NULL,
  `foodQuantity` varchar(45) NOT NULL,
  `venue` varchar(100) NOT NULL,
  `timeposted` datetime NOT NULL,
  `expirydate` datetime NOT NULL,
  `paymentType` varchar(10) NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `foodStatus` tinyint(2) NOT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`foodID`),
  KEY `userID` (`userID`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (3,'iin',8,6,2,1,'9','hnusi','2016-04-26 14:07:12','2016-05-14 08:04:00','Cash','hello\r\n',1,2),(4,'chinese',12,2,0,6,'1','albany','2016-04-26 15:13:24','2016-04-26 14:07:14','Cash','sfds',1,2),(5,'indian',123,23,0,5.3478260869565215,'30','ny','2016-04-26 15:18:38','2016-04-26 11:07:12','Cash','sds',1,2),(6,'chicken',10,1,1,5,'10','339 mannign','2016-04-26 15:33:38','2016-04-28 01:00:00','Cash','jf',1,2);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodconfirmation`
--

DROP TABLE IF EXISTS `foodconfirmation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foodconfirmation` (
  `foodID` int(11) NOT NULL,
  `userID` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`foodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodconfirmation`
--

LOCK TABLES `foodconfirmation` WRITE;
/*!40000 ALTER TABLE `foodconfirmation` DISABLE KEYS */;
/*!40000 ALTER TABLE `foodconfirmation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fooduser`
--

DROP TABLE IF EXISTS `fooduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fooduser` (
  `userID` int(11) NOT NULL,
  `foodID` int(11) NOT NULL,
  PRIMARY KEY (`userID`,`foodID`),
  KEY `foodID` (`foodID`),
  CONSTRAINT `fooduser_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Registration` (`userID`),
  CONSTRAINT `fooduser_ibfk_2` FOREIGN KEY (`foodID`) REFERENCES `food` (`foodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fooduser`
--

LOCK TABLES `fooduser` WRITE;
/*!40000 ALTER TABLE `fooduser` DISABLE KEYS */;
/*!40000 ALTER TABLE `fooduser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `nameoftopic` varchar(50) DEFAULT NULL,
  `datecreated` date DEFAULT NULL,
  `userinfo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES ('Clothes','2016-04-26',NULL),('food','2016-04-26',NULL),('123','2016-04-26','meeet');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topicfeed`
--

DROP TABLE IF EXISTS `topicfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topicfeed` (
  `time` datetime(6) DEFAULT NULL,
  `parentfeedid` int(11) NOT NULL AUTO_INCREMENT,
  `nameoftopic` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`parentfeedid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topicfeed`
--

LOCK TABLES `topicfeed` WRITE;
/*!40000 ALTER TABLE `topicfeed` DISABLE KEYS */;
INSERT INTO `topicfeed` VALUES ('2016-04-26 02:21:13.000000',23,'Clothes','I want to buy'),('2016-04-26 02:21:15.000000',24,'Clothes',''),('2016-04-26 02:21:18.000000',25,'Clothes','udgsbd'),('2016-04-26 03:46:00.000000',26,'food','food was good'),('2016-04-26 03:46:07.000000',27,'food','we had fun'),('2016-04-26 05:09:33.000000',28,'123','654'),('2016-04-26 05:09:37.000000',29,'123','7653');
/*!40000 ALTER TABLE `topicfeed` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-10 10:59:42

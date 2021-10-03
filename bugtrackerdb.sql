-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: bugtrackerdb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `bugs`
--

DROP TABLE IF EXISTS `bugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bugs` (
  `bug_id` varchar(100) NOT NULL,
  `bug_title` varchar(100) DEFAULT NULL,
  `bug_desc` varchar(500) DEFAULT NULL,
  `project_name` varchar(100) DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `open_date` date DEFAULT NULL,
  `assigned_to` varchar(100) DEFAULT NULL,
  `marked_for_closing` tinyint(1) DEFAULT NULL,
  `closed_by` varchar(100) DEFAULT NULL,
  `bug_status` varchar(100) DEFAULT NULL,
  `severity_level` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugs`
--

LOCK TABLES `bugs` WRITE;
/*!40000 ALTER TABLE `bugs` DISABLE KEYS */;
INSERT INTO `bugs` VALUES ('BUG1202','Registration failure','Users are not able to register themselves','Auth0 Integration','user6','2021-10-02','user13',1,'user5','Closed','major'),('BUG1555','Session Misinterpreted','Session getting mixed','Auth0 Integration','user6','2021-10-02','user4',1,'user5','Closed','critical'),('BUG1591','Registration failure','Registration failure','Covid Application','user12','2021-10-03','user31',1,'user8','Closed','major'),('BUG2022','Authentication Failure','User cant login','Auth0 Integration','user6','2021-10-02','user4',1,'user5','Closed','major'),('BUG3329','Server not responding','Server not responding','Covid Application','user12','2021-10-03',NULL,NULL,NULL,'Open','critical'),('BUG3841','Severity Checker','Filter according to severity having issues','Auth0 Integration','user6','2021-10-02','user4',1,'user5','Closed','trivial');
/*!40000 ALTER TABLE `bugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imported_users`
--

DROP TABLE IF EXISTS `imported_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imported_users` (
  `user_id` varchar(200) NOT NULL,
  `email_id` varchar(40) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imported_users`
--

LOCK TABLES `imported_users` WRITE;
/*!40000 ALTER TABLE `imported_users` DISABLE KEYS */;
INSERT INTO `imported_users` VALUES ('user1','user1@gmail.com','Developer','user1'),('user10','user10@gmail.com','Developer','user10'),('user11','user11@gmail.com','ProjectManager','user11'),('user12','user12@gmail.com','Tester','user12'),('user13','user13@gmail.com','Developer','user13'),('user14','user14@gmail.com','ProjectManager','user14'),('user15','user15@gmail.com','Tester','user15'),('user16','user16@gmail.com','Developer','user16'),('user17','user17@gmail.com','ProjectManager','user17'),('user18','user18@gmail.com','Tester','user18'),('user19','user19@gmail.com','Developer','user19'),('user2','user2@gmail.com','ProjectManager','user2'),('user20','user20@gmail.com','Tester','user20'),('user21','user21@gmail.com','Developer','user21'),('user22','user22@gmail.com','Developer','user22'),('user23','user23@gmail.com','Developer','user23'),('user24','user24@gmail.com','Developer','user24'),('user25','user25@gmail.com','Developer','user25'),('user26','user26@gmail.com','Tester','user26'),('user27','user27@gmail.com','Tester','user27'),('user28','user28@gmail.com','Tester','user28'),('user29','user29@gmail.com','Tester','user29'),('user3','user3@gmail.com','Tester','user3'),('user30','user30@gmail.com','Tester','user30'),('user31','user31@gmail.com','Developer','user31'),('user32','user32@gmail.com','Developer','user32'),('user33','user33@gmail.com','Developer','user33'),('user34','user34@gmail.com','Developer','user34'),('user35','user35@gmail.com','Tester','user35'),('user36','user36@gmail.com','Developer','user36'),('user37','user37@gmail.com','Developer','user37'),('user38','user38@gmail.com','Developer','user38'),('user39','user39@gmail.com','Developer','user39'),('user4','user4@gmail.com','Developer','user4'),('user40','user40@gmail.com','Developer','user40'),('user5','user5@gmail.com','ProjectManager','user5'),('user6','user6@gmail.com','Tester','user6'),('user7','user7@gmail.com','Developer','user7'),('user8','user8@gmail.com','ProjectManager','user8'),('user9','user9@gmail.com','Tester','user9');
/*!40000 ALTER TABLE `imported_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` varchar(30) NOT NULL,
  `project_name` varchar(200) DEFAULT NULL,
  `project_desc` varchar(800) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `project_state` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('PRJ4806','E-Asset Management','This is E-Asset Management','2021-10-05','InProgress'),('PRJ6556','Lems Project','Users single sign on','2021-10-04','InProgress'),('PRJ7687','Auth0 Integration','Users are not authorized to access database','2021-10-04','InProgress'),('PRJ8319','Covid Application','This application is to track vaccination status','2021-10-05','InProgress');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `user_id` varchar(100) NOT NULL,
  `project_id` varchar(100) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES ('user1','PRJ4806','Developer'),('user10','PRJ6556','Developer'),('user12','PRJ8319','Tester'),('user13','PRJ7687','Developer'),('user16','PRJ4806','Developer'),('user19','PRJ6556','Developer'),('user3','PRJ4806','Tester'),('user3','PRJ6556','Tester'),('user31','PRJ8319','Developer'),('user32','PRJ8319','Developer'),('user4','PRJ7687','Developer'),('user5','PRJ4806','ProjectManager'),('user5','PRJ6556','ProjectManager'),('user5','PRJ7687','ProjectManager'),('user6','PRJ7687','Tester'),('user7','PRJ7687','Developer'),('user8','PRJ8319','ProjectManager');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` varchar(100) NOT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `last_login` timestamp NULL DEFAULT NULL,
  `project_counter` int DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('user1','user1@gmail.com','Developer','user1','$2a$10$aZgejMcAXfJteMJZFQqlkebzBKr6bcBkZDOWT5b3kEyY/5sA3sqmm',NULL,1),('user10','user10@gmail.com','Developer','user10','$2a$10$uDNJ21Ic1FKYhMMGQI3nn.b6hQ.d5Oz0/Ylk7jg3M.bcczSTqjqf6',NULL,1),('user12','user12@gmail.com','Tester','user12','$2a$10$UKfNpldMG5h7RlDP85i.w.lZljqFnrX6pwFjJ.VuZeyJp2NlHFg3i','2021-10-03 12:44:43',1),('user13','user13@gmail.com','Developer','user13','$2a$10$dpa71.xiUVyMAsrYJPZORuWh/NyDPhqBa2QvJKY4PgnbBGD9N3Bsq','2021-10-03 04:57:22',1),('user14','user14@gmail.com','ProjectManager','user14','$2a$10$MeUu4F0rmsHDfWdH/0b5Vu93UA1M4iyrP8AR6BOvjRXEixb1wErca','2021-10-02 22:22:15',0),('user15','user15@gmail.com','Tester','user15','$2a$10$0lCV5RsBxKRBzkOyrC4pCOMJL3W0fQIAfmFdKutJBipA2balPQbWO',NULL,0),('user16','user16@gmail.com','Developer','user16','$2a$10$pwlB.5sk/pHh/GSCEhhBv.wotgokKk7QC3vMeTko2tVeXKQKIzggO',NULL,1),('user18','user18@gmail.com','Tester','user18','$2a$10$Zz/zcaqk7J5l/yflJr/WC.S4ETEB9/WEriyeZGXm1piqkBH5h2MPe','2021-10-01 18:55:24',0),('user19','user19@gmail.com','Developer','user19','$2a$10$q1.KKDMyK0d3QoGzIqzCA.ceqM7Qsxi0W6NKAVmr4jUuENFAhLKNa','2021-10-01 19:51:41',1),('user20','user20@gmail.com','Tester','user20','$2a$10$ON4eSG1UewzsBU8Y.5QeL.QR/Sr88moOzgkSTvCqTItMWepz033R.',NULL,0),('user26','user26@gmail.com','Tester','user26','$2a$10$JpEfNuZnYo5aAvcxXaaAFefDMnNe2etzbeiDUQkRT8Hm2o3VDUory',NULL,0),('user27','user27@gmail.com','Tester','user27','$2a$10$EhYeW9UCFrhCFzyliHzUyukSc6fGNwDSADOL7o8OIj8t0lkpATh96',NULL,0),('user3','user3@gmail.com','Tester','user3','$2a$10$XXaq4upaSOEvPwVxXMtJ.uSCGzMNR1hacMv0r.XspYmbt4AGnKaRK','2021-10-02 22:18:42',2),('user31','user31@gmail.com','Developer','user31','$2a$10$Srlff40qsUELl6OAkvi72uAI/cm80SMqcWeuxxKDykDZkz.W/H/X2','2021-10-03 12:51:18',1),('user32','user32@gmail.com','Developer','user32','$2a$10$PUQXsC2oOz1HjKVGi.hOiOzFVhWDc9WD8whKJVQXE9y5.93/s.rdm',NULL,1),('user33','user33@gmail.com','Developer','user33','$2a$10$cUlrngeC4c02q5lr6dKnROs.xkT9bG14E4iZqt4pWHeVbk18NY.O.',NULL,0),('user34','user34@gmail.com','Developer','user34','$2a$10$w51pq75LziidS6QnMAOlf.UN0rG6AMGvgJd1HP/ADolhkj8AEowja',NULL,0),('user35','user35@gmail.com','Tester','user35','$2a$10$u7D54NUy8RYTz/G/0wSYPubMSBii2lK68oG83E9Cf/cDv9YE1hUiS',NULL,0),('user36','user36@gmail.com','Developer','user36','$2a$10$zLGKYesYY5LGwM/.E9h8TeNYVFuh4cgO9gYwHYcXl3hMsmKKUINOm','2021-10-02 08:53:29',0),('user37','user37@gmail.com','Developer','user37','$2a$10$n6mdfk5sOdppTFX80iC3e.4BnpyJm8UM3t5SvH921JLuCLvLjJP..',NULL,0),('user38','user38@gmail.com','Developer','user38','$2a$10$oo6WtT5JMVlucJX1rOWi6Owy1OouhkoHFRxyL15I8j6kGMWlwQo7y',NULL,0),('user39','user39@gmail.com','Developer','user39','$2a$10$.VZGhNujnKQ7E/ub.tnsYuIEb6u6hnS7p6N82KoUvjIgyL21OHp2e',NULL,0),('user4','user4@gmail.com','Developer','user4','$2a$10$lNjjd9iJWE1vViw4zNB1ueRsoexn.LkC.1XUPBwL/pr4DekMXqZ7i','2021-10-03 17:26:37',1),('user5','user5@gmail.com','ProjectManager','user5','$2a$10$Zkr62JGH./yEGvRCjTAyF./7Sb7ZOIsWYFEdKM4D9BNJ.a241rBbG','2021-10-03 17:25:22',3),('user6','user6@gmail.com','Tester','user6','$2a$10$lDqoATSkZcY6zcWpk09meOzNF7vSx1inFTkqMQHyLetUCPts1U5p2','2021-10-03 17:26:07',1),('user7','user7@gmail.com','Developer','user7','$2a$10$1qT.KIp/zEcnyn6uMWTjpuast8IXuOIwx673U6FjcUMywQptAHhGy','2021-10-02 22:16:53',1),('user8','user8@gmail.com','ProjectManager','user8','$2a$10$LVyhbNDy66IuJxlbcIIuj.xCrgavolKAootNAQn69QCiv4s5QxoJa','2021-10-03 12:53:55',1),('user9','user9@gmail.com','Tester','user9','$2a$10$wnY2NUObSUoKNPF6ykpa8.bt8qnw21mFy5z3HOJso5hpVBXY3Odhe',NULL,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-03 23:16:21

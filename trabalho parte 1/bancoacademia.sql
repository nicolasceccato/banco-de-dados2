-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: testeban
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
-- Table structure for table `alunos`
--

DROP TABLE IF EXISTS `alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alunos` (
  `cpf` varchar(11) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `data_de_nascimento` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_da_casa` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `id_plano` bigint DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  KEY `FK1rscl3k7pihj0urlnr7w6xeff` (`id_plano`),
  CONSTRAINT `FK1rscl3k7pihj0urlnr7w6xeff` FOREIGN KEY (`id_plano`) REFERENCES `planos` (`id_plano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos`
--

LOCK TABLES `alunos` WRITE;
/*!40000 ALTER TABLE `alunos` DISABLE KEYS */;
INSERT INTO `alunos` VALUES ('10101010101',NULL,NULL,NULL,'ana@gmail.com','Ana Oliveira',NULL,NULL,'47996665555',3),('11111111111',NULL,NULL,NULL,'pedro@gmail.com','Pedro Mendes',NULL,NULL,'47995554444',4),('12312312312',NULL,NULL,NULL,'joaquim@gmail.com','Joaquim Brasil',NULL,NULL,'47999887766',1),('45645645645',NULL,NULL,NULL,'maria@gmail.com','Maria Silva',NULL,NULL,'47998887777',1),('78978978978',NULL,NULL,NULL,'carlos@gmail.com','Carlos Santos',NULL,NULL,'47997776666',2);
/*!40000 ALTER TABLE `alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alunos_treinos`
--

DROP TABLE IF EXISTS `alunos_treinos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alunos_treinos` (
  `cpf` varchar(11) NOT NULL,
  `id_treino` bigint NOT NULL,
  KEY `FKkam2brefamyep084dtcg331cb` (`id_treino`),
  KEY `FK7dpk9u5kwixv3invvpcey61dx` (`cpf`),
  CONSTRAINT `FK7dpk9u5kwixv3invvpcey61dx` FOREIGN KEY (`cpf`) REFERENCES `alunos` (`cpf`),
  CONSTRAINT `FKkam2brefamyep084dtcg331cb` FOREIGN KEY (`id_treino`) REFERENCES `treinos` (`id_treino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos_treinos`
--

LOCK TABLES `alunos_treinos` WRITE;
/*!40000 ALTER TABLE `alunos_treinos` DISABLE KEYS */;
INSERT INTO `alunos_treinos` VALUES ('12312312312',1),('12312312312',2),('45645645645',2),('45645645645',3),('78978978978',2),('78978978978',3),('10101010101',1),('10101010101',4),('11111111111',5);
/*!40000 ALTER TABLE `alunos_treinos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutores`
--

DROP TABLE IF EXISTS `instrutores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrutores` (
  `matricula` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `data_de_nascimento` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `especialidade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_da_casa` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutores`
--

LOCK TABLES `instrutores` WRITE;
/*!40000 ALTER TABLE `instrutores` DISABLE KEYS */;
INSERT INTO `instrutores` VALUES (1,NULL,'Personal Trainer',NULL,NULL,'joao@gmail.com','Musculação','João Silva',NULL,NULL,'47998887777'),(2,NULL,'Instrutor de Yoga',NULL,NULL,'maria@gmail.com','Yoga e Alongamento','Maria Santos',NULL,NULL,'47997776666'),(3,NULL,'Instrutor de Cardio',NULL,NULL,'carlos@gmail.com','Aeróbica e Corrida','Carlos Oliveira',NULL,NULL,'47996665555'),(4,NULL,'Instrutor de Pilates',NULL,NULL,'ana@gmail.com','Pilates e Flexibilidade','Ana Mendes',NULL,NULL,'47995554444'),(5,NULL,'Instrutor de Artes Marciais',NULL,NULL,'pedro@gmail.com','Boxe e Jiu-Jitsu','Pedro Pereira',NULL,NULL,'47994443333');
/*!40000 ALTER TABLE `instrutores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutores_treinos`
--

DROP TABLE IF EXISTS `instrutores_treinos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrutores_treinos` (
  `id_treino` bigint NOT NULL,
  `matricula` bigint NOT NULL,
  KEY `FK8vef3g7rubew7uwsrcd12qfi8` (`matricula`),
  KEY `FKl1nhiu5p2s1x7qqfyntxi3de0` (`id_treino`),
  CONSTRAINT `FK8vef3g7rubew7uwsrcd12qfi8` FOREIGN KEY (`matricula`) REFERENCES `instrutores` (`matricula`),
  CONSTRAINT `FKl1nhiu5p2s1x7qqfyntxi3de0` FOREIGN KEY (`id_treino`) REFERENCES `treinos` (`id_treino`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutores_treinos`
--

LOCK TABLES `instrutores_treinos` WRITE;
/*!40000 ALTER TABLE `instrutores_treinos` DISABLE KEYS */;
INSERT INTO `instrutores_treinos` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,1),(2,2),(2,3),(2,4),(2,5),(3,2),(4,3),(5,5);
/*!40000 ALTER TABLE `instrutores_treinos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamentos` (
  `id_pagamento` bigint NOT NULL AUTO_INCREMENT,
  `data_do_pagamento` datetime(6) DEFAULT NULL,
  `valor_do_pagamento` double DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `id_plano` bigint DEFAULT NULL,
  PRIMARY KEY (`id_pagamento`),
  KEY `FKscenggvlmeqvbbrlvyvbm8tt7` (`cpf`),
  KEY `FK60uvakb1mbw6h2c8cadq6waby` (`id_plano`),
  CONSTRAINT `FK60uvakb1mbw6h2c8cadq6waby` FOREIGN KEY (`id_plano`) REFERENCES `planos` (`id_plano`),
  CONSTRAINT `FKscenggvlmeqvbbrlvyvbm8tt7` FOREIGN KEY (`cpf`) REFERENCES `alunos` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentos`
--

LOCK TABLES `pagamentos` WRITE;
/*!40000 ALTER TABLE `pagamentos` DISABLE KEYS */;
INSERT INTO `pagamentos` VALUES (1,'2023-09-27 22:56:34.763000',50,'12312312312',1),(2,'2023-09-27 22:56:34.763000',60,'78978978978',2),(3,'2023-09-27 22:56:34.763000',70,'10101010101',3),(4,'2023-09-27 22:56:34.763000',80,'11111111111',4),(5,'2023-09-27 22:56:34.763000',55,'45645645645',1),(6,'2023-09-27 22:56:34.763000',65,'78978978978',2),(7,'2023-09-27 22:56:34.763000',75,'10101010101',3),(8,'2023-09-27 22:56:34.763000',85,'11111111111',4),(9,'2023-09-27 22:56:34.763000',52,'12312312312',1),(10,'2023-09-27 22:56:34.763000',62,'78978978978',2),(11,'2023-09-27 22:56:34.763000',72,'10101010101',3),(12,'2023-09-27 22:56:34.763000',82,'11111111111',4),(13,'2023-09-27 22:56:34.763000',58,'45645645645',1),(14,'2023-09-27 22:56:34.763000',68,'78978978978',2),(15,'2023-09-27 22:56:34.763000',78,'10101010101',3),(16,'2023-09-27 22:56:34.763000',88,'11111111111',4);
/*!40000 ALTER TABLE `pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planos`
--

DROP TABLE IF EXISTS `planos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planos` (
  `id_plano` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome_do_plano` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_plano`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planos`
--

LOCK TABLES `planos` WRITE;
/*!40000 ALTER TABLE `planos` DISABLE KEYS */;
INSERT INTO `planos` VALUES (1,'Este é o Plano Silver com recursos básicos.','Plano Silver'),(2,'O Plano Gold oferece recursos avançados para assinantes.','Plano Gold'),(3,'Assine o Plano Premium para obter acesso total a todos os recursos.','Plano Premium'),(4,'O Plano Familiar permite que até 5 membros da família compartilhem uma assinatura.','Plano Familiar'),(5,'Os estudantes podem aproveitar o Plano Estudante com desconto especial.','Plano Estudante');
/*!40000 ALTER TABLE `planos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treinos`
--

DROP TABLE IF EXISTS `treinos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinos` (
  `id_treino` bigint NOT NULL AUTO_INCREMENT,
  `data_do_treino` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `duracao_emminutos` int NOT NULL,
  `nome_do_treino` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_treino`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinos`
--

LOCK TABLES `treinos` WRITE;
/*!40000 ALTER TABLE `treinos` DISABLE KEYS */;
INSERT INTO `treinos` VALUES (1,'2023-09-27 22:56:34.763000','Treino focado em fortalecimento muscular',60,'Treino de Musculação'),(2,'2023-09-27 22:56:34.763000','Treino de alta intensidade para queimar calorias',45,'Treino de Cardio'),(3,'2023-09-27 22:56:34.763000','Treino de relaxamento e flexibilidade',90,'Treino de Yoga'),(4,'2023-09-27 22:56:34.763000','Treino funcional para ganho de resistência e força',75,'Treino de CrossFit'),(5,'2023-09-27 22:56:34.763000','Treino focado em flexibilidade e equilíbrio',60,'Treino de Pilates');
/*!40000 ALTER TABLE `treinos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'testeban'
--

--
-- Dumping routines for database 'testeban'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-27 20:07:49

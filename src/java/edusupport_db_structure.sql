-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: edusupport_db
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `absence` (
  `idabsence` int(11) NOT NULL AUTO_INCREMENT,
  `jour_absence` datetime NOT NULL,
  `justifiee` tinyint(4) NOT NULL,
  `motif` text,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idabsence`),
  KEY `fk_absence_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_absence_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence`
--

LOCK TABLES `absence` WRITE;
/*!40000 ALTER TABLE `absence` DISABLE KEYS */;
/*!40000 ALTER TABLE `absence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activite`
--

DROP TABLE IF EXISTS `activite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activite` (
  `idactivite` int(11) NOT NULL AUTO_INCREMENT,
  `action` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `utilisateur_idutilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idactivite`),
  KEY `fk_activite_utilisateur1_idx` (`utilisateur_idutilisateur`),
  CONSTRAINT `fk_activite_utilisateur1` FOREIGN KEY (`utilisateur_idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activite`
--

LOCK TABLES `activite` WRITE;
/*!40000 ALTER TABLE `activite` DISABLE KEYS */;
/*!40000 ALTER TABLE `activite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annee_scolaire`
--

DROP TABLE IF EXISTS `annee_scolaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annee_scolaire` (
  `idannee_scolaire` int(11) NOT NULL AUTO_INCREMENT,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`idannee_scolaire`),
  UNIQUE KEY `UQ_DATE_DEBUT_DATE_FIN` (`date_debut`,`date_fin`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annee_scolaire`
--

LOCK TABLES `annee_scolaire` WRITE;
/*!40000 ALTER TABLE `annee_scolaire` DISABLE KEYS */;
INSERT INTO `annee_scolaire` VALUES (1,'2018-09-03 00:00:00','2019-06-21 00:00:00','2018-09-26 01:56:14','2018-09-26 01:56:14',0);
/*!40000 ALTER TABLE `annee_scolaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorisation_sortie`
--

DROP TABLE IF EXISTS `autorisation_sortie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autorisation_sortie` (
  `idautorisation_sortie` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `date_jour` datetime DEFAULT NULL,
  `date_retour` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  `maladie_idmaladie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idautorisation_sortie`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_autorisation_sortie_eleve1_idx` (`eleve_ideleve`),
  KEY `fk_aurotisation_sortie_maladie_idx` (`maladie_idmaladie`),
  CONSTRAINT `fk_aurotisation_sortie_maladie` FOREIGN KEY (`maladie_idmaladie`) REFERENCES `maladie` (`idmaladie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_autorisation_sortie_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorisation_sortie`
--

LOCK TABLES `autorisation_sortie` WRITE;
/*!40000 ALTER TABLE `autorisation_sortie` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorisation_sortie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe` (
  `idclasse` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `frais_scolarite` double NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `serie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idclasse`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_serie_idx` (`serie`),
  CONSTRAINT `fk_serie` FOREIGN KEY (`serie`) REFERENCES `serie` (`idserie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (1,'6E','Sixième',90000,'0000-00-00 00:00:00','0000-00-00 00:00:00',0,NULL),(2,'5E','Cinquième',90000,'2018-09-26 02:25:06','2018-09-26 02:25:06',0,NULL),(3,'4E','Quatrieme',100000,'2018-09-26 03:40:27','2018-09-26 03:40:27',0,NULL),(5,'3E','Troisieme',100000,'2018-09-26 08:25:40','2018-09-26 08:25:40',0,NULL),(6,'2ND','Seconde',110000,'2018-09-26 10:56:05','2018-09-26 10:56:05',0,NULL);
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe_matiere`
--

DROP TABLE IF EXISTS `classe_matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe_matiere` (
  `idclasse_matiere` int(11) NOT NULL AUTO_INCREMENT,
  `salle_de_classe_idsalle_de_classe` int(11) NOT NULL,
  `matiere_idmatiere` int(11) NOT NULL,
  `coefficient` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idclasse_matiere`),
  KEY `fk_table1_classe1_idx` (`salle_de_classe_idsalle_de_classe`),
  KEY `fk_table1_matiere1_idx` (`matiere_idmatiere`),
  CONSTRAINT `fk_table1_classe1` FOREIGN KEY (`salle_de_classe_idsalle_de_classe`) REFERENCES `salle_de_classe` (`idsalle_de_classe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_matiere1` FOREIGN KEY (`matiere_idmatiere`) REFERENCES `matiere` (`idmatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_matiere`
--

LOCK TABLES `classe_matiere` WRITE;
/*!40000 ALTER TABLE `classe_matiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `classe_matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compte_parent`
--

DROP TABLE IF EXISTS `compte_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compte_parent` (
  `idcompte_parent` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(254) DEFAULT NULL,
  `mot_de_passe` text,
  `etablissement` int(11) DEFAULT NULL,
  `actif` tinyint(1) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`idcompte_parent`),
  KEY `fk_etablissement_idx` (`etablissement`),
  CONSTRAINT `fk_etablissement` FOREIGN KEY (`etablissement`) REFERENCES `etablissement` (`idetablissement`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte_parent`
--

LOCK TABLES `compte_parent` WRITE;
/*!40000 ALTER TABLE `compte_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `compte_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compte_parent_eleve`
--

DROP TABLE IF EXISTS `compte_parent_eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compte_parent_eleve` (
  `idcompte_parent_eleve` int(11) NOT NULL AUTO_INCREMENT,
  `compte_parent` int(11) DEFAULT NULL,
  `eleve` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcompte_parent_eleve`),
  KEY `fk_compte_parent_idx` (`compte_parent`),
  KEY `fk_eleve_idx` (`eleve`),
  CONSTRAINT `fk_compte_parent` FOREIGN KEY (`compte_parent`) REFERENCES `compte_parent` (`idcompte_parent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eleve` FOREIGN KEY (`eleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte_parent_eleve`
--

LOCK TABLES `compte_parent_eleve` WRITE;
/*!40000 ALTER TABLE `compte_parent_eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `compte_parent_eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conseil_discipline`
--

DROP TABLE IF EXISTS `conseil_discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conseil_discipline` (
  `idconseil_discipline` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `rapport` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idconseil_discipline`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conseil_discipline`
--

LOCK TABLES `conseil_discipline` WRITE;
/*!40000 ALTER TABLE `conseil_discipline` DISABLE KEYS */;
INSERT INTO `conseil_discipline` VALUES (1,'CD000ET2018','Conseil special','2018-09-18 00:00:00','2018-09-18 00:00:00','2018-09-18 15:08:33','2018-09-18 15:42:01',0,NULL),(2,'CD001ET2018','Conseil de discipline','2018-09-23 00:00:00','2018-09-23 00:00:00','2018-09-23 11:43:29','2018-09-23 11:43:29',0,NULL);
/*!40000 ALTER TABLE `conseil_discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convocation`
--

DROP TABLE IF EXISTS `convocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convocation` (
  `idconvocation` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `motif` text NOT NULL,
  `date_jour` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idconvocation`),
  KEY `fk_convocation_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_convocation_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convocation`
--

LOCK TABLES `convocation` WRITE;
/*!40000 ALTER TABLE `convocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `convocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `droit_acces`
--

DROP TABLE IF EXISTS `droit_acces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `droit_acces` (
  `iddroit_acces` int(11) NOT NULL AUTO_INCREMENT,
  `niveau` int(11) NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`iddroit_acces`),
  UNIQUE KEY `niveau_UNIQUE` (`niveau`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `droit_acces`
--

LOCK TABLES `droit_acces` WRITE;
/*!40000 ALTER TABLE `droit_acces` DISABLE KEYS */;
INSERT INTO `droit_acces` VALUES (1,1,'Lecture simple','2028-07-16 16:00:00','2028-07-16 16:00:00',0),(2,2,'Lecture et Ecriture simple','2028-07-16 16:00:00','2028-07-16 16:00:00',0),(3,3,'TOUT','2028-07-16 16:00:00','2028-07-16 16:00:00',0);
/*!40000 ALTER TABLE `droit_acces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eleve` (
  `ideleve` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `individu_idindividu` int(11) NOT NULL,
  `salle_de_classe_idsalle_de_classe` int(11) NOT NULL,
  PRIMARY KEY (`ideleve`),
  KEY `fk_eleve_individu1_idx` (`individu_idindividu`),
  KEY `fk_eleve_salle_de_classe_idx` (`salle_de_classe_idsalle_de_classe`),
  CONSTRAINT `fk_eleve_salle_de_classe` FOREIGN KEY (`salle_de_classe_idsalle_de_classe`) REFERENCES `salle_de_classe` (`idsalle_de_classe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eleve_individu1` FOREIGN KEY (`individu_idindividu`) REFERENCES `individu` (`idindividu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleve`
--

LOCK TABLES `eleve` WRITE;
/*!40000 ALTER TABLE `eleve` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleve_maladie`
--

DROP TABLE IF EXISTS `eleve_maladie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eleve_maladie` (
  `ideleve_maladie` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  `maladie_idmaladie` int(11) NOT NULL,
  PRIMARY KEY (`ideleve_maladie`),
  KEY `fk_eleve_maladie_eleve1_idx` (`eleve_ideleve`),
  KEY `fk_eleve_maladie_maladie1_idx` (`maladie_idmaladie`),
  CONSTRAINT `fk_eleve_maladie_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eleve_maladie_maladie1` FOREIGN KEY (`maladie_idmaladie`) REFERENCES `maladie` (`idmaladie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleve_maladie`
--

LOCK TABLES `eleve_maladie` WRITE;
/*!40000 ALTER TABLE `eleve_maladie` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleve_maladie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleve_traduit`
--

DROP TABLE IF EXISTS `eleve_traduit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eleve_traduit` (
  `ideleves_traduits` int(11) NOT NULL AUTO_INCREMENT,
  `motif` text NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  `conseil_discipline_idconseil_discipline` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`ideleves_traduits`),
  KEY `fk_eleves_traduits_eleve1_idx` (`eleve_ideleve`),
  KEY `fk_eleves_traduits_conseil_discipline1_idx` (`conseil_discipline_idconseil_discipline`),
  CONSTRAINT `fk_eleves_traduits_conseil_discipline1` FOREIGN KEY (`conseil_discipline_idconseil_discipline`) REFERENCES `conseil_discipline` (`idconseil_discipline`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eleves_traduits_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleve_traduit`
--

LOCK TABLES `eleve_traduit` WRITE;
/*!40000 ALTER TABLE `eleve_traduit` DISABLE KEYS */;
/*!40000 ALTER TABLE `eleve_traduit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employe` (
  `idemploye` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `individu_idindividu` int(11) NOT NULL,
  PRIMARY KEY (`idemploye`),
  KEY `fk_employe_individu1_idx` (`individu_idindividu`),
  CONSTRAINT `fk_employe_individu1` FOREIGN KEY (`individu_idindividu`) REFERENCES `individu` (`idindividu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employe`
--

LOCK TABLES `employe` WRITE;
/*!40000 ALTER TABLE `employe` DISABLE KEYS */;
INSERT INTO `employe` VALUES (1,'2018-09-26 02:39:33','2018-09-26 02:39:33',0,5);
/*!40000 ALTER TABLE `employe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enseignant` (
  `idenseignant` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `individu_idindividu` int(11) NOT NULL,
  PRIMARY KEY (`idenseignant`),
  KEY `fk_enseignant_individu1_idx` (`individu_idindividu`),
  CONSTRAINT `fk_enseignant_individu1` FOREIGN KEY (`individu_idindividu`) REFERENCES `individu` (`idindividu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enseignant`
--

LOCK TABLES `enseignant` WRITE;
/*!40000 ALTER TABLE `enseignant` DISABLE KEYS */;
INSERT INTO `enseignant` VALUES (1,'2018-09-26 02:39:57','2018-09-26 02:39:57',0,4);
/*!40000 ALTER TABLE `enseignant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enseignant_classe_matiere`
--

DROP TABLE IF EXISTS `enseignant_classe_matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enseignant_classe_matiere` (
  `idenseignant_classe_matiere` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `enseignant_idenseignant` int(11) NOT NULL,
  `classe_matiere_idclasse_matiere` int(11) NOT NULL,
  PRIMARY KEY (`idenseignant_classe_matiere`),
  KEY `fk_enseignants_classes_matieres_enseignant1_idx` (`enseignant_idenseignant`),
  KEY `fk_enseignants_classes_matieres_classes_matieres1_idx` (`classe_matiere_idclasse_matiere`),
  CONSTRAINT `fk_enseignants_classes_matieres_classes_matieres1` FOREIGN KEY (`classe_matiere_idclasse_matiere`) REFERENCES `classe_matiere` (`idclasse_matiere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_enseignants_classes_matieres_enseignant1` FOREIGN KEY (`enseignant_idenseignant`) REFERENCES `enseignant` (`idenseignant`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enseignant_classe_matiere`
--

LOCK TABLES `enseignant_classe_matiere` WRITE;
/*!40000 ALTER TABLE `enseignant_classe_matiere` DISABLE KEYS */;
/*!40000 ALTER TABLE `enseignant_classe_matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etablissement`
--

DROP TABLE IF EXISTS `etablissement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etablissement` (
  `idetablissement` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `nom_etablissement` varchar(254) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`idetablissement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etablissement`
--

LOCK TABLES `etablissement` WRITE;
/*!40000 ALTER TABLE `etablissement` DISABLE KEYS */;
/*!40000 ALTER TABLE `etablissement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluation` (
  `idevaluation` int(11) NOT NULL AUTO_INCREMENT,
  `sequence_idsequence` int(11) NOT NULL,
  `classe_matiere_idclasse_matiere` int(11) NOT NULL,
  `date_jour` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`idevaluation`),
  KEY `fk_evaluation_sequence1_idx` (`sequence_idsequence`),
  KEY `fk_evaluation_classes_matieres1_idx` (`classe_matiere_idclasse_matiere`),
  CONSTRAINT `fk_evaluation_classes_matieres1` FOREIGN KEY (`classe_matiere_idclasse_matiere`) REFERENCES `classe_matiere` (`idclasse_matiere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluation_sequence1` FOREIGN KEY (`sequence_idsequence`) REFERENCES `sequence` (`idsequence`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation`
--

LOCK TABLES `evaluation` WRITE;
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fonctionnalite`
--

DROP TABLE IF EXISTS `fonctionnalite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fonctionnalite` (
  `idfonctionnalite` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(254) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idfonctionnalite`),
  UNIQUE KEY `niveau_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fonctionnalite`
--

LOCK TABLES `fonctionnalite` WRITE;
/*!40000 ALTER TABLE `fonctionnalite` DISABLE KEYS */;
/*!40000 ALTER TABLE `fonctionnalite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `individu`
--

DROP TABLE IF EXISTS `individu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `individu` (
  `idindividu` int(11) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(254) NOT NULL,
  `noms` varchar(45) NOT NULL,
  `prenoms` varchar(45) DEFAULT NULL,
  `date_naissance` datetime NOT NULL,
  `lieu_naissance` text NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `sexe` varchar(1) NOT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `residence` text NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idindividu`),
  UNIQUE KEY `matricule_UNIQUE` (`matricule`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telephone_UNIQUE` (`telephone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `individu`
--

LOCK TABLES `individu` WRITE;
/*!40000 ALTER TABLE `individu` DISABLE KEYS */;
INSERT INTO `individu` VALUES (1,'MLEEL2028','SALAO','HASSAN','1988-12-12 00:00:00','Yaounde','hsalao@gmail.com','M','677878667','YAOUNDE ','0000-00-00 00:00:00','0000-00-00 00:00:00',0),(2,'MLE675E2018','PONDI','Florent Olivier','1990-11-21 00:00:00','Londres',NULL,'M','677889888','Yaounde','2018-09-26 02:31:31','2018-09-26 02:31:31',0),(4,'MLE695E2018','MUANZA','Kangudie','1988-08-13 00:00:00','Kinshasa',NULL,'M','677898878','Yaounde','2018-09-26 02:34:50','2018-09-26 02:34:50',0),(5,'MLE705E2018','CARR','Dima','2009-03-06 00:00:00','Chicago',NULL,'F','677888990','Washington','2018-09-26 02:38:56','2018-09-26 02:38:56',0);
/*!40000 ALTER TABLE `individu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `individu_utilisateur`
--

DROP TABLE IF EXISTS `individu_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `individu_utilisateur` (
  `idindividu_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `utilisateur_idutilisateur` int(11) NOT NULL,
  `individu_idindividu` int(11) NOT NULL,
  PRIMARY KEY (`idindividu_utilisateur`),
  KEY `fk_individu_utilisateur_utilisateur1_idx` (`utilisateur_idutilisateur`),
  KEY `fk_individu_utilisateur_individu1_idx` (`individu_idindividu`),
  CONSTRAINT `fk_individu_utilisateur_individu1` FOREIGN KEY (`individu_idindividu`) REFERENCES `individu` (`idindividu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_individu_utilisateur_utilisateur1` FOREIGN KEY (`utilisateur_idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `individu_utilisateur`
--

LOCK TABLES `individu_utilisateur` WRITE;
/*!40000 ALTER TABLE `individu_utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `individu_utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maladie`
--

DROP TABLE IF EXISTS `maladie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maladie` (
  `idmaladie` int(11) NOT NULL AUTO_INCREMENT,
  `nom` text NOT NULL,
  `description` text NOT NULL,
  `type_maladie` text NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idmaladie`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maladie`
--

LOCK TABLES `maladie` WRITE;
/*!40000 ALTER TABLE `maladie` DISABLE KEYS */;
INSERT INTO `maladie` VALUES (1,'Paludisme','le palu','Bacterienne','2018-09-23 16:15:52','2018-09-23 16:15:52',0);
/*!40000 ALTER TABLE `maladie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matiere` (
  `idmatiere` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idmatiere`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matiere`
--

LOCK TABLES `matiere` WRITE;
/*!40000 ALTER TABLE `matiere` DISABLE KEYS */;
INSERT INTO `matiere` VALUES (1,'MATH6E','Mathematiques','2018-09-26 02:27:40','2018-09-26 02:27:40',0),(2,'ANG6E','Anglais','2018-09-26 02:28:57','2018-09-26 02:28:57',0);
/*!40000 ALTER TABLE `matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moratoire`
--

DROP TABLE IF EXISTS `moratoire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moratoire` (
  `idmoratoire` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `date_fin_validite` datetime DEFAULT NULL,
  `reponse` text,
  `etat` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idmoratoire`),
  KEY `fk_moratoire_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_moratoire_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moratoire`
--

LOCK TABLES `moratoire` WRITE;
/*!40000 ALTER TABLE `moratoire` DISABLE KEYS */;
/*!40000 ALTER TABLE `moratoire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `note` (
  `idnote` int(11) NOT NULL AUTO_INCREMENT,
  `valeur` double NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  `evaluation_idevaluation` int(11) NOT NULL,
  PRIMARY KEY (`idnote`),
  KEY `fk_note_eleve1_idx` (`eleve_ideleve`),
  KEY `fk_note_evaluation1_idx` (`evaluation_idevaluation`),
  CONSTRAINT `fk_note_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_note_evaluation1` FOREIGN KEY (`evaluation_idevaluation`) REFERENCES `evaluation` (`idevaluation`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paiement`
--

DROP TABLE IF EXISTS `paiement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paiement` (
  `idpaiement` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `montant` double NOT NULL,
  `date_jour` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idpaiement`),
  KEY `fk_paiement_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_paiement_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paiement`
--

LOCK TABLES `paiement` WRITE;
/*!40000 ALTER TABLE `paiement` DISABLE KEYS */;
/*!40000 ALTER TABLE `paiement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passage_infirmerie`
--

DROP TABLE IF EXISTS `passage_infirmerie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passage_infirmerie` (
  `idpassage_infirmerie` int(11) NOT NULL,
  `code` varchar(45) NOT NULL,
  `date_jour` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  `maladie_idmaladie` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpassage_infirmerie`),
  KEY `fk_passage_infirmerie_eleve1_idx` (`eleve_ideleve`),
  KEY `fk_passage_infirmerie_maladie_idx` (`maladie_idmaladie`),
  CONSTRAINT `fk_passage_infirmerie_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_passage_infirmerie_maladie` FOREIGN KEY (`maladie_idmaladie`) REFERENCES `maladie` (`idmaladie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passage_infirmerie`
--

LOCK TABLES `passage_infirmerie` WRITE;
/*!40000 ALTER TABLE `passage_infirmerie` DISABLE KEYS */;
/*!40000 ALTER TABLE `passage_infirmerie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rapport`
--

DROP TABLE IF EXISTS `rapport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rapport` (
  `idrapport` int(11) NOT NULL,
  `code` varchar(45) NOT NULL,
  `nom_fichier` varchar(45) NOT NULL,
  `url` text,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `reunion_idreunion` int(11) NOT NULL,
  PRIMARY KEY (`idrapport`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rapport`
--

LOCK TABLES `rapport` WRITE;
/*!40000 ALTER TABLE `rapport` DISABLE KEYS */;
/*!40000 ALTER TABLE `rapport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relance`
--

DROP TABLE IF EXISTS `relance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relance` (
  `idrelance` int(11) NOT NULL,
  `motif` text NOT NULL,
  `montant` double NOT NULL,
  `echeance` datetime NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idrelance`),
  KEY `fk_relance_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_relance_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relance`
--

LOCK TABLES `relance` WRITE;
/*!40000 ALTER TABLE `relance` DISABLE KEYS */;
/*!40000 ALTER TABLE `relance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retard`
--

DROP TABLE IF EXISTS `retard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retard` (
  `idretard` int(11) NOT NULL AUTO_INCREMENT,
  `marge` int(11) NOT NULL,
  `jour_retard` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idretard`),
  KEY `fk_retard_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_retard_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retard`
--

LOCK TABLES `retard` WRITE;
/*!40000 ALTER TABLE `retard` DISABLE KEYS */;
/*!40000 ALTER TABLE `retard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reunion`
--

DROP TABLE IF EXISTS `reunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reunion` (
  `idreunion` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  `etat` int(11) NOT NULL,
  `date_jour` datetime NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idreunion`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reunion`
--

LOCK TABLES `reunion` WRITE;
/*!40000 ALTER TABLE `reunion` DISABLE KEYS */;
INSERT INTO `reunion` VALUES (1,'RP00T2018','Reunion du cinq octobre',1,'2018-09-24 00:00:00','2018-09-24 17:36:12','2018-09-24 17:36:12',0);
/*!40000 ALTER TABLE `reunion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salle_de_classe`
--

DROP TABLE IF EXISTS `salle_de_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salle_de_classe` (
  `idsalle_de_classe` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `classe_idclasse` int(11) NOT NULL,
  PRIMARY KEY (`idsalle_de_classe`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_classe_idx` (`classe_idclasse`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle_de_classe`
--

LOCK TABLES `salle_de_classe` WRITE;
/*!40000 ALTER TABLE `salle_de_classe` DISABLE KEYS */;
INSERT INTO `salle_de_classe` VALUES (2,'6EM1','Sixième M1','0000-00-00 00:00:00','0000-00-00 00:00:00',0,0);
/*!40000 ALTER TABLE `salle_de_classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanction`
--

DROP TABLE IF EXISTS `sanction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanction` (
  `idsanction` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `date_jour` datetime DEFAULT NULL,
  `motif` text NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `eleve_ideleve` int(11) NOT NULL,
  PRIMARY KEY (`idsanction`),
  KEY `fk_sanction_eleve1_idx` (`eleve_ideleve`),
  CONSTRAINT `fk_sanction_eleve1` FOREIGN KEY (`eleve_ideleve`) REFERENCES `eleve` (`ideleve`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanction`
--

LOCK TABLES `sanction` WRITE;
/*!40000 ALTER TABLE `sanction` DISABLE KEYS */;
/*!40000 ALTER TABLE `sanction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `idsequence` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `numero` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  `trimestre_idtrimestre` int(11) NOT NULL,
  `annee_scolaire_idannee_scolaire` int(11) NOT NULL,
  PRIMARY KEY (`idsequence`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_anneescolaire_idx` (`annee_scolaire_idannee_scolaire`),
  KEY `fk_trimestre_idx` (`trimestre_idtrimestre`),
  CONSTRAINT `fk_trimestre` FOREIGN KEY (`trimestre_idtrimestre`) REFERENCES `trimestre` (`idtrimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_anneescolaire` FOREIGN KEY (`annee_scolaire_idannee_scolaire`) REFERENCES `annee_scolaire` (`idannee_scolaire`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES (1,'SEQ1',1,'2018-09-26 02:23:42','2018-09-26 02:23:42',0,1,1),(2,'SEQ2',2,'2018-09-26 02:28:27','2018-09-26 02:28:27',0,1,1);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serie` (
  `idserie` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idserie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tranche`
--

DROP TABLE IF EXISTS `tranche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tranche` (
  `idtranche` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `libelle` varchar(100) DEFAULT NULL,
  `montant` double NOT NULL,
  `date_limite` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`idtranche`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tranche`
--

LOCK TABLES `tranche` WRITE;
/*!40000 ALTER TABLE `tranche` DISABLE KEYS */;
/*!40000 ALTER TABLE `tranche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tranche_classe`
--

DROP TABLE IF EXISTS `tranche_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tranche_classe` (
  `idtranche_classe` int(11) NOT NULL AUTO_INCREMENT,
  `classe` int(11) NOT NULL,
  `tranche` int(11) NOT NULL,
  PRIMARY KEY (`idtranche_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tranche_classe`
--

LOCK TABLES `tranche_classe` WRITE;
/*!40000 ALTER TABLE `tranche_classe` DISABLE KEYS */;
/*!40000 ALTER TABLE `tranche_classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trimestre` (
  `idtrimestre` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) DEFAULT NULL,
  `libelle` varchar(45) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`idtrimestre`),
  UNIQUE KEY `numero_UNIQUE` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trimestre`
--

LOCK TABLES `trimestre` WRITE;
/*!40000 ALTER TABLE `trimestre` DISABLE KEYS */;
INSERT INTO `trimestre` VALUES (1,'PT1','Premier Trimestre',1,'2018-09-26 02:11:14','2018-09-26 02:11:14',0);
/*!40000 ALTER TABLE `trimestre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `idutilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(254) NOT NULL,
  `mot_de_passe` text NOT NULL,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  PRIMARY KEY (`idutilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'admingimac','admingimac','2018-08-24 11:51:13','2018-08-24 11:51:13',0);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur_fonctionnalite`
--

DROP TABLE IF EXISTS `utilisateur_fonctionnalite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur_fonctionnalite` (
  `idutilisateur_fonctionnalite` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL,
  `utilisateur_idutilisateur` int(11) NOT NULL,
  `fonctionnalite_idfonctionnalite` int(11) NOT NULL,
  PRIMARY KEY (`idutilisateur_fonctionnalite`),
  KEY `fk_utilisateurs_fonctionnalites_utilisateur1_idx` (`utilisateur_idutilisateur`),
  KEY `fk_utilisateurs_fonctionnalites_fonctionnalite1_idx` (`fonctionnalite_idfonctionnalite`),
  CONSTRAINT `fk_utilisateurs_fonctionnalites_fonctionnalite1` FOREIGN KEY (`fonctionnalite_idfonctionnalite`) REFERENCES `fonctionnalite` (`idfonctionnalite`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_utilisateurs_fonctionnalites_utilisateur1` FOREIGN KEY (`utilisateur_idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur_fonctionnalite`
--

LOCK TABLES `utilisateur_fonctionnalite` WRITE;
/*!40000 ALTER TABLE `utilisateur_fonctionnalite` DISABLE KEYS */;
/*!40000 ALTER TABLE `utilisateur_fonctionnalite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-27 13:36:23

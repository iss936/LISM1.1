-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 27 Avril 2014 à 17:03
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `lism`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE IF NOT EXISTS `cours` (
  `id_cours` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelle_cours` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`id_cours`, `libelle_cours`) VALUES
(1, 'Anglais'),
(2, 'Communication'),
(3, 'Framework'),
(4, 'Informatique'),
(5, 'Maths');

-- --------------------------------------------------------

--
-- Structure de la table `cours_session`
--

CREATE TABLE IF NOT EXISTS `cours_session` (
  `id_cours_session` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_debut` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `date_fin` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `description` varchar(2000) NOT NULL DEFAULT '',
  `id_cours` int(10) unsigned NOT NULL DEFAULT '0',
  `type_cours_session` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cours_session`),
  KEY `FK_cours_session_1` (`id_cours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `cours_session`
--

INSERT INTO `cours_session` (`id_cours_session`, `date_debut`, `date_fin`, `description`, `id_cours`, `type_cours_session`) VALUES
(1, '0000-09-01 00:00:00', '0000-09-02 00:00:00', 'Cours de programmation Java', 4, 'Présentiel');

-- --------------------------------------------------------

--
-- Structure de la table `cours_session_item`
--

CREATE TABLE IF NOT EXISTS `cours_session_item` (
  `id_cours_session_item` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_enseignant` int(10) unsigned NOT NULL DEFAULT '0',
  `id_salle` int(10) unsigned NOT NULL DEFAULT '0',
  `id_cours_session` int(10) unsigned NOT NULL DEFAULT '0',
  `description_detail` varchar(2000) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cours_session_item`),
  KEY `FK_cours_session_item_1` (`id_enseignant`),
  KEY `FK_cours_session_item_2` (`id_salle`),
  KEY `FK_cours_session_item_3` (`id_cours_session`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `cours_session_item`
--

INSERT INTO `cours_session_item` (`id_cours_session_item`, `id_enseignant`, `id_salle`, `id_cours_session`, `description_detail`) VALUES
(1, 1, 2, 1, 'Cours sur framework java : hibernate');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE IF NOT EXISTS `enseignant` (
  `id_enseignant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prenom_enseignant` varchar(45) NOT NULL DEFAULT '',
  `nom_enseignant` varchar(45) NOT NULL DEFAULT '',
  `login` varchar(45) NOT NULL DEFAULT '',
  `mdp` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_enseignant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `enseignant`
--

INSERT INTO `enseignant` (`id_enseignant`, `prenom_enseignant`, `nom_enseignant`, `login`, `mdp`) VALUES
(1, 'Nedra', 'Mellouli-Nauwynck', 'nmellouli', 'nmellouli');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id_etudiant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prenom_etudiant` varchar(45) NOT NULL DEFAULT '',
  `nom_etudiant` varchar(45) NOT NULL DEFAULT '',
  `login` varchar(45) NOT NULL DEFAULT '',
  `mdp` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_etudiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`, `prenom_etudiant`, `nom_etudiant`, `login`, `mdp`) VALUES
(1, 'Lionel', 'Lienafa', 'llienafa', 'llienafa'),
(2, 'Mostafa', 'BIAICH', 'admin', 'admin'),
(3, 'Soumare', 'Issa', 'issa', 'issa')
;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_cours_eval`
--

CREATE TABLE IF NOT EXISTS `etudiant_cours_eval` (
  `id_etudiant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_eval_session` int(10) unsigned NOT NULL DEFAULT '0',
  `note_eval` decimal(10,0) NOT NULL DEFAULT '0',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_etudiant`,`id_eval_session`),
  KEY `FK_etudiant_cours_eval_3` (`id_eval_session`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `eval_session`
--

CREATE TABLE IF NOT EXISTS `eval_session` (
  `id_eval_session` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_debut` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `date_fin` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `id_cours_session` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_eval_session`),
  KEY `FK_eval_session_1` (`id_cours_session`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `inscription_session`
--

CREATE TABLE IF NOT EXISTS `inscription_session` (
  `id_etudiant` int(10) unsigned NOT NULL,
  `id_cours_session` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_etudiant`,`id_cours_session`),
  KEY `id_cours_session` (`id_cours_session`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelle_salle` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_salle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id_salle`, `libelle_salle`) VALUES
(1, 'B1-09'),
(2, 'A0-06'),
(3, 'B1-14'),
(4, 'D1-10');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `cours_session`
--
ALTER TABLE `cours_session`
  ADD CONSTRAINT `FK_cours_session_1` FOREIGN KEY (`id_cours`) REFERENCES `cours` (`id_cours`);

--
-- Contraintes pour la table `cours_session_item`
--
ALTER TABLE `cours_session_item`
  ADD CONSTRAINT `FK_cours_session_item_1` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`),
  ADD CONSTRAINT `FK_cours_session_item_2` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`),
  ADD CONSTRAINT `FK_cours_session_item_3` FOREIGN KEY (`id_cours_session`) REFERENCES `cours_session` (`id_cours_session`);

--
-- Contraintes pour la table `etudiant_cours_eval`
--
ALTER TABLE `etudiant_cours_eval`
  ADD CONSTRAINT `FK_etudiant_cours_eval_1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`),
  ADD CONSTRAINT `FK_etudiant_cours_eval_3` FOREIGN KEY (`id_eval_session`) REFERENCES `eval_session` (`id_eval_session`);

--
-- Contraintes pour la table `eval_session`
--
ALTER TABLE `eval_session`
  ADD CONSTRAINT `FK_eval_session_1` FOREIGN KEY (`id_cours_session`) REFERENCES `cours_session` (`id_cours_session`);

--
-- Contraintes pour la table `inscription_session`
--
ALTER TABLE `inscription_session`
  ADD CONSTRAINT `inscription_session_ibfk_1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`),
  ADD CONSTRAINT `inscription_session_ibfk_2` FOREIGN KEY (`id_cours_session`) REFERENCES `cours_session` (`id_cours_session`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

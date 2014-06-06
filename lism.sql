-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 06 Juin 2014 à 08:26
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
-- Structure de la table `administrateur`
--

CREATE TABLE IF NOT EXISTS `administrateur` (
  `id_administrateur` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prenom_administrateur` varchar(45) NOT NULL,
  `nom_administrateur` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT 'administrateur',
  PRIMARY KEY (`id_administrateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`id_administrateur`, `prenom_administrateur`, `nom_administrateur`, `login`, `mdp`, `role`) VALUES
(1, 'admin', 'admin', 'admi', 'admi', 'administrateur');

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
  `date_debut` date NOT NULL DEFAULT '0000-00-00',
  `date_fin` date NOT NULL DEFAULT '0000-00-00',
  `description` varchar(2000) NOT NULL DEFAULT '',
  `id_cours` int(10) unsigned NOT NULL DEFAULT '0',
  `type_cours_session` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cours_session`),
  KEY `FK_cours_session_1` (`id_cours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `cours_session`
--

INSERT INTO `cours_session` (`id_cours_session`, `date_debut`, `date_fin`, `description`, `id_cours`, `type_cours_session`) VALUES
(1, '2014-09-01', '2014-09-02', 'Cours de programmation Java', 4, 'Présentiel'),
(2, '2014-09-01', '2014-09-01', 'Intercultural communication and international perspectives', 2, 'En ligne');

-- --------------------------------------------------------

--
-- Structure de la table `cours_session_item`
--

CREATE TABLE IF NOT EXISTS `cours_session_item` (
  `id_cours_session_item` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_enseignant` int(10) unsigned DEFAULT NULL,
  `id_salle` int(10) unsigned NOT NULL DEFAULT '0',
  `id_cours_session` int(10) unsigned NOT NULL DEFAULT '0',
  `description_detail` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_cours_session_item`),
  KEY `FK_cours_session_item_1` (`id_enseignant`),
  KEY `FK_cours_session_item_2` (`id_salle`),
  KEY `FK_cours_session_item_3` (`id_cours_session`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `cours_session_item`
--

INSERT INTO `cours_session_item` (`id_cours_session_item`, `id_enseignant`, `id_salle`, `id_cours_session`, `description_detail`) VALUES
(1, 1, 2, 1, 'Cours sur framework java : hibernate'),
(3, 1, 1, 1, 'Test');

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
  `role` varchar(15) NOT NULL DEFAULT 'enseignant',
  PRIMARY KEY (`id_enseignant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `enseignant`
--

INSERT INTO `enseignant` (`id_enseignant`, `prenom_enseignant`, `nom_enseignant`, `login`, `mdp`, `role`) VALUES
(1, 'Nedra', 'Mellouli-Nauwynck', 'nmellouli', 'nmellouli', 'enseignant');

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
  `role` varchar(15) NOT NULL DEFAULT 'etudiant',
  PRIMARY KEY (`id_etudiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`, `prenom_etudiant`, `nom_etudiant`, `login`, `mdp`, `role`) VALUES
(1, 'Lionel', 'Lienafa', 'llienafa', 'llienafa', 'etudiant'),
(2, 'Mostafa', 'BIAICH', 'admin', 'admin', 'etudiant'),
(3, 'Soumare', 'Issa', 'issa', 'issa', 'etudiant'),
(4, 'test', 'Test', 'ttest', 'ttest', 'etudiant');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant_cours_eval`
--

CREATE TABLE IF NOT EXISTS `etudiant_cours_eval` (
  `id_etudiant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_eval_session` int(10) unsigned NOT NULL DEFAULT '0',
  `note_eval` decimal(10,0) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_etudiant`,`id_eval_session`),
  KEY `FK_etudiant_cours_eval_3` (`id_eval_session`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `etudiant_cours_eval`
--

INSERT INTO `etudiant_cours_eval` (`id_etudiant`, `id_eval_session`, `note_eval`, `status`) VALUES
(1, 1, '0', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `eval_session`
--

INSERT INTO `eval_session` (`id_eval_session`, `date_debut`, `date_fin`, `id_cours_session`) VALUES
(1, '2014-09-03 00:00:00', '2014-09-03 00:00:00', 1),
(2, '2014-05-31 00:00:00', '2014-05-31 00:00:00', 2);

-- --------------------------------------------------------

--
-- Structure de la table `inscription_session`
--

CREATE TABLE IF NOT EXISTS `inscription_session` (
  `id_etudiant` int(10) unsigned NOT NULL DEFAULT '0',
  `id_cours_session` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_etudiant`,`id_cours_session`),
  KEY `id_cours_session` (`id_cours_session`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `inscription_session`
--

INSERT INTO `inscription_session` (`id_etudiant`, `id_cours_session`) VALUES
(1, 1),
(2, 1),
(1, 2);

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

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `utilisateur`
--
CREATE TABLE IF NOT EXISTS `utilisateur` (
`id_utilisateur` int(11) unsigned
,`prenom_utilisateur` varchar(45)
,`nom_utilisateur` varchar(45)
,`login` varchar(45)
,`mdp` varchar(45)
,`role` varchar(15)
);
-- --------------------------------------------------------

--
-- Structure de la vue `utilisateur`
--
DROP TABLE IF EXISTS `utilisateur`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `utilisateur` AS select `etudiant`.`id_etudiant` AS `id_utilisateur`,`etudiant`.`prenom_etudiant` AS `prenom_utilisateur`,`etudiant`.`nom_etudiant` AS `nom_utilisateur`,`etudiant`.`login` AS `login`,`etudiant`.`mdp` AS `mdp`,`etudiant`.`role` AS `role` from `etudiant` union select `enseignant`.`id_enseignant` AS `id_enseignant`,`enseignant`.`prenom_enseignant` AS `prenom_enseignant`,`enseignant`.`nom_enseignant` AS `nom_enseignant`,`enseignant`.`login` AS `login`,`enseignant`.`mdp` AS `mdp`,`enseignant`.`role` AS `role` from `enseignant` union select `administrateur`.`id_administrateur` AS `id_administrateur`,`administrateur`.`nom_administrateur` AS `nom_administrateur`,`administrateur`.`prenom_administrateur` AS `prenom_administrateur`,`administrateur`.`login` AS `login`,`administrateur`.`mdp` AS `mdp`,`administrateur`.`role` AS `role` from `administrateur`;

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

-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 30 Juin 2015 à 19:31
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `projettutore`
--
CREATE DATABASE IF NOT EXISTS `projettutore` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `projettutore`;

-- --------------------------------------------------------

--
-- Structure de la table `bebe`
--

CREATE TABLE IF NOT EXISTS `bebe` (
  `id_bebe` int(11) NOT NULL AUTO_INCREMENT,
  `nom_b` varchar(50) NOT NULL,
  `prenom_b` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `poids_b` int(50) NOT NULL,
  `sexe_b` varchar(50) NOT NULL,
  PRIMARY KEY (`id_bebe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `bebe`
--

INSERT INTO `bebe` (`id_bebe`, `nom_b`, `prenom_b`, `date_naissance`, `poids_b`, `sexe_b`) VALUES
(1, 'jean', 'marie', '2015-06-09', 20, 'M'),
(2, 'jules', 'vernes', '2015-06-09', 18, 'M');

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE IF NOT EXISTS `consultation` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `date_consultation` date NOT NULL,
  `heure_consultation` varchar(50) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `medecin_consultant` varchar(50) NOT NULL,
  `nom_patiente` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `consultation`
--

INSERT INTO `consultation` (`id`, `date_consultation`, `heure_consultation`, `libelle`, `medecin_consultant`, `nom_patiente`) VALUES
(1, '2015-06-27', '14h:30', 'consultation pour l''echographie', 'Dr Arielle Nobime ', 'Nabou '),
(2, '2015-06-10', '10h:00', 'prise de contact avec le medecin', 'Dr Boris', 'Nabou'),
(3, '2015-06-10', '21h:45', 'tres urgent', 'Dr Arielle', 'Nabou');

-- --------------------------------------------------------

--
-- Structure de la table `patiente`
--

CREATE TABLE IF NOT EXISTS `patiente` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `nom_m` varchar(50) NOT NULL,
  `prenom_m` varchar(50) NOT NULL,
  `age_m` int(50) NOT NULL,
  `poids_m` int(50) NOT NULL,
  `grp_sm` varchar(50) NOT NULL,
  `date_gm` date NOT NULL,
  `num_m` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `patiente`
--

INSERT INTO `patiente` (`id`, `nom_m`, `prenom_m`, `age_m`, `poids_m`, `grp_sm`, `date_gm`, `num_m`) VALUES
(1, 'marie', 'marthe', 27, 85, 'B', '2015-06-27', '772277116'),
(2, 'vasquez', 'linda', 28, 75, 'A', '2015-03-12', '778877989'),
(3, 'louise', 'louise', 22, 90, 'AB', '2014-04-05', '334533455'),
(4, 'marie', 'madeleine', 22, 78, 'O ', '2014-01-03', '667855432'),
(5, 'Damnodji', 'edithe', 28, 87, 'AB', '2015-02-10', '330977654'),
(6, '', '', 0, 0, '', '0000-00-00', '');

-- --------------------------------------------------------

--
-- Structure de la table `rv`
--

CREATE TABLE IF NOT EXISTS `rv` (
  `id_rv` int(11) NOT NULL AUTO_INCREMENT,
  `nom_patiente` varchar(50) NOT NULL,
  `date_rv` date NOT NULL,
  `medecin_traitant` varchar(50) NOT NULL,
  PRIMARY KEY (`id_rv`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `rv`
--

INSERT INTO `rv` (`id_rv`, `nom_patiente`, `date_rv`, `medecin_traitant`) VALUES
(1, 'marie-louise', '2015-06-30', 'Dr Boris');

-- --------------------------------------------------------

--
-- Structure de la table `user1`
--

CREATE TABLE IF NOT EXISTS `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `user1`
--

INSERT INTO `user1` (`id`, `login`, `password`, `genre`, `nom`, `prenom`) VALUES
(2, 'marie', '12345', 'Femme', 'marie-cruz', 'parerra'),
(3, 'louise', 'louise', 'Femme', 'mari-jose', 'gomez'),
(4, 'john', 'passer', 'Femme', 'john', 'travolta');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : dim. 05 juin 2022 à 08:21
-- Version du serveur : 5.7.34
-- Version de PHP : 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_stage`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `firstname` varchar(250) NOT NULL,
  `lastname` varchar(250) NOT NULL,
  `role` varchar(120) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `email` varchar(250) NOT NULL,
  `phone_number` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id`, `firstname`, `lastname`, `role`, `password`, `email`, `phone_number`) VALUES
(1, 'dhekra', 'abuda', 'Enseignant', 'dhekra', 'dhekra@gmail.com', '0867754532'),
(2, 'nassima', 'haimar', 'Etudiant', 'nassima', 'nas@gmail.com', '0967754323'),
(3, 'george', 'manou', 'Directeur', 'george', 'george@gmail.com', '0967754234'),
(4, 'najib', 'kary', 'Tuteur entreprise', 'najib', 'naj@gmail.com', '0978865429'),
(5, 'najiba', 'karya', 'Tuteur entreprise', 'najiba', 'naja@gmail.com', '0978865427'),
(6, 'laurence', 'pillard', 'Enseignant', 'laurence', 'laur@gmail.com', '0978869827'),
(7, 'oumaima', 'haimar', 'Etudiant', 'oumaima', 'ouma@gmail.com', '0750032378');

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

CREATE TABLE `catalogue` (
  `id` int(11) NOT NULL,
  `offre_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `statut` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`id`, `offre_id`, `account_id`, `statut`) VALUES
(2, 1, 7, 0),
(3, 2, 7, 0),
(4, 1, 2, 0),
(5, 3, 2, 0),
(6, 1, 7, 0),
(7, 1, 7, 0),
(9, 2, 7, 0),
(10, 3, 7, 0),
(11, 3, 7, 0),
(12, 4, 7, 0),
(13, 2, 2, 0),
(14, 3, 7, 0),
(15, 2, 7, 0),
(16, 3, 2, 0),
(17, 2, 2, 0);

-- --------------------------------------------------------

--
-- Structure de la table `convention`
--

CREATE TABLE `convention` (
  `id_conv` int(30) NOT NULL,
  `id_offre` int(30) NOT NULL,
  `identite_encadrant` varchar(40) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `signe_directeur` tinyint(1) DEFAULT NULL,
  `signe_entreprise` tinyint(1) DEFAULT NULL,
  `signe_etudiant` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `id` int(11) NOT NULL,
  `entrepriseAccueil` varchar(60) NOT NULL,
  `sujetStage` varchar(80) NOT NULL,
  `missions` varchar(90) NOT NULL,
  `poste` varchar(60) NOT NULL,
  `lieu` varchar(80) NOT NULL,
  `montantIdemnite` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`id`, `entrepriseAccueil`, `sujetStage`, `missions`, `poste`, `lieu`, `montantIdemnite`) VALUES
(1, 'esgi', 'site', 'site\r\ncss', 'dev', 'paris', 0),
(2, 'isty', 'back', 'php\r\ncshstml\r\nfront', 'fullm stack', 'velizy', 10),
(3, 'Vertical', 'virtualisation', 'connexion', 'dev', 'nice', 3456),
(4, 'altas', 'realisation', 'donner, chanter danser', 'programmeur', 'lyon', 2345),
(5, 'adios', 'realiser une app', 'realiser une app , dev', 'developer', 'lille', 3451),
(6, 'orange', 'reseau', 'reseauuuu', 'ingenier', 'bordeaux', 3457);

-- --------------------------------------------------------

--
-- Structure de la table `Rôle`
--

CREATE TABLE `Rôle` (
  `id_role` int(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Rôle`
--

INSERT INTO `Rôle` (`id_role`, `role`) VALUES
(1, 'Admin'),
(2, 'Etudiant'),
(3, 'Enseignant'),
(4, 'Directeur'),
(5, 'Tuteur entreprise');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accout_id` (`account_id`),
  ADD KEY `offre_id` (`offre_id`);

--
-- Index pour la table `convention`
--
ALTER TABLE `convention`
  ADD PRIMARY KEY (`id_conv`),
  ADD KEY `id_offre` (`id_offre`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Rôle`
--
ALTER TABLE `Rôle`
  ADD PRIMARY KEY (`id_role`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `convention`
--
ALTER TABLE `convention`
  MODIFY `id_conv` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `offre`
--
ALTER TABLE `offre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `Rôle`
--
ALTER TABLE `Rôle`
  MODIFY `id_role` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD CONSTRAINT `catalogue_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `catalogue_ibfk_2` FOREIGN KEY (`offre_id`) REFERENCES `offre` (`id`);

--
-- Contraintes pour la table `convention`
--
ALTER TABLE `convention`
  ADD CONSTRAINT `id_offre` FOREIGN KEY (`id_offre`) REFERENCES `offre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

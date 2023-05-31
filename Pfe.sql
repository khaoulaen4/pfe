-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mar. 30 mai 2023 à 18:08
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `Pfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `Administrateur`
--

CREATE TABLE `Administrateur` (
  `id_ad` int(11) NOT NULL,
  `nom_adm` varchar(45) NOT NULL,
  `prenom_adm` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissence_adm` date NOT NULL,
  `Date_inscp_adm` date NOT NULL,
  `num_tele` int(45) NOT NULL,
  `message` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Chapitre`
--

CREATE TABLE `Chapitre` (
  `id_chpt` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `module` int(45) NOT NULL,
  `Date_ajoute` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Departement`
--

CREATE TABLE `Departement` (
  `id_dep` int(11) NOT NULL,
  `nom_dep` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Enseignant`
--

CREATE TABLE `Enseignant` (
  `id_eng` int(11) NOT NULL,
  `nom_eng` varchar(45) NOT NULL,
  `prenom_eng` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `User_Name` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissance_eng` date NOT NULL,
  `Date_inscp_eng` date NOT NULL,
  `num_tele` int(11) NOT NULL,
  `module` int(11) NOT NULL,
  `message` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Etudiante`
--

CREATE TABLE `Etudiante` (
  `id_etu` int(11) NOT NULL,
  `nom_etu` int(11) NOT NULL,
  `prenom_etu` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissance_etd` date NOT NULL,
  `Date_inscp_etd` date NOT NULL,
  `filier` int(11) NOT NULL,
  `Num_tele` int(11) NOT NULL,
  `Note` float NOT NULL,
  `module` int(11) NOT NULL,
  `message` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Exercice`
--

CREATE TABLE `Exercice` (
  `id_ex` int(11) NOT NULL,
  `nom_ex` varchar(45) NOT NULL,
  `module` int(45) NOT NULL,
  `Date_ajoute` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Filiere`
--

CREATE TABLE `Filiere` (
  `id_fil` int(11) NOT NULL,
  `Nom_fil` varchar(45) NOT NULL,
  `Code_fil` varchar(45) NOT NULL,
  `Departement` int(45) NOT NULL,
  `module` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id_Msg` int(11) NOT NULL,
  `Contenue` varchar(255) NOT NULL,
  `DateEnvoi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Module`
--

CREATE TABLE `Module` (
  `id_modul` int(45) NOT NULL,
  `nom_modul` varchar(45) NOT NULL,
  `filier` varchar(45) NOT NULL,
  `enseignante` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Question`
--

CREATE TABLE `Question` (
  `id_qst` int(11) NOT NULL,
  `Question` varchar(255) NOT NULL,
  `reponse` varchar(255) NOT NULL,
  `note` float NOT NULL,
  `quiz` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Quiz`
--

CREATE TABLE `Quiz` (
  `id_qz` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `Date_ajoute` date NOT NULL,
  `Date_limite` date NOT NULL,
  `module` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Administrateur`
--
ALTER TABLE `Administrateur`
  ADD PRIMARY KEY (`id_ad`),
  ADD UNIQUE KEY `UserName` (`UserName`),
  ADD KEY `message` (`message`);

--
-- Index pour la table `Chapitre`
--
ALTER TABLE `Chapitre`
  ADD PRIMARY KEY (`id_chpt`),
  ADD KEY `module` (`module`);

--
-- Index pour la table `Departement`
--
ALTER TABLE `Departement`
  ADD PRIMARY KEY (`id_dep`);

--
-- Index pour la table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD PRIMARY KEY (`id_eng`),
  ADD UNIQUE KEY `User_Name` (`User_Name`),
  ADD KEY `module` (`module`),
  ADD KEY `message` (`message`);

--
-- Index pour la table `Etudiante`
--
ALTER TABLE `Etudiante`
  ADD UNIQUE KEY `UserName` (`UserName`),
  ADD KEY `filier` (`filier`),
  ADD KEY `module` (`module`),
  ADD KEY `message` (`message`);

--
-- Index pour la table `Exercice`
--
ALTER TABLE `Exercice`
  ADD PRIMARY KEY (`id_ex`),
  ADD KEY `module` (`module`);

--
-- Index pour la table `Filiere`
--
ALTER TABLE `Filiere`
  ADD PRIMARY KEY (`id_fil`),
  ADD KEY `Departement` (`Departement`),
  ADD KEY `module` (`module`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_Msg`);

--
-- Index pour la table `Module`
--
ALTER TABLE `Module`
  ADD PRIMARY KEY (`id_modul`);

--
-- Index pour la table `Question`
--
ALTER TABLE `Question`
  ADD PRIMARY KEY (`id_qst`),
  ADD KEY `quiz` (`quiz`);

--
-- Index pour la table `Quiz`
--
ALTER TABLE `Quiz`
  ADD PRIMARY KEY (`id_qz`),
  ADD KEY `module` (`module`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Administrateur`
--
ALTER TABLE `Administrateur`
  ADD CONSTRAINT `administrateur_ibfk_1` FOREIGN KEY (`message`) REFERENCES `message` (`id_Msg`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Chapitre`
--
ALTER TABLE `Chapitre`
  ADD CONSTRAINT `chapitre_ibfk_1` FOREIGN KEY (`module`) REFERENCES `Module` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Enseignant`
--
ALTER TABLE `Enseignant`
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`module`) REFERENCES `Module` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `enseignant_ibfk_2` FOREIGN KEY (`message`) REFERENCES `message` (`id_Msg`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Etudiante`
--
ALTER TABLE `Etudiante`
  ADD CONSTRAINT `etudiante_ibfk_1` FOREIGN KEY (`filier`) REFERENCES `Filiere` (`id_fil`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiante_ibfk_2` FOREIGN KEY (`module`) REFERENCES `Module` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiante_ibfk_3` FOREIGN KEY (`message`) REFERENCES `message` (`id_Msg`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Exercice`
--
ALTER TABLE `Exercice`
  ADD CONSTRAINT `exercice_ibfk_1` FOREIGN KEY (`module`) REFERENCES `Module` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Filiere`
--
ALTER TABLE `Filiere`
  ADD CONSTRAINT `filiere_ibfk_1` FOREIGN KEY (`Departement`) REFERENCES `Departement` (`id_dep`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `filiere_ibfk_2` FOREIGN KEY (`module`) REFERENCES `Module` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Question`
--
ALTER TABLE `Question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`quiz`) REFERENCES `Quiz` (`id_qz`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Quiz`
--
ALTER TABLE `Quiz`
  ADD CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`module`) REFERENCES `Module` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

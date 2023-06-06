-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 05 juin 2023 à 21:49
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `id_ad` int(11) NOT NULL,
  `nom_adm` varchar(45) NOT NULL,
  `prenom_adm` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissence_adm` date DEFAULT NULL,
  `Date_inscp_adm` date NOT NULL DEFAULT current_timestamp(),
  `num_tele` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `chapitre`
--

CREATE TABLE `chapitre` (
  `id_chpt` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `module` int(45) NOT NULL,
  `Date_ajoute` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `id_dep` int(11) NOT NULL,
  `nom_dep` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`id_dep`, `nom_dep`) VALUES
(1, 'Informatique'),
(2, 'Physique'),
(3, 'Droit Arabe'),
(4, 'SVI'),
(5, 'Math');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `id_eng` int(11) NOT NULL,
  `nom_eng` varchar(45) NOT NULL,
  `prenom_eng` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `User_Name` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissance_eng` date DEFAULT NULL,
  `Date_inscp_eng` date NOT NULL DEFAULT current_timestamp(),
  `num_tele` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `etudiante`
--

CREATE TABLE `etudiante` (
  `id_etu` int(11) NOT NULL,
  `nom_etu` int(11) NOT NULL,
  `prenom_etu` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissance_etd` date DEFAULT NULL,
  `Date_inscp_etd` date NOT NULL DEFAULT current_timestamp(),
  `filier` int(11) NOT NULL,
  `Num_tele` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `etudiante_module`
--

CREATE TABLE `etudiante_module` (
  `id` int(11) NOT NULL,
  `idModul` int(11) NOT NULL,
  `idEtu` int(11) NOT NULL,
  `note_modul` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

CREATE TABLE `exercice` (
  `id_ex` int(11) NOT NULL,
  `nom_ex` varchar(45) NOT NULL,
  `module` int(45) NOT NULL,
  `Date_ajoute` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `id_fil` int(11) NOT NULL,
  `Nom_fil` varchar(45) NOT NULL,
  `Code_fil` varchar(45) NOT NULL,
  `Departement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`id_fil`, `Nom_fil`, `Code_fil`, `Departement`) VALUES
(1, 'SMathInfo', '123', 1),
(2, 'SMathPhysique', '456', 2),
(3, 'Droit Prive', '789', 3),
(4, 'SMathInfo', '101', 5),
(5, 'SMathPhysique', '112', 5);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id_Msg` int(11) NOT NULL,
  `Contenue` varchar(255) NOT NULL,
  `DateEnvoi` date NOT NULL DEFAULT current_timestamp(),
  `sender` int(11) NOT NULL,
  `receiver` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `modul`
--

CREATE TABLE `modul` (
  `id_modul` int(45) NOT NULL,
  `nom_modul` varchar(45) NOT NULL,
  `filier` int(11) NOT NULL,
  `enseignante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `note_quiz`
--

CREATE TABLE `note_quiz` (
  `idNote` int(11) NOT NULL,
  `idEtu` int(11) NOT NULL,
  `IdQuiz` int(11) NOT NULL,
  `note_quiz` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `id_qst` int(11) NOT NULL,
  `Question` varchar(255) NOT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  `note` float DEFAULT NULL,
  `quiz` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `quiz`
--

CREATE TABLE `quiz` (
  `id_qz` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `Date_ajoute` date NOT NULL DEFAULT current_timestamp(),
  `Date_limite` date DEFAULT NULL,
  `module` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id_ad`),
  ADD UNIQUE KEY `UserName` (`UserName`);

--
-- Index pour la table `chapitre`
--
ALTER TABLE `chapitre`
  ADD PRIMARY KEY (`id_chpt`),
  ADD KEY `module` (`module`);

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id_dep`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id_eng`),
  ADD UNIQUE KEY `User_Name` (`User_Name`);

--
-- Index pour la table `etudiante`
--
ALTER TABLE `etudiante`
  ADD PRIMARY KEY (`id_etu`),
  ADD UNIQUE KEY `UserName` (`UserName`),
  ADD KEY `filier` (`filier`);

--
-- Index pour la table `etudiante_module`
--
ALTER TABLE `etudiante_module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEtu` (`idEtu`),
  ADD KEY `idModul` (`idModul`);

--
-- Index pour la table `exercice`
--
ALTER TABLE `exercice`
  ADD PRIMARY KEY (`id_ex`),
  ADD KEY `module` (`module`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`id_fil`),
  ADD KEY `Departement` (`Departement`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_Msg`);

--
-- Index pour la table `modul`
--
ALTER TABLE `modul`
  ADD PRIMARY KEY (`id_modul`),
  ADD KEY `filier` (`filier`),
  ADD KEY `enseignante` (`enseignante`);

--
-- Index pour la table `note_quiz`
--
ALTER TABLE `note_quiz`
  ADD PRIMARY KEY (`idNote`),
  ADD KEY `idEtu` (`idEtu`),
  ADD KEY `IdQuiz` (`IdQuiz`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_qst`),
  ADD KEY `quiz` (`quiz`);

--
-- Index pour la table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id_qz`),
  ADD KEY `module` (`module`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `id_ad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chapitre`
--
ALTER TABLE `chapitre`
  MODIFY `id_chpt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `id_dep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `id_eng` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `etudiante`
--
ALTER TABLE `etudiante`
  MODIFY `id_etu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `etudiante_module`
--
ALTER TABLE `etudiante_module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `exercice`
--
ALTER TABLE `exercice`
  MODIFY `id_ex` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id_fil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id_Msg` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `modul`
--
ALTER TABLE `modul`
  MODIFY `id_modul` int(45) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `note_quiz`
--
ALTER TABLE `note_quiz`
  MODIFY `idNote` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `id_qst` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id_qz` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chapitre`
--
ALTER TABLE `chapitre`
  ADD CONSTRAINT `chapitre_ibfk_1` FOREIGN KEY (`module`) REFERENCES `modul` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiante_module`
--
ALTER TABLE `etudiante_module`
  ADD CONSTRAINT `etudiante_module_ibfk_1` FOREIGN KEY (`idEtu`) REFERENCES `etudiante` (`id_etu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiante_module_ibfk_2` FOREIGN KEY (`idModul`) REFERENCES `modul` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `exercice`
--
ALTER TABLE `exercice`
  ADD CONSTRAINT `exercice_ibfk_1` FOREIGN KEY (`module`) REFERENCES `modul` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD CONSTRAINT `filiere_ibfk_5` FOREIGN KEY (`Departement`) REFERENCES `departement` (`id_dep`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `modul`
--
ALTER TABLE `modul`
  ADD CONSTRAINT `modul_ibfk_1` FOREIGN KEY (`filier`) REFERENCES `filiere` (`id_fil`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `modul_ibfk_2` FOREIGN KEY (`enseignante`) REFERENCES `enseignant` (`id_eng`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `note_quiz`
--
ALTER TABLE `note_quiz`
  ADD CONSTRAINT `note_quiz_ibfk_1` FOREIGN KEY (`idEtu`) REFERENCES `etudiante` (`id_etu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `note_quiz_ibfk_2` FOREIGN KEY (`IdQuiz`) REFERENCES `quiz` (`id_qz`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`quiz`) REFERENCES `quiz` (`id_qz`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`module`) REFERENCES `modul` (`id_modul`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

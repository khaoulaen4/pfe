-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : sam. 24 juin 2023 à 00:22
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
  `num_tele` varchar(255) DEFAULT NULL,
  `user_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`id_ad`, `nom_adm`, `prenom_adm`, `email`, `UserName`, `password`, `Date_naissence_adm`, `Date_inscp_adm`, `num_tele`, `user_name`) VALUES
(1, 'Admin', 'Admin', 'khaoula@gmail.com', 'Admin1', '1234', '2001-10-05', '2023-06-15', '0612345678', '');

-- --------------------------------------------------------

--
-- Structure de la table `chapitre`
--

CREATE TABLE `chapitre` (
  `id_chpt` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `module` int(45) DEFAULT NULL,
  `Date_ajoute` date DEFAULT current_timestamp(),
  `contenue` varchar(2250) DEFAULT NULL,
  `Image` varchar(2550) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `chapitre`
--

INSERT INTO `chapitre` (`id_chpt`, `titre`, `module`, `Date_ajoute`, `contenue`, `Image`) VALUES
(1, 'Rappele Java', 4, NULL, '77f47268-bf0e-4557-97b8-fc00c6c466fe.pdf', 'bda834ac-a205-457a-94a1-c1270acd61f6.jpg'),
(2, 'les servlets et jsp', 4, NULL, 'a6c951da-bd37-4926-a4c1-ae69c8b765a2.pdf', 'b74512c4-6c11-4d83-8d86-61c17f019e22.jpg'),
(3, 'Adressage Resaux', 5, NULL, '900d9754-a16f-4d57-adae-58c2259db833.pdf', '25076a13-f809-4d06-a3ba-ecc5baa1dc84.jpg'),
(4, 'Les VLANs', 5, NULL, '7a69fc43-51f6-4c6e-8fb8-82e5f1dfdfa8.pdf', '39bdebad-43ef-4a76-9370-71b86a0d6224.jpg'),
(5, 'Programmation Patrie 1 ', 3, NULL, '465f8037-e919-4a73-9cf4-0ede9a333794.pdf', 'a0f045e1-7bf1-49a0-bf87-9740c1e8d610.jpg'),
(6, 'Programmation Partie 2', 3, NULL, 'afbda0e2-6fa5-4bd4-9be4-c0832cdbc09c.pdf', 'acd511b1-c402-452a-8b9e-87426c508b9f.jpg'),
(9, 'Gestion des fichiers', 6, NULL, '79b6d130-3456-4242-baf9-6c85180ce746.pdf', 'aa6ae603-5c5f-45f3-bfdd-d7680b32b5f6.jpg'),
(10, 'Unix vs Linux', 6, NULL, 'c253527b-de04-4b4c-987f-6a882202b8e0.pdf', '33798ee9-292d-4423-b52c-34bfbd3137a3.jpg'),
(13, 'ALGÈBRE LINÉAIRE', 8, NULL, 'a18e345b-0493-4585-9d51-3903f4407fe0.pdf', '4a4c583d-cbb8-4666-a5a7-16905fdb6a02.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `id_dep` int(11) NOT NULL,
  `nom_dep` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `departement`
--

INSERT INTO `departement` (`id_dep`, `nom_dep`) VALUES
(1, 'Informatique'),
(3, 'Droit Arabe'),
(6, 'SVI'),
(7, 'Math');

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
  `Date_inscp_eng` date DEFAULT current_timestamp(),
  `num_tele` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id_eng`, `nom_eng`, `prenom_eng`, `email`, `User_Name`, `password`, `Date_naissance_eng`, `Date_inscp_eng`, `num_tele`) VALUES
(1, 'Achkari begdouri', 'Mohamed', 'Mohamed@gmail.com', 'Achkari begdouri', '123456789', '1998-11-26', NULL, '07123456567'),
(2, 'Haimoudi', 'ElKhatir', 'haimoudikhatir@gmail.com', 'haimoudikhatir', '23456780987', '1978-05-12', NULL, '0712345678'),
(3, 'GIBET TANI', 'Hicham', 'Hgibet@gmail.com', 'hichamGibet', '9876532', '1988-03-06', NULL, '06123456789'),
(4, 'TOUIL', 'Hicham', 'Hichamtouil@gmail.com', 'touilHICHAM', '123987653', '1967-12-08', NULL, '07123456'),
(5, 'Astitou', 'Mohamed', 'Mohamed@gmail.com', 'Meedas', '098762', '2001-11-26', NULL, '071234567890');

-- --------------------------------------------------------

--
-- Structure de la table `etudiante`
--

CREATE TABLE `etudiante` (
  `id_etu` int(11) NOT NULL,
  `nom_etu` varchar(255) NOT NULL,
  `prenom_etu` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `Date_naissance_etd` date DEFAULT NULL,
  `Date_inscp_etd` date DEFAULT current_timestamp(),
  `filier` int(11) DEFAULT NULL,
  `Num_tele` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiante`
--

INSERT INTO `etudiante` (`id_etu`, `nom_etu`, `prenom_etu`, `email`, `user_name`, `password`, `Date_naissance_etd`, `Date_inscp_etd`, `filier`, `Num_tele`) VALUES
(4, 'Astitou', 'Meed', 'Meed@gmail.com', 'MeedAss', '123456', '2000-11-26', NULL, 1, '07123456'),
(5, 'mtmari', 'Hafsa', 'hafsa@gmail.com', 'HafsaMtm', '56789', '2001-02-01', NULL, 1, '061234567'),
(6, 'khaiari', 'simo', 'mohammed.elkhaiari@gmail.com', 'mohammed', 'password', '2003-01-25', NULL, 1, '1234567890'),
(7, 'Chakkour', 'Khadija', 'chakkourk4@gmail.com', 'ChakkourKhadija', 'khadija123', '2003-02-21', NULL, 1, '0622324471'),
(9, 'enfifakh', 'khaoula', 'khaoulanefifakh@gmail.com', 'khaoulaenfifakh', '123456', '2000-10-05', NULL, 1, '06123456');

-- --------------------------------------------------------

--
-- Structure de la table `etudiante_module`
--

CREATE TABLE `etudiante_module` (
  `id` int(11) NOT NULL,
  `idModul` int(11) NOT NULL,
  `idEtu` int(11) NOT NULL,
  `note_modul` int(11) DEFAULT NULL,
  `id_etu` int(11) NOT NULL,
  `id_modul` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

CREATE TABLE `exercice` (
  `id_ex` int(11) NOT NULL,
  `nom_ex` varchar(45) NOT NULL,
  `module` int(45) NOT NULL,
  `Date_ajoute` date DEFAULT current_timestamp(),
  `contenue` varchar(2250) NOT NULL,
  `Image` varchar(2550) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `exercice`
--

INSERT INTO `exercice` (`id_ex`, `nom_ex`, `module`, `Date_ajoute`, `contenue`, `Image`) VALUES
(1, 'Tp1_Les Collections', 4, NULL, '626b3f76-8156-4f72-b038-69cd26648282.pdf', 'ae473764-b244-43dc-9398-633d3fa50f16.jpg'),
(2, 'Tp2_JDBC', 4, NULL, '16f9ad23-bae0-4223-89c4-900852ed8c84.pdf', '423ba013-5b59-4fb2-848c-811be09307db.jpg'),
(3, 'Td1_fork()', 6, NULL, '20f30ce9-0a17-4110-9085-ddd877fc4968.pdf', 'e32a3e18-1a03-495b-88af-0e5167c17d9c.jpg'),
(4, 'Td2_file', 6, NULL, '09fc2f2d-f7bf-4cc3-8595-49eae8186b0d.pdf', 'e145af16-efd9-4855-a330-8c11df8c0b80.jpg'),
(5, 'Tp1_Routage_Statique', 5, NULL, 'aecca084-b758-44ed-8639-c51777c135dd.pdf', '9902b241-4b8a-4bca-a856-354a5c6af9a2.jpg'),
(6, 'Tp2_VLAN', 5, NULL, '49373030-54c7-46cb-9864-667863ebf197.pdf', '6ab5920e-f815-44cc-abb4-893e437c6db7.jpg'),
(7, 'Tp1_EssaiEvenement', 3, NULL, 'a22008d3-95d7-426a-9280-e664ded6376a.pdf', 'a311e2e5-d14a-4906-8126-da5b43f44388.jpg'),
(8, 'Tp2_Frame', 3, NULL, 'f4b75e12-df27-4762-8ea6-c368e61cef7e.pdf', '93fba449-0f57-42a5-b053-56b913f4f049.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `id_fil` int(11) NOT NULL,
  `Nom_fil` varchar(45) NOT NULL,
  `Code_fil` varchar(45) NOT NULL,
  `Departement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`id_fil`, `Nom_fil`, `Code_fil`, `Departement`) VALUES
(1, 'SMathInformatique', '1238', 7),
(7, 'SMathAplique', '21425', 7),
(8, 'Droit Prive', '8743456', 3);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id_Msg` int(11) NOT NULL,
  `Contenue` varchar(255) NOT NULL,
  `DateEnvoi` date NOT NULL DEFAULT current_timestamp(),
  `sender` int(11) NOT NULL,
  `receiver` int(11) NOT NULL,
  `date_envoi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `modul`
--

CREATE TABLE `modul` (
  `id_modul` int(45) NOT NULL,
  `nom_modul` varchar(45) NOT NULL,
  `filier` int(11) NOT NULL,
  `enseignante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `modul`
--

INSERT INTO `modul` (`id_modul`, `nom_modul`, `filier`, `enseignante`) VALUES
(1, 'Math', 1, NULL),
(3, 'Programmation', 1, NULL),
(4, 'JEE', 1, NULL),
(5, 'Resaux', 1, NULL),
(6, 'Systeme D\'exploitation', 1, NULL),
(8, 'Algebre', 1, NULL),
(12, 'Analyse', 1, NULL),
(13, 'Physique', 7, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `note_quiz`
--

CREATE TABLE `note_quiz` (
  `idNote` int(11) NOT NULL,
  `idEtu` int(11) NOT NULL,
  `IdQuiz` int(11) NOT NULL,
  `note_quiz` int(11) NOT NULL,
  `id_etu` int(11) NOT NULL,
  `id_quiz` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `id_qst` int(11) NOT NULL,
  `Question` varchar(255) NOT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  `note` double DEFAULT NULL,
  `quiz` int(11) NOT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`id_qst`, `Question`, `reponse`, `note`, `quiz`, `option1`, `option2`, `option3`) VALUES
(1, 'Quelle methode est appelee en premier a chaque appel d une servelet?', 'init ()', 1, 1, 'Start()', 'Run()', 'Servive()'),
(2, 'Quelle exeption est levee lors de l\'initialisation du Servelet echoue?', 'ServletExeption', 1, 1, 'RemoteExeption', 'IOExeption', 'SochetExeption'),
(3, 'Quelle methode est appelee en premier a chaque appel d une servelet?', 'init ()', 1, 2, 'Sevice()', 'Get()', 'Set()'),
(4, 'Quelle methode est appelee ?', 'sdas', 1, 2, 'wertyu', 'wertyuf', 'qsdfgh');

-- --------------------------------------------------------

--
-- Structure de la table `quiz`
--

CREATE TABLE `quiz` (
  `id_qz` int(11) NOT NULL,
  `titre` varchar(45) NOT NULL,
  `Date_ajoute` date DEFAULT current_timestamp(),
  `Date_limite` date DEFAULT NULL,
  `module` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `quiz`
--

INSERT INTO `quiz` (`id_qz`, `titre`, `Date_ajoute`, `Date_limite`, `module`) VALUES
(1, 'Quiz JEE', NULL, NULL, NULL),
(2, 'quiz1', NULL, NULL, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id_ad`),
  ADD UNIQUE KEY `UserName` (`UserName`),
  ADD UNIQUE KEY `UK_fbibgy3cxd8fcgmqhk1gcju20` (`user_name`),
  ADD UNIQUE KEY `UKgbyp8bbrkrrtpp99ku9cpecbl` (`user_name`);

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
  ADD UNIQUE KEY `User_Name` (`User_Name`),
  ADD UNIQUE KEY `UKhm1i1f4jqruuos78kf4g3i36t` (`User_Name`);

--
-- Index pour la table `etudiante`
--
ALTER TABLE `etudiante`
  ADD PRIMARY KEY (`id_etu`),
  ADD UNIQUE KEY `UserName` (`user_name`) USING BTREE,
  ADD UNIQUE KEY `UKdg5pmn3tohp58x2ds01o8v0em` (`user_name`),
  ADD KEY `filier` (`filier`);

--
-- Index pour la table `etudiante_module`
--
ALTER TABLE `etudiante_module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idEtu` (`idEtu`),
  ADD KEY `idModul` (`idModul`),
  ADD KEY `FKc79ysr5p0v6mfbi0g0rsq7k24` (`id_etu`),
  ADD KEY `FK4qi88lpiems6v31we6elaxu8u` (`id_modul`);

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
  ADD KEY `IdQuiz` (`IdQuiz`),
  ADD KEY `FKq9ag7tiyc9nc2vb0cvtu6vc77` (`id_etu`),
  ADD KEY `FKrugofw4t67nwnj0q1o6x1jrr3` (`id_quiz`);

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
  MODIFY `id_ad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `chapitre`
--
ALTER TABLE `chapitre`
  MODIFY `id_chpt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `id_dep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `id_eng` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `etudiante`
--
ALTER TABLE `etudiante`
  MODIFY `id_etu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `etudiante_module`
--
ALTER TABLE `etudiante_module`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `exercice`
--
ALTER TABLE `exercice`
  MODIFY `id_ex` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id_fil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id_Msg` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `modul`
--
ALTER TABLE `modul`
  MODIFY `id_modul` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `note_quiz`
--
ALTER TABLE `note_quiz`
  MODIFY `idNote` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `id_qst` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id_qz` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  ADD CONSTRAINT `FK4qi88lpiems6v31we6elaxu8u` FOREIGN KEY (`id_modul`) REFERENCES `modul` (`id_modul`),
  ADD CONSTRAINT `FKc79ysr5p0v6mfbi0g0rsq7k24` FOREIGN KEY (`id_etu`) REFERENCES `etudiante` (`id_etu`),
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
  ADD CONSTRAINT `FKq9ag7tiyc9nc2vb0cvtu6vc77` FOREIGN KEY (`id_etu`) REFERENCES `etudiante` (`id_etu`),
  ADD CONSTRAINT `FKrugofw4t67nwnj0q1o6x1jrr3` FOREIGN KEY (`id_quiz`) REFERENCES `quiz` (`id_qz`),
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

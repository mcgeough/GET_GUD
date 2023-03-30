-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2023 at 08:14 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `getgud`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `title` varchar(20) NOT NULL,
  `genre` varchar(10) NOT NULL,
  `ageRating` varchar(3) NOT NULL,
  `price` double NOT NULL,
  `info` varchar(30) NOT NULL,
  `platform` varchar(15) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`title`, `genre`, `ageRating`, `price`, `info`, `platform`, `id`) VALUES
('Animal Crossing: New', 'Life simul', '3+', 49.99, 'Create your own island paradis', 'Nintendo Switch', 6),
('Demon\'s Souls', 'Action RPG', '16+', 69.99, 'Experience the remake of the c', 'PlayStation 5', 2),
('Forza Horizon 5', 'Racing', '12+', 59.99, 'Race across Mexico in the late', 'Xbox Series S', 4),
('Halo Infinite', 'First-pers', '16+', 59.99, 'Join Master Chief on a new adv', 'Xbox Series S', 3),
('Spider-Man: Miles Mo', 'Action', '12+', 49.99, 'Swing through New York City as', 'PlayStation 5', 1),
('The Legend of Zelda:', 'Action-adv', '12+', 59.99, 'Explore the vast open world of', 'Nintendo Switch', 5);

-- --------------------------------------------------------

--
-- Table structure for table `game_barter`
--

CREATE TABLE `game_barter` (
  `Barter_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `gameToTrade` varchar(20) NOT NULL,
  `wanted_game` varchar(20) NOT NULL,
  `Misc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game_barter`
--

INSERT INTO `game_barter` (`Barter_id`, `user_id`, `username`, `gameToTrade`, `wanted_game`, `Misc`) VALUES
(1, 1, 'johndoe', 'Spider-Man: Miles Mo', 'Demon\'s Souls', 'Looking for someone in the same city to trade game'),
(2, 2, 'janedoe', 'Halo Infinite', 'Forza Horizon 5', 'Prefer to meet up in person to trade.'),
(3, 3, 'bobsmith', 'Animal Crossing: New', 'The Legend of Zelda:', 'Looking to trade with someone who has played both '),
(4, 1, 'johndoe', 'Demon\'s Souls', 'Spider-Man: Miles Mo', 'Interested in trading with someone who has complet'),
(5, 2, 'janedoe', 'Forza Horizon 5', 'Halo Infinite', 'Looking to trade with someone who also enjoys raci'),
(6, 3, 'bobsmith', 'The Legend of Zelda:', 'Animal Crossing: New', 'Open to trading with someone who has a different N');

-- --------------------------------------------------------

--
-- Table structure for table `lfg`
--

CREATE TABLE `lfg` (
  `user_id` int(11) NOT NULL,
  `gameTitle` varchar(20) NOT NULL,
  `platform` varchar(10) NOT NULL,
  `haveMic` tinyint(1) NOT NULL,
  `language` varchar(15) NOT NULL,
  `region` varchar(10) NOT NULL,
  `info` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lfg`
--

INSERT INTO `lfg` (`user_id`, `gameTitle`, `platform`, `haveMic`, `language`, `region`, `info`) VALUES
(1, 'Fortnite', 'Xbox', 1, 'English', 'NA West', 'Looking for squad to play competitive'),
(2, 'Call of Duty: Warzon', 'PlayStatio', 0, 'Spanish', 'NA East', 'Need a squad for casual play'),
(3, 'Apex Legends', 'PC', 1, 'French', 'EU', 'Looking for duo to push ranks'),
(4, 'Minecraft', 'Nintendo S', 1, 'English', 'NA East', 'Looking for friends to play survival'),
(5, 'Overwatch', 'Xbox', 1, 'English', 'NA West', 'Looking for group to play quick play'),
(6, 'Valorant', 'PC', 1, 'German', 'EU', 'Need a team for ranked play'),
(7, 'FIFA 22', 'PlayStatio', 0, 'English', 'NA East', 'Looking for someone to play co-op with'),
(8, 'Rocket League', 'PC', 1, 'English', 'EU', 'Need a teammate for 2v2 ranked play');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `gameTitle` varchar(30) NOT NULL,
  `Rating` decimal(10,0) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `Description`, `gameTitle`, `Rating`, `user_id`) VALUES
(1, 'Great game! The graphics are amazing and the gameplay is really fun.', 'Spider-Man: Miles Morales', '9', 1),
(2, 'I loved this game. The story is great and the combat is really satisfying.', 'Halo Infinite', '8', 2),
(3, 'This game is so relaxing and cute. I could play it for hours!', 'Animal Crossing: New Horizons', '10', 3),
(4, 'This is one of the best racing games I\'ve ever played. The graphics are beautiful and the cars handle really well.', 'Forza Horizon 5', '9', 2),
(5, 'This is a really challenging game, but it\'s also really rewarding. The boss fights are amazing!', 'Demon\'s Souls', '9', 1),
(6, 'This game is a masterpiece. The open world is incredible and there\'s so much to explore.', 'The Legend of Zelda: Breath of', '10', 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(20) NOT NULL,
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `D.o.B` date DEFAULT NULL,
  `isCritic` tinyint(1) DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `email`, `firstName`, `lastName`, `D.o.B`, `isCritic`, `isAdmin`) VALUES
(1, 'johndoe', 'password1', 'johndoe@example.com', 'John', 'Doe', '1985-07-15', 0, 0),
(2, 'janedoe', 'password2', 'janedoe@example.com', 'Jane', 'Doe', '1990-01-01', 0, 0),
(3, 'bobsmith', 'password3', 'bobsmith@example.com', 'Bob', 'Smith', '1988-05-20', 0, 0),
(4, 'critic1', 'password4', 'critic1@example.com', 'Hard', 'Critic', '1982-12-31', 1, 0),
(5, 'critic2', 'password5', 'critic2@example.com', 'Sarah', 'Jones', '1975-08-08', 1, 0),
(6, 'admin1', 'password6', 'admin1@example.com', 'Admin', 'User', '1970-01-01', 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`title`);

--
-- Indexes for table `game_barter`
--
ALTER TABLE `game_barter`
  ADD PRIMARY KEY (`Barter_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `lfg`
--
ALTER TABLE `lfg`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `lfg_ibfk_1` (`gameTitle`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `gameTitle` (`gameTitle`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `game_barter`
--
ALTER TABLE `game_barter`
  ADD CONSTRAINT `game_barter_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- Triggers for dumped tables (untested)

CREATE TRIGGER `set_haveMic_on_info_update` BEFORE UPDATE ON `lfg`
FOR EACH ROW
BEGIN
    IF NEW.info LIKE '%have mic%' THEN
        SET NEW.haveMic = 1;
    END IF;
END;

CREATE TRIGGER `prevent_duplicate_entries` BEFORE INSERT ON `lfg`
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1 FROM `lfg`
        WHERE `user_id` = NEW.`user_id`
        AND `gameTitle` = NEW.`gameTitle`
        AND `platform` = NEW.`platform`
        AND `info` != 'Deleted'
    ) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You already have an active entry for this game and platform.';
    END IF;
END;

CREATE TRIGGER `prevent_gameTitle_platform_update` BEFORE UPDATE ON `lfg`
FOR EACH ROW
BEGIN
    IF OLD.gameTitle != NEW.gameTitle OR OLD.platform != NEW.platform THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You cannot change the game title or platform for an LFG entry.';
    END IF;
END;

CREATE TRIGGER `set_user_roles_on_insert` BEFORE INSERT ON `users`
FOR EACH ROW
BEGIN
    IF NEW.email LIKE '%@gmail.com' OR NEW.email LIKE '%@yahoo.com' THEN
        SET NEW.isAdmin = 0;
        SET NEW.isCritic = 1;
    END IF;
END;

CREATE TRIGGER `prevent_game_deletion_on_review` BEFORE DELETE ON `game`
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1 FROM `reviews`
        WHERE `gameTitle` = OLD.`title`
    ) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'This game has reviews associated with it and cannot be deleted.';
    END IF;
END;

CREATE TRIGGER `set_unique_barter_id_on_insert` BEFORE INSERT ON `game_barter`
FOR EACH ROW
BEGIN
    SET NEW.Barter_id = (
        SELECT COALESCE(MAX(`Barter_id`), 0) + 1 FROM `game_barter`
    );
END;

CREATE TRIGGER `prevent_gameTitle_update` BEFORE UPDATE ON `reviews`
FOR EACH ROW
BEGIN
    IF OLD.gameTitle != NEW.gameTitle THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You cannot change the game title for a review.';
    END IF;
END;

CREATE TRIGGER `prevent_gameTitle_platform_update` BEFORE UPDATE ON `lfg`
FOR EACH ROW
BEGIN
    IF OLD.gameTitle != NEW.gameTitle OR OLD.platform != NEW.platform THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You cannot change the game title or platform for an LFG entry.';
    END IF;
END;

CREATE TRIGGER `prevent_duplicate_entries` BEFORE INSERT ON `lfg`
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1 FROM `lfg`
        WHERE `user_id` = NEW.`user_id`
        AND `gameTitle` = NEW.`gameTitle`
        AND `platform` = NEW.`platform`
        AND `info` != 'Deleted'
    ) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You already have an active entry for this game and platform.';
    END IF;
END;
-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 21, 2021 at 03:30 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `my-chat`
--

-- --------------------------------------------------------

--
-- Table structure for table `channel`
--

CREATE TABLE `channel` (
  `Id` int(11) NOT NULL,
  `User1` varchar(30) NOT NULL,
  `User2` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `channel`
--

INSERT INTO `channel` (`Id`, `User1`, `User2`) VALUES
(1, '12', '1234'),
(2, 'YY', 'yk'),
(3, 'Yogesh Kumar', 'yk'),
(4, 'Ravi', '12');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `Id` int(11) NOT NULL,
  `Channel` varchar(30) NOT NULL,
  `Sender` varchar(30) NOT NULL,
  `Text` text NOT NULL,
  `Time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`Id`, `Channel`, `Sender`, `Text`, `Time`) VALUES
(1, '1', '12', 'Association for  Computing Machinery', '2021-03-20 07:36:37'),
(2, '1', '12', 'MY', '2021-03-20 09:35:21'),
(3, '1', '12', 'hello', '2021-03-20 09:47:37'),
(4, '1', '12', 'hi', '2021-03-20 09:48:25'),
(5, '1', '12', '...', '2021-03-20 09:52:25'),
(6, '1', '12', 'hi', '2021-03-20 10:07:00'),
(7, '1', '12', 'hi', '2021-03-20 10:07:01'),
(8, '1', '12', 'll', '2021-03-20 10:08:42'),
(9, '1', '12', 'hello', '2021-03-21 13:07:33'),
(10, '1', '12', 'hi', '2021-03-21 13:07:53'),
(11, '1', '12', 'YOGESH5YOGESH5YOGESH5YOGESH5YOGESH5YOGESH5', '2021-03-21 13:55:45'),
(12, '1', '12', 'mjqqt', '2021-03-21 14:00:29'),
(13, '1', '12', 'mjqqt', '2021-03-21 14:19:34');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `Name`, `Password`) VALUES
('12', 'Yogesh', '12345'),
('1234', 'Ravi', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `channel`
--
ALTER TABLE `channel`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `channel`
--
ALTER TABLE `channel`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

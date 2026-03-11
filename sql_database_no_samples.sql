-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_e23152_e23021`
--

-- --------------------------------------------------------

--
-- Table structure for table `concenter`
--

CREATE TABLE `concenter` (
  `center_code` varchar(50) NOT NULL,
  `center_name` varchar(50) NOT NULL,
  `center_address` varchar(50) NOT NULL,
  `center_city` varchar(50) NOT NULL,
  `center_phone` bigint(10) NOT NULL,
  `center_email` varchar(50) NOT NULL,
  `center_services` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `conroom`
--

CREATE TABLE `conroom` (
  `room_code` varchar(50) NOT NULL,
  `room_name` varchar(50) NOT NULL,
  `room_maxCapacity` int(11) NOT NULL,
  `room_eidosKathismatwn` varchar(50) NOT NULL,
  `room_ejoplismos` varchar(50) NOT NULL,
  `room_wifi` tinyint(1) NOT NULL,
  `room_timh` double NOT NULL,
  `room_availability` tinyint(1) NOT NULL,
  `center_code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_onoma` varchar(50) NOT NULL,
  `cus_email` varchar(50) NOT NULL,
  `cus_phone` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pay_poso` double DEFAULT NULL,
  `pay_methodos` varchar(50) DEFAULT NULL,
  `pay_hmeromhnia` datetime DEFAULT NULL,
  `pay_katastash` varchar(50) DEFAULT NULL,
  `res_code` varchar(50) DEFAULT NULL,
  `cus_onoma` varchar(50) DEFAULT NULL,
  `pay_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reservesion`
--

CREATE TABLE `reservesion` (
  `res_code` varchar(50) NOT NULL,
  `res_resCity` varchar(50) NOT NULL,
  `res_hmerominia` date NOT NULL,
  `res_summetexontes` int(11) DEFAULT NULL,
  `res_protimiseisEjoplismou` varchar(50) DEFAULT NULL,
  `res_timologio` tinyint(1) DEFAULT NULL,
  `res_akurosi` tinyint(1) DEFAULT NULL,
  `room_code` varchar(50) DEFAULT NULL,
  `cus_onoma` varchar(50) NOT NULL,
  `center_code` varchar(50) DEFAULT NULL,
  `pay_code` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `concenter`
--
ALTER TABLE `concenter`
  ADD PRIMARY KEY (`center_code`);

--
-- Indexes for table `conroom`
--
ALTER TABLE `conroom`
  ADD PRIMARY KEY (`room_code`,`center_code`),
  ADD KEY `center_code` (`center_code`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_onoma`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pay_code`),
  ADD UNIQUE KEY `Payment_Reservesion_IDX` (`res_code`,`cus_onoma`),
  ADD UNIQUE KEY `Payment_PayCode_IDX` (`pay_code`);

--
-- Indexes for table `reservesion`
--
ALTER TABLE `reservesion`
  ADD PRIMARY KEY (`res_code`,`cus_onoma`),
  ADD KEY `room_code` (`room_code`,`center_code`),
  ADD KEY `cus_onoma` (`cus_onoma`),
  ADD KEY `reservesion_ibfk_3` (`pay_code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `pay_code` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `conroom`
--
ALTER TABLE `conroom`
  ADD CONSTRAINT `conroom_ibfk_1` FOREIGN KEY (`center_code`) REFERENCES `concenter` (`center_code`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `Payment_Reservesion_FK` FOREIGN KEY (`res_code`,`cus_onoma`) REFERENCES `reservesion` (`res_code`, `cus_onoma`);

--
-- Constraints for table `reservesion`
--
ALTER TABLE `reservesion`
  ADD CONSTRAINT `reservesion_ibfk_1` FOREIGN KEY (`room_code`,`center_code`) REFERENCES `conroom` (`room_code`, `center_code`),
  ADD CONSTRAINT `reservesion_ibfk_2` FOREIGN KEY (`cus_onoma`) REFERENCES `customer` (`cus_onoma`),
  ADD CONSTRAINT `reservesion_ibfk_3` FOREIGN KEY (`pay_code`) REFERENCES `payment` (`pay_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
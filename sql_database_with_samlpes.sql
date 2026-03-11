-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 19 Μάη 2025 στις 15:21:34
-- Έκδοση διακομιστή: 10.4.32-MariaDB
-- Έκδοση PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `e23021_e23152_teliko`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `concenter`
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

--
-- Άδειασμα δεδομένων του πίνακα `concenter`
--

INSERT INTO `concenter` (`center_code`, `center_name`, `center_address`, `center_city`, `center_phone`, `center_email`, `center_services`) VALUES
('ATH_001', 'Athens International Conference Center', 'Leof. Syggrou 245', 'Athens', 2101234001, 'events@gmail.gr', 'Conferences, Exhibitions, Catering'),
('CRT_003', 'Cretan Elite Conference Resort', 'Akti Koundourou 7', 'Heraklion', 2810345603, 'reservations@outlook.com', 'Luxury Meetings, Team Building, Spa'),
('PAT_004', 'Patras Business Hub', 'Maizonos 42', 'Patras', 2610789004, 'info@hotmail.gr', 'Workshops, Networking, Coffee Bar'),
('THS_002', 'Thessaloniki Seaside Events', 'Nikis Avenue 15', 'Thessaloniki', 2310555002, 'bookings@hotmail.gr', 'Meetings, Galas, AV Equipment'),
('VOL_005', 'Volos Tech Park', 'Iasonos 88', 'Volos', 2421067005, 'tech@gmail.gr', 'IT Conferences, Hackathons, High-Speed WiFi');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `conroom`
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

--
-- Άδειασμα δεδομένων του πίνακα `conroom`
--

INSERT INTO `conroom` (`room_code`, `room_name`, `room_maxCapacity`, `room_eidosKathismatwn`, `room_ejoplismos`, `room_wifi`, `room_timh`, `room_availability`, `center_code`) VALUES
('ATH_HALL1', 'Grand Ballroom', 500, 'Theater', 'Projector, Microphones, Stage', 1, 1200, 1, 'ATH_001'),
('ATH_HALL2', 'Skyview Room', 100, 'Theater', 'Projector, Sound System, Lighting', 1, 600, 1, 'ATH_001'),
('ATH_MTG1', 'Boardroom', 12, 'Boardroom', 'Conference Phone, Screen', 1, 200, 1, 'ATH_001'),
('CRT_CONF2', 'Innovation Hub', 25, 'Roundtable', 'Interactive Board, Webcam', 1, 350, 1, 'CRT_003'),
('CRT_VIP1', 'Executive Lounge', 15, 'Roundtable', 'Smart TV, Mini Bar', 1, 800, 1, 'CRT_003'),
('PAT_ECO1', 'Basic Meeting Room', 20, 'U-Shape', 'Flipchart, TV', 1, 150, 1, 'PAT_004'),
('PAT_LAB2', 'Training Room', 40, 'Classroom', 'Computers, Whiteboard, Projector', 1, 250, 1, 'PAT_004'),
('THS_LAB1', 'Tech Workshop Room', 30, 'Classroom', 'Computers, Whiteboards', 1, 300, 1, 'THS_002'),
('VOL_HACK1', 'Coding Arena', 50, 'Cabaret', 'Power Outlets, Fast WiFi', 1, 400, 1, 'VOL_005');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customer`
--

CREATE TABLE `customer` (
  `cus_onoma` varchar(50) NOT NULL,
  `cus_email` varchar(50) NOT NULL,
  `cus_phone` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `customer`
--

INSERT INTO `customer` (`cus_onoma`, `cus_email`, `cus_phone`) VALUES
('dionisisp', 'dionisisp@gmail.com', 6999888777),
('giorgosk', 'giorgos@gmail.com', 6944123456),
('mariax', 'maria.x@outlook.com', 6955112233),
('stavros99', 'stavros_99@hotmail.com', 6988776655),
('vicky12', 'vicky12@outlook.com', 6977334455);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `payment`
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

--
-- Άδειασμα δεδομένων του πίνακα `payment`
--

INSERT INTO `payment` (`pay_poso`, `pay_methodos`, `pay_hmeromhnia`, `pay_katastash`, `res_code`, `cus_onoma`, `pay_code`) VALUES
(400, 'Card', '2025-04-20 10:00:00', 'completed', 'res001', 'giorgosk', 1),
(200, 'Cash', '2025-05-01 11:30:00', 'pending', 'res002', 'mariax', 2),
(600, 'Card', '2025-05-15 12:15:00', 'completed', 'res003', 'stavros99', 3),
(150, 'Card', '2025-05-09 09:00:00', 'completed', 'res004', 'vicky12', 4),
(300, 'Cash', '2025-05-28 16:00:00', 'pending', 'res005', 'dionisisp', 5),
(550, 'Card', '2024-12-01 14:30:00', 'completed', 'res006', 'mariax', 6),
(800, 'Cash', '2025-01-10 17:00:00', 'completed', 'res007', 'vicky12', 7),
(250, 'Card', '2025-06-01 13:45:00', 'completed', 'res008', 'giorgosk', 8);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `reservesion`
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
-- Άδειασμα δεδομένων του πίνακα `reservesion`
--

INSERT INTO `reservesion` (`res_code`, `res_resCity`, `res_hmerominia`, `res_summetexontes`, `res_protimiseisEjoplismou`, `res_timologio`, `res_akurosi`, `room_code`, `cus_onoma`, `center_code`, `pay_code`) VALUES
('res001', 'Athens', '2025-04-25', 50, 'Projector, WiFi', 1, 0, 'ATH_HALL1', 'giorgosk', 'ATH_001', 1),
('res002', 'Heraklion', '2025-05-10', 20, 'Interactive Board', 0, 0, 'CRT_CONF2', 'mariax', 'CRT_003', 2),
('res003', 'Thessaloniki', '2025-05-15', 30, 'Computers, Whiteboards', 1, 0, 'THS_LAB1', 'stavros99', 'THS_002', 3),
('res004', 'Patras', '2025-05-25', 15, 'TV, Flipchart', 0, 0, 'PAT_ECO1', 'vicky12', 'PAT_004', 4),
('res005', 'Volos', '2025-05-30', 40, 'Fast WiFi', 1, 0, 'VOL_HACK1', 'dionisisp', 'VOL_005', 5),
('res006', 'Athens', '2024-12-15', 10, 'Stage, Microphones', 1, 0, 'ATH_HALL2', 'mariax', 'ATH_001', 6),
('res007', 'Heraklion', '2025-01-20', 25, 'Mini Bar', 0, 0, 'CRT_VIP1', 'vicky12', 'CRT_003', 7),
('res008', 'Patras', '2025-06-10', 35, 'Whiteboard, Projector', 1, 0, 'PAT_LAB2', 'giorgosk', 'PAT_004', 8);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `concenter`
--
ALTER TABLE `concenter`
  ADD PRIMARY KEY (`center_code`);

--
-- Ευρετήρια για πίνακα `conroom`
--
ALTER TABLE `conroom`
  ADD PRIMARY KEY (`room_code`,`center_code`),
  ADD KEY `center_code` (`center_code`);

--
-- Ευρετήρια για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_onoma`);

--
-- Ευρετήρια για πίνακα `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pay_code`),
  ADD UNIQUE KEY `Payment_PayCode_IDX` (`pay_code`),
  ADD UNIQUE KEY `Payment_Reservesion_IDX` (`res_code`,`cus_onoma`);

--
-- Ευρετήρια για πίνακα `reservesion`
--
ALTER TABLE `reservesion`
  ADD PRIMARY KEY (`res_code`,`cus_onoma`),
  ADD KEY `room_code` (`room_code`,`center_code`),
  ADD KEY `cus_onoma` (`cus_onoma`),
  ADD KEY `reservesion_ibfk_3` (`pay_code`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `payment`
--
ALTER TABLE `payment`
  MODIFY `pay_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `conroom`
--
ALTER TABLE `conroom`
  ADD CONSTRAINT `conroom_ibfk_1` FOREIGN KEY (`center_code`) REFERENCES `concenter` (`center_code`);

--
-- Περιορισμοί για πίνακα `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `Payment_Reservesion_FK` FOREIGN KEY (`res_code`,`cus_onoma`) REFERENCES `reservesion` (`res_code`, `cus_onoma`);

--
-- Περιορισμοί για πίνακα `reservesion`
--
ALTER TABLE `reservesion`
  ADD CONSTRAINT `reservesion_ibfk_1` FOREIGN KEY (`room_code`,`center_code`) REFERENCES `conroom` (`room_code`, `center_code`),
  ADD CONSTRAINT `reservesion_ibfk_2` FOREIGN KEY (`cus_onoma`) REFERENCES `customer` (`cus_onoma`),
  ADD CONSTRAINT `reservesion_ibfk_3` FOREIGN KEY (`pay_code`) REFERENCES `payment` (`pay_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

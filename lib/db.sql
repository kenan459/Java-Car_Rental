-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for car_rental
CREATE DATABASE IF NOT EXISTS `car_rental` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `car_rental`;

-- Dumping structure for table car_rental.rentals
CREATE TABLE IF NOT EXISTS `rentals` (
  `rental_id` int(128) NOT NULL AUTO_INCREMENT,
  `vehicle_ID` int(128) DEFAULT NULL,
  `vehicle_name` varchar(50) DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `rental_days` int(11) DEFAULT NULL,
  `rental_amountPaid` double DEFAULT NULL,
  `payment_method` varchar(50) DEFAULT NULL,
  `rental_date` datetime DEFAULT NULL,
  `rental_returnedDate` datetime DEFAULT NULL,
  `rental_status` int(11) DEFAULT 1,
  PRIMARY KEY (`rental_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci CHECKSUM=1;

-- Dumping data for table car_rental.rentals: ~0 rows (approximately)
INSERT INTO `rentals` (`rental_id`, `vehicle_ID`, `vehicle_name`, `customer_name`, `rental_days`, `rental_amountPaid`, `payment_method`, `rental_date`, `rental_returnedDate`, `rental_status`) VALUES
	(28, 6, 'Toyota Wigo', 'George', 7, 10500, 'Gcash', '2024-10-27 16:11:26', NULL, 1);

-- Dumping structure for table car_rental.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_role` varchar(50) DEFAULT 'user',
  `user_status` varchar(50) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_rental.users: ~3 rows (approximately)
INSERT INTO `users` (`user_id`, `username`, `password`, `user_role`, `user_status`) VALUES
	(1, 'admin', 'admin', 'admin', '1'),
	(2, 'user', 'user', 'user', '1');

-- Dumping structure for table car_rental.vehicles
CREATE TABLE IF NOT EXISTS `vehicles` (
  `Vehicle_ID` int(128) NOT NULL AUTO_INCREMENT,
  `Vehicle_Make` varchar(50) NOT NULL DEFAULT '',
  `Vehicle_Model` varchar(50) NOT NULL DEFAULT '',
  `Vehicle_Year` varchar(50) DEFAULT NULL,
  `Vehicle_Rate` varchar(50) NOT NULL DEFAULT '',
  `Vehicle_Status` varchar(50) NOT NULL DEFAULT '1',
  `Available_From` date DEFAULT NULL,
  `Available_To` date DEFAULT NULL,
  PRIMARY KEY (`Vehicle_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table car_rental.vehicles: ~7 rows (approximately)
INSERT INTO `vehicles` (`Vehicle_ID`, `Vehicle_Make`, `Vehicle_Model`, `Vehicle_Year`, `Vehicle_Rate`, `Vehicle_Status`, `Available_From`, `Available_To`) VALUES
	(1, 'Toyota', 'Vios', '2023', '1500', '1', '2024-10-28', '2024-11-03'),
	(2, 'Mitsubishi', 'Xpander', '2021', '2000', '1', '2024-11-04', '2025-01-01'),
	(3, 'Toyota', 'Innova', '2021', '2400', '1', '2024-10-28', '2025-01-01'),
	(6, 'Toyota', 'Wigo', '2022', '1500', '0', NULL, '2025-01-01'),
	(7, 'Honda	', 'Accord', '2020', '2000', '1', '2024-10-28', '2025-01-01'),
	(8, 'Mazda', 'CX-5', '2021', '2700', '1', '2024-11-28', '2025-01-01'),
	(11, 'Honda', 'Civic', '2021', '1800', '1', '2024-11-04', '2025-01-01');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

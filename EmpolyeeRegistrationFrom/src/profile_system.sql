CREATE DATABASE `profile_system`;

CREATE TABLE `employees` (
  `id` int NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
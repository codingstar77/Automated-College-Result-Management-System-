-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2017 at 07:39 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `result`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `dept` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `dept`) VALUES
(1, 'kd', 'kd', 'comp'),
(2, 'it', 'it', 'it');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(11) NOT NULL,
  `exam_name` varchar(30) NOT NULL,
  `branch` varchar(30) NOT NULL,
  `year` varchar(30) NOT NULL,
  `sem` int(11) NOT NULL,
  `batch` varchar(30) NOT NULL,
  `insem_max` int(11) DEFAULT NULL,
  `endsem_max` int(11) DEFAULT NULL,
  `prac_max` int(11) DEFAULT NULL,
  `tw_max` int(11) DEFAULT NULL,
  `oral_max` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id`, `exam_name`, `branch`, `year`, `sem`, `batch`, `insem_max`, `endsem_max`, `prac_max`, `tw_max`, `oral_max`) VALUES
(1, 'April May 2017', 'COMP', 'SE', 2, '2019', 50, 50, 50, 50, 0),
(4, 'Nov Dec 2016', 'COMP', 'SE', 1, '2019', 50, 50, 50, 25, 0);

-- --------------------------------------------------------

--
-- Table structure for table `result_t`
--

CREATE TABLE `result_t` (
  `id` int(11) NOT NULL,
  `sub_code` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `stu_id` varchar(30) NOT NULL,
  `insem` int(11) NOT NULL,
  `endsem` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `practical` int(11) NOT NULL,
  `term_work` int(11) NOT NULL,
  `oral` int(11) DEFAULT NULL,
  `grade` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sgpa_t`
--

CREATE TABLE `sgpa_t` (
  `id` int(11) NOT NULL,
  `stu_id` varchar(30) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `batch` year(4) DEFAULT NULL,
  `sgpa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stud_id` int(11) NOT NULL,
  `prn` varchar(30) DEFAULT NULL,
  `roll_no` int(11) DEFAULT NULL,
  `uni_roll` varchar(30) DEFAULT NULL,
  `stud_name` varchar(100) DEFAULT NULL,
  `division` varchar(30) DEFAULT NULL,
  `year` varchar(30) DEFAULT NULL,
  `branch` varchar(30) DEFAULT NULL,
  `batch` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `sub_id` int(11) NOT NULL,
  `sub_code` int(11) DEFAULT NULL,
  `sub_name` varchar(200) DEFAULT NULL,
  `year` varchar(200) DEFAULT NULL,
  `branch` varchar(200) DEFAULT NULL,
  `batch` varchar(200) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL,
  `t_name` varchar(100) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  `year` varchar(30) DEFAULT NULL,
  `branch` varchar(30) DEFAULT NULL,
  `sem` int(11) DEFAULT NULL,
  `division` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `result_t`
--
ALTER TABLE `result_t`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sub_code` (`sub_code`),
  ADD KEY `exam_id` (`exam_id`),
  ADD KEY `stu_id` (`stu_id`),
  ADD KEY `insem` (`insem`),
  ADD KEY `endsem` (`endsem`),
  ADD KEY `practical` (`practical`),
  ADD KEY `practical_2` (`practical`),
  ADD KEY `practical_3` (`practical`),
  ADD KEY `term_work` (`term_work`),
  ADD KEY `grade` (`grade`),
  ADD KEY `oral` (`oral`),
  ADD KEY `sub_code_2` (`sub_code`),
  ADD KEY `exam_id_2` (`exam_id`),
  ADD KEY `stu_id_2` (`stu_id`);

--
-- Indexes for table `sgpa_t`
--
ALTER TABLE `sgpa_t`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stu_id` (`stu_id`),
  ADD KEY `exam_id` (`exam_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stud_id`),
  ADD UNIQUE KEY `uni_roll` (`uni_roll`),
  ADD KEY `uni_roll_2` (`uni_roll`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`sub_id`),
  ADD UNIQUE KEY `sub_code` (`sub_code`),
  ADD KEY `sub_code_2` (`sub_code`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`t_id`),
  ADD UNIQUE KEY `sub_id_2` (`sub_id`),
  ADD UNIQUE KEY `sub_id_3` (`sub_id`),
  ADD KEY `sub_id` (`sub_id`),
  ADD KEY `sub_id_4` (`sub_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `result_t`
--
ALTER TABLE `result_t`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3001;
--
-- AUTO_INCREMENT for table `sgpa_t`
--
ALTER TABLE `sgpa_t`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `stud_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=301;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `sub_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=173;
--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `result_t`
--
ALTER TABLE `result_t`
  ADD CONSTRAINT `result_t_ibfk_1` FOREIGN KEY (`sub_code`) REFERENCES `subject` (`sub_code`) ON UPDATE CASCADE,
  ADD CONSTRAINT `result_t_ibfk_2` FOREIGN KEY (`stu_id`) REFERENCES `student` (`uni_roll`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `result_t_ibfk_3` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sgpa_t`
--
ALTER TABLE `sgpa_t`
  ADD CONSTRAINT `sgpa_t_ibfk_1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sgpa_t_ibfk_2` FOREIGN KEY (`stu_id`) REFERENCES `student` (`uni_roll`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_code`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

# EmpoloyeeManagement

Mysql Username :-root 
Mysql password :-admin
Mysql Queries:-
---------------
create database h_project;
use h_project;

DROP TABLE IF EXISTS `address_details`;

CREATE TABLE `address_details` (
  `emp_id` int(11) NOT NULL,
  `phone_no` varchar(128) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `employee_details`;
CREATE TABLE `employee_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(100) DEFAULT NULL,
  `date_of_joining` varchar(100) DEFAULT NULL,
  `employee_status` varchar(100) DEFAULT NULL,
  `time_stamp` timestamp(6) NULL DEFAULT NULL,
  `employee_details_emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`employee_details_emp_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`employee_details_emp_id`) REFERENCES `address_details` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

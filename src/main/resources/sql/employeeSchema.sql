DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(30) NOT NULL,
    `employee_number` VARCHAR(7) NOT NULL,
    `department` INT NOT NULL,
    `welfare_point` INT NOT NULL DEFAULT 0,
    `work_status` VARCHAR(10) NOT NULL,
    `entry_date` DATE NOT NULL
);
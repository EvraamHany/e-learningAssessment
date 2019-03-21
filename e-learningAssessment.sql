CREATE SCHEMA `assignment` ;

CREATE TABLE `assignment`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `assignment`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `publish_date` DATETIME NOT NULL,
  `last_update` DATETIME NOT NULL,
  `total_hours` INT NOT NULL,
  `instructor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `assignment`.`course_registration` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `course_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  PRIMARY KEY (`id`));


ALTER TABLE `assignment`.`course_registration` 
ADD INDEX `course_id_fk_idx` (`course_id` ASC);
ALTER TABLE `assignment`.`course_registration` 
ADD CONSTRAINT `course_id_fk`
  FOREIGN KEY (`course_id`)
  REFERENCES `assignment`.`course` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `assignment`.`course_registration` 
ADD INDEX `student_id_fk_idx` (`student_id` ASC);
ALTER TABLE `assignment`.`course_registration` 
ADD CONSTRAINT `student_id_fk`
  FOREIGN KEY (`student_id`)
  REFERENCES `assignment`.`student` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

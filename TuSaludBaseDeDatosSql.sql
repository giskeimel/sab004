﻿-- MySQL Script generated by MySQL Workbench
-- 01/18/19 09:58:59
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TuSalud
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TuSalud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TuSalud` DEFAULT CHARACTER SET utf8 ;
USE `TuSalud` ;

-- -----------------------------------------------------
-- Table `TuSalud`.`Cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Cuenta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Direccion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `calle` VARCHAR(45) NOT NULL,
  `piso` INT NULL,
  `departamento` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Lugar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Lugar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `id_Direccion` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Lugar_Direccion1_idx` (`id_Direccion` ASC),
  CONSTRAINT `fk_Lugar_Direccion1`
    FOREIGN KEY (`id_Direccion`)
    REFERENCES `TuSalud`.`Direccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `historia_clinica` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_Lugar` INT NOT NULL,
  `id_Direccion` INT NULL,
  `id_Cuenta` INT NOT NULL,
  `observaciones` VARCHAR(1024) NULL,
  INDEX `fk_Pasiente_Lugar1_idx` (`id_Lugar` ASC),
  INDEX `fk_Pasiente_Direccion1_idx` (`id_Direccion` ASC),
  INDEX `fk_Pasiente_Usuario1_idx` (`id_Cuenta` ASC),
  UNIQUE INDEX `historia_clinica_UNIQUE` (`historia_clinica` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Pasiente_Lugar1`
    FOREIGN KEY (`id_Lugar`)
    REFERENCES `TuSalud`.`Lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pasiente_Direccion1`
    FOREIGN KEY (`id_Direccion`)
    REFERENCES `TuSalud`.`Direccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pasiente_Usuario1`
    FOREIGN KEY (`id_Cuenta`)
    REFERENCES `TuSalud`.`Cuenta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Familiar_a_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Familiar_a_cargo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `id_Paciente` INT NOT NULL,
  `mi_historia_clinica` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Familiar_a_cargo_Pasiente1_idx` (`id_Paciente` ASC),
  INDEX `fk_Familiar_a_cargo_Paciente2_idx` (`mi_historia_clinica` ASC),
  CONSTRAINT `fk_Familiar_a_cargo_Paciente1`
    FOREIGN KEY (`id_Paciente`)
    REFERENCES `TuSalud`.`Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Familiar_a_cargo_Paciente2`
    FOREIGN KEY (`mi_historia_clinica`)
    REFERENCES `TuSalud`.`Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `TuSalud`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Empleado` (
  `id` INT  AUTO_INCREMENT NOT NULL,
  `legajo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_Cuenta` INT NOT NULL,
  `id_Direccion` INT NULL,
  `id_Lugar` INT NOT NULL,
  INDEX `fk_Empleado_Usuario1_idx` (`id_Cuenta` ASC),
  INDEX `fk_Empleado_Direccion1_idx` (`id_Direccion` ASC),
  INDEX `fk_Empleado_Lugar1_idx` (`id_Lugar` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Empleado_Usuario1`
    FOREIGN KEY (`id_Cuenta`)
    REFERENCES `TuSalud`.`Cuenta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Direccion1`
    FOREIGN KEY (`id_Direccion`)
    REFERENCES `TuSalud`.`Direccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Lugar1`
    FOREIGN KEY (`id_Lugar`)
    REFERENCES `TuSalud`.`Lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Turno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `libre` BIT(1) NOT NULL,
  `id_Lugar` INT NOT NULL,
  `id_Especialidad` INT NOT NULL,
  `id_Paciente` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Turno_Lugar1_idx` (`id_Lugar` ASC),
  INDEX `fk_Turno_Especialidad1_idx` (`id_Especialidad` ASC),
  INDEX `fk_Turno_Pasiente1_idx` (`id_Paciente` ASC),
  CONSTRAINT `fk_Turno_Lugar1`
    FOREIGN KEY (`id_Lugar`)
    REFERENCES `TuSalud`.`Lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turno_Especialidad1`
    FOREIGN KEY (`id_Especialidad`)
    REFERENCES `TuSalud`.`Especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turno_Pasiente1`
    FOREIGN KEY (`id_Paciente`)
    REFERENCES `TuSalud`.`Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Derivacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Derivacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `aprobado` BIT(1) NOT NULL,
  `id_Especialidad` INT NOT NULL,
  `id_Paciente` INT NOT NULL,
  INDEX `fk_Derivacion_Especialidad1_idx` (`id_Especialidad` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_Derivacion_Paciente1_idx` (`id_Paciente` ASC),
  CONSTRAINT `fk_Derivacion_Especialidad1`
    FOREIGN KEY (`id_Especialidad`)
    REFERENCES `TuSalud`.`Especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Derivacion_Paciente1`
    FOREIGN KEY (`id_Paciente`)
    REFERENCES `TuSalud`.`Paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Lugar_nn_Especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Lugar_nn_Especialidad` (
  `id_Lugar` INT NOT NULL,
  `id_Especialidad` INT NOT NULL,
  PRIMARY KEY (`id_Lugar`, `id_Especialidad`),
  INDEX `fk_Lugar_has_Especialidad_Especialidad1_idx` (`id_Especialidad` ASC),
  INDEX `fk_Lugar_has_Especialidad_Lugar1_idx` (`id_Lugar` ASC),
  CONSTRAINT `fk_Lugar_has_Especialidad_Lugar1`
    FOREIGN KEY (`id_Lugar`)
    REFERENCES `TuSalud`.`Lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lugar_has_Especialidad_Especialidad1`
    FOREIGN KEY (`id_Especialidad`)
    REFERENCES `TuSalud`.`Especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Profesional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Profesional` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `id_Especialidad` INT NOT NULL,
  INDEX `fk_Profesional_Especialidad1_idx` (`id_Especialidad` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Profesional_Especialidad1`
    FOREIGN KEY (`id_Especialidad`)
    REFERENCES `TuSalud`.`Especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`Turno_has_Profesional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`Turno_nn_Profesional` (
  `Turno_id` INT NOT NULL,
  `Profesional_id` INT NOT NULL,
  PRIMARY KEY (`Turno_id`, `Profesional_id`),
  INDEX `fk_Turno_has_Profesional_Profesional1_idx` (`Profesional_id` ASC),
  INDEX `fk_Turno_has_Profesional_Turno1_idx` (`Turno_id` ASC),
  CONSTRAINT `fk_Turno_has_Profesional_Turno1`
    FOREIGN KEY (`Turno_id`)
    REFERENCES `TuSalud`.`Turno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Turno_has_Profesional_Profesional1`
    FOREIGN KEY (`Profesional_id`)
    REFERENCES `TuSalud`.`Profesional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


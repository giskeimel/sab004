
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
-- Table `TuSalud`.`cuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`cuenta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`direccion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` INT NOT NULL,
  `calle` VARCHAR(45) NOT NULL,
  `piso` INT NULL,
  `departamento` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`lugar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`lugar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `id_direccion` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lugar_direccion1_idx` (`id_direccion` ASC),
  CONSTRAINT `fk_lugar_direccion1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `TuSalud`.`direccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`paciente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `historia_clinica` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_lugar` INT NOT NULL,
  `id_direccion` INT NULL,
  `id_cuenta` INT NOT NULL,
  `observaciones` VARCHAR(1024) NULL,
  INDEX `fk_paciente_lugar1_idx` (`id_lugar` ASC),
  INDEX `fk_paciente_direccion1_idx` (`id_direccion` ASC),
  INDEX `fk_paciente_usuario1_idx` (`id_cuenta` ASC),
  UNIQUE INDEX `historia_clinica_UNIQUE` (`historia_clinica` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_paciente_lugar1`
    FOREIGN KEY (`id_lugar`)
    REFERENCES `TuSalud`.`lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_direccion1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `TuSalud`.`direccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_usuario1`
    FOREIGN KEY (`id_cuenta`)
    REFERENCES `TuSalud`.`cuenta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`familiar_a_cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`familiar_a_cargo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `id_paciente` INT NOT NULL,
  `mi_historia_clinica` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_familiar_a_cargo_paciente1_idx` (`id_paciente` ASC),
  INDEX `fk_familiar_a_cargo_paciente2_idx` (`mi_historia_clinica` ASC),
  CONSTRAINT `fk_familiar_a_cargo_paciente1`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `TuSalud`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_familiar_a_cargo_paciente2`
    FOREIGN KEY (`mi_historia_clinica`)
    REFERENCES `TuSalud`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`especialidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `TuSalud`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`empleado` (
  `id` INT  AUTO_INCREMENT NOT NULL,
  `legajo` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `id_cuenta` INT NOT NULL,
  `id_direccion` INT NULL,
  `id_lugar` INT NOT NULL,
  INDEX `fk_empleado_usuario1_idx` (`id_cuenta` ASC),
  INDEX `fk_empleado_direccion1_idx` (`id_direccion` ASC),
  INDEX `fk_empleado_lugar1_idx` (`id_lugar` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_empleado_usuario1`
    FOREIGN KEY (`id_cuenta`)
    REFERENCES `TuSalud`.`cuenta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_direccion1`
    FOREIGN KEY (`id_direccion`)
    REFERENCES `TuSalud`.`direccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_lugar1`
    FOREIGN KEY (`id_lugar`)
    REFERENCES `TuSalud`.`lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

alter table empleado add column telefono long not null;

-- -----------------------------------------------------
-- Table `TuSalud`.`turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`turno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `libre` BIT(1) NOT NULL,
  `id_lugar` INT NOT NULL,
  `id_especialidad` INT NOT NULL,
  `id_paciente` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_turno_lugar1_idx` (`id_lugar` ASC),
  INDEX `fk_turno_especialidad1_idx` (`id_especialidad` ASC),
  INDEX `fk_turno_paciente1_idx` (`id_paciente` ASC),
  CONSTRAINT `fk_turno_lugar1`
    FOREIGN KEY (`id_lugar`)
    REFERENCES `TuSalud`.`lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turno_especialidad1`
    FOREIGN KEY (`id_especialidad`)
    REFERENCES `TuSalud`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turno_paciente1`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `TuSalud`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

alter table turno add column id_derivacion int;
alter table turno add CONSTRAINT fk_turno_derivacion1
FOREIGN KEY (id_derivacion)
REFERENCES TuSalud.derivacion (id);

alter table turno add column id_profesional int;
alter table turno add CONSTRAINT fk_turno_profesional1
FOREIGN KEY (id_profesional)
REFERENCES TuSalud.profesional (id);

alter table turno add column alta bit(1) not null;

-- -----------------------------------------------------
-- Table `TuSalud`.`derivacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`derivacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `aprobado` BIT(1) NOT NULL,
  `id_especialidad` INT NOT NULL,
  `id_paciente` INT NOT NULL,
  INDEX `fk_derivacion_especialidad1_idx` (`id_especialidad` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_derivacion_paciente1_idx` (`id_paciente` ASC),
  CONSTRAINT `fk_derivacion_especialidad1`
    FOREIGN KEY (`id_especialidad`)
    REFERENCES `TuSalud`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_derivacion_paciente1`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `TuSalud`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`lugar_nn_especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`lugar_nn_especialidad` (
  `id_lugar` INT NOT NULL,
  `id_especialidad` INT NOT NULL,
  PRIMARY KEY (`id_lugar`, `id_especialidad`),
  INDEX `fk_lugar_has_especialidad_especialidad1_idx` (`id_especialidad` ASC),
  INDEX `fk_lugar_has_especialidad_lugar1_idx` (`id_lugar` ASC),
  CONSTRAINT `fk_lugar_has_especialidad_lugar1`
    FOREIGN KEY (`id_lugar`)
    REFERENCES `TuSalud`.`lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lugar_has_especialidad_especialidad1`
    FOREIGN KEY (`id_especialidad`)
    REFERENCES `TuSalud`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TuSalud`.`profesional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`profesional` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `id_especialidad` INT NOT NULL,
  INDEX `fk_profesional_especialidad1_idx` (`id_especialidad` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_profesional_especialidad1`
    FOREIGN KEY (`id_especialidad`)
    REFERENCES `TuSalud`.`especialidad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

alter table profesional add column telefono int;
alter table profesional add column email VARCHAR(45);

alter table profesional add column id_direccion int;
alter table profesional add CONSTRAINT fk_profesional_direccion1
FOREIGN KEY (id_direccion)
REFERENCES TuSalud.direccion (id);

alter table profesional add column id_cuenta int;
alter table profesional add CONSTRAINT fk_profesional_cuenta1
FOREIGN KEY (id_cuenta)
REFERENCES TuSalud.cuenta (id);

alter table profesional add column id_lugar int not null;
alter table profesional add CONSTRAINT fk_profesional_lugar1
FOREIGN KEY (id_lugar)
REFERENCES TuSalud.lugar (id);
-- -----------------------------------------------------
-- Table `TuSalud`.`turno_has_profesional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TuSalud`.`turno_nn_profesional` (
  `turno_id` INT NOT NULL,
  `profesional_id` INT NOT NULL,
  PRIMARY KEY (`turno_id`, `profesional_id`),
  INDEX `fk_turno_has_profesional_profesional1_idx` (`profesional_id` ASC),
  INDEX `fk_turno_has_profesional_turno1_idx` (`turno_id` ASC),
  CONSTRAINT `fk_turno_has_profesional_turno1`
    FOREIGN KEY (`turno_id`)
    REFERENCES `TuSalud`.`turno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turno_has_profesional_profesional1`
    FOREIGN KEY (`profesional_id`)
    REFERENCES `TuSalud`.`profesional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `TuSalud`.`notificacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fechaVigenciaInicial` DATE NOT NULL,
  `fechaVigenciaFinal` DATE NOT NULL,
  `mostrar` BOOLEAN NOT NULL,
  `texto` VARCHAR(200) NOT NULL,
  `id_paciente` INT,
  `id_lugar` INT,
  PRIMARY KEY (`id`),
  INDEX `fk_notificaciones_paciente1_idx` (`id_paciente` ASC),
  INDEX `fk_notificaciones_lugar1_idx` (`id_lugar` ASC),
  CONSTRAINT `fk_notificaciones_paciente1`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `TuSalud`.`paciente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notificaciones_lugar1`
    FOREIGN KEY (`id_lugar`)
    REFERENCES `TuSalud`.`lugar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


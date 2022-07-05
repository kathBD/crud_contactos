
CREATE SCHEMA IF NOT EXISTS `agenda` DEFAULT CHARACTER SET utf8 ;
USE `contacto` ;

-- -----------------------------------------------------
-- Table `contactos`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agenda`.`contacto` (
  `id_contacto` INT NOT NULL AUTO_INCREMENT,
  `cont_nombre` VARCHAR(45) NOT NULL,
  `cont_teléfono` VARCHAR(45) NULL,
  `cont_email` VARCHAR(45) NULL,
  `cont_fecha_nacimiento` DATE NULL,
  PRIMARY KEY (`id_contacto`),
  UNIQUE INDEX `id_contact_UNIQUE` (`id_contacto` ASC) VISIBLE,
  UNIQUE INDEX `cont_teléfono_UNIQUE` (`cont_teléfono` ASC) VISIBLE)
ENGINE = InnoDB;


INSERT INTO contacto (cont_nombre, cont_teléfono, cont_email, cont_fecha_nacimiento)
VALUES('Juan López', 312584789, 'lope_j@gmail.com', '1990-04-20');

INSERT INTO contacto (cont_nombre, cont_teléfono, cont_email, cont_fecha_nacimiento)
VALUES('María Conde', 6014785, 'M_conde@gmail.com', '1970-11-02');

INSERT INTO contacto (cont_nombre, cont_teléfono, cont_email, cont_fecha_nacimiento)
VALUES('Tsuki López', 25478111, 'tsuki@gmail.com', '2000-03-28');

INSERT INTO contacto (cont_nombre, cont_teléfono, cont_email, cont_fecha_nacimiento)
VALUES('Antonio Duarte', 320568741, 'tony258@gmail.com', '1960-07-11');

INSERT INTO contacto (cont_nombre, cont_teléfono, cont_email, cont_fecha_nacimiento)
VALUES('Dilcia García', 31023569877, 'D.loGarcia@gmail.com', '1955-09-06');

INSERT INTO contacto (cont_nombre, cont_teléfono, cont_email, cont_fecha_nacimiento)
VALUES('Glenda López', 3165217845, 'yai_glen@gmail.com', '1985-11-18');

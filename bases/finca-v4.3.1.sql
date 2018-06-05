/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-log : Database - finca
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`finca` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `finca`;

/*Table structure for table `tbl_detalleenvio` */

DROP TABLE IF EXISTS `tbl_detalleenvio`;

CREATE TABLE `tbl_detalleenvio` (
  `idDetalleEnvio` int(11) NOT NULL AUTO_INCREMENT,
  `cantidadEnvios` int(11) NOT NULL,
  `idEnvios` int(11) NOT NULL COMMENT 'foranea',
  `idInsumo` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idDetalleEnvio`),
  KEY `fk_detalleenvio_envio` (`idEnvios`),
  KEY `fk_detalleenvio_insumo` (`idInsumo`),
  CONSTRAINT `fk_detalleenvio_envio` FOREIGN KEY (`idEnvios`) REFERENCES `tbl_envios` (`idEnvios`),
  CONSTRAINT `fk_detalleenvio_insumo` FOREIGN KEY (`idInsumo`) REFERENCES `tbl_insumos` (`idInsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_detalleenvio` */

insert  into `tbl_detalleenvio`(`idDetalleEnvio`,`cantidadEnvios`,`idEnvios`,`idInsumo`) values (1,5,4,1);

/*Table structure for table `tbl_envios` */

DROP TABLE IF EXISTS `tbl_envios`;

CREATE TABLE `tbl_envios` (
  `idEnvios` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(50) NOT NULL,
  `fechaEnvio` date NOT NULL,
  `nombreReceptor` varchar(100) NOT NULL,
  `idFinca` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idEnvios`),
  KEY `fk_envios_finca` (`idFinca`),
  CONSTRAINT `fk_envios_finca` FOREIGN KEY (`idFinca`) REFERENCES `tbl_finca` (`idFinca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_envios` */

insert  into `tbl_envios`(`idEnvios`,`nombre`,`fechaEnvio`,`nombreReceptor`,`idFinca`) values (1,'envio 1','2018-05-31','nombre 1',3);

/*Table structure for table `tbl_finca` */

DROP TABLE IF EXISTS `tbl_finca`;

CREATE TABLE `tbl_finca` (
  `idFinca` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `tipoFinca` varchar(50) NOT NULL,
  PRIMARY KEY (`idFinca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_finca` */

insert  into `tbl_finca`(`idFinca`,`nombre`,`direccion`,`tipoFinca`) values (1,'Finca 1','direccion 1','tipo finca 1');

/*Table structure for table `tbl_insumos` */

DROP TABLE IF EXISTS `tbl_insumos`;

CREATE TABLE `tbl_insumos` (
  `idInsumo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(50) NOT NULL,
  `medida` varchar(50) NOT NULL,
  `cantidad` double NOT NULL,
  `idTipoInsumo` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idInsumo`),
  KEY `fk_insumos_tipo` (`idTipoInsumo`),
  CONSTRAINT `fk_insumos_tipo` FOREIGN KEY (`idTipoInsumo`) REFERENCES `tbl_tipoinsumo` (`idTipoInsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_insumos` */

insert  into `tbl_insumos`(`idInsumo`,`nombre`,`medida`,`cantidad`,`idTipoInsumo`) values (1,'insumo 1','5',5,1);

/*Table structure for table `tbl_insumosutilizados` */

DROP TABLE IF EXISTS `tbl_insumosutilizados`;

CREATE TABLE `tbl_insumosutilizados` (
  `idInsumoUtilizados` int(11) NOT NULL AUTO_INCREMENT,
  `cantidadUtilizada` int(11) NOT NULL,
  `idInsumo` int(11) NOT NULL COMMENT 'foranea',
  `idTareaDiaria` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idInsumoUtilizados`),
  KEY `fk_insumosutilizados_tareadia` (`idTareaDiaria`),
  KEY `fk_insumosutilizados_insumo` (`idInsumo`),
  CONSTRAINT `fk_insumosutilizados_insumo` FOREIGN KEY (`idInsumo`) REFERENCES `tbl_insumos` (`idInsumo`),
  CONSTRAINT `fk_insumosutilizados_tareadia` FOREIGN KEY (`idTareaDiaria`) REFERENCES `tbl_tareadiaria` (`idTareaDiaria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_insumosutilizados` */

insert  into `tbl_insumosutilizados`(`idInsumoUtilizados`,`cantidadUtilizada`,`idInsumo`,`idTareaDiaria`) values (1,5,1,2),(2,6,1,2);

/*Table structure for table `tbl_inventario` */

DROP TABLE IF EXISTS `tbl_inventario`;

CREATE TABLE `tbl_inventario` (
  `idInventario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `estado` int(1) NOT NULL,
  `idFinca` int(11) NOT NULL COMMENT 'foranea',
  `idProveedor` int(11) NOT NULL COMMENT 'foranea',
  `idInsumo` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idInventario`),
  KEY `fk_inventario_finca` (`idFinca`),
  KEY `fk_inventario_proveedor` (`idProveedor`),
  KEY `fk_inventario_insumo` (`idInsumo`),
  CONSTRAINT `fk_inventario_finca` FOREIGN KEY (`idFinca`) REFERENCES `tbl_finca` (`idFinca`),
  CONSTRAINT `fk_inventario_insumo` FOREIGN KEY (`idInsumo`) REFERENCES `tbl_insumos` (`idInsumo`),
  CONSTRAINT `fk_inventario_proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `tbl_proveedor` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_inventario` */

insert  into `tbl_inventario`(`idInventario`,`cantidad`,`precio`,`estado`,`idFinca`,`idProveedor`,`idInsumo`) values (1,5,50,1,3,2,1);

/*Table structure for table `tbl_jornaleros` */

DROP TABLE IF EXISTS `tbl_jornaleros`;

CREATE TABLE `tbl_jornaleros` (
  `idJornaleros` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `edad` int(3) NOT NULL,
  `horario` varchar(10) NOT NULL,
  `estado` int(1) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `idPagos` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idJornaleros`),
  KEY `fk_jornaleros_pagos` (`idPagos`),
  CONSTRAINT `fk_jornaleros_pagos` FOREIGN KEY (`idPagos`) REFERENCES `tbl_pagos` (`idPagos`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_jornaleros` */

insert  into `tbl_jornaleros`(`idJornaleros`,`nombre`,`apellido`,`edad`,`horario`,`estado`,`direccion`,`idPagos`) values (1,'jornalero','apellido',20,'5',1,'direccion',10);

/*Table structure for table `tbl_pagos` */

DROP TABLE IF EXISTS `tbl_pagos`;

CREATE TABLE `tbl_pagos` (
  `idPagos` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `salarioDiario` double NOT NULL,
  PRIMARY KEY (`idPagos`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_pagos` */

insert  into `tbl_pagos`(`idPagos`,`salarioDiario`) values (1,100),(2,200),(3,300),(4,400),(5,500);

/*Table structure for table `tbl_proveedor` */

DROP TABLE IF EXISTS `tbl_proveedor`;

CREATE TABLE `tbl_proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(60) NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_proveedor` */

insert  into `tbl_proveedor`(`idProveedor`,`nombre`,`direccion`,`telefono`,`correo`) values (1,'Proveedor 1','direccion 1','5555-5555','correo@correo.com');

/*Table structure for table `tbl_rol` */

DROP TABLE IF EXISTS `tbl_rol`;

CREATE TABLE `tbl_rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(70) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_rol` */

insert  into `tbl_rol`(`idRol`,`nombre`) values (1,'Admin'),(2,'Secretaria'),(3,'Jornalero');

/*Table structure for table `tbl_tablones` */

DROP TABLE IF EXISTS `tbl_tablones`;

CREATE TABLE `tbl_tablones` (
  `idTablones` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(60) NOT NULL,
  `sector` varchar(30) NOT NULL,
  `idFinca` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idTablones`),
  KEY `fk_tablones_finca` (`idFinca`),
  CONSTRAINT `fk_tablones_finca` FOREIGN KEY (`idFinca`) REFERENCES `tbl_finca` (`idFinca`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_tablones` */

insert  into `tbl_tablones`(`idTablones`,`nombre`,`sector`,`idFinca`) values (1,'Tablon 1','sector 1',3);

/*Table structure for table `tbl_tareadiaria` */

DROP TABLE IF EXISTS `tbl_tareadiaria`;

CREATE TABLE `tbl_tareadiaria` (
  `idTareaDiaria` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `fecha` date NOT NULL,
  `estado` int(1) NOT NULL,
  `jornada` varchar(30) NOT NULL,
  `porcentajeRealizado` varchar(4) NOT NULL,
  `idTarea` int(11) NOT NULL COMMENT 'foranea',
  `idTablones` int(11) NOT NULL COMMENT 'foranea',
  `idJornalero` int(11) NOT NULL,
  PRIMARY KEY (`idTareaDiaria`),
  KEY `fk_tareadia_tarea` (`idTarea`),
  KEY `fk_tareadia_tablones` (`idTablones`),
  KEY `fk_tareadia_jornalero` (`idJornalero`),
  CONSTRAINT `fk_tareadia_jornalero` FOREIGN KEY (`idJornalero`) REFERENCES `tbl_jornaleros` (`idJornaleros`),
  CONSTRAINT `fk_tareadia_tablones` FOREIGN KEY (`idTablones`) REFERENCES `tbl_tablones` (`idTablones`),
  CONSTRAINT `fk_tareadia_tarea` FOREIGN KEY (`idTarea`) REFERENCES `tbl_tareas` (`idTarea`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_tareadiaria` */

insert  into `tbl_tareadiaria`(`idTareaDiaria`,`fecha`,`estado`,`jornada`,`porcentajeRealizado`,`idTarea`,`idTablones`,`idJornalero`) values (1,'2018-05-31',1,'fgh','50%',2,3,9);

/*Table structure for table `tbl_tareas` */

DROP TABLE IF EXISTS `tbl_tareas`;

CREATE TABLE `tbl_tareas` (
  `idTarea` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(30) NOT NULL,
  `tipoTarea` varchar(30) NOT NULL,
  PRIMARY KEY (`idTarea`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_tareas` */

insert  into `tbl_tareas`(`idTarea`,`nombre`,`tipoTarea`) values (1,'Tarea 1','Tipo 1');

/*Table structure for table `tbl_tipoinsumo` */

DROP TABLE IF EXISTS `tbl_tipoinsumo`;

CREATE TABLE `tbl_tipoinsumo` (
  `idTipoInsumo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoInsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_tipoinsumo` */

insert  into `tbl_tipoinsumo`(`idTipoInsumo`,`nombre`) values (1,'Trabajo'),(2,'Capital');

/*Table structure for table `tbl_usuario` */

DROP TABLE IF EXISTS `tbl_usuario`;

CREATE TABLE `tbl_usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary',
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nickname` varchar(15) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `edad` int(3) NOT NULL,
  `estado` int(1) NOT NULL,
  `correo` varchar(70) NOT NULL,
  `idRol` int(11) NOT NULL COMMENT 'foranea',
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usuario_rol` (`idRol`),
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`idRol`) REFERENCES `tbl_rol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_usuario` */

insert  into `tbl_usuario`(`idUsuario`,`nombre`,`apellido`,`nickname`,`pass`,`edad`,`estado`,`correo`,`idRol`) values (1,'nombre user','apellido user','user','202cb962ac59075b964b07152d234b70',20,1,'correo@correo.com',1);

/* Procedure structure for procedure `sp_detalleenvio` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_detalleenvio` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_detalleenvio`(
	Accion INT,
	vIDDETALLEENVIO INT,
	vCANTIDADENVIOS INT,
	vIDENVIOS INT,
	vNOMBREENVIO VARCHAR(50),
	vIDINSUMO INT,
	vNOMBREINSUMO VARCHAR(50)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_detalleenvio(cantidadEnvios,idEnvios,idInsumo) VALUES(vCANTIDADENVIOS,vIDENVIOS,vIDINSUMO);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_detalleenvio SET cantidadEnvios=vCANTIDADENVIOS,idEnvios=vIDENVIOS,idInsumo=vIDINSUMO WHERE idDetalleEnvio=vIDDETALLEENVIO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_detalleenvio WHERE idDetalleEnvio=vIDDETALLEENVIO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_detalleenvio;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		select nombre from tbl_envios;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idEnvios FROM tbl_envios where nombre=vNOMBREENVIO;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT nombre FROM tbl_envios WHERE idEnvios=vIDENVIOS;
	END;
	ELSEIF Accion = 8 THEN
	BEGIN
		SELECT nombre FROM tbl_insumos;
	END;
    ELSEIF Accion = 9 THEN
	BEGIN
		SELECT idInsumo FROM tbl_insumos WHERE nombre=vNOMBREINSUMO;
	END;
    ELSEIF Accion = 10 THEN
	BEGIN
		SELECT nombre FROM tbl_insumos WHERE idInsumo=vIDINSUMO;
	END;
    ELSEIF Accion = 11 THEN
	BEGIN
		SELECT * FROM tbl_detalleenvio WHERE idDetalleEnvio=vIDDETALLEENVIO;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_envios` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_envios` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_envios`(
	Accion INT,
	vIDENVIOS INT,
	vNOMBRE VARCHAR(50),
	vFECHAENVIO varchar(10),
	vNOMBRERECEPTOR VARCHAR(100),
	vIDFINCA INT,
	vNOMBREFINCA varchar(100)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		insert into tbl_envios(nombre,fechaEnvio,nombreReceptor,idFinca) values(vNOMBRE,DATE_FORMAT(vFECHAENVIO,'%Y-%m-%d'),vNOMBRERECEPTOR,vIDFINCA);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		update tbl_envios set nombre=vNOMBRE,fechaEnvio=DATE_FORMAT(vFECHAENVIO,'%Y-%m-%d'),nombreReceptor=vNOMBRERECEPTOR,idFinca=vIDFINCA where idEnvios=vIDENVIOS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		delete from tbl_envios where idEnvios=vIDENVIOS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT idEnvios,nombre,date_format(fechaEnvio,'%d-%m-%Y') as fechaEnvio,nombreReceptor,idFinca FROM tbl_envios;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT nombre FROM tbl_finca;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idFinca FROM tbl_finca where nombre=vNOMBREFINCA;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT nombre FROM tbl_finca WHERE idFinca=vIDFINCA;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT idEnvios,nombre,DATE_FORMAT(fechaEnvio,'%d-%m-%Y') AS fechaEnvio,nombreReceptor,idFinca FROM tbl_envios WHERE nombre like concat("%",vNOMBRE,"%");
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_finca` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_finca` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_finca`(
	Accion INT,
	vIDFINCA INT,
	vNOMBRE VARCHAR(100),
	vDIRECCION VARCHAR(100),
	vTIPOFINCA VARCHAR(50)
    )
BEGIN
    
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_finca(nombre,direccion,tipoFinca) VALUES(vNOMBRE,vDIRECCION,vTIPOFINCA);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_finca SET nombre=vNOMBRE,direccion=vDIRECCION,tipoFinca=vTIPOFINCA WHERE idFinca=vIDFINCA;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_finca WHERE idFinca=vIDFINCA;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_finca;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT * FROM tbl_finca WHERE idFinca=vIDFINCA;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_insumos` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_insumos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insumos`(
	Accion INT,
	vIDINSUMO INT,
	vNOMBRE VARCHAR(50),
	vMEDIDA VARCHAR(50),
	vCANTIDAD DOUBLE,
	vIDTIPOINSUMO INT
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_insumos(nombre,medida,cantidad,idTipoInsumo) VALUES(vNOMBRE,vMEDIDA,vCANTIDAD,vIDTIPOINSUMO);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_insumos SET nombre=vNOMBRE,medida=vMEDIDA,cantidad=vCANTIDAD,idTipoInsumo=vIDTIPOINSUMO WHERE idInsumo=vIDINSUMO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_insumos WHERE idInsumo=vIDINSUMO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_insumos;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT nombre FROM tbl_tipoinsumo;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT * FROM tbl_insumos WHERE nombre like concat("%",vNOMBRE,"%");
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_insumosutilizados` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_insumosutilizados` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insumosutilizados`(
	Accion INT,
	vIDINSUMOUTILIZADOS INT,
	vCANTIDADUTILIZADA INT,
	vIDINSUMO INT,
	vNOMBREINSUMO VARCHAR(50),
	vIDTAREADIARIA INT,
	vNOMBRETAREA VARCHAR(50)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_insumosutilizados(cantidadUtilizada,idInsumo,idTareaDiaria) VALUES(vCANTIDADUTILIZADA,vIDINSUMO,vIDTAREADIARIA);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_insumosutilizados SET cantidadUtilizada=vCANTIDADUTILIZADA,idInsumo=vIDINSUMO,idTareaDiaria=vIDTAREADIARIA WHERE idInsumoUtilizados=vIDINSUMOUTILIZADOS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_insumosutilizados WHERE idInsumoUtilizados=vIDINSUMOUTILIZADOS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_insumosutilizados;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT idInsumo,nombre FROM tbl_insumos;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idInsumo,nombre FROM tbl_insumos WHERE nombre=vNOMBREINSUMO;
		-- SELECT u.idInsumo,i.nombre FROM tbl_insumosutilizados u
		-- join tbl_insumos i on u.idInsumo=i.idInsumo where i.nombre=vNOMBREINSUMO;
	END;
	
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT idInsumo,nombre FROM tbl_insumos WHERE idInsumo=vIDINSUMO;
		-- SELECT u.idInsumo,i.nombre FROM tbl_insumosutilizados u
		-- join tbl_insumos i on u.idInsumo=i.idInsumo where i.nombre=vNOMBREINSUMO;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT d.idTareaDiaria as idTareaDiaria,t.nombre as nombre FROM tbl_tareas t
		join tbl_tareadiaria d on t.idTarea = d.idTarea;
	END;
    ELSEIF Accion = 9 THEN
	BEGIN
		SELECT d.idTareaDiaria AS idTareaDiaria,t.nombre AS nombre FROM tbl_tareas t
		JOIN tbl_tareadiaria d ON t.idTarea = d.idTarea WHERE t.nombre=vNOMBRETAREA;
	END;
    ELSEIF Accion = 10 THEN
	BEGIN
		SELECT d.idTareaDiaria AS idTareaDiaria,t.nombre AS nombre FROM tbl_tareas t
		JOIN tbl_tareadiaria d ON t.idTarea = d.idTarea WHERE d.idTareaDiaria=vIDTAREADIARIA;
	END;
    ELSEIF Accion = 11 THEN
	BEGIN
		SELECT * from tbl_insumosutilizados WHERE idInsumoUtilizados=vIDINSUMOUTILIZADOS;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_inventario` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_inventario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_inventario`(
	Accion INT,
	vIDINVENTARIO INT,
	vCANTIDAD INT,
	vPRECIO DOUBLE,
	vESTADO INT,
	vIDFINCA INT,
	vNOMBREFINCA VARCHAR(100),
	vIDPROVEEDOR INT,
	vNOMBREPROVEEDOR VARCHAR(100),
	vIDINSUMO INT,
	vNOMBREINSUMO VARCHAR(50)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_inventario(cantidad,precio,estado,idFinca,idProveedor,idInsumo) VALUES(vCANTIDAD,vPRECIO,vESTADO,vIDFINCA,vIDPROVEEDOR,vIDINSUMO);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_inventario SET cantidad=vCANTIDAD,precio=vPRECIO,estado=vESTADO,idFinca=vIDFINCA,idProveedor=vIDPROVEEDOR,idInsumo=vIDINSUMO WHERE idInventario=vIDINVENTARIO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_inventario WHERE idInventario=vIDINVENTARIO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_inventario where estado=1;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT nombre FROM tbl_finca;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idFinca FROM tbl_finca where nombre=vNOMBREFINCA;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT nombre FROM tbl_finca where idFinca=vIDFINCA;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT nombre FROM tbl_proveedor;
	END;
    ELSEIF Accion = 9 THEN
	BEGIN
		SELECT idProveedor FROM tbl_proveedor WHERE nombre=vNOMBREPROVEEDOR;
	END;
    ELSEIF Accion = 10 THEN
	BEGIN
		SELECT nombre FROM tbl_proveedor WHERE idProveedor=vIDPROVEEDOR;
	END;
    ELSEIF Accion = 11 THEN
	BEGIN
		SELECT nombre FROM tbl_insumos;
	END;
    ELSEIF Accion = 12 THEN
	BEGIN
		SELECT idInsumo FROM tbl_insumos WHERE nombre=vNOMBREINSUMO;
	END;
    ELSEIF Accion = 13 THEN
	BEGIN
		SELECT nombre FROM tbl_insumos WHERE idInsumo=vIDINSUMO;
	END;
    ELSEIF Accion = 14 THEN
	BEGIN
		SELECT * FROM tbl_inventario WHERE idInventario=vIDINVENTARIO;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_jornaleros` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_jornaleros` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_jornaleros`(
	Accion INT,
	vIDJORNALEROS INT,
	vNOMBRE VARCHAR(50),
	vAPELLIDO VARCHAR(50),
	vEDAD INT,
	vHORARIO VARCHAR(10),
	vESTADO INT,
	vDIRECCION VARCHAR(100),
	vIDPAGOS INT,
	vSALARIODIARIO DOUBLE
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_jornaleros(nombre,apellido,edad,horario,estado,direccion,idPagos) VALUES(vNOMBRE,vAPELLIDO,vEDAD,vHORARIO,vESTADO,vDIRECCION,vIDPAGOS);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_jornaleros SET nombre=vNOMBRE,apellido=vAPELLIDO,edad=vEDAD,horario=vHORARIO,estado=vESTADO,direccion=vDIRECCION,idPagos=vIDPAGOS WHERE idJornaleros=vIDJORNALEROS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_jornaleros WHERE idJornaleros=vIDJORNALEROS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_jornaleros where estado=1;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT salarioDiario FROM tbl_pagos;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idPagos FROM tbl_pagos where salarioDiario=vSALARIODIARIO;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT salarioDiario FROM tbl_pagos WHERE idPagos=vIDPAGOS;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT * FROM tbl_jornaleros WHERE nombre=vNOMBRE;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_pagos` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_pagos` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pagos`(
	Accion INT,
	vIDPAGOS INT,
	vSALARIODIARIO DOUBLE
    )
BEGIN
    
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_pagos(salarioDiario) VALUES(vSALARIODIARIO);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_pagos SET salarioDiario=vSALARIODIARIO WHERE idPagos=vIDPAGOS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_pagos WHERE idPagos=vIDPAGOS;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_pagos;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_proveedores` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_proveedores` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_proveedores`(
	Accion INT,
	vIDPROVEEDOR INT,
	vNOMBRE VARCHAR(100),
	vDIRECCION VARChAR(100),
	vTELEFONO VARChAR(9),
	vCORREO VARCHAR(60)
    )
BEGIN
    
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_proveedor(nombre,direccion,telefono,correo) VALUES(vNOMBRE,vDIRECCION,vTELEFONO,vCORREO);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_proveedor SET nombre=vNOMBRE,direccion=vDIRECCION,telefono=vTELEFONO,correo=vCORREO WHERE idProveedor=vIDPROVEEDOR;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_proveedor WHERE idProveedor=vIDPROVEEDOR;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_proveedor;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT * FROM tbl_proveedor WHERE idProveedor=vIDPROVEEDOR;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_rol` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_rol` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_rol`(
	Accion INT,
	vIDROL INT,
	vNOMBRE VARCHAR(70)
    )
BEGIN
    
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_rol(nombre) VALUES(vNOMBRE);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_rol SET nombre=vNOMBRE WHERE idRol=vIDROL;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_rol WHERE idRol=vIDROL;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_rol;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_tablones` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_tablones` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_tablones`(
	Accion INT,
	vIDTABLONES INT,
	vNOMBRE VARCHAR(60),
	vSECTOR VARCHAR(30),
	vIDFINCA INT,
	vNOMBREFINCA VARCHAR(100)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_tablones(nombre,sector,idFinca) VALUES(vNOMBRE,vSECTOR,vIDFINCA);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_tablones SET nombre=vNOMBRE,sector=vSECTOR,idFinca=vIDFINCA WHERE idTablones=vIDTABLONES;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_tablones WHERE idTablones=vIDTABLONES;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_tablones;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT nombre FROM tbl_finca;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idFinca FROM tbl_finca where nombre=vNOMBREFINCA;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT nombre FROM tbl_finca WHERE idFinca=vIDFINCA;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT * FROM tbl_tablones WHERE nombre=vNOMBRE;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_tareadiaria` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_tareadiaria` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_tareadiaria`(
	Accion INT,
	vIDTAREADIARIA INT,
	vFECHA varchar(10),
	vESTADO INT,
	vJORNADA VARCHAR(30),
	vPORCENTAJEREALIZADO VARCHAR(4),
	vIDTAREA INT,
	vNOMBRETAREA VARCHAR(50),
	vIDTABLONES INT,
	vNOMBRETABLONES VARCHAR(50),
	vIDJORNALERO int,
	vNOMBREJORNALERO VARCHAR(100)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_tareadiaria(fecha,estado,jornada,porcenajeRealizado,idTarea,idTablones,idJornalero) VALUES(DATE_FORMAT(vFECHA,'%Y-%m-%d'),vESTADO,vJORNADA,vPORCENTAJEREALIZADO,vIDTAREA,vIDTABLONES,vIDJORNALERO );
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_tareadiaria SET fecha=DATE_FORMAT(vFECHA,'%Y-%m-%d'),estado=vESTADO,jornada=vJORNADA,porcenajeRealizado=vPORCENTAJEREALIZADO,idTarea=vIDTAREA,idTablones=vIDTABLONES,idJornalero=vIDJORNALERO WHERE idTareaDiaria=vIDTAREADIARIA;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_tareadiaria WHERE idTareaDiaria=vIDTAREADIARIA;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT idTareaDiaria,DATE_FORMAT(fecha,'%d-%m-%Y') as fecha,estado,jornada,porcentajeRealizado,idTarea,idTablones,idJornalero FROM tbl_tareadiaria where estado=1;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT nombre FROM tbl_tareas;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idTarea FROM tbl_tareas where nombre=vNOMBRETAREA;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT nombre FROM tbl_tareas where idTarea=vIDTAREA;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT nombre FROM tbl_tablones;
	END;
    ELSEIF Accion = 9 THEN
	BEGIN
		SELECT idTablones FROM tbl_tablones WHERE nombre=vNOMBRETABLONES;
	END;
    ELSEIF Accion = 10 THEN
	BEGIN
		SELECT nombre FROM tbl_tablones WHERE idTablones=vIDTABLONES;
	END;
    ELSEIF Accion = 11 THEN
	BEGIN
		SELECT nombre FROM tbl_jornaleros;
	END;
    ELSEIF Accion = 12 THEN
	BEGIN
		SELECT idJornaleros FROM tbl_jornaleros WHERE nombre=vNOMBREJORNALERO;
	END;
    ELSEIF Accion = 13 THEN
	BEGIN
		SELECT nombre FROM tbl_jornaleros WHERE idJornalero=vIDJORNALERO;
	END;
    ELSEIF Accion = 14 THEN
	BEGIN
		SELECT idTareaDiaria,DATE_FORMAT(fecha,'%d-%m-%Y') as fecha,estado,jornada,porcentajeRealizado,idTarea,idTablones,idJornalero FROM tbl_tareadiaria WHERE idTareaDiaria=vIDTAREADIARIA;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_tareas` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_tareas` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_tareas`(
	Accion INT,
	vIDTAREA INT,
	vNOMBRE VARCHAR(30),
	vTIPOTAREA VARCHAR(30)
    )
BEGIN
    
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_tareas(nombre,tipoTarea) VALUES(vNOMBRE,vTIPOTAREA);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_tareas SET nombre=vNOMBRE,tipoTarea=vTIPOTAREA WHERE idTarea=vIDTAREA;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_tareas WHERE idTarea=vIDTAREA;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_tareas;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT * FROM tbl_tareas WHERE nombre=vNOMBRE;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_tipoinsumo` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_tipoinsumo` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_tipoinsumo`(
	Accion INT,
	vIDTIPOINSUMO INT,
	vNOMBRE VARCHAR(50)
    )
BEGIN
    
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_tipoinsumo(nombre) VALUES(vNOMBRE);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_tipoinsumo SET nombre=vNOMBRE WHERE idTipoInsumo=vIDTIPOINSUMO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_tipoinsumo WHERE idTipoInsumo=vIDTIPOINSUMO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_tipoinsumo;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/* Procedure structure for procedure `sp_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `sp_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_usuario`(
	Accion INT,
	vIDUSUARIO INT,
	vNOMBRE VARCHAR(100),
	vAPELLIDO VARCHAR(100),
	vNICKNAME VARCHAR(15),
	vPASSWORD VARCHAR(50),
	vEDAD INT,
	vESTADO INT,
	vCORREO VARCHAR(70),
	vIDROL INT,
	vNOMBREROL varchar(20)
    )
BEGIN
    IF Accion = 1 THEN
	BEGIN
		INSERT INTO tbl_usuario(nombre,apellido,nickname,pass,edad,estado,correo,idRol) VALUES(vNOMBRE,vAPELLIDO,vNICKNAME,MD5(vPASSWORD),vEDAD,vESTADO,vCORREO,vIDROL);
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 2 THEN
	BEGIN
		UPDATE tbl_usuario SET nombre=vNOMBRE,apellido=vAPELLIDO,nickname=vNICKNAME,pass=MD5(vPASSWORD),edad=vEDAD,estado=vESTADO,correo=vCORREO,idRol=vIDROL WHERE idUsuario=vIDUSUARIO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 3 THEN
	BEGIN
		DELETE FROM tbl_usuario WHERE idUsuario=vIDUSUARIO;
		SELECT 1 AS 'Mensaje';
	END;
    ELSEIF Accion = 4 THEN
	BEGIN
		SELECT * FROM tbl_usuario where estado=1;
	END;
    ELSEIF Accion = 5 THEN
	BEGIN
		SELECT nombre FROM tbl_rol;
	END;
    ELSEIF Accion = 6 THEN
	BEGIN
		SELECT idRol FROM tbl_rol where nombre=vNOMBREROL;
	END;
    ELSEIF Accion = 7 THEN
	BEGIN
		SELECT nombre FROM tbl_rol WHERE idRol=vIDROL;
	END;
    ELSEIF Accion = 8 THEN
	BEGIN
		SELECT * FROM tbl_usuario WHERE nombre=vNOMBRE;
	END;
    END IF;
    
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

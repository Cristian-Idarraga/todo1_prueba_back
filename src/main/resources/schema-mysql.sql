CREATE TABLE IF NOT EXISTS `maestro` (
   `cdmaestro` bigint NOT NULL AUTO_INCREMENT,
   `codigo` varchar(20) NOT NULL,
   `descripcion` varchar(120) DEFAULT NULL,
   `estado` varchar(1) DEFAULT NULL,
   `fecha_creacion` datetime DEFAULT NULL,
   `fecha_modificacion` datetime DEFAULT NULL,
   PRIMARY KEY (`cdmaestro`));

CREATE TABLE IF NOT EXISTS `datomaestro` (
   `cddato` bigint NOT NULL AUTO_INCREMENT,
   `cdmaestro` bigint NOT NULL,
   `codigo` varchar(20) NOT NULL,
   `descripcion` varchar(200) NOT NULL,
   `estado` varchar(1) DEFAULT NULL,
   `fecha_creacion` datetime DEFAULT NULL,
   `fecha_modificacion` datetime DEFAULT NULL,
   PRIMARY KEY (`cddato`),
   UNIQUE KEY `unique_maestra` (`cdmaestro`,`codigo`),
   KEY `idx_usuario` (`codigo`),
   CONSTRAINT `FK_DataMaestra_Maestro` FOREIGN KEY (`cdmaestro`) REFERENCES `maestro` (`cdmaestro`));

CREATE TABLE IF NOT EXISTS `rol` (
   `cdrol` bigint NOT NULL AUTO_INCREMENT,
   `nombre` varchar(150) NOT NULL,
   `descripcion` varchar(150) DEFAULT NULL,
   `estado` varchar(1) DEFAULT NULL,
   `fecha_creacion` datetime DEFAULT NULL,
   `fecha_modificacion` datetime DEFAULT NULL,
   PRIMARY KEY (`cdrol`));

CREATE TABLE IF NOT EXISTS `usuario` (
   `cdusuario` bigint NOT NULL AUTO_INCREMENT,
   `nombres` varchar(50) NOT NULL,
   `apellidos` varchar(50) NOT NULL,
   `celular` varchar(15) DEFAULT NULL,
   `correo` varchar(50) NOT NULL,
   `direccion` varchar(30) DEFAULT NULL,
   `fecha_nacimiento` date NOT NULL,
   `cdrol` bigint NOT NULL,
   `cdtipo` varchar(20) NOT NULL,
   `documento` varchar(15) NOT NULL,
   `nombre_usuario` varchar(50) NOT NULL,
   `contrasena` varchar(50) NOT NULL,
   `estado` varchar(1) NOT NULL,
   `fecha_creacion` timestamp NULL DEFAULT NULL,
   `fecha_modificacion` timestamp NULL DEFAULT NULL,
   PRIMARY KEY (`cdusuario`),
   KEY `FK_usuario_Rol` (`cdrol`),
   KEY `FK_usuario_datamaesta` (`cdtipo`),
   CONSTRAINT `FK_usuario_datamaesta` FOREIGN KEY (`cdtipo`) REFERENCES `datomaestro` (`codigo`),
   CONSTRAINT `FK_usuario_Rol` FOREIGN KEY (`cdrol`) REFERENCES `rol` (`cdrol`));

CREATE TABLE IF NOT EXISTS `producto` (
    `cdproducto` bigint NOT NULL AUTO_INCREMENT,
    `nombre` varchar(100) NOT NULL,
    `cdcategoria` varchar(20) NOT NULL,
    `estado` varchar(1) DEFAULT NULL,
    `precio` decimal(16,0) DEFAULT NULL,
    `cantidad_stock` int NOT NULL,
    `fecha_creacion` datetime DEFAULT NULL,
    `fecha_modificacion` datetime DEFAULT NULL,
    PRIMARY KEY (`cdproducto`),
    KEY `fk_categoria_idx` (`cdcategoria`),
    CONSTRAINT `fk_categoria` FOREIGN KEY (`cdcategoria`) REFERENCES `datomaestro` (`codigo`));

CREATE TABLE IF NOT EXISTS `compra` (
  `cdcompra` bigint NOT NULL AUTO_INCREMENT,
  `cdcliente` bigint NOT NULL,
  `comentario` varchar(300) NOT NULL,
  `medio_pago` varchar(10) NOT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `total` decimal(16,0) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`cdcompra`));


CREATE TABLE IF NOT EXISTS `compra_producto` (
    `cdcompra_producto` bigint NOT NULL AUTO_INCREMENT,
    `cdproducto` bigint NOT NULL,
    `cdcompra` bigint NOT NULL,
    `cantidad` int NOT NULL,
    `total` decimal(16,0) DEFAULT NULL,
    `estado` varchar(1) DEFAULT NULL,
    `fecha_creacion` datetime DEFAULT NULL,
    `fecha_modificacion` datetime DEFAULT NULL,
    PRIMARY KEY (`cdcompra_producto`));

ALTER TABLE compra ADD CONSTRAINT `FK_compra_cliente` FOREIGN KEY (`cdcliente`) REFERENCES `usuario` (`cdusuario`);
ALTER TABLE compra_producto ADD CONSTRAINT `fk_compra_producto_compra` FOREIGN KEY (`cdcompra`) REFERENCES `compra` (`cdcompra`);
ALTER TABLE compra_producto ADD CONSTRAINT `fk_compra_producto_producto` FOREIGN KEY (`cdproducto`) REFERENCES `producto` (`cdproducto`);
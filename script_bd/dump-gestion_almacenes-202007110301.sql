-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: gestion_almacenes
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.13-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacenes`
--

DROP TABLE IF EXISTS `almacenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacenes` (
  `id_almacen` int(11) NOT NULL,
  `alm_descripcion` varchar(100) NOT NULL,
  `alm_direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_almacen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacenes`
--

LOCK TABLES `almacenes` WRITE;
/*!40000 ALTER TABLE `almacenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `almacenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `id_tipodoc` int(11) NOT NULL,
  `cli_nrodoc` char(12) NOT NULL,
  `cli_nombres` varchar(80) NOT NULL,
  `cli_apellidos` varchar(100) NOT NULL,
  `cli_razon_social` varchar(200) NOT NULL,
  `cli_direccion` varchar(200) NOT NULL,
  `cli_telefono` char(9) NOT NULL,
  `cli_email` varchar(200) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_clientes_tipo_documento_identidad` (`id_tipodoc`),
  CONSTRAINT `fk_clientes_tipo_documento_identidad` FOREIGN KEY (`id_tipodoc`) REFERENCES `tipo_documento_identidad` (`id_tipodoc`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kardex_cabecera`
--

DROP TABLE IF EXISTS `kardex_cabecera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kardex_cabecera` (
  `id_kdxcab` int(11) NOT NULL,
  `id_almacen` int(11) NOT NULL,
  `id_tdo` int(11) NOT NULL,
  `id_motivo` int(11) NOT NULL,
  `kac_nummov` int(5) NOT NULL,
  `kac_tdoref1` char(3) NOT NULL,
  `kac_docref1` char(14) NOT NULL,
  `kac_tdoref2` char(3) NOT NULL,
  `kac_docref2` char(14) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `kac_fecha` date NOT NULL,
  `kac_glosa` varchar(200) NOT NULL,
  `kac_estado` char(1) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `kac_fecreg` date NOT NULL,
  PRIMARY KEY (`id_kdxcab`),
  KEY `fk_kardex_cabecera_almacen` (`id_almacen`),
  KEY `fk_kardex_cabecera_tipo_documento` (`id_tdo`),
  KEY `fk_kardex_cabecera_motivo` (`id_motivo`),
  KEY `fk_kardex_cabecera_clientes` (`id_cliente`),
  KEY `fk_kardex_cabecera_proveedores` (`id_proveedor`),
  KEY `fk_kardex_cabecera_usuarios` (`id_usuario`),
  CONSTRAINT `fk_kardex_cabecera_almacen` FOREIGN KEY (`id_almacen`) REFERENCES `almacenes` (`id_almacen`) ON UPDATE CASCADE,
  CONSTRAINT `fk_kardex_cabecera_clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON UPDATE CASCADE,
  CONSTRAINT `fk_kardex_cabecera_motivo` FOREIGN KEY (`id_motivo`) REFERENCES `motivo_movimientos` (`id_motivo`) ON UPDATE CASCADE,
  CONSTRAINT `fk_kardex_cabecera_proveedores` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`) ON UPDATE CASCADE,
  CONSTRAINT `fk_kardex_cabecera_tipo_documento` FOREIGN KEY (`id_tdo`) REFERENCES `tipo_documento` (`id_tdo`) ON UPDATE CASCADE,
  CONSTRAINT `fk_kardex_cabecera_usuarios` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kardex_cabecera`
--

LOCK TABLES `kardex_cabecera` WRITE;
/*!40000 ALTER TABLE `kardex_cabecera` DISABLE KEYS */;
/*!40000 ALTER TABLE `kardex_cabecera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kardex_detalle`
--

DROP TABLE IF EXISTS `kardex_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kardex_detalle` (
  `id_kdxdet` int(11) NOT NULL,
  `id_kdxcab` int(11) NOT NULL,
  `kac_nummov` int(5) NOT NULL,
  `kad_item` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `kad_cantidad` int(11) NOT NULL,
  `kad_costo` decimal(12,3) NOT NULL,
  `kad_precio` decimal(12,3) NOT NULL,
  PRIMARY KEY (`id_kdxdet`),
  KEY `fk_kardex_deatlle_productos` (`id_producto`),
  KEY `fk_kardex_detalle_kadex_cabecera` (`id_kdxcab`),
  CONSTRAINT `fk_kardex_deatlle_productos` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE,
  CONSTRAINT `fk_kardex_detalle_kadex_cabecera` FOREIGN KEY (`id_kdxcab`) REFERENCES `kardex_cabecera` (`id_kdxcab`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kardex_detalle`
--

LOCK TABLES `kardex_detalle` WRITE;
/*!40000 ALTER TABLE `kardex_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `kardex_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL,
  `mrc_descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moneda`
--

DROP TABLE IF EXISTS `moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moneda` (
  `id_moneda` int(11) NOT NULL,
  `tmo_descripcion` varchar(20) NOT NULL,
  `tmo_simbolo` char(2) NOT NULL,
  PRIMARY KEY (`id_moneda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneda`
--

LOCK TABLES `moneda` WRITE;
/*!40000 ALTER TABLE `moneda` DISABLE KEYS */;
/*!40000 ALTER TABLE `moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivo_movimientos`
--

DROP TABLE IF EXISTS `motivo_movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motivo_movimientos` (
  `id_motivo` int(11) NOT NULL,
  `mmo_descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_motivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivo_movimientos`
--

LOCK TABLES `motivo_movimientos` WRITE;
/*!40000 ALTER TABLE `motivo_movimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivo_movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL,
  `per_descripcion` varchar(80) NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'ADMINISTRADOR');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `prd_descripcion` int(11) NOT NULL,
  `id_undmed` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_tipinv` int(11) NOT NULL,
  `prd_costo` decimal(12,3) NOT NULL,
  `prd_precio` decimal(12,3) NOT NULL,
  `prd_stkmin` int(11) NOT NULL,
  `prd_stkmax` int(11) NOT NULL,
  `prd_peso` decimal(10,2) NOT NULL,
  `prd_estado` char(1) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `fk_producto_unidad_medida` (`id_undmed`),
  KEY `fk_producto_marca` (`id_marca`),
  KEY `fk_producto_tipo_inventario` (`id_tipinv`),
  CONSTRAINT `fk_producto_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`) ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_tipo_inventario` FOREIGN KEY (`id_tipinv`) REFERENCES `tipo_inventario` (`id_tipinv`) ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_unidad_medida` FOREIGN KEY (`id_undmed`) REFERENCES `unidad_medida` (`id_undmed`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `id_tipodoc` int(11) NOT NULL,
  `pro_nrodoc` char(12) NOT NULL,
  `pro_razsoc` varchar(200) NOT NULL,
  `pro_direccion` varchar(200) NOT NULL,
  `pro_telefono` char(9) NOT NULL,
  `pro_email` varchar(200) NOT NULL,
  `pro_pais` varchar(100) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `fk_proveedores_tipo_documento_identidad` (`id_tipodoc`),
  CONSTRAINT `fk_proveedores_tipo_documento_identidad` FOREIGN KEY (`id_tipodoc`) REFERENCES `tipo_documento_identidad` (`id_tipodoc`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saldos_productos`
--

DROP TABLE IF EXISTS `saldos_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldos_productos` (
  `id_saldos` int(11) NOT NULL,
  `spa_año` char(4) NOT NULL,
  `spa_mes` char(2) NOT NULL,
  `id_almacen` int(11) NOT NULL,
  `id_tdo` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `spa_salinicio` int(11) NOT NULL,
  `spa_ingresos` int(11) NOT NULL,
  `spa_salidas` int(11) NOT NULL,
  `spa_salfinal` int(11) NOT NULL,
  PRIMARY KEY (`id_saldos`),
  KEY `fk_saldos_productos_almacenes` (`id_almacen`),
  KEY `fk_saldos_productos_tipo_documento` (`id_tdo`),
  KEY `fk_saldos_productos_productos` (`id_producto`),
  CONSTRAINT `fk_saldos_productos_almacenes` FOREIGN KEY (`id_almacen`) REFERENCES `almacenes` (`id_almacen`) ON UPDATE CASCADE,
  CONSTRAINT `fk_saldos_productos_productos` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE,
  CONSTRAINT `fk_saldos_productos_tipo_documento` FOREIGN KEY (`id_tdo`) REFERENCES `tipo_documento` (`id_tdo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldos_productos`
--

LOCK TABLES `saldos_productos` WRITE;
/*!40000 ALTER TABLE `saldos_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `saldos_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_documento` (
  `id_tdo` int(11) NOT NULL,
  `tdo_descripcion` varchar(50) NOT NULL,
  `tdo_abreviatura` char(3) NOT NULL,
  `tdo_induso` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_tdo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento_identidad`
--

DROP TABLE IF EXISTS `tipo_documento_identidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_documento_identidad` (
  `id_tipodoc` int(11) NOT NULL,
  `tdi_descripcion` varchar(50) NOT NULL,
  `tdi_abreviatura` char(3) NOT NULL,
  PRIMARY KEY (`id_tipodoc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento_identidad`
--

LOCK TABLES `tipo_documento_identidad` WRITE;
/*!40000 ALTER TABLE `tipo_documento_identidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_documento_identidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_inventario`
--

DROP TABLE IF EXISTS `tipo_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_inventario` (
  `id_tipinv` int(11) NOT NULL,
  `tin_descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipinv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_inventario`
--

LOCK TABLES `tipo_inventario` WRITE;
/*!40000 ALTER TABLE `tipo_inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_medida`
--

DROP TABLE IF EXISTS `unidad_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_medida` (
  `id_undmed` int(11) NOT NULL,
  `ume_descripcion` varchar(50) NOT NULL,
  `ume_abreviatura` char(10) NOT NULL,
  PRIMARY KEY (`id_undmed`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_medida`
--

LOCK TABLES `unidad_medida` WRITE;
/*!40000 ALTER TABLE `unidad_medida` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidad_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `usu_username` varchar(30) NOT NULL,
  `usu_password` varchar(50) NOT NULL,
  `usu_nombre` varchar(80) NOT NULL,
  `usu_apellidos` varchar(100) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  `usu_estado` char(1) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_perfil` (`id_perfil`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id_perfil`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'RMAQUERA','123456','ROGER','MAQUERA',1,'A'),(2,'CMENA','123456','CATHERINE','MENA',1,'A'),(3,'FVEGA','123456','FERNANDO','VEGA',1,'A'),(4,'GARELLANO','123456','GIAMPIER MARCO','ARELLANO BULEJE',1,'A');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gestion_almacenes'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-11  3:01:32

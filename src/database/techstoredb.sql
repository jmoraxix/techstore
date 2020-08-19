-- Database export via SQLPro (https://www.sqlprostudio.com/allapps.html)
-- Exported by jmora at 19-08-2020 4:29 PM.
-- WARNING: This file may contain descructive statements such as DROPs.
-- Please ensure that you are running the script at the proper location.


-- BEGIN TABLE categoria
DROP TABLE IF EXISTS categoria;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `orden` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 8 rows into categoria
-- Insert batch #1
INSERT INTO categoria (id, nombre, orden) VALUES
(1, 'Computadoras', 1),
(2, 'Componentes', 1),
(3, 'Perifericos', 1),
(4, 'Accesorios', 1),
(5, 'Dispositivos', 1),
(6, 'Audio', 1),
(7, 'Televisores', 1),
(9, 'Otro', 0);

-- END TABLE categoria

-- BEGIN TABLE factura
DROP TABLE IF EXISTS factura;
CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orden_id` int(11) NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo_pago_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_orden_id` (`orden_id`),
  KEY `fk_factura_tipo_pago_id` (`tipo_pago_id`),
  CONSTRAINT `fk_factura_orden_id` FOREIGN KEY (`orden_id`) REFERENCES `orden` (`id`),
  CONSTRAINT `fk_factura_tipo_pago_id` FOREIGN KEY (`tipo_pago_id`) REFERENCES `tipo_pago` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 16 rows into factura
-- Insert batch #1
INSERT INTO factura (id, orden_id, fecha, tipo_pago_id) VALUES
(11, 20, '2020-08-19 04:23:39', 8238888),
(12, 23, '2020-08-19 04:30:16', 8238888),
(13, 24, '2020-08-19 04:34:30', 8238886),
(14, 25, '2020-08-19 06:04:28', 8238886),
(15, 19, '2020-08-19 06:04:29', 8238888),
(16, 26, '2020-08-19 06:05:27', 8238886),
(17, 27, '2020-08-19 06:05:30', 8238886),
(18, 29, '2020-08-19 06:07:33', 8238886),
(19, 28, '2020-08-19 06:08:05', 8238886),
(20, 31, '2020-08-19 06:09:00', 8238888),
(21, 33, '2020-08-19 06:09:57', 8238886),
(22, 30, '2020-08-19 06:10:23', 8238886),
(23, 32, '2020-08-19 06:10:52', 8238886),
(24, 36, '2020-08-19 07:59:10', 8238886),
(25, 38, '2020-08-19 21:40:47', 8238888),
(26, 34, '2020-08-19 22:18:41', 8238888);

-- END TABLE factura

-- BEGIN TABLE imagen
DROP TABLE IF EXISTS imagen;
CREATE TABLE `imagen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `producto_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `imagen_id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 53 rows into imagen
-- Insert batch #1
INSERT INTO imagen (id, nombre, producto_id) VALUES
(23, 'memoria-ram-hyperx-fury-ddr4-8gb-dimm-2666mhz-12v.jpg', 1),
(24, '20-821-206-V03.jpg', 2),
(25, 'imexx-audifonos-in-ear-microfono.jpg', 3),
(26, '51xSM8X96KL._AC_UY327_FMwebp_QL65_.webp', 1),
(27, '71aJf5U+4GL._AC_SL1500_.jpg', 13),
(28, 'razer-blackshark-v2x.jpg', 14),
(29, 'razer-kraken-x-consola.jpg', 15),
(30, 'gskill-ripjaws-v-8-gb-ddr4-2666-rojo.jpg', 16),
(31, '81QywkHcJFL._AC_SL1500_.jpg', 17),
(32, 'adata-xpg-spectrix-d80-8-gb-ddr4-3000.jpg', 18),
(33, 'corsair-k57-rgb-wireless.jpg', 19),
(34, 'msi-gt710-2-gb.jpg', 21),
(35, 'asus-geforce-gt-1030-2-gb.jpg', 22),
(36, '31Si+sh6hTL._AC_.jpg', 23),
(37, '31xiAPYsJ+L._AC_.jpg', 23),
(38, '41kXmux1RwL._AC_.jpg', 23),
(39, '71pZBy04+tL._AC_SL1500_.jpg', 23),
(42, 'redragon-legend-m990-rgb.jpg', 26),
(44, '6QV95LA-5_T1578318287.jpg', 25),
(45, '71pbZdoiHYL._AC_SL1500_.jpg', 25),
(46, '161945_1_wizttu8pkclw1b1m.jpg', 25),
(47, '61Vyge3Nm1L._AC_SL1500_.jpg', 24),
(48, '71BXWTTazlL._AC_SL1500_.jpg', 24),
(49, '71s1LRpaprL._AC_SL1500_.jpg', 24),
(50, '41HLuP7HIPL._AC_SL1024_.jpg', 27),
(51, '41UPtXbP4LL._AC_SL1024_.jpg', 27),
(52, '51Mn+JppEHL._AC_SL1024_.jpg', 27),
(53, '61g8YU1UisL._AC_SL1000_.jpg', 28),
(54, '51pzRrxG6YL._AC_SL1000_.jpg', 28),
(55, '51ay897aXqL._AC_SL1000_.jpg', 28),
(59, '81qmTTzUlfL._AC_SL1500_.jpg', 29),
(60, '81AczAgBE1L._AC_SL1500_.jpg', 29),
(61, '61VWiaPrmQL._AC_SL1500_.jpg', 29),
(62, '616+kGLMqJL._AC_SL1000_.jpg', 30),
(63, '51k2rVrFTzL._AC_SL1000_.jpg', 30),
(64, '31AFifw1GTL._AC_.jpg', 30),
(66, '91-eauuXOVL._AC_SL1500_.jpg', 31),
(67, '61dpU6lM-BL._AC_SL1000_.jpg', 31),
(68, '91y9KARm0KL._AC_SL1500_.jpg', 32),
(69, '91THQ9CMpfL._AC_SL1500_.jpg', 32),
(70, '71Jog-wotuL._AC_SL1500_.jpg', 33),
(71, 'b8f2a6f806eb2db4efc766501d90b3d1.jpg', 33),
(72, '71pfpQwYjZL._AC_SL1500_.jpg', 34),
(73, '81ZcJbFg-qL._AC_SL1500_.jpg', 34),
(74, '61B+cuviCPL._AC_SL1203_.jpg', 34),
(75, '71Q5sdPHD-L._AC_SL1500_.jpg', 35),
(76, '81-l4X-IM9L._AC_SL1500_.jpg', 35),
(77, 'imexx-cable-vga-18m.jpg', 36),
(78, '612H2RRXaBL._AC_SL1280_.jpg', 37),
(79, 'imexx-adaptador-hdmi-a-vga.jpg', 38),
(80, 'xiaomi-mi-led-tv-4s-43-pulgadas-4k-hdr.jpg', 39),
(81, 'logitech-c525.jpg', 40),
(82, 'hipertextual-samsung-presenta-galaxy-note-20-y-galaxy-note-20-ultra-2020813155-740x486.jpg', 29);

-- END TABLE imagen

-- BEGIN TABLE inventario
DROP TABLE IF EXISTS inventario;
CREATE TABLE `inventario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sucursal_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inventario_producto_idx` (`producto_id`),
  KEY `fk_inventario_sucursal_id_idx` (`sucursal_id`),
  CONSTRAINT `fk_inventario_producto` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`),
  CONSTRAINT `fk_inventario_sucursal_id` FOREIGN KEY (`sucursal_id`) REFERENCES `sucursal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 2 rows into inventario
-- Insert batch #1
INSERT INTO inventario (id, sucursal_id, producto_id, cantidad) VALUES
(6, 1, 1, 5),
(7, 2, 25, 22);

-- END TABLE inventario

-- BEGIN TABLE item_orden
DROP TABLE IF EXISTS item_orden;
CREATE TABLE `item_orden` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `producto_id` int(11) NOT NULL,
  `orden_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `item_orden_unique_producto_orden` (`orden_id`,`producto_id`),
  KEY `fk_item_orden_producto_id` (`producto_id`),
  CONSTRAINT `fk_item_orden_orden_id` FOREIGN KEY (`orden_id`) REFERENCES `orden` (`id`),
  CONSTRAINT `fk_item_orden_producto_id` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 31 rows into item_orden
-- Insert batch #1
INSERT INTO item_orden (id, producto_id, orden_id, cantidad) VALUES
(35, 1, 20, 1),
(37, 3, 20, 1),
(38, 2, 20, 1),
(39, 1, 19, 1),
(40, 1, 23, 1),
(41, 14, 23, 1),
(42, 14, 24, 1),
(43, 14, 25, 2),
(44, 17, 19, 1),
(45, 13, 25, 1),
(46, 19, 19, 1),
(47, 15, 19, 1),
(48, 22, 26, 1),
(49, 23, 27, 1),
(50, 26, 26, 1),
(51, 24, 28, 1),
(52, 17, 28, 1),
(53, 3, 29, 1),
(54, 30, 29, 1),
(55, 27, 31, 1),
(56, 1, 30, 1),
(58, 25, 33, 1),
(59, 2, 30, 1),
(60, 30, 32, 1),
(61, 29, 32, 1),
(62, 1, 34, 1),
(63, 1, 36, 1),
(64, 13, 36, 1),
(65, 13, 38, 2),
(66, 14, 38, 1),
(67, 14, 34, 1);

-- END TABLE item_orden

-- BEGIN TABLE marca
DROP TABLE IF EXISTS marca;
CREATE TABLE `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 49 rows into marca
-- Insert batch #1
INSERT INTO marca (id, nombre) VALUES
(3, 'DELL'),
(4, 'HP'),
(6, 'REDRAGON '),
(9, 'GIGABYTE '),
(10, 'LOGITECH '),
(11, 'MSI'),
(15, 'Bose'),
(16, 'LENOVO'),
(17, 'ASUS'),
(18, 'ACER'),
(19, 'OMEN'),
(20, 'AMD'),
(21, 'GeForce'),
(22, 'Intel'),
(23, 'ASROCK'),
(24, 'ADATA'),
(25, 'G.SKILL RIPJAWS'),
(27, 'SAPPHIRE '),
(28, 'SEAGATE'),
(29, 'WESTERN DIGITAL'),
(32, 'KINGSTON'),
(33, 'CRUCIAL'),
(34, 'NZXT'),
(35, 'CORSAIR'),
(36, 'AORUS'),
(37, 'ARTIC'),
(38, 'DARKFLASH'),
(39, 'COOLER MASTER'),
(40, 'AZZA'),
(41, 'EVGA'),
(42, 'BITFENIX'),
(43, 'BE QUIET!'),
(44, 'HAVIT'),
(45, 'HYPERX'),
(46, 'ASTRO'),
(47, 'XIAOMI'),
(48, 'JBL'),
(49, 'THONET & VANDER'),
(50, 'MICROSOFT'),
(51, 'GOOGLE'),
(53, 'IMEXX'),
(54, 'OLOy'),
(57, 'RAZER'),
(58, 'Mackie MR Series'),
(59, 'SAMSUNG'),
(60, 'Huawei'),
(61, 'SONY'),
(62, 'VicTsing'),
(63, 'XIAOMI');

-- END TABLE marca

-- BEGIN TABLE orden
DROP TABLE IF EXISTS orden;
CREATE TABLE `orden` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_nombre_usuario` varchar(25) NOT NULL,
  `activa` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_orden_usuario_nombre_usuario` (`usuario_nombre_usuario`),
  CONSTRAINT `fk_orden_usuario_nombre_usuario` FOREIGN KEY (`usuario_nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 18 rows into orden
-- Insert batch #1
INSERT INTO orden (id, usuario_nombre_usuario, activa) VALUES
(19, 'ashred', 0),
(20, 'jmora', 0),
(23, 'maikmm30', 0),
(24, 'maikmm30', 0),
(25, 'sebas_r3101', 0),
(26, 'ashred', 0),
(27, 'Dino', 0),
(28, 'sebas_r3101', 0),
(29, 'Dino', 0),
(30, 'ashred', 0),
(31, 'Dino', 0),
(32, 'sebas_r3101', 0),
(33, 'Dino', 0),
(34, 'ashred', 0),
(35, 'sebas_r3101', 1),
(36, 'Dino', 0),
(37, 'Dino', 1),
(38, 'jmora', 0);

-- END TABLE orden

-- BEGIN TABLE producto
DROP TABLE IF EXISTS producto;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `tipo_producto_id` int(11) NOT NULL,
  `precio` double NOT NULL,
  `marca_id` int(11) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_producto_nombre` (`nombre`),
  KEY `fk_producto_tipo_producto_id_idx` (`tipo_producto_id`),
  KEY `fk_producto_marca_id_idx` (`marca_id`),
  CONSTRAINT `fk_producto_marca_id` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`),
  CONSTRAINT `fk_producto_tipo_producto_id` FOREIGN KEY (`tipo_producto_id`) REFERENCES `tipo_producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 31 rows into producto
-- Insert batch #1
INSERT INTO producto (id, nombre, tipo_producto_id, precio, marca_id, modelo, descripcion) VALUES
(1, 'HyperX Fury 16GB', 1, 30000, 45, 'Fury', 'HyperX Fury 16GB 2666MHz DDR4'),
(2, 'OLOy DDR4 RAM 16GB', 1, 25000, 54, 'MD4U083016BJDA', '3000 MHz CL16 1.35V 288-PinUDIMM'),
(3, 'IMEXX - AUDIFONOS IN-EAR + MICROFONO', 5, 2000, 53, 'IMEXX', 'IMEXX Audifonos'),
(13, 'LED Strip Lights', 14, 10000, 3, 'Stripped', '16.4ft RGB Color Changing LED Lights Strip'),
(14, 'RAZER BLACKSHARK V2X', 5, 26000, 57, 'BLACKSHARK V2X', 'Compatible con PC, Mac, PS4, Xbox One, Nintendo Switch y dispositivos moviles '),
(15, 'RAZER KRAKEN X - CONSOLAS', 5, 31000, 57, 'KRAKEN X - CONSOLAS', ' Compatibles con PC, Mac, Xbox One, PS4, Nintendo Switch y dispositivos móviles con conector minijack de audio de 3,5 mm  Sonido 7.1 Surround Virtual con Software / Compatible con PC'),
(16, 'G.SKILL RIPJAWS V 8 GB DDR4 2666 - ROJO', 1, 22000, 25, '8 GB DDR4 2666 - ROJO', 'Velocidad: DDR4 2666  Capacidad: 8 GB  Latencia CAS: 15  Voltaje: 1.2V'),
(17, 'Studio Monitor 6.5-Inch Professional-Grade', 4, 150000, 58, 'MR624', 'Designed for superior mix translations and accuracy for professional results in any studio.'),
(18, 'ADATA XPG ', 1, 29000, 24, 'SPECTRIX D80 8 GB DDR4 3000 - LIQUID COOLING', ' Velocidad: DDR4 3000  Capacidad: 8 GB  Latencia CAS: 16  Voltaje: 1.35V  Enfriamiento líquido  LED RGB  Disponibles en color:  -Negro -Rojo'),
(19, 'CORSAIR K57 RGB WIRELESS', 11, 67000, 35, 'K57 RGB WIRELESS', 'Corsair Slipstream Wireless  Tecnología LED Capellix  3 modos conexion:  -Wireless (Corsair Slipstream) -Bluetooth -USB'),
(20, 'LOGITECH G613 LIGHTSPEED - WIRELESS', 11, 55000, 10, ' G613 LIGHTSPEED - WIRELESS', 'Inalambrico  Tecnología Logitech Lightspeed - Conexión 1 ms  Conexión adicional por Bluetooth  Duración de batería de hasta 18 meses'),
(21, 'MSI GT710 2 GB', 15, 35000, 11, ' GT710 2 GB', ' GPU: NVIDIA GT710  Memoria: 2 GB DDR3  Core Clock: 954 MHz'),
(22, ' ASUS GEFORCE GT 1030 2 GB - GDDR5', 15, 65000, 17, ' GEFORCE GT 1030 2 GB - GDDR5', 'GPU: NVIDIA GeForce GT 1030  Memoria: 2 GB GDDR5  Core Clock: 1228 MHz  Boost Clock: 1468 MHz'),
(23, '2019 Dell G7 15.6', 8, 800000, 3, '2019 G7 15.6"', 'FHD Gaming Laptop Computer, 9th Gen Intel Hexa-Core i7-9750H up to 4.5GHz, 16GB DDR4 RAM, 1TB HDD + 256GB PCIe SSD, GeForce GTX 1660 Ti 6GB, 802.11AC WiFi, Bluetooth 5.0, Windows 10'),
(24, 'Acer Nitro 5 Gaming Laptop', 8, 424000, 18, 'Nitro 5', 'Acer Nitro 5 Gaming Laptop, 9th Gen Intel Core i5-9300H, NVIDIA GeForce GTX 1650, 15.6" Full HD IPS Display, 8GB DDR4, 256GB NVMe SSD, WiFi 6, teclado retroiluminado, Alexa Integrado, AN515-54-5812'),
(25, 'HP Pavilion 15"', 8, 504000, 4, 'Pavilion 15"', 'HP Pavilion 15" ordenador portátil, Intel Core i7, 16 GB de RAM, 512 GB de almacenamiento SSD, Intel Iris Plus Graphics, Windows 10 Pro, Amazon Alexa Voice compatible (15-cs3019nr, plata mineral)'),
(26, 'REDRAGON LEGEND M990 RGB', 21, 19000, 6, 'LEGEND M990 RGB', ' Sensor Pixart PMW 3360 Optico  24 Botones programables   Peso regulable - Incluye 8 pesas de 2.4 g  Software para personalización de botones y RGB  Boton Rapid Fire / Double Tap'),
(27, 'Samsung Galaxy Tab A 8.0"', 18, 72000, 59, 'Galaxy Tab A 8', 'Samsung Galaxy Tab A 8.0" 32 GB Wifi Android 9.0 Pie Tablet Negro (2019) - SM-T290NZKAXAR'),
(28, '2019 Samsung Galaxy Tab A 10.1"', 18, 136000, 59, 'Galaxy Tab A 10', '2019 Samsung Galaxy Tab A 10.1" Pantalla táctil (1920x1200) Wi-Fi Tablet Bundle, Exynos 7904A procesador, 2GB RAM, 32GB Memory, BMali-G71 MP2 Graphics, Bluetooth, Tigology Case, Android 9.0 Pie OS'),
(29, 'Samsung Electronics Galaxy Note 20', 9, 593000, 59, 'Galaxy Note 20', 'Samsung Electronics Galaxy Note 20 5G Factory Unlocked Android Cell Phone | US Version | 128GB of Storage | Mobile Gaming Smartphone | Long-Lasting Battery | Mystic Bronze'),
(30, 'Huawei P30 Lite', 9, 137000, 60, 'P30 Lite', 'Huawei P30 Lite (128 GB, 4 GB RAM) Pantalla de 6,15 pulgadas, cámara triple AI, selfie de 32 MP, SIM doble GSM desbloqueado de fábrica MAR-LX3A - Global 4G LTE International Version'),
(31, 'Logitech S-120', 3, 14000, 10, 'S-120', 'Logitech S-120 - Sistema de altavoces estéreo con conector para auriculares auxiliares, color negro'),
(32, 'Logitech Z337', 3, 47000, 10, 'Z337', 'Logitech Z337 - Sistema de altavoces Bluetooth inalámbrico 2.1 para ordenadores, smartphones y tablets'),
(33, 'Logitech Z606', 6, 77000, 10, 'Z606', 'Logitech Z606 5.1 Sistema de altavoces de sonido envolvente con Bluetooth'),
(34, 'Sony CMTSBT100', 6, 118000, 61, 'CMTSBT100', 'Sony CMTSBT100 - Sistema de micro música con Bluetooth y NFC'),
(35, 'Intel Core i7-9700K', 10, 242000, 22, 'Core i7-9700K', 'Intel Core i7-9700K - Procesador de escritorio (8 núcleos, hasta 4.9 GHz, Turbo desbloqueado, LGA1151 300 Series, 95 W)'),
(36, 'CABLE VGA', 16, 1200, 53, 'VGA', 'IMEXX - CABLE VGA 1.8M'),
(37, 'Alfombrilla para mouse', 12, 1200, 62, 'VicTsing', 'VicTsing - Alfombrilla para mouse con bordes cosidos'),
(38, 'ADAPTADOR HDMI A VGA', 13, 3000, 53, 'HDMI A VGA', 'IMEXX - ADAPTADOR HDMI A VGA'),
(39, 'XIAOMI MI LED TV 4S', 22, 230000, 63, 'MI LED TV 4S', 'XIAOMI MI LED TV 4S - 43 PULGADAS 4K HDR'),
(40, 'Logitech C525', 23, 44000, 10, 'C525', 'Logitech C525 - Cámara web USB HD');

-- END TABLE producto

-- BEGIN TABLE rol_usuario
DROP TABLE IF EXISTS rol_usuario;
CREATE TABLE `rol_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rol_UNIQUE` (`nombre`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 2 rows into rol_usuario
-- Insert batch #1
INSERT INTO rol_usuario (id, nombre, descripcion) VALUES
(1, 'Admin', 'Administrador del sistema'),
(2, 'Cliente', NULL);

-- END TABLE rol_usuario

-- BEGIN TABLE sucursal
DROP TABLE IF EXISTS sucursal;
CREATE TABLE `sucursal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(20) NOT NULL,
  `canton` varchar(20) NOT NULL,
  `distrito` varchar(20) NOT NULL,
  `telefono` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 7 rows into sucursal
-- Insert batch #1
INSERT INTO sucursal (id, provincia, canton, distrito, telefono, nombre) VALUES
(1, 'Alajuela', 'Alajuela', 'Centro', 24403894, 'Techstore Alajuela'),
(2, 'San Jose', 'San Jose', 'San Jose', 24302482, 'TechStore San Jose'),
(3, 'Guanacaste', 'Nicoya', 'Nicoya', 22908767, 'TechStore Guanacaste'),
(4, 'Puntarenas', 'El Roble', 'Esparza', 22876756, 'TechStore Puntarenas'),
(5, 'Heredia', 'Heredia', 'Heredia', 22789076, 'TechStore Heredia'),
(6, 'Limon', 'Limon', 'Limon', 22986789, 'TechStore Limon'),
(10, 'Alajuela', 'Asdsa', 'asdadas', 1231321, 'Techstore Alajuela 2');

-- END TABLE sucursal

-- BEGIN TABLE tipo_pago
DROP TABLE IF EXISTS tipo_pago;
CREATE TABLE `tipo_pago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8238891 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 2 rows into tipo_pago
-- Insert batch #1
INSERT INTO tipo_pago (id, nombre, descripcion) VALUES
(8238886, 'Tarjeta', ''),
(8238888, 'Efectivo', '');

-- END TABLE tipo_pago

-- BEGIN TABLE tipo_producto
DROP TABLE IF EXISTS tipo_producto;
CREATE TABLE `tipo_producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_tipo_producto_categoria_idx` (`categoria_id`),
  CONSTRAINT `fk_tipo_producto_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 18 rows into tipo_producto
-- Insert batch #1
INSERT INTO tipo_producto (id, nombre, categoria_id) VALUES
(1, 'Memoria Ram', 2),
(3, 'Parlantes', 6),
(4, 'Monitores', 6),
(5, 'Audifonos', 6),
(6, 'Equipos de Sonido', 6),
(8, 'Portatiles', 1),
(9, 'Celulares', 5),
(10, 'Procesadores', 2),
(11, 'Teclados', 3),
(12, 'MousePad', 3),
(13, 'Adaptadores', 4),
(14, 'LED', 4),
(15, 'Tarjetas de Video', 2),
(16, 'Cables', 4),
(18, 'Tabletas', 5),
(21, 'Mouse', 3),
(22, 'Pantalla', 7),
(23, 'WebCam', 9);

-- END TABLE tipo_producto

-- BEGIN TABLE usuario
DROP TABLE IF EXISTS usuario;
CREATE TABLE `usuario` (
  `nombre_usuario` varchar(25) NOT NULL,
  `cedula` varchar(9) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasena` varchar(16) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `telefono` varchar(8) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`nombre_usuario`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  UNIQUE KEY `correo_UNIQUE` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 7 rows into usuario
-- Insert batch #1
INSERT INTO usuario (nombre_usuario, cedula, correo, contrasena, nombre, primer_apellido, segundo_apellido, telefono, direccion) VALUES
('ashred', '118020040', 'ashred@test', '123', 'Eduardo', 'Castillo', 'Rodas', '88395948', 'Alajuela, Alajuela'),
('Cliente', '123456789', 'Cliente@test', '123', 'Cliente', 'Cliente', 'Cliente', '', ''),
('Dino', '118110039', 'Dino@test', '123', 'Eduardo', 'Garrido', 'Rivera', '83840935', ''),
('jmora', '12345', 'jmora@test', '123', 'Jose', 'Mora', 'Loria', '123', 'Test'),
('maikmm30', '117270054', 'maikmm30@test', '123', 'Michael', 'Monge', 'Mora', '85398919', ''),
('Prueba', '124', 'Prueba@test', '123', 'wqer213fr', '23f23', 'f243f23', 'd2323f', '23f2'),
('sebas_r3101', '118010634', 'sebas_r3101@test', '123', 'William Sebastian', 'Rojas', 'Ernest', '84597446', 'Esparza');

-- END TABLE usuario

-- BEGIN TABLE usuario_roles
DROP TABLE IF EXISTS usuario_roles;
CREATE TABLE `usuario_roles` (
  `usuario_nombre_usuario` varchar(25) NOT NULL,
  `rol_usuario_id` int(11) NOT NULL,
  KEY `fk_usuario_roles_usuario_nombre_usuario` (`usuario_nombre_usuario`),
  KEY `fk_usuario_roles_rol_usuario_id` (`rol_usuario_id`),
  CONSTRAINT `fk_usuario_roles_rol_usuario_id` FOREIGN KEY (`rol_usuario_id`) REFERENCES `rol_usuario` (`id`),
  CONSTRAINT `fk_usuario_roles_usuario_nombre_usuario` FOREIGN KEY (`usuario_nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting 10 rows into usuario_roles
-- Insert batch #1
INSERT INTO usuario_roles (usuario_nombre_usuario, rol_usuario_id) VALUES
('ashred', 1),
('ashred', 2),
('Dino', 1),
('Dino', 2),
('jmora', 1),
('jmora', 2),
('maikmm30', 1),
('maikmm30', 2),
('sebas_r3101', 1),
('sebas_r3101', 2);

-- END TABLE usuario_roles


-- Crear la base de datos
CREATE DATABASE minech;
USE minech;

-- Crear la tabla usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    categoria VARCHAR(100),
    codigo VARCHAR(50),
    proveedor VARCHAR(100),
    precio_unitario DOUBLE,
    stock INT
);

INSERT INTO usuarios (usuario, password) VALUES ('admin', '1234');
INSERT INTO usuarios (usuario, password) VALUES ('BRIAN', '1234');
INSERT INTO productos (nombre, categoria, codigo, proveedor, precio_unitario, stock) VALUES
('Coca Cola', 'bebidas', 'B001', 'CocaCola Company', 3.5, 100),
('Sprite', 'bebidas', 'B002', 'CocaCola Company', 3.0, 80),
('Chocman', 'chocolates', 'CH001', 'Nestlé', 1.5, 150),
('Sublime', 'chocolates', 'CH002', 'Nestlé', 2.0, 120),
('Galleta Oreo', 'galletas', 'G001', 'Mondelez', 2.0, 90),
('Galleta Casino', 'galletas', 'G002', 'Nestlé', 1.8, 110),
('Caramelo de Menta', 'caramelos', 'CA001', 'Arcor', 0.5, 500),
('Caramelo Frutal', 'caramelos', 'CA002', 'Arcor', 0.6, 450);

SELECT * FROM usuarios;
SELECT * FROM productos;


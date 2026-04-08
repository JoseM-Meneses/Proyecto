CREATE DATABASE tenis_col
USE tenis_col

CREATE TABLE tenis (
    id INT IDENTITY(1,1) PRIMARY KEY,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    precio FLOAT,
    stock INT
);

INSERT INTO tenis (marca, modelo, precio, stock)
VALUES 
('Nike', 'Air Max', 450000, 10),
('Adidas', 'Forum', 500000, 8),
('Puma', 'Speedcat', 300000, 5);

SELECT * FROM tenis

CREATE TABLE compra (
    id INT IDENTITY(1,1) PRIMARY KEY,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    talla INT,
    cantidad INT,
    fecha DATETIME DEFAULT GETDATE()
);

SELECT * FROM compra
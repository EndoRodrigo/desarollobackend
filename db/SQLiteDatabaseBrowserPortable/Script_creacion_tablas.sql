

-- Creación de la tabla de clientes
CREATE TABLE IF NOT EXISTS Clientes (
    id_cliente INTEGER PRIMARY KEY,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    direccion TEXT,
    telefono TEXT
);

-- Creación de la tabla de celulares
CREATE TABLE IF NOT EXISTS Celulares (
    id_celular INTEGER PRIMARY KEY,
    marca TEXT NOT NULL,
    modelo TEXT NOT NULL,
    precio NUMERIC NOT NULL,
    descripcion TEXT
);

-- Creación de la tabla de ventas
CREATE TABLE IF NOT EXISTS Ventas (
    id_venta INTEGER PRIMARY KEY,
    id_cliente INTEGER,
    id_celular INTEGER,
    fecha_venta DATE,
    cantidad INTEGER,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
    FOREIGN KEY (id_celular) REFERENCES Celulares(id_celular)
);

-- Creación de la tabla de usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    id_usuario INTEGER PRIMARY KEY,
    nombre_usuario TEXT NOT NULL,
    contrasena TEXT NOT NULL,
    tipo_usuario TEXT CHECK (tipo_usuario IN ('admin', 'customer')) NOT NULL
);

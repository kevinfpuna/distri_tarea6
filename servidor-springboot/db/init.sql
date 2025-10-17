CREATE TABLE IF NOT EXISTS clientes (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100),
  direccion VARCHAR(200),
  telefono VARCHAR(30)
);
CREATE TABLE IF NOT EXISTS sucursales (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(120),
  ciudad VARCHAR(80)
);
CREATE TABLE IF NOT EXISTS transacciones (
  id SERIAL PRIMARY KEY,
  cliente_id INT,
  fecha DATE,
  descripcion VARCHAR(200),
  monto NUMERIC(14,2)
);
CREATE TABLE IF NOT EXISTS beneficiarios (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(120),
  cuenta VARCHAR(40)
);
CREATE TABLE IF NOT EXISTS transferencias (
  id SERIAL PRIMARY KEY,
  origen_cuenta VARCHAR(40),
  destino_cuenta VARCHAR(40),
  monto NUMERIC(14,2),
  fecha TIMESTAMP DEFAULT NOW()
);
INSERT INTO sucursales (nombre, ciudad) VALUES
('Casa Central', 'Asunción'),
('Sucursal San Lorenzo', 'San Lorenzo'),
('Sucursal Encarnación', 'Encarnación');
INSERT INTO clientes (nombre, direccion, telefono) VALUES
('Juan Pérez','Av. Principal 123','0981-111111'),
('María López','Calle Secundaria 456','0982-222222');
INSERT INTO transacciones (cliente_id, fecha, descripcion, monto) VALUES
(1, CURRENT_DATE, 'Compra supermercado', 250000.00),
(1, CURRENT_DATE - INTERVAL '1 day', 'Pago servicio', 120000.00),
(2, CURRENT_DATE, 'Transferencia recibida', 500000.00);
INSERT INTO beneficiarios (nombre, cuenta) VALUES
('Beneficiario 1', '12345678');

CREATE TABLE IF NOT EXISTS employees(
    id_employee SERIAL PRIMARY KEY,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    position_rol VARCHAR(30) NOT NULL
);
-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON TABLE employees IS 'Tabla para almacenar datos de empleados y roles.';
COMMENT ON COLUMN employees.id_employee IS 'id primary key';
COMMENT ON COLUMN employees.first_name IS 'primer nombre';
COMMENT ON COLUMN employees.last_name IS 'apellidos del empleado';
COMMENT ON COLUMN employees.position_rol IS 'nombre del rol o puesto del empleado';
CREATE TABLE IF NOT EXISTS cat_status_policy(
    id_status SERIAL PRIMARY KEY,
    clave CHAR(3) NOT NULL,
    description VARCHAR(30) NOT NULL
);
-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON TABLE cat_status_policy IS 'Tabla de catalogo para estatus de polizas.';
COMMENT ON COLUMN cat_status_policy.id_status IS 'id primary key';
COMMENT ON COLUMN cat_status_policy.clave IS 'clave que representa el estatus';
COMMENT ON COLUMN cat_status_policy.description IS 'descripcion completa del estatus';
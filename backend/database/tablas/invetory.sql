
CREATE TABLE IF NOT EXISTS inventory(
    sku VARCHAR(50) PRIMARY KEY,
    product_name VARCHAR(60) NOT NULL,
    total_amount INT NOT NULL
);

-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON TABLE inventory IS 'Tabla para almacenar datos de empleados y roles.';
COMMENT ON COLUMN inventory.SKU IS 'primary key';
COMMENT ON COLUMN inventory.product_name IS 'nombre del producto';
COMMENT ON COLUMN inventory.total_amount IS 'cantidad total del producto en stock';
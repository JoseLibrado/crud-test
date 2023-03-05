CREATE TABLE IF NOT EXISTS policies (
    id_policy SERIAL PRIMARY KEY,
    sku VARCHAR(50) NOT NULL,
    amount INT NOT NULL,
    policy_date DATE NOT NULL,
    id_employee INT NOT NULL,
    status_policy CHAR(3),

    FOREIGN KEY ( id_employee )
        REFERENCES employees( id_employee ),
    FOREIGN KEY ( sku )
        REFERENCES Inventory( sku )
    
);
-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON TABLE policies IS 'Tabla para almacenar datos de empleados y roles.';
COMMENT ON COLUMN policies.id_policy IS 'id primary key';
COMMENT ON COLUMN policies.sku IS 'identificador del producto';
COMMENT ON COLUMN policies.amount IS 'cantidad total de faltantes del producto';
COMMENT ON COLUMN policies.policy_date IS 'fecha de creacion de la poliza';
COMMENT ON COLUMN policies.id_employee IS 'identificador del empleado.';
COMMENT ON COLUMN policies.status_policy IS 'estatus que puede tener la poliza.';

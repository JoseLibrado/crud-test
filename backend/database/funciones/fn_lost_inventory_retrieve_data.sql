
CREATE OR REPLACE FUNCTION fn_lost_inventory_retrieve_data(
    inTipoQuery INT,
    inId_policy INT
)
RETURNS TABLE (
    id_policy_data INT ,
    amount_data INT,
    employee_first_name_data  VARCHAR(40),
    employee_last_name_data  VARCHAR(60),
    sku_data VARCHAR(50),
    item_name_data VARCHAR(60),
    status_policy_data VARCHAR(30),
    policy_date_data DATE
)
-- =============================================
-- Autor: Jose Librado Soto Obeso
-- Fecha: 01/03/2023
-- Descripción General: funcion para consultar todas las polizas.
-- Ejemplo: SELECT * FROM fn_lost_inventory_retrieve_data();
-- =============================================
AS 
$$
BEGIN

    IF ( inTipoQuery > 0 ) THEN 
        RETURN QUERY
            SELECT
            p.id_policy,
            p.amount, 
            e.first_name,
            e.last_name,
            p.sku, 
            i.product_name,
            cat.description AS status_policy,
            p.policy_date
            FROM employees e
            INNER JOIN policies p 
            ON e.id_employee = p.id_employee
            INNER JOIN cat_status_policy cat
            ON p.status_policy = cat.clave
            INNER JOIN inventory i 
            ON p.sku = i.sku
            ORDER BY p.id_policy;
    END IF;
    
    RETURN QUERY
        SELECT
        p.id_policy,
        p.amount, 
        e.first_name,
        e.last_name,
        p.sku, 
        i.product_name,
        cat.description AS status_policy,
        p.policy_date
        FROM employees e
        INNER JOIN policies p 
        ON e.id_employee = p.id_employee
        INNER JOIN cat_status_policy cat
        ON p.status_policy = cat.clave
        INNER JOIN inventory i 
        ON p.sku = i.sku
        WHERE p.id_policy = inId_policy;

        
END; 
$$
-- Parámetro SECURITY DEFINER permite la ejecución del contenido de la función sin que el usuario tenga asignado el privilegio sobre los parametros del código. El Parametro (SECURITY DEFINER) es compatible con bases de datos de postgres con versiones 8.4 y superiores
 LANGUAGE plpgsql;

-- Sintaxis que indica el tipo de privilegio que debe tener un usuario.
GRANT execute ON FUNCTION fn_lost_inventory_retrieve_data() TO postgres;
-- tipoderecho = execute

-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON FUNCTION fn_lost_inventory_retrieve_data() IS 'Funcion para consultar las polizas';
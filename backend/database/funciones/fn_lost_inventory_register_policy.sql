
CREATE OR REPLACE FUNCTION fn_lost_inventory_register_policy(
    inSKU VARCHAR(50),
    inAmount INT,
    inId_employee INT
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
-- Descripción General: funcion para registrar en base de datos polizas generadas.
-- Ejemplo: SELECT * FROM fn_lost_inventory_register_policy('MTOHONDA3554235',3,3);
-- =============================================
AS 
$$
DECLARE
    v_id_employee INT;
    v_sku VARCHAR(50);

    v_id_policy INT;

BEGIN
    IF ( inAmount > 0 ) THEN

        SELECT e.id_employee
        into v_id_employee
        FROM
        employees e
        WHERE e.id_employee = inId_employee;

        SELECT i.sku
        INTO v_sku
        FROM inventory i
        WHERE i.sku = inSKU;
        
        IF (v_id_employee > 0 AND v_sku != '') THEN
            INSERT INTO policies
            (sku, amount, policy_date, id_employee, status_policy)
            VALUES(v_sku, inAmount, CURRENT_DATE, v_id_employee, 'PEN')
            RETURNING id_policy INTO v_id_policy;

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
                WHERE p.id_policy = v_id_policy;
        END IF;


    END IF;

END; 
$$
-- Parámetro SECURITY DEFINER permite la ejecución del contenido de la función sin que el usuario tenga asignado el privilegio sobre los parametros del código. El Parametro (SECURITY DEFINER) es compatible con bases de datos de postgres con versiones 8.4 y superiores
 LANGUAGE plpgsql;

-- Sintaxis que indica el tipo de privilegio que debe tener un usuario.
GRANT execute ON FUNCTION fn_lost_inventory_register_policy(inSKU VARCHAR(50), inAmount INT, inId_employee INT) TO postgres;
-- tipoderecho = execute

-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON FUNCTION fn_lost_inventory_register_policy(inSKU VARCHAR(50), inAmount INT, inId_employee INT) IS 'Funcion para crear una poliza,
inSKU = identificar unidco del producto,
inAmount = cantidad de faltantes,
inId_employee = fecha de registo de la poliza';

CREATE OR REPLACE FUNCTION fn_lost_inventory_update_policy(
    inIdPolicy INT,
    inAmount INT
    -- inIdEmployee INT,
    -- inStatusPolicy CHAR(3) 
)
RETURNS TABLE ( policy INT )
-- =============================================
-- Autor: Jose Librado Soto Obeso
-- Fecha: 01/03/2023
-- Descripción General: funcion para consultar todas las polizas.
-- Ejemplo: SELECT * FROM fn_lost_inventory_update_policy();
-- =============================================
AS 
$$
DECLARE 

BEGIN

    UPDATE policies
        SET amount = inAmount 
        -- id_employee = inIdEmployee,
        -- status_policy = inStatusPolicy
    WHERE 
        id_policy = inIdPolicy;
    
    RETURN QUERY
        SELECT id_policy
        FROM policies
        WHERE 
        id_policy = inIdPolicy;

END; 
$$
-- Parámetro SECURITY DEFINER permite la ejecución del contenido de la función sin que el usuario tenga asignado el privilegio sobre los parametros del código. El Parametro (SECURITY DEFINER) es compatible con bases de datos de postgres con versiones 8.4 y superiores
 LANGUAGE plpgsql;

-- Sintaxis que indica el tipo de privilegio que debe tener un usuario.
GRANT execute ON FUNCTION fn_lost_inventory_update_policy(inIdPolicy INT, inAmout INT) TO postgres;
-- tipoderecho = execute

-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON FUNCTION fn_lost_inventory_update_policy(inIdPolicy INT, inAmout INT) IS 'Funcion para consultar las polizas
inIdPolicy = identificar unidco del producto,
inAmout = cantidad de faltantes,
inIdEmployee = fecha de registo de la poliza,
inStatusPolicy = identificador unico del empleado';
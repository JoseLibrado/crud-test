
CREATE OR REPLACE FUNCTION fn_lost_inventory_delete_policy(
    inIdPolicy INT
)
RETURNS TABLE ( policy_deleted INT )
-- =============================================
-- Autor: Jose Librado Soto Obeso
-- Fecha: 01/03/2023
-- Descripción General: funcion para eliminar polizas.
-- Ejemplo: SELECT * FROM fn_lost_inventory_delete_policy();
-- =============================================
AS 
$$
DECLARE 

BEGIN

    RETURN QUERY
        DELETE 
        FROM policies
            WHERE 
            id_policy = inIdPolicy
        RETURNING id_policy AS clean_table;

END; 
$$
-- Parámetro SECURITY DEFINER permite la ejecución del contenido de la función sin que el usuario tenga asignado el privilegio sobre los parametros del código. El Parametro (SECURITY DEFINER) es compatible con bases de datos de postgres con versiones 8.4 y superiores
 LANGUAGE plpgsql;

-- Sintaxis que indica el tipo de privilegio que debe tener un usuario.
GRANT execute ON FUNCTION fn_lost_inventory_delete_policy(inIdPolicy INT) TO postgres;
-- tipoderecho = execute

-- Sintaxis que permite guardar la documentación del objeto. [Diccionario de datos]
COMMENT ON FUNCTION fn_lost_inventory_delete_policy(inIdPolicy INT) IS 'Funcion para consultar las polizas
inIdPolicy = identificar unidco del producto';
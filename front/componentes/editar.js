import {app} from "../src/app.js"

const editar_poliza = async (id_poliza, cantidad, token ) => {

    // const data = await app.borrar.borrar_poliza(id_poliza)
    const { Meta, Data } = await app.editar_modelo.editar_poliza(id_poliza, cantidad, token)
    
    return {
        status: Meta.Status,
        mensaje: Data.Mensaje
    }
}
export {
    editar_poliza
}
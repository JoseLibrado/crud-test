import {app} from "../src/app.js"

const borrar_poliza = async (id_poliza, token) => {

    // const data = await app.borrar.borrar_poliza(id_poliza)
    const { Meta, Data } = await app.borrar_modelo.borrar_poliza(id_poliza, token)

    return {
        status: Meta.Status,
        mensaje: Data.Mensaje
    }
}

export {
    borrar_poliza
}
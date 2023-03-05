import {app} from "../src/app.js"

const borrar_poliza = async (id_poliza) => {

    // const data = await app.borrar.borrar_poliza(id_poliza)
    const { Meta, Data } = await app.borrar.borrar_poliza(id_poliza)

    return {
        status: Meta.Status,
        mensaje: Data.Mensaje
    }
}

export {
    borrar_poliza
}
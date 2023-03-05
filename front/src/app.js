import {poliza_modelo} from "./modelo/polizas.js"
import {consulta_modelo} from "./modelo/consulta.js"
import {borrar_modelo} from "./modelo/borrar.js"
import {editar_modelo} from "./modelo/editar.js"

const app = {
    create: poliza_modelo,
    consulta: consulta_modelo,
    borrar: borrar_modelo,
    editar: editar_modelo
}

export {
    app
}
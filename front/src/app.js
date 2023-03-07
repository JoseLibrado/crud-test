import {poliza_modelo} from "./modelo/polizas.js"
import {consulta_modelo} from "./modelo/consulta.js"
import {borrar_modelo} from "./modelo/borrar.js"
import {editar_modelo} from "./modelo/editar.js"
import {token} from "./modelo/token.js"

const app = {
    poliza_modelo,
    consulta_modelo,
    borrar_modelo,
    editar_modelo,
    token: token
}

export {
    app
}
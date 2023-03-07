import {home} from './componentes/home.js'
import {token} from './componentes/token.js'
import {polizas} from './componentes/polizas.js'
import {consulta} from './componentes/consulta.js'



const init = () => {

    const contenedor = document.querySelector(".main-content")
    const registrar = document.querySelector(".regis")
    const inventary = document.querySelector(".inv")
    const empleadoss = document.querySelector(".emp")




    home()
    empleadoss.onclick = () => {
        contenedor.innerHTML = ""
        token()
        empleadoss.classList.add("selected")
        registrar.classList.remove("class","selected")
        inventary.classList.remove("class","selected")

    }

    registrar.onclick = () => {
        contenedor.innerHTML = ""
        polizas()
        registrar.classList.add("selected")
        empleadoss.classList.remove("selected")
        inventary.classList.remove("class","selected")
    }
    inventary.onclick = () => {
        contenedor.innerHTML = ""
        consulta()
        inventary.classList.add("selected")
        registrar.classList.remove("selected")
        empleadoss.classList.remove("selected")
    }
}

init() 
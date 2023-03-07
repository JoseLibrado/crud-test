import { app } from "../src/app.js"
const token = () => {

    const div = document.createElement("div")
    div.classList.add("empleados-cont")

    const p =document.createElement("p")
    p.classList.add("empleados-titulo")
    p.innerText = "Generador de Token."

    const tb = document.createElement("table")
    tb.classList.add("grid-empleados")

    const tb_header = `
    <div class="consulta class-token">
        <div class="div-token">
            <button class="bt-token">Token</button>
        </div>
        <div class="div-token">
            <p>token:</p>
            <p class="token"></p>
        </div>
    </div>
`
    
    tb.innerHTML = tb_header
    div.append(p)
    div.append(tb)
    document.querySelector(".main-content").append(div)

    document.querySelector(".bt-token").onclick = async () => {

        const {token} = await app.token.generar_token()
        app.token.autorization = token
        document.querySelector(".token").innerText = token
        console.log(token)
    }
    
    
}

const registro = (id, nombre, apellido, puesto) => {
    return `
        <tr>
            <td>${id}</td>
            <td>${nombre}</td>
            <td>${apellido}</td>
            <td>${puesto}</td>
        </tr>`
    
}

export {
    token
}
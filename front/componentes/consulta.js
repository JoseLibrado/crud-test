import {app} from "../src/app.js"
import {borrar_poliza}  from "./borrar.js"
import {editar_poliza} from "./editar.js"

const SUCCESSFUL_RETRIEVE_POLICY = "Poliza Consultada."

const consulta = () => {

    //creacion de pantalla
    pantalla()
    // consulta a ms
    obtenerValores()
}

const pantalla = () => {
    const arbol = document.querySelector(".main-content")
    const div = document.createElement("div")
    div.classList.add("consulta-cont")

    const tb = document.createElement("table")
    tb.classList.add("grid-consulta")

    const tb_header = `
                    <tr>
                        <th>Id poliza</th>
                        <th>Cantidad</th>
                        <th>SKU </th>
                        <th>Articulo</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Estatus</th>
                        <th>Fecha</th>
                        <th>Editar</th>
                        <th>Borrar</th>
                    </tr>`
    

    tb.innerHTML = tb_header
    div.append(tb)

    arbol.innerHTML = `
                <div class="dash-consulta">
                    <div class="consulta">
                        <div class="controles-consulta">
                            <p class="header-resumen">Consulta Poliza</p>
                        </div>
                        <div class="lista">
                            <input type="text" id="idpoliza" placeholder="ID Poliza">
                            <button class="consultar">Consultar</button>
                            <button class="update-delete" disabled>Update/Delete</button>
                            <button class="cancelar">Reset</button>
                        </div>
                    </div>
                    <div class="resumen">
                        <div class="consulta-controles">
                            <p class="header-resumen">Resumen</p>
                        </div>
                        <div class="listas">
                            <ul class="lista">
                                <li>Pendientes</li>
                                <li>Revision</li>
                                <li>Finalizada</li>
                                <li>Cancelada</li>
                            </ul>
                        </div>
                    </div>
                </div>
    `
    arbol.append(div)
    // tb.innerHTML += registro(1,"Lavadora wifi integrado","LAVAWIRP93858503", 2, "Jose Soto", "CAN","2021-03-30")
    
}


const registro = (id, cantidad, sku, producto, nombre, apellido, estatus, fecha ) => {
    
    const ta = document.querySelector("tbody")
    
    ta.innerHTML += 
    `
        <tr class="registro-recuperado">
            <td>${id}</td>
            <td>${cantidad}</td>
            <td>${sku}</td>
            <td>${producto}</td>
            <td>${nombre}</td>
            <td>${apellido}</td>
            <td>${estatus}</td>
            <td>${fecha}</td>
            <td><div><div  class="editar"></div>
            <td><div><div class="borrar"></div>
        </tr>`

    const  editar = document.querySelector(".editar")
    const  borrar = document.querySelector(".borrar")

    borrar.onclick = () => {
        
        const btn_up = document.querySelector(".update-delete")
        btn_up.disabled = false

        document.querySelector(".mensaje").remove()

        console.log(id)
        btn_up.onclick = async () => {
            const {mensaje, status} = await borrar_poliza(id)
        
            if ( status == "FAILURE" || status == "FAILED" ) {
    
                document.querySelector(".mensaje").remove()
    
                failed(mensaje, document.querySelector(".consultar"))
        
                return
            }
            const registro = document.querySelector(".registro-recuperado") 
            registro.classList.add("inhabil")
            
            successful(mensaje.IDMensaje, document.querySelector(".consultar"))
            btn_up.disabled = true
        }
        
        
    }
    editar.onclick = () => {
        const btn_up = document.querySelector(".update-delete")
        btn_up.disabled = false
        const update_id = document.querySelectorAll("td")[1]
        let val = update_id.textContent
        const campo = document.createElement("input")
        campo.setAttribute("id", "idpoliza-update")
        campo.value = val
        update_id.textContent = ""

        update_id.append(campo)
        
        document.querySelector(".mensaje").remove()
        
        const registro = document.querySelector(".registro-recuperado") 
        registro.classList.add("inhabil")

        btn_up.onclick = async () => {
            btn_up.disabled = true
            const {mensaje, status} = await editar_poliza(id, campo.value) 

            if ( status == "FAILURE" || status == "FAILED" ) {

                document.querySelector(".mensaje").remove()

                failed(mensaje, document.querySelector(".consultar"))
        
                return
            }
            // registro.classList.add("success")
            update_id.innerHTML = `<td>${campo.value}</td>`
            campo.remove()
            successful(mensaje.IDMensaje, document.querySelector(".consultar"))

        }


    }
        
        
    
}

const obtenerValores = () => {

    const consultar = document.querySelector(".consultar")

    consultar.onclick = () => {

        const id_poliza = document.querySelector("#idpoliza")
         
        if ( id_poliza.value == "" ) return 

        consultar.disabled = true
        const obj =  {
            btn_desbloquear: consultar,
            valores: [id_poliza] 
        }
        peticion(obj)


    }
}

const peticion = async (objeto) => {
    
    const {Data, Meta} = await app.consulta.consultar_poliza(0,(objeto.valores[0].value * 1))
    if ( {Data, Meta} ) {

        mostrar_resultados({Data, Meta},objeto)
    }
}

const mostrar_resultados = ({Data, Meta}, {btn_desbloquear}) => {

    if ( Meta.Status == "FAILURE" || Meta.Status == "FAILED" ) {

        failed(Data.Mensaje, btn_desbloquear)

        return
    }

    registro(
        Data.Poliza.IDPoliza, 
        Data.Poliza.Cantidad, 
        Data.DetalleArticulo.SKU,
        Data.DetalleArticulo.Nombre,
        Data.Empleado.Nombre,
        Data.Empleado.Apellido , 
        "Pendiente", 
        "2023-03-04")

    successful(SUCCESSFUL_RETRIEVE_POLICY, btn_desbloquear)

}

const successful = (mensaje, btn_desbloquear) => {

    const arbol = document.querySelector(".main-content")
    const div_response = document.createElement("div")
    div_response.classList.add("mensaje")

    div_response.innerText = mensaje
    arbol.append(div_response)
    div_response.classList.add("success")
    
    reset( btn_desbloquear)
}

const failed = (mensaje, btn_desbloquear) => {

    const arbol = document.querySelector(".main-content")
    const div_response = document.createElement("div")
    div_response.classList.add("mensaje")
    
    div_response.classList.remove("success")
    div_response.classList.add("failed")
    div_response.innerText = mensaje
    arbol.append(div_response)

    reset( btn_desbloquear)

}

const reset = (btn) => {
    document.querySelector(".cancelar").onclick = () => {

        const registro = document.querySelector(".registro-recuperado") 
        if ( registro ) registro.remove()

        const msj = document.querySelector(".mensaje")
        if ( msj ) msj.remove()

        document.querySelector("#idpoliza").value = ""

        btn.disabled = false
        document.querySelector(".update-delete").disabled = true



    }
}

export {
    consulta
}
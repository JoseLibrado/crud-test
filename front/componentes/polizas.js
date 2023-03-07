import {app} from "../src/app.js"

const polizas = () => {

    const arbol =document.querySelector(".main-content")

    const div_response = document.createElement("div")
    div_response.classList.add("mensaje")
    
    const div = document.createElement("div")
    div.classList.add("polizas-cont")

    const p =document.createElement("p")
    p.classList.add("polizas-titulo")
    p.innerText = "Polizas."

    const tb = document.createElement("table")
    tb.classList.add("grid-polizas")

    const tb_header = `
                    <tr>
                        <th>ID</th>
                        <th>SKU</th>
                        <th>Cantidad</th>
                        <th>Asignar</th>
                    </tr>`
    
    tb.innerHTML = tb_header
    // div.append(p)
    div.append(tb)
    arbol.innerHTML = `
                    <div class="campos">
                        <div>
                            <input type="text" id="sku" placeholder="SKU">
                        </div>
                        <div>
                            <input type="text" id="cantidad" placeholder="Cantidad">
                        </div>
                        <div>
                            <input type="text" id="asinado" placeholder="Nombre Apellido">
                        </div>
                    </div>
                    <div class="controles">
                        <div>
                        <button class="continuar">Continuar</button>
                        </div>
                        <div>
                        <button class="confirmar" disabled>Confirmar</button>
                        </div>
                        <div>
                        <button class="cancelar">Reset</button>
                        </div>
                    </div>
    `
    arbol.append(div)
    // tb.innerHTML += registro("LAVAWIRP93858503","1", "Jose Soto")
    // tb.innerHTML += registro(1,"Lavadora wifi integrado","LAVAWIRP93858503", 2, "Jose Soto", "CAN","2021-03-30")
    
    const btn = document.querySelector(".continuar")
    const confir = document.querySelector(".confirmar")

    //PETICION GUARDADO
    const sku = document.querySelector("#sku")
    const cantidad = document.querySelector("#cantidad")
    const empleado = document.querySelector("#asinado")

    cancelar(sku, cantidad, empleado, [btn, confir])

    btn.onclick = () => {

        if ( !(sku.value != '' && cantidad.value != '' && empleado.value != '') ) return
        
        btn.disabled = true
        confir.disabled = false

        if ( confirmar(sku.value, cantidad.value, empleado.value) ) {
            
            confir.onclick = async () => {

                console.log(app.token.autorization)

                app.poliza_modelo.token = app.token.autorization

                confir.disabled = true
                
                const data = await app.poliza_modelo.crear(sku.value,cantidad.value,empleado.value)
                console.log(data)
                if( data ) {
                    if ( data.Meta.Status == "FAILURE" || data.Meta.Status == "FAILED"  ) {
        
                        div_response.classList.remove("success")
                        div_response.classList.add("failed")
                        div_response.innerText = data.Data.Mensaje
                        arbol.append(div_response)
                        
                        confir.disabled = true
                        sku.value = ''
                        cantidad.value = ''
                        empleado.value = ''

                        return
                    }
                    btn.disabled = false
                    confir.disabled = true
                    sku.value = ''
                    cantidad.value = ''
                    empleado.value = ''

                    document.querySelector("#id_pol").innerText = data.Data.Poliza.IDPoliza
                    div_response.innerText = "Poliza Registada."
                    arbol.append(div_response)
                    div_response.classList.add("success")
                }

            }
        }
    }
}
const registro = (sku, cantidad, empleado ) => {
    return `
        <tr class="informacion">
            <td id="id_pol"></td>
            <td id="id_sku">${sku}</td>
            <td id="id_cantidad">${cantidad}</td>
            <td id="id_empleado">${empleado}</td>
        </tr>`
    
}

const confirmar = (sku_c, cantidad_c, empleado_c) => {

    const ta = document.querySelector("tbody")

    ta.innerHTML +=  registro(sku_c, cantidad_c, empleado_c)

    return true
}

const cancelar = (sku, cantidad, empleado, arrbtns) => {
    const can = document.querySelector(".cancelar")

    can.onclick = () => {
        sku.value = ''
        cantidad.value = ''
        empleado.value = ''

        arrbtns[0].disabled = false
        arrbtns[1].disabled = true

        const datos = document.querySelector(".informacion")
        const mensaje = document.querySelector(".mensaje")
        if ( datos ) {
            datos.remove()
            mensaje.remove()
        }
    }
}



export {
    polizas
}

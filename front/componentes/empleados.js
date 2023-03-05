const empleados = () => {

    const div = document.createElement("div")
    div.classList.add("empleados-cont")

    const p =document.createElement("p")
    p.classList.add("empleados-titulo")
    p.innerText = "Lista de Empleados."

    const tb = document.createElement("table")
    tb.classList.add("grid-empleados")

    const tb_header = `
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Puesto</th>
                    </tr>`
    
    tb.innerHTML = tb_header
    div.append(p)
    div.append(tb)
    document.querySelector(".main-content").append(div)
    // tb.innerHTML += registro(1,"Librado","Soto","Programador")
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
    empleados
}
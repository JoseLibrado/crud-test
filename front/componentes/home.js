
const home = () => {
    const div = document.createElement("div")
    div.classList.add("welcome")

    const t = document.createElement("p")
    t.classList.add("titulo")
    t.innerText = "Bienvenido."

    const f = document.createElement("p")
    f.classList.add("frase")
    f.innerText = "Del tamaño de tu esfuerzo \n sera tu recompenza !!"
    
    div.append(t)
    div.append(f)
    
    document.querySelector('.main-content').append(div)
    // <div class="welcome">
    //         <p class="titulo">Bienvenido.</p>
    //         <p class="frase"> Del tamaño del esfuerzo, sera la recompenza !!</p>
    //     </div>
}

export {
    home
}
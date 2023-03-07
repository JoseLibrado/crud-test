const consulta_modelo = {
    /**
     * Consultar set de polizas
        tipo consulta = 0
        id_poliza = 0 
    * Consultar una poliza
        tipo consulta = 1
        id_poliza = (id poliza existente en base de datos)
    */
    consultar_poliza:  async (tipo_consulta, id_poliza, token) => {

        console.log(tipo_consulta, id_poliza)
        
        try {

            let myHeaders = new Headers()

            myHeaders.append("Authorization", "Bearer " + token)
            myHeaders.append("Content-Type", "application/json")

            console.log("modelo... ",token)

            let requestOptions = {
            method: 'GET',
            headers: myHeaders,
            // body: urlencoded,
            redirect: 'follow'
            };

            let endpoint = `http://localhost:8081/app/api/v1/policies/retrieve-policies?tipoQ=${tipo_consulta}&idPolicy=${id_poliza}`

            const resp = await fetch(endpoint, requestOptions)
            const data = await resp.json().catch( e => {throw new Error("Genera un Token para ejecutar la operacion")} )
            console.log(data)
            if ( data.status == 400) throw new Error(data.error)

            if ( data.Meta.Status == "OK" ) return data
            if ( data.Meta.Status == "FAILURE" ) return data
            if ( data.status != 200) throw new Error(data.error)
        } catch (error) {
            return {
                Meta: {
                    Status: "FAILED"
                },
                Data: {
                    Mensaje: "Presiona 'Reset', si continua el error, comunicarse a Soporte... \n" + error.toString()
                }
            }
        }

        
    },
    token : ""

}

export {
    consulta_modelo
}
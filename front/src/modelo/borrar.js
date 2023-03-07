const borrar_modelo = {
    /**
     * Eliminar poliza por id
       
    */

    borrar_poliza: async (id_poliza, token) => {

        console.log(token)
        try {
            let endpoint = `http://localhost:8081/app/api/v1/policies/delete-policy/${id_poliza}`
            
            let myHeaders = new Headers()
            myHeaders.append("Authorization", "Bearer " + token)
            myHeaders.append("Content-Type", "application/json")

            let requestOptions = {
                method: 'DELETE',
                redirect: 'follow',
                headers: myHeaders
            }
            
            const resp = await fetch( endpoint, requestOptions )
            const data = await resp.json().catch( e => "Genera un Token para ejecutar la operacion" )

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
    borrar_modelo
}
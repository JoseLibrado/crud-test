const editar_modelo = {
    /**
     * Eliminar poliza por id
       
    */

    editar_poliza: async (id_poliza, new_cantidad, token) => {

        try {
            let endpoint = `http://localhost:8081/app/api/v1/policies/update-policy/${id_poliza}`
           
            let myHeaders = new Headers()
            myHeaders.append("Authorization", "Bearer " + token)
            myHeaders.append("Content-Type", "application/json")

            let raw = JSON.stringify({
            "amount": new_cantidad
            })

            var requestOptions = {
            method: 'PUT',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
            }

            const resp = await fetch( endpoint, requestOptions )
            const data = await resp.json()

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
    editar_modelo
}
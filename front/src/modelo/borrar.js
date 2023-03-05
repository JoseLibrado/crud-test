const borrar_modelo = {
    /**
     * Eliminar poliza por id
       
    */

    borrar_poliza: async (id_poliza) => {

        try {
            let endpoint = `http://localhost:8080/app/api/policies/delete-policy/${id_poliza}`
            let requestOptions = {
                method: 'DELETE',
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


    }

}

export {
    borrar_modelo
}
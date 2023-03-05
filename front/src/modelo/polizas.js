const poliza_modelo = {
    crear: async function(sku, cantidad, idEmploye) {

        try {
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            var raw = JSON.stringify({
            "sku": sku,
            "amout": cantidad,
            "idEmploye": idEmploye
            });

            var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
            };

            const res = await fetch("http://localhost:8080/app/api/policies/create-policy", requestOptions)
            const data = await res.json()
            console.log(data)

            
            if ( data.status == 400) throw new Error(data.error)

            if ( data.Meta.Status == "OK" ) return data
            if ( data.Meta.Status == "FAILURE" ) return data
            if ( data.status != 200) throw new Error(data.error)



        } catch ( error ) {
            return {
                Meta: {
                    Status: "FAILED"
                },
                Data: {
                    Mensaje: "Presiona 'Reset', si continua el error, comunicarse a Soporte... \n" + error.toString()
                }
            }
                
            
        }
        // fetch("http://localhost:8080/app/api/policies/create-policy", requestOptions)
        // .then(response => response.text())
        // .then(result => console.log(result))
        // .catch(error => console.log('error', error));
    }
}

export {
    poliza_modelo
}
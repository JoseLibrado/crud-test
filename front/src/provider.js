

const getPolicies = async (tq, idp) => {
    let urlApi = `http://localhost:8080/app/api/policies/retrieve-policies?tipoQ=${tq}&idPolicy=${idp}`
    
    try {

        var urlencoded = new URLSearchParams();

        var requestOptions = {
        method: 'GET',
        // body: urlencoded,
        redirect: 'follow'
        };

        // fetch(urlApi, requestOptions)
        // .then(response => response.text())
        // .then(result => console.log(result))
        // .catch(error => console.log('error', error));

        const resp = await fetch(urlApi,requestOptions)

        // if(!resp.ok) throw 'Ocurrio algo inesperado'

        const data = await resp.json()
        console.log(data)
        return data;
    } catch (err) {
        throw err
    }
    
}
export {
    getPolicies,
}




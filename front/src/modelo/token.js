const token = {
    generar_token: async () => {

        try {
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            var raw = JSON.stringify({
            "name": "ws_crud",
            "password": "1234"
            });

            var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
            };

            const resp = await fetch("http://localhost:8081/app/api/v1/auth/authenticate", requestOptions)
            const data = await resp.json()
            console.log(data)
            return data
        } catch (error) {
            return error
        }
    },
    autorization : ""
}

export {
    token
}
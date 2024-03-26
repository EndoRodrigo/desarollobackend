document.addEventListener('DOMContentLoaded', function () {

    // Obtener el botón por su ID
    let btnSubmit = document.getElementById("login");
    console.log("Pagina del login cargada......")

    // Agregar un evento de clic al botón
    btnSubmit.addEventListener("click", function (e) {
        event.preventDefault();
        console.log("Llamado a la api de autenticacion......")
        valideUser();
    });


    async function valideUser() {

        try {

            let email = document.getElementsByName("email")[0].value;
            let pswd = document.getElementsByName("pswd")[0].value;

            /* Objeto con los datos del usuario
            const data = {
                email: email,
                password: pswd
            };*/

            const data = {
                id: 2,
                name: "Endo Rodrigo",
                mail: "test@gmail.com",
                password: "12345"
            }


            const apiUrl = 'http://localhost:8080/api/login/validate';

            const response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'X-API-KEY': 'Baeldung'
                },
                body: JSON.stringify(data)
            });

            if (!response.ok) {
                throw new Error('Error al obtener los datos');
            }

            const respuesta = await response.text();
            localStorage.setItem("token", respuesta);
            console.log(respuesta);

            if (response != '') {

                const poslog = {
                    id: 2,
                    name: "Endo Rodrigo",
                    mail: "test@gmail.com"
                };
                const poslogJSON = JSON.stringify(poslog);
                localStorage.setItem("venta", poslogJSON);

                window.location.href = "home.html";
            }

        } catch (error) {
            console.error('Error:', error);
        }
    }





});




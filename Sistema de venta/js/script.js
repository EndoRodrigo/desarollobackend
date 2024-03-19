document.addEventListener("DOMContentLoaded", function () {
    cargarTablaUsuarioCelular();
});

function cargarTablaUsuarioCelular() {
    // Simula obtener datos del servidor (puedes reemplazarlo con llamadas reales a la API)
    const datosSimulados = [
        {
            id: 1,
            nombre: "Usuario1",
            correo: "usuario1@example.com",
            contraseña: "contrasena1",
            celular: {
                marca: "Marca1",
                modelo: "Modelo1",
                precio: 499.99
            }
        },
        // Agregar más datos según sea necesario
    ];

    const tablaUsuarioCelular = document.getElementById("tabla-usuario-celular");
    tablaUsuarioCelular.innerHTML = ""; // Limpiar la tabla antes de cargar nuevos datos

    datosSimulados.forEach(usuarioCelular => {
        const fila = document.createElement("div");
        fila.classList.add("fila-usuario-celular");
        fila.innerHTML = `
            <span>ID: ${usuarioCelular.id}</span>
            <span>Nombre: ${usuarioCelular.nombre}</span>
            <span>Correo: ${usuarioCelular.correo}</span>
            <span>Marca: ${usuarioCelular.celular.marca}</span>
            <span>Modelo: ${usuarioCelular.celular.modelo}</span>
            <span>Precio: ${usuarioCelular.celular.precio}</span>
            <button onclick="editarUsuarioCelular(${usuarioCelular.id})">Editar</button>
            <button onclick="eliminarUsuarioCelular(${usuarioCelular.id})">Eliminar</button>
        `;
        tablaUsuarioCelular.appendChild(fila);
    });
}

function crearUsuarioCelular() {
    // Obtener valores del formulario
    const nombre = document.getElementById("nombre").value;
    const correo = document.getElementById("correo").value;
    const contraseña = document.getElementById("contrasena").value;
    const marca = document.getElementById("marca").value;
    const modelo = document.getElementById("modelo").value;
    const precio = parseFloat(document.getElementById("precio").value);

    // Simular enviar datos al servidor (puedes reemplazarlo con llamadas reales a la API)
    const nuevoUsuarioCelular = {
        nombre: nombre,
        correo: correo,
        contraseña: contraseña,
        celular: {
            marca: marca,
            modelo: modelo,
            precio: precio
        }
    };

    // Simular respuesta del servidor (puedes reemplazarlo con una lógica real)
    const respuestaSimulada = {
        id: Math.floor(Math.random() * 1000) + 1 // ID simulado
    };

    nuevoUsuarioCelular.id = respuestaSimulada.id; // Asignar el ID simulado al nuevo usuarioCelular

    // Agregar el nuevo usuarioCelular a la lista simulada
    // (normalmente, aquí harías una llamada a la API para agregarlo al backend)
    // En este ejemplo, simplemente lo agregamos a la lista simulada
    const datosSimulados = [
        ...datosSimulados,
        nuevoUsuarioCelular
    ];

    // Limpiar el formulario
    document.getElementById("formulario-usuario-celular").reset();

    // Recargar la tabla con los datos actualizados
    cargarTablaUsuarioCelular();
}

function editarUsuarioCelular(id) {
    // Implementar lógica de edición según tus necesidades
    alert(`Editar UsuarioCelular con ID ${id}`);
}

function eliminarUsuarioCelular(id) {
    // Implementar lógica de eliminación según tus necesidades
    alert(`Eliminar UsuarioCelular con ID ${id}`);
    // Simular eliminación del usuarioCelular (puedes reemplazarlo con una llamada real a la API)
    // En este ejemplo, simplemente eliminamos el usuarioCelular de la lista simulada
    const datosSimuladosActualizados = datosSimulados.filter(usuarioCelular => usuarioCelular.id !== id);
    datosSimulados = datosSimuladosActualizados;
    // Recargar la tabla con los datos actualizados
    cargarTablaUsuarioCelular();
}

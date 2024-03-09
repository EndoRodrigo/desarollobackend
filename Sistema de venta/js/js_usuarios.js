document.addEventListener("DOMContentLoaded", function () {
    cargarTablaUsuarios();
});

function cargarTablaUsuarios() {
    fetch('http://localhost:8080/api/user/v2')
        .then(response => response.json())
        .then(data => {
            const tablaUsuarios = document.getElementById("tabla-usuarios");
            tablaUsuarios.innerHTML = ""; // Limpiar la tabla antes de cargar nuevos datos

            // Crear encabezado de la tabla
            const encabezado = document.createElement("tr");
            encabezado.innerHTML = "<th>ID</th><th>Nombre</th><th>Correo</th><th>Acciones</th>";
            tablaUsuarios.appendChild(encabezado);

            // Llenar la tabla con los datos
            data.forEach(usuario => {
                const fila = document.createElement("tr");
                fila.innerHTML = `
                    <td>${usuario.id}</td>
                    <td>${usuario.nombre}</td>
                    <td>${usuario.correo}</td>
                    <td>
                        <button onclick="editarUsuario(${usuario.id})">Editar</button>
                        <button onclick="eliminarUsuario(${usuario.id})">Eliminar</button>
                    </td>
                `;
                tablaUsuarios.appendChild(fila);
            });
        })
        .catch(error => console.error('Error al cargar la tabla:', error));
}

function crearUsuario() {
    const nombre = document.getElementById("nombre").value;
    const correo = document.getElementById("correo").value;
    const contraseña = document.getElementById("contrasena").value;

    const nuevoUsuario = {
        nombre: nombre,
        correo: correo,
        contraseña: contraseña
    };

    fetch('http://localhost:8080/api/user/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuevoUsuario)
    })
        .then(response => response.json())
        .then(data => {
            alert('Usuario creado con éxito. ID: ' + data.id);
            cargarTablaUsuarios();
        })
        .catch(error => console.error('Error al crear el usuario:', error));
}

function editarUsuario(id) {
    // Implementar lógica de edición según tus necesidades
    alert(`Editar Usuario con ID ${id}`);
}

function eliminarUsuario() {
    fetch(`http://localhost:8080/api/user/update/`, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert(data);
            cargarTablaUsuarios();
        })
        .catch(error => console.error('Error al eliminar el usuario:', error));
}

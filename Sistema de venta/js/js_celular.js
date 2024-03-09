document.addEventListener("DOMContentLoaded", function () {
    cargarTablaCelulares();
});

function cargarTablaCelulares() {
    fetch('http://localhost:8080/ventas/listado')
        .then(response => response.json())
        .then(data => {
            const tablaCelulares = document.getElementById("tabla-celulares");
            tablaCelulares.innerHTML = ""; // Limpiar la tabla antes de cargar nuevos datos

            // Crear encabezado de la tabla
            const encabezado = document.createElement("tr");
            encabezado.innerHTML = "<th>ID</th><th>Marca</th><th>Modelo</th><th>Precio</th><th>Acciones</th>";
            tablaCelulares.appendChild(encabezado);

            // Llenar la tabla con los datos
            data.forEach(celular => {
                const fila = document.createElement("tr");
                fila.innerHTML = `
                    <td>${celular.id}</td>
                    <td>${celular.marca}</td>
                    <td>${celular.modelo}</td>
                    <td>${celular.precio}</td>
                    <td>
                        <button onclick="editarCelular(${celular.id})">Editar</button>
                        <button onclick="eliminarCelular(${celular.id})">Eliminar</button>
                    </td>
                `;
                tablaCelulares.appendChild(fila);
            });
        })
        .catch(error => console.error('Error al cargar la tabla:', error));
}

function crearCelular() {
    const marca = document.getElementById("marca").value;
    const modelo = document.getElementById("modelo").value;
    const precio = parseFloat(document.getElementById("precio").value);

    const nuevoCelular = {
        marca: marca,
        modelo: modelo,
        precio: precio
    };

    fetch('http://localhost:8080/ventas/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuevoCelular)
    })
        .then(response => response.json())
        .then(data => {
            alert('Celular creado con éxito. ID: ' + data.id);
            cargarTablaCelulares();
        })
        .catch(error => console.error('Error al crear el celular:', error));
}

function editarCelular(id) {
    // Implementar lógica de edición según tus necesidades
    alert(`Editar Celular con ID ${id}`);
}

function eliminarCelular(id) {
    fetch(`/api/celulares/${id}`, {
        method: 'DELETE'
    })
        .then(response => response.text())
        .then(data => {
            alert(data);
            cargarTablaCelulares();
        })
        .catch(error => console.error('Error al eliminar el celular:', error));
}

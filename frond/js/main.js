document.addEventListener('DOMContentLoaded', function () {
    console.log("Pagina cargo con exito");
    obtenerProductos();
});


const contenedorProductos = document.querySelector("#contenedor-productos");
const botonesCategorias = document.querySelectorAll(".boton-categoria");
const tituloPrincipal = document.querySelector("#titulo-principal");
let botonesAgregar = document.querySelectorAll(".producto-agregar");
const numerito = document.querySelector("#numerito");


botonesCategorias.forEach(boton => boton.addEventListener("click", () => {
    aside.classList.remove("aside-visible");
}))



async function obtenerProductos() {
    try {
        const apiUrl = 'http://localhost:8080/api/listphone';
        const response = await fetch(apiUrl, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'X-API-KEY': localStorage.getItem("token")
            },
        });

        if (!response.ok) {
            throw new Error('Error al obtener los datos');
        }
        const productos = await response.json();
        console.log(productos);

        cargarProductos(productos);
    } catch (error) {
        console.error('Error:', error);
    }
}

let btn_filtro = document.getElementById("GAMA ALTA");
let btn_filtro2 = document.getElementById("GAMA MEDIA");
let btn_filtro3 = document.getElementById("GAMA BAJA");
let btn_filtro4 = document.getElementById("todos");

btn_filtro.addEventListener("click", function (e) {
    e.preventDefault();
    obtenerProductosPorName("GAMA ALTA");
});

btn_filtro2.addEventListener("click", function (e) {
    e.preventDefault();
    obtenerProductosPorName("GAMA MEDIA");
});

btn_filtro3.addEventListener("click", function (e) {
    e.preventDefault();
    obtenerProductosPorName("GAMA BAJA");
});

btn_filtro4.addEventListener("click", function (e) {
    e.preventDefault();
    obtenerProductos();
});

async function obtenerProductosPorName(gama) {
    try {
        const apiUrl = 'http://localhost:8080/api/phone/name/' + gama;
        const response = await fetch(apiUrl, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'X-API-KEY': localStorage.getItem("token")
            },
        });

        if (!response.ok) {
            throw new Error('Error al obtener los datos');
        }
        const productos = await response.json();
        console.log(productos);
        cargarProductos(productos);
    } catch (error) {
        console.error('Error:', error);
    }
}




function cargarProductos(productosElegidos) {

    contenedorProductos.innerHTML = "";

    productosElegidos.forEach(producto => {

        const div = document.createElement("div");
        div.classList.add("producto");
        div.innerHTML = `
            <img class="producto-imagen" src="${producto.image}" alt="${producto.name}">
            <div class="producto-detalles">
                <h3 id="name" class="producto-titulo">${producto.name}</h3>
                <p id="price" class="producto-precio">$${producto.price}</p>
                <button  class="producto-agregar" id="${producto.id}">Agregar</button>
            </div>
        `;

        contenedorProductos.append(div);
    })

    actualizarBotonesAgregar();
}


botonesCategorias.forEach(boton => {
    boton.addEventListener("click", (e) => {

        botonesCategorias.forEach(boton => boton.classList.remove("active"));
        e.currentTarget.classList.add("active");
        if (e.currentTarget.id != "todos") {
            console.log(e.currentTarget.id);
            const productoCategoria = productos.find(producto => producto.gama === e.currentTarget.id);
            tituloPrincipal.innerText = productoCategoria.gama;
            const productosBoton = productos.filter(producto => producto.gama === e.currentTarget.id);
            cargarProductos(productosBoton);
        } else {
            tituloPrincipal.innerText = "TODOS LOS PRODUCTOS";
            cargarProductos(productos);
        }

    })
});

function actualizarBotonesAgregar() {
    botonesAgregar = document.querySelectorAll(".producto-agregar");

    botonesAgregar.forEach(boton => {
        boton.addEventListener("click", agregarAlCarrito);
    });
}



let poslog = localStorage.getItem("poslog");
let index = 0;
let cadena = index.toString();
function agregarAlCarrito(e) {

    console.log(e);
    const id = e.currentTarget.id;
    console.log(id);
    let contador = id - 1;
    let nname = document.getElementsByClassName("producto-titulo")[contador].innerText;
    console.log(nname);
    let pprice = document.getElementsByClassName("producto-precio")[contador].innerText;
    console.log(pprice);
    let iimage = document.getElementsByClassName("producto-imagen")[contador].getAttribute("src");
    console.log(iimage);
    


    let miDiccionarioJSON = localStorage.getItem("venta");
    let miDiccionario = JSON.parse(miDiccionarioJSON);
    console.log(miDiccionario);


    phone = {
        id: id,
        name: nname,
        img: iimage,
        price: pprice,
        count: 1
    }

    if (miDiccionario.hasOwnProperty('phone')) {
        alert("Solo puedes comprar un articulo por transacion")
    } else {
        miDiccionario["phone"] = phone;
        console.log(miDiccionario);

        miDiccionarioJSON = JSON.stringify(miDiccionario);
        localStorage.setItem("venta", miDiccionarioJSON);
    }

    let productosEnCarritoLS = localStorage.getItem("venta");
    let productosEnCarrito = JSON.parse(productosEnCarritoLS);

    if (productosEnCarrito.hasOwnProperty('phone')) {
        numerito.textContent = 1;
    } else {
        console.log('El array no está vacío');
    }
}

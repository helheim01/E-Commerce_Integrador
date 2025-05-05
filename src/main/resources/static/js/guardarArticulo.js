// Obtener elementos
const botonRegistrar  = document.getElementById("btnRegistrar");
const selectCategoria = document.getElementById("categoria");
const formArticulo    = document.getElementById("formArticulo");

// 1) Carga de categorías
async function cargarCategorias() {
  try {
    const res = await fetch("http://localhost:8080/categoria");
    if (!res.ok) throw new Error("No se pudieron cargar categorías");
    const cats = await res.json();
    cats.forEach(cat => {
      const o = document.createElement("option");
      o.value       = cat.nombre; // Suponiendo que estás guardando el nombre, no el ID
      o.textContent = cat.nombre;
      selectCategoria.appendChild(o);
    });
  } catch (e) {
    console.error(e);
    alert("Error al cargar categorías");
  }
}

// 2) En lugar de submit nativo, escuchamos el click:
botonRegistrar.addEventListener("click", async () => {
  const nombre      = document.getElementById("nombre").value.trim();
  const precio      = parseFloat(document.getElementById("precio").value);
  const descripcion = document.getElementById("descripcion").value.trim();
  const imagenes    = document.getElementById("imagenes").files[0]?.name || "";
  const disponible  = document.getElementById("disponible").checked;
  const stock       = parseInt(document.getElementById("stock").value, 10);

  // Validación de campos obligatorios
  if (!nombre || isNaN(precio) || !descripcion || isNaN(stock)) {
    alert("Por favor, completá todos los campos correctamente.");
    return;
  }

  const articulo = {
    nombre,
    precio,
    descripcion,
    imagenes,
    disponible,
    stock
  };

  try {
    const resp = await fetch("http://localhost:8080/articulos/guardarArticulo", {
      method:  "POST",
      headers: { "Content-Type": "application/json" },
      body:    JSON.stringify(articulo)
    });

    if (resp.ok) {
      alert("Artículo guardado correctamente.");
      formArticulo.reset();
    } else {
      const msg = await resp.text();
      throw new Error(msg || "Error desconocido");
    }
  } catch (err) {
    console.error(err);
    alert("Error al guardar artículo: " + err.message);
  }
});

// 3) Ejecutar carga al cargar DOM
document.addEventListener("DOMContentLoaded", cargarCategorias);

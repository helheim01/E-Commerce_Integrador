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
      o.value       = cat.id;
      o.textContent = cat.nombre;
      selectCategoria.appendChild(o);
    });
  } catch (e) {
    console.error(e);
    alert("Error al cargar categorías");
  }
}

// 2) En lugar de submit nativo, escuchamos el click:
botonRegistrar.addEventListener("click", async ev => {
  // No hace falta preventDefault porque el botón NO es submit
  // Armar el objeto artículo:
  const articulo = {
    nombre:      document.getElementById("nombre").value.trim(),
    precio:      parseFloat(document.getElementById("precio").value),
    descripcion: document.getElementById("descripcion").value.trim(),
    imagenes:    document.getElementById("imagenes").files[0]?.name || "",
    disponible:  document.getElementById("disponible").checked,
    stock:       parseInt(document.getElementById("stock").value, 10)
  };

  const catId = selectCategoria.value;
  if (!catId) return alert("Seleccioná una categoría");

  try {
    const resp = await fetch(
      `http://localhost:8080/categoria/${catId}/articulos`,
      {
        method:  "POST",
        headers: { "Content-Type": "application/json" },
        body:    JSON.stringify(articulo)
      }
    );

    if (resp.ok) {
      alert("Artículo creado en la categoría");
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

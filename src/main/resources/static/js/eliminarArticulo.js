const form = document.querySelector("form");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("id").value.trim();

  if (!id) {
    alert("Por favor, ingresá un ID válido");
    return;
  }

  const confirmacion = confirm(`¿Estás seguro de que querés eliminar el artículo con ID ${id}?`);
  if (!confirmacion) return;

  try {
    const resp = await fetch(`http://localhost:8080/articulos/deleteArticulo/${id}`, {
      method: "DELETE"
    });

    if (resp.ok) {
      const msg = await resp.text();
      alert(msg); // "ARTICULO ELIMINADO"
      form.reset();
    } else {
      const msg = await resp.text();
      throw new Error(msg || "No se pudo eliminar el artículo");
    }

  } catch (err) {
    console.error(err);
    alert("Error al eliminar el artículo: " + err.message);
  }
});
const form = document.querySelector("form");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const id = document.getElementById("id").value.trim();

  if (!id) {
    alert("Por favor, ingresá un ID válido");
    return;
  }

  try {
    // Verificar existencia del artículo
    const verificarResp = await fetch(`http://localhost:8080/articulos/articulo/${id}`);
    if (!verificarResp.ok) throw new Error("No se encontró un artículo con ese ID");

    const confirmacion = confirm(`¿Estás seguro de que querés eliminar el artículo con ID ${id}?`);
    if (!confirmacion) return;

    // Si existe, proceder con eliminación
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
    alert("Error: " + err.message);
  }
});
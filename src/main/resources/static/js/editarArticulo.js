const form = document.querySelector("form");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const id          = document.getElementById("id").value.trim();
  const nombre      = document.getElementById("nombre").value.trim();
  const precio      = document.getElementById("precio").value;
  const descripcion = document.getElementById("descripcion").value.trim();
  const stock       = document.getElementById("stock").value;
  const imagenFile  = document.getElementById("imagen").files[0];
  const imagen      = imagenFile?.name || "";
  const disponible  = true;

  // Validaciones manuales
  if (!id || !nombre || !precio || !descripcion || !stock || !imagen) {
    alert("Todos los campos deben estar completos");
    return;
  }

  try {
    // Verificar existencia del artículo
    const res = await fetch(`http://localhost:8080/articulos/articulo/${id}`);
    if (!res.ok) throw new Error("No se encontró un artículo con ese ID");

    const articuloActualizado = {
      nombre,
      precio: parseFloat(precio),
      descripcion,
      stock: parseInt(stock, 10),
      imagenes: imagen,
      disponible
    };

    // PUT al backend con el endpoint corregido
    const putResp = await fetch(`http://localhost:8080/articulos/editarArticulo/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(articuloActualizado)
    });

    if (putResp.ok) {
      const msg = await putResp.text();
      alert(msg); // "ARTICULO EDITADO CORRECTAMENTE"
      form.reset();
    } else {
      const msg = await putResp.text();
      throw new Error(msg || "Error al actualizar el artículo");
    }

  } catch (err) {
    console.error(err);
    alert("Error: " + err.message);
  }
});
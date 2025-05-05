document.addEventListener("DOMContentLoaded", async () => {
  const tabla = document.getElementById("tablaArticulos");

  try {
    const res = await fetch("http://localhost:8080/articulos/articulos");
    if (!res.ok) throw new Error("No se pudieron obtener los artículos");

    const articulos = await res.json();

    articulos.forEach(a => {
      const fila = document.createElement("tr");

      fila.innerHTML = `
        <td>${a.id}</td>
        <td>${a.nombre}</td>
        <td>$${a.precio.toFixed(2)}</td>
        <td>${a.descripcion}</td>
        <td>${a.stock}</td>
        <td>${a.disponible ? 'Sí' : 'No'}</td>
        <td>${a.imagenes || '-'}</td>
      `;

      tabla.appendChild(fila);
    });

  } catch (err) {
    console.error(err);
    alert("Error al cargar artículos: " + err.message);
  }
});
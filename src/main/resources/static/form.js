document.addEventListener("DOMContentLoaded", function sendEmail() {
    const form = document.querySelector("form");

    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const nombre = document.getElementById("nombre").value;
        const email = document.getElementById("email").value;
        const telefono = document.getElementById("telefono").value;
        const mensaje = document.getElementById("mensaje").value;
        

        const params = {
            nombre: nombre,
            email: email,
            telefono: telefono,
            mensaje: mensaje
        };

        emailjs.send("service_i6b77ai", "template_6koymzj", params)
            .then(function (response) {
                alert("¡Mensaje enviado con éxito!");
                form.reset();
            }, function (error) {
                alert("Ocurrió un error al enviar el mensaje. Intentalo nuevamente.");
                console.error("Error:", error);
            });
    });
});

package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Carrito;
import com.equipovinos.e_commerce_vinos.repository.RepositoryCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarritoController {

    @Autowired
    private RepositoryCarrito repositoryCarrito;

    @GetMapping()
    public String index() {
        return "Conectado";
    }

    // Obtener un Carrito por ID
    @GetMapping("/carrito/{id}")
    public Carrito traerCarritoPorId(@PathVariable int id) {
        Optional<Carrito> carrito = repositoryCarrito.findById(id);
        return carrito.orElse(null);
    }

    // Traer lista de carritos
    @GetMapping("/carritos")
    public List<Carrito> traerListaCarritos() {
        return repositoryCarrito.findAll();
    }

    // Crear
    @PostMapping("/carrito/crear")
    public String crearCarrito(@RequestBody Carrito carrito) {
        repositoryCarrito.save(carrito);
        return "Carrito Creado Correctamente";
    }

    // Editar
    @PutMapping("/carrito/editar/{id}")
    public String editarCarrito(@PathVariable int id, @RequestBody Carrito carrito) {
        Carrito actualizarCarrito = repositoryCarrito.findById(id).orElse(null);
        if (actualizarCarrito != null) {
            actualizarCarrito.setEstado(carrito.getEstado());
            actualizarCarrito.setFecha(carrito.getFecha());
            actualizarCarrito.setUsuario(carrito.getUsuario());
            repositoryCarrito.save(actualizarCarrito);
            return "Carrito Editado Correctamente";
        } else {
            return "Carrito no encontrado";
        }
    }

    // Eliminar
    @DeleteMapping("/carrito/delete/{id}")
    public String eliminarCarrito(@PathVariable int id) {
        Carrito carritoAEliminar = repositoryCarrito.findById(id).orElse(null);
        if (carritoAEliminar != null) {
            repositoryCarrito.delete(carritoAEliminar);
            return "Carrito Eliminado Correctamente";
        } else {
            return "Carrito no encontrado";
        }
    }

}

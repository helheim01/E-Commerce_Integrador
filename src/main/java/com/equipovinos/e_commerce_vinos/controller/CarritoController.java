package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Articulo;
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

    // Obtener Carrito por ID
    @GetMapping("carrito")
    public Carrito getCarrito(@PathVariable Integer id) {
        return repositoryCarrito.findById(id).get();
    }

    // Obtener todos los Carritos
    @GetMapping("carritos")
    public List<Carrito> getCarritos() {
        return repositoryCarrito.findAll();
    }

    // Guardar Carrito
    @PostMapping("guardarCarrito")
    public String post(@RequestBody Carrito carrito) {
        repositoryCarrito.save(carrito);
        return "CARRITO GUARDADO";
    }

    // Editar Carrito
    @PutMapping("editarCarrito/{id}")
    public String uptdate(@PathVariable Integer id, @RequestBody Carrito carrito) {
        Carrito uptdateCarrito = repositoryCarrito.findById(id).get();
        uptdateCarrito.setEstado(carrito.getEstado());
        uptdateCarrito.setUsuario(carrito.getUsuario());
        uptdateCarrito.setFecha(carrito.getFecha());

        return "CARRITO EDITADO CORRECTAMENTE";
    }

    // Eliminar Carrito
    @DeleteMapping("deleteCarrito/{id}")
    public String delete(@PathVariable Integer id) {
        Carrito deleteCarrito = repositoryCarrito.findById(id).get();
        repositoryCarrito.delete(deleteCarrito);

        return "CARRITO ELIMINADO";
    }

}

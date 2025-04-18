package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.DetalleCarrito;
import com.equipovinos.e_commerce_vinos.repository.RepositoryDetalleCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DetalleCarritoController {

    @Autowired
    private RepositoryDetalleCarrito repositoryDetalleCarrito;

    // Obtener un DetalleCarrito por ID
    @GetMapping("/detallecarrito/{id}")
    public DetalleCarrito traerDetallePorId(@PathVariable int id) {
        Optional<DetalleCarrito> detalle = repositoryDetalleCarrito.findById(id);
        return detalle.orElse(null);
    }

    // Traer lista de detalles de carrito
    @GetMapping("/detallecarrito")
    public List<DetalleCarrito> traerListaDetalles() {
        return repositoryDetalleCarrito.findAll();
    }

    // Crear
    @PostMapping("/detallecarrito/crear")
    public String crearDetalle(@RequestBody DetalleCarrito detalleCarrito) {
        repositoryDetalleCarrito.save(detalleCarrito);
        return "Detalle de Carrito Creado Correctamente";
    }

    // Editar
    @PutMapping("/detallecarrito/editar/{id}")
    public String editarDetalle(@PathVariable int id, @RequestBody DetalleCarrito detalleCarrito) {
        DetalleCarrito actualizarDetalle = repositoryDetalleCarrito.findById(id).orElse(null);
        if (actualizarDetalle != null) {
            actualizarDetalle.setCantidad(detalleCarrito.getCantidad());
            actualizarDetalle.setPrecio(detalleCarrito.getPrecio());
            actualizarDetalle.setSubtotal(detalleCarrito.getSubtotal());
            actualizarDetalle.setCarrito(detalleCarrito.getCarrito());
            actualizarDetalle.setArticulos(detalleCarrito.getArticulos());
            repositoryDetalleCarrito.save(actualizarDetalle);
            return "Detalle de Carrito Editado Correctamente";
        } else {
            return "Detalle no encontrado";
        }
    }

    // Eliminar
    @DeleteMapping("/detallecarrito/delete/{id}")
    public String eliminarDetalle(@PathVariable int id) {
        DetalleCarrito detalleAEliminar = repositoryDetalleCarrito.findById(id).orElse(null);
        if (detalleAEliminar != null) {
            repositoryDetalleCarrito.delete(detalleAEliminar);
            return "Detalle de Carrito Eliminado Correctamente";
        } else {
            return "Detalle no encontrado";
        }
    }

}

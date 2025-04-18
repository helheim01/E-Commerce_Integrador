package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Venta;
import com.equipovinos.e_commerce_vinos.repository.RepositoryVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VentaController {

    @Autowired
    private RepositoryVenta repositoryVenta;

    // Obtener una Venta por ID
    @GetMapping("/venta/{id}")
    public Venta traerVentaPorId(@PathVariable int id) {
        Optional<Venta> venta = repositoryVenta.findById(id);
        return venta.orElse(null);
    }

    // Traer lista de Ventas
    @GetMapping("/venta")
    public List<Venta> traerListaVentas() {
        return repositoryVenta.findAll();
    }

    // Crear una nueva Venta
    @PostMapping("/venta/crear")
    public String crearVenta(@RequestBody Venta venta) {
        repositoryVenta.save(venta);
        return "Venta Creada Correctamente";
    }

    // Editar una Venta existente
    @PutMapping("/venta/editar/{id}")
    public String editarVenta(@PathVariable int id, @RequestBody Venta venta) {
        Venta actualizarVenta = repositoryVenta.findById(id).orElse(null);
        if (actualizarVenta != null) {
            actualizarVenta.setNumComprobante(venta.getNumComprobante());
            actualizarVenta.setMedioPago(venta.getMedioPago());
            actualizarVenta.setUsuario(venta.getUsuario());
            actualizarVenta.setCarrito(venta.getCarrito());
            actualizarVenta.setEnvio(venta.getEnvio());
            repositoryVenta.save(actualizarVenta);
            return "Venta Editada Correctamente";
        } else {
            return "Venta no encontrada";
        }
    }

    // Eliminar una Venta
    @DeleteMapping("/venta/delete/{id}")
    public String eliminarVenta(@PathVariable int id) {
        Venta ventaAEliminar = repositoryVenta.findById(id).orElse(null);
        if (ventaAEliminar != null) {
            repositoryVenta.delete(ventaAEliminar);
            return "Venta Eliminada Correctamente";
        } else {
            return "Venta no encontrada";
        }
    }
}

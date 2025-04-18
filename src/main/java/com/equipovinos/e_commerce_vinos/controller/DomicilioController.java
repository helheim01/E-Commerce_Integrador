package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Domicilio;
import com.equipovinos.e_commerce_vinos.repository.RepositoryDomicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DomicilioController {

    @Autowired
    private RepositoryDomicilio repositoryDomicilio;

    @GetMapping()
    public String index() {
        return "Conectado";
    }

    // Obtener un Domicilio por ID
    @GetMapping("/domicilio/{id}")
    public Domicilio traerDomicilioPorId(@PathVariable int id) {
        Optional<Domicilio> domicilio = repositoryDomicilio.findById(id);
        return domicilio.orElse(null);
    }

    // Traer lista de domicilios
    @GetMapping("/domicilio")
    public List<Domicilio> traerListaDomicilios() {
        return repositoryDomicilio.findAll();
    }

    // Crear
    @PostMapping("/domicilio/crear")
    public String crearDomicilio(@RequestBody Domicilio domicilio) {
        repositoryDomicilio.save(domicilio);
        return "Domicilio Creado Correctamente";
    }

    // Editar
    @PutMapping("/domicilio/editar/{id}")
    public String editarDomicilio(@PathVariable int id, @RequestBody Domicilio domicilio) {
        Domicilio actualizarDomicilio = repositoryDomicilio.findById(id).orElse(null);
        if (actualizarDomicilio != null) {
            actualizarDomicilio.setCalle(domicilio.getCalle());
            actualizarDomicilio.setNumero(domicilio.getNumero());
            actualizarDomicilio.setCiudad(domicilio.getCiudad());
            actualizarDomicilio.setEstado(domicilio.getEstado());
            actualizarDomicilio.setCodPostal(domicilio.getCodPostal());
            actualizarDomicilio.setPais(domicilio.getPais());
            repositoryDomicilio.save(actualizarDomicilio);
            return "Domicilio Editado Correctamente";
        } else {
            return "Domicilio no encontrado";
        }
    }

    // Eliminar
    @DeleteMapping("/domicilio/delete/{id}")
    public String eliminarDomicilio(@PathVariable int id) {
        Domicilio domicilioAEliminar = repositoryDomicilio.findById(id).orElse(null);
        if (domicilioAEliminar != null) {
            repositoryDomicilio.delete(domicilioAEliminar);
            return "Domicilio Eliminado Correctamente";
        } else {
            return "Domicilio no encontrado";
        }
    }

}

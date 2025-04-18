package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Envio;
import com.equipovinos.e_commerce_vinos.repository.RepositoryEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnvioController {

    @Autowired
    private RepositoryEnvio repositoryEnvio;

    @GetMapping()
    public String index() {
        return "Conectado";
    }

    // Obtener un Envio por ID
    @GetMapping("/envio/{id}")
    public Envio traerEnvioPorId(@PathVariable int id) {
        Optional<Envio> envio = repositoryEnvio.findById(id);
        return envio.orElse(null);
    }

    // Traer lista de envíos
    @GetMapping("/envio")
    public List<Envio> traerListaEnvios() {
        return repositoryEnvio.findAll();
    }

    // Crear un nuevo Envio
    @PostMapping("/envio/crear")
    public String crearEnvio(@RequestBody Envio envio) {
        repositoryEnvio.save(envio);
        return "Envío Creado Correctamente";
    }

    // Editar un Envio existente
    @PutMapping("/envio/editar/{id}")
    public String editarEnvio(@PathVariable int id, @RequestBody Envio envio) {
        Envio actualizarEnvio = repositoryEnvio.findById(id).orElse(null);
        if (actualizarEnvio != null) {
            actualizarEnvio.setEstado(envio.getEstado());
            actualizarEnvio.setFecha(envio.getFecha());
            actualizarEnvio.setEntregaEstimada(envio.getEntregaEstimada());
            actualizarEnvio.setDomicilio(envio.getDomicilio());
            repositoryEnvio.save(actualizarEnvio);
            return "Envío Editado Correctamente";
        } else {
            return "Envío no encontrado";
        }
    }

    // Eliminar un Envio
    @DeleteMapping("/envio/delete/{id}")
    public String eliminarEnvio(@PathVariable int id) {
        Envio envioAEliminar = repositoryEnvio.findById(id).orElse(null);
        if (envioAEliminar != null) {
            repositoryEnvio.delete(envioAEliminar);
            return "Envío Eliminado Correctamente";
        } else {
            return "Envío no encontrado";
        }
    }
}

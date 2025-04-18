package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Usuario;
import com.equipovinos.e_commerce_vinos.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    // Obtener un Usuario por ID
    @GetMapping("/usuario/{id}")
    public Usuario traerUsuarioPorId(@PathVariable int id) {
        Optional<Usuario> usuario = repositoryUsuario.findById(id);
        return usuario.orElse(null);
    }

    // Traer lista de Usuarios
    @GetMapping("/usuario")
    public List<Usuario> traerListaUsuarios() {
        return repositoryUsuario.findAll();
    }

    // Crear un nuevo Usuario
    @PostMapping("/usuario/crear")
    public String crearUsuario(@RequestBody Usuario usuario) {
        repositoryUsuario.save(usuario);
        return "Usuario Creado Correctamente";
    }

    // Editar un Usuario existente
    @PutMapping("/usuario/editar/{id}")
    public String editarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario actualizarUsuario = repositoryUsuario.findById(id).orElse(null);
        if (actualizarUsuario != null) {
            actualizarUsuario.setNombre(usuario.getNombre());
            actualizarUsuario.setApellido(usuario.getApellido());
            actualizarUsuario.setEmail(usuario.getEmail());
            actualizarUsuario.setNumTelefono(usuario.getNumTelefono());
            actualizarUsuario.setEdad(usuario.getEdad());
            actualizarUsuario.setContrasenia(usuario.getContrasenia());
            actualizarUsuario.setDomicilios(usuario.getDomicilios());
            repositoryUsuario.save(actualizarUsuario);
            return "Usuario Editado Correctamente";
        } else {
            return "Usuario no encontrado";
        }
    }

    // Eliminar un Usuario
    @DeleteMapping("/usuario/delete/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        Usuario usuarioAEliminar = repositoryUsuario.findById(id).orElse(null);
        if (usuarioAEliminar != null) {
            repositoryUsuario.delete(usuarioAEliminar);
            return "Usuario Eliminado Correctamente";
        } else {
            return "Usuario no encontrado";
        }
    }
}

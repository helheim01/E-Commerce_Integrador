package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Categoria;
import com.equipovinos.e_commerce_vinos.repository.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    private RepositoryCategoria repositoryCategoria;

    // Obtener una Categoria por ID
    @GetMapping("/categoria/{id}")
    public Categoria traerCategoriaPorId(@PathVariable int id) {
        Optional<Categoria> categoria = repositoryCategoria.findById(id);
        return categoria.orElse(null);
    }

    // Traer lista de categorias
    @GetMapping("/categorias")
    public List<Categoria> traerListaCategorias() {
        return repositoryCategoria.findAll();
    }

    // Crear
    @PostMapping("/categoria/crear")
    public String crearCategoria(@RequestBody Categoria categoria) {
        repositoryCategoria.save(categoria);
        return "Categoría Creada Correctamente";
    }

    // Editar
    @PutMapping("/categoria/editar/{id}")
    public String editarCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        Categoria actualizarCategoria = repositoryCategoria.findById(id).orElse(null);
        if (actualizarCategoria != null) {
            actualizarCategoria.setNombre(categoria.getNombre());
            actualizarCategoria.setDescripcion(categoria.getDescripcion());
            actualizarCategoria.setArticulos(categoria.getArticulos());
            repositoryCategoria.save(actualizarCategoria);
            return "Categoría Editada Correctamente";
        } else {
            return "Categoría no encontrada";
        }
    }

    // Eliminar
    @DeleteMapping("/categoria/delete/{id}")
    public String eliminarCategoria(@PathVariable int id) {
        Categoria categoriaAEliminar = repositoryCategoria.findById(id).orElse(null);
        if (categoriaAEliminar != null) {
            repositoryCategoria.delete(categoriaAEliminar);
            return "Categoría Eliminada Correctamente";
        } else {
            return "Categoría no encontrada";
        }
    }

}

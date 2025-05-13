package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Articulo;
import com.equipovinos.e_commerce_vinos.repository.RepositoryArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/articulos")
@CrossOrigin(origins = "http://localhost:8080")  // Ajustar la URL si es necesario
public class ArticuloController {

    @Autowired
    private RepositoryArticulo repositoryArticulo;

    // Obtener Articulo por ID
    @GetMapping("articulo/{id}")
    public Articulo getArticulo(@PathVariable Integer id) {
        return repositoryArticulo.findById(id).get();
    }

    // Obtener todos los Articulos
    @GetMapping("articulos")
    public List<Articulo> getArticulos() {
        return repositoryArticulo.findAll();
    }

    // Guardar Articulo
    @PostMapping("guardarArticulo")
    public String post(@RequestBody Articulo articulo) {
        repositoryArticulo.save(articulo);
        return "ARTICULO GUARDADO";
    }

    // Editar Articulo
    @PutMapping("editarArticulo/{id}")
    public String uptdate(@PathVariable Integer id, @RequestBody Articulo articulo) {
        Articulo uptdateArticulo = repositoryArticulo.findById(id).get();
        uptdateArticulo.setNombre(articulo.getNombre());
        uptdateArticulo.setPrecio(articulo.getPrecio());
        uptdateArticulo.setStock(articulo.getStock());
        uptdateArticulo.setDisponible(articulo.getDisponible());
        uptdateArticulo.setDescripcion(articulo.getDescripcion());
        uptdateArticulo.setImagenes(articulo.getImagenes());
        repositoryArticulo.save(uptdateArticulo);

        return "ARTICULO EDITADO CORRECTAMENTE";
    }

    // Eliminar Articulo
    @DeleteMapping("deleteArticulo/{id}")
    public String delete(@PathVariable Integer id) {
        Articulo deleteArticulo = repositoryArticulo.findById(id).get();
        repositoryArticulo.delete(deleteArticulo);

        return "ARTICULO ELIMINADO";
    }

}

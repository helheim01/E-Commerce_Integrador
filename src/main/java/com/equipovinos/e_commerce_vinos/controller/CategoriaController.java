package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Articulo;
import com.equipovinos.e_commerce_vinos.entity.Categoria;
import com.equipovinos.e_commerce_vinos.repository.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:8080")
public class CategoriaController {

    @Autowired
    private RepositoryCategoria repositoryCategoria;

    // 1) Obtener una categoría por ID
    //    GET /categoria/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> traerCategoriaPorId(@PathVariable int id) {
        return repositoryCategoria.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2) Traer lista de categorías
    //    GET /categoria
    @GetMapping
    public List<Categoria> traerListaCategorias() {
        return repositoryCategoria.findAll();
    }

    // 3) Crear categoría
    //    POST /categoria
    @PostMapping
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria) {
        repositoryCategoria.save(categoria);
        return ResponseEntity.ok("Categoría creada correctamente");
    }

    // 4) Editar categoría
    //    PUT /categoria/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> editarCategoria(
            @PathVariable int id,
            @RequestBody Categoria categoria
    ) {
        Optional<Categoria> opt = repositoryCategoria.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría no encontrada");
        }
        Categoria actual = opt.get();
        actual.setNombre(categoria.getNombre());
        actual.setDescripcion(categoria.getDescripcion());
        // Si quisieras reemplazar la lista de artículos:
        // actual.setArticulos(categoria.getArticulos());
        repositoryCategoria.save(actual);
        return ResponseEntity.ok("Categoría editada correctamente");
    }

    // 5) Eliminar categoría
    //    DELETE /categoria/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id) {
        Optional<Categoria> opt = repositoryCategoria.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría no encontrada");
        }
        repositoryCategoria.delete(opt.get());
        return ResponseEntity.ok("Categoría eliminada correctamente");
    }

    // 6) Obtener todos los artículos de una categoría
    //    GET /categoria/{id}/articulos
    @GetMapping("/{id}/articulos")
    public ResponseEntity<List<Articulo>> traerArticulosDeCategoria(@PathVariable int id) {
        return repositoryCategoria.findById(id)
                .map(cat -> ResponseEntity.ok(cat.getArticulos()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 7) Agregar un artículo a una categoría (persistencia unidireccional)
    //    POST /categoria/{id}/articulos
    @PostMapping("/{id}/articulos")
    public ResponseEntity<String> agregarArticulo(
            @PathVariable int id,
            @RequestBody Articulo articulo
    ) {
        Optional<Categoria> opt = repositoryCategoria.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría no encontrada");
        }
        Categoria cat = opt.get();
        cat.addArticulo(articulo);
        repositoryCategoria.save(cat);
        return ResponseEntity.ok("Artículo agregado a la categoría");
    }
}

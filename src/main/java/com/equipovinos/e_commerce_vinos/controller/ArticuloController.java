package com.equipovinos.e_commerce_vinos.controller;

import com.equipovinos.e_commerce_vinos.entity.Articulo;
import com.equipovinos.e_commerce_vinos.entity.Carrito;
import com.equipovinos.e_commerce_vinos.repository.RepositoryArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticuloController {

    @Autowired
    private RepositoryArticulo repositoryArticulo;


    @GetMapping()
    public String index(){
        return "Conectado";
    }

    // Obtener un Articulo por ID
    @GetMapping("/{id}")
    public Articulo traerArticuloPorId(@PathVariable int id) {
        Optional<Articulo> articulo = repositoryArticulo.findById(id);
        return articulo.orElse(null);
    }

    //Traer lista
    @GetMapping("articulos")
    public List<Articulo> traerListaArticulos(){
        return repositoryArticulo.findAll();
    }

    //Crear
    @PostMapping("crear")
    public String crearArticulo (@RequestBody Articulo articulo){
            repositoryArticulo.save(articulo);
            return "Articulo Creado Correctamente";
    }

    @PutMapping("editar/{id}")
    public String editarArticulo(@PathVariable int id, @RequestBody Articulo articulo){
        Articulo actualizarArticulo = repositoryArticulo.findById(id).orElse(null);
        if (actualizarArticulo != null) {
            actualizarArticulo.setNombre(articulo.getNombre());
            actualizarArticulo.setDescripcion(articulo.getDescripcion());
            actualizarArticulo.setStock(articulo.getStock());
            actualizarArticulo.setPrecio(articulo.getPrecio());
            actualizarArticulo.setDisponible(articulo.getDisponible());
            actualizarArticulo.setImagenes(articulo.getImagenes());
            repositoryArticulo.save(actualizarArticulo);
            return "Articulo Editado Correctamente";
        } else {
            return "Articulo no encontrado";
        }
    }

    @DeleteMapping("delete/{id}")
        public String eliminarArticulo(@PathVariable int id){
        Articulo editarArticulo=repositoryArticulo.findById(id).get();
        repositoryArticulo.delete(editarArticulo);
        return "Articulo Eliminado Correctamente";
    }

}

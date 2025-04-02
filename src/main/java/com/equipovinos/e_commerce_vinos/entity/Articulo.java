
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Articulo implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private String nombre;
    private int precio;
    private String descripcion;
    private String imagenes;
    private Boolean disponible;
    private int stock;
    
    //Relaciones
    @OneToMany
    private List<Categoria> idCategoria;

    public Articulo() {
    }

    public Articulo(int id, String nombre, int precio, String descripcion, String imagenes, Boolean disponible, int stock, List<Categoria> idCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.disponible = disponible;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Categoria> getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(List<Categoria> idCategoria) {
        this.idCategoria = idCategoria;
    }
    
}

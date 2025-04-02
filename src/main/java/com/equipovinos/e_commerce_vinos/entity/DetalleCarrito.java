
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DetalleCarrito implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private int cantidad;
    private int precio;
    private int subtotal;
    
    //Relaciones
    @OneToMany
    private ArrayList<Articulo> idArticulos = new ArrayList();

    public DetalleCarrito() {
    }

    public DetalleCarrito(int id, int cantidad, int precio, int subtotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public ArrayList<Articulo> getIdArticulos() {
        return idArticulos;
    }

    public void setIdArticulos(ArrayList<Articulo> idArticulos) {
        this.idArticulos = idArticulos;
    }
    
    public void addIdArticulos(Articulo idArticulos) {
        this.idArticulos.add(idArticulos);
    }
    
}

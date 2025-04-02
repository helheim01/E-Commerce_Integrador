
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class DetalleVenta implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private int cantidad;
    private String descripcion;
    
    //Relaciones
    @OneToMany
    private ArrayList<Articulo> idArticulo = new ArrayList();
    @OneToOne
    private Venta idVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, String descripcion, Venta idVenta) {
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Articulo> getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(ArrayList<Articulo> idArticulo) {
        this.idArticulo = idArticulo;
    }
    
    public void addIdArticulo(Articulo idArticulo) {
        this.idArticulo.add(idArticulo);
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }
    
}


package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Carrito implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private Boolean estado;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    //Relaciones
    @OneToOne
    private Usuario idUsuario;
    @OneToOne
    private DetalleCarrito idDetalle;
    @OneToOne
    private Venta idVenta;

    public Carrito() {
    }

    public Carrito(int id, Boolean estado, Date fecha, Usuario idUsuario, DetalleCarrito idDetalle, Venta idVenta) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public DetalleCarrito getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(DetalleCarrito idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }
    
}

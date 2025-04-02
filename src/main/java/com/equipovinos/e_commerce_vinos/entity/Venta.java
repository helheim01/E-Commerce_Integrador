
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Venta implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private int numComprobante;
    
    //Relaciones
    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;
    @OneToOne
    private Usuario idUsuario;
    @OneToOne
    private Carrito idCarrito;
    @OneToOne
    private DetalleVenta idDetalleVenta;

    public Venta() {
    }

    public Venta(int numComprobante, MedioPago medioPago, Usuario idUsuario, Carrito idCarrito, DetalleVenta idDetalleVenta) {
        this.numComprobante = numComprobante;
        this.medioPago = medioPago;
        this.idUsuario = idUsuario;
        this.idCarrito = idCarrito;
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(int numComprobante) {
        this.numComprobante = numComprobante;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Carrito getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Carrito idCarrito) {
        this.idCarrito = idCarrito;
    }

    public DetalleVenta getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(DetalleVenta idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

}

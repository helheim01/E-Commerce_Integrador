
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Envio implements Serializable {
    
    @Id
    private int id;
    
    @Enumerated(EnumType.STRING)
    private EstadoEnvio estado;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.DATE)
    private Date entregaEstimada;
    
    //Relaciones
    @OneToOne
    private Venta idVenta;
    @OneToOne
    private Domicilio idDomicilio;

    public Envio() {
    }

    public Envio(EstadoEnvio estado, Date fecha, Date entregaEstimada, Venta idVenta, Domicilio idDomicilio) {
        this.estado = estado;
        this.fecha = fecha;
        this.entregaEstimada = entregaEstimada;
        this.idVenta = idVenta;
        this.idDomicilio = idDomicilio;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getEntregaEstimada() {
        return entregaEstimada;
    }

    public void setEntregaEstimada(Date entregaEstimada) {
        this.entregaEstimada = entregaEstimada;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public Domicilio getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Domicilio idDomicilio) {
        this.idDomicilio = idDomicilio;
    }
    
}


package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Domicilio implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private String calle;
    private int numero;
    private String ciudad;
    private String estado;
    private int codPostal;
    private String pais;
    
    //Relaciones
    @OneToOne
    private Envio idEnvio;

    public Domicilio() {
    }

    public Domicilio(int id, String calle, int numero, String ciudad, String estado, int codPostal, String pais, Envio idEnvio) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codPostal = codPostal;
        this.pais = pais;
        this.idEnvio = idEnvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Envio getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Envio idEnvio) {
        this.idEnvio = idEnvio;
    }
    
}

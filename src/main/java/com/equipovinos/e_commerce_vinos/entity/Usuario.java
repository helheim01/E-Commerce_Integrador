
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
    
    @Id
    private int id;
    
    @Basic
    private String nombre;
    private String Apellido;
    private String email;
    private String numTelefono;
    private int edad;
    private String contrasenia;
    
    //Relaciones
    @OneToMany
    private ArrayList<Domicilio> domicilios = new ArrayList();
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String Apellido, String email, String numTelefono, int edad, String contrasenia, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.email = email;
        this.numTelefono = numTelefono;
        this.edad = edad;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(ArrayList<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
    
    public void addDomicilios(Domicilio domicilios) {
        this.domicilios.add(domicilios);
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
}

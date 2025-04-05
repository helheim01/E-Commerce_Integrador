
package com.equipovinos.e_commerce_vinos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domicilio> domicilios = new ArrayList<>();

    //Relaciones
    @OneToOne(mappedBy = "usuario") //Hace referencia al private Usuario usuario del Carrito
    private Carrito carrito;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Venta venta;

    public void addDomicilios(Domicilio domicilio) {
        this.domicilios.add(domicilio);
    }
}

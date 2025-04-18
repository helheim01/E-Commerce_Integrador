
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    @Basic
    private String nombre;
    private String Apellido;
    private String email;
    private String numTelefono;
    private int edad;
    private String contrasenia;

    //Relaciones

    @OneToMany//(cascade = CascadeType.ALL)  //CORREGIDO
    //@JoinColumn(name = "usuario_id")
    private List<Domicilio> domicilios = new ArrayList<>();


    public void addDomicilios(Domicilio domicilio) {
        this.domicilios.add(domicilio);
    }
}



package com.equipovinos.e_commerce_vinos.entity;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "id_usuario") // FK en la tabla domicilio
    private Usuario usuario;


    @OneToOne(mappedBy = "domicilio") // hace referencia al atributo "domicilio" en Envio
    private Envio envio;
}


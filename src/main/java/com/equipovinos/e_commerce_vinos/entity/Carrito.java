
package com.equipovinos.e_commerce_vinos.entity;
import java.io.Serializable;
import java.sql.Date;
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
public class Carrito implements Serializable {

    @Id
    private int id;

    @Basic
    private Boolean estado;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    //Relaciones
    @OneToOne//(cascade = CascadeType.ALL)    //CORREGIDO
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}


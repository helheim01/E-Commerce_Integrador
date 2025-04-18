
package com.equipovinos.e_commerce_vinos.entity;
import java.io.Serializable;
import java.sql.Date;
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
public class Envio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Enumerated(EnumType.STRING)
    private EstadoEnvio estado;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.DATE)
    private Date entregaEstimada;

    //Relaciones

    @OneToOne//(cascade = CascadeType.ALL) //CORREGIDO
    //@JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
}


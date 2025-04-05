
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
    private int id;

    @Enumerated(EnumType.STRING)
    private EstadoEnvio estado;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.DATE)
    private Date entregaEstimada;

    //Relaciones

    @OneToOne
    @JoinColumn(name = "id_domicilio") // FK en la tabla Envio
    private Domicilio domicilio;

    @OneToOne(mappedBy = "envio")
    private Venta venta;

}

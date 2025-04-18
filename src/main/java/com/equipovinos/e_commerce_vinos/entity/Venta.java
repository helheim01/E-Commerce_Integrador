package com.equipovinos.e_commerce_vinos.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Venta implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    @Basic
    private int numComprobante;


    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    @OneToOne//(cascade = CascadeType.ALL) //CORREGIDO
    //@JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne//(cascade = CascadeType.ALL) //CORREGIDO
    //@JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @OneToOne//(cascade = CascadeType.ALL) //CORREGIDO
    //@JoinColumn(name = "envio_id")
    private Envio envio;


}

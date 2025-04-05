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
    private int id;


    @Basic
    private int numComprobante;


    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;


    @OneToOne
    @JoinColumn(name = "id_usuario") // FK en la tabla Venta
    private Usuario usuario;


    @OneToOne
    @JoinColumn(name = "id_carrito") // FK en la tabla Venta
    private Carrito carrito;


    @OneToOne
    @JoinColumn(name = "id_envio") // FK en la tabla Venta
    private Envio envio;


}

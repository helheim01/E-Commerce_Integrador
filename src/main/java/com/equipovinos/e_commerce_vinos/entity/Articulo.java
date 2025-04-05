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
public class Articulo implements Serializable {

    @Id
    private int id;

    @Basic
    private String nombre;
    private int precio;
    private String descripcion;
    private String imagenes;
    private Boolean disponible;
    private int stock;


    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_categoria") // FK en la tabla articulo
    private Categoria categoria;




    @ManyToOne
    @JoinColumn(name = "id_detalle_carrito") // FK en la tabla Articulo
    private DetalleCarrito detalleCarrito;


}

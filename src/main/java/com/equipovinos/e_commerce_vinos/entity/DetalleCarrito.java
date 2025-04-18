
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
public class DetalleCarrito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Basic
    private int cantidad;
    private int precio;
    private int subtotal;

    //Relaciones

    @OneToOne//(cascade = CascadeType.ALL)    //CORREGIDO
    //@JoinColumn(name = "carrito_id")
    private Carrito carrito;


    @OneToMany//(cascade = CascadeType.ALL)  //CORREGIDO
    //@JoinColumn(name = "detalleCarrito_id")
    private List<Articulo> articulos = new ArrayList<>();

    public void addArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }

}



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
    private int id;

    @Basic
    private int cantidad;
    private int precio;
    private int subtotal;

    //Relaciones


    @OneToOne
    @JoinColumn(name = "id_carrito")
    private Carrito idCarrito;


    @OneToMany(mappedBy = "detalleCarrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Articulo> articulos = new ArrayList<>();


    public void addArticulo(Articulo articulo) {
        this.articulos.add(articulo);
        articulo.setDetalleCarrito(this);
    }


}


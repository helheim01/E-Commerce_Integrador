
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
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Basic
    private String nombre;
    private String descripcion;


    //Relaciones

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "categoria_id")
    private List<Articulo> articulos = new ArrayList<>();

    public void addArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }
}



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

    @OneToOne(mappedBy = "idCarrito") //Hace referencia al private Carrito idCarrito; del detallecarrito
    private DetalleCarrito detalleCarrito;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToOne(mappedBy = "carrito") // hace referencia a 'private Carrito carrito;' en Venta
    private Venta venta;

}

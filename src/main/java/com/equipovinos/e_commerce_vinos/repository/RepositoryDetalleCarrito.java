package com.equipovinos.e_commerce_vinos.repository;

import com.equipovinos.e_commerce_vinos.entity.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryDetalleCarrito extends JpaRepository<DetalleCarrito, Integer> {
}

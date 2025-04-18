package com.equipovinos.e_commerce_vinos.repository;

import com.equipovinos.e_commerce_vinos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategoria extends JpaRepository<Categoria, Integer> {
}

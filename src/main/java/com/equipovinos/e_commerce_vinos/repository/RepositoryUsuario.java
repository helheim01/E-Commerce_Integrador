package com.equipovinos.e_commerce_vinos.repository;

import com.equipovinos.e_commerce_vinos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
}

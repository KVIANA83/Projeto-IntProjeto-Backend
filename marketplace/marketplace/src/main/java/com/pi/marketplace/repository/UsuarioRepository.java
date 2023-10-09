package com.pi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pi.marketplace.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);

    // Outras consultas personalizadas para a entidade Usuario
}


package com.pi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pi.marketplace.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    /**
     * @param nome
     * @return
     */
    @Query("SELECT c FROM Categoria c WHERE c.nome = :nome")
    Categoria findByNome(@Param("nome") String nome);

    // Outras consultas personalizadas
}

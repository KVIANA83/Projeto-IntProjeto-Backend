package com.pi.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pi.marketplace.entities.Empreendedor;

public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Long> {
    
    /**
     * @param nome
     * @return
     */
    @Query("SELECT e FROM Empreendedor e WHERE e.nome = :nome")
    Empreendedor findByNome(@Param("nome") String nome);

    // Outras consultas personalizadas
}

package com.pi.marketplace.repository;

import com.pi.marketplace.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    @Query("SELECT c FROM Categoria c WHERE c.nome = :nome")
    Categoria findByNome(@Param("nome") String nome);

//     Outras consultas personalizadas
}

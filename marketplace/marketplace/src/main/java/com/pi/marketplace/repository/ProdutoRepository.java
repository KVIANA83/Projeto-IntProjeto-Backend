package com.pi.marketplace.repository;

import com.pi.marketplace.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
    /**
     * @param nome
     * @return
     */
    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    List<Produto> findByNomeContaining(@Param("nome") String nome);

    // Outras consultas personalizadas
}


package com.pi.marketplace.repository;

import com.pi.marketplace.model.Categoria;
import com.pi.marketplace.model.Empreendedor;
import com.pi.marketplace.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<List<Produto>> findAllByCategoria(@Param("categoria") Categoria categoria);

    Optional<List<Produto>> findAllByEmpreendedor(@Param("empreendedor") Empreendedor empreendedor);
}


package com.pi.marketplace.repository;

import com.pi.marketplace.model.Empreendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Integer> {

    Optional<Empreendedor> findByNomeCompleto(@Param("nome") String nome);

    Optional<Empreendedor> findByEmail(@Param("email") String email);

}

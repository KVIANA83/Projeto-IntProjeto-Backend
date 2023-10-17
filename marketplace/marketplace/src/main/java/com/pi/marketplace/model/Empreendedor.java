package com.pi.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Empreendedor")
public class Empreendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empr")
    private Integer idEmpreendedor;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column
    private String telefone;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column
    private String endereco;

    @Column
    private String email;

    @Column
    private String senha;
}

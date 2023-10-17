package com.pi.marketplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private String nome;
    private String descricao;
    private String categoria;
    private String urlImagem;
    private EmpreendedorDTO empreendedor;
}

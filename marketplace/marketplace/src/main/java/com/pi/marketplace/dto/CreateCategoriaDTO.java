package com.pi.marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoriaDTO {

    @NotBlank(message = "nome é um campo obrigatório!")
    public String nome;

    @NotBlank(message = "descricao é um campo obrigatório!")
    public String descricao;
}

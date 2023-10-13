package com.pi.marketplace.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpreendedorDTO {

    private String telefone;
    private String nomeCompleto;
    private String razaoSocial;
    private String endereco;
    private String email;
}
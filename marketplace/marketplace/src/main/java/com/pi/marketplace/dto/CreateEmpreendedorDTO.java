package com.pi.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmpreendedorDTO {

    @NotNull(message = "Data de nascimento é um campo obrigatório!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "Telefone é um campo obrigatório!")
    private String telefone;

    @NotBlank(message = "Nome completo é um campo obrigatório!")
    private String nomeCompleto;

    @NotBlank(message = "Razão social é um campo obrigatório!")
    private String razaoSocial;

    @NotBlank(message = "Endereco é um campo obrigatório!")
    private String endereco;

    @NotBlank(message = "Email é um campo obrigatório!")
    @Email
    private String email;

    @NotBlank(message = "Senha é um campo obrigatório!")
    private String senha;
}
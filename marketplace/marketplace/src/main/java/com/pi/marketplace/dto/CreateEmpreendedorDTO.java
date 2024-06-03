package com.pi.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(name = "dataNascimento", 
            description = "Data de nascimento do usuário cadastrado", 
            example = "01-01-2000", 
            required = true)
    @NotNull(message = "Data de nascimento é um campo obrigatório!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Schema(name = "telefone", 
            description = "Telefone do usuário cadastrado", 
            example = "81988776655", 
            required = true)
    @NotBlank(message = "Telefone é um campo obrigatório!")
    private String telefone;

    @Schema(name = "nomeCompleto", 
            description = "Nome do usuário cadastrado", 
            example = "Maria João da Silva", 
            required = true)
    @NotBlank(message = "Nome completo é um campo obrigatório!")
    private String nomeCompleto;

    @Schema(name = "razaoSocial", 
            description = "Nome fantasia ou Razão social de empreendedor cadastrado", 
            example = "MJ modas evangelica", 
            required = true)
    @NotBlank(message = "Razão social é um campo obrigatório!")
    private String razaoSocial;

    @Schema(name = "endereco", 
            description = "Endereço do usuário cadastrado", 
            example = "Rua rua, s/n, Bairro bairro, Cidade - Ci, cep 11220330", 
            required = true)
    @NotBlank(message = "Endereco é um campo obrigatório!")
    private String endereco;

    @Schema(name = "email", 
            description = "E-mail do usuário cadastrado", 
            example = "maria.joao@email.com", 
            required = true)
    @NotBlank(message = "Email é um campo obrigatório!")
    @Email
    private String email;

    @Schema(name = "senha", 
            description = "Senha do usuário cadastrado", 
            example = "SeNHA.123", 
            required = true)
    @NotBlank(message = "Senha é um campo obrigatório!")
    private String senha;
}
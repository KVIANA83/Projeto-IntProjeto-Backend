package com.pi.marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @Schema(name = "email", 
            description = "Login do usuário cadastrado", 
            example = "usuarioteste@email.com", 
            required = true)
    @NotBlank(message = "email é um campo obrigatório!")
    private String email;

    @Schema(name = "senha", 
            description = "Senha cadastrada pelo usuário", 
            example = "SeNHa.123", 
            required = true)
    @NotBlank(message = "senha é um campo obrigatório!")
    private String senha;
}

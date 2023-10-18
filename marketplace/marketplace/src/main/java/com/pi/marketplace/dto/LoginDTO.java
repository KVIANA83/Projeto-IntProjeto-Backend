package com.pi.marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = "email é um campo obrigatório!")
    private String email;

    @NotBlank(message = "senha é um campo obrigatório!")
    private String senha;
}

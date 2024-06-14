package com.pi.marketplace.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "DTO para retornar informações do usuário")
public class UsuarioDTO {

    @Schema(description = "Telefone do usuário", 
			example = "+5511999999999")
    private String telefone;

    @Schema(description = "Nome completo do usuário", 
			example = "João Silva")
    private String nomeCompleto;

    @Schema(description = "Nome social do usuário, se aplicável", 
			example = "Joãozinho Silva")
    private String nomeSocial;

    @Schema(description = "Endereço do usuário", 
			example = "Rua das Flores, 123, São Paulo, SP")
    private String endereco;

    @Schema(description = "Email do usuário", 
			example = "joao.silva@example.com")
    private String email;
}

package com.pi.marketplace.dto;

import com.pi.marketplace.model.Empreendedor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
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
@Schema(description = "DTO para retornar informações do empreendedor")
public class EmpreendedorDTO {

    @Schema(description = "Telefone do empreendedor", 
			example = "+5511999999999")
    private String telefone;

    @Schema(description = "Nome completo do empreendedor", 
			example = "João Silva")
    private String nomeCompleto;

    @Schema(description = "Razão social do empreendedor", 
			example = "Empresa XYZ LTDA")
    private String razaoSocial;

    @Schema(description = "Endereço do empreendedor", 
			example = "Rua das Flores, 123, São Paulo, SP")
    private String endereco;

    @Schema(description = "Email do empreendedor", 
			example = "joao.silva@empresa.com")
    private String email;

}
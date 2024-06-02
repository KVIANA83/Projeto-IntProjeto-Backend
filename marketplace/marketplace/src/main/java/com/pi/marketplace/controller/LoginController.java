package com.pi.marketplace.controller;

import com.pi.marketplace.dto.LoginDTO;
import com.pi.marketplace.service.EmpreendedorService;
import com.pi.marketplace.service.UsuarioService;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tem no Bairro Login Controller API")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private UsuarioService usuarioService;
    private EmpreendedorService empreendedorService;

    
        @Operation(
        description = "Endpoint para realizar login na plataforma",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Credenciais não encontradas. Deseja realizar cadastro?", 
                content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BodyMensagem.class))})
            },
            parameters = {
                @Parameter(name = "login", 
                            description = "Login do usuário cadastrado", 
                            example = "A1234"),
                @Parameter(name = "senha", 
                            description = "Senha cadastrada pelo usuário", 
                            example = "SeNHa.123")
            }
    )
    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {

        String retorno = "";

        if (usuarioService.preLoginUsuario(loginDTO.getEmail())) {
            retorno = usuarioService.logarUsuario(loginDTO).toString();

        } else if(empreendedorService.preLoginEmpreendedor(loginDTO.getEmail())) {
            retorno = empreendedorService.logarEmpreendedor(loginDTO).toString();

        } else {
            retorno = "Credenciais não encontradas. Deseja realizar cadastro?";
        }

        return ResponseEntity.ok(retorno);
    }
}

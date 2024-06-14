package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CreateUsuarioDTO;
import com.pi.marketplace.dto.UsuarioDTO;
import com.pi.marketplace.model.Usuario;
import com.pi.marketplace.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import java.util.List;

@Tag(name = "Usuarios Controller API")
@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;


    @Operation(
        summary = "Listar todos os usuários",
        description = "Endpoint para listar todos os usuários na plataforma",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {

        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @Operation(
        summary = "Buscar um usuário pelo ID",
        description = "Endpoint para buscar um usuário pelo seu ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do usuário", example = "1")
        }
    )
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {

        return ResponseEntity.ok(usuarioService.pegarUsuarioPeloId(id));
    }

    @Operation(
        summary = "Criar um novo usuário",
        description = "Endpoint para criar um novo usuário",
        responses = {
            @ApiResponse(responseCode = "204", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @PostMapping("/criar")
    public ResponseEntity<Void> criarUsuario(@Valid @RequestBody CreateUsuarioDTO usuarioDTO) {

        usuarioService.saveUsuario(usuarioDTO);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Atualizar um usuário",
        description = "Endpoint para atualizar um usuário existente",
        responses = {
            @ApiResponse(responseCode = "204", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do usuário", example = "1")
        }
    )
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarUsuario(@PathVariable Integer id,
            @Valid @RequestBody CreateUsuarioDTO usuarioAtualizar) {

        usuarioService.atualizarUsuario(usuarioAtualizar, id);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Deletar um usuário",
        description = "Endpoint para deletar um usuário existente",
        responses = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do usuário", example = "1")
        }
    )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {

        usuarioService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}

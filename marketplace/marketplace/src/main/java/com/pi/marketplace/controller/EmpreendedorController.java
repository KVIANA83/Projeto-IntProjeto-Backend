package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CreateEmpreendedorDTO;
import com.pi.marketplace.dto.EmpreendedorDTO;
import com.pi.marketplace.model.Empreendedor;
import com.pi.marketplace.service.EmpreendedorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Empreendedores Controller API")
@RestController
@AllArgsConstructor
@RequestMapping("/empreendedores")
public class EmpreendedorController {

    private EmpreendedorService empreendedorService;


    @Operation(
        summary = "Listar todos os empreendedores",
        description = "Endpoint para listar todos os empreendedores na plataforma",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmpreendedorDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @GetMapping("/listar")
    public ResponseEntity<List<EmpreendedorDTO>> listarEmpreendedores() {

        return ResponseEntity.ok(empreendedorService.listarTodos());
    }

    @Operation(
        summary = "Salvar um novo empreendedor",
        description = "Endpoint para criar um novo empreendedor",
        responses = {
            @ApiResponse(responseCode = "204", description = "Empreendedor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @PostMapping("/salvar")
    public ResponseEntity<Void> salvarEmpreendedor(@Valid @RequestBody CreateEmpreendedorDTO createEmpreendedorDTO) {

        empreendedorService.salvarEmpreendedor(createEmpreendedorDTO);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Buscar um empreendedor pelo ID",
        description = "Endpoint para buscar um empreendedor pelo seu ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Empreendedor.class))),
            @ApiResponse(responseCode = "404", description = "Empreendedor não encontrado", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do empreendedor", example = "1")
        }
    )
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Empreendedor> buscarEmpreendedorPeloId(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(empreendedorService.pegarEmpreendedorPeloId(id));
    }

    @Operation(
        summary = "Atualizar um empreendedor",
        description = "Endpoint para atualizar um empreendedor existente",
        responses = {
            @ApiResponse(responseCode = "204", description = "Empreendedor atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do empreendedor", example = "1")
        }
    )
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarEmpreendedor(@PathVariable("id") Integer id,
                                                      @Valid @RequestBody CreateEmpreendedorDTO createEmpreendedorDTO) {

        empreendedorService.atualizarEmpreendedor(createEmpreendedorDTO, id);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Deletar um empreendedor",
        description = "Endpoint para deletar um empreendedor existente",
        responses = {
            @ApiResponse(responseCode = "204", description = "Empreendedor deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do empreendedor", example = "1")
        }
    )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEmpreendedor(@PathVariable("id") Integer id) {

        empreendedorService.deletarEmpreendedor(id);

        return ResponseEntity.noContent().build();
    }
}

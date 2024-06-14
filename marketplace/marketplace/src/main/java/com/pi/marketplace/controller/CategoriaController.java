package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CategoriaDTO;
import com.pi.marketplace.dto.CreateCategoriaDTO;
import com.pi.marketplace.service.CategoriaService;
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

@Tag(name = "Categorias Controller API")
@RestController
@AllArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;


    @Operation(
        summary = "Listar todas as categorias",
        description = "Endpoint para listar todas as categorias disponíveis na plataforma",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {

        return ResponseEntity.ok(categoriaService.listarTodasCategorias());
    }

    @Operation(
        summary = "Salvar uma nova categoria",
        description = "Endpoint para criar uma nova categoria",
        responses = {
            @ApiResponse(responseCode = "204", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @PostMapping("/salvar")
    public ResponseEntity<Void> criarCategoria(@Valid @RequestBody CreateCategoriaDTO categoriaDTO) {

        categoriaService.salvarCategoria(categoriaDTO);

        return ResponseEntity.noContent().build();
    }

    @Operation(
        summary = "Deletar uma categoria",
        description = "Endpoint para deletar uma categoria",
        responses = {
            @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID da categoria", example = "1")
        }
    )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> criarCategoria(@PathVariable("id") Integer idCategoria) {

        categoriaService.deletarCategoria(idCategoria);

        return ResponseEntity.noContent().build();
    }

}

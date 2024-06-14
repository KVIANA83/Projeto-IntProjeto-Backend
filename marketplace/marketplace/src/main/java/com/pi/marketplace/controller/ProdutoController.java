package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CreateProdutoDTO;
import com.pi.marketplace.dto.ProdutoDTO;
import com.pi.marketplace.service.ProdutoService;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Tem no Bairro Produtos Controller API")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;


    @Operation(
        summary = "Listar todos os produtos",
        description = "Endpoint para listar produtos na plataforma",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro na requisição.", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {

        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @Operation(
        summary = "Salvar um novo produto",
        description = "Endpoint para criar um novo produto",
        responses = {
            @ApiResponse(responseCode = "204", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição.", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        }
    )
    @PostMapping("/salvar")
    public ResponseEntity<Void> criarProduto(@Valid @RequestBody CreateProdutoDTO createProdutoDTO) {

        produtoService.salvarProduto(createProdutoDTO);

        return ResponseEntity.noContent().build();
    }

   
    @Operation(
        summary = "Listar produtos por categoria",
        description = "Endpoint para listar produtos por categoria",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro na requisição.", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "categoria", description = "Categoria do produto", example = "Eletrônicos")
        }
    ) @GetMapping("/listar/categoria/{categoria}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorCategoria(@PathVariable("categoria") String categoria) {

        return ResponseEntity.ok(produtoService.listarProdutosPorCategoria(categoria));
    }

   
    @Operation(
        summary = "Listar produtos de um empreendedor",
        description = "Endpoint para listar produtos de um empreendedor específico",
        responses = {
            @ApiResponse(responseCode = "200", description = "Requisição feita com sucesso", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoDTO.class))),
            @ApiResponse(responseCode = "400", description = "Erro na requisição.", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "idEmp", description = "ID do empreendedor", example = "1")
        }
    ) @GetMapping("/listar/empreendendor/{idEmp}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosDoEmpreendedor(@PathVariable("idEmp") Integer idEmpreendedor) {

        return ResponseEntity.ok(produtoService.listarProdutosPorEmpreendedor(idEmpreendedor));
    }

    @Operation(
        summary = "Deletar um produto",
        description = "Endpoint para deletar um produto",
        responses = {
            @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição.", 
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
        },
        parameters = {
            @Parameter(name = "id", description = "ID do produto", example = "1")
        }
    )
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable("id") Integer idProduto) {

        produtoService.deletarProduto(idProduto);

        return ResponseEntity.noContent().build();
    }

}

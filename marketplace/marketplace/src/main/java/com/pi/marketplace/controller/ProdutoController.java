package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CreateProdutoDTO;
import com.pi.marketplace.dto.ProdutoDTO;
import com.pi.marketplace.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;


    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {

        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> criarProduto(@Valid @RequestBody CreateProdutoDTO createProdutoDTO) {

        produtoService.salvarProduto(createProdutoDTO);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar/categoria/{categoria}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosPorCategoria(@PathVariable("categoria") String categoria) {

        return ResponseEntity.ok(produtoService.listarProdutosPorCategoria(categoria));
    }

    @GetMapping("/listar/empreendendor/{idEmp}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutosDoEmpreendedor(@PathVariable("idEmp") Integer idEmpreendedor) {

        return ResponseEntity.ok(produtoService.listarProdutosPorEmpreendedor(idEmpreendedor));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable("id") Integer idProduto) {

        produtoService.deletarProduto(idProduto);

        return ResponseEntity.noContent().build();
    }

}

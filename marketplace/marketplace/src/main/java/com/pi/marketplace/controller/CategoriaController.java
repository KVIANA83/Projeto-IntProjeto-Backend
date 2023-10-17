package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CategoriaDTO;
import com.pi.marketplace.dto.CreateCategoriaDTO;
import com.pi.marketplace.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;


    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {

        return ResponseEntity.ok(categoriaService.listarTodasCategorias());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> criarCategoria(@Valid @RequestBody CreateCategoriaDTO categoriaDTO) {

        categoriaService.salvarCategoria(categoriaDTO);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> criarCategoria(@PathVariable("id") Integer idCategoria) throws ClassNotFoundException {

        categoriaService.deletarCategoria(idCategoria);

        return ResponseEntity.noContent().build();
    }

}

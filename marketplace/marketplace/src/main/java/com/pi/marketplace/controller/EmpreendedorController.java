package com.pi.marketplace.controller;

import com.pi.marketplace.dto.CreateEmpreendedorDTO;
import com.pi.marketplace.dto.EmpreendedorDTO;
import com.pi.marketplace.model.Empreendedor;
import com.pi.marketplace.service.EmpreendedorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/empreendedores")
public class EmpreendedorController {

    private EmpreendedorService empreendedorService;


    @GetMapping("/listar")
    public ResponseEntity<List<EmpreendedorDTO>> listarEmpreendedores() {

        return ResponseEntity.ok(empreendedorService.listarTodos());
    }

    @GetMapping("/listar/empreendedor/{id}")
    public ResponseEntity<List<EmpreendedorDTO>> listarEmpreendedores(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(empreendedorService.listarTodos());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Void> salvarEmpreendedor(@Valid @RequestBody CreateEmpreendedorDTO createEmpreendedorDTO) {

        empreendedorService.salvarEmpreendedor(createEmpreendedorDTO);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Empreendedor> buscarEmpreendedorPeloId(@PathVariable("id") Integer id) throws ClassNotFoundException {

        return ResponseEntity.ok(empreendedorService.pegarEmpreendedorPeloId(id));
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarEmpreendedor(@PathVariable("id") Integer id,
                                                      @Valid @RequestBody CreateEmpreendedorDTO createEmpreendedorDTO) throws ClassNotFoundException {

        empreendedorService.atualizarEmpreendedor(createEmpreendedorDTO, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEmpreendedor(@PathVariable("id") Integer id) throws ClassNotFoundException {

        empreendedorService.deletarEmpreendedor(id);

        return ResponseEntity.noContent().build();
    }
}

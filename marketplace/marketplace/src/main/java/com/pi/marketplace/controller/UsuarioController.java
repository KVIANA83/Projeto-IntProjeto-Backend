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

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {

        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {

        return ResponseEntity.ok(usuarioService.pegarUsuarioPeloId(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criarUsuario(@Valid @RequestBody CreateUsuarioDTO usuarioDTO) {

        usuarioService.saveUsuario(usuarioDTO);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarUsuario(@PathVariable Integer id,
            @Valid @RequestBody CreateUsuarioDTO usuarioAtualizar) {

        usuarioService.atualizarUsuario(usuarioAtualizar, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {

        usuarioService.deletarUsuario(id);

        return ResponseEntity.noContent().build();
    }
}

package com.pi.marketplace.controller;

import com.pi.marketplace.dto.LoginDTO;
import com.pi.marketplace.service.EmpreendedorService;
import com.pi.marketplace.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private UsuarioService usuarioService;
    private EmpreendedorService empreendedorService;

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

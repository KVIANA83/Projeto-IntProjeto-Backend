package com.pi.marketplace.controller;

import com.pi.marketplace.model.Empreendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pi.marketplace.repository.EmpreendedorRepository;

import java.util.List;

@RestController
@RequestMapping("/empreendedores")
public class EmpreendedorController {

    @Autowired
    private EmpreendedorRepository empreendedorRepository;

    @GetMapping
    public List<Empreendedor> listarEmpreendedores() {
        return empreendedorRepository.findAll();
    }

    @PostMapping
    public Empreendedor criarEmpreendedor(@RequestBody Empreendedor empreendedor) {
        return empreendedorRepository.save(empreendedor);
    }

     Adicione outros métodos para atualizar, excluir e recuperar empreendedores por ID
}

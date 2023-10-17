package com.pi.marketplace.service;

import com.pi.marketplace.dto.CreateEmpreendedorDTO;
import com.pi.marketplace.dto.EmpreendedorDTO;
import com.pi.marketplace.model.Empreendedor;
import com.pi.marketplace.repository.EmpreendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpreendedorService {

    private EmpreendedorRepository empreendedorRepository;


    public List<EmpreendedorDTO> listarTodos() {

        var listaEmpreendores = empreendedorRepository.findAll();

        var empreendedorDTOS = new ArrayList<EmpreendedorDTO>();

        for(Empreendedor empreendedor : listaEmpreendores) {

            var empreendedorDTO = EmpreendedorDTO.builder()
                    .telefone(empreendedor.getTelefone())
                    .razaoSocial(empreendedor.getRazaoSocial())
                    .nomeCompleto(empreendedor.getNomeCompleto())
                    .endereco(empreendedor.getEndereco())
                    .email(empreendedor.getEmail())
                    .build();

            empreendedorDTOS.add(empreendedorDTO);
        }

        return empreendedorDTOS;
    }

    public Empreendedor pegarEmpreendedorPeloId(Integer id) throws ClassNotFoundException {

        var empreendedor = empreendedorRepository.findById(id);

        if (empreendedor.isEmpty()) {
            throw new ClassNotFoundException("Empreendedor não encontrado com o ID: %s" + id);
        }

        return empreendedor.get();
    }

    public void salvarEmpreendedor(CreateEmpreendedorDTO empreendedorDTO) {

        var empreendedor = Empreendedor.builder()
                .dataNascimento(empreendedorDTO.getDataNascimento())
                .email(empreendedorDTO.getEmail())
                .senha(empreendedorDTO.getSenha())
                .endereco(empreendedorDTO.getEndereco())
                .nomeCompleto(empreendedorDTO.getNomeCompleto())
                .razaoSocial(empreendedorDTO.getRazaoSocial())
                .telefone(empreendedorDTO.getTelefone())
                .build();

        empreendedorRepository.save(empreendedor);
    }

    public void atualizarEmpreendedor(CreateEmpreendedorDTO empreendedorAtualizar, Integer id) throws ClassNotFoundException {

        var empreendedor = pegarEmpreendedorPeloId(id);

        empreendedor.setNomeCompleto(empreendedorAtualizar.getNomeCompleto());
        empreendedor.setRazaoSocial(empreendedorAtualizar.getRazaoSocial());
        empreendedor.setEndereco(empreendedorAtualizar.getEndereco());
        empreendedor.setTelefone(empreendedorAtualizar.getTelefone());
        empreendedor.setEmail(empreendedorAtualizar.getEmail());
        empreendedor.setSenha(empreendedorAtualizar.getSenha());
        empreendedor.setDataNascimento(empreendedorAtualizar.getDataNascimento());

        empreendedorRepository.save(empreendedor);
    }

    public void deletarEmpreendedor(Integer id) throws ClassNotFoundException {

        Optional<Empreendedor> entity = empreendedorRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ClassNotFoundException("Empreendedor não encontrado com o ID: %s" + id);
        }

        empreendedorRepository.delete(entity.get());
    }

}
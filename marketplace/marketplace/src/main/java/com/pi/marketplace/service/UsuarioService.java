package com.pi.marketplace.service;

import com.pi.marketplace.dto.CreateUsuarioDTO;
import com.pi.marketplace.dto.UsuarioDTO;
import com.pi.marketplace.model.Usuario;
import com.pi.marketplace.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos() {
        var listaUsuarios = usuarioRepository.findAll();

        var usuarioDTOS = new ArrayList<UsuarioDTO>();

        for(Usuario usuario : listaUsuarios) {

            var usuarioDTO = UsuarioDTO.builder()
                    .telefone(usuario.getTelefone())
                    .nomeSocial(usuario.getNomeSocial())
                    .nomeCompleto(usuario.getNomeCompleto())
                    .endereco(usuario.getEndereco())
                    .email(usuario.getEmail())
                    .build();

            usuarioDTOS.add(usuarioDTO);
        }

        return usuarioDTOS;
    }

    public Usuario pegarUsuarioPeloId(Integer id) throws ClassNotFoundException {

        var usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new ClassNotFoundException("Usuário não encontrado com o ID: %s" + id);
        }

        return usuario.get();
    }

    public void saveUsuario(CreateUsuarioDTO usuarioDTO) {

        var usuario = Usuario.builder()
                .dataNascimento(usuarioDTO.getDataNascimento())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .endereco(usuarioDTO.getEndereco())
                .nomeCompleto(usuarioDTO.getNomeCompleto())
                .nomeSocial(usuarioDTO.getNomeSocial())
                .telefone(usuarioDTO.getTelefone())
                .build();

        usuarioRepository.save(usuario);
    }

    public void atualizarUsuario(CreateUsuarioDTO usuarioAtualizar, Integer id) throws ClassNotFoundException {

        var usuario = pegarUsuarioPeloId(id);

        usuario.setNomeCompleto(usuarioAtualizar.getNomeCompleto());
        usuario.setNomeSocial(usuarioAtualizar.getNomeSocial());
        usuario.setEndereco(usuarioAtualizar.getEndereco());
        usuario.setTelefone(usuarioAtualizar.getTelefone());
        usuario.setEmail(usuarioAtualizar.getEmail());
        usuario.setSenha(usuarioAtualizar.getSenha());
        usuario.setDataNascimento(usuarioAtualizar.getDataNascimento());

        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Integer id) throws ClassNotFoundException {

        var entity = pegarUsuarioPeloId(id);

        usuarioRepository.delete(entity);
    }

}

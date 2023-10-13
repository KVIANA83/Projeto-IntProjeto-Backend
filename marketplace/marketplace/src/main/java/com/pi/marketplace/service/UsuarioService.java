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
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for(Usuario usuario : listaUsuarios) {
            UsuarioDTO usuarioDTO = UsuarioDTO.builder()
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
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            throw new ClassNotFoundException("Usuário não encontrado com o ID: %s" + id);
        }

        return usuario.get();
    }

    public void saveUsuario(CreateUsuarioDTO usuarioDTO) {

        Usuario entity = Usuario.builder()
                .dataNascimento(usuarioDTO.getDataNascimento())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .endereco(usuarioDTO.getEndereco())
                .nomeCompleto(usuarioDTO.getNomeCompleto())
                .nomeSocial(usuarioDTO.getNomeSocial())
                .telefone(usuarioDTO.getTelefone())
                .build();

        usuarioRepository.save(entity);
    }

    public void atualizarUsuario(CreateUsuarioDTO usuarioAtualizar, Integer id) throws ClassNotFoundException {

        Optional<Usuario> entity = usuarioRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ClassNotFoundException("Usuário não encontrado com o ID: %s" + id);
        }

        Usuario usuario = entity.get();
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

        Optional<Usuario> entity = usuarioRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ClassNotFoundException("Usuário não encontrado com o ID: %s" + id);
        }

        usuarioRepository.delete(entity.get());
    }

}

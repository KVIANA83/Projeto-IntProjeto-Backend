package com.pi.marketplace.service;

import com.pi.marketplace.dto.CategoriaDTO;
import com.pi.marketplace.dto.CreateCategoriaDTO;
import com.pi.marketplace.exceptions.ValidacaoException;
import com.pi.marketplace.model.Categoria;
import com.pi.marketplace.repository.CategoriaRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> listarTodasCategorias() {

        var categorias = categoriaRepository.findAll();
        var categoriasDTO = new ArrayList<CategoriaDTO>();

        for (Categoria categoria: categorias) {

            var categoriaDTO = CategoriaDTO.builder()
                    .nome(categoria.getNome())
                    .descricao(categoria.getDescricao())
                    .build();

            categoriasDTO.add(categoriaDTO);
        }

        return categoriasDTO;
    }

    public Categoria buscarCategoriaPorId(Integer idCategoria) {

        var entity = categoriaRepository.findById(idCategoria);

        if (entity.isEmpty()) {
            throw new ValidacaoException("Categoria não encontrada com o ID: %s" + idCategoria);
        }

        return entity.get();
    }

    public Categoria buscarCategoriaPorNome(String categoria) {

        var entity = categoriaRepository.findByNome(categoria);

        if (entity.isEmpty()) {
            throw new ValidacaoException("Categoria não encontrada com o nome: %s" + categoria);
        }

        return entity.get();
    }

    public void salvarCategoria(CreateCategoriaDTO categoriaDTO) {

        var categoria = Categoria.builder()
                .nome(categoriaDTO.getNome())
                .descricao(categoriaDTO.getDescricao())
                .build();

        categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Integer idCategoria) {

        var entity = buscarCategoriaPorId(idCategoria);

        categoriaRepository.delete(entity);
    }
}

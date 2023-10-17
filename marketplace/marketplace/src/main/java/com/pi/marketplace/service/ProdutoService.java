package com.pi.marketplace.service;

import com.pi.marketplace.dto.*;
import com.pi.marketplace.model.Produto;
import com.pi.marketplace.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private CategoriaService categoriaService;
    private EmpreendedorService empreendedorService;


    public List<ProdutoDTO> listarProdutos() {

        var produtos = produtoRepository.findAll();

        return converteEntidadeParaDTO(produtos);
    }

    public List<ProdutoDTO> listarProdutosPorCategoria(String nomeCategoria) throws Exception {

        var categoria = categoriaService.buscarCategoriaPorNome(nomeCategoria);

        var listaProdutos = produtoRepository.findAllByCategoria(categoria);

        if (listaProdutos.isEmpty()) {
            throw new Exception("Não existem produtos com categoria: %s" + nomeCategoria);
        }

        return converteEntidadeParaDTO(listaProdutos.get());

    }

    public List<ProdutoDTO> listarProdutosPorEmpreendedor(Integer idEmpreendedor) throws Exception {

        var empreendedor = empreendedorService.pegarEmpreendedorPeloId(idEmpreendedor);

        var listaProdutos = produtoRepository.findAllByEmpreendedor(empreendedor);

        if (listaProdutos.isEmpty()) {
            throw new Exception("O empreendedor ainda não possui produtos cadastrados!");
        }

        return converteEntidadeParaDTO(listaProdutos.get());

    }

    public void salvarProduto(CreateProdutoDTO createProdutoDTO) throws ClassNotFoundException {

        var categoria = categoriaService.buscarCategoriaPorId(createProdutoDTO.getIdCategoria());
        var empreendedor = empreendedorService.pegarEmpreendedorPeloId(createProdutoDTO.getIdEmpreendedor());

        var produto = Produto.builder()
                .nome(createProdutoDTO.getNome())
                .descricao(createProdutoDTO.getDescricao())
                .urlImagem(createProdutoDTO.getUrlImagem())
                .categoria(categoria)
                .empreendedor(empreendedor)
                .build();

        produtoRepository.save(produto);
    }

    public void deletarProduto(Integer idProduto) throws ClassNotFoundException {

        var produto = produtoRepository.findById(idProduto);

        if (produto.isEmpty()) {
            throw new ClassNotFoundException("Usuário não encontrado com o ID: %s" + idProduto);
        }

        produtoRepository.delete(produto.get());
    }

    private List<ProdutoDTO> converteEntidadeParaDTO(List<Produto> produtos) {

        var produtosDTO = new ArrayList<ProdutoDTO>();

        for (Produto produto: produtos) {

            var emp = produto.getEmpreendedor();

            var produtoDTO = ProdutoDTO.builder()
                    .nome(produto.getNome())
                    .descricao(produto.getDescricao())
                    .categoria(produto.getCategoria().getNome())
                    .urlImagem(produto.getUrlImagem())
                    .empreendedor(EmpreendedorDTO.builder()
                            .telefone(emp.getTelefone())
                            .email(emp.getEmail())
                            .nomeCompleto(emp.getNomeCompleto())
                            .razaoSocial(emp.getRazaoSocial())
                            .endereco(emp.getEndereco())
                            .build())
                    .build();

            produtosDTO.add(produtoDTO);
        }

        return produtosDTO;
    }
}

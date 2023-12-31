package com.pi.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @OneToOne
    private Categoria categoria;

    @JoinColumn(name = "id_empreendedor", referencedColumnName = "id_empr")
    @OneToOne()
    private Empreendedor empreendedor;

    @Column(name = "url_imagem")
    private String urlImagem;

}

package com.example.Projetofinal.domain.produtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoricoProdutos {
    private LocalDateTime data;
    private int quantidade;
    @DBRef
    private Produto produto;
    private Double valor_ultima_compra;
    private Boolean realizada;

    public HistoricoProdutos(DadosAttProd dados){
        this.data = dados.data_ultima_compra();
        this.quantidade = dados.quantidade();
        this.produto = null;
        this.valor_ultima_compra = dados.valor_ultima_compra();
        this.realizada = false;
    }
}

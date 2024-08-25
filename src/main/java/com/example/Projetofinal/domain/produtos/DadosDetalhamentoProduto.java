package com.example.Projetofinal.domain.produtos;

import java.time.LocalDateTime;
import java.util.Date;

public record DadosDetalhamentoProduto(
        String id,
        String nome,
        int quantidade,
        int qtd_min,
        Unidade unidade,
        LocalDateTime data_ultima_compra,
        String descritivo,
        Double preco_unit

) {
    public DadosDetalhamentoProduto(Produto prod){
        this(prod.getId() ,prod.getNome(), prod.getQuantidade(), prod.getQtd_min(), prod.getUnidade(), prod.getData_ultima_compra(), prod.getDescritivo(), prod.getPreco_unid());
    }
}

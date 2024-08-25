package com.example.Projetofinal.domain.carga;

import java.time.LocalDateTime;

public record DadosDetalhamentoCarga(
        String id,
        LocalDateTime dia,
        double valor,
        int caixas,
        BananaTipo tipoBanana,
        String nomeVendedor
) {
    public DadosDetalhamentoCarga(Carga carga){
        this(carga.getId(), carga.getDia(), carga.getValor(), carga.getCaixas(), carga.getTipoBanana(), carga.getVendedor().getNome());
    }
}

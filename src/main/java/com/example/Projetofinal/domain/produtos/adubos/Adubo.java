package com.example.Projetofinal.domain.produtos.adubos;

import com.example.Projetofinal.domain.produtos.DadosCadastroProduto;
import com.example.Projetofinal.domain.produtos.Produto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adubo extends Produto {
    private Double dose;
    private Double nitrogenio;
    private Double fosforo;
    private Double potassio;

    private Map<String, Double> composition;

    public Adubo(DadosCadastroAdubo dados){
        super(new DadosCadastroProduto(dados.nome(), dados.quantidade(), dados.qtd_min(), dados.unidade(), dados.descritivo()));
        this.dose = dados.dose();
        this.nitrogenio = dados.nitrogenio();
        this.fosforo = dados.fosforo();
        this.potassio = dados.potassio();
        this.composition = dados.composition();

    }
}

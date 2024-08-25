package com.example.Projetofinal.domain.produtos.adubos;

import com.example.Projetofinal.domain.produtos.Unidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record DadosCadastroAdubo(
        @NotBlank
        String nome,
        @NotNull
        int quantidade,
        @NotNull
        int qtd_min,
        @NotNull
        Unidade unidade,
        @NotBlank
        String descritivo,
        @NotNull
        Double dose,
        @NotNull
        Double nitrogenio,
        @NotNull
        Double fosforo,
        @NotNull
        Double potassio,
        @NotNull
        Map<String, Double> composition
) {
}

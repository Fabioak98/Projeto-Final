package com.example.Projetofinal.domain.produtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotNull
        int quantidade,
        @NotNull
        int qtd_min,
        @NotNull
        Unidade unidade,
        @NotBlank
        String descritivo
) {
}

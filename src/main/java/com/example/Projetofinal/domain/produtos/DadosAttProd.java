package com.example.Projetofinal.domain.produtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

public record DadosAttProd(
        @NotNull
        String id,
        @NotNull
        int quantidade,
        @NotNull
        int qtd_min,
        LocalDateTime data_ultima_compra,
        @NotNull
        Double valor_ultima_compra,
        @NotBlank
        String descritivo
) {
}

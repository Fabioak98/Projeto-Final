package com.example.Projetofinal.domain.comprador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadComprador(
    @NotBlank
    String nome,
    @NotNull
    String cnpj
) {
}

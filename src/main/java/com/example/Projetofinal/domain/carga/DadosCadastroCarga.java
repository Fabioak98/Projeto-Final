package com.example.Projetofinal.domain.carga;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroCarga(
        @Future
        LocalDateTime dia,
        @NotBlank
        double valor,
        @NotBlank
        int caixas,
        @NotBlank
        BananaTipo tipoBanana,
        @NotBlank
        String placaVeiculo,
        @NotBlank
        String idVendedor
) {
}

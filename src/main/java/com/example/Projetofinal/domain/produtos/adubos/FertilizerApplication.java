package com.example.Projetofinal.domain.produtos.adubos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Month;

@Entity
@Data
public class FertilizerApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fertilizer_id")
    private Adubo adubo;

    private Month mes;
    private Double quantidadeAplicada;
}
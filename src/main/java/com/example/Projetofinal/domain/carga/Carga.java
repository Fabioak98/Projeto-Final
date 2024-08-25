package com.example.Projetofinal.domain.carga;

import com.example.Projetofinal.domain.vendedor.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Carga {
    @Id
    private String id;
    private LocalDateTime dia;
    private double valor;
    private int caixas;
    private BananaTipo tipoBanana;
    private String placaVeiculo;
    @DBRef
    private Vendedor vendedor;

    public Carga(DadosCadastroCarga dados){
        this.dia = dados.dia();
        this.valor = dados.valor();
        this.caixas = dados.caixas();
        this.tipoBanana = dados.tipoBanana();
        this.placaVeiculo = dados.placaVeiculo();

    }
}
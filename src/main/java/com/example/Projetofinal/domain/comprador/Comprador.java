package com.example.Projetofinal.domain.comprador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="compradores")
@Entity(name="Comprador")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comprador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nome;

    private String cnpj;

    public Comprador(DadosCadComprador dados ){
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
    }

}

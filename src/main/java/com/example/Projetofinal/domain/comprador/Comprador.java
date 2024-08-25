package com.example.Projetofinal.domain.comprador;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comprador {
    @Id
    private String id;

    private String nome;

    private String cnpj;

    public Comprador(DadosCadComprador dados ){
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
    }

}

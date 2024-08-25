package com.example.Projetofinal.domain.vendedor;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendedores")
@Getter
public class Vendedor {
    @Id
    private String id;
    private String nome;
    private String contato;


    // Getters and Setters
}
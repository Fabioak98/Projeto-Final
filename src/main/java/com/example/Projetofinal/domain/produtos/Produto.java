package com.example.Projetofinal.domain.produtos;

import com.example.Projetofinal.domain.produtos.adubos.Adubo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Adubo.class, name = "adubo")
})
public class Produto {
    @Id
    private String id;
    private String nome;
    private int quantidade;
    private int qtd_min;
    private Unidade unidade;
    private LocalDateTime data_ultima_compra;
    private Double valor_ultima_compra;
    private String descritivo;
    private Double preco_unid;

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.quantidade = dados.quantidade();
        this.qtd_min = dados.qtd_min();
        this.unidade = dados.unidade();
        this.descritivo = dados.descritivo();
    }

    public void  attQuantidade(int quantidade){
        this.quantidade += quantidade;
    }
}

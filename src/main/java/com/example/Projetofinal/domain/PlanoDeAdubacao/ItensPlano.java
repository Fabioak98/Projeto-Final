package com.example.Projetofinal.domain.PlanoDeAdubacao;

import com.example.Projetofinal.domain.produtos.adubos.Adubo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItensPlano {
    private Adubo adubo;
    private Double doses;
}

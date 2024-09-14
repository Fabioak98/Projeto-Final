package com.example.Projetofinal.domain.PlanoDeAdubacao;

import com.example.Projetofinal.domain.produtos.adubos.Adubo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanoDeAdubacao {
    @Id
    private Long id;

    private LocalDateTime start;
    private LocalDateTime end;

    @DBRef
    private List<ItensPlano> itens;

    public void ajustarDoses(Double doseJogada, int mesCorrente) {
        Double dosePlanejada = this.itens.get(mesCorrente).getDoses();
        Double diferenca = dosePlanejada - doseJogada;

        if (diferenca != 0) {
            Double dosePorMes = diferenca / (itens.size() - mesCorrente - 1);
            for (int i = mesCorrente + 1; i < itens.size(); i++) {
                ItensPlano item = itens.get(i);
                item.setDoses(item.getDoses() + dosePorMes);
            }
        }
    }
}
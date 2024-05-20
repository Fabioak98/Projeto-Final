package com.example.Projetofinal.domain.produtos.adubos;

import com.example.Projetofinal.domain.produtos.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Adubo extends Produto {
    private Double dose;
    private Double nitrogenio;
    private Double fosforo;
    private Double potassio;

    @OneToMany(mappedBy = "fertilizer")
    private List<FertilizerApplication> applications;
}

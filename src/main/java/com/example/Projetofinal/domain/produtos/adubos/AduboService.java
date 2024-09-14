package com.example.Projetofinal.domain.produtos.adubos;

import com.example.Projetofinal.domain.produtos.Produto;
import com.example.Projetofinal.domain.produtos.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AduboService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public Adubo cadastraAdubo(DadosCadastroAdubo dados) {
        Adubo adubo = new Adubo(dados);
        return produtoRepository.save(adubo);
    }

}

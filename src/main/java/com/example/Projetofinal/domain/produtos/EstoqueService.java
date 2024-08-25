package com.example.Projetofinal.domain.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private HistoricoProdutosRepository historicoProdutosRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteById(String id) {
        produtoRepository.deleteById(id);
    }

    public Produto cadastraProduto(DadosCadastroProduto dados) {
        Produto produto = new Produto(dados);
        return produtoRepository.save(produto);
    }

    public Produto atualizaProduto(DadosAttProd dados) {
        Produto produto = produtoRepository.findById(dados.id()).get();
        HistoricoProdutos historicoProdutos = new HistoricoProdutos(dados);

        if (dados.quantidade() > 0) {
            produto.attQuantidade(dados.quantidade());
            produto.setData_ultima_compra(dados.data_ultima_compra());
            produto.setValor_ultima_compra(dados.valor_ultima_compra());
        }
        produto.setQtd_min(dados.qtd_min());
        produto.setDescritivo(dados.descritivo());
        historicoProdutos.setRealizada(true);

        historicoProdutos.setProduto(produto);
        historicoProdutosRepository.save(historicoProdutos);
        return produtoRepository.save(produto);
    }
}


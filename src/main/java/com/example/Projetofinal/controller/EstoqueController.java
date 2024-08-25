package com.example.Projetofinal.controller;

import com.example.Projetofinal.domain.produtos.*;
import com.example.Projetofinal.domain.produtos.adubos.Adubo;
import com.example.Projetofinal.domain.produtos.adubos.AduboService;
import com.example.Projetofinal.domain.produtos.adubos.DadosCadastroAdubo;
import com.example.Projetofinal.domain.user.DadosDetalhamentoUsuario;
import com.example.Projetofinal.domain.user.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private AduboService aduboService;

    @Autowired
    private ProdutoRepository produtoRepository;


    private Page<DadosDetalhamentoProduto> convertListToPage (List<DadosDetalhamentoProduto> produtoList, int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        int start = Math.min((int) pageable.getOffset(), produtoList.size());
        int end = Math.min((start + pageable.getPageSize()), produtoList.size());

        List<DadosDetalhamentoProduto> subList = produtoList.subList(start,end);

        return new PageImpl<>(subList,pageable,produtoList.size());
    }
    @Transactional
    @PostMapping("/cadastra")
    public ResponseEntity cadastraProduto(@Valid @RequestBody DadosCadastroProduto dados, UriComponentsBuilder uriComponentsBuilder) {
        Produto produto = estoqueService.cadastraProduto(dados);
        var uri = uriComponentsBuilder.path("/estoque/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @Transactional
    @PostMapping("/adubo/cadastra")
    public ResponseEntity cadastraAdubo(@Valid @RequestBody DadosCadastroAdubo dados, UriComponentsBuilder uriComponentsBuilder){
        Adubo adubo = aduboService.cadastraAdubo(dados);
        var uri = uriComponentsBuilder.path("/estoque/adubo/{id}").buildAndExpand(adubo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(adubo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoProduto>> pegaEstoque(@PageableDefault Pageable pageable ){
        Page<DadosDetalhamentoProduto> lista = produtoRepository.findAll(pageable).map(DadosDetalhamentoProduto :: new);
        return ResponseEntity.ok(lista);
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizaProduto(@RequestBody @Valid DadosAttProd dados){
        Produto produto = estoqueService.atualizaProduto(dados);
        return  ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping("/aviso-minimo")
    public ResponseEntity<Page<DadosDetalhamentoProduto>> avisoProdutoMin(
            @RequestParam(value = "page", defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", defaultValue = "10") int pageSize){

        List<DadosDetalhamentoProduto> produtoList = new ArrayList<>();
        for (Produto item : estoqueService.findAll()) {
            if (item.getQtd_min() >= item.getQuantidade()) {
                produtoList.add(new DadosDetalhamentoProduto(item));
            }
        }

        Page<DadosDetalhamentoProduto> paginacao = convertListToPage(produtoList,pageNumber,pageSize);

        return ResponseEntity.ok(paginacao);
    }
}

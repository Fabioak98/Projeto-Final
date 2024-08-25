package com.example.Projetofinal.controller;

import com.example.Projetofinal.domain.carga.Carga;
import com.example.Projetofinal.domain.carga.CargaService;
import com.example.Projetofinal.domain.carga.DadosCadastroCarga;
import com.example.Projetofinal.domain.carga.DadosDetalhamentoCarga;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {

    @Autowired
    private CargaService cargaService;
    @PostMapping("/carga")
    public ResponseEntity registraCarga(@RequestBody @Valid DadosCadastroCarga dados, UriComponentsBuilder uriComponentsBuilder){
        Carga carga = cargaService.registraCarga(dados);
        var uri = uriComponentsBuilder.path("/carga/{id}").buildAndExpand(carga.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCarga(carga));
    }

}

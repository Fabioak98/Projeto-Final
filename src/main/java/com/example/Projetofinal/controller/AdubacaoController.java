package com.example.Projetofinal.controller;

import com.example.Projetofinal.domain.PlanoDeAdubacao.DadosCadastroPlano;
import com.example.Projetofinal.domain.PlanoDeAdubacao.PlanoDeAdubacao;
import com.example.Projetofinal.domain.PlanoDeAdubacao.PlanoDeAdubacaoRepository;
import com.example.Projetofinal.domain.produtos.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/adubacao")
public class AdubacaoController {

    @Autowired
    private PlanoDeAdubacaoRepository PlanoDeAdubacaoRepository;

    @Autowired
    private ProdutoRepository aduboRepository;

    // Criação de um novo plano de adubação
    @PostMapping("/criar-plano")
    public ResponseEntity<PlanoDeAdubacao> criarPlano(@RequestParam String aduboId,
                                                    @RequestParam Double doseTotal,
                                                    @RequestParam int meses,
                                                    @RequestParam String startDate) {
        // Busca o adubo pelo ID
//        Adubo adubo = aduboRepository.findById(aduboId)
//                .orElseThrow(() -> new RuntimeException("Adubo não encontrado"));

        // Cria um novo plano de adubação
        PlanoDeAdubacao plano = new PlanoDeAdubacao();
        plano.setStart(LocalDateTime.parse(startDate));
        plano.setEnd(plano.getStart().plusMonths(meses));


        // Salva o plano de adubação no banco de dados
        PlanoDeAdubacaoRepository.save(plano);

        return ResponseEntity.ok(plano);
    }

    // Ajustar a dose jogada para um mês específico
    @PutMapping("/ajustar-dose")
    public ResponseEntity<PlanoDeAdubacao> ajustarDose(@RequestParam String planoId,
                                                     @RequestParam int mesCorrente,
                                                     @RequestParam Double doseJogada) {
        // Busca o plano de adubação pelo ID
        PlanoDeAdubacao plano = PlanoDeAdubacaoRepository.findById(planoId)
                .orElseThrow(() -> new RuntimeException("Plano de adubação não encontrado"));

        // Ajusta as doses com base na quantidade jogada
        plano.ajustarDoses(doseJogada, mesCorrente);

        // Salva o plano atualizado
        PlanoDeAdubacaoRepository.save(plano);

        return ResponseEntity.ok(plano);
    }

    // Confirmar e sobrescrever o plano de adubação ajustado
    @PostMapping("/confirmar-ajuste")
    public ResponseEntity<String> confirmarAjuste(@RequestParam String planoId) {
        // Busca o plano de adubação pelo ID
        PlanoDeAdubacao plano = PlanoDeAdubacaoRepository.findById(planoId)
                .orElseThrow(() -> new RuntimeException("Plano de adubação não encontrado"));

        // Confirmar o ajuste
//        plano.confirmarAjuste();

        // Salva o plano final no banco de dados
        PlanoDeAdubacaoRepository.save(plano);

        return ResponseEntity.ok("Ajuste confirmado e plano atualizado com sucesso.");
    }

    // Obter um plano de adubação por ID
    @GetMapping("/plano/{id}")
    public ResponseEntity<PlanoDeAdubacao> obterPlano(@PathVariable String id) {
        // Busca o plano de adubação pelo ID
        PlanoDeAdubacao plano = PlanoDeAdubacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano de adubação não encontrado"));

        return ResponseEntity.ok(plano);
    }

    // Deletar um plano de adubação
    @DeleteMapping("/deletar-plano/{id}")
    public ResponseEntity<String> deletarPlano(@PathVariable String id) {
        // Busca o plano de adubação pelo ID
        PlanoDeAdubacao plano = PlanoDeAdubacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano de adubação não encontrado"));

        PlanoDeAdubacaoRepository.delete(plano);
        return ResponseEntity.ok("Plano de adubação deletado com sucesso.");
    }

}

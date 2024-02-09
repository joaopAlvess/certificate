package br.com.fox.certificate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fox.certificate.repositores.CertificacoesEstudanteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/ranking")
public class RankingController {
    
    @Autowired
    private Ranking ranking

    @GetMapping("/top10")
    public List<> top10() {
        return this.ranking.listarRanking();
    }
    
}

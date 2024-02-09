package br.com.fox.certificate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fox.certificate.repositores.CertificacoesEstudanteRepository;

@Service
public class Ranking {

    @Autowired
    private CertificacoesEstudanteRepository certificacoesEstudanteRepository;

    public List<CertificacoesEstudante> listarRanking() {
        return this.certificacoesEstudanteRepository.findByTop10OrderDesc()
    }

}

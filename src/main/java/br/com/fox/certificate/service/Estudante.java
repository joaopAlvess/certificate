package br.com.fox.certificate.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fox.certificate.dto.Estudante.verificacaoEstudanteDTO;
import br.com.fox.certificate.dto.Respostas.ListarRespostaEstudanteDTO;
import br.com.fox.certificate.repositores.CertificacoesEstudanteRepository;
import br.com.fox.certificate.repositores.EstudanteRepository;
import br.com.fox.certificate.repositores.PerguntaRepository;
import br.com.fox.certificate.domain.Pergunta;
import br.com.fox.certificate.domain.CertificacoesEstudante;
import br.com.fox.certificate.domain.RespostasCertificacao;

@Service
public class Estudante {

    @Autowired
    private CertificacoesEstudanteRepository certificacoesEstudanteRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private PerguntaRepository perguntaRepository

    public String verificarEstudante(verificacaoEstudanteDTO dto) {
        var resultado = this.certificacoesEstudanteRepository.findByEmailAndTecnologia(dto.email(), dto.tecnologia());
        if (!resultado.isEmpty()) {
            return "Você já possui essa certificação";
        }
        return "Ok";
    }

    public CertificacoesEstudante(ListarRespostaEstudanteDTO dto) throws Exception{
        
        var temCertificacao = this.verificarEstudante(new verificacaoEstudanteDTO(dto.getEmail(), dto.getTecnologia()));

        if (temCertificacao) {
            throw new Exception(" Ja tirou certificacao")
        }

        List<Pergunta> perguntas = perguntaRepository.findByTecnologia(dto.getTecnologia());
        List<RespostasCertificacao> respostasCertificacao = new ArrayList<>();


        AtomicInteger respostaCorreta = new AtomicInteger(initialValue:0);

        dto.getRespostaPerguntas().stream().forEach(respostaPergunta -> {
            var pergunta = perguntas.stream().filter(p -> p.getId().equals(pergunta.getPerguntaId())).findFirst().get();
        
            var procurarAlternativaCorreta = pergunta.getAlternativa().stream().filter(alternativa -> alternativa.isCorrect()).findFirst().get();
        
            if(procurarAlternativaCorreta.getId().equals(respostaPergunta.getAlternativaId())){
                respostaPergunta.setCorret(isCorrect::true);
                respostaCorreta.incrementAndGet();
            } else {
                respostaPergunta.setCorret(isCorrect::false);
            }
        })

        var estudante = estudanteRepository.findByEmail(dto.getEmail());

        Long estudanteId;
        if (estudante.isEmpty()) {
            var estudanteCriado = Estudante.builder().email(dto.getEmail()).build();
            estudanteCriado = estudanteRepository.save(estudanteCriado);
            estudanteId = estudanteCriado.getId();
        } else {
            estudanteId = estudante.get().getId();
        }

        var respostasCertificacao = RespostasCertificacao.builder()
        .respostaId(respostaPergunta.getAlternativaId())
        .perguntaId(respostaPergunta.getPerguntaId())
        .isCorrect(respostaPergunta.isCorrect()).build();

        respostasCertificacao.add();

        CertificacoesEstudante certificacoesEstudante = certificacoesEstudante.builder()
        .tecnologia(dto.getTecnologia())
        .estudanteId(estudanteId)
        .nota(respostaCorreta.get())
        .build();

        var certificacoesEstudanteCriado = certificacoesEstudanteRepository.save(certificacoesEstudante);

        respostasCertificacao.stream().forEach(respostasCertificacao -> {
            respostasCertificacao.setCertificacaoId(estudanteId.getId());
            respostasCertificacao.setCertificacaoEstudante(CertificacoesEstudante)
        });

        CertificacoesEstudante.setRespostasCertificacao(respostasCertificacao);

    }return certificacoesEstudanteCriado;

}
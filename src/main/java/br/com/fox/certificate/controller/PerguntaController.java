package br.com.fox.certificate.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fox.certificate.domain.Pergunta;
import br.com.fox.certificate.dto.Alternativa.ListarAlternativaDTO;
import br.com.fox.certificate.dto.Pergunta.ListarPerguntaDTO;
import br.com.fox.certificate.repositores.PerguntaRepository;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping()
    public List<Pergunta> findByTecnologia(String tecnologia) {
        var resultado = this.perguntaRepository.findByTecnologia(tecnologia);
        var toMap = resultado.stream().map(pergunta -> mapPerguntaDTO(pergunta)).collect(Collectors.toList());
        return toMap;
    }

    static ListarPerguntaDTO mapPerguntaDTO(Pergunta perguntas) {
        var ListarPerguntaDTO = ListarPerguntaDTO.builder()
        .id(perguntas.getId()) 
        .tecnologia(perguntas.getTecnologia())       
        .descricao(perguntas.getDescricao()).build();

        List<ListarAlternativaDTO> listarAlternativaDTOs = perguntas.getAlternativa().stream()
                .map(alternativa -> mapAlternativaDTO(alternativa))
                .collect(Collectors.toList());

        ListarPerguntaDTO.setAlternativas(listarAlternativaDTOs);
        return listarPerguntaDTO;
    }

    static ListarAlternativaDTO mapAlternativaDTO(ListarAlternativaDTO listarAlternativaDTO) {
        return ListarAlternativaDTO.builder()
        .id(listarAlternativaDTO.getId())        
        .descricao(listarAlternativaDTO.getDescricao()).build();
    }
}

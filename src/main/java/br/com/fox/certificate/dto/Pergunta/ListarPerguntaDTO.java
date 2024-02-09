package br.com.fox.certificate.dto.Pergunta;

import java.util.List;

import br.com.fox.certificate.dto.Alternativa.*;
import lombok.Builder;

@Builder
public record ListarPerguntaDTO(
    
    Long id,
    String descricao,
    String tecnologia,
    List<ListarAlternativaDTO> alternativa

) {
    
}

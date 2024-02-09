package br.com.fox.certificate.dto.Respostas;

import java.util.List;

public record ListarRespostaEstudanteDTO(
    String email,
    String tecnologia,
    List<RespostaPerguntaDTO> respostaPerguntaDTO
    )
 {
    
}

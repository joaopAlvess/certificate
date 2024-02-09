package br.com.fox.certificate.dto.Respostas;

public record RespostaPerguntaDTO(
    Long perguntaId,
    Long alternativaId,
    boolean isCorrect
) {
    
}

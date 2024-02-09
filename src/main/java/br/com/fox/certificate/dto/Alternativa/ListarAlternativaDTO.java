package br.com.fox.certificate.dto.Alternativa;

import lombok.Builder;

@Builder
public record ListarAlternativaDTO(
    Long id,
    String descricao
) {
    
}

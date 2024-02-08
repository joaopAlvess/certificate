package br.com.fox.certificate.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Respostas")
public class RespostasCertificacao {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "certificacao_id")
    private CertificacoesEstudante certificacao;
    private Long estudanteId;
    private Long perguntaId;
    private Long alternativaId;
    private Long isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

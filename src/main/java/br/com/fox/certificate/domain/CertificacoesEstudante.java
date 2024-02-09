package br.com.fox.certificate.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "Certificacao")
public class CertificacoesEstudante {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    private String tecnologia;
    
    private int nota;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<RespostasCertificacao> respostasCertificacao;

    @CreationTimestamp
    private LocalDateTime createdAt;

}

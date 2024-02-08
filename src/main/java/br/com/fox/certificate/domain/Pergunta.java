package br.com.fox.certificate.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Pergunta")
public class Pergunta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String descricao;

    String tecnologia;

    @OneToMany(mappedBy = "pergunta")
    private List<Alternativa> alternativa;
}
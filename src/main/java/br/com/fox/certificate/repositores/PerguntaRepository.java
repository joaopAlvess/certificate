package br.com.fox.certificate.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fox.certificate.domain.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

    List<Pergunta> findByTecnologia(String tecnologia);
}

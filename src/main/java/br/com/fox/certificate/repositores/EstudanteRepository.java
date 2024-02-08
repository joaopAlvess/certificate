package br.com.fox.certificate.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fox.certificate.domain.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
    
}

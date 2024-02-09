package br.com.fox.certificate.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fox.certificate.domain.Estudante;
import java.util.List;
import java.util.Optional;


public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
    
    public Optional<Estudante> findByEmail(String email);
}

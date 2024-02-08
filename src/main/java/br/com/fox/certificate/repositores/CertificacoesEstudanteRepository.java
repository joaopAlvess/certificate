package br.com.fox.certificate.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fox.certificate.domain.CertificacoesEstudante;

public interface CertificacoesEstudanteRepository extends JpaRepository<CertificacoesEstudante, Long>{
    
    @Query("SELECT c FROM Certificacao c INNER JOIN c.estudante estd WHERE estd.email = :email AND c.tecnologia = :tecnologia")
    List<CertificacoesEstudante> findByEmailAndTecnologia(String email, String tecnologia);
}

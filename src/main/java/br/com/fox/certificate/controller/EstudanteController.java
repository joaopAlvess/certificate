package br.com.fox.certificate.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fox.certificate.domain.CertificacoesEstudante;
import br.com.fox.certificate.dto.Estudante.verificacaoEstudanteDTO;
import br.com.fox.certificate.dto.Respostas.ListarRespostaEstudanteDTO;
import br.com.fox.certificate.service.Estudante;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    
    @Autowired
    private Estudante estudanteService;

    public String verificarEstudante(@RequestBody verificacaoEstudanteDTO dto) {
        var resultado = this.estudanteService.verificarEstudante(dto);
        if (resultado) {
            return "usuario pode fazer a prova"

        }
        return "Usuario não pode fazer a prova"
    }

    @PostMapping("/certificacoes")
    public ResponseEntity<Object> respostaEstudante(@RequestBody ListarRespostaEstudanteDTO listarRespostaEstudanteDTO){
        try {
            var resultado = estudanteService.RespostaEstudante(listarRespostaEstudanteDTO);
            return ResponseEntity.ok().body(resultado)
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}

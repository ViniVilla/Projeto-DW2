package br.edu.ifsp.eol.osservice.web;

import br.edu.ifsp.eol.osservice.data.EnderecoRepositorio;
import br.edu.ifsp.eol.osservice.data.OrdemServicoRepositorio;
import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import java.time.LocalDate;

import br.edu.ifsp.eol.osservice.modelo.Usuario;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepositorio repoOs;

    @Autowired
    private EnderecoRepositorio repoEnd;

    @ModelAttribute
    public OrdemServico ordemServico() { return new OrdemServico(); }

    @GetMapping
    public String exibir() { return "os-form"; }

    @PostMapping
    public String criaOrdemServico(OrdemServico os, @AuthenticationPrincipal Usuario usuario) {
        log.info("method=criaOrdemServico, os={}, usuario={}", os, usuario);

        os.setDataCriacao(LocalDate.now());
        os.setUsuario(usuario);

        repoEnd.save(os.getEndereco());
        repoOs.save(os);

        return "os-criada";
    }

}

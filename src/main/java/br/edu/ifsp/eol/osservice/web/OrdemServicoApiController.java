package br.edu.ifsp.eol.osservice.web;

import br.edu.ifsp.eol.osservice.data.OrdemServicoRepositorio;
import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/ordem-servico")
public class OrdemServicoApiController {

    @Autowired
    private OrdemServicoRepositorio repo;

    @GetMapping
    public List<OrdemServico> findAllNotStarted() {
        return repo.findAllNotStarted();
    }

}

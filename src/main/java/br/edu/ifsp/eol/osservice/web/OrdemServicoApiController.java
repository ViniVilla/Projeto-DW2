package br.edu.ifsp.eol.osservice.web;

import br.edu.ifsp.eol.osservice.data.OrdemServicoRepositorio;
import br.edu.ifsp.eol.osservice.data.UsuarioRepositorio;
import br.edu.ifsp.eol.osservice.exception.ResourceNotFoundException;
import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import br.edu.ifsp.eol.osservice.modelo.request.OrdemServicoRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Log4j2
@RestController
@RequestMapping("/api/ordem-servico")
public class OrdemServicoApiController {

    @Autowired
    private OrdemServicoRepositorio ordemServicoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public List<OrdemServico> findAllNotStarted() {
        return ordemServicoRepositorio.findAllNotStarted();
    }

    @PutMapping("/atribuir")
    @ResponseStatus(NO_CONTENT)
    public void update(@RequestBody @Valid OrdemServicoRequest ordemServicoRequest) {
        log.info("method=update, id={}, instalador={}", ordemServicoRequest.getId(), ordemServicoRequest.getInstalador());
        OrdemServico ordemServico = ordemServicoRepositorio.findById(ordemServicoRequest.getId()).orElseThrow(ResourceNotFoundException::new);
        if (ordemServico.getDataAtribuicao() == null &&
                ordemServico.getInstalador() == null &&
                ordemServico.getDataFinalizacao() == null
        ) {
            ordemServico.setDataAtribuicao(LocalDate.now());
            ordemServico.setInstalador(usuarioRepositorio.findById(ordemServicoRequest.getInstalador()).orElseThrow(ResourceNotFoundException::new));
            ordemServicoRepositorio.save(ordemServico);
        }

    }

    @PutMapping
    @ResponseStatus(NO_CONTENT)
    public void close(@PathVariable Long id) {
        log.info("method=close, id={}", id);
        OrdemServico ordemServico = ordemServicoRepositorio.findById(id).orElseThrow(ResourceNotFoundException::new);

        if (ordemServico.getInstalador() != null &&
                ordemServico.getDataAtribuicao() != null &&
                ordemServico.getDataFinalizacao() == null
        ) {
            ordemServico.setDataFinalizacao(LocalDate.now());
        }
    }

}

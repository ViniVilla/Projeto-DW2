package br.edu.ifsp.eol.osservice.web;

import br.edu.ifsp.eol.osservice.data.OrdemServicoPorInstalador;
import br.edu.ifsp.eol.osservice.data.OrdemServicoRepositorio;
import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrdemServicoRepositorio repoOs;

    @GetMapping
    public String exibir() {
        return "admin-home";
    }

    @GetMapping("/ordem-servico/atrasadas")
    public String osAtrasadas(Model model) {
        LocalDate data = LocalDate.now().minusDays(5);

        List<OrdemServico> atrasadas = repoOs.findAllDelayed(data);
        model.addAttribute("osAtrasadas", atrasadas);

        return "os-atrasadas";
    }

    @GetMapping("/instalador/atrasadas")
    public String osAtrasadasInstaladores(Model model) {
        LocalDate data = LocalDate.now().minusDays(5);

        List<OrdemServicoPorInstalador> osInstalador = repoOs.findAllDelayedByInstalador(data);
        model.addAttribute("osAtrasadasInstalador", osInstalador);

        return "instalador-os-atrasadas";
    }

    @GetMapping("/instalador/finalizadas")
    public String osNoPrazoInstaladores(Model model) {
        List<OrdemServicoPorInstalador> osInstalador = repoOs.findAllFinishedInTimeByInstalador();
        model.addAttribute("osFinalizadasInstalador", osInstalador);

        return "instalador-os-finalizadas";
    }

}

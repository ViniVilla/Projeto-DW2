package br.edu.ifsp.eol.osservice.data;

import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepositorio extends JpaRepository<OrdemServico, Long> {
}

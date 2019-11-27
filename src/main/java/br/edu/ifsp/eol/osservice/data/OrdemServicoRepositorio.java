package br.edu.ifsp.eol.osservice.data;

import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdemServicoRepositorio extends JpaRepository<OrdemServico, Long> {

    @Query("SELECT o FROM OrdemServico o WHERE o.dataCriacao = null")
    List<OrdemServico> findAllNotStarted();

}

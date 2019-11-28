package br.edu.ifsp.eol.osservice.data;

import br.edu.ifsp.eol.osservice.modelo.OrdemServico;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdemServicoRepositorio extends JpaRepository<OrdemServico, Long> {

    @Query("SELECT o FROM OrdemServico o WHERE o.dataAtribuicao = null")
    List<OrdemServico> findAllNotStarted();

    @Query("SELECT o FROM OrdemServico o WHERE o.dataAtribuicao < :data AND dataFinalizacao = null")
    List<OrdemServico> findAllDelayed(@Param(value = "data") LocalDate data);

}

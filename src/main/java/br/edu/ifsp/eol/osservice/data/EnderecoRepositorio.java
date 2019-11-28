package br.edu.ifsp.eol.osservice.data;

import br.edu.ifsp.eol.osservice.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
}

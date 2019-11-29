package br.edu.ifsp.eol.osservice.data;

import br.edu.ifsp.eol.osservice.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServicoPorInstalador {

    private Usuario instalador;
    private Long quantidade;

}

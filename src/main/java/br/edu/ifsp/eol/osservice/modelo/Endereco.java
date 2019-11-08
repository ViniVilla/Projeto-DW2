package br.edu.ifsp.eol.osservice.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private OrdemServico ordemServico;

    private String cidade;
    private String bairro;
    private String rua;

    @Override
    public String toString() {
        return "{\"Endereco\":{"
                + "\"id\":\"" + id + "\""
                + ", \"ordemServico\":" + ordemServico
                + ", \"cidade\":\"" + cidade + "\""
                + ", \"bairro\":\"" + bairro + "\""
                + ", \"rua\":\"" + rua + "\""
                + "}}";
    }
}

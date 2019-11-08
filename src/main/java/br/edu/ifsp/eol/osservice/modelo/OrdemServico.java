package br.edu.ifsp.eol.osservice.modelo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Plano plano;

    @OneToOne
    @JoinColumn(name = "ordem_servico_id")
    private Endereco endereco;

    @CreatedDate
    private LocalDate DataCriacao;

    private LocalDate DataAtribuicao;

    private LocalDate DataFinalizacao;

    @Override
    public String toString() {
        return "{\"OrdemServico\":{"
                + "\"id\":\"" + id + "\""
                + ", \"plano\":\"" + plano + "\""
                + ", \"endereco\":" + endereco
                + ", \"DataCriacao\":" + DataCriacao
                + ", \"DataAtribuicao\":" + DataAtribuicao
                + ", \"DataFinalizacao\":" + DataFinalizacao
                + "}}";
    }
}

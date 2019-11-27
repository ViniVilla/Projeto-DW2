package br.edu.ifsp.eol.osservice.modelo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private Plano plano;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @CreatedDate
    private LocalDate dataCriacao;

    private LocalDate dataAtribuicao;

    private LocalDate dataFinalizacao;

    @Override
    public String toString() {
        return "{\"OrdemServico\":{"
                + "\"id\":\"" + id + "\""
                + ", \"plano\":\"" + plano + "\""
                + ", \"endereco\":" + endereco
                + ", \"DataCriacao\":" + dataCriacao
                + ", \"DataAtribuicao\":" + dataAtribuicao
                + ", \"DataFinalizacao\":" + dataFinalizacao
                + "}}";
    }
}

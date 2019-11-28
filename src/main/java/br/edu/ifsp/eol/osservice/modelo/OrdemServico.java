package br.edu.ifsp.eol.osservice.modelo;

import java.time.LocalDate;
import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

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

package br.edu.ifsp.eol.osservice.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "papeis")
@Data
@NoArgsConstructor
public class Papel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String papel;

    public Papel(String papel){
        this.papel = papel;
    }

    @Override
    public String getAuthority() {
        return papel;
    }
}

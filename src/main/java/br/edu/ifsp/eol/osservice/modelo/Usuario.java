package br.edu.ifsp.eol.osservice.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private List<Papel> papeis = new ArrayList<>();

    public void addPapel(Papel papel){
        this.papeis.add(papel);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return papeis;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }


    @Override
    public String toString() {
        return "{\"Usuario\":{"
                + "\"id\":\"" + id + "\""
                + ", \"username\":\"" + username + "\""
                + ", \"password\":\"" + password + "\""
                + ", \"nome\":\"" + nome + "\""
                + ", \"email\":\"" + email + "\""
                + ", \"papeis\":" + papeis
                + "}}";
    }
}

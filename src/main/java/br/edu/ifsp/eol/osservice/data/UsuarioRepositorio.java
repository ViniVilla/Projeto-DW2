package br.edu.ifsp.eol.osservice.data;

import br.edu.ifsp.eol.osservice.modelo.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query("SELECT u FROM Usuario u JOIN u.papeis p WHERE p.papel = :role")
    List<Usuario> findAllByRole(String role);

}

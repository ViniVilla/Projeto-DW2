package br.edu.ifsp.eol.osservice.web;

import br.edu.ifsp.eol.osservice.data.UsuarioRepositorio;
import br.edu.ifsp.eol.osservice.modelo.Papel;
import br.edu.ifsp.eol.osservice.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registro() {
        return "usuario-form";
    }

    @PostMapping
    public String processarRegistro(Usuario usuario) {
        usuario.addPapel(new Papel("ROLE_USER"));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        repo.save(usuario);
        return "redirect:/login";
    }
}

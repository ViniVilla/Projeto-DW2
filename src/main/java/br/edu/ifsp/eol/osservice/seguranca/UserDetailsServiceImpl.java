package br.edu.ifsp.eol.osservice.seguranca;

import br.edu.ifsp.eol.osservice.data.UsuarioRepositorio;
import br.edu.ifsp.eol.osservice.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByUsername(username);
		
		if (usuario == null)
			throw new UsernameNotFoundException("Username " + username + " não encontrado.");

		if (usuario.getAuthorities().size() == 0)
			throw new UsernameNotFoundException("Username " + username + ": sem papéis (roles) cadastrados.");
		
		return usuario;
	}

}

package com.example.basicsecurity.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.basicsecurity.repository.PermissaoRepository;
import com.example.basicsecurity.repository.UsuarioRepository;
import com.example.basicsecurity.security.Permissao;
import com.example.basicsecurity.security.Usuario;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepository.deleteAll();
		permissaoRepository.deleteAll();		
		
		Permissao role_administrador = new Permissao(null, "ROLE_ADMINISTRADOR");		
		Permissao role_usuario = new Permissao(null, "ROLE_USUARIO");	
		
		Usuario administrador = new Usuario(null, "Administrador", "admin", passwordEncoder().encode("admin"));	
		administrador.getPermissoes().add(role_administrador);
		
		Usuario usuario = new Usuario(null, "Usuario", "user", passwordEncoder().encode("user"));
		usuario.getPermissoes().add(role_usuario);
		
		permissaoRepository.saveAll(Arrays.asList(role_administrador, role_usuario));
		usuarioRepository.saveAll(Arrays.asList(administrador, usuario));
		
	}
	
	public PasswordEncoder passwordEncoder() {		
		return new BCryptPasswordEncoder();
	}

}

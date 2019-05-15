package com.example.basicsecurity.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioSpringSecurity extends User {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UsuarioSpringSecurity(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getConta(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}

package com.example.basicsecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.basicsecurity.security.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	public Optional<Usuario> findByConta(String conta);
	
}

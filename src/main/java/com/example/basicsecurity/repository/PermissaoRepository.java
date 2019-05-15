package com.example.basicsecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.basicsecurity.security.Permissao;

@Repository
public interface PermissaoRepository extends MongoRepository<Permissao, String> {

	public Optional<Permissao> findByDescricao(String descricao);
	
}

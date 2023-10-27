package com.midominio.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.midominio.biblioteca.entity.Usuario;

@Service
public interface IUsuarioService {

	
	List<Usuario> findAll();
	void save (Usuario usuario);
	Usuario findOne (Long id);
	void delete (Long id);
}

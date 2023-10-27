package com.midominio.biblioteca.dao;

import java.util.List;

import com.midominio.biblioteca.entity.Usuario;

public interface IUsuarioDao {

	List<Usuario> findAll();
	void save (Usuario usuario);
	Usuario findOne (Long id);
	void delete (Long id);
}

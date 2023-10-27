package com.midominio.biblioteca.dao;

import java.util.List;

import com.midominio.biblioteca.entity.Libro;

public interface ILibroDao {
	List<Libro> findAll();
	void save(Libro libro);
	Libro findOne (Long id);
	void delete(Long id);
	Libro findById (Long id);  //filtrado
	Libro findByAutor (String autor);
	List<Libro> findByAutor();
}

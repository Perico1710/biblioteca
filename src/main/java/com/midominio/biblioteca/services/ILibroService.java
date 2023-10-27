package com.midominio.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.midominio.biblioteca.entity.Libro;

@Service
public interface ILibroService {

	List<Libro> findAll();
	void save (Libro libro);
	Libro findOne(Long id);
	void delete (Long id);
	Libro findById (Long id); //filtrado


}

package com.midominio.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca.dao.ILibroDao;
import com.midominio.biblioteca.entity.Libro;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	ILibroDao libroDao;

	@Override
	@Transactional (readOnly = true)
	public List<Libro> findAll(){
		return libroDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Libro libro) {
		libroDao.save(libro);
	}
	
	@Override
	@Transactional (readOnly = true)
	public Libro findOne(Long id) {
		return libroDao.findOne(id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		libroDao.delete(id);
	}
	

	
	
	
	//filtrado
	@Override
	@Transactional (readOnly = true)
	public Libro findById (Long id) {
		return libroDao.findById(id);
	}
}

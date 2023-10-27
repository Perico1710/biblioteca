package com.midominio.biblioteca.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.midominio.biblioteca.entity.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


//Acedemos a los datos
@Repository
public class LibroDaoImpl implements ILibroDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Libro> findAll(){
		return em.createQuery("From Libro", Libro.class).getResultList();
	}
	
	
	@Override
	public void save (Libro libro) {
		if (libro.getId()!= null && libro.getId() > 0)
			em.merge(libro);
		else
		em.persist(libro);
	}
	
	@Override
	public Libro findOne(Long id) {
		return em.find(Libro.class, id);
	}
		
	@Override
	public void delete (Long id) {
		em.remove(findOne(id));
	}
	
	//filtrado
	@Override
	public Libro findById (Long id) {
		return em.find(Libro.class, id);
	}
	
	@Override
	public Libro findByAutor (String autor) {
		return em.find(Libro.class, autor);
	}
	
	@Override
	public List<Libro> findByAutor(){
		return em.createQuery("From Libro", Libro.class).getResultList();
	}
}

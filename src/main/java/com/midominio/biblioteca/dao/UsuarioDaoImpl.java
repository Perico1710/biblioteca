package com.midominio.biblioteca.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.midominio.biblioteca.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuario> findAll(){
		return em.createQuery("From Usuario", Usuario.class).getResultList();
	}
	
	@Override
	public void save (Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() > 0)
			em.merge(usuario);
		else
			em.persist(usuario);
	}
	
	@Override
	public Usuario findOne(Long id) {
		return em.find(Usuario.class, id);
	}
	
	
	@Override
	public void delete (Long id) {
		em.remove(findOne(id));
	}
	
	
}

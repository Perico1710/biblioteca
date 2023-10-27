package com.midominio.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca.dao.IUsuarioDao;
import com.midominio.biblioteca.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	IUsuarioDao usuarioDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Usuario> findAll(){
		return usuarioDao.findAll();
	}
	
	@Override
	@Transactional
	public void save (Usuario usuario) {
		usuarioDao.save (usuario);
	}
	
	@Override
	@Transactional (readOnly = true)
	public Usuario findOne (Long id) {
		return usuarioDao.findOne (id);
	}
	
	@Override
	@Transactional
	public void delete (Long id) {
		usuarioDao.delete(id);
	}
	
	
}

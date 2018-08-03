package com.vector.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.model.Usuario;
import com.vector.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	public List<Usuario> findAll() {
		return (List<Usuario>)usuarioRepository.findAll();
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void actualizar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}


	public void borrar(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario findByName(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	
	public Optional<Usuario> findByOne(Long id) {
		return usuarioRepository.findById(id);
	}

	public List<String> nombres() {
		return usuarioRepository.nombres();
	}
	
	
	
}

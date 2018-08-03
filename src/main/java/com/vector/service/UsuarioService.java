package com.vector.service;

import java.util.List;
import java.util.Optional;


import com.vector.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();
	
	void save(Usuario usuario);
	
	void actualizar(Usuario usuario);
	
	void borrar(Long id);
	
	Optional<Usuario> findByOne(Long id);
	
	Usuario findByName(String nombre);
	
	List<String> nombres();
}

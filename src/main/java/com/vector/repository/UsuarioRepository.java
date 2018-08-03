package com.vector.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vector.model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findByNombre(String nombre);
	
	Usuario findById(long id);
	
	@Query(value = "select u.id from Usuario u where u.id = 5", nativeQuery=true)
	List<String> nombres();
}

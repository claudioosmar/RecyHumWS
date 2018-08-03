package com.vector.service;


import java.util.List;
import java.util.Optional;

import com.vector.model.DatosLogin;


public interface LoginService {
	
	
	List<DatosLogin> findAll();
	
	void save(DatosLogin datos);
	
	void actualizar(DatosLogin datos);
	
	void borrar(Long id);
	
	Optional<DatosLogin> findByOne(Long id);
	
	DatosLogin findByName(String nombre);

	
	

}

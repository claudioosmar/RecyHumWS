package com.vector.service;

import java.util.List;
import java.util.Optional;

import com.vector.model.BeanDatosPersonales;


public interface DatosPersonalesService {

	List<BeanDatosPersonales> findAll();
	
	void save(BeanDatosPersonales datos);
	
	void actualizar(BeanDatosPersonales datos);
	
	void borrar(Long id);
	
	Optional<BeanDatosPersonales> findByOne(Long id);
	
	BeanDatosPersonales findByName(String nombre);

}

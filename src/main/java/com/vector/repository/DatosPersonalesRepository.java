package com.vector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vector.model.BeanDatosPersonales;

public interface DatosPersonalesRepository extends CrudRepository<BeanDatosPersonales, Long > {

	BeanDatosPersonales findbynombre(String nombre);
@Query(value = "select u.nombre from tbluser u where u.id = 5", nativeQuery=true)
	
	List<String> Usuarios(); 
	
}

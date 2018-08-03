package com.vector.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vector.model.DatosLogin;



public interface LoginRepository extends CrudRepository<DatosLogin,Long> {
	
	//beanlogin VerificarLogin(beanlogin datos);
	
	DatosLogin findByNombre(String nombre);
	
	//DatosLogin findById(long iduser);
	
	@Query(value = "select u.nombre from tbluser u where u.id = 5", nativeQuery=true)
	
	List<String> Usuarios();

}

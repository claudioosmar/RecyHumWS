package com.vector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.model.DatosLogin;
import com.vector.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginrepository;

	
	public List<String> Usuarios() {
		return loginrepository.Usuarios();
	}
	
	public List<DatosLogin> findAll() {
		return (List<DatosLogin>)loginrepository.findAll();
	}
	
	public void save(DatosLogin datos) {
		loginrepository.save(datos);
		
	}
	
	public void actualizar(DatosLogin datos) {
		loginrepository.save(datos);
		
	}
	
	public void borrar(Long id) {
		loginrepository.deleteById(id);
		
	}
	
	public Optional<DatosLogin> findByOne(Long id) {
		return loginrepository.findById(id);
	}
	
	public DatosLogin findByName(String nombre) {
		return loginrepository.findByNombre(nombre);
	}

}

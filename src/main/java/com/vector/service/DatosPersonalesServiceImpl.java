package com.vector.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vector.model.BeanDatosPersonales;
import com.vector.repository.DatosPersonalesRepository;

public class DatosPersonalesServiceImpl implements DatosPersonalesService {
	@Autowired
	private DatosPersonalesRepository datosPersonalesRepository;

	@Override
	public List<BeanDatosPersonales> findAll() {
		return (List<BeanDatosPersonales>)datosPersonalesRepository.findAll();
	}

	@Override
	public void save(BeanDatosPersonales datos) {
		datosPersonalesRepository.save(datos);
		
	}

	@Override
	public void actualizar(BeanDatosPersonales datos) {
		datosPersonalesRepository.save(datos);
		
	}

	@Override
	public void borrar(Long id) {
		datosPersonalesRepository.deleteById(id);
		
	}

	@Override
	public Optional<BeanDatosPersonales> findByOne(Long id) {
		// TODO Auto-generated method stub
		return datosPersonalesRepository.findById(id);
	}

	@Override
	public BeanDatosPersonales findByName(String nombre) {
		// TODO Auto-generated method stub
		return datosPersonalesRepository.findbynombre(nombre);
	}

}

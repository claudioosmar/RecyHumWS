/**
 * 
 */
package com.vector.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vector.model.BeanDatosPersonales;
import com.vector.model.Modelo;
import com.vector.service.ModelABCLD;

/**
 * @author Claudio
 *
 */
@Repository
public class DatosPersonalesRepository implements ModelABCLD<BeanDatosPersonales> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Create(com.vector.model.Modelo)
	 */
	@Override
	@Transactional(readOnly = true)
	public Modelo Create(BeanDatosPersonales datos) {
		// TODO Auto-generated method stub		
		BeanDatosPersonales bean = new BeanDatosPersonales();
		
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Delete(int)
	 */
	@Transactional(readOnly = true)
	public Modelo Delete(int id) {
		// TODO Auto-generated method stub
		BeanDatosPersonales bean = new BeanDatosPersonales();
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Buscar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public Modelo Buscar(BeanDatosPersonales datos) {
		// TODO Auto-generated method stub
		BeanDatosPersonales bean = new BeanDatosPersonales();
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Listar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public List<Modelo> Listar(BeanDatosPersonales  datos) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

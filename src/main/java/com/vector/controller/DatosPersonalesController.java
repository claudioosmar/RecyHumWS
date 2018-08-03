package com.vector.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.model.BeanDatosPersonales;
import com.vector.service.DatosPersonalesService;

@RestController
public class DatosPersonalesController {
	@Autowired
	private DatosPersonalesService datosPersonalesService;
	
	
	@RequestMapping(value = "/listarpersonas", method = RequestMethod.POST)
	public ResponseEntity<List<BeanDatosPersonales>> consultaLogin() {
		List<BeanDatosPersonales> dto = datosPersonalesService.findAll();
		if (dto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<BeanDatosPersonales>>(dto, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/insertarpersona", method = RequestMethod.POST)
	public ResponseEntity<BeanDatosPersonales> insertar(@RequestBody BeanDatosPersonales body){
		datosPersonalesService.save(body);
		return new ResponseEntity<BeanDatosPersonales>(HttpStatus.CREATED);
	}
	
	
@RequestMapping(value = "/actualizarpersona", method= RequestMethod.POST)
public ResponseEntity<BeanDatosPersonales> actualizaruser(@RequestBody BeanDatosPersonales body){
 datosPersonalesService.actualizar(body);
	return new ResponseEntity<BeanDatosPersonales>(HttpStatus.CREATED);
}


	@RequestMapping (value ="/borrarpersona/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> borrar(@PathVariable ("id") long id){
		Optional<BeanDatosPersonales>resultado= datosPersonalesService.findByOne(id);
		BeanDatosPersonales datos = new BeanDatosPersonales();
		if(resultado.isPresent()) {
			datos = resultado.get();
		}if(datos == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			datosPersonalesService.borrar(id);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping (value ="/buscarpersonaid/{id}", method = RequestMethod.POST)
	public ResponseEntity<BeanDatosPersonales> buscarid(@PathVariable ("id") long id){
		Optional<BeanDatosPersonales>resultado= datosPersonalesService.findByOne(id);
		BeanDatosPersonales datos = new BeanDatosPersonales();
		if(resultado.isPresent()) {
			datos = resultado.get();
		}if(datos == null) {
			return new ResponseEntity<BeanDatosPersonales>(HttpStatus.NOT_FOUND);
		}
		else {
		}
		return new ResponseEntity<BeanDatosPersonales>(datos,HttpStatus.OK);
	}
	

	@RequestMapping (value ="/buscarpersonaname/{nombre}", method = RequestMethod.POST)
	public ResponseEntity<BeanDatosPersonales> buscarname(@PathVariable("nombre") String nombre){
		BeanDatosPersonales datos= datosPersonalesService.findByName(nombre);
		if(datos == null) {
			return new ResponseEntity<BeanDatosPersonales>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<BeanDatosPersonales>(datos,new HttpHeaders(),HttpStatus.OK);	
		}
		
	}

}

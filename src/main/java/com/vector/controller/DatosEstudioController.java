/**
 * 
 */
package com.vector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosEstudio;
import com.vector.Beans.DatosEstudioBean;

/**
 * @author Claudio
 *
 */
@RestController
public class DatosEstudioController {
	
	
	@Autowired
	private BODatosEstudio estudio;
	
	@RequestMapping(value = "{proyecto}/{modulo.2}/Crear", method = RequestMethod.POST)
	public ResponseEntity<String> insertar(@RequestBody DatosEstudioBean datos){
		return new ResponseEntity<String>(estudio.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.2}/Modificar",method = RequestMethod.POST)
	public ResponseEntity<String>actualizar(@RequestBody DatosEstudioBean datos){
		return new ResponseEntity<String>(estudio.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.2}/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<String> eliminar(@RequestBody int id){
		return new ResponseEntity<String>(estudio.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.2}/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosEstudioBean>buscar(@RequestBody DatosEstudioBean datos){
		return new ResponseEntity<DatosEstudioBean>(estudio.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.2}/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosEstudioBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List<DatosEstudioBean> estudios = estudio.Listar();
		if(estudios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosEstudioBean>>(estudios, HttpStatus.OK);
		}
	}
}

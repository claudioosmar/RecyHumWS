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

import com.vector.BO.BOIdiomas;
import com.vector.Beans.DatosIdiomasBean;

/**
 * @author vectormx
 *
 */
@RestController
public class DatosIdiomasController {

	@Autowired
	private BOIdiomas idioma;
	
	@RequestMapping(value = "SGRHWebService/{modulo.5}/Crear", method = RequestMethod.POST)
	public ResponseEntity<String> insertar(@RequestBody DatosIdiomasBean datos){
		return new ResponseEntity<String>(idioma.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.5}/Modificar",method = RequestMethod.POST)
	public ResponseEntity<String>actualizar(@RequestBody DatosIdiomasBean datos){
		return new ResponseEntity<String>(idioma.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.5}/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<String> eliminar(@RequestBody int id){
		return new ResponseEntity<String>(idioma.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.5}/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosIdiomasBean>buscar(@RequestBody DatosIdiomasBean datos){
		return new ResponseEntity<DatosIdiomasBean>(idioma.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(value = "{proyecto}/{modulo.5}/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosIdiomasBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List<DatosIdiomasBean> idiomas = idioma.Listar();
		if(idiomas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosIdiomasBean>>(idiomas, HttpStatus.OK);
		}
	}
}

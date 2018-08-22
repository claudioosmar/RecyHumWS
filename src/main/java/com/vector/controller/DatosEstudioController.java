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
import com.vector.Beans.MsgBean;

/**
 * @author Claudio
 *
 */

@RestController
public class DatosEstudioController {
	
	
	@Autowired
	private BODatosEstudio estudio;
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosEstudioBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(estudio.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosEstudioBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(estudio.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(estudio.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosEstudioBean>buscar(@RequestBody DatosEstudioBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity<DatosEstudioBean>(estudio.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Listar",method=RequestMethod.POST)
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

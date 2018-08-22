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

import com.vector.BO.BODatosLaborales;
import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.MsgBean;

/**
 * @author Claudio
 *
 */
@RestController
public class DatosLaboralesController {
	@Autowired
	private BODatosLaborales laborales;
	
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosLaboralesBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(laborales.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosLaboralesBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(laborales.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(laborales.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosLaboralesBean>buscar(@RequestBody DatosLaboralesBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity<DatosLaboralesBean>(laborales.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosLaboralesBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List<DatosLaboralesBean> laboral = laborales.Listar();
		if(laboral.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosLaboralesBean>>(laboral, HttpStatus.OK);
		}
	}
}

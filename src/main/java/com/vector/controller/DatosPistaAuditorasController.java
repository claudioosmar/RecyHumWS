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

import com.vector.BO.BODatosPistaAuditora;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@RestController
public class DatosPistaAuditorasController {
	@Autowired
	private BODatosPistaAuditora pistas;
	
	@RequestMapping(path = "/SGRHWebService/DatosPista/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosPistaAuditoraBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(pistas.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosPista/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(pistas.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosPista/Buscar",method=RequestMethod.POST)
	public ResponseEntity< DatosPistaAuditoraBean>buscar(@RequestBody  DatosPistaAuditoraBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity< DatosPistaAuditoraBean>(pistas.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosPista/Listar",method=RequestMethod.POST)
	public ResponseEntity<List< DatosPistaAuditoraBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List< DatosPistaAuditoraBean> pista = pistas.Listar();
		if(pista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List< DatosPistaAuditoraBean>>(pista, HttpStatus.OK);
		}
	}
}

package com.vector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

@RestController
public class DatosPersonalesController {
	@Autowired
	private BODatosPersonales bodatos;
		
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosPersonalesBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(bodatos.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosPersonalesBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(bodatos.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(bodatos.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosPersonalesBean>buscar(@RequestBody DatosPersonalesBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity<DatosPersonalesBean>(bodatos.Buscar(datos),HttpStatus.OK);
	}
	@RequestMapping("/SGRHWebService/DatosPersonales/listar")
	public ResponseEntity<List<DatosPersonalesBean>> Listar(){
		List<DatosPersonalesBean> resp = bodatos.Listar();
		if(resp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosPersonalesBean>>(resp, HttpStatus.OK);
		}
	}

}

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
	//Ruta utilizada para la llamada de la funcion crear datos personales	
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Crear", method = RequestMethod.POST)
	public ResponseEntity<DatosPersonalesBean> insertar(@RequestBody DatosPersonalesBean datos){
		//Linea de impresion en consola que muestra datos de los datos personales al ser creados
		System.out.print("Se creo un Datos personales "+ datos.getPrimerNombre()+" id localidad "+datos.getIdlocalidad()+"\n");
		return new ResponseEntity<DatosPersonalesBean>(bodatos.Crear(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion Modificar datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosPersonalesBean datos){
		//Linea de impresion en consola que muestra datos de los datos personales al ser modificados
		System.out.print("Se modifico datos personales ");
		return new ResponseEntity<MsgBean>(bodatos.Modificar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion eliminar datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosPersonalesBean datos){
		//Linea de impresion en consola que muestra datos de los datos personales al ser eliminados
		System.out.print("se elimino datos personales");
		return new ResponseEntity<MsgBean>(bodatos.Eliminar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion buscar datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosPersonalesBean>buscar(@RequestBody DatosPersonalesBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		System.out.print("se busco los datos personales "+datos.getIdpersona()+"\n");
		return new ResponseEntity<DatosPersonalesBean>(bodatos.Buscar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion listar idiomas
	@RequestMapping("/SGRHWebService/DatosPersonales/Listar")
	public ResponseEntity<List<DatosPersonalesBean>> Listar(){
		List<DatosPersonalesBean> resp = bodatos.Listar();
		if(resp.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosPersonalesBean>>(resp, HttpStatus.OK);
		}
	}


}

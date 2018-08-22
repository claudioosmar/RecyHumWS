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

import com.vector.BO.BODatosHerramientas;
import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@RestController
@RequestMapping("{proyecto}/{modulo}")
public class DatosHerramientasController {
	@Autowired
	private BODatosHerramientas herramientas;
	
	@RequestMapping(path = "/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosHerramientasBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(herramientas.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosHerramientasBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(herramientas.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(herramientas.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosHerramientasBean>buscar(@RequestBody DatosHerramientasBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity<DatosHerramientasBean>(herramientas.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List<DatosHerramientasBean> herramienta = herramientas.Listar();
		if(herramienta.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosHerramientasBean>>(herramienta, HttpStatus.OK);
		}
	}
}

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

import com.vector.BO.BODatosCorreoAlt;
import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@RestController
@RequestMapping("/{proyecto}/{modulo.2}")
public class DatosCorreoAltController {
	@Autowired
	private BODatosCorreoAlt correo;
	
	@RequestMapping(path = "/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosCorreoAltBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(correo.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosCorreoAltBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(correo.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(correo.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosCorreoAltBean>buscar(@RequestBody DatosCorreoAltBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity<DatosCorreoAltBean>(correo.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCorreoAltBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List<DatosCorreoAltBean> correos = correo.Listar();
		if(correos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosCorreoAltBean>>(correos, HttpStatus.OK);
		}
	}
}

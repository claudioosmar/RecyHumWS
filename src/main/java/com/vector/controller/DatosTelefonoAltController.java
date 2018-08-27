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

import com.vector.BO.BODatosTelefonoAlt;
import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@RestController
public class DatosTelefonoAltController {
	@Autowired
	private BODatosTelefonoAlt telefono;
	
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosTelefonoAltBean> datos){
		System.out.print("Se agrego el telefono "+datos.get(0).getTelefonoNw()+" al ID de persona "+datos.get(0).getIdpersona() );
		return new ResponseEntity<MsgBean>(telefono.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosTelefonoAltBean datos){
		System.out.print("Se modifico el telefono "+datos.getTelefonoNw()+" al ID de persona "+datos.getIdpersona() );
		return new ResponseEntity<MsgBean>(telefono.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosTelefonoAltBean datos){
		System.out.print("Se elimino el telefono "+datos.getTelefonoNw());
		return new ResponseEntity<MsgBean>(telefono.Eliminar(datos.getTelefonoNw()),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosTelefonoAltBean>buscar(@RequestBody DatosTelefonoAltBean datos){
		System.out.print("Se Listo el telefono "+datos.getTelefonoNw()+" al ID de persona "+datos.getIdpersona());
		return new ResponseEntity<DatosTelefonoAltBean>(telefono.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosTelefono/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosTelefonoAltBean>> consulta(@RequestBody DatosTelefonoAltBean datos){
		System.out.println("Ingresando a listar telefonos ");
		List<DatosTelefonoAltBean> telefonos = telefono.Listar(datos.getIdpersona());
		if(telefonos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosTelefonoAltBean>>(telefonos, HttpStatus.OK);
		}
	}
}

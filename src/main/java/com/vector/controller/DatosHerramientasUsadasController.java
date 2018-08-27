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

import com.vector.BO.BODatosHerramientasUsadas;
import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@RestController
public class DatosHerramientasUsadasController {
	@Autowired
	private BODatosHerramientasUsadas herramientasus;
	
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosHerramientasUsadasBean> datos){
		System.out.print("Se agrego herramienta usadas "+datos.get(0).getIdherramienta()+"\n ");
		return new ResponseEntity<MsgBean>(herramientasus.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosHerramientasUsadasBean datos){
		System.out.print("Se actualizo herramienta usadas "+datos.getNombreherramienta()+"con id "+datos.getIdherramienta()+"\n ");
		return new ResponseEntity<MsgBean>(herramientasus.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosHerramientasUsadasBean datos){
		System.out.print("Se elimino herramienta usada con id "+datos.getIdherramienta()+"y persona id "+datos.getIdexplaboral()+"\n ");
		return new ResponseEntity<MsgBean>(herramientasus.Eliminar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasUsadasBean>>buscar(@RequestBody DatosHerramientasUsadasBean datos){
		System.out.print("Se buscaron las herramientas usadas en el trabajo "+datos.getIdherramienta()+" y experiencia con id "+datos.getIdexplaboral()+"\n ");
		return new ResponseEntity<List<DatosHerramientasUsadasBean>>(herramientasus.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosHerramientasUsadas/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosHerramientasUsadasBean>> consulta(@RequestBody DatosHerramientasUsadasBean datos){
		System.out.print("Se listaton herramientas usadas"+"\n ");
		List<DatosHerramientasUsadasBean> herramientaus = herramientasus.Listar();
		if(herramientaus.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosHerramientasUsadasBean>>(herramientaus, HttpStatus.OK);
		}
	}
}

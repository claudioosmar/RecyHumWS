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
	public ResponseEntity<DatosEstudioBean> insertar(@RequestBody List<DatosEstudioBean> datos){
		System.out.println("datos  de estudio a ingresar desde controller: id grado:"+datos.get(0).getIdgrado()+" id localidad:"+datos.get(0).getIdlocalidad()+" periodo inicial:"+datos.get(0).getPeriodoinicial()+" periodo final:"+datos.get(0).getPeriodofinal()+" "+ "nombre carrera:"+datos.get(0).getNombrecorrera());
		return new ResponseEntity<DatosEstudioBean>(estudio.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosEstudioBean datos){
		System.out.print("Se modifico el estudio "+datos.getIdestudio()+"\n ");
		return new ResponseEntity<MsgBean>(estudio.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosEstudioBean datos){
		System.out.print("se elimino el estudio con id carrera "+datos.getIdcarrera()+"e id educacion "+datos.getIdestudio()+"\n ");
		return new ResponseEntity<MsgBean>(estudio.Eliminar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosEstudioBean>>buscar(@RequestBody DatosEstudioBean datos){
		System.out.print("se busco los estudios de la persona "+datos.getIdpersona()+"\n ");
		return new ResponseEntity<List<DatosEstudioBean>>(estudio.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosEstudio/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosEstudioBean>> consulta(@RequestBody DatosEstudioBean datos ){
		System.out.println("Ingresando a estudios"+"\n");
		List<DatosEstudioBean> estudios = estudio.Listar();
		if(estudios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosEstudioBean>>(estudios, HttpStatus.OK);
		}
	}
}

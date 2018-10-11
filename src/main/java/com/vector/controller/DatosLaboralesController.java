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
import com.vector.Utileria.Log;

/**
 * @author Claudio
 *
 */
@RestController
public class DatosLaboralesController  extends Log{
	@Autowired
	private BODatosLaborales laborales;
	//Ruta utilizada para la llamada de la funcion crear datos laborales
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Crear", method = RequestMethod.POST)
	public ResponseEntity<DatosLaboralesBean> insertar(@RequestBody List<DatosLaboralesBean> datos){
		//Linea de impresion en consola que muestra datos de los datos laboralesal ser creados
		info("Se creo un registro laboral"+datos.get(0).getIdexplaborl());
		return new ResponseEntity<DatosLaboralesBean>(laborales.Crear(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion Modificar datos laborales
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosLaboralesBean datos){
		//Linea de impresion en consola que muestra datos de los datos laborales al ser modificados
		info("Se modifico un regristro laboral"+datos.toString());
		return new ResponseEntity<MsgBean>(laborales.Modificar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion eliminar datos laborales
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosLaboralesBean datos){
		//Linea de impresion en consola que muestra datos de los datos laborales al ser eliminados
		info("se elimino un registro laboral de "+datos.getIdexplaborl());
		return new ResponseEntity<MsgBean>(laborales.Eliminar(datos.getIdexplaborl()),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion buscar datos laborales
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosLaboralesBean>>buscar(@RequestBody DatosLaboralesBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		info("se busco un registro laboral");
		return new ResponseEntity<List<DatosLaboralesBean>>(laborales.Buscar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion listar datos laborales
	@RequestMapping(path = "/SGRHWebService/DatosLaborales/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosLaboralesBean>> consulta(){
		//mensaje de impresion de la accion realisada
		info("Ingresando a listar de datos laborales ");
		List<DatosLaboralesBean> laboral = laborales.Listar();
		if(laboral.isEmpty()) {
			info("no se encontraron datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron las experiencias laborales");
			return new ResponseEntity<List<DatosLaboralesBean>>(laboral, HttpStatus.OK);
		}
	}
}

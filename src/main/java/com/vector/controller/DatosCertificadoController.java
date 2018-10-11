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
import com.vector.BO.BODatosCertificado;
import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;

/**
 * @author vectormx
 *
 */
@RestController
public class DatosCertificadoController extends Log {
	@Autowired
	private BODatosCertificado certificado;
	//Ruta utilizada para la llamada de la funcion crear certificado
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosCertificadoBean> datos){
		//Linea de impresion en consola que muestra datos de los certificados al ser creados
		info("Se creo un certificado: "+datos.toString());
		return new ResponseEntity<MsgBean>(certificado.Crear(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion Modificar certificados
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody  DatosCertificadoBean datos){
		//Linea de impresion en consola que muestra datos de los certificados al ser modificados
		info("Se modifico el certificado con id: "+ datos.getIdcertificado());
		return new ResponseEntity<MsgBean>(certificado.Modificar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion eliminar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosCertificadoBean datos){
		//Linea de impresion en consola que muestra datos de los certificados al ser eliminados
		info("se elimino el certificado: "+ datos.getIdcertificado());
		return new ResponseEntity<MsgBean>(certificado.Eliminar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion buscar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCertificadoBean>> buscar(@RequestBody  DatosCertificadoBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		info("se busco el certificado "+ datos.toString());
		return new ResponseEntity<List<DatosCertificadoBean>>(certificado.Buscar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion listar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Listar",method=RequestMethod.POST)
	public ResponseEntity<List< DatosCertificadoBean>> consulta(@RequestBody DatosCertificadoBean datos){
		//mensaje de impresion de la accion realisada
		info("Ingresando a listar certificado ");
		List< DatosCertificadoBean> certificados = certificado.Listar();
		if(certificados.isEmpty()) {
			info("No se encontro contenido");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los certificados");
			return new ResponseEntity<List< DatosCertificadoBean>>(certificados, HttpStatus.OK);
		}
	}

}

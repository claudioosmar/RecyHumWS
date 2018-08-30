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

/**
 * @author vectormx
 *
 */
@RestController
public class DatosCertificadoController {
	@Autowired
	private BODatosCertificado certificado;
	//Ruta utilizada para la llamada de la funcion crear certificado
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosCertificadoBean> datos){
		//Linea de impresion en consola que muestra datos de los certificados al ser creados
		System.out.print("Se creo un certificado "+datos.get(0).getNomcertificadoNw()+ " al ID de documento " +" "+datos.get(0).getIddocumentoNw()+"id estudio "+datos.get(0).getIdestudio()+" ");
		return new ResponseEntity<MsgBean>(certificado.Crear(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion Modificar certificados
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody  DatosCertificadoBean datos){
		//Linea de impresion en consola que muestra datos de los certificados al ser modificados
		System.out.print("Se modifico el certificado"+ datos.getNomcertificadoNw() + " con ID de documento " +datos.getIddocumentoNw());
		return new ResponseEntity<MsgBean>(certificado.Modificar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion eliminar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosCertificadoBean datos){
		//Linea de impresion en consola que muestra datos de los certificados al ser eliminados
		System.out.print("se elimino el certificado"+ datos.getNomcertificadoNw());
		return new ResponseEntity<MsgBean>(certificado.Eliminar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion buscar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCertificadoBean>> buscar(@RequestBody  DatosCertificadoBean datos){
		//mensaje de impresion en la consola que muestra los datos que relacionan la consulta
		System.out.print("se busco el certificado "+ datos.getNomcertificadoNw()+ "con el ID " + datos.getIdcertificado());
		return new ResponseEntity<List<DatosCertificadoBean>>(certificado.Buscar(datos),HttpStatus.OK);
	}
	//Ruta utilizada para la llamada de la funcion listar idiomas
	@RequestMapping(path = "/SGRHWebService/DatosCertificado/Listar",method=RequestMethod.POST)
	public ResponseEntity<List< DatosCertificadoBean>> consulta(@RequestBody DatosCertificadoBean datos){
		//mensaje de impresion de la accion realisada
		System.out.println("Ingresando a listar certificado ");
		List< DatosCertificadoBean> certificados = certificado.Listar();
		if(certificados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List< DatosCertificadoBean>>(certificados, HttpStatus.OK);
		}
	}

}

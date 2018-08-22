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
@RequestMapping("/{proyecto}/{modulo.2}")
public class DatosCertificadoController {
	@Autowired
	private BODatosCertificado certificado;
	
	@RequestMapping(path = "/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosCertificadoBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(certificado.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody  DatosCertificadoBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(certificado.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(certificado.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Buscar",method=RequestMethod.POST)
	public ResponseEntity< DatosCertificadoBean>buscar(@RequestBody  DatosCertificadoBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity< DatosCertificadoBean>(certificado.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Listar",method=RequestMethod.POST)
	public ResponseEntity<List< DatosCertificadoBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List< DatosCertificadoBean> certificados = certificado.Listar();
		if(certificados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List< DatosCertificadoBean>>(certificados, HttpStatus.OK);
		}
	}

}

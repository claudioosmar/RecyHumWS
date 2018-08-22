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

import com.vector.BO.BODatosDocumentos;
import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
@RestController
@RequestMapping("{proyecto}/{modulo}")
public class DatosDocumentosController {
	@Autowired
	private BODatosDocumentos documento;
	
	@RequestMapping(path = "/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosDocumentoBean datos){
		System.out.print("Se creo un historial academico");
		return new ResponseEntity<MsgBean>(documento.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosDocumentoBean datos){
		System.out.print("Se modifico historial academico");
		return new ResponseEntity<MsgBean>(documento.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody int id){
		System.out.print("se elimo historial academico");
		return new ResponseEntity<MsgBean>(documento.Eliminar(id),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosDocumentoBean>buscar(@RequestBody DatosDocumentoBean datos){
		System.out.print("se busco historial acdemico");
		return new ResponseEntity<DatosDocumentoBean>(documento.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosDocumentoBean>> consulta(){
		System.out.println("Ingresando a listar estudio ");
		List<DatosDocumentoBean> documentos = documento.Listar();
		if(documentos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosDocumentoBean>>(documentos, HttpStatus.OK);
		}
	}
}

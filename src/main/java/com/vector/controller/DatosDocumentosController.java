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
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
@RestController
public class DatosDocumentosController {
	@Autowired
	private BODatosDocumentos documento;
	
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosDocumentoBean> datos){
		System.out.print("Se agrego el doc "+datos.get(0).getDescripciondocNw()+ " al ID de persona" +datos.get(0).getIdpersona());
		return new ResponseEntity<MsgBean>(documento.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosDocumentoBean datos){
		System.out.print("Se modifico el documento "+datos.getDescripciondocNw()+" con id "+datos.getIddocumentoLt()+" " + "al ID de persona "+datos.getIdpersona()+" con id nuevo documento "+datos.getIddocumentoNw()+" ");
		return new ResponseEntity<MsgBean>(documento.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosDocumentoBean datos){
		System.out.print("se elimino el documento "+datos.getDescripciondocNw()+ "con el ID de documento "+datos.getIddocumentoNw());
		return new ResponseEntity<MsgBean>(documento.Eliminar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosDocumentoBean>>buscar(@RequestBody DatosDocumentoBean datos){
		System.out.print("se busco el documento "+datos.getDescripciondocNw()+ "con el ID de documento "+datos.getIddocumentoNw()+" ");
		return new ResponseEntity<List<DatosDocumentoBean>>(documento.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosDocumento/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosDocumentoBean>> consulta(@RequestBody DatosDocumentoBean datos){
		System.out.println("Ingresando a listar documento ");
		List<DatosDocumentoBean> documentos = documento.Listar(datos.getIdpersona());
		if(documentos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosDocumentoBean>>(documentos, HttpStatus.OK);
		}
	}
}

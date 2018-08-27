/**
 * DatosCursoController.java -- 25/08/2018
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

import com.vector.BO.BODatosCurso;
import com.vector.Beans.DatosCursoBean;
import com.vector.Beans.MsgBean;

/**
 * @author Jair
 *
 */
@RestController
public class DatosCursoController {
	@Autowired
	private BODatosCurso curso;
	
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody List<DatosCursoBean> datos){
		System.out.print("Se creo un curso "+datos.get(0).getNombrecurso()+"\n ");
		return new ResponseEntity<MsgBean>(curso.Crear(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody  DatosCursoBean datos){
		System.out.print("Se modifico un curso "+datos.getIdcurso()+"\n ");
		return new ResponseEntity<MsgBean>(curso.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Eliminar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosCursoBean datos){
		System.out.print("se elimino un curso con id "+datos.getIdcurso()+"\n ");
		return new ResponseEntity<MsgBean>(curso.Eliminar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Buscar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCursoBean>>buscar(@RequestBody  DatosCursoBean datos){
		System.out.print("se busco los cursos "+datos.getIdcurso()+"\n ");
		return new ResponseEntity<List< DatosCursoBean>>(curso.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosCurso/Listar",method=RequestMethod.POST)
	public ResponseEntity<List<DatosCursoBean>> consulta(@RequestBody DatosCursoBean datos){
		System.out.println("Ingresando a listar cursos "+"\n ");
		List<DatosCursoBean> cursos = curso.Listar();
		if(cursos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<DatosCursoBean>>(cursos, HttpStatus.OK);
		}
	}
}

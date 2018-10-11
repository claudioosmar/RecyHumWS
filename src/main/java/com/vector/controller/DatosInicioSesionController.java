/**
 * 
 */
package com.vector.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosLogin;
import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.MsgBean;
import com.vector.Utileria.Log;


/**
 * @author Claudio
 *
 */

@RestController
public class DatosInicioSesionController extends Log{
	
	
	
	@Autowired
	private BODatosLogin login;
	

	@RequestMapping(path = "/SGRHWebService/DatosSesion/Crear", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> insertar(@RequestBody DatosInicioSesionBean datos){
		info("Se creo un usuario"+datos.toString());
		return new ResponseEntity<MsgBean>(login.CreateUser(datos),HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Buscar",method=RequestMethod.POST)
	public ResponseEntity<DatosInicioSesionBean>buscar(@RequestBody DatosInicioSesionBean datos){
		info("Se busco los datos del usuario"+datos.getiduser());
		return new ResponseEntity<DatosInicioSesionBean>(login.Buscar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Verificar", method = RequestMethod.POST)
	public ResponseEntity<List<DatosFormularioBean>> verificarlogin(@RequestBody DatosInicioSesionBean datos){
		info("se verifica el usuario");/*letreros*/
		debug(null);/*informacion de variables*/
		error(null);/*errores ocurridos bajo control*/
		warn(null);/*alertas de informacion erronea*/
		fatal(null);/*errores fatales del programa*/
		MsgBean respuesta = new MsgBean();
		if(datos.getUsuario().isEmpty()&&datos.getContraseña().isEmpty()) {
			warn("usuario y contraseña incorrecto");
			respuesta.setMsjAccion("falta usuario y/o contraseña");
		}else {
		
		info("acceso concedido");
	}
		info("verificaccion correcta");
		return new ResponseEntity<List<DatosFormularioBean>>(login.VerificarUsuario(datos),HttpStatus.OK);
		
	}

	
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Listar", method = RequestMethod.POST)
	public ResponseEntity<List<DatosInicioSesionBean>> consulta(){
		info("Se ingreso a listar Usuarios");
		List<DatosInicioSesionBean> usuarios = login.ListarUsuarios();
		if(usuarios.isEmpty()) {
			info("no se encontro datos");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			info("se enlistaron los usuarios");
			return new ResponseEntity<List<DatosInicioSesionBean>>(usuarios, HttpStatus.OK);
		}
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosSesion/VerificarPrueba", method = RequestMethod.POST)
	public ResponseEntity<List<DatosFormularioBean>> consultaprueba(){
		info("Ingresando a listar formularios ");
		List<DatosFormularioBean> retorno = new ArrayList<DatosFormularioBean>();
		DatosFormularioBean form= new DatosFormularioBean();
		form.setNomformulario("DatosPersonales");
		form.setStatus(true);
		retorno.add(form);
		form = new DatosFormularioBean();
		form.setNomformulario("Idiomas");
		form.setStatus(false);
		retorno.add(form);
			return new ResponseEntity<List<DatosFormularioBean>>(retorno, HttpStatus.OK);
		}
	
	@RequestMapping(path = "/SGRHWebService/DatosSesion/Modificar",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>actualizar(@RequestBody DatosInicioSesionBean datos){
		info("Se modifico el usuario con id de persona: "+datos.getiduser());
		return new ResponseEntity<MsgBean>(login.Modificar(datos),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/SGRHWebService/DatosSesion/EliminarUser",method = RequestMethod.POST)
	public ResponseEntity<MsgBean>eliminar(@RequestBody DatosInicioSesionBean datos){
		info("Se elimino usuario: "+datos.getiduser());
		return new ResponseEntity<MsgBean>(login.Eliminar(datos.getiduser()),HttpStatus.OK);
	}
	
}

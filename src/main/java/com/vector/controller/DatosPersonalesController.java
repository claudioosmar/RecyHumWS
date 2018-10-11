package com.vector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.MsgBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.Utileria.Log;

@RestController
public class DatosPersonalesController extends Log {
	@Autowired
	private BODatosPersonales bodatos;

	// Ruta utilizada para la llamada de la funcion crear datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Crear", method = RequestMethod.POST)
	public ResponseEntity<DatosPersonalesBean> insertar(@RequestBody DatosPersonalesBean datos) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser creados
		info("Se creo una persona: " + datos.toString());
		return new ResponseEntity<DatosPersonalesBean>(bodatos.Crear(datos), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion Modificar datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Modificar", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> actualizar(@RequestBody DatosPersonalesBean datos) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser modificados
		info("Se modifico datos personales: " + datos.toString());
		return new ResponseEntity<MsgBean>(bodatos.Modificar(datos), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion eliminar datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Eliminar", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> eliminar(@RequestBody DatosPersonalesBean datos) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser eliminados
		info("se eliminó los datos personales con id: " + datos.getIdpersona());
		return new ResponseEntity<MsgBean>(bodatos.Eliminar(datos), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion buscar datos personales
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Buscar", method = RequestMethod.POST)
	public ResponseEntity<DatosPersonalesBean> buscar(@RequestBody DatosPersonalesBean datos) {
		// mensaje de impresion en la consola que muestra los datos que relacionan la
		// consulta
		info("se busco los datos personales: " + datos.getIdpersona());
		return new ResponseEntity<DatosPersonalesBean>(bodatos.Buscar(datos), HttpStatus.OK);
	}

	// Ruta utilizada para buscar datos personales por area
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/BusquedaEstudiosP/{id}", method = RequestMethod.POST)
	public ResponseEntity<List<DatosPersonalesBean>> busquedaestudiosp(@PathVariable("id") long id) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser creados
		info("Se Busco datos estudio de la persona: " + id);
		return new ResponseEntity<List<DatosPersonalesBean>>(bodatos.BusquedaEstudiosPersona(id), HttpStatus.OK);
	}

	// Ruta utilizada para buscar datos personales por area
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/BusquedaHerramientasconP/{id}", method = RequestMethod.POST)
	public ResponseEntity<List<DatosPersonalesBean>> busquedaherramientascon(@PathVariable("id") long id) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser creados
		info("Se Busco datos de las herramientas conocidas de la persona: " + id);
		return new ResponseEntity<List<DatosPersonalesBean>>(bodatos.BusquedaHerramientasConPersona(id), HttpStatus.OK);
	}

	// Ruta utilizada para buscar datos personales por area
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/BusquedaExpLaboralesP/{id}", method = RequestMethod.POST)
	public ResponseEntity<List<DatosPersonalesBean>> busquedaexplaboralesp(@PathVariable("id") long id) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser creados
		info("Se Busco datos de la experiencia laboral de la persona: " + id);
		return new ResponseEntity<List<DatosPersonalesBean>>(bodatos.BusquedaExpLaboralPersona(id), HttpStatus.OK);
	}

	// Ruta utilizada para buscar datos personales por area
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/BusquedaIdiomasP/{id}", method = RequestMethod.POST)
	public ResponseEntity<List<DatosPersonalesBean>> busquedaidomasp(@PathVariable("id") long id) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser creados
		info("Se Busco datos de los idiomas dominados de la persona: " + id);
		return new ResponseEntity<List<DatosPersonalesBean>>(bodatos.BusquedaIdiomasPersona(id), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion modificar datos personales v2
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/Modificar2", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> actualizar2(@RequestBody DatosPersonalesBean datos) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser modificados v2
		info("Se modificaron datos personales: " + datos.toString());
		return new ResponseEntity<MsgBean>(bodatos.Modificar2(datos), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion modificar datos administrativos
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/ModificarAdmin", method = RequestMethod.POST)
	public ResponseEntity<MsgBean> actualizar3(@RequestBody DatosPersonalesBean datos) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser modificados v2
		info("Se actualizaron datos de suma importancia: " + datos.toString());
		return new ResponseEntity<MsgBean>(bodatos.Modificar3(datos), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion modificar datos administrativos
	@RequestMapping(path = "/SGRHWebService/DatosPersonales/BuscarNombreCompleto/{cadena}", method = RequestMethod.POST)
	public ResponseEntity<List<DatosPersonalesBean>> BuscarNombreCompleto(@PathVariable("cadena") String parametro) {
		// Linea de impresion en consola que muestra datos de los datos personales al
		// ser modificados v2
		info("Busqueda exitosa al buscar por: " + parametro);
		return new ResponseEntity<List<DatosPersonalesBean>>(bodatos.BusquedaNombreCompleto(parametro), HttpStatus.OK);
	}

	// Ruta utilizada para la llamada de la funcion listar idiomas
	@RequestMapping("/SGRHWebService/DatosPersonales/Listar")
	public ResponseEntity<List<DatosPersonalesBean>> Listar() {
		info("Ingresando a listar datos personales ");
		List<DatosPersonalesBean> resp = bodatos.Listar();
		if (resp.isEmpty()) {
			info("No se encontro contenido");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			info("se listaron datos personales");
			return new ResponseEntity<List<DatosPersonalesBean>>(resp, HttpStatus.OK);
		}
	}

}

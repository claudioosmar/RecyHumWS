package com.vector.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.vector.model.Usuario;
import com.vector.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> consultaUsuarios(){
		List<Usuario> usuarios = usuarioService.findAll();
		
		if(usuarios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/insertar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertar(){
		Usuario usuario = new Usuario();
		usuario.setNombre("Poncho");
		usuarioService.save(usuario);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> actualizar(@PathVariable("id") long id, @RequestBody Usuario usuario){
		System.out.println("Actualizando usuario " + id);
		Optional<Usuario> user = usuarioService.findByOne(id);
		Usuario us = new Usuario();
		if(user.isPresent()) {
			us = user.get();
		}
		if(us == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}else {
			us.setNombre(usuario.getNombre());
			usuarioService.actualizar(us);
			return new ResponseEntity<Usuario>(us, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") long id){
		System.out.println("Buscando usuario por: " + id);
		Optional<Usuario> usuario = usuarioService.findByOne(id);
		Usuario us = new Usuario();
		if(usuario.isPresent()) {
			us = usuario.get();
		}
		
		if(us == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Usuario>(us, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/busca/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorNombre(@PathVariable("nombre") String nombre){
		System.out.println("Buscando usuario por: " + nombre);
		Usuario usuario = usuarioService.findByName(nombre);
		if(usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/borrar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> borrar(@PathVariable("id") long id){
		System.out.println("Borrando " + id);
		Optional<Usuario> usuario = usuarioService.findByOne(id);
		Usuario us = new Usuario();
		if(usuario.isPresent()) {
			us = usuario.get();
		}
		if(us == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else {
			usuarioService.borrar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/nombres", method = RequestMethod.GET)
	public ResponseEntity<List<String>> consultaNombres(){
		List<String> nombres = usuarioService.nombres();
		if(nombres == null) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<String>>(nombres, HttpStatus.OK);
		}
	}
}

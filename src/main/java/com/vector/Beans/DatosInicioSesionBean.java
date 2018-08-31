/**
 * DatosInicioSesionBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosInicioSesionBean
 */
//Clase Bean para los datos de login
public class DatosInicioSesionBean {
	//Variable para declara los getter y setter de login
	@NotNull
	private long ID_User=0;
	@NotNull
	private String IP="";
	@NotNull
	private String usuario="";
	@NotNull
	private String contraseña="";
	@NotNull
	private String Status="";
	@NotNull
	private String token="";
	@NotNull
	private String movimiento="";
	@NotNull
	private int idtipouser=0;
	@NotNull
	private long idpersonaalta=0;
	@NotNull
	private long idpersona=0;
	@NotNull
	private String observacion="";
	@NotNull
	private String nombre="";
	@NotNull
	private String fechaCreacion="";
	@NotNull
	private String fechaTermino="";
	@NotNull
	private String nombrecompleto="";
	@NotNull
	private String area="";
	
	//declaraciones de getters y setters
	/**
	 * @return Obtienes el valor de iD_User del tipo long
	 */
	
	public long getID_User() {
		return ID_User;
	}
	
	/**
	 * @param Agregar el valor a iD_User del tipo long
	 */
	
	public void setID_User(long iD_User) {
		ID_User = iD_User;
	}
	
	/**
	 * @return Obtienes el valor de iP del tipo String
	 */
	
	public String getIP() {
		return IP;
	}
	
	/**
	 * @param Agregar el valor a iP del tipo String
	 */
	
	public void setIP(String iP) {
		IP = iP;
	}
	
	/**
	 * @return Obtienes el valor de usuario del tipo String
	 */
	
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * @param Agregar el valor a usuario del tipo String
	 */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return Obtienes el valor de contraseña del tipo String
	 */
	
	public String getContraseña() {
		return contraseña;
	}
	
	/**
	 * @param Agregar el valor a contraseña del tipo String
	 */
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	/**
	 * @return Obtienes el valor de status del tipo String
	 */
	
	public String getStatus() {
		return Status;
	}
	
	/**
	 * @param Agregar el valor a status del tipo String
	 */
	
	public void setStatus(String status) {
		Status = status;
	}
	
	/**
	 * @return Obtienes el valor de token del tipo String
	 */
	
	public String getToken() {
		return token;
	}
	
	/**
	 * @param Agregar el valor a token del tipo String
	 */
	
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return Obtienes el valor de movimiento del tipo String
	 */
	
	public String getMovimiento() {
		return movimiento;
	}
	
	/**
	 * @param Agregar el valor a movimiento del tipo String
	 */
	
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
	/**
	 * @return Obtienes el valor de idtipouser del tipo int
	 */
	
	public int getIdtipouser() {
		return idtipouser;
	}
	
	/**
	 * @param Agregar el valor a idtipouser del tipo int
	 */
	
	public void setIdtipouser(int idtipouser) {
		this.idtipouser = idtipouser;
	}
	
	/**
	 * @return Obtienes el valor de idpersonaalta del tipo long
	 */
	
	public long getIdpersonaalta() {
		return idpersonaalta;
	}
	
	/**
	 * @param Agregar el valor a idpersonaalta del tipo long
	 */
	
	public void setIdpersonaalta(long idpersonaalta) {
		this.idpersonaalta = idpersonaalta;
	}
	
	/**
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona del tipo long
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * @return Obtienes el valor de observacion del tipo String
	 */
	
	public String getObservacion() {
		return observacion;
	}
	
	/**
	 * @param Agregar el valor a observacion del tipo String
	 */
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	/**
	 * @return Obtienes el valor de nombre del tipo String
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param Agregar el valor a nombre del tipo String
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return Obtienes el valor de fechaCreacion del tipo String
	 */
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	/**
	 * @param Agregar el valor a fechaCreacion del tipo String
	 */
	
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * @return Obtienes el valor de fechaTermino del tipo String
	 */
	
	public String getFechaTermino() {
		return fechaTermino;
	}
	
	/**
	 * @param Agregar el valor a fechaTermino del tipo String
	 */
	
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	/**
	 * @return Obtienes el valor de nombrecompleto del tipo String
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	
	/**
	 * @param Agregar el valor a nombrecompleto del tipo String
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	/**
	 * @return Obtienes el valor de area del tipo String
	 */
	
	public String getArea() {
		return area;
	}
	
	/**
	 * @param Agregar el valor a area del tipo String
	 */
	
	public void setArea(String area) {
		this.area = area;
	}
	
	
}

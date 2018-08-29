/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author Claudio
 *
 */
public class DatosInicioSesionBean  {
	/*Atributos del inicio de sesion*/
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
	
	
	
	
	/**
	 * @return Obtienes el valor de area
	 */
	
	public String getArea() {
		return area;
	}


	
	/**
	 * @param Agregar el valor a area
	 */
	
	public void setArea(String area) {
		this.area = area;
	}


	/**
	 * @return Obtienes el valor de nombrecompleto
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}

	
	/**
	 * @param Agregar el valor a nombrecompleto
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	/**
	 * @return Obtienes el valor de iD_User
	 */
	
	public long getID_User() {
		return ID_User;
	}
	
	/**
	 * @param Agregar el valor a iD_User
	 */
	
	public void setID_User(long iD_User) {
		ID_User = iD_User;
	}
	
	/**
	 * @return Obtienes el valor de iP
	 */
	
	public String getIP() {
		return IP;
	}
	
	/**
	 * @param Agregar el valor a iP
	 */
	
	public void setIP(String iP) {
		IP = iP;
	}
	
	/**
	 * @return Obtienes el valor de usuario
	 */
	
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * @param Agregar el valor a usuario
	 */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return Obtienes el valor de contraseña
	 */
	
	public String getContraseña() {
		return contraseña;
	}
	
	/**
	 * @param Agregar el valor a contraseña
	 */
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	/**
	 * @return Obtienes el valor de status
	 */
	
	public String getStatus() {
		return Status;
	}
	
	/**
	 * @param Agregar el valor a status
	 */
	
	public void setStatus(String status) {
		Status = status;
	}
	
	/**
	 * @return Obtienes el valor de token
	 */
	
	public String getToken() {
		return token;
	}
	
	/**
	 * @param Agregar el valor a token
	 */
	
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return Obtienes el valor de movimiento
	 */
	
	public String getMovimiento() {
		return movimiento;
	}
	
	/**
	 * @param Agregar el valor a movimiento
	 */
	
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
	/**
	 * @return Obtienes el valor de idtipouser
	 */
	
	public int getIdtipouser() {
		return idtipouser;
	}
	
	/**
	 * @param Agregar el valor a idtipouser
	 */
	
	public void setIdtipouser(int idtipouser) {
		this.idtipouser = idtipouser;
	}
	
	/**
	 * @return Obtienes el valor de idpersonaalta
	 */
	
	public long getIdpersonaalta() {
		return idpersonaalta;
	}
	
	/**
	 * @param Agregar el valor a idpersonaalta
	 */
	
	public void setIdpersonaalta(long idpersonaalta) {
		this.idpersonaalta = idpersonaalta;
	}
	
	/**
	 * @return Obtienes el valor de idpersona
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * @return Obtienes el valor de observacion
	 */
	
	public String getObservacion() {
		return observacion;
	}
	
	/**
	 * @param Agregar el valor a observacion
	 */
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	/**
	 * @return Obtienes el valor de nombre
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param Agregar el valor a nombre
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return Obtienes el valor de fechaCreacion
	 */
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	/**
	 * @param Agregar el valor a fechaCreacion
	 */
	
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * @return Obtienes el valor de fechaTermino
	 */
	
	public String getFechaTermino() {
		return fechaTermino;
	}
	
	/**
	 * @param Agregar el valor a fechaTermino
	 */
	
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	
}

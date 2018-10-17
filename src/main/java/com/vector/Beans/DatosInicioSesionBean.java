/**
 * DatosInicioSesionBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosInicioSesionBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de login
public class DatosInicioSesionBean {
	
	/** The iduser. */
	//Variable para declara los getter y setter de login
	@NotNull
	private long iduser=0;
	
	/** The idtipocorreo. */
	@NotNull
	private int idtipocorreo=0;
	
	/** The usuario. */
	@NotNull
	private String usuario="";
	
	/** The contraseña. */
	@NotNull
	private String contraseña="";
	
	/** The Status. */
	@NotNull
	private boolean Status= false;
	
	/** The token. */
	@NotNull
	private String token="";
	
	/** The movimiento. */
	@NotNull
	private String movimiento="";
	
	/** The idtipouser. */
	@NotNull
	private int idtipouser=0;
	
	/** The idpersonaalta. */
	@NotNull
	private long idpersonaalta=0;
	
	/** The idpersona. */
	@NotNull
	private long idpersona=0;
	
	/** The observacion. */
	@NotNull
	private String observacion="";
	
	/** The nombre. */
	@NotNull
	private String nombre="";
	
	/** The fecha creacion. */
	@NotNull
	private String fechaCreacion="";
	
	/** The fecha termino. */
	@NotNull
	private String fechaTermino="";
	
	/** The nombrecompleto. */
	@NotNull
	private String nombrecompleto="";
	
	/** The area. */
	@NotNull
	private String area="";
	
	//declaraciones de getters y setters
	/**
	 * Gets the iduser.
	 *
	 * @return Obtienes el valor de iD_User del tipo long
	 */
	
	public long getiduser() {
		return iduser;
	}
	
	/**
	 * Sets the iduser.
	 *
	 * @param iD_User the new iduser
	 */
	
	public void setiduser(long iD_User) {
		iduser = iD_User;
	}
	
	/**
	 * Gets the ip.
	 *
	 * @return Obtienes el valor de iP del tipo String
	 */
	
	public int getIdtipocorreo() {
		return idtipocorreo;
	}
	
	/**
	 * Sets the ip.
	 *
	 * @param iP the new ip
	 */
	
	public void setIdtipocorreo(int Idtipocorreo) {
		idtipocorreo = Idtipocorreo;
	}
	
	/**
	 * Gets the usuario.
	 *
	 * @return Obtienes el valor de usuario del tipo String
	 */
	
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Gets the contraseña.
	 *
	 * @return Obtienes el valor de contraseña del tipo String
	 */
	
	public String getContraseña() {
		return contraseña;
	}
	
	/**
	 * Sets the contraseña.
	 *
	 * @param contraseña the new contraseña
	 */
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return Obtienes el valor de status del tipo String
	 */
	
	public boolean getStatus() {
		return Status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	
	public void setStatus(boolean status) {
		Status = status;
	}
	
	/**
	 * Gets the token.
	 *
	 * @return Obtienes el valor de token del tipo String
	 */
	
	public String getToken() {
		return token;
	}
	
	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Gets the movimiento.
	 *
	 * @return Obtienes el valor de movimiento del tipo String
	 */
	
	public String getMovimiento() {
		return movimiento;
	}
	
	/**
	 * Sets the movimiento.
	 *
	 * @param movimiento the new movimiento
	 */
	
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
	/**
	 * Gets the idtipouser.
	 *
	 * @return Obtienes el valor de idtipouser del tipo int
	 */
	
	public int getIdtipouser() {
		return idtipouser;
	}
	
	/**
	 * Sets the idtipouser.
	 *
	 * @param idtipouser the new idtipouser
	 */
	
	public void setIdtipouser(int idtipouser) {
		this.idtipouser = idtipouser;
	}
	
	/**
	 * Gets the idpersonaalta.
	 *
	 * @return Obtienes el valor de idpersonaalta del tipo long
	 */
	
	public long getIdpersonaalta() {
		return idpersonaalta;
	}
	
	/**
	 * Sets the idpersonaalta.
	 *
	 * @param idpersonaalta the new idpersonaalta
	 */
	
	public void setIdpersonaalta(long idpersonaalta) {
		this.idpersonaalta = idpersonaalta;
	}
	
	/**
	 * Gets the idpersona.
	 *
	 * @return Obtienes el valor de idpersona del tipo long
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * Sets the idpersona.
	 *
	 * @param idpersona the new idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	
	/**
	 * Gets the observacion.
	 *
	 * @return Obtienes el valor de observacion del tipo String
	 */
	
	public String getObservacion() {
		return observacion;
	}
	
	/**
	 * Sets the observacion.
	 *
	 * @param observacion the new observacion
	 */
	
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return Obtienes el valor de nombre del tipo String
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the fecha creacion.
	 *
	 * @return Obtienes el valor de fechaCreacion del tipo String
	 */
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	/**
	 * Sets the fecha creacion.
	 *
	 * @param fechaCreacion the new fecha creacion
	 */
	
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * Gets the fecha termino.
	 *
	 * @return Obtienes el valor de fechaTermino del tipo String
	 */
	
	public String getFechaTermino() {
		return fechaTermino;
	}
	
	/**
	 * Sets the fecha termino.
	 *
	 * @param fechaTermino the new fecha termino
	 */
	
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	/**
	 * Gets the nombrecompleto.
	 *
	 * @return Obtienes el valor de nombrecompleto del tipo String
	 */
	
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	
	/**
	 * Sets the nombrecompleto.
	 *
	 * @param nombrecompleto the new nombrecompleto
	 */
	
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	
	/**
	 * Gets the area.
	 *
	 * @return Obtienes el valor de area del tipo String
	 */
	
	public String getArea() {
		return area;
	}
	
	/**
	 * Sets the area.
	 *
	 * @param area the new area
	 */
	
	public void setArea(String area) {
		this.area = area;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return String.format("DatosUsuarioBean [IDUSER="+iduser+ "],[IDTIPOCORREO="+idtipocorreo + "],[USUARIO="+usuario + "],[CONTRASEÑA="+contraseña + "],[STATUS="
		+Status + "],[TOKEN="+token + "],[MOVIMIENTO="+movimiento + "],[IDTIPOUSER="
		+idtipouser + "],[IDTIPOPERSONAALTA="+idpersonaalta + "],[IDPERSONA="+idpersona + "],[OBSERVACION="
		+observacion + "],[NOMBRE="	+nombre + "],[FECHACREACION="+fechaCreacion  + "],[FECHAMODIFICACION="
		+fechaTermino + "],[NOMBRECOMPLETO="+nombrecompleto + "],[AREA="+area +"]");
	
	}
}

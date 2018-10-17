/**
 * DatosPistaAuditoraBean.java -- 17/10/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosPistaAuditoraBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  17/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public class DatosPistaAuditoraBean {
	
	/** The idpista. */
	@NotNull
	private long idpista =0;
	
	/** The iduser. */
	@NotNull
	private long iduser=0;
	
	/** The formulario. */
	@NotNull
	private String formulario="";
	
	/** The sistema. */
	@NotNull
	private String sistema="";
	
	/** The accion. */
	@NotNull
	private String accion="";
	
	/** The ipequipo. */
	@NotNull
	private String ipequipo="";
	
	/** The status. */
	@NotNull
	private String status="";
	
	/**
	 * Gets the idpista.
	 *
	 * @return Obtienes el valor de idpista del tipo long
	 */
	
	public long getIdpista() {
		return idpista;
	}
	
	/**
	 * Sets the idpista.
	 *
	 * @param idpista the new idpista
	 */
	
	public void setIdpista(long idpista) {
		this.idpista = idpista;
	}
	
	/**
	 * Gets the iduser.
	 *
	 * @return Obtienes el valor de iduser del tipo long
	 */
	
	public long getIduser() {
		return iduser;
	}
	
	/**
	 * Sets the iduser.
	 *
	 * @param iduser the new iduser
	 */
	
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	
	/**
	 * Gets the formulario.
	 *
	 * @return Obtienes el valor de formulario del tipo String
	 */
	
	public String getFormulario() {
		return formulario;
	}
	
	/**
	 * Sets the formulario.
	 *
	 * @param formulario the new formulario
	 */
	
	public void setFormulario(String formulario) {
		this.formulario = formulario;
	}
	
	/**
	 * Gets the sistema.
	 *
	 * @return Obtienes el valor de sistema del tipo String
	 */
	
	public String getSistema() {
		return sistema;
	}
	
	/**
	 * Sets the sistema.
	 *
	 * @param sistema the new sistema
	 */
	
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
	/**
	 * Gets the accion.
	 *
	 * @return Obtienes el valor de accion del tipo String
	 */
	
	public String getAccion() {
		return accion;
	}
	
	/**
	 * Sets the accion.
	 *
	 * @param accion the new accion
	 */
	
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	/**
	 * Gets the ipequipo.
	 *
	 * @return Obtienes el valor de ipequipo del tipo String
	 */
	
	public String getIpequipo() {
		return ipequipo;
	}
	
	/**
	 * Sets the ipequipo.
	 *
	 * @param ipequipo the new ipequipo
	 */
	
	public void setIpequipo(String ipequipo) {
		this.ipequipo = ipequipo;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return Obtienes el valor de status del tipo String
	 */
	
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}

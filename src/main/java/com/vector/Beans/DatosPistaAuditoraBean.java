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
	
	private long idpista =0;
	
	/** The iduser. */
	@NotNull(message="IDUsuario Necesario")
	private long iduserp;
	
	/** The formulario. */
	@NotNull(message="Formulario Necesario")
	private String formulario;
	
	/** The sistema. */
	@NotNull(message="Sistema Necesario")
	private String sistema;
	
	/** The accion. */
	private String accion;
	
	/** The ipequipo. */
	@NotNull(message="IPEquipo Necesario")
	private String ipequipo;
	
	private String statusOp;
	
	
	/**
	 * @return Obtienes el valor de statusOp del tipo String
	 */
	
	public String getStatusOp() {
		return statusOp;
	}

	
	/**
	 * @param Agregar el valor a statusOp del tipo String
	 */
	
	public void setStatusOp(String statusOp) {
		this.statusOp = statusOp;
	}

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
	
	public long getIduserp() {
		return iduserp;
	}
	
	/**
	 * Sets the iduser.
	 *
	 * @param iduser the new iduser
	 */
	
	public void setIduserp(long iduser) {
		this.iduserp = iduser;
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
	

	@Override
	public String toString() {
		return "{idpista["+idpista+"],iduser["+iduserp+"][formulario["+formulario+"],sistema["+sistema+"],ipequipo["+ipequipo+"],status["+statusOp+"]}";
	}
	
}

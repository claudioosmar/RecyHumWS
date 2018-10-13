/**
 * DatosFormularioBean.java -- 29/08/2018
 */
package com.vector.Beans;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosFormularioBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de formulario
public class DatosFormularioBean {
	
	/** The Nomformulario. */
	//Variable para declara los getter y setter de formulario
	private String Nomformulario="";
	
	/** The status. */
	private boolean status=false;
	
	/** The idpersona. */
	private long idpersona=0;
	
	/** The idtipousuario. */
	private int idtipousuario=0;
	
	

	
	/**
	 * Gets the idtipousuario.
	 *
	 * @return Obtienes el valor de idtipousuario del tipo int
	 */
	
	public int getIdtipousuario() {
		return idtipousuario;
	}

	
	/**
	 * Sets the idtipousuario.
	 *
	 * @param idtipousuario the new idtipousuario
	 */
	
	public void setIdtipousuario(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	//declaracion de getters y setters
	/**
	 * Gets the nomformulario.
	 *
	 * @return Obtienes el valor de nomformulario del tipo String
	 */
	
	public String getNomformulario() {
		return Nomformulario;
	}
	
	/**
	 * Sets the nomformulario.
	 *
	 * @param nomformulario the new nomformulario
	 */
	
	public void setNomformulario(String nomformulario) {
		Nomformulario = nomformulario;
	}
	
	/**
	 * Checks if is status.
	 *
	 * @return Obtienes el valor de status del tipo boolean
	 */
	
	public boolean isStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	
	public void setStatus(boolean status) {
		this.status = status;
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
	
	
}

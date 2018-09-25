/**
 * DatosFormularioBean.java -- 29/08/2018
 */
package com.vector.Beans;

/**
 * @author Claudio
 *RecyHumWS2--com.vector.Beans--DatosFormularioBean
 */
//Clase Bean para los datos de formulario
public class DatosFormularioBean {
	//Variable para declara los getter y setter de formulario
	private String Nomformulario="";
	private boolean status=false;
	private long idpersona=0;
	private int idtipousuario=0;
	
	

	
	/**
	 * @return Obtienes el valor de idtipousuario del tipo int
	 */
	
	public int getIdtipousuario() {
		return idtipousuario;
	}

	
	/**
	 * @param Agregar el valor a idtipousuario del tipo int
	 */
	
	public void setIdtipousuario(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	//declaracion de getters y setters
	/**
	 * @return Obtienes el valor de nomformulario del tipo String
	 */
	
	public String getNomformulario() {
		return Nomformulario;
	}
	
	/**
	 * @param Agregar el valor a nomformulario del tipo String
	 */
	
	public void setNomformulario(String nomformulario) {
		Nomformulario = nomformulario;
	}
	
	/**
	 * @return Obtienes el valor de status del tipo boolean
	 */
	
	public boolean isStatus() {
		return status;
	}
	
	/**
	 * @param Agregar el valor a status del tipo boolean
	 */
	
	public void setStatus(boolean status) {
		this.status = status;
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
	
	
}

/**
 * DatosDocumentoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosDocumentoBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
//Clase Bean para los datos de documentos
public class DatosDocumentoBean {
	
	/** The iddocumento nw. */
	//Variable para declara los getter y setter de documento
	@NotNull
	private int iddocumentoNw=0;
	
	/** The descripciondoc nw. */
	@NotNull
	private String descripciondocNw="";
	
	/** The urldoc nw. */
	@NotNull
	private String urldocNw="";
	
	/** The idpersona. */
	private int idpersona =0;
	
	/** The iddocumento lt. */
	@NotNull
	private int iddocumentoLt=0;
	
	/** The descripciondoc lt. */
	@NotNull
	private String descripciondocLt="";
	
	/** The urldoc lt. */
	@NotNull
	private String urldocLt="";

	
	/**
	 * Gets the iddocumento nw.
	 *
	 * @return Obtienes el valor de iddocumentoNw del tipo int
	 */
	
	public int getIddocumentoNw() {
		return iddocumentoNw;
	}

	
	/**
	 * Sets the iddocumento nw.
	 *
	 * @param iddocumentoNw the new iddocumento nw
	 */
	
	public void setIddocumentoNw(int iddocumentoNw) {
		this.iddocumentoNw = iddocumentoNw;
	}

	
	/**
	 * Gets the descripciondoc nw.
	 *
	 * @return Obtienes el valor de descripciondocNw del tipo String
	 */
	
	public String getDescripciondocNw() {
		return descripciondocNw;
	}

	
	/**
	 * Sets the descripciondoc nw.
	 *
	 * @param descripciondocNw the new descripciondoc nw
	 */
	
	public void setDescripciondocNw(String descripciondocNw) {
		this.descripciondocNw = descripciondocNw;
	}

	
	/**
	 * Gets the urldoc nw.
	 *
	 * @return Obtienes el valor de urldocNw del tipo String
	 */
	
	public String getUrldocNw() {
		return urldocNw;
	}

	
	/**
	 * Sets the urldoc nw.
	 *
	 * @param urldocNw the new urldoc nw
	 */
	
	public void setUrldocNw(String urldocNw) {
		this.urldocNw = urldocNw;
	}

	
	/**
	 * Gets the idpersona.
	 *
	 * @return Obtienes el valor de idpersona del tipo int
	 */
	
	public int getIdpersona() {
		return idpersona;
	}

	
	/**
	 * Sets the idpersona.
	 *
	 * @param idpersona the new idpersona
	 */
	
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	
	/**
	 * Gets the iddocumento lt.
	 *
	 * @return Obtienes el valor de iddocumentoLt del tipo int
	 */
	
	public int getIddocumentoLt() {
		return iddocumentoLt;
	}

	
	/**
	 * Sets the iddocumento lt.
	 *
	 * @param iddocumentoLt the new iddocumento lt
	 */
	
	public void setIddocumentoLt(int iddocumentoLt) {
		this.iddocumentoLt = iddocumentoLt;
	}

	
	/**
	 * Gets the descripciondoc lt.
	 *
	 * @return Obtienes el valor de descripciondocLt del tipo String
	 */
	
	public String getDescripciondocLt() {
		return descripciondocLt;
	}

	
	/**
	 * Sets the descripciondoc lt.
	 *
	 * @param descripciondocLt the new descripciondoc lt
	 */
	
	public void setDescripciondocLt(String descripciondocLt) {
		this.descripciondocLt = descripciondocLt;
	}

	
	/**
	 * Gets the urldoc lt.
	 *
	 * @return Obtienes el valor de urldocLt del tipo String
	 */
	
	public String getUrldocLt() {
		return urldocLt;
	}

	
	/**
	 * Sets the urldoc lt.
	 *
	 * @param urldocLt the new urldoc lt
	 */
	
	public void setUrldocLt(String urldocLt) {
		this.urldocLt = urldocLt;
	}
	
	
}

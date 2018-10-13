/**
 * DatosCertificadoBean.java -- 29/08/2018
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DatosCertificadoBean.java
 *   Descripción:  contiene las variables, getters y setters 
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
// Clase Bean para los datos de certificado 
public class DatosCertificadoBean {
	
	/** The nomcertificado nw. */
	//Variable para declara los getter y setter de certificado
	@NotNull
	private String nomcertificadoNw=""; 
	
	/** The iddocumento nw. */
	@NotNull
	private int iddocumentoNw=0;
	
	/** The idcertificado. */
	@NotNull
	private int idcertificado=0;
	
	/** The nomcertificado lt. */
	@NotNull
	private String nomcertificadoLt="";
	
	/** The iddocumento lt. */
	@NotNull
	private int iddocumentoLt=0;
	
	/** The idestudio. */
	@NotNull
	private int idestudio=0;
	
	/** The idpersona. */
	@NotNull
	private long idpersona;
	
	/**
	 * Gets the nomcertificado nw.
	 *
	 * @return Obtienes el valor de nomcertificadoNw del tipo String
	 */
	
	public String getNomcertificadoNw() {
		return nomcertificadoNw;
	}
	
	/**
	 * Sets the nomcertificado nw.
	 *
	 * @param nomcertificadoNw the new nomcertificado nw
	 */
	
	public void setNomcertificadoNw(String nomcertificadoNw) {
		this.nomcertificadoNw = nomcertificadoNw;
	}
	
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
	 * Gets the idcertificado.
	 *
	 * @return Obtienes el valor de idcertificado del tipo int
	 */
	
	public int getIdcertificado() {
		return idcertificado;
	}
	
	/**
	 * Sets the idcertificado.
	 *
	 * @param idcertificado the new idcertificado
	 */
	
	public void setIdcertificado(int idcertificado) {
		this.idcertificado = idcertificado;
	}
	
	/**
	 * Gets the nomcertificado lt.
	 *
	 * @return Obtienes el valor de nomcertificadoLt del tipo String
	 */
	
	public String getNomcertificadoLt() {
		return nomcertificadoLt;
	}
	
	/**
	 * Sets the nomcertificado lt.
	 *
	 * @param nomcertificadoLt the new nomcertificado lt
	 */
	
	public void setNomcertificadoLt(String nomcertificadoLt) {
		this.nomcertificadoLt = nomcertificadoLt;
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
	 * Gets the idestudio.
	 *
	 * @return Obtienes el valor de idestudio del tipo int
	 */
	
	public int getIdestudio() {
		return idestudio;
	}
	
	/**
	 * Sets the idestudio.
	 *
	 * @param idestudio the new idestudio
	 */
	
	public void setIdestudio(int idestudio) {
		this.idestudio = idestudio;
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

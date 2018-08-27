/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
public class DatosDocumentoBean {
	@NotNull
	private int iddocumentoNw=0;
	@NotNull
	private String descripciondocNw="";
	@NotNull
	private String urldocNw="";
	
	private int idpersona =0;
	
	@NotNull
	private int iddocumentoLt=0;
	@NotNull
	private String descripciondocLt="";
	
	@NotNull
	private String urldocLt="";

	/**
	 * @return the iddocumentoNw
	 */
	public int getIddocumentoNw() {
		return iddocumentoNw;
	}

	/**
	 * @param iddocumentoNw the iddocumentoNw to set
	 */
	public void setIddocumentoNw(int iddocumentoNw) {
		this.iddocumentoNw = iddocumentoNw;
	}

	/**
	 * @return the descripciondocNw
	 */
	public String getDescripciondocNw() {
		return descripciondocNw;
	}

	/**
	 * @param descripciondocNw the descripciondocNw to set
	 */
	public void setDescripciondocNw(String descripciondocNw) {
		this.descripciondocNw = descripciondocNw;
	}

	/**
	 * @return the urldocNw
	 */
	public String getUrldocNw() {
		return urldocNw;
	}

	/**
	 * @param urldocNw the urldocNw to set
	 */
	public void setUrldocNw(String urldocNw) {
		this.urldocNw = urldocNw;
	}

	/**
	 * @return the idpersona
	 */
	public int getIdpersona() {
		return idpersona;
	}

	/**
	 * @param idpersona the idpersona to set
	 */
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	/**
	 * @return the iddocumentoLt
	 */
	public int getIddocumentoLt() {
		return iddocumentoLt;
	}

	/**
	 * @param iddocumentoLt the iddocumentoLt to set
	 */
	public void setIddocumentoLt(int iddocumentoLt) {
		this.iddocumentoLt = iddocumentoLt;
	}

	/**
	 * @return the descripciondocLt
	 */
	public String getDescripciondocLt() {
		return descripciondocLt;
	}

	/**
	 * @param descripciondocLt the descripciondocLt to set
	 */
	public void setDescripciondocLt(String descripciondocLt) {
		this.descripciondocLt = descripciondocLt;
	}

	/**
	 * @return the urldocLt
	 */
	public String getUrldocLt() {
		return urldocLt;
	}

	/**
	 * @param urldocLt the urldocLt to set
	 */
	public void setUrldocLt(String urldocLt) {
		this.urldocLt = urldocLt;
	}

	
	
	
	
}
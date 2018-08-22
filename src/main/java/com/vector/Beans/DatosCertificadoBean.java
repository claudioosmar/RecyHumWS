/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosCertificadoBean extends LogBean implements Model{
	@NotNull
	private String nombrecertificado="";
	@NotNull
	private int iddocumento=0;
	@NotNull
	private String descripciondoc="";
	@NotNull
	private String urldoc="";
	private long idpersona=0;
	private long idcertificado=0;
	
	
	/**
	 * @return the idpersona
	 */
	public long getIdpersona() {
		return idpersona;
	}
	/**
	 * @param idpersona the idpersona to set
	 */
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @return the idcertificado
	 */
	public long getIdcertificado() {
		return idcertificado;
	}
	/**
	 * @param idcertificado the idcertificado to set
	 */
	public void setIdcertificado(long idcertificado) {
		this.idcertificado = idcertificado;
	}
	/**
	 * @return the nombrecertificado
	 */
	public String getNombrecertificado() {
		return nombrecertificado;
	}
	/**
	 * @param nombrecertificado the nombrecertificado to set
	 */
	public void setNombrecertificado(String nombrecertificado) {
		this.nombrecertificado = nombrecertificado;
	}
	/**
	 * @return the iddocumento
	 */
	public int getIddocumento() {
		return iddocumento;
	}
	/**
	 * @param iddocumento the iddocumento to set
	 */
	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}
	/**
	 * @return the descripciondoc
	 */
	public String getDescripciondoc() {
		return descripciondoc;
	}
	/**
	 * @param descripciondoc the descripciondoc to set
	 */
	public void setDescripciondoc(String descripciondoc) {
		this.descripciondoc = descripciondoc;
	}
	/**
	 * @return the urldoc
	 */
	public String getUrldoc() {
		return urldoc;
	}
	/**
	 * @param urldoc the urldoc to set
	 */
	public void setUrldoc(String urldoc) {
		this.urldoc = urldoc;
	}
	
	
}

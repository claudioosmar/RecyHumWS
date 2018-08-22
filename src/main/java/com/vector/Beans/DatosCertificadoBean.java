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
	private String nombrecertificado;
	@NotNull
	private int iddocumento;
	@NotNull
	private String descripciondoc;
	@NotNull
	private String urldoc;
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

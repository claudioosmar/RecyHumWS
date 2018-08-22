/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosDocumentoBean extends LogBean implements Model{
	@NotNull
	private int iddocumento;
	@NotNull
	private String descripciondoc;
	@NotNull
	private String urldoc;
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

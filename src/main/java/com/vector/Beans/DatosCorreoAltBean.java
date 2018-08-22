/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosCorreoAltBean extends LogBean implements Model{
	@NotNull
	private int idtipocorreo=0;
	@NotNull
	private String Correo="";
	/**
	 * @return the idtipocorreo
	 */
	public int getIdtipocorreo() {
		return idtipocorreo;
	}
	/**
	 * @param idtipocorreo the idtipocorreo to set
	 */
	public void setIdtipocorreo(int idtipocorreo) {
		this.idtipocorreo = idtipocorreo;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return Correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	
}

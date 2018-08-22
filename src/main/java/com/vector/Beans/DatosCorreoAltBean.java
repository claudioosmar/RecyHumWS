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
	private long idpersona=0;
	
	
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

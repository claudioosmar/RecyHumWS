/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */

public class DatosCorreoAltBean {
	@NotNull
	private int idtipocorreo=0;
	@NotNull
	private String correoNw="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private String correoLt="";
	@NotNull
	private String NombreCompleto = "";
	
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return NombreCompleto;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}
	
/**
 * @return the correoLt
 */
public String getCorreoLt() {
	return correoLt;
}
/**
 * @param correoLt the correoLt to set
 */

public void setCorreoLt(String correoLt) {
	this.correoLt = correoLt;
}
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
	 * @return the correoNw
	 */
	public String getCorreoNw() {
		return correoNw;
	}
	/**
	 * @param correoNw the correoNw to set
	 */
	public void setCorreoNw(String correoNw) {
		this.correoNw = correoNw;
	}


	
	

	}	


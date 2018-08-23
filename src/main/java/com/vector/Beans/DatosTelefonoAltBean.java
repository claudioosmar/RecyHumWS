/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class DatosTelefonoAltBean extends LogBean implements Model{
	@NotNull
	private int idtipotelefono=0;
	@NotNull
	private String telefonoNw="";
	@NotNull
	private long idpersona=0;
	@NotNull
	private String telefonoLt;
	@NotNull
	private String NombreCompleto;
	
	
	
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
	 * @return the telefonoLt
	 */
	public String getTelefonoLt() {
		return telefonoLt;
	}
	/**
	 * @param telefonoLt the telefonoLt to set
	 */
	public void setTelefonoLt(String telefonoLt) {
		this.telefonoLt = telefonoLt;
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
	 * @return the idtipotelefono
	 */
	public int getIdtipotelefono() {
		return idtipotelefono;
	}
	/**
	 * @param idtipotelefono the idtipotelefono to set
	 */
	public void setIdtipotelefono(int idtipotelefono) {
		this.idtipotelefono = idtipotelefono;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefonoNw() {
		return telefonoNw;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefonoNw(String telefono) {
		this.telefonoNw = telefono;
	}
	
	
}

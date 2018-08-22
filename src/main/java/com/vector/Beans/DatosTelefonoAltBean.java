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
	private String telefono="";
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
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}

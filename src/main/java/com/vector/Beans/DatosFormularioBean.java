/**
 * 
 */
package com.vector.Beans;

/**
 * @author vectormx
 *
 */
public class DatosFormularioBean {
	private String Nomformulario="";
	private boolean status=false;
	private long idpersona=0;
	
	
	
	/**
	 * @return Obtienes el valor de idpersona
	 */
	
	public long getIdpersona() {
		return idpersona;
	}
	
	/**
	 * @param Agregar el valor a idpersona
	 */
	
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	/**
	 * @return the nomformulario
	 */
	public String getNomformulario() {
		return Nomformulario;
	}
	/**
	 * @param nomformulario the nomformulario to set
	 */
	public void setNomformulario(String nomformulario) {
		Nomformulario = nomformulario;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}

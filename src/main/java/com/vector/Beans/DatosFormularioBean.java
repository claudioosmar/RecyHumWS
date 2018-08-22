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

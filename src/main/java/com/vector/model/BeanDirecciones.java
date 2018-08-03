/**
 * 
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotNull;
/**
 * @author vectormx
 *
 */
@ManagedBean
public class BeanDirecciones {
	@NotNull
	private long iddireccion;
	@NotNull
	private long idcodpost;

	@NotNull
	private String calle;
	@NotNull
	private String colonia;

	private String numinterior;
	
	private String numexterior;
	
	public long getIddireccion() {
		return iddireccion;
	}
	public void setIddireccion(long iddireccion) {
		this.iddireccion = iddireccion;
	}
	
	public long getIdcodpost() {
		return idcodpost;
	}
	public void setIdcodpost(long idcodpost) {
		this.idcodpost = idcodpost;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getNuminterior() {
		return numinterior;
	}
	public void setNuminterior(String numinterior) {
		this.numinterior = numinterior;
	}
	public String getNumexterior() {
		return numexterior;
	}
	public void setNumexterior(String numexterior) {
		this.numexterior = numexterior;
	}
	
	
}

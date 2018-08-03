/**
 * 
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * @author vectormx
 *
 */
@ManagedBean
public class BeanEstado {
	@NotNull
	private long idestado;
	@NotNull
	private String clave;
	@NotNull
	private String nombre;
	@NotNull
	@NotBlank
	private String abrev;
	@NotNull
	private int activo;
	
	public long getIdestado() {
		return idestado;
	}
	public void setIdestado(long idestado) {
		this.idestado = idestado;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbrev() {
		return abrev;
	}
	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}

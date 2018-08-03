/**
 * 
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author vectormx
 *
 */
@ManagedBean
public class BeanMunicipio {
	@NotNull
	private long idmunicipio;
	@NotNull
	private long idestado;
	@NotNull
	private String clave;
	@NotBlank
	@NotNull
	@Size(min = 3, max=50)
	private String nombre;
	@NotNull
	private int activo;
	
	public long getIdmunicipio() {
		return idmunicipio;
	}
	public void setIdmunicipio(long idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
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
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
}

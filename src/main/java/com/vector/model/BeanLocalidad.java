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
public class BeanLocalidad {
	@NotNull
	private long idloclaidad;
	@NotNull
	private long idmunicipio;
	@NotNull
	private String clave;
	@NotBlank
	@NotNull
	private String nombre;
	@NotNull
	private String latitud;
	@NotNull
	private String longitud;
	@NotNull
	private int lat;
	@NotNull
	private int lng;
	@NotNull
	private String altitud;
	@NotNull
	private int activo;
	
	
	public long getIdloclaidad() {
		return idloclaidad;
	}
	public void setIdloclaidad(long idloclaidad) {
		this.idloclaidad = idloclaidad;
	}
	public long getIdmunicipio() {
		return idmunicipio;
	}
	public void setIdmunicipio(long idmunicipio) {
		this.idmunicipio = idmunicipio;
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
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLng() {
		return lng;
	}
	public void setLng(int lng) {
		this.lng = lng;
	}
	public String getAltitud() {
		return altitud;
	}
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
		
}

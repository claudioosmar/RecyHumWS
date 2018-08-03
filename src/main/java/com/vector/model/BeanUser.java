/**
 * Bean para el almacenamiento de usuario
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author vectormx
 *
 */

@ManagedBean
public class BeanUser {
	//@NotNull
	private long iduser;
	//@NotNull
	private int idtipouser;
//	@NotNull
	private long idpersonaalta;
//	@NotNull
	private long idpersona;
	@NotBlank
	@NotEmpty
	@Size(min = 3,max=250)
	private String nombre;
	@NotBlank
	@NotEmpty
	private String contrasena;
//	@NotNull
	private int status;
	@NotBlank
	@NotEmpty
	private String fcreacion;
	@NotBlank
	@NotEmpty
	private String fmodificacion;

	private String observacion;
	
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	public int getIdtipouser() {
		return idtipouser;
	}
	public void setIdtipouser(int idtipouser) {
		this.idtipouser = idtipouser;
	}
	public long getIdpersonaalta() {
		return idpersonaalta;
	}
	public void setIdpersonaalta(long idpersonaalta) {
		this.idpersonaalta = idpersonaalta;
	}
	public long getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getFcreacion() {
		return fcreacion;
	}
	public void setFcreacion(String fcreacion) {
		this.fcreacion = fcreacion;
	}
	public String getFmodificacion() {
		return fmodificacion;
	}
	public void setFmodificacion(String fmodificacion) {
		this.fmodificacion = fmodificacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}

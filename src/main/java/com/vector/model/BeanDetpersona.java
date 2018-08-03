/**
 * Bean para el alamacenamiento de los dettales de persona
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 * @author vectormx
 *
 */
@ManagedBean
public class BeanDetpersona {
	@NotNull
	private long IDDETPERSONA;

	@NotNull
	private long IDPERSONA;

	@NotNull
	private String IDEDOCIVIL;
	@NotNull
	private long iddetpersona;
	@NotNull
	private long iddireccion;
	@NotNull
	private int idestadocivil;
	@NotNull
	private long idpersona;

	@NotNull
	private String nombre;

	private String segnombre;

	@NotNull
	private String apellidop;

	@NotNull
	private String apellidom;

	@NotNull
	private int sexo;

	@NotNull
	@Past
	private String fechanac;

	@NotNull
	private String nacionalidad;

	public long getIddetpersona() {
		return iddetpersona;
	}

	public void setIddetpersona(long iddetpersona) {
		this.iddetpersona = iddetpersona;
	}

	public long getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(long iddireccion) {
		this.iddireccion = iddireccion;
	}

	public long getIdestadocivil() {
		return idestadocivil;
	}

	public void setIdestadocivil(int idestadocivil) {
		this.idestadocivil = idestadocivil;
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

	public String getSegnombre() {
		return segnombre;
	}

	public void setSegnombre(String segnombre) {
		this.segnombre = segnombre;
	}

	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getApellidom() {
		return apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}

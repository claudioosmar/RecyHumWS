/**
 * Bean para el almacenamiento de datos de Personas
 */
package com.vector.model;

import javax.annotation.ManagedBean;
import javax.validation.constraints.NotNull;

/**
 * @author sjflores
 *
 */
@ManagedBean
public class BeanPersona {
	@NotNull
	private long idpersona;
	@NotNull
	private int idarea;
	@NotNull
	private long idestudio;
	@NotNull
	private String numerocontrol;
	@NotNull
	private String urlfoto;
	@NotNull
	private char status;
	@NotNull
	private String resumen;
	@NotNull
	private String objetivolabora;
	@NotNull
	private float sueldo;
	
	public long getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(long idpersona) {
		this.idpersona = idpersona;
	}
	public int getIdarea() {
		return idarea;
	}
	public void setIdarea(int idarea) {
		this.idarea = idarea;
	}
	public long getIdestudio() {
		return idestudio;
	}
	public void setIdestudio(long idestudio) {
		this.idestudio = idestudio;
	}
	public String getNumerocontrol() {
		return numerocontrol;
	}
	public void setNumerocontrol(String numerocontrol) {
		this.numerocontrol = numerocontrol;
	}
	public String getUrlfoto() {
		return urlfoto;
	}
	public void setUrlfoto(String urlfoto) {
		this.urlfoto = urlfoto;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getObjetivolabora() {
		return objetivolabora;
	}
	public void setObjetivolabora(String objetivolabora) {
		this.objetivolabora = objetivolabora;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	
}

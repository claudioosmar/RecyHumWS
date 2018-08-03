package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanEstudios {
	@NotNull
	private long idestudio;
	@NotNull
	private long idgrado;
	@NotNull
	private long carrera;
	@NotNull
	private long idlocalidad;
	@NotNull
	private String instituto;
	@NotNull
	private String peinicial;
	
	private String pefinal;

	public long getIdestudio() {
		return idestudio;
	}

	public void setIdestudio(long idestudio) {
		this.idestudio = idestudio;
	}

	public long getIdgrado() {
		return idgrado;
	}

	public void setIdgrado(long idgrado) {
		this.idgrado = idgrado;
	}

	public long getCarrera() {
		return carrera;
	}

	public void setCarrera(long carrera) {
		this.carrera = carrera;
	}

	public long getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(long idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public String getPeinicial() {
		return peinicial;
	}

	public void setPeinicial(String peinicial) {
		this.peinicial = peinicial;
	}

	public String getPefinal() {
		return pefinal;
	}

	public void setPefinal(String pefinal) {
		this.pefinal = pefinal;
	}

}

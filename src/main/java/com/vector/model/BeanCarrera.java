package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanCarrera {
	
	@NotNull
	private long idcarrera;
	@NotNull
	private String nomcarrera;

	public long getIdcarrera() {
		return idcarrera;
	}

	public void setIdcarrera(long idcarrera) {
		this.idcarrera = idcarrera;
	}

	public String getNomcarrera() {
		return nomcarrera;
	}

	public void setNomcarrera(String nomcarrera) {
		this.nomcarrera = nomcarrera;
	}

}

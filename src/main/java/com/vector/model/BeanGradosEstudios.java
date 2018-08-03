package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanGradosEstudios {
	@NotNull
	private int idagrado;
	@NotNull
	private String nombregrado;

	public int getIdagrado() {
		return idagrado;
	}

	public void setIdagrado(int idagrado) {
		this.idagrado = idagrado;
	}

	public String getNombregrado() {
		return nombregrado;
	}

	public void setNombregrado(String nombregrado) {
		this.nombregrado = nombregrado;
	}

}

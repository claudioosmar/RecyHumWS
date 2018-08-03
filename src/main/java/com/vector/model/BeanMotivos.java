package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanMotivos {
	@NotNull
	private int idmotivo;
	@NotNull
	private String motivo;

	public int getIdmotivo() {
		return idmotivo;
	}

	public void setIdmotivo(int idmotivo) {
		this.idmotivo = idmotivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}

package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanEdocivil {
	@NotNull
	private int idedocivil;
	@NotNull
	private String nombreedo;
	@NotNull
	private char status;

	public int getIdedocivil() {
		return idedocivil;
	}

	public void setIdedocivil(int idedocivil) {
		this.idedocivil = idedocivil;
	}

	public String getNombreedo() {
		return nombreedo;
	}

	public void setNombreedo(String nombreedo) {
		this.nombreedo = nombreedo;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}

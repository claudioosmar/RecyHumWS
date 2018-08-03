package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanOtrosDocs {
	@NotNull
	private int idotrodoc;
	@NotNull
	private String nombredoc;
	@NotNull
	private char status;

	public int getIdotrodoc() {
		return idotrodoc;
	}

	public void setIdotrodoc(int idotrodoc) {
		this.idotrodoc = idotrodoc;
	}

	public String getNombredoc() {
		return nombredoc;
	}

	public void setNombredoc(String nombredoc) {
		this.nombredoc = nombredoc;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}

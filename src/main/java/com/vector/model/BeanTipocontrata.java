package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanTipocontrata {
	@NotNull
	private int idtipocontrata;
	@NotNull
	private String tipocontrata;
	@NotNull
	private char status;

	public int getIdtipocontrata() {
		return idtipocontrata;
	}

	public void setIdtipocontrata(int idtipocontrata) {
		this.idtipocontrata = idtipocontrata;
	}

	public String getTipocontrata() {
		return tipocontrata;
	}

	public void setTipocontrata(String tipocontrata) {
		this.tipocontrata = tipocontrata;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
}

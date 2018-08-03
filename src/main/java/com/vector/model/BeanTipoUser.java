package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanTipoUser {
	@NotNull
	private int idtipouser;
	@NotNull
	private String tipouser;

	public int getIdtipouser() {
		return idtipouser;
	}

	public void setIdtipouser(int idtipouser) {
		this.idtipouser = idtipouser;
	}

	public String getTipouser() {
		return tipouser;
	}

	public void setTipouser(String tipouser) {
		this.tipouser = tipouser;
	}

}

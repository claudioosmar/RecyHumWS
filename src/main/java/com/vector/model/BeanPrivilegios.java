package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanPrivilegios {
	@NotNull
	private int idprivilegio;
	@NotNull
	private String tipoprivilegio;

	public int getIdprivilegio() {
		return idprivilegio;
	}

	public void setIdprivilegio(int idprivilegio) {
		this.idprivilegio = idprivilegio;
	}

	public String getTipoprivilegio() {
		return tipoprivilegio;
	}

	public void setTipoprivilegio(String tipoprivilegio) {
		this.tipoprivilegio = tipoprivilegio;
	}

}

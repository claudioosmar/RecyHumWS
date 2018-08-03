package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanTipoCorreo {
	@NotNull
	private int idtipocorreo;
	@NotNull
	private String tipocorreo;

	public int getIdtipocorreo() {
		return idtipocorreo;
	}

	public void setIdtipocorreo(int idtipocorreo) {
		this.idtipocorreo = idtipocorreo;
	}

	public String getTipocorreo() {
		return tipocorreo;
	}

	public void setTipocorreo(String tipocorreo) {
		this.tipocorreo = tipocorreo;
	}

}

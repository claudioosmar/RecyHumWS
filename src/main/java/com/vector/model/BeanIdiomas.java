package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanIdiomas {
	@NotNull
	private int ididioma;
	@NotNull
	private String nombreidioma;

	public int getIdidioma() {
		return ididioma;
	}

	public void setIdidioma(int ididioma) {
		this.ididioma = ididioma;
	}

	public String getNombreidioma() {
		return nombreidioma;
	}

	public void setNombreidioma(String nombreidioma) {
		this.nombreidioma = nombreidioma;
	}

}

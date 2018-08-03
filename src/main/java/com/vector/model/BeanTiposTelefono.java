package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanTiposTelefono {
	@NotNull
	private int idtipotelefono;
	@NotNull
	private String nombretipo;

	public int getIdtipotelefono() {
		return idtipotelefono;
	}

	public void setIdtipotelefono(int idtipotelefono) {
		this.idtipotelefono = idtipotelefono;
	}

	public String getNombretipo() {
		return nombretipo;
	}

	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}

}

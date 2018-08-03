package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanDocs {
	@NotNull
	private long iddoc;
	@NotNull
	private String nombredoc;
	@NotNull
	private char status;

	public long getIddoc() {
		return iddoc;
	}

	public void setIddoc(long iddoc) {
		this.iddoc = iddoc;
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

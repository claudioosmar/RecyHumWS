package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanCodpos {
	@NotNull
	private long idcodpost;
	@NotNull
	private String codpost;

	public long getIdcodpost() {
		return idcodpost;
	}

	public void setIdcodpost(long idcodpost) {
		this.idcodpost = idcodpost;
	}

	public String getCodpost() {
		return codpost;
	}

	public void setCodpost(String codpost) {
		this.codpost = codpost;
	}

}

package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanCursos {
	@NotNull
	private long idcurso;
	@NotNull
	private String nombre;
	@NotNull
	private String institucion;
	@NotNull
	private String finicio;
	
	private String ftermino;

	public long getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(long idcurso) {
		this.idcurso = idcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getFinicio() {
		return finicio;
	}

	public void setFinicio(String finicio) {
		this.finicio = finicio;
	}

	public String getFtermino() {
		return ftermino;
	}

	public void setFtermino(String ftermino) {
		this.ftermino = ftermino;
	}

}

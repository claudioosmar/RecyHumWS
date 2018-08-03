package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanAcceso {
@NotNull
private long ideuser;
@NotNull
private String token;
@NotNull
private String fechainicio;
@NotNull
private String fechasalida;
@NotNull
private char status;

public long getIdeuser() {
	return ideuser;
}
public void setIdeuser(long ideuser) {
	this.ideuser = ideuser;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getFechainicio() {
	return fechainicio;
}
public void setFechainicio(String fechainicio) {
	this.fechainicio = fechainicio;
}
public String getFechasalida() {
	return fechasalida;
}
public void setFechasalida(String fechasalida) {
	this.fechasalida = fechasalida;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}

}

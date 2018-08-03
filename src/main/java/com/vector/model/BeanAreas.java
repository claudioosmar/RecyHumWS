package com.vector.model;

import javax.validation.constraints.NotNull;

public class BeanAreas {
@NotNull
private int idarea;
@NotNull
private String nombrearea;
@NotNull
private String clavearea;
@NotNull
private char status;

public int getIdarea() {
	return idarea;
}
public void setIdarea(int idarea) {
	this.idarea = idarea;
}
public String getNombrearea() {
	return nombrearea;
}
public void setNombrearea(String nombrearea) {
	this.nombrearea = nombrearea;
}
public String getClavearea() {
	return clavearea;
}
public void setClavearea(String clavearea) {
	this.clavearea = clavearea;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}





}

package com.vector.model;


import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblusers")
@ManagedBean
public class DatosLogin {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_SPRING")
	@SequenceGenerator(name = "SEQUENCE_SPRING", allocationSize = 1, sequenceName = "seq_spring")
	
private long iduser;
	private long idtipo;
	private long idpealta;
	private long idpersona;
	private String fechacreacion;
	private String fechamodificacion;
private String nombre;
private String contraseña;
private char status;



public long getIdtipo() {
	return idtipo;
}
public void setIdtipo(long idtipo) {
	this.idtipo = idtipo;
}
public long getIdpealta() {
	return idpealta;
}
public void setIdpealta(long idpealta) {
	this.idpealta = idpealta;
}
public long getIdpersona() {
	return idpersona;
}
public void setIdpersona(long idpersona) {
	this.idpersona = idpersona;
}
public String getFechacreacion() {
	return fechacreacion;
}
public void setFechacreacion(String fechacreacion) {
	this.fechacreacion = fechacreacion;
}
public String getFechamodificacion() {
	return fechamodificacion;
}
public void setFechamodificacion(String fechamodificacion) {
	this.fechamodificacion = fechamodificacion;
}
public long getIduser() {
	return iduser;
}
public void setIduser(long iduser) {
	this.iduser = iduser;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getContraseña() {
	return contraseña;
}
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}

	
}

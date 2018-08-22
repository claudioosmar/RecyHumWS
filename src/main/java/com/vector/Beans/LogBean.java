/**
 * 
 */
package com.vector.Beans;

import javax.validation.constraints.NotNull;

/**
 * @author vectormx
 *
 */
public class LogBean {
	@NotNull
 private long iduser;
	@NotNull
 private String formulario;
	@NotNull
 private String accion;
	@NotNull
 private String ipequipo;
/**
 * @return the iduser
 */
public long getIduser() {
	return iduser;
}
/**
 * @param iduser the iduser to set
 */
public void setIduser(long iduser) {
	this.iduser = iduser;
}
/**
 * @return the formulario
 */
public String getFormulario() {
	return formulario;
}
/**
 * @param formulario the formulario to set
 */
public void setFormulario(String formulario) {
	this.formulario = formulario;
}
/**
 * @return the accion
 */
public String getAccion() {
	return accion;
}
/**
 * @param accion the accion to set
 */
public void setAccion(String accion) {
	this.accion = accion;
}
/**
 * @return the ipequipo
 */
public String getIpequipo() {
	return ipequipo;
}
/**
 * @param ipequipo the ipequipo to set
 */
public void setIpequipo(String ipequipo) {
	this.ipequipo = ipequipo;
}
 
 
}

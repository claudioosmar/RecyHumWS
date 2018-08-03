package com.vector.model;

import javax.annotation.ManagedBean;

@ManagedBean

public class BeanSupremo {
	
	
	BeanDetpersona beandetallepersona = new BeanDetpersona();
	BeanDirecciones beandirecciones = new BeanDirecciones();
	BeanPersona beanpersona = new BeanPersona();
	BeanDatosLogin Beandatoslogin = new BeanDatosLogin();
	BeanEmpresa Beanempresa = new BeanEmpresa();
	BeanEstado Beanestados = new BeanEstado();
	BeanExpslaborales Beanexplaboral = new BeanExpslaborales();
	BeanMunicipio Beanmunicipio = new BeanMunicipio();
	BeanLocalidad Beanlocalidad = new BeanLocalidad();
	
	public BeanEmpresa getBeanempresa() {
		return Beanempresa;
	}
	public void setBeanempresa(BeanEmpresa beanempresa) {
		Beanempresa = beanempresa;
	}
	public BeanEstado getBeanestados() {
		return Beanestados;
	}
	public void setBeanestados(BeanEstado beanestados) {
		Beanestados = beanestados;
	}
	public BeanExpslaborales getBeanexplaboral() {
		return Beanexplaboral;
	}
	public void setBeanexplaboral(BeanExpslaborales beanexplaboral) {
		Beanexplaboral = beanexplaboral;
	}
	public BeanMunicipio getBeanmunicipio() {
		return Beanmunicipio;
	}
	public void setBeanmunicipio(BeanMunicipio beanmunicipio) {
		Beanmunicipio = beanmunicipio;
	}
	public BeanLocalidad getBeanlocalidad() {
		return Beanlocalidad;
	}
	public void setBeanlocalidad(BeanLocalidad beanlocalidad) {
		Beanlocalidad = beanlocalidad;
	}
	public BeanDetpersona getBeandetallepersona() {
		return beandetallepersona;
	}
	public void setBeandetallepersona(BeanDetpersona beandetallepersona) {
		this.beandetallepersona = beandetallepersona;
	}
	public BeanDirecciones getBeandirecciones() {
		return beandirecciones;
	}
	public void setBeandirecciones(BeanDirecciones beandirecciones) {
		this.beandirecciones = beandirecciones;
	}
	public BeanPersona getBeanpersona() {
		return beanpersona;
	}
	public void setBeanpersona(BeanPersona beanpersona) {
		this.beanpersona = beanpersona;
	}
	public BeanDatosLogin getBeandatoslogin() {
		return Beandatoslogin;
	}
	public void setBeandatoslogin(BeanDatosLogin beandatoslogin) {
		Beandatoslogin = beandatoslogin;
	}
	
	
	

}

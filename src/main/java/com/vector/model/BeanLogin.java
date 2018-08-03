package com.vector.model;

public class BeanLogin {
	
	BeanUser beanuser = new BeanUser();
	BeanTipoUser beantipouser = new BeanTipoUser();
	BeanTipoCorreo beantipocorreo = new BeanTipoCorreo();
	BeanAcceso beanacceso = new BeanAcceso();
	BeanPrivilegios beanprivilegios = new BeanPrivilegios();
	BeanFormularios beanformularios = new BeanFormularios();
	public BeanAcceso getBeanacceso() {
		return beanacceso;
	}
	public void setBeanacceso(BeanAcceso beanacceso) {
		this.beanacceso = beanacceso;
	}
	public BeanPrivilegios getBeanprivilegios() {
		return beanprivilegios;
	}
	public void setBeanprivilegios(BeanPrivilegios beanprivilegios) {
		this.beanprivilegios = beanprivilegios;
	}
	public BeanFormularios getBeanformularios() {
		return beanformularios;
	}
	public void setBeanformularios(BeanFormularios beanformularios) {
		this.beanformularios = beanformularios;
	}
	public BeanUser getBeanuser() {
		return beanuser;
	}
	public void setBeanuser(BeanUser beanuser) {
		this.beanuser = beanuser;
	}
	public BeanTipoUser getBeantipouser() {
		return beantipouser;
	}
	public void setBeantipouser(BeanTipoUser beantipouser) {
		this.beantipouser = beantipouser;
	}
	public BeanTipoCorreo getBeantipocorreo() {
		return beantipocorreo;
	}
	public void setBeantipocorreo(BeanTipoCorreo beantipocorreo) {
		this.beantipocorreo = beantipocorreo;
	}

}

/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
public interface BODatosLogin  {
	//REGRESA UN LISTADO DEL BEAN DE INICIO DE SESION
	List<DatosInicioSesionBean> ListarUsuarios ();
	//REGRESA UN LISTADO DEL BEAN DE FORMULARIO
	List<DatosFormularioBean> VerificarUsuario(DatosInicioSesionBean datos);
	//MENSAJE DE CREACION DE USUARIO QUE REGRESA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean CreateUser(DatosInicioSesionBean datos);
	//MENSAJE DE MODIFICACION DE DATOS DE INICIO DE SESION QUE REGRESA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosInicioSesionBean datos);
	//MENSAJE DE ELIMINACION DE DATOS DEL INICIO DE SESION QUE REGRESA UN MENSADE DE LA CLASE MSGBEAN
	MsgBean Eliminar(long id);
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL BEAN INICIO DE SESION
	DatosInicioSesionBean Buscar(DatosInicioSesionBean datos);
	
}

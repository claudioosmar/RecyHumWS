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
	List<DatosInicioSesionBean> ListarUsuarios ();
	List<DatosFormularioBean> VerificarUsuario(DatosInicioSesionBean datos);
	MsgBean CreateUser(DatosInicioSesionBean datos);
	
}

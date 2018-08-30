/**
 * 
 */
package com.vector.BO;

import java.util.List;

import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.MsgBean;

/**
 * @author vectormx
 *
 */
//INTERFAZ PARA EL BO DE DATOS CERTIFICADO
public interface BODatosCertificado {
	//MENSAJE DE CREACION DE LOS DATOS DEL APARTADO DE CERTIFICADO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Crear(List<DatosCertificadoBean> datos);
	//MENSAJE DE MODIFICACION DE LOS DATOS DEL APARTADO DE CERTIFICADO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Modificar(DatosCertificadoBean datos);
	//MENSAJE DE ELIMINACION DE LOS DATOS DEL APARTADO DE CERTIFICADO QUE RETORNA UN MENSAJE DE LA CLASE MSGBEAN
	MsgBean Eliminar(DatosCertificadoBean datos);
	//REGRESA UNA BUSQUEDA DE LOS DATOS DEL APARTADO DE CERTIFICADO
	List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos);
	//REGRESA UN LISTADO DE LOS DATOS DEL APARTADO CERTIFICADO 
	List<DatosCertificadoBean> Listar();
}

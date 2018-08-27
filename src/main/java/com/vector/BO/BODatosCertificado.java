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
public interface BODatosCertificado {
	MsgBean Crear(List<DatosCertificadoBean> datos);
	MsgBean Modificar(DatosCertificadoBean datos);
	MsgBean Eliminar(int id);
	DatosCertificadoBean Buscar(DatosCertificadoBean datos);
	List<DatosCertificadoBean> Listar(int id);
}

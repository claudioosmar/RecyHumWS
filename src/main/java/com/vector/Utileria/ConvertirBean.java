/**
 * 
 */
package com.vector.Utileria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vector.Beans.InicioSesionBean;

/**
 * @author vectormx
 *
 */
@Service
public class ConvertirBean {

	public List<InicioSesionBean> InicioSesion(ResultSet rs) {
		List<InicioSesionBean> retorno = new ArrayList<InicioSesionBean>();
		InicioSesionBean datos = new InicioSesionBean();
		try {
		while(rs.next()) {
			datos.setID_User((Long)(rs.getObject("iduser")));
			datos.setUsuario((String)(rs.getObject("nombre")));
			datos.setStatus((String)(rs.getObject("status")));
			datos.setIdtipouser((int)(rs.getObject("idtipouser")));
			retorno.add(datos);
		}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return retorno;
	}
	
}

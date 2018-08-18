/**
 * 
 */
package com.vector.Utileria;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vector.Beans.InicioSesionBean;
import com.vector.Beans.Model;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

/**
 * @author vectormx
 *
 */

public class ConvertirBean2 {
	
}
class ConvertirBeans implements RowMapper<Model>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public InicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		InicioSesionBean user = new InicioSesionBean();
		user.setID_User(rs.getInt("iduser"));
		//user.setIP(rs.getInt("ip"));
		user.setUsuario(rs.getString("nombre"));
		//user.setContra(rs.getString(""));
		user.setStatus(rs.getString("status"));
		//user.setToken(rs.getString("token"));
		//user.setFormulario_accion(rs.getString("formulario"));
		//user.setMovimiento(rs.getString("movimiento"));
		user.setIdtipouser(rs.getInt("idtipouser"));
		return user;
	}

	
}

 class ConvertirSesion implements RowMapper<InicioSesionBean> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
 @Override
	public InicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
		InicioSesionBean user = new InicioSesionBean();
		user.setID_User(rs.getInt("iduser"));
		//user.setIP(rs.getInt("ip"));
		user.setUsuario(rs.getString("nombre"));
		//user.setContra(rs.getString(""));
		user.setStatus(rs.getString("status"));
		//user.setToken(rs.getString("token"));
		//user.setFormulario_accion(rs.getString("formulario"));
		//user.setMovimiento(rs.getString("movimiento"));
		user.setIdtipouser(rs.getInt("idtipouser"));
		return user;
	}
}
class ConvertirDatos implements RowMapper<DatosPersonalesBean>{

/* (non-Javadoc)
 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
 */
@Override
public DatosPersonalesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
	// TODO Auto-generated method stub
	DatosPersonalesBean datos = new DatosPersonalesBean();
	datos.setIdp(rs.getLong("IDP"));
	datos.setNombre(rs.getString("NOMBREPERSONA"));
	datos.setSegnombre(rs.getString("SEGUNDONOMBRE"));
	datos.setApellidop(rs.getString("APELLIDOPATERNO"));
	datos.setApellidom(rs.getString("APELLIDOMATERNO"));
	datos.setSexo(rs.getString("SEXO"));
	datos.setFechanac(rs.getString("FECHANACIMIENTO"));
	datos.setNacionalidad(rs.getString("NACIONALIDAD"));
	datos.setResumen(rs.getString("RESUMEN"));
	datos.setObjlaboral(rs.getString("OBJETIVOLABORAL"));
	datos.setSueldo(rs.getString("SUELDO"));
	datos.setNcontrol(rs.getString("NUMEROCONTROL"));
	datos.setEstadoCivil(rs.getString("ESTADOCIVIL"));
	datos.setStatus(rs.getString("STATUS"));
	datos.setNombrearea(rs.getString("NOMBREAREA"));
	datos.setTelefono(rs.getString("TELEFONO"));
	datos.setCorreo(rs.getString("CORREO"));
	datos.setTipocorreo(rs.getString("TIPOCORREO"));
	datos.setNombredocumento(rs.getString("NOMBREDOCUMENTO"));
	datos.setNombreherramienta(rs.getString("NOMBREHERRAMIENTA"));
	datos.setVersionherramienta(rs.getString("VERSIONHERRAMIENTA"));
	datos.setPorcentaje(rs.getString("PORCENTAJECONECERLA"));
	datos.setAñosexp(rs.getInt("AÑOSEXPERIENCIA"));
	datos.setEstado(rs.getString("NOMBREESTADO"));
	datos.setMunicipio(rs.getString("NOMBREMUNICIPIO"));
	datos.setLocalidad(rs.getString("LOCALIDAD"));
	datos.setCodpostal(rs.getString("CODIGOPOSTAL"));
	datos.setCalle(rs.getString("CALLE"));
	datos.setColonia(rs.getString("COLONIA"));
	datos.setNuminter(rs.getString("NUMEROINTERIOR"));
	datos.setNumext(rs.getString("NUMEROEXTERIOR"));
	return datos;
}

}
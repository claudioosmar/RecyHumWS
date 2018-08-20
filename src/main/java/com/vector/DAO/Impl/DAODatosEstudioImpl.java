/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.InicioSesionBean;
import com.vector.DAO.DAODatosEstudio;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosEstudioImpl implements DAODatosEstudio {
	@Autowired
	private JdbcTemplate jdbctemplate;

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Crear(com.vector.Beans.DatosEstudioBean)
	 */

	@Transactional(readOnly = true)
	public int Crear(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		
		final String sql = "begin sp_agregareducacion(?,?,?,?,?,?,?,?,?,?,?); end;";
		int respuesta = jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setLong(5, datos.getIdpersona());
				ps.setString(6, datos.getNombrecorrera());
				ps.setInt(7, datos.getIdgrado());
				ps.setInt(8, datos.getIdlocalidad());
				ps.setString(9, datos.getInstitutoestudio());
				ps.setString(10, datos.getPeriodoinicial());
				ps.setString(11, datos.getPeriodofinal());
			
				
				return ps;
			}
		});
		return respuesta;
	}
	

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public String Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Eliminar(int)
	 */
	@Override
	public String Eliminar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Buscar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public DatosEstudioBean Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Listar()
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

class CrearRowMapper implements RowMapper<InicioSesionBean> {
	@Override
	public InicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		InicioSesionBean user = new InicioSesionBean();
		user.setID_User(rs.getInt(1));
		user.setIP(rs.getString(4));
		user.setUsuario(rs.getString(2));
		user.setContra("unsigned");
		user.setStatus(rs.getString(8));
		user.setToken(rs.getString(3));
		user.setFormulario_accion(rs.getString(5));
		user.setMovimiento(rs.getString(7));
		user.setIdtipouser(rs.getInt(6));
		return user;
	}
}

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

import com.vector.Beans.InicioSesionBean;
import com.vector.Beans.Model;
import com.vector.DAO.DAOSesion;
import com.vector.Utileria.*;

/**
 * @author vectormx
 *
 */
@Service
public class DAOSesionImpl implements DAOSesion {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Encriptarsha1 encripa;
	private String resp;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Create(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Create(InicioSesionBean datos) {
		final String sql = "begin sp_agregaruser(?,?,?,?,?,?,?,?,?,?,?); end;";
		datos.setContraseña(encripa.Encriptar(datos.getContraseña()));
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdtipouser());
				ps.setLong(6, datos.getIdpersonaalta());
				ps.setString(7, datos.getContraseña());
				ps.setString(8, datos.getObservacion());
				ps.setLong(9, datos.getIdpersona());							
				return ps;
			}
		});
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Delete(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public String Delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Buscar(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public Model Buscar(InicioSesionBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Listar(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<InicioSesionBean> Listar() {
		// TODO Auto-generated method stub

		final String sql = "select * from view_usuario";
		return jdbcTemplate.query(sql, new SesionRowMapper());
	
		/*jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				sesion=convert.InicioSesion(ps.executeQuery());
				return ps;
			}
		});
		return sesion;*/
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.SesionDAO#VerificarLogin(com.vector.Beans.InicioSesionBean)
	 */
	@Override
	public String VerificarLogin(InicioSesionBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select fverificar_login(?,?) from dual";
		datos.setContraseña(encripa.Encriptar(datos.getContraseña()));
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getUsuario());
				ps.setString(2, datos.getContraseña());
				ResultSet rs = ps.executeQuery();
				rs.next();
				resp=(rs.getString(1));
				return ps;
			}
		});
		return resp;
		
	

}
}

class SesionRowMapper implements RowMapper<InicioSesionBean> {
	@Override
	public InicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		InicioSesionBean user = new InicioSesionBean();
		user.setIduser(0);
		user.setFormulario("unsigned");
		user.setAccion("unsigned");
		user.setIdpersona(0);
		user.setIdpersonaalta(0);
		user.setObservacion("unsigned");
		user.setID_User(rs.getInt(1));
		user.setIP(rs.getString(4));
		user.setUsuario(rs.getString(2));
		user.setContraseña("unsigned");
		user.setStatus(rs.getString(7));
		user.setToken(rs.getString(3));
		user.setMovimiento(rs.getString(6));
		user.setIdtipouser(rs.getInt(5));
		return user;
	}
}

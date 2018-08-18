/**
 * 
 */
package com.vector.DAO.Impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
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
	public String Create(InicioSesionBean datos) {
		// TODO Auto-generated method stub
		return null;
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
	
	
		final String sql = "select * from view_acceso";
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
		InicioSesionBean bean = new InicioSesionBean();
		final String sql = "select fverificar_login(?,?) from dual";
		datos.setContra(encripa.Encriptar(datos.getContra()));
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getUsuario());
				ps.setString(2, datos.getContra());
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

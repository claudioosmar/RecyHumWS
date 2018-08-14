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

/**
 * @author vectormx
 *
 */
@Service
public class DAOSesionImpl implements DAOSesion {
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		return jdbcTemplate.query("select * from tblusers", new SesionRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.SesionDAO#VerificarLogin(com.vector.Beans.InicioSesionBean)
	 */
	@Override
	public String VerificarLogin(InicioSesionBean datos) {
		// TODO Auto-generated method stub
		InicioSesionBean bean = new InicioSesionBean();
		final String sql = "select fverificar_login(?,?) from dual";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getUsuario());
				ps.setString(2, datos.getContra());
				ResultSet rs = ps.executeQuery();
				rs.next();
				bean.setResp(rs.getString(1));
				return ps;
			}
		});
		return bean.getResp();
		
	

}
}

class SesionRowMapper implements RowMapper<InicioSesionBean> {
	@Override
	public InicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
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

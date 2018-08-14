/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.BeanInicioSesion;
import com.vector.Beans.Model;
import com.vector.DAO.SesionDAO;

/**
 * @author vectormx
 *
 */
@Service
public class SesionDAOImpl implements SesionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Create(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public String Create(BeanInicioSesion datos) {
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
	public Model Buscar(BeanInicioSesion datos) {
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
	public List<BeanInicioSesion> Listar() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from tblusers", new SesionRowMapper());
	}

}

class SesionRowMapper implements RowMapper<BeanInicioSesion> {
	@Override
	public BeanInicioSesion mapRow(ResultSet rs, int rowNum) throws SQLException {
		BeanInicioSesion user = new BeanInicioSesion();
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

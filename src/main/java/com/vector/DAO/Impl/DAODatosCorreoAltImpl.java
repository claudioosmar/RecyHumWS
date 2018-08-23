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

import com.vector.Beans.DatosCorreoAltBean;
import com.vector.Beans.DatosFormularioBean;
import com.vector.DAO.DAODatosCorreoAlt;
import com.vector.Utileria.Encriptarsha1;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosCorreoAltImpl implements DAODatosCorreoAlt {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Crear(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public int Crear(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregarcorreoalt(?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdtipocorreo());
				ps.setString(6, datos.getCorreo());
				
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Modificar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public int Modificar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarcorreoalt(?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setLong(5, datos.getIdpersona());
				ps.setInt(6, datos.getIdtipocorreo());
				ps.setString(7, datos.getCorreo());
				
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Buscar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public DatosCorreoAltBean Buscar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql = "indefinido";
		DatosCorreoAltBean respuesta = new DatosCorreoAltBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ResultSet rs = ps.executeQuery();
				respuesta.setCorreo(rs.getString(3));
				respuesta.setIdtipocorreo(rs.getInt(2));
				return ps;
			}
		});
		return respuesta;
	}
	

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Listar()
	 */
	@Override
	public List<DatosCorreoAltBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv02";
		return jdbcTemplate.query(sql, new CorreosRowMapper());
	}

}
class CorreosRowMapper implements RowMapper<DatosCorreoAltBean>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DatosCorreoAltBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosCorreoAltBean retorno= new DatosCorreoAltBean();
		retorno.setCorreo(rs.getString(3));
		retorno.setIdtipocorreo(rs.getInt(2));
		return retorno;
	}
	
}

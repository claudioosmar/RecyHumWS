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

import com.vector.Beans.DatosCertificadoBean;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosCertificado;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosCertificadoImpl implements DAODatosCertificado {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Crear(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregarcertificado(?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setString(5, datos.getNombrecertificado());
				ps.setInt(6, datos.getIddocumento());
				ps.setString(7, datos.getDescripciondoc());
				ps.setString(8, datos.getUrldoc());
				
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Modificar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarcertificado(?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setString(5, datos.getDescripciondoc());
				ps.setInt(6, datos.getIddocumento());
				ps.setString(7, datos.getUrldoc());
				ps.setString(8, datos.getNombrecertificado());
				ps.setLong(9, datos.getIdpersona());
				ps.setLong(10, datos.getIdcertificado());
				
				
				
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Buscar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public DatosCertificadoBean Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Listar()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosCertificadoBean> Listar() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from datospersonales", new DatPerRowMapper());
	}
	
	class DatPerRowMapper implements RowMapper<DatosCertificadoBean> {
		@Override
		public DatosCertificadoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DatosCertificadoBean datos = new DatosCertificadoBean();
			DatosPersonalesBean datos2 = new DatosPersonalesBean();
			datos2.setIdpersona(rs.getLong(1));
			datos2.setNombrepersona(rs.getString(2));
			datos2.setSegundonombre(rs.getString(3));
			datos2.setApellidopaterno(rs.getString(4));
			datos2.setApellidomaterno(rs.getString(5));
			datos.setNombrecertificado(rs.getString(6));
			datos.setIddocumento(rs.getInt(7));
			datos.setDescripciondoc(rs.getString(8));
			datos.setUrldoc(rs.getString(9));
			

			return datos;
		}
	}

}

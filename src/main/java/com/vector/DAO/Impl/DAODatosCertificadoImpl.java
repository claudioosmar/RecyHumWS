/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.vector.Beans.DatosCertificadoBean;
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
	public int Modificar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarcertificado(?,?,?,?,?,?,?,?)";		
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
	 * @see com.vector.DAO.DAODatosCertificado#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Buscar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	public DatosCertificadoBean Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Listar()
	 */
	@Override
	public List<DatosCertificadoBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

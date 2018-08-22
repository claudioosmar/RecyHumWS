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

import com.vector.Beans.DatosTelefonoAltBean;
import com.vector.DAO.DAODatosTelefonoAlt;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosTelefonoAltImpl implements DAODatosTelefonoAlt {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Crear(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public int Crear(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregartelefonoalt(?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdtipotelefono());
				ps.setString(6, datos.getTelefono());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Modificar(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public int Modificar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificartelefonoalt(?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdtipotelefono());
				ps.setString(6, datos.getTelefono());
				ps.setLong(7, datos.getIdpersona());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Buscar(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Listar()
	 */
	@Override
	public List<DatosTelefonoAltBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

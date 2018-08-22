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

import com.vector.Beans.DatosHerramientasBean;
import com.vector.DAO.DAODatosHerramientas;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosHerramientasImpl implements DAODatosHerramientas {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientas#Crear(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public int Crear(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregarHerramienta(?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdherramienta());
				ps.setInt(6, datos.getPorcentajeherra());
				ps.setInt(7,datos.getAñosexpherra());
				ps.setString(8, datos.getDescripcionherra());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientas#Modificar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public int Modificar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarHerramienta(?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdherramienta());
				ps.setInt(6, datos.getPorcentajeherra());
				ps.setInt(7,datos.getAñosexpherra());
				ps.setString(8, datos.getDescripcionherra());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientas#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientas#Buscar(com.vector.Beans.DatosHerramientasBean)
	 */
	@Override
	public DatosHerramientasBean Buscar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientas#Listar()
	 */
	@Override
	public List<DatosHerramientasBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

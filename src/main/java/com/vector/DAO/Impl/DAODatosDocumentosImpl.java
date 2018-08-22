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

import com.vector.Beans.DatosDocumentoBean;
import com.vector.DAO.DAODatosDocumento;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosDocumentosImpl implements DAODatosDocumento {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosDocumento#Crear(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public int Crear(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregardocumento(?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIddocumento());
				ps.setString(6, datos.getDescripciondoc());
				ps.setString(7,datos.getUrldoc());
				
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosDocumento#Modificar(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public int Modificar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificardocumento(?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIddocumento());
				ps.setString(6, datos.getDescripciondoc());
				ps.setString(7,datos.getUrldoc());

				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosDocumento#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosDocumento#Buscar(com.vector.Beans.DatosDocumentoBean)
	 */
	@Override
	public DatosDocumentoBean Buscar(DatosDocumentoBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosDocumento#Listar()
	 */
	@Override
	public List<DatosDocumentoBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

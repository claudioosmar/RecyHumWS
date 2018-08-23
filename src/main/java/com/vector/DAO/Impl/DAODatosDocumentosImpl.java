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
		final String sql="execute sp_modificardocumento(?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setString(5, datos.getDescripciondoc());
				ps.setString(6,datos.getUrldoc());
				ps.setLong(7, datos.getIdpersona());
				ps.setInt(8, datos.getIddocumento());
			

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
		final String sql = "indefinido";
		DatosDocumentoBean respuesta = new DatosDocumentoBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ResultSet rs = ps.executeQuery();
				respuesta.setIddocumento(rs.getInt(2));
				respuesta.setDescripciondoc(rs.getString(3));
				respuesta.setUrldoc(rs.getString(4));
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosDocumento#Listar()
	 */
	@Override
	public List<DatosDocumentoBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv03";
		return jdbcTemplate.query(sql, new DocRowMapper());
	}

}
class DocRowMapper implements RowMapper<DatosDocumentoBean>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DatosDocumentoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosDocumentoBean retorno= new DatosDocumentoBean();
		retorno.setIddocumento(rs.getInt(2));
		retorno.setDescripciondoc(rs.getString(3));
		retorno.setUrldoc(rs.getString(4));
		return retorno;
	}
	
}

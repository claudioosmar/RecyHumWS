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

import com.vector.Beans.DatosHerramientasBean;
import com.vector.Beans.DatosIdiomasBean;
import com.vector.DAO.DAODatosIdiomas;


/**
 * @author vectormx
 *
 */
@Service
public class DAODatosIdiomasImpl implements DAODatosIdiomas {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Crear(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "begin sp_agregaridioma(?,?,?,?,?,?,?,?,?,?,?); end;";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setLong(5, datos.getIdpersona());	
				ps.setInt(6, datos.getIdidioma());
				ps.setInt(7, datos.getPcjescrito());
				ps.setInt(8, datos.getPcjhablado());
				ps.setInt(9, datos.getPcjentendido());
				ps.setString(10, datos.getDescripciondominio());
				ps.setString(11, datos.getIdiomanativa());
							
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Modificar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "begin sp_modificaridioma(?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setLong(5, datos.getIdpersona());		
				ps.setInt(6, datos.getPcjescrito());
				ps.setInt(7, datos.getPcjhablado());
				ps.setInt(8, datos.getPcjentendido());
				ps.setString(9, datos.getDescripciondominio());
				ps.setString(10, datos.getIdiomanativa());
				ps.setLong(11, datos.getIdpersona());
				ps.setInt(12, datos.getIdidioma());
				ps.setInt(13, datos.getIddominio());
							
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Buscar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	public DatosIdiomasBean Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "indefinido";
		DatosIdiomasBean respuesta = new DatosIdiomasBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ResultSet rs = ps.executeQuery();
				respuesta.setIdidioma(rs.getInt(1));
				respuesta.setIdiomanativa(rs.getString(2));
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Listar()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosIdiomasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tbldominios";
		return jdbcTemplate.query(sql, new IdiomaRowMapper());
		
	}
	
	class IdiomaRowMapper implements RowMapper<DatosIdiomasBean> {
		@Override
		public DatosIdiomasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DatosIdiomasBean idioma = new DatosIdiomasBean();

			return idioma;
		}

	}
}

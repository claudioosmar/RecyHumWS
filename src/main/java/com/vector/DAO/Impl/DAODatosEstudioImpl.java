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

import com.vector.Beans.DatosDocumentoBean;
import com.vector.Beans.DatosEstudioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.DAO.DAODatosEstudio;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosEstudioImpl implements DAODatosEstudio {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Crear(com.vector.Beans.DatosEstudioBean)
	 */

	@Transactional(readOnly = true)
	public int Crear(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		
		final String sql = "begin sp_agregareducacion(?,?,?,?,?,?,?,?,?,?,?); end;";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setLong(5, datos.getIdpersona());
				ps.setString(6, datos.getNombrecorrera());
				ps.setInt(7, datos.getIdgrado());
				ps.setInt(8, datos.getIdlocalidad());
				ps.setString(9, datos.getInstitutoestudio());
				ps.setString(10, datos.getPeriodoinicial());
				ps.setString(11, datos.getPeriodofinal());
			
				
				return ps;
			}
		});
		return respuesta;
	}
	

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		final String sql = "begin sp_modificareducacion(?,?,?,?,?,?,?,?,?,?,?,?,?); end;";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setLong(5, datos.getIdpersona());
				ps.setInt(6, datos.getIdcarrera());
				ps.setString(7, datos.getNombrecorrera());
				ps.setInt(8, datos.getIdgrado());
				ps.setInt(9, datos.getIdlocalidad());
				ps.setLong(10, datos.getIdestudio());
				ps.setString(11, datos.getInstitutoestudio());
				ps.setString(12, datos.getPeriodoinicial());
				ps.setString(13, datos.getPeriodofinal());
			
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Buscar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public DatosEstudioBean Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		final String sql = "indefinido";
		DatosEstudioBean respuesta = new DatosEstudioBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ResultSet rs = ps.executeQuery();
				respuesta.setIdestudio(rs.getLong(1));
				respuesta.setIdgrado(rs.getInt(2));
				respuesta.setIdcarrera(rs.getInt(3));
				respuesta.setIdlocalidad(rs.getInt(4));
				respuesta.setInstitutoestudio(rs.getString(5));
				respuesta.setPeriodoinicial(rs.getString(6));
				respuesta.setPeriodofinal(rs.getString(7));
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Listar()
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblestudios";
		return jdbcTemplate.query(sql, new EstudioRowMapper());
	}

}

class EstudioRowMapper implements RowMapper<DatosEstudioBean> {
	@Override
	public DatosEstudioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosEstudioBean respuesta = new DatosEstudioBean();
		respuesta.setIdestudio(rs.getLong(1));
		respuesta.setIdgrado(rs.getInt(2));
		respuesta.setIdcarrera(rs.getInt(3));
		respuesta.setIdlocalidad(rs.getInt(4));
		respuesta.setInstitutoestudio(rs.getString(5));
		respuesta.setPeriodoinicial(rs.getString(6));
		respuesta.setPeriodofinal(rs.getString(7));
		return respuesta;
	}
}

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

import com.vector.Beans.DatosIdiomasBean;
import com.vector.Beans.DatosLaboralesBean;
import com.vector.DAO.DAODatosLaborales;
import com.vector.DAO.Impl.DAODatosIdiomasImpl.IdiomaRowMapper;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosLaboralesImpl implements DAODatosLaborales {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Crear(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public int Crear(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregarexplaboral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdmotivotermino());
				ps.setString(6, datos.getPuesto());
				ps.setString(7,datos.getFechainicioexp());
				ps.setString(8,datos.getFechafinalexp());
				ps.setString(9,datos.getActividadesreal());
				ps.setString(10,datos.getLogros());
				ps.setInt(11,datos.getIdtipocontrato());
				ps.setString(12,datos.getDescripcionexp());
				ps.setString(13,datos.getNombreempresa());
				ps.setLong(14,datos.getIdpersona());
				ps.setInt(15,datos.getIdherramienta());
				ps.setInt(16,datos.getPorsentajeherra());
				ps.setInt(17,datos.getAñosexp());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Modificar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public int Modificar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarexplaboral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdmotivotermino());
				ps.setString(6, datos.getPuesto());
				ps.setString(7,datos.getFechainicioexp());
				ps.setString(8,datos.getFechafinalexp());
				ps.setString(9,datos.getActividadesreal());
				ps.setString(10,datos.getLogros());
				ps.setInt(11,datos.getIdtipocontrato());
				ps.setString(12,datos.getDescripcionexp());
				ps.setString(13,datos.getNombreempresa());
				ps.setLong(14,datos.getIdpersona());
				ps.setInt(15,datos.getIdherramienta());
				ps.setInt(16,datos.getPorsentajeherra());
				ps.setInt(17,datos.getAñosexp());
				ps.setString(18, datos.getDescripcionherrm());
				ps.setInt(19, datos.getIddescmotivo());
				ps.setInt(20, datos.getIdexplaborl());
				ps.setInt(21, datos.getIdempresa());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Buscar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public DatosLaboralesBean Buscar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql = "indefinido";
		DatosLaboralesBean respuesta = new DatosLaboralesBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ResultSet rs = ps.executeQuery();
				respuesta.setIdexplaborl(rs.getInt(1));
				respuesta.setIdmotivotermino(rs.getInt(2));
				respuesta.setIdempresa(rs.getInt(3));
				respuesta.setPuesto(rs.getString(4));
				respuesta.setFechainicioexp(rs.getString(5));
				respuesta.setFechafinalexp(rs.getString(6));
				respuesta.setActividadesreal(rs.getString(7));
				respuesta.setLogros(rs.getString(8));
				respuesta.setIdtipocontrato(rs.getInt(9));
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Listar()
	 */
	@Override
	public List<DatosLaboralesBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblexpslaborales";
		return jdbcTemplate.query(sql, new labRowMapper());
	}
}class labRowMapper implements RowMapper<DatosLaboralesBean> {
	@Override
	public DatosLaboralesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosLaboralesBean respuesta = new DatosLaboralesBean();
		respuesta.setIdexplaborl(rs.getInt(1));
		respuesta.setIdmotivotermino(rs.getInt(2));
		respuesta.setIdempresa(rs.getInt(3));
		respuesta.setPuesto(rs.getString(4));
		respuesta.setFechainicioexp(rs.getString(5));
		respuesta.setFechafinalexp(rs.getString(6));
		respuesta.setActividadesreal(rs.getString(7));
		respuesta.setLogros(rs.getString(8));
		respuesta.setIdtipocontrato(rs.getInt(9));

		return respuesta;
	}

}



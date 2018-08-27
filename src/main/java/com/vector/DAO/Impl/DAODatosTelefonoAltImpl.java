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
		final String sql="INSERT INTO TBLPIV01 VALUES(?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ps.setInt(2, datos.getIdtipotelefono());
				ps.setString(3, datos.getTelefonoNw());
				
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
		final String sql="update tblpiv01 set telefono = (?), idtipotelefono =(?) where telefono = (?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(2, datos.getIdtipotelefono());
				ps.setString(1, datos.getTelefonoNw());
				ps.setString(3, datos.getTelefonoLt());
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Eliminar(int)
	 */
	@Override
	public int Eliminar(String id) {
		// TODO Auto-generated method stub
		final String sql="delete tblpiv01 where telefono = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, id);
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Buscar(com.vector.Beans.DatosTelefonoAltBean)
	 */
	@Override
	public DatosTelefonoAltBean Buscar(DatosTelefonoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="select * from tblpiv01 where telefono = (?)";
		DatosTelefonoAltBean respuesta = new DatosTelefonoAltBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getTelefonoNw());
				ResultSet rs = ps.executeQuery();
				rs.next();
				respuesta.setIdtipotelefono(rs.getInt(2));
				respuesta.setIdpersona(rs.getLong(1));
				PreparedStatement ps1 = con.prepareStatement("select * from tbldetspersonas where idpersona = (?)");
				ps1.setLong(1, respuesta.getIdpersona());
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				respuesta.setNombreCompleto(rs1.getString("nombre")+" "+rs1.getString("segnombre")+" "+rs1.getString("apellidop")+" "+rs1.getString("apellidom"));
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosTelefonoAlt#Listar()
	 */
	@Override
	public List<DatosTelefonoAltBean> Listar(long id) {
		// TODO Auto-generated method stub
		final String sql="select * from tblpiv01 where idpersona = '"+id+"'";
		System.out.println(sql);
		return jdbcTemplate.query(sql, new telefonoRowMapper());
	}

}
class telefonoRowMapper implements RowMapper<DatosTelefonoAltBean>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DatosTelefonoAltBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosTelefonoAltBean respuesta = new DatosTelefonoAltBean();
		respuesta.setTelefonoNw(rs.getString(3));
		respuesta.setIdtipotelefono(rs.getInt(2));
		return respuesta;
	}
	
}


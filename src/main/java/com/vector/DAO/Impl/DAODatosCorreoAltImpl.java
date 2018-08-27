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
import com.vector.DAO.DAODatosCorreoAlt;



/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
@Service
public class DAODatosCorreoAltImpl implements DAODatosCorreoAlt {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Crear(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public int Crear(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		
		final String sql="INSERT INTO TBLPIV02 VALUES(?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ps.setInt(2, datos.getIdtipocorreo());
				ps.setString(3, datos.getCorreoNw());
				
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Modificar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public int Modificar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="update tblpiv02 set correo = (?), idtipocorreo =(?) where correo= (?)";		
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(2, datos.getIdtipocorreo());
				ps.setString(1, datos.getCorreoNw());
				ps.setString(3, datos.getCorreoLt());
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Eliminar(int)
	 */
	@Override
	public int Eliminar(String id) {
		// TODO Auto-generated method stub
final String sql="delete tblpiv02 where correo = (?)";
		
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
	 * @see com.vector.DAO.DAODatosCorreoAlt#Buscar(com.vector.Beans.DatosCorreoAltBean)
	 */
	@Override
	public DatosCorreoAltBean Buscar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
		final String sql="select * from tblpiv02 where correo  = (?)";
		DatosCorreoAltBean respuesta = new DatosCorreoAltBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getCorreoNw());
				ResultSet rs = ps.executeQuery();
				rs.next();
				respuesta.setIdtipocorreo(rs.getInt(2));
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
	 * @see com.vector.DAO.DAODatosCorreoAlt#Listar()
	 */
	@Override
	public List<DatosCorreoAltBean> Listar(long id) {
		// TODO Auto-generated method stub
		final String sql="select * from tblpiv02 where idpersona = '"+id+"'";
		System.out.println(sql);
		return jdbcTemplate.query(sql, new CorreosRowMapper());
	}

}
class CorreosRowMapper implements RowMapper<DatosCorreoAltBean>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DatosCorreoAltBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosCorreoAltBean retorno= new DatosCorreoAltBean();
		retorno.setCorreoNw(rs.getString(3));
		retorno.setIdtipocorreo(rs.getInt(2));
		return retorno;
	}
	
}

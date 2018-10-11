/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.vector.Beans.DatosCorreoAltBean;
import com.vector.DAO.DAODatosCorreoAlt;
import com.vector.Utileria.Log;



/**
 * @author JESUS ALEJANDRO CARRILLO SANCHEZ
 *
 */
@Service
public class DAODatosCorreoAltImpl extends Log implements DAODatosCorreoAlt {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	List<DatosCorreoAltBean> datos ;
	
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
				//INSERCION EN LA TABLA PIVOTE 02
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"],IDTIPOCORREO["+datos.getIdtipocorreo()+"],CORREONW"+datos.getCorreoNw()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ps.setInt(2, datos.getIdtipocorreo());
				ps.setString(3, datos.getCorreoNw());
				info("ejecucion del sql insert: "+sql);
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
		final String sql="update tblpiv02 set correo = (?), idtipocorreo =(?) where correo= (?) and idpersona = (?)";		
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//MODIFICICACION DE LSO DATOS EN LA TABLA PIVOTE 02
				debug("datos de entrada para el sql: IDPERSONA["+datos.getIdpersona()+"],IDTIPOCORREO["+datos.getIdtipocorreo()+"],CORREONW["+datos.getCorreoNw()+"],CORREOLT["+datos.getCorreoLt()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(2, datos.getIdtipocorreo());
				ps.setString(1, datos.getCorreoNw());
				ps.setString(3, datos.getCorreoLt());
				ps.setLong(4, datos.getIdpersona());
				info("ejecucion de la sentencia sql update: "+sql);
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCorreoAlt#Eliminar(int)
	 */
	@Override
	public int Eliminar(DatosCorreoAltBean datos) {
		// TODO Auto-generated method stub
final String sql="delete tblpiv02 where correo = (?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//ELIMINACION DE DATOS EN LA TABLA PIVOTE 02
				debug("datos entrantes al sql: CORREONW["+datos.getCorreoNw()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getCorreoNw());
				info("ejecucion de la sentencia sql delete: "+sql);
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
		final String sql="select * from tblpiv02 where idpersona  = (?)";
		final String sql2 = "select * from tbldetspersonas where idpersona = (?)";
		DatosCorreoAltBean respuesta = new DatosCorreoAltBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				rs.next();
				respuesta.setIdtipocorreo(rs.getInt(2));
				respuesta.setIdpersona(rs.getLong(1));
				warn("datos enviados: IDTIPOCORREO["+rs.getInt(2)+"],IDPERSONA["+rs.getLong(1)+"]");
				info("ejecucion de la sentencia sql: "+sql);
				debug("datos entrantes para el sql2: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps1 = con.prepareStatement(sql2);
				ps1.setLong(1, respuesta.getIdpersona());
				ResultSet rs1 = ps1.executeQuery();
				rs1.next();
				respuesta.setNombreCompleto(rs1.getString("nombre")+" "+rs1.getString("segnombre")+" "+rs1.getString("apellidop")+" "+rs1.getString("apellidom"));
				warn("datos enviado: NOMBRE["+rs1.getString("nombre")+"], SEGUNDONOMBRE["+rs1.getString("segnombre")+"], APELLIDOPATERNO["+rs1.getString("apellidop")+"],APELLIDOMATERNO["+rs1.getString("apellidom")+"]");
				setDatosCorreo(rs);
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
		info("ejecucion de la sentencia sql: "+sql);
		return jdbcTemplate.query(sql, new CorreosRowMapper());
	}
	private void setDatosCorreo(ResultSet rs) throws SQLException{
		datos= new ArrayList<DatosCorreoAltBean>();
		DatosCorreoAltBean respuesta;
		while(rs.next()) {
			respuesta = new DatosCorreoAltBean();
			
			this.datos.add(respuesta);
			}
	}

	@SuppressWarnings("unused")
	private List<DatosCorreoAltBean>getDatosCorreo(){
		return this.datos;
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

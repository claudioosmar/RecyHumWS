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

import javax.sound.midi.MidiDevice.Info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.vector.Beans.DatosDocumentoBean;
import com.vector.DAO.DAODatosDocumento;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosDocumentosImpl.java
 *   Descripción: contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  24/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: mensajes de LOG
 *   
 */
@Service
public class DAODatosDocumentosImpl extends Log implements DAODatosDocumento {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The datos. */
	List<DatosDocumentoBean> datos;
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Crear(DatosDocumentoBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL PARA INSERSION DE DATOS!
		final String sql="INSERT INTO TBLPIV03 VALUES(?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"], IDDOCUMENTONW["+datos.getIddocumentoNw()+"],DESCRIPCION["+datos.getDescripciondocNw()+"],URLDOCUMENTONW["+datos.getUrldocNw()+"]");
				//INSERSION DE DATOS EN LA TABLA PIVOTE 03
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdpersona());
				ps.setInt(2, datos.getIddocumentoNw());
				ps.setString(3, datos.getDescripciondocNw());
				ps.setString(4, datos.getUrldocNw());
				info("ejecucion de la sentencia sql: "+sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA["+respuesta+"]");
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosDocumentoBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL PARA LA MODIFICACION O ACTUALIZACION DE DATOS
		final String sql="update tblpiv03 set iddoc =(?), descripcion = (?), urldoc = (?) where idpersona = (?) and iddoc = (?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"], IDDOCUMENTONW["+datos.getIddocumentoNw()+"], IDDOCUMENTOLT["+datos.getIddocumentoLt()+"],DESCRIPCION["+datos.getDescripciondocNw()+"],URLDOCUMENTONW["+datos.getUrldocNw()+"]");
				//MODIFICACION DE LOS DATOS EN LA TABLA PIVOTE 03
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(4, datos.getIdpersona());
				ps.setInt(1, datos.getIddocumentoNw());
				ps.setInt(5, datos.getIddocumentoLt());
				ps.setString(2, datos.getDescripciondocNw());
				ps.setString(3, datos.getUrldocNw());
				info("ejecucion de la sentencia sql: "+sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA["+respuesta+"]");
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Eliminar(DatosDocumentoBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL DE ELIIMINACION DE DATOS
		final String sql="delete tblpiv03 where iddoc = (?) and idpersona = (?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"], IDDOCUMENTONW["+datos.getIddocumentoNw()+"]");
				//ELIMINACION DE DATOS DE LA TABLA PIVOTE 03
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIddocumentoNw());
				ps.setInt(2, datos.getIdpersona());
				info("ejecucion de la sentencia sql: "+sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA["+respuesta+"]");
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosDocumentoBean> Buscar(DatosDocumentoBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL PARA LA GENERACION DE UNA CONSULTA
		final String sql = "select * from tblpiv03 where iddoc = (?) and idpersona = (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"], IDDOCUMENTONW["+datos.getIddocumentoNw()+"]");
				//CONSULTA DE DATOS DE LA TABLA PIVOTE 03
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(2, datos.getIdpersona());
				ps.setInt(1, datos.getIddocumentoNw());
				ResultSet rs = ps.executeQuery();
				info("llamando al metodo setDatosDocumento(rs)");
				setDatosDocumento(rs);
				info("ejecucion de la sentencia sql: "+sql);
				return ps;
			}
		});
		List<DatosDocumentoBean> retorno = getDatosDocumento();
		return retorno;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosDocumentoBean> Listar(long id) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv03 where idpersona = '"+id+"'";
		debug("datos entrantes para el sql: IDPERSONA["+id+"]");
		info("ejecucion de la sentencia sql: "+sql );
		return jdbcTemplate.query(sql, new DocRowMapper());
	}
	
	/**
	 * Sets the datos documento.
	 *
	 * @param rs the new datos documento
	 * @throws SQLException the SQL exception
	 */
	private void setDatosDocumento(ResultSet rs) throws SQLException{
		datos= new ArrayList<DatosDocumentoBean>();
		DatosDocumentoBean respuesta;
		info("se enlistaron los documento");
		while(rs.next()) {
			respuesta = new DatosDocumentoBean();
			respuesta.setDescripciondocNw(rs.getString(3));
			respuesta.setIdpersona(rs.getInt(1));
			warn("datos enviados: DESCRIPCIONDOCUEMENTO["+rs.getString(3)+"], IDPERSONA["+rs.getInt(1)+"]");
			
			this.datos.add(respuesta);
			}
	}

	/**
	 * Gets the datos documento.
	 *
	 * @return the datos documento
	 */
	private List<DatosDocumentoBean>getDatosDocumento(){
		return this.datos;
	}
}
class DocRowMapper implements RowMapper<DatosDocumentoBean>{


	@Override
	public DatosDocumentoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosDocumentoBean retorno= new DatosDocumentoBean();
		retorno.setIddocumentoNw(rs.getInt(2));
		retorno.setDescripciondocNw(rs.getString(3));
		retorno.setUrldocNw(rs.getString(4));
		return retorno;
	}
	
}

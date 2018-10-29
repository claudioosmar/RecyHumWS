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
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosCertificadoBean;
import com.vector.DAO.DAODatosCertificado;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosCertificadoImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class DAODatosCertificadoImpl extends Log implements DAODatosCertificado {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The autoin. */
	private AutoIncrementablesBDOracle autoin;
	
	/** The datos. */
	List<DatosCertificadoBean> datos;
	

	/** 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public int Crear(DatosCertificadoBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub	
		autoin = new AutoIncrementablesBDOracle();
		int IDCertificado = autoin.CertificadoIDUltimo(jdbcTemplate);
		//SENTENCIA SQL DE INSERCION PARA LAS TABLAS CRTIFICADOS Y LA PIVOTE 05
		final String sql="INSERT INTO tblcertificado VALUES (?,?,?)";
		final String sql2="INSERT INTO tblpiv05 VALUES(?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//INSERCION DE DATOS EN LA TABLA CERTIFICADO
				debug("datos entrantes en el sql: IDCERTIFICADO["+IDCertificado+"],[NOMBRECERTIFICADO["+datos.getNomcertificadoNw()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, IDCertificado);
				ps.setInt(2, 7);
				ps.setString(3, datos.getNomcertificadoNw());
				ps.execute();
				info("ejecucion de la sentencia sql insert: "+sql);
				//INSERCION DE DATOS EN LA TABLA PIVOTE 05
				debug("datos entrantes en el sql2: IDCERTIFICADO["+IDCertificado+"],IDESTUDIO["+datos.getIdestudio()+"]");				
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setLong(1, datos.getIdestudio());
				ps2.setInt(2, IDCertificado);
				info("ejecucion de la sentencia sql insert: "+sql2);
				 return ps2;
				 
			}
		});
		warn("datos enviados: RESPUESTA["+respuesta+"]");
		return respuesta;
		
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosCertificadoBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL PARA LA MODIFICACION DE DATOS EN LA TABLA CERTIFICADO
		final String sql= "update tblcertificado set iddoc = (?), nomcertificado = (?) where idcertificado = (?) and iddoc = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//MODIFICACION DE LOS DATOS EN LA TABLA CERTIFICADO
				debug("datos entrantes en sql: IDDOCUMENTONW["+datos.getIddocumentoNw()+"],NOMBRECERTIFICADO["+datos.getNomcertificadoNw()+"],IDCERTIFICADO["+datos.getIdcertificado()+"],IDDOCUMENTOLT["+datos.getIddocumentoLt()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(3, datos.getIdcertificado());
				ps.setInt(1, datos.getIddocumentoNw());
				ps.setString(2, datos.getNomcertificadoNw());
				ps.setInt(4, datos.getIddocumentoLt());
				info("ejecucion de la sentencia sql update: "+sql);
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
	@Transactional(readOnly = true)
	public int Eliminar(DatosCertificadoBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL DE ELIMINACION PARA LA TABLA CERTIFICADO
		final String sql="delete tblcertificado where idcertificado = (?) and iddoc = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//ELIMINACION DE DATOS EN LA TABLA CERTIFICADO
				debug("datos entrantes en sql: IDCERTIFICADO["+datos.getIdcertificado()+"],IDDOCUMENTONW["+datos.getIddocumentoNw()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdcertificado());
				ps.setInt(2, datos.getIddocumentoNw());
				info("ejecucion de la sentencia sql delete: "+sql);
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
	@Transactional//(readOnly = true)
	public List<DatosCertificadoBean> Buscar(DatosCertificadoBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		//SENTENCIA SQL PARA UNA CONSULTA EN LA TABLA CERTIFICADO
		final String sql="select * from tblpiv05 piv5, tblpiv15 piv15, tblcertificado cert where piv15.idestudio=piv5.idestudio and piv5.idcertificado=cert.idcertificado and piv15.idpersona = (?) ";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				setDatosCertificado(rs);
				info("llamado al metodo: setDatosCertificado(rs), ejecucion de la sentencia sql: "+sql);
				return ps;
			}
		});
		List<DatosCertificadoBean> retorno = getDatosCertificado();
		info("llamado al metodo: getDatosCertificado()");
		return retorno;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosCertificadoBean> Listar() {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql="select * from tblcertificado";
		info("ejecuta sentencia sql: "+sql);
		return jdbcTemplate.query(sql, new CertificadoRowMapper());
	}
	
	/**
	 * Sets the datos certificado.
	 *
	 * @param rs the new datos certificado
	 * @throws SQLException the SQL exception
	 */
	private void setDatosCertificado(ResultSet rs) throws SQLException{
		datos= new ArrayList<DatosCertificadoBean>();
		DatosCertificadoBean respuesta;
		info("entra en el while");
		while(rs.next()) {
			respuesta = new DatosCertificadoBean();
			respuesta.setIdcertificado(rs.getInt(1));
			respuesta.setIddocumentoNw(rs.getInt(2));
			respuesta.setNomcertificadoNw(rs.getString(7));	
			info("Datos Enviados: IDCERTIFICADO["+rs.getInt(1)+"],IDDOCUMENTONW["+rs.getInt(2)+"],NOMBRECERTIFICADO["+rs.getString(7)+"]");
			this.datos.add(respuesta);
			}
	}

	/**
	 * Gets the datos certificado.
	 *
	 * @return the datos certificado
	 */
	private List<DatosCertificadoBean>getDatosCertificado(){
		info("retorna los datos");
		return this.datos;
	}

}
	class CertificadoRowMapper implements RowMapper<DatosCertificadoBean> {
		@Override
		public DatosCertificadoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DatosCertificadoBean retorno = new DatosCertificadoBean();
			retorno.setIdcertificado(rs.getInt(1));
			retorno.setIddocumentoNw(rs.getInt(2));
			retorno.setNomcertificadoNw(rs.getString(3));

			return retorno;
		}
	}

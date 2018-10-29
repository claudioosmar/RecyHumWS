/**
 * DAODatosCursoImpl.java -- 25/08/2018
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosCursoBean;
import com.vector.DAO.DAODatosCurso;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.ConvertirFecha;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc

/**
 *   Vector México
 *   Clase: DAODatosCursoImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  16/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: mejora en los metodo de busqueda y actualizacion
 *   
 */
@Service
public class DAODatosCursoImpl extends Log implements DAODatosCurso {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The autoin. */
	private AutoIncrementablesBDOracle autoin;

	/** The datos. */
	List<DatosCursoBean> datos;
	/** The c. */
	Calendar c;
	
	/** The dia. */
	String dia = "";
	
	/** The mes. */
	String mes = "";
	
	/** The annio. */
	String annio = "";


	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosCursoBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		autoin = new AutoIncrementablesBDOracle();
		long idcurso = autoin.CursoIDUltimo(jdbcTemplate);
		long idcertificado = autoin.CertificadoIDUltimo(jdbcTemplate);

		final String sql = "insert into tblcursos values (?,?,?,?,?)";
		final String sql2 = "insert into tblpiv04 values(?,?)";
		final String sql3 = "insert into tblpiv16 values(?,?)";
		final String sql4 = "insert into tblcertificado values(?,?,?)";
		final String sql5 = "select * from tblcursos where idcurso=(?)";
		final String sql6 = "insert into tblpiv14 values(?,?)";
		final String sql7 = "insert into tblpiv03 values (?,?,?,?)";
	//	final String sql8 = "selec * from tblpiv03 where idpersona =(?) and iddoc =(?)";

		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				/* primera insercion */
				PreparedStatement ps1 = con.prepareStatement(sql);
				debug("datos de entrada para el sql: IDCURSO[" + idcurso + "],NOMBRECURSO[" + datos.getNombrecurso()
						+ "],INSTITUTIO[" + datos.getInstitutocurso() + "],FECHAINICIO[" + datos.getFechainicioc()
						+ "],FECHATERMINO[" + datos.getFechaterminoc() + "]");
				ps1.setLong(1, idcurso);
				ps1.setString(2, datos.getNombrecurso());
				ps1.setString(3, datos.getInstitutocurso());
				ps1.setString(4, datos.getFechainicioc());
				ps1.setString(5, datos.getFechaterminoc());
				ps1.execute();
				info("ejecucion de la sentencia sql: " + sql);
				info("entra en la sentencia if");
				if (datos.getIdcertificado() != 0) {
					/* segunda insercion si se cumple y prerara la sentencia de insertan */
					PreparedStatement ps3 = con.prepareStatement(sql4);
					debug("datos de entrada para el sql4: IDCERTIFICADO[" + idcertificado + "],NOMBRECERTIFICADO["
							+ datos.getNombrecurso() + "]");
					ps3.setLong(1, idcertificado);
					ps3.setString(3, datos.getNombrecurso());
					ps3.setInt(2, 8);
					ps3.execute();
					info("ejecucion de la sentencia sql4: " + sql4);
					/* tercera insercion si se cumple la segunda */
					PreparedStatement ps = con.prepareStatement(sql2);
					debug("datos de entrada para el sql2: IDCURSO[" + idcurso + "],IDCERTIFICADO[" + idcertificado
							+ "]");
					ps.setLong(1, idcurso);
					ps.setLong(2, idcertificado);
					ps.execute();
					info("ejecucion de la sentencia sql2: " + sql2);

					debug("datos entrantes para sql7: IDPERSONA[" + datos.getIdpersona() + "], DESCRIPCION["
							+ idcertificado + "], URLCERTIFICADO[" + datos.getUrlcertificado() + "]");

					PreparedStatement ps5 = con.prepareStatement(sql7);
					ps5.setLong(1, datos.getIdpersona());
					ps5.setInt(2, 8);
					ps5.setLong(3, idcertificado);
					ps5.setString(4, datos.getUrlcertificado());
					ps5.execute();
					info("ejecucion de la sentencia sql7: " + sql7);
				} else {

				}
				info("entrando  la sentencia if");
				/* cuarta insercion si se cumple */
				if (datos.getIdpersona() != 0) {
					PreparedStatement ps3 = con.prepareStatement(sql3);
					debug("datos entrantes para el sql3: IDCURSO[" + idcurso + "], IDPERSONA[" + datos.getIdpersona()
							+ "]");
					ps3.setLong(2, idcurso);
					ps3.setLong(1, datos.getIdpersona());
					ps3.execute();
					info("ejecucion de la sentencia sql3: " + sql3);
				}
				info("entrando la sentencia if");
				if (datos.getIdestudio() != 0) {
					PreparedStatement ps4 = con.prepareStatement(sql6);
					debug("datos entrantes para el sql6: IDCURSO[" + idcurso + "], IDESTUDIO[" + datos.getIdestudio() + "]");
					ps4.setLong(2, idcurso);
					ps4.setLong(1, datos.getIdestudio());
					ps4.execute();
					info("ejecucion de la sentencia sql6: " + sql6);
				}
				PreparedStatement ps5 = con.prepareStatement(sql5);
				debug("dato entrante para el sql5: IDCURSO[" + idcurso + "]");
				ps5.setLong(1, idcurso);
				ResultSet rts = ps5.executeQuery();
				if (rts.next()) {
					debug("ps lo ta haciendo");
				}
				info("ejecucion de la sentencia sql5: " + sql5);
				return ps5;
			}
		});
		info("resputa --> " + respuesta);
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosCursoBean datos) {
		autoin = new AutoIncrementablesBDOracle();
		long idcertificado = autoin.CertificadoIDUltimo(jdbcTemplate);
		// TODO Auto-generated method stub
		final String sql = "update tblcursos set nombre =(?), institucion =(?),finicio=(?),ftermino=(?) where idcurso =(?)";
		final String sql7 = "update tblcertificado set nomcertificado = (?) where idcertificado=(?)";
		final String sql2 = "insert into tblcertificado values(?,?,?)";
		final String sql4 = "select * from tblpiv04 where idcurso=(?) and idcertificado=(?)";
		final String sql5 = "insert into tblpiv04 values(?,?)";
		final String sql8 = "update tblpiv03 set urldoc = (?) where iddoc =(?) and idpersona=(?) and descripcion = (?)";
		final String sql9 = "select * from tblpiv03 where idpersona =(?) and iddoc=(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/* preparando sentencia de select tblpiv04 */
				PreparedStatement ps1 = con.prepareStatement(sql4);
				debug("datos entrantes para el sql4: IDCERTIFICADO[" + datos.getIdcertificado() + "], IDCURSO[: "
						+ datos.getIdcurso() + "]");
				ps1.setLong(2, datos.getIdcertificado());
				ps1.setLong(1, datos.getIdcurso());
				ResultSet rs1 = ps1.executeQuery();

				/* actualizar si existen datos */
				if (rs1.next()) {
					info("entra en la sentencia if");
				
						PreparedStatement ps = con.prepareStatement(sql);
						debug("datos entrantes para el sql: IDCURSO[" + datos.getIdcurso() + "],NOMBRECURSO["
								+ datos.getNombrecurso() + "], INSTITUTO[" + datos.getInstitutocurso()
								+ "], FECHAINICIO[" + datos.getFechainicioc() + "], FECHAFINAL["
								+ datos.getFechaterminoc() + "]");
						ps.setLong(5, datos.getIdcurso());
						ps.setString(1, datos.getNombrecurso());
						ps.setString(2, datos.getInstitutocurso());
						ps.setString(3, datos.getFechainicioc().toString());
						ps.setString(4, datos.getFechaterminoc().toString());
						ps.execute();
						info("ejecucion de la sentencia sql: " + sql);
			
						PreparedStatement ps7 = con.prepareStatement(sql7);
						debug("datos entrantes para el sql7: IDCERTIFICADO[" + datos.getIdcertificado()
								+ "], NOMBRECERTIFICADO[" + datos.getNombrecurso() + "]");
						ps7.setLong(2, datos.getIdcertificado());
						ps7.setString(1, datos.getNombrecurso());
						ps7.execute();
						info("ejecucion de la sentencia sql7: " + sql7);
					
					PreparedStatement ps8 = con.prepareStatement(sql8);
					debug("datos entrantes para el sql8: URLCERTIFICADO[" + datos.getUrlcertificado() + "], IDPERSONA["
							+ datos.getIdpersona() + "], DESCRIPCION["+datos.getIdcertificado()+"]");
					ps8.setString(1, datos.getUrlcertificado());
					ps8.setInt(2, 8);
					ps8.setLong(3, datos.getIdpersona());
					ps8.setInt(4, datos.getIdcertificado());
					ps8.execute();
					
				} else if (datos.getIdcertificado() == 0) {
					info("entrando en else if");
					PreparedStatement ps = con.prepareStatement(sql);
					debug("datos entrantes al sql: IDCURSO[" + datos.getIdcurso() + "], NOMBRE["
							+ datos.getNombrecurso() + "], INSTITUTO[" + datos.getInstitutocurso() + "], FECHAINICIO["
							+ datos.getFechainicioc() + "], FECHAFINAL[" + datos.getFechaterminoc() + "]");
					ps.setLong(5, datos.getIdcurso());
					ps.setString(1, datos.getNombrecurso());
					ps.setString(2, datos.getInstitutocurso());
					ps.setString(3, datos.getFechainicioc().toString());
					ps.setString(4, datos.getFechaterminoc().toString());
					ps.execute();
					info("ejecucion de la sentencia sql: " + sql);
				} else {
					info("entrando en else");
					PreparedStatement ps3 = con.prepareStatement(sql2);
					debug("datos de entrada para el sql2: IDCERTIFICADO[" + idcertificado + "], NOMBRECERTIFICADO["
							+ datos.getNombrecurso() + "]");
					ps3.setLong(1, idcertificado);
					ps3.setString(3, datos.getNombrecurso());
					ps3.setInt(2, 8);
					ps3.execute();
					info("ejecucion de la sentencia sql2: " + sql2);
					
					PreparedStatement ps5 = con.prepareStatement(sql5);
					debug("datos de entrada para el sql5: IDCURSO[" + datos.getIdcurso() + "], IDCERTIFICADO["
							+ idcertificado + "]");
					ps5.setLong(1, datos.getIdcurso());
					ps5.setLong(2, idcertificado);
					ps5.execute();
					info("ejecucion de la sentencia sql5: " + sql5);
				}
				info("ejecucion de la sentencia sql4: " + sql4);
				return ps1;
			}
		});
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		final String sql = "delete tblcursos where idcurso = (?)";
		// final String sql2 ="delete tblpiv16 where idcurso = (?)";

		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para el sql: IDCURSO[" + datos.getIdcurso() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdcurso());
				// ps.execute();
				/*
				 * debug("datos de entrada para el sql2: IDCURSO["+datos.getIdcurso()+"]");
				 * PreparedStatement ps1 = con.prepareStatement(sql2); ps1.setInt(1,
				 * datos.getIdcurso());
				 */
				return ps;
			}
		});
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosCursoBean> Buscar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpersonas pe LEFT JOIN tblpiv16 piv16 ON pe.idpersona=piv16.idpersona LEFT JOIN tblcursos cur ON piv16.idcurso= cur.idcurso LEFT JOIN tblpiv04 piv4 ON cur.idcurso = piv4.idcurso LEFT JOIN tblcertificado cer ON piv4.idcertificado = cer.idcertificado where piv16.idpersona =(?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para el sql: IDPERSONA[" + datos.getIdpersona() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				info("llamdo al metodo setDatosCurso(rs)");
				setDatosCurso(rs);
				return ps;
			}
		});
		info("llamado al metodo getDatosCurso()");
		List<DatosCursoBean> retorno = getDatosCurso();
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosCursoBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblcursos";
		info("ejecucion de la sentencia sql: " + sql);
		return jdbcTemplate.query(sql, new CursoRowMapper());
	}

	/**
	 * Sets the datos curso.
	 *
	 * @param rs
	 *            the new datos curso
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void setDatosCurso(ResultSet rs) throws SQLException {
		ConvertirFecha converter = new ConvertirFecha();
		c = Calendar.getInstance();
		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH)+1);
		annio = Integer.toString(c.get(Calendar.YEAR));
		
		datos = new ArrayList<DatosCursoBean>();
		DatosCursoBean respuesta;
		info("entra en el while");
		while (rs.next()) {
			respuesta = new DatosCursoBean();
			if(rs.getString(11) == null) {
				respuesta.setIdcurso(0);
			}else {
				respuesta.setIdcurso(rs.getInt(11));
			}
			if(rs.getString(12) == null) {
				respuesta.setNombrecurso("");
			}else {
			
				respuesta.setNombrecurso(rs.getString(12));
			}
			if(rs.getString(13) == null) {
				respuesta.setInstitutocurso("");
			}else {
			respuesta.setInstitutocurso(rs.getString(13));
			}
			respuesta.setFechainicioc(converter.converter((String) rs.getString(14).toString()));
			if (rs.getString("FTERMINO") == null) {
				info("entra en la sentencia if");
				respuesta.setFechaterminoc(dia + "/" + mes + "/" + annio);
			}else if(rs.getString("FTERMINO") == null && rs.getString("IDCURSO_1")==null){
				respuesta.setFechaterminoc("");
			}else {
				info("entran en la sentencia else");
				respuesta.setFechaterminoc(converter.converter((String) rs.getString(15).toString()));
			}
			respuesta.setIdpersona(rs.getLong(1));
			if (rs.getString("NOMCERTIFICADO") == null) {
				respuesta.setNombrecertificado("");
			} else {
				respuesta.setNombrecertificado(rs.getString(20));
			}
			if (rs.getString("IDCERTIFICADO") == null) {
				respuesta.setIdcertificado(0);
			} else {
				respuesta.setIdcertificado(rs.getInt(17));
			}
			warn("datos enviados: IDCURSO[" + rs.getInt(11) + "], NOMBRECURSO[" + rs.getString(12) + "], INSTITUTO["
					+ rs.getString(13) + "], FECHAINICIO[" + rs.getString(14) + "], FECHATERMINO[" + rs.getString(15)
					+ "], IDPERSONA[" + rs.getLong(1) + "], NOMBRECERTIFICADO[" + rs.getString(20) + "], IDCERTIFICADO["
					+ rs.getInt(17) + "]");
			this.datos.add(respuesta);
		}
	}

	/**
	 * Gets the datos curso.
	 *
	 * @return the datos curso
	 */
	private List<DatosCursoBean> getDatosCurso() {
		return this.datos;
	}

}

class CursoRowMapper implements RowMapper<DatosCursoBean> {
	@Override
	public DatosCursoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosCursoBean respuesta = new DatosCursoBean();
		respuesta.setIdcurso(rs.getInt(1));
		respuesta.setNombrecurso(rs.getString(2));
		respuesta.setInstitutocurso(rs.getString(3));
		respuesta.setFechainicioc(rs.getString(4));
		respuesta.setFechaterminoc(rs.getString(5));
		return respuesta;
	}
}
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

import com.vector.Beans.DatosIdiomasBean;
import com.vector.DAO.DAODatosIdiomas;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.Log;

import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * Vector México Clase: DAODatosIdiomasImpl.java Descripción: contiene los
 * metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y
 * las sentenicas sql
 * 
 * 
 * Control de Cambios: 12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 * 18/10/2018 Jair de Jesus Barcenas Gomez - Modificacion de mensajes en LOG
 * 
 */
@Service
public class DAODatosIdiomasImpl extends Log implements DAODatosIdiomas {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");

	/** The autoin. */
	private AutoIncrementablesBDOracle autoin;

	/** The datos. */
	List<DatosIdiomasBean> datos;

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	public int Crear(DatosIdiomasBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		autoin = new AutoIncrementablesBDOracle();
		long iddominio = autoin.DominioIDUltimo(jdbcTemplate);
		LOGGER.info("Este es el id de estudio: " + autoin);

		final String sql = "insert into tbldominio values(?,?,?,?,?,?,?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				debug("datos recibidos para el sql: IDDOMINIO[" + iddominio + "], IDPERSONA[" + datos.getIdpersona()
						+ "], IDIDIOMA[" + datos.getIdidioma() + "], PCJESCRITURA[" + datos.getPcjescrito()
						+ "], PCJHABALDO[" + datos.getPcjhablado() + "], PCJENTENDIMIENTO[" + datos.getPcjentendido()
						+ "], DESCRIPCION[" + datos.getDescripciondominio() + "], IDIOMANATIVO["
						+ datos.getIdiomanativa() + "]");
				ps.setLong(1, iddominio);
				ps.setLong(5, datos.getIdpersona());
				ps.setInt(8, datos.getIdidioma());
				ps.setInt(2, datos.getPcjescrito());
				ps.setInt(3, datos.getPcjhablado());
				ps.setInt(4, datos.getPcjentendido());
				ps.setString(6, datos.getDescripciondominio());
				ps.setString(7, datos.getIdiomanativa());
				info("ejecucion de la sentencia sql: " + sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosIdiomasBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "update tbldominio set pctescrito = (?), pcthablado = (?), pctentendido =(?), descripcion =(?), idiomanativa=(?),ididioma=(?) where idpersona =(?) and iddominio= (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos recibidos para el sql:  IDDOMINIO[" + datos.getIddominio() + "], IDPERSONA[" + datos.getIdpersona()
						+ "], IDIDIOMA[" + datos.getIdidioma() + "], PCJESCRITURA[" + datos.getPcjescrito()
						+ "], PCJHABALDO[" + +datos.getPcjhablado() + "], PCJENTENDIMIENTO[" + datos.getPcjentendido()
						+ "], DESCRIPCION[" + datos.getDescripciondominio() + "], IDIOMANATIVO["
						+ datos.getIdiomanativa() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getPcjescrito());
				ps.setInt(2, datos.getPcjhablado());
				ps.setInt(3, datos.getPcjentendido());
				ps.setString(4, datos.getDescripciondominio());
				ps.setString(5, datos.getIdiomanativa());
				ps.setInt(6, datos.getIdidioma());
				ps.setLong(7, datos.getIdpersona());
				ps.setInt(8, datos.getIddominio());
				info("ejecucion de la sentencia sql: " + sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(DatosIdiomasBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "delete tbldominio where iddominio = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDDOMINIO["+datos.getIddominio()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIddominio());
				info("ejecucion de la sentencia sql: " + sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tbldominio dom, tbldetspersonas dts, tblidiomas ido where dom.ididioma=ido.ididioma and dts.idpersona=dom.idpersona and dom.idpersona = (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				info("llamada el metodo setDatosIdiomas(rs)");
				setDatosIdiomas(rs);
				info("ejecucion de la sentencia sql: " + sql);
				return ps;
			}
		});
		info("llamada el metodo getDatosIdiomas()");
		List<DatosIdiomasBean> retorno = getDatosIdiomas();
		
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosIdiomasBean> Listar() {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tbldominio dom, tblidiomas idio where dom.ididioma=idio.ididioma";
		info("ejecucion de la sentencia sql: "+ sql);
		return jdbcTemplate.query(sql, new IdiomaRowMapper());
	}

	/**
	 * Sets the datos idiomas.
	 *
	 * @param rs
	 *            the new datos idiomas
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void setDatosIdiomas(ResultSet rs) throws SQLException {
		info("entra en el metodo");
		datos = new ArrayList<DatosIdiomasBean>();
		DatosIdiomasBean respuesta;
		info("se enlistaron los idiomas");
		while (rs.next()) {
			
			respuesta = new DatosIdiomasBean();
			respuesta.setIddominio(rs.getInt(1));
			respuesta.setPcjescrito(rs.getInt(2));
			respuesta.setPcjhablado(rs.getInt(3));
			respuesta.setPcjentendido(rs.getInt(4));
			if(rs.getString("DESCRIPCION")==null) {
			respuesta.setDescripciondominio("");
			}else {
				respuesta.setDescripciondominio(rs.getString(6));
			}
			respuesta.setIdiomanativa(rs.getString(7));
			respuesta.setIdidioma(rs.getInt(8));
			respuesta.setNombrecompleto(rs.getString(13) + " " + rs.getString(14) + " " + rs.getString(15) + " " + rs.getString(16));
			respuesta.setNombreidioma(rs.getString(21));
			warn("datos enviados: IDDOMINIO["+rs.getInt(1)+"], PCJESCRITURA["+rs.getInt(2)+"], PCJHABLADO["+rs.getInt(3)+"], PCJENTENDIDO["
					+rs.getInt(4)+"], DESCRIPCION["+rs.getString(6)+"], IDIOMANATIVO["+rs.getString(7)+"], NOMBRECOMPLETO["
					+rs.getString(13) + " " + rs.getString(14) + " " + rs.getString(15) + " " + rs.getString(16)
					+"], NOMBREIDIOMA["+rs.getString(21)+"], IDIDIOMA["+rs.getInt(8)+"]");
			this.datos.add(respuesta);
		}
	}

	/**
	 * Gets the datos idiomas.
	 *
	 * @return the datos idiomas
	 */
	private List<DatosIdiomasBean> getDatosIdiomas() {
		info("entra en el metodo");
		return this.datos;
	}
}

class IdiomaRowMapper implements RowMapper<DatosIdiomasBean> {
	@Override
	public DatosIdiomasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosIdiomasBean idioma = new DatosIdiomasBean();
		idioma.setIddominio(rs.getInt(1));
		idioma.setIdidioma(rs.getInt(8));
		idioma.setNombreidioma(rs.getString(10));
		return idioma;
	}

}

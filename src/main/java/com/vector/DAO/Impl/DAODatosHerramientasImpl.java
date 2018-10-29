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

import com.vector.Beans.DatosHerramientasBean;
import com.vector.DAO.DAODatosHerramientas;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 * Vector México Clase: DAODatosHerramientasImpl.java Descripción: contiene los
 * metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y
 * las sentenicas sql
 * 
 * 
 * Control de Cambios: 
 * 12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 * 23/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: mensajes de LOG
 * 
 */
// clase de herramientas conocidas implements
@Service
public class DAODatosHerramientasImpl extends Log implements DAODatosHerramientas {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The datos. */
	List<DatosHerramientasBean> datos;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Crear(DatosHerramientasBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "insert into tblpiv09 values(?,?,?,?,?)";
		final String sql2 = "select * from tblpiv09 where idherramienta=(?)";

		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA[" + datos.getIdpersona() + "], IDHERRAMIENTA["
						+ datos.getIdherramienta() + "], PORCENTAJE[" + datos.getPorcentajeherra()
						+ "], AÑOSEXPERIENCIA[" + datos.getAnosexpherra() + "], DESCRIPCION["
						+ datos.getDescripcionherra() + "]");
				if (datos.getIdpersona() != 0) {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setLong(1, datos.getIdpersona());
					ps.setInt(2, datos.getIdherramienta());
					ps.setInt(3, datos.getPorcentajeherra());
					ps.setInt(4, datos.getAnosexpherra());
					ps.setString(5, datos.getDescripcionherra());
					ps.execute();
					info("ejecucion de la sentencia sql: " + sql);
				}

				debug("dato entrante para el sql2: IDPERSONA[" + datos.getIdherramienta() + "]");
				PreparedStatement ps1 = con.prepareStatement(sql2);
				ps1.setLong(1, datos.getIdherramienta());
				info("ejecucion de la sentencia sql2: " + sql2);
				return ps1;

			}
		});
		warn("dato enviado: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosHerramientasBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "update tblpiv09 set idherramienta=(?),porcentaje=(?),añosexpe=(?),descripcion=(?) where idpersona =(?) and idherramienta=(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA[" + datos.getIdpersona() + "], IDHERRAMIENTA["
						+ datos.getIdherramienta() + "], PORCENTAJE[" + datos.getPorcentajeherra()
						+ "], AÑOSEXPERIENCIA[" + datos.getAnosexpherra() + "], DESCRIPCION["
						+ datos.getDescripcionherra() + "], IDHERRAMIENTANUEVA[" + datos.getIdherramientaNw() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(5, datos.getIdpersona());
				ps.setInt(6, datos.getIdherramienta());
				ps.setInt(2, datos.getPorcentajeherra());
				ps.setInt(3, datos.getAnosexpherra());
				ps.setString(4, datos.getDescripcionherra());
				ps.setInt(1, datos.getIdherramientaNw());
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
	public int Eliminar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "delete tblpiv09 where idpersona =(?) and idherramienta=(?)";
		final String sql2 = "delete tblpiv09 where idherramienta=(?) and idpersona=(?) and descripcion=(?)";
		final String sql3 = "select * from tblherramientas where idherramienta = (?)";

		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				if (datos.getIdherramienta() != 6) {
					debug("dato entrantes para el sql: IDHERRAMIENTA[" + datos.getIdherramienta() + "]");
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setLong(1, datos.getIdpersona());
					ps.setInt(2, datos.getIdherramienta());
					ps.execute();
					info("ejecucion de la sentencia sql: " + sql);
				} else {
					debug("datos entrantes para el sql: IDDESCRIPCION[" + datos.getDescripcionherra() + "], IDPERSONA["
							+ datos.getIdpersona() + "]");
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, 6);
					ps2.setLong(2, datos.getIdpersona());
					ps2.setString(3, datos.getDescripcionherra());
					ps2.execute();
					info("ejecucion de la sentencia sql2: " + sql2);
				}
				debug("datos entrantes para el sql3: IDHERRAMIENTA[" + datos.getIdherramienta() + "]");
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setInt(1, datos.getIdherramienta());
				info("ejecucion de la sentencia sql3: " + sql3);
				return ps3;
			}
		});
		warn("dato enviado: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv09 piv,tblherramientas her where piv.idherramienta=her.idherramienta and idpersona =(?)";
		final String sql2 = "select * from tbldetspersonas where idpersona =(?)";
		DatosHerramientasBean respuesta = new DatosHerramientasBean();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA[" + datos.getIdpersona() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				List<Integer> idherr = new ArrayList<Integer>();
				ResultSet rs = ps.executeQuery();
				info("llamando al metodo setDatosHerramientas(rs)");
				setDatosHerramientas(rs);
				info("entra en el ciclo for");
				for (int i = 0; i < idherr.size(); i++) {
					debug("datos entrantes para el sql2: IDPERSONA[" + datos.getIdpersona() + "]");
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setLong(1, datos.getIdpersona());
					ResultSet rs2 = ps2.executeQuery();
					info("ejecucion de la sentencia sql2: " + sql2);
					rs2.next();
					respuesta.setNombrecompleto(rs2.getString("nombre") + " " + rs2.getString("segnombre") + " "
							+ rs2.getString("apellidop") + " " + rs2.getString("apellidom"));
					warn("datos enviados: NOMBRECOMPLETO[" + rs2.getString("nombre") + " " + rs2.getString("segnombre")
							+ " " + rs2.getString("apellidop") + " " + rs2.getString("apellidom") + "]");
				}
				// PreparedStatement ps3 = con.prepareStatement(sql);
				return ps;
			}
		});
		List<DatosHerramientasBean> retorno = getDatosherramientas();
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblherramientas";
		return jdbcTemplate.query(sql, new HerrRowMapper());
	}

	/**
	 * Sets the datos herramientas.
	 *
	 * @param rs
	 *            the new datos herramientas
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void setDatosHerramientas(ResultSet rs) throws SQLException {
		datos = new ArrayList<DatosHerramientasBean>();
		DatosHerramientasBean respuesta;
		info("se enlistaron las herramientas");
		while (rs.next()) {
			respuesta = new DatosHerramientasBean();
			respuesta.setIdpersona(rs.getLong(1));
			respuesta.setIdherramienta(rs.getInt(2));
			respuesta.setPorcentajeherra(rs.getInt(3));
			respuesta.setAnosexpherra(rs.getInt(4));
			respuesta.setDescripcionherra(rs.getString(5));
			respuesta.setNombreherramienta(rs.getString(7));
			respuesta.setVersion(rs.getString(8));
			warn("datos enviados: IDPERSONA[" + rs.getLong(1) + "],IDHERRAMIENTA[" + rs.getInt(2) + "], PORCENTAJE["
					+ rs.getInt(3) + "], AÑOSEXPERIENCIA[" + rs.getInt(4) + "],DESCRIPCION[" + rs.getString(5)
					+ "], NOMBREHERRAMIENTA[" + rs.getString(7) + "],VERSION[" + rs.getString(8) + "]");
			this.datos.add(respuesta);
		}
	}

	/**
	 * Gets the datosherramientas.
	 *
	 * @return the datosherramientas
	 */
	private List<DatosHerramientasBean> getDatosherramientas() {
		return this.datos;
	}
}

class HerrRowMapper implements RowMapper<DatosHerramientasBean> {

	@Override
	public DatosHerramientasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosHerramientasBean retorno = new DatosHerramientasBean();
		retorno.setIdherramienta(rs.getInt(1));
		retorno.setNombreherramienta(rs.getString(2));
		retorno.setVersion(rs.getString(3));
		return retorno;
	}

}
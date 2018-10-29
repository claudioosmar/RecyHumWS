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

import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.DAO.DAODatosHerramientasUsadas;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 * Vector México Clase: DAODatosHerramientasUsadasImpl.java Descripción:
 * contiene los metedos crear, modificar, eliminar, buscar, listar implementadas
 * del DAO y las sentenicas sql
 * 
 * 
 * Control de Cambios: 
 * 12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 * 23/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: mensajes de LOG
 * 
 */
@Service
public class DAODatosHerramientasUsadasImpl extends Log implements DAODatosHerramientasUsadas {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The datos. */
	List<DatosHerramientasUsadasBean> datos;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Crear(DatosHerramientasUsadasBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "insert into tblpiv07 values(?,?,?,?,?)";
		final String sql2 = "select * from tblpiv07 where idexplaboral =(?)";
		final String sql3 = "select * from tblexpslaborales where idexplaboral = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				if (datos.getIdexplaboral() != 0) {
					debug("datos entrantes pars el sql: IDHERRAMIENTA[" + datos.getIdherramienta()
							+ "], IDEXPERIENCIALABORAL[" + datos.getIdexplaboral() + "], PORCENTAJE["
							+ datos.getPorcentajeherra() + "],AÑOSEXPERIENCIA[" + datos.getAnosexpherra()
							+ "], DESCRIPCION[" + datos.getDescripcionherra() + "]");
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setLong(2, datos.getIdexplaboral());
					ps.setInt(1, datos.getIdherramienta());
					ps.setInt(3, datos.getPorcentajeherra());
					ps.setInt(4, datos.getAnosexpherra());
					ps.setString(5, datos.getDescripcionherra());
					ps.execute();
					info("ejecucion del sql: " + sql);
				}
				debug("datos entrantes para el sql2: IDEXPERIENCIALABORAL[" + datos.getIdexplaboral() + "]");
				PreparedStatement ps1 = con.prepareStatement(sql2);
				ps1.setLong(1, datos.getIdexplaboral());
				ps1.execute();
				info("ejecucion de la sentencia sql2: " + sql2);
				
				debug("datos entrantes para el sql3: IDEXPERIENCIALABORAL[" + datos.getIdexplaboral() + "]");
				PreparedStatement ps2 = con.prepareStatement(sql3);
				ps2.setLong(1, datos.getIdexplaboral());
				info("ejecucion de la sentencia sql3: " + sql3);
				return ps2;

			}
		});
		warn("datos enviados:  RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosHerramientasUsadasBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "update tblpiv07 set idherramienta=(?),porcentaje=(?),añosexp=(?),descripcion=(?) where idexplaboral =(?) and idherramienta=(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes pars el sql: IDHERRAMIENTA[" + datos.getIdherramienta()
						+ "], IDEXPERIENCIALABORAL[" + datos.getIdexplaboral() + "], PORCENTAJE["
						+ datos.getPorcentajeherra() + "],AÑOSEXPERIENCIA[" + datos.getAnosexpherra()
						+ "], DESCRIPCION[" + datos.getDescripcionherra() + "], IDHERRAMIENTANUEVA["
						+ datos.getIdherramientaNw() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(5, datos.getIdexplaboral());
				ps.setInt(6, datos.getIdherramienta());
				ps.setInt(2, datos.getPorcentajeherra());
				ps.setInt(3, datos.getAnosexpherra());
				ps.setString(4, datos.getDescripcionherra());
				ps.setInt(1, datos.getIdherramientaNw());
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
	public int Eliminar(DatosHerramientasUsadasBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "delete tblpiv07 where idexplaboral =(?) and idherramienta=(?)";
		final String sql2 = "delete tblpiv07 where idpersona=(?) and descripcion=(?)";
		final String sql3 = "select * from tblpiv07";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				if (datos.getDescripcionherra() == "") {
					debug("datos entrantes para el sql: IDHERRAMIENTA[" + datos.getIdherramienta()+"], IDEXPERIENCIALABORAL["+datos.getIdexplaboral()+"]");
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setLong(1, datos.getIdexplaboral());
					ps.setInt(2, datos.getIdherramienta());
					ps.execute();
					info("ejecucion de la sentencia sql: "+sql);
				} else {
					PreparedStatement ps2 = con.prepareStatement(sql2);
					debug("datos entrantes para el sql2: " + datos.getDescripcionherra()+"], IDEXPERIENCIALABORAL["+ datos.getIdexplaboral()+"]");
					ps2.setLong(1, datos.getIdexplaboral());
					ps2.setString(2, datos.getDescripcionherra());
					ps2.execute();
				}
				debug("datos entrantes para el sql3: IDHERRAMIENTA[" + datos.getIdexplaboral()+"]");
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setLong(1, datos.getIdexplaboral());
				ResultSet rs3 = ps3.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				datos.setIdherramienta(rs3.getInt(2));
				warn("datos enviados: IDHERRAMIENTA["+rs3.getInt(2)+"]");
				rs3.next();
				return ps3;
			}
		});
		warn("datos enviados: RESPUESTA["+respuesta+"]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos) {
		info("entrando en el metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv07 piv, tblherramientas herm where piv.idherramienta=herm.idherramienta and idexplaboral =(?)";
		final String sql2 = "select * from tblexpslaborales where idexplaboral =(?)";
		DatosHerramientasUsadasBean respuesta = new DatosHerramientasUsadasBean();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes al sql: IDEXPERIENCIALABORAL["+ datos.getIdexplaboral()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdexplaboral());
				List<Integer> idherramientau = new ArrayList<Integer>();
				info("ejecucion de la sentencia sql: "+sql);
				ResultSet rs = ps.executeQuery();
				info("entrando al metodo setDatosHerramientasusadas(rs)");
				setDatosHerramientasusadas(rs);
				info("entrando al ciclo for");
				for (int i = 0; i < idherramientau.size(); i++) {
					debug("datos entrantes al sql2: IDEXPERIENCIALABORALES["+datos.getIdexplaboral()+"]");
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setLong(1, datos.getIdexplaboral());
					ResultSet rs2 = ps2.executeQuery();
					info("ejecucion de la sentencia sql2: "+sql2);
					rs2.next();
					respuesta.setIdexplaboral(rs2.getLong(1));
					warn("datos enviados: IDEXPERIENCIALABORAL["+rs2.getLong(1)+"]");

				}
				return ps;
			}
		});
		List<DatosHerramientasUsadasBean> retorno = getDatosherramientasusadas();
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv07 piv, tblherramientas herrm where piv.idherramienta = herrm.idherramienta";
		return jdbcTemplate.query(sql, new Herr2RowMapper());
	}

	/**
	 * Sets the datos herramientasusadas.
	 *
	 * @param rs
	 *            the new datos herramientasusadas
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void setDatosHerramientasusadas(ResultSet rs) throws SQLException {
		datos = new ArrayList<DatosHerramientasUsadasBean>();
		DatosHerramientasUsadasBean respuesta;
		info("se enlistaron las herramientas usadas");
		while (rs.next()) {
			respuesta = new DatosHerramientasUsadasBean();
			respuesta.setIdexplaboral(rs.getInt(2));
			respuesta.setIdherramienta(rs.getInt(1));
			respuesta.setPorcentajeherra(rs.getInt(3));
			respuesta.setAnosexpherra(rs.getInt(4));
			respuesta.setDescripcionherra(rs.getString(5));
			respuesta.setNombreherramienta(rs.getString(7));
			respuesta.setVersion(rs.getString(8));
			warn("datos enviados: IDEXPERIENCIALABORAL[" + rs.getInt(2) + "],IDHERRAMIENTA[" + rs.getInt(1) + "], PORCENTAJE["
					+ rs.getInt(3) + "], AÑOSEXPERIENCIA[" + rs.getInt(4) + "],DESCRIPCION[" + rs.getString(5)
					+ "], NOMBREHERRAMIENTA[" + rs.getString(7) + "],VERSION[" + rs.getString(8) + "]");
			this.datos.add(respuesta);
		}
	}

	/**
	 * Gets the datosherramientasusadas.
	 *
	 * @return the datosherramientasusadas
	 */
	private List<DatosHerramientasUsadasBean> getDatosherramientasusadas() {
		return this.datos;
	}
}

class Herr2RowMapper implements RowMapper<DatosHerramientasUsadasBean> {

	@Override
	public DatosHerramientasUsadasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosHerramientasUsadasBean retorno = new DatosHerramientasUsadasBean();
		retorno.setIdexplaboral(rs.getInt(2));
		retorno.setIdherramienta(rs.getInt(1));
		retorno.setPorcentajeherra(rs.getInt(3));
		retorno.setAnosexpherra(rs.getInt(4));
		retorno.setDescripcionherra(rs.getString(5));
		retorno.setNombreherramienta(rs.getString(7));
		retorno.setVersion(rs.getString(8));
		return retorno;
	}

}

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
import com.vector.Beans.DatosLaboralesBean;
import com.vector.DAO.DAODatosLaborales;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.Log;


// TODO: Auto-generated Javadoc
/**
 * Vector México Clase: DAODatosLaboralesImpl.java Descripción: contiene los
 * metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y
 * las sentenicas sql
 * 
 * 
 * Control de Cambios: 12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 * Control de Cambios: 19/10/2018 Jair de Jesus Barcenas Gomez - modificacion:
 * se modifico los mensajes del LOG y nueva mejora en actualizacion y
 * modificacion
 * 
 */
@Service
public class DAODatosLaboralesImpl extends Log implements DAODatosLaborales {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/** The ids. */
	private AutoIncrementablesBDOracle ids;

	/** The listalabo. */
	private List<DatosLaboralesBean> listalabo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Crear(DatosLaboralesBean datos) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		ids = new AutoIncrementablesBDOracle();
		int IDExpLaboral = ids.IDExpLaboralIDUltimo(jdbcTemplate);
		int IDEmpresas = ids.EmpresasIDUltimo(jdbcTemplate);
		int IDdesmotivotermino = ids.desmotivoIDUltimo(jdbcTemplate);

		final String sql = "INSERT INTO TBLEXPSLABORALES VALUES (?,?,?,?,?,?,?,?,?)";
		final String sql2 = "INSERT INTO TBLPIV06 VALUES (?,?)";
		final String sql3 = "INSERT INTO TBLEMPRESAS VALUES (?,?,?)";
		final String sql4 = "insert into tbldescsmotivos values (?,?)";
		final String sql5 = "insert into tblpiv08 values (?,?,?)";
		final String sql6 = "select * from tblexpslaborales where idexplaboral = (?)";

		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql3: IDEMPRESA[" + IDEmpresas + "], NOMBREEMPRESA["
						+ datos.getNombreempresa() + "]");
				// Insersion en tabla empresas
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setInt(1, IDEmpresas);
				ps3.setString(2, datos.getNombreempresa());
				ps3.setString(3, "1");
				ps3.execute();
				info("ejecucion de la sentencia sql3: " + sql3);

				debug("datos entrantes para el sql: IDEXPERIENCIALABORAL[" + IDExpLaboral + "], IDMOTIVOTERMINO["
						+ datos.getIdmotivotermino() + "], IDEMPRESA[" + IDEmpresas + "], PUESTO[" + datos.getPuesto()
						+ "], FECHAINICIO[" + datos.getFechainicioexp() + "], FECHAFINAL[" + datos.getFechafinalexp()
						+ "], ACTIVIDADES[" + datos.getActividadesreal() + "], LOGROS[" + datos.getLogros()
						+ "], IDTIPOCONTRATO[" + datos.getIdtipocontrato() + "]");
				// Insersion en tabla Experiencia Laboral
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, IDExpLaboral);
				ps.setInt(2, datos.getIdmotivotermino());
				ps.setInt(3, IDEmpresas);
				ps.setString(4, datos.getPuesto());
				ps.setString(5, datos.getFechainicioexp());
				ps.setString(6, datos.getFechafinalexp());
				ps.setString(7, datos.getActividadesreal());
				ps.setString(8, datos.getLogros());
				ps.setInt(9, datos.getIdtipocontrato());
				ps.execute();
				info("ejecucion de la sentencia sql: " + sql);

				debug("datos entrantes para el sql2: IDPERSONA[" + datos.getIdpersona() + "], IDEXPERIENCIALABORAL["
						+ IDExpLaboral + "]");
				// Insersion en tabla piv06
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setLong(1, datos.getIdpersona());
				ps2.setInt(2, IDExpLaboral);
				ps2.execute();
				info("ejecucion de la sentencia sql2: " + sql2);

				if (datos.getIdmotivotermino() == 4) {
					debug("datos entrantes para el sql4: IDDESCRIPCIONMOTIVO[" + IDdesmotivotermino
							+ "],DESCRIPCIONMOTIVO[" + datos.getDescripcionexp() + "]");
					PreparedStatement ps4 = con.prepareStatement(sql4);
					ps4.setLong(1, IDdesmotivotermino);
					ps4.setString(2, datos.getDescripcionexp());
					
					ps4.execute();
					info("ejecucion de la sentencia sql4: " + sql4);

					debug("datos entrantes para el sql5:IDDESCRIPCIONMOTIVO[" + IDdesmotivotermino + "], IDMOTIVO["
							+ datos.getIdmotivotermino() + "], IDEXPERIENCIALABORAL["+IDExpLaboral+"]");
					PreparedStatement ps5 = con.prepareStatement(sql5);
					ps5.setLong(2, IDdesmotivotermino);
					ps5.setInt(1, datos.getIdmotivotermino());
					ps5.setLong(3, IDExpLaboral);
					ps5.execute();
					info("ejecucion de la sentencia sql5: " + sql5);
				} else {
					info("IDMOTIVOTERMINO[" + datos.getIdmotivotermino() + "]");
				}
				debug("datos entrantes para el sql6: IDEXPERIENCIALABORAL[" + IDExpLaboral + "]");
				PreparedStatement ps6 = con.prepareStatement(sql6);
				ps6.setLong(1, IDExpLaboral);
				info("ejecucion de la sentencia sql6: " + sql6);
				return ps6;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "], IDEXPERIENCIALABORAL[" + IDExpLaboral + "]");
		if (respuesta == 1) {
			warn("datos enviados: IDEXPERIENCIALABORAL" + IDExpLaboral + "]");
			return IDExpLaboral;
		} else {
			warn("datos enviados: IDEXPERIENCIALABORAL[" + 0 + "]");
			return 0;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosLaboralesBean datos) {
		int IDdesmotivotermino = ids.desmotivoIDUltimo(jdbcTemplate);
		/**ARREGLAR EL METODO PARA QUE INGRESE EN LA PIV08 CUANDO ACTUALICE EL IDMOTIVOTERMINO PARA SU RELACION*/
		info("entrando en el metodo");
		// TODO Auto-generated method stub
		final String sql = "UPDATE TBLEXPSLABORALES SET IDMOTIVOTER=(?), IDEMPRESA=(?), PUESTO=(?), FINICIAL=(?), FFINAL=(?), ACTREALIZADAS=(?), LOGROS=(?), IDTIPOCONTRATA=(?) WHERE IDEXPLABORAL=(?)";
		final String sql2 = "UPDATE TBLEMPRESAS SET NOMEMPRESA=(?) WHERE IDEMPRESA=(?)  ";
		final String sql3 = "UPDATE TBLDESCSMOTIVOS SET DESCRIPCION = (?) WHERE IDDESCMOTIVO =(?)";
		final String sql4 = "SELECT * FROM TBLEXPSLABORALES WHERE IDEXPLABORAL = (?)";
		final String sql5 = "insert into tblpiv08 values (?,?,?)";
		final String sql6 = "insert into TBLDESCSMOTIVOS values (?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql2: IDEMPRESA[" + datos.getIdempresa() + "], NOMBREEMPRESA["
						+ datos.getNombreempresa() + "]");
				// Insersion en tabla empresas
				PreparedStatement ps3 = con.prepareStatement(sql2);
				ps3.setInt(2, datos.getIdempresa());
				ps3.setString(1, datos.getNombreempresa());
				ps3.execute();
				info("ejecucion de la sentencia sql2: " + sql2);

				debug("datos entrantes para el sql: IDEXPERIENCIALABORAL[" + datos.getIdexplaborl()
						+ "], IDMOTIVOTERMINO[" + datos.getIdmotivotermino() + "], IDEMPRESA[" + datos.getIdempresa()
						+ "], PUESTO[" + datos.getPuesto() + "], FECHAINICIO[" + datos.getFechainicioexp()
						+ "], FECHAFINAL[" + datos.getFechafinalexp() + "], ACTIVIDADES[" + datos.getActividadesreal()
						+ "], LOGROS[" + datos.getLogros() + "], IDTIPOCONTRATO[" + datos.getIdtipocontrato() + "]");
				// Insersion en tabla Experiencia Laboral
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(9, datos.getIdexplaborl());
				ps.setInt(1, datos.getIdmotivotermino());
				ps.setInt(2, datos.getIdempresa());
				ps.setString(3, datos.getPuesto());
				ps.setString(4, datos.getFechainicioexp());
				ps.setString(5, datos.getFechafinalexp());
				ps.setString(6, datos.getActividadesreal());
				ps.setString(7, datos.getLogros());
				ps.setInt(8, datos.getIdtipocontrato());
				ps.execute();
				info("ejecucion de la sentencia sql: " + sql);

				if (datos.getIddescmotivo() != 0) {
					debug("datos entrantes para el sql3: DESCRIPCION[" + datos.getDescripcionexp()
							+ "], IDDESCRIPCIONMOTIVO[" + datos.getIddescmotivo() + "]");
					PreparedStatement ps5 = con.prepareStatement(sql3);
					ps5.setString(1, datos.getDescripcionexp());
					ps5.setLong(2, datos.getIddescmotivo());
					ps5.execute();
					info("ejecucion de la sentencia sql3: " + sql3);
				} else {
					info("IDDESCRIPCIONMOTIVO[" + datos.getIddescmotivo() + "]");
				}
				
				if (datos.getIdmotivotermino() == 4) {
					debug("datos entrantes para el sql6: IDDESCRIPCIONMOTIVO["+IDdesmotivotermino+"], DESCRIPCION["+datos.getDescripcionexp()+"]");
					PreparedStatement ps6 = con.prepareStatement(sql6);
					ps6.setLong(1, IDdesmotivotermino);
					ps6.setString(2, datos.getDescripcionexp());
					ps6.execute();
					info("ejecucion de la sentencia sql6: "+sql6);
					
					debug("datos entrantes para el sql5: IDMOTIVO["+datos.getIdmotivotermino()+"], IDDESCRIPCIONMOTIVO["+IDdesmotivotermino+"], IDEXPERIENCIALABORAL["+datos.getIdexplaborl()+"]");
					PreparedStatement ps7 = con.prepareStatement(sql5);
					ps7.setLong(1, datos.getIdmotivotermino());
					ps7.setLong(2, IDdesmotivotermino);
					ps7.setLong(3, datos.getIdexplaborl());
					ps7.execute();
					info("ejecucion de la sentencia sql5: "+ sql5);
				}else {
					info("IDMOTIVO[" + datos.getIdmotivotermino() + "]");
				}

				debug("datos entrantes para el sql4: IDEXPERIENCIALABORAL[" + datos.getIdexplaborl() + "]");
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setLong(1, datos.getIdexplaborl());
				info("ejecucion de la sentencia sql4: " + sql4);
				return ps4;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int Eliminar(int id) {
		info("entra en el metodo");
		// TODO Auto-generated method stub
		final String sql = "DELETE TBLEXPSLABORALES WHERE IDEXPLABORAL=(?) ";
		final String sql2 = "select * from tblpiv08 where idexplaboral=(?)";
		final String sql3 = "delete tbldescsmotivos where iddescmotivo = (?)";
		final String sql4 = "select * from tblexpslaborales where idexplaboral = (?)";
		final String sql5 ="delete tblempresas where idempresa =(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				
				debug("datos entrantes para el sql4: IDEXPERIENCIALABORAL[" + id + "]");
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setInt(1, id);
				ResultSet rs4= ps4.executeQuery();
				info("ejecucion de la sentencia sql4: "+sql4);
				if(rs4.next());
				int idempresa = rs4.getInt(3);
				int idmotivo = rs4.getInt(2);
				warn("datos obtenido: IDEMPRESA["+idempresa+"], IDMOTIVO["+idmotivo+"]");
				
				if (idmotivo == 4) {
					info("entrando al if");
					debug("datos entrantes para el sql2: IDEXPERIENCIALABORAL[" + id + "]");
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setInt(1, id);
					ResultSet rs2 = ps2.executeQuery();
					info("ejecucion de la sentencia sql2: "+sql2);
					if(rs2.next());
					int iddesc = rs2.getInt(2);
					warn("datos obtenido: IDDESCRIPCIONMOTIVO["+iddesc+"]");
					
					debug("datos entrantes para el sql3: IDDESCRIPCIONMOTIVO[" + iddesc + "]");
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ps3.setInt(1, iddesc);
					ps3.execute();
					info("ejecucion de la sentencia sql3: "+sql3);
					
					debug("datos entrantes para el sql: IDEXPERIENCIALABORAL[" + id + "]");
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ps.execute();
					info("ejecucion de la sentecia sql: " + sql);
					
					debug("datos entrantes para el sql5: IDEMPRESA[" + idempresa + "]");
					PreparedStatement ps6 = con.prepareStatement(sql5);
					ps6.setInt(1, idempresa);
					ps6.execute();
					info("ejecucion de la sentecia sql5: " + sql5);
				}else {
					info("entrando al else");
					
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ps.execute();
					info("ejecucion de la sentecia sql: " + sql);
					
					debug("datos entrantes para el sql5: IDEMPRESA[" + idempresa + "]");
					PreparedStatement ps5 = con.prepareStatement(sql5);
					ps5.setInt(1, idempresa);
					ps5.execute();
					info("ejecucion de la sentecia sql5: " + sql5);
				}
				
				debug("datos entrantes para el sql4(1): IDEXPERIENCIALABORAL[" + (id+1) + "]");
				PreparedStatement ps6 = con.prepareStatement(sql4);
				ps6.setInt(1, (id+1));
				info("ejecucion de la sentecia sql4(1): " + sql4);
				return ps6;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "SELECT DISTINCT * FROM TBLEXPSLABORALES expa LEFT JOIN tblempresas emp ON expa.idempresa=emp.idempresa LEFT JOIN tblpiv08 piv8 ON expa.idexplaboral = piv8.idexplaboral LEFT JOIN tbldescsmotivos descs ON piv8.iddescmotivo = descs.iddescmotivo LEFT JOIN tblmotivos mot ON expa.idmotivoter = mot.idmotivo WHERE  expa.IDEXPLABORAL = (?)";
		final String sql3 = "SELECT * FROM TBLPIV06 WHERE IDPERSONA =(?)";

		// DatosLaboralesBean respuesta = new DatosLaboralesBean();
		// List<DatosLaboralesBean> retorno = new ArrayList<DatosLaboralesBean>();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// PreparedStatement ps3 = con.prepareStatement(sql2);
				debug("datos entrantes para el sql3: IDPERSONA[" + datos.getIdpersona() + "]");
				// Consulta piv06
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setLong(1, datos.getIdpersona());
				ResultSet rs3 = ps3.executeQuery();
				info("ejecucion de la sentencia sql3: " + sql3);
				List<Integer> idexplaboral = new ArrayList<Integer>();
				while (rs3.next()) {

					idexplaboral.add(rs3.getInt(2));
					warn("datos enviado: IDEXPERIENCIALABORAL[" + idexplaboral + "]");
				}
				listalabo = new ArrayList<DatosLaboralesBean>();
				debug("datos entrantes para el sql: IDEXPERIENCIALABORAL[" + idexplaboral
						+ "], NUMERODEEXPERIENCIASLABORALES[" + idexplaboral.size() + "]");
				info("entra en ciclo for");

				for (int i = 0; i < idexplaboral.size(); i++) {
					debug("datos entrantes para el sql: IDEXPERIENCIALABORAL[" + idexplaboral.get(i) + "]");
					// Consulta TBLEXPLABORALES
					PreparedStatement ps2 = con.prepareStatement(sql);
					ps2.setInt(1, idexplaboral.get(i));
					info("ejecucion de la sentencia sql: " + sql);
					setBuscarDatosLaborales(ps2.executeQuery());

				}

				return ps3;
			}
		});

		return getListaDatosLaborales();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosLaboralesBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblexpslaborales";
		return jdbcTemplate.query(sql, new labRowMapper());
	}

	/**
	 * Sets the buscar datos laborales.
	 *
	 * @param rs2
	 *            the new buscar datos laborales
	 * @throws SQLException
	 *             the SQL exception
	 */
	private void setBuscarDatosLaborales(ResultSet rs2) throws SQLException {

		DatosLaboralesBean respuesta = new DatosLaboralesBean();
		info("se enlistaron las experiencias laborales");
		rs2.next();
		respuesta.setIdexplaborl(rs2.getInt(1));
		respuesta.setIdmotivotermino(rs2.getInt(2));
		respuesta.setIdempresa(rs2.getInt(3));
		respuesta.setPuesto(rs2.getString(4));
		respuesta.setFechainicioexp(rs2.getString(5));
		respuesta.setFechafinalexp(rs2.getString(6));
		respuesta.setActividadesreal(rs2.getString(7));
		respuesta.setLogros(rs2.getString(8));
		respuesta.setIdtipocontrato(rs2.getInt(9));
		respuesta.setNombreempresa(rs2.getString(11));
		if (rs2.getString("IDDESCMOTIVO") == null) {
			respuesta.setIddescmotivo(0);
		} else {
			respuesta.setIddescmotivo(rs2.getInt(14));
		}
		if (rs2.getString("DESCRIPCION") == null) {
			respuesta.setDescripcionexp("");
		} else {
			respuesta.setDescripcionexp(rs2.getString(17));
		}
		respuesta.setDescripcionmotivo(rs2.getString(19));
		warn("datos enviados: IDEXPERIENCIALABORAL[" + rs2.getInt(1) + "], IDMOTIVOTERMINO[" + rs2.getInt(2)
				+ "], IDEMPRESA[" + rs2.getInt(3) + "], PUESTO[" + rs2.getString(4) + "], FECHAINICIO["
				+ rs2.getString(5) + "], FECHAFINAL[" + rs2.getString(6) + "], ACTIVIDADES[" + rs2.getString(7)
				+ "], LOGROS[" + rs2.getString(8) + "], IDTIPOCONTRATO[" + rs2.getInt(9) + "], NOMBREEMPRESA["
				+ rs2.getString(11) + "], IDDESCRIPCIONMOTIVO[" + rs2.getInt(14) + "], DESCRIPCION[" + rs2.getString(17)
				+ "], MOTIVO["+rs2.getString(19)+"]");

		listalabo.add(respuesta);

	}

	/**
	 * Gets the lista datos laborales.
	 *
	 * @return the lista datos laborales
	 */
	private List<DatosLaboralesBean> getListaDatosLaborales() {
		return this.listalabo;
	}
}

class labRowMapper implements RowMapper<DatosLaboralesBean> {
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

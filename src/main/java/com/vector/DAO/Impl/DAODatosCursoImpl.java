/**
 * DAODatosCursoImpl.java -- 25/08/2018
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

import com.vector.Beans.DatosCursoBean;
import com.vector.DAO.DAODatosCurso;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.Log;

/**
 * @author Jair
 *
 */
@Service
public class DAODatosCursoImpl extends Log implements DAODatosCurso {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private AutoIncrementablesBDOracle autoin;
	List<DatosCursoBean> datos ;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Crear(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		autoin= new AutoIncrementablesBDOracle();
		long idcurso=autoin.CursoIDUltimo(jdbcTemplate);
		long idcertificado=autoin.CertificadoIDUltimo(jdbcTemplate);
		
		final String sql = "insert into tblcursos values (?,?,?,?,?)";
		final String sql2 ="insert into tblpiv04 values(?,?)";
		final String sql3 ="insert into tblpiv16 values(?,?)";
		final String sql4 ="insert into tblcertificado values(?,?,?)";
		final String sql5 ="select * from tblcursos where idcurso=(?)";
		final String sql6 ="insert into tblpiv14 values(?,?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/*primera insercion*/
				PreparedStatement ps1 = con.prepareStatement(sql);
				debug("datos de entrada para el sql: IDCURSO["+idcurso+"],NOMBRECURSO[" +datos.getNombrecurso()+"],INSTITUTIO["+datos.getInstitutocurso()+"],FECHAINICIO["+datos.getFechainicioc()+"],FECHATERMINO["+ datos.getFechaterminoc()+"]");
				ps1.setLong(1, idcurso);
				ps1.setString(2, datos.getNombrecurso());
				ps1.setString(3, datos.getInstitutocurso());
				ps1.setString(4, datos.getFechainicioc());
				ps1.setString(5, datos.getFechaterminoc());
				ps1.execute();
				info("ejecucion de la sentencia sql: "+sql);
				info("entra en la sentencia if");
				if(datos.getIdcertificado()!=0) {
					/*segunda insercion si se cumple y prerara la sentencia de insertan*/
						PreparedStatement ps3 = con.prepareStatement(sql4);
						debug("datos de entrada para el sql4: IDCERTIFICADO["+idcertificado+"],NOMBRECERTIFICADO["+datos.getNombrecertificado()+"]");
						ps3.setLong(1, idcertificado);
						ps3.setString(3, datos.getNombrecertificado());
						ps3.setInt(2, 7);
						ps3.execute();
						info("ejecucion de la sentencia sql4: "+sql);
					/*tercera insercion si se cumple la segunda*/
						PreparedStatement ps = con.prepareStatement(sql2);
						debug("datos de entrada para el sql2: IDCURSO["+idcurso+"],IDCERTIFICADO["+idcertificado+"]");
						ps.setLong(1, idcurso);
						ps.setLong(2, idcertificado);
						ps.execute();
						info("ejecucion de la sentencia sql2: "+sql2);
				}else{
					
				}
				info("entrando  la sentencia if");
				/*cuarta insercion si se cumple*/
				if(datos.getIdpersona()!=0) {
				PreparedStatement ps3 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: IDCURSO["+idcurso+"], IDPERSONA["+datos.getIdpersona()+"]");
				ps3.setLong(2,idcurso);
				ps3.setLong(1, datos.getIdpersona());
				ps3.execute();
				info("ejecucion de la sentencia sql3: "+sql3);
				}
				info("entrando la sentencia if");
				if(datos.getIdestudio()!=0) {
					PreparedStatement ps4 = con.prepareStatement(sql6);
					debug("datos entrantes para el sql6: "+idcurso+" "+datos.getIdestudio()+"\n");
					ps4.setLong(2,idcurso);
					ps4.setLong(1, datos.getIdestudio());
					ps4.execute();
					info("ejecucion de la sentencia sql6: "+sql6);
					}
				PreparedStatement ps5 = con.prepareStatement(sql5);
				debug("dato entrante para el sql5: NOMBRECURSO["+datos.getNombrecurso()+"]");
					ps5.setInt(1, datos.getIdcurso());
					info("ejecucion de la sentencia sql5: "+sql5);
				return ps5;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Modificar(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosCursoBean datos) {
		autoin= new AutoIncrementablesBDOracle();
		long idcertificado=autoin.CertificadoIDUltimo(jdbcTemplate);
		// TODO Auto-generated method stub
		final String sql = "update tblcursos set nombre =(?), institucion =(?),finicio=(?),ftermino=(?) where idcurso =(?)";
		final String sql7 ="update tblcertificado set nomcertificado = (?) where idcertificado=(?)";
		final String sql2 ="insert into tblcertificado values(?,?,?)";
		final String sql4 = "select * from tblpiv04 where idcurso=(?) and idcertificado=(?)";
		final String sql5 ="insert into tblpiv04 values(?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/*preparando sentencia de select tblpiv04*/
				PreparedStatement ps1 = con.prepareStatement(sql4);
				debug("datos entrantes para el sql4: IDCERTIFICADO["+datos.getIdcertificado()+"], IDCURSO[: "+datos.getIdcurso()+"]");
				ps1.setLong(2, datos.getIdcertificado());
				ps1.setLong(1, datos.getIdcurso());
				ResultSet rs1=ps1.executeQuery();

				/*actualizar si existen datos*/
				if(rs1.next()) {
					info("entra en la sentencia if");
					    PreparedStatement ps = con.prepareStatement(sql);
					    debug("datos entrantes para el sql: IDCURSO["+ datos.getIdcurso()+"],NOMBRECURSO["+datos.getNombrecurso()+"], INSTITUTO["+datos.getInstitutocurso()+"], FECHAINICIO["+datos.getFechainicioc()+"], FECHAFINAL["+datos.getFechaterminoc()+"]");
						ps.setLong(5, datos.getIdcurso());
						ps.setString(1, datos.getNombrecurso());
						ps.setString(2, datos.getInstitutocurso());
						ps.setString(3, datos.getFechainicioc());
						ps.setString(4, datos.getFechaterminoc());
						ps.execute();
						info("ejecucion de la sentencia sql: "+sql);
						PreparedStatement ps7 = con.prepareStatement(sql7);
						debug("datos entrantes para el sql7: IDCERTIFICADO["+ datos.getIdcertificado()+"], NOMBRECERTIFICADO"+datos.getNombrecertificado()+"]");
						ps7.setLong(2, datos.getIdcertificado());
						ps7.setString(1, datos.getNombrecertificado());
						ps7.execute();
						info("ejecucion de la sentencia sql7: "+sql7);
	
				}
				else if(datos.getIdcertificado()==0){
					info("entrando en else if");
					PreparedStatement ps = con.prepareStatement(sql);
						debug("datos entrantes al sql: IDCURSO["+ datos.getIdcurso()+"], NOMBRE["+datos.getNombrecurso()+"], INSTITUTO["+datos.getInstitutocurso()+"], FECHAINICIO["+datos.getFechainicioc()+"], FECHAFINAL["+datos.getFechaterminoc()+"]");
						ps.setLong(5, datos.getIdcurso());
						ps.setString(1, datos.getNombrecurso());
						ps.setString(2, datos.getInstitutocurso());
						ps.setString(3, datos.getFechainicioc());
						ps.setString(4, datos.getFechaterminoc());
						ps.execute();
						info("ejecucion de la sentencia sql: "+sql);
				}
				else {
							info("entrando en else");	
							PreparedStatement ps3 = con.prepareStatement(sql2);
							debug("datos de entrada para el sql2: IDCERTIFICADO["+idcertificado+"], NOMBRECERTIFICADO["+datos.getNombrecertificado()+"]");
							ps3.setLong(1, idcertificado);
							ps3.setString(3, datos.getNombrecertificado());
							ps3.setInt(2, 8);
							ps3.execute();
							info("ejecucion de la sentencia sql2: "+sql2);
							PreparedStatement ps5 = con.prepareStatement(sql5);
							debug("datos de entrada para el sql5: IDCURSO["+datos.getIdcurso()+"], IDCERTIFICADO["+idcertificado+"]");
							ps5.setLong(1, datos.getIdcurso());
							ps5.setLong(2, idcertificado);
							ps5.execute();   
							info("ejecucion de la sentencia sql5: "+sql5);
						}
				info("ejecucion de la sentencia sql4: "+sql4);
				return ps1;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		final String sql="delete tblcursos where idcurso = (?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para el sql: IDCURSO["+datos.getIdcurso()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdcurso());

				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Buscar(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosCursoBean> Buscar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpersonas pe,tblpiv16 piv16,tblcursos cur where pe.idpersona=piv16.idpersona and piv16.idcurso=cur.idcurso and piv16.idpersona =(?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para el sql: IDPERSONA["+datos.getIdpersona()+"]");
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
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Listar()
	 */
	@Override
	public List<DatosCursoBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblcursos";
		info("ejecucion de la sentencia sql: "+sql);
		return jdbcTemplate.query(sql, new CursoRowMapper());
	}
	
	private void setDatosCurso(ResultSet rs) throws SQLException{
		datos= new ArrayList<DatosCursoBean>();
		DatosCursoBean respuesta;
		info("entra en el while");
		while(rs.next()) {
			respuesta = new DatosCursoBean();
			respuesta.setIdcurso(rs.getInt(11));
			respuesta.setNombrecurso(rs.getString(12));
			respuesta.setInstitutocurso(rs.getString(13));
			respuesta.setFechainicioc(rs.getString(14));
			respuesta.setFechaterminoc(rs.getString(15));
			respuesta.setIdpersona(rs.getLong(1));
			warn("datos enviados: IDCURSO["+rs.getInt(11)+"], NOMBRECURSO["+rs.getString(12)+"], INSTITUTO["+rs.getString(13)+"], FECHAINICIO["+rs.getString(14)+"], FECHATERMINO["+rs.getString(15)+"], IDPERSONA["+rs.getLong(1)+"]");	
			this.datos.add(respuesta);
			}
	}

	private List<DatosCursoBean>getDatosCurso(){
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
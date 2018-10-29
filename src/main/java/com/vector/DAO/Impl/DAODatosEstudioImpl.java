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

import com.vector.Beans.DatosEstudioBean;
import com.vector.DAO.DAODatosEstudio;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosEstudioImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class DAODatosEstudioImpl extends Log implements DAODatosEstudio {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The autoin. */
	private AutoIncrementablesBDOracle autoin;
	
	/** The datos. */
	List<DatosEstudioBean> datos ;

	/** 
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	public long Crear(DatosEstudioBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		autoin= new AutoIncrementablesBDOracle();
		long idcarrera=autoin.CarreraIDUltimo(jdbcTemplate);
		long idestudio=autoin.EstudioIDUltimo(jdbcTemplate);
		
		final String sql = "insert into tblestudios values (?,?,?,?,?,?,?)";
		final String sql2 ="insert into tblcarreras values (?,?)";
		final String sql3 ="insert into tblpiv05 values(?,?)";
		final String sql4 ="insert into tblpiv14 values(?,?)";
		final String sql5 ="insert into tblpiv15 values(?,?)";
		final String sql6="select * from tblestudios where idestudio=(?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para el sql2:  IDCARRERA["+idcarrera+"], NOMBRECARRERA["+datos.getNombrecorrera()+"]");
				/*primera insercion*/
				PreparedStatement ps1 = con.prepareStatement(sql2);
				ps1.setLong(1, idcarrera);
				ps1.setString(2, datos.getNombrecorrera());
				ps1.execute();
				info("ejecucion de la sentencia sql2: "+sql2);
				/*segunda insercion*/
				debug("datos de entrada para el sql: IDESTUDIO["+idestudio+"],IDGRADO["+datos.getIdgrado()+"], IDCARRERA["+idcarrera+"], LOCALIDAD["+datos.getIdlocalidad()+"], INSTITUTO["+datos.getInstitutoestudio()+"], PERIODPINICIAL["+datos.getPeriodoinicial()+"], PERIODOFINAL["+datos.getPeriodofinal()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, idestudio);
				ps.setInt(2, datos.getIdgrado());
				ps.setLong(3, idcarrera);
				ps.setInt(4, datos.getIdlocalidad());	
				ps.setString(5, datos.getInstitutoestudio());	
				ps.setString(6, datos.getPeriodoinicial());
				ps.setString(7, datos.getPeriodofinal());
				ps.execute();
				info("ejecucion de la sentencia sql: "+sql);
				
				/*tercera insercion*/
				if(datos.getIdcertificado()!=0) {
					info("entra en la sentencia if");
					debug("datos entrantes para el sql3: IDCERTIFICADO["+datos.getIdcertificado()+"], IDESTUDIO["+idestudio+"]");
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setLong(1,idestudio);
				ps3.setLong(2, datos.getIdcertificado());
				ps3.execute();
				info("ejecucion de la sentencia sql3: "+sql3);
				}
				
			
				/*cuarta insercion*/
				if(datos.getIdcurso()!=0) {
					info("entra en la sentencia if");
					debug("datos entrantes para el sql4: IDCURSO["+datos.getIdcurso()+"], IDESTUDIO["+idestudio+"]");
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setLong(1,idestudio);
				ps4.setLong(2, datos.getIdcurso());
				ps4.execute();
				info("ejecucion de la sentencia sql4: "+sql4);
				}
				/*quinta insercion*/
				PreparedStatement ps5 = con.prepareStatement(sql5);
				debug("datos entrantes para el sql5: IDPERSONA["+datos.getIdpersona()+"], IDESTUDIO["+idestudio+"]");
				ps5.setLong(1,idestudio);
				ps5.setLong(2, datos.getIdpersona());
				ps5.execute();
				info("ejecucion de la sentencia sql5: "+sql5);
				
				PreparedStatement ps6 = con.prepareStatement(sql6);
				debug("datos entrantes para el sql6: IDESTUDIO["+idestudio+"]");
				ps6.setLong(1, idestudio);
				info("ejecucion de la sentencia sql6: "+sql6);
				return ps6;
			}
		});
		if(respuesta==1) {
			warn("datos enviados: IDESTUDIO["+idestudio+"],RESPUESTA["+respuesta+"]");
			return idestudio;
			
		}else {
			error("dato no enviado");
			return 0;
		}
		
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosEstudioBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "update tblcarreras set NOMCARRERA =(?) where IDCARRERA =(?)";
		final String sql2 ="update tblestudios set idgrado=(?),idlocalidad=(?),instituto=(?),peinicial=(?),pefinal=(?) where idestudio =(?)";
		final String sqlaux = "select * from tblestudios where idestudio =(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/**consulta para retornar el id de carrera para su actualizacion en tabla*/
				debug("datos entrantes para el sqlaux: IDESTUDIO["+datos.getIdestudio()+"]");
				PreparedStatement psaux = con.prepareStatement(sqlaux);
				psaux.setLong(1, datos.getIdestudio());
				ResultSet rsaux = psaux.executeQuery();
				rsaux.next();
				info("ejecucion de la sentencia sqlaux: "+sqlaux);
				int idcarrera = (rsaux.getInt(3));
				warn("datos enviados: IDCARRERA["+idcarrera+"]");
				/*primera insercion*/
				debug("datos entrantes para el sql: IDCARRERA["+idcarrera+"], NOMBRECARRERA["+datos.getNombrecorrera()+"]");
				PreparedStatement ps1 = con.prepareStatement(sql);
				ps1.setInt(2, idcarrera);
				ps1.setString(1, datos.getNombrecorrera());
				ps1.execute();
				info("ejecucion de la sentencia sql: "+sql);
				/*segunda insercion*/
				debug("datos entrantes para el sql2: IDESTUDIO["+datos.getIdestudio()+"], IDGRADO["+datos.getIdgrado()+"], IDLOCALIDAD["+datos.getIdlocalidad()+"], INSTITUTO["+ datos.getInstitutoestudio()+"],PERIODOINICIAL"+datos.getPeriodoinicial()+"], PERIODOFINAL["+datos.getPeriodofinal()+"]");
				PreparedStatement ps = con.prepareStatement(sql2);
				ps.setLong(6, datos.getIdestudio());
				ps.setInt(1, datos.getIdgrado());
				ps.setInt(2, datos.getIdlocalidad());	
				ps.setString(3, datos.getInstitutoestudio());	
				ps.setString(4, datos.getPeriodoinicial());
				ps.setString(5, datos.getPeriodofinal());				
				info("ejecucion de la sentencia sql2: "+sql2);
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
	public int Eliminar(DatosEstudioBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		//final String sql="delete tblestudios where idestudio = (?)";
		final String sql2="Select * from tblestudios where idestudio = (?)";
		final String sql3="delete tblcarreras where idcarrera =(?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrates para el sql2: IDESTUDIO["+datos.getIdestudio()+"]");
				PreparedStatement psAux = con.prepareStatement(sql2);
				psAux.setLong(1, datos.getIdestudio());
				ResultSet rsAux = psAux.executeQuery();
				rsAux.next();
				info("ejecucion de la sentencia sql2: "+sql2);
				int idAux2 = Integer.parseInt(rsAux.getString(3));
				info("datos enviados: IDCARRERA["+idAux2+"]");
				if(idAux2 != 0) {
				info("entra en la sentencia if");
				debug("datos entrantes para el sql3: IDCARRERA["+idAux2+"]");
				PreparedStatement ps1 = con.prepareStatement(sql3);
				ps1.setLong(1, idAux2);
				ps1.execute();
				info("ejecucion de la sentencia sql3: "+sql3);
				
				info("se elimino la carrera con id: "+idAux2+"y el estudio con id: "+datos.getIdestudio());
				}
				debug("datos entrantes para el sql2: IDESTUDIO["+datos.getIdestudio()+"]");
				PreparedStatement ps2 = con.prepareStatement(sql2);		
				ps2.setLong(1, datos.getIdestudio());
				info("ejecucion de la sentencia sql2: "+sql2);
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
	public List<DatosEstudioBean> Buscar(DatosEstudioBean datos) {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tblestudios est,tblcarreras carr,tblgradosests gra,tbllocalidades loc, tblpiv15 piv where est.idcarrera = carr.idcarrera and est.idlocalidad = loc.idlocalidad and est.idgrado = gra.idgrado and piv.idestudio=est.idestudio and piv.idpersona = (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				info("llamado al metodo setDatosEstudio(rs)");
				setDatosEstudio(rs);
				return ps;
			}
		});
		info("llamado al metodo getDatosEstudio()");
		List<DatosEstudioBean> retorno = getDatosEstudio();
		return retorno;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		info("entrando al metodo");
		// TODO Auto-generated method stub
		final String sql = "select * from tblestudios est,tblcarreras carr,tblgradosests gra,tbllocalidades loc where est.idcarrera = carr.idcarrera and est.idlocalidad = loc.idlocalidad and est.idgrado = gra.idgrado";
		info("ejecucion de la sentencia sql: "+sql);
		return jdbcTemplate.query(sql, new EstudioRowMapper());
	}

/**
 * Sets the datos estudio.
 *
 * @param rs the new datos estudio
 * @throws SQLException the SQL exception
 */
private void setDatosEstudio(ResultSet rs) throws SQLException{
	datos= new ArrayList<DatosEstudioBean>();
	DatosEstudioBean respuesta;
	info("se enlistaron los estudios");
	while(rs.next()) {
		respuesta = new DatosEstudioBean();
		respuesta.setIdgrado(rs.getInt(2));
		respuesta.setIdcarrera(rs.getInt(3));
		respuesta.setIdlocalidad(rs.getInt(4));
		respuesta.setInstitutoestudio(rs.getString(5));
		respuesta.setPeriodoinicial(rs.getString(6));
		respuesta.setPeriodofinal(rs.getString(7));
		respuesta.setNombrelocalidad(rs.getString(15));		
		respuesta.setNombregrado(rs.getString(11));				
		respuesta.setNombrecorrera(rs.getString(9));
	/*	respuesta.setNombreestado(rs.getString(25));
		respuesta.setNombremunicipio(rs.getString(21));*/
		respuesta.setIdestudio(rs.getLong(1));
		warn("datos enviados: IDGRADO["+rs.getInt(2)+"], IDCARRERA["+rs.getInt(3)+"], IDLOCALIDAD["+rs.getInt(4)+"], INSTITUTIO["+rs.getString(5)+"], PERIODOINICIAL["+rs.getString(6)+"], PERIODOFINAL"+rs.getString(7)+"], NOMBRELOCALIDAD["+rs.getString(15)+"], NOMBREGRADO["+rs.getString(11)+"], NOMBRECARRERA["+rs.getString(9)+"], IDESTUDIO["+rs.getLong(1)+"]");
		this.datos.add(respuesta);
		}
}

/**
 * Gets the datos estudio.
 *
 * @return the datos estudio
 */
private List<DatosEstudioBean>getDatosEstudio(){
	return this.datos;
}
}

class EstudioRowMapper implements RowMapper<DatosEstudioBean> {
	@Override
	public DatosEstudioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosEstudioBean respuesta = new DatosEstudioBean();
		respuesta.setIdestudio(rs.getLong(1));
		respuesta.setIdgrado(rs.getInt(2));
		respuesta.setIdcarrera(rs.getInt(3));
		respuesta.setIdlocalidad(rs.getInt(4));
		respuesta.setInstitutoestudio(rs.getString(5));
		respuesta.setPeriodoinicial(rs.getString(6));
		respuesta.setPeriodofinal(rs.getString(7));
		respuesta.setNombrecorrera(rs.getString(9));
		respuesta.setNombregrado(rs.getString(11));
		respuesta.setNombrelocalidad(rs.getString(15));
		return respuesta;
	}
}

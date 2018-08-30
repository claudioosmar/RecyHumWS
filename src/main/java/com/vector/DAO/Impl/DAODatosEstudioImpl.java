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

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosEstudioImpl implements DAODatosEstudio {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private AutoIncrementablesBDOracle autoin;
	List<DatosEstudioBean> datos ;

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Crear(com.vector.Beans.DatosEstudioBean)
	 */

	@Transactional(readOnly = true)
	public long Crear(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		autoin= new AutoIncrementablesBDOracle();
		long idcarrera=autoin.CarreraIDUltimo(jdbcTemplate);
		long idestudio=autoin.EstudioIDUltimo(jdbcTemplate);
		
		final String sql = "insert into tblestudios values (?,?,?,?,?,?,?)";
		final String sql2 ="insert into tblcarreras values (?,?)";
		final String sql3 ="insert into tblpiv05 values(?,?)";
		final String sql4 ="insert into tblpiv14 values(?,?)";
		final String sql5 ="insert into tblpiv15 values(?,?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/*primera insercion*/
				PreparedStatement ps1 = con.prepareStatement(sql2);
				ps1.setLong(1, idcarrera);
				ps1.setString(2, datos.getNombrecorrera());
				ps1.execute();
				/*segunda insercion*/
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, idestudio);
				ps.setInt(2, datos.getIdgrado());
				ps.setLong(3, idcarrera);
				ps.setInt(4, datos.getIdlocalidad());	
				ps.setString(5, datos.getInstitutoestudio());	
				ps.setString(6, datos.getPeriodoinicial());
				ps.setString(7, datos.getPeriodofinal());
				ps.execute();
				/*tercera insercion*/
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setLong(1,idestudio);
				ps3.setLong(2, datos.getIdcertificado());
				ps3.execute();
				/*cuarta insercion*/
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setLong(1,idestudio);
				ps4.setLong(2, datos.getIdcurso());
				ps4.execute();
				/*quinta insercion*/
				PreparedStatement ps5 = con.prepareStatement(sql5);
				ps5.setLong(1,idestudio);
				ps5.setLong(2, datos.getIdpersona());
	
				return ps5;
			}
		});
		if (respuesta==1) {
			return idestudio;
		}else {
			return 0;
		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Modificar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		final String sql = "update tblcarreras set nomcarrera =(?) where idcarrera =(?)";
		final String sql2 ="update tblestudios set idgrado=(?),idcarrera=(?),idlocalidad=(?),instituto=(?),peinicial=(?),pefinal=(?) where idestudio =(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/*primera insercion*/
				PreparedStatement ps1 = con.prepareStatement(sql);
				ps1.setInt(2, datos.getIdcarrera());
				ps1.setString(1, datos.getNombrecorrera());
				ps1.execute();
				
				/*segunda insercion*/
				PreparedStatement ps = con.prepareStatement(sql2);
				ps.setLong(7, datos.getIdestudio());
				ps.setInt(1, datos.getIdgrado());
				ps.setInt(2, datos.getIdcarrera());
				ps.setInt(3, datos.getIdlocalidad());	
				ps.setString(4, datos.getInstitutoestudio());	
				ps.setString(5, datos.getPeriodoinicial());
				ps.setString(6, datos.getPeriodofinal());				
			
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		final String sql="delete tblcarreras where idcarrera = (?)";
		final String sql2="Select * from tblcarreras where idcarrera = (?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdcarrera());
				ps.execute();
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, datos.getIdcarrera());

				return ps2;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Buscar(com.vector.Beans.DatosEstudioBean)
	 */
	@Override
	public List<DatosEstudioBean> Buscar(DatosEstudioBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblestudios est,tblcarreras carr,tblgradosests gra,tbllocalidades loc, tblpiv15 piv where est.idcarrera = carr.idcarrera and est.idlocalidad = loc.idlocalidad and est.idgrado = gra.idgrado and piv.idestudio=est.idestudio and piv.idpersona = (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				setDatosEstudio(rs);
				return ps;
			}
		});
		List<DatosEstudioBean> retorno = getDatosEstudio();
		return retorno;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosEstudio#Listar()
	 */
	@Override
	public List<DatosEstudioBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblestudios est,tblcarreras carr,tblgradosests gra,tbllocalidades loc where est.idcarrera = carr.idcarrera and est.idlocalidad = loc.idlocalidad and est.idgrado = gra.idgrado";
		return jdbcTemplate.query(sql, new EstudioRowMapper());
	}

private void setDatosEstudio(ResultSet rs) throws SQLException{
	datos= new ArrayList<DatosEstudioBean>();
	DatosEstudioBean respuesta;
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
		this.datos.add(respuesta);
		}
}

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

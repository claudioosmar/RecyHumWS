/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;

/**
 * @author Claudio
 *
 */
@Service
public class DAODatosPersonalesImpl implements DAODatosPersonales  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Create(com.vector.model.Modelo)
	 */
	
	@Transactional(readOnly = true)
	public int Crear(DatosPersonalesBean datos) {
		
		final String sql="execute SP_AGREGARPERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdestadocivil());
				ps.setString(6, datos.getNombrepersona());
				ps.setString(7, datos.getSegundonombre());
				ps.setString(8, datos.getApellidopaterno());
				ps.setString(9, datos.getApellidomaterno());
				ps.setString(10, datos.getSexo());
				ps.setString(11, datos.getFechanacimiento());
				ps.setString(12, datos.getNacionalidad());
				ps.setString(13, datos.getCalle());
				ps.setString(14, datos.getColonia());
				ps.setString(15, datos.getNumerointerior());
				ps.setString(16, datos.getNumeroexterior());
				ps.setLong(17, datos.getIdcodigopostal());
				ps.setString(18, datos.getUrlfoto());
				ps.setString(19, datos.getResumen());
				ps.setString(20, datos.getObjetivolaboral());
				ps.setInt(21,datos.getIdidioma());
				ps.setInt(22,datos.getPcjescrito());
				ps.setInt(23,datos.getPcjhablado());
				ps.setInt(24,datos.getPcjentendido());
				ps.setString(25,datos.getDescripciondominio());
				ps.setString(26,datos.getIdiomanativa());
				ps.setInt(27, datos.getIdtipotelefono());
				ps.setString(28, datos.getTelefono());
				ps.setString(29, datos.getCorreo());
				ps.setInt(30, datos.getIdtipocorreo());	
				ps.setInt(31, datos.getIddocumento());
				ps.setString(32, datos.getDescripciondoc());
				ps.setString(33, datos.getUrldoc());
				ps.setInt(34, datos.getIdotrodocs());
				ps.setInt(35, datos.getIdherramienta());
				ps.setInt(36, datos.getPorcentaje());
				ps.setInt(37, datos.getAños());
				ps.setString(38, datos.getDescripcion());
				ps.setInt(39, datos.getIdgrado());
				ps.setInt(40, datos.getIdlocalidad());
				ps.setString(41, datos.getInstitutoestudio());
				ps.setString(42, datos.getPeriodoinicial());
				ps.setString(43, datos.getPeriodofinal());
				ps.setString(44, datos.getNombrecarrera());
				ps.setString(45, datos.getNombrecurso());
				ps.setString(46, datos.getInstitutocurso());
				ps.setString(47, datos.getFechainicioc());
				ps.setString(48, datos.getFechaterminoc());
				ps.setString(49, datos.getNombrecertificado());
				ps.setString(50, datos.getNombreempresa());
				ps.setInt(51, datos.getIdmotivotermino());
				ps.setString(52, datos.getPuesto());
				ps.setString(53, datos.getFechainical());
				ps.setString(54, datos.getFechafinal());
				ps.setString(55, datos.getActividadesrealizadas());
				ps.setString(56, datos.getLogros());
				ps.setInt(57, datos.getIdtipocontrato());
				ps.setString(58, datos.getDescripcionmotivo());
				ps.setInt(59, datos.getIdherramientau());
				ps.setInt(60, datos.getPorcentajeu());
				ps.setInt(61, datos.getAñosexpu());
				ps.setString(62, datos.getDescripcionherram());
				
				return ps;
			}
		});
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Delete(int)
	 */
	@Transactional(readOnly = true)
	public String Eliminar(int id) {
		//final String  sql = "";
		
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Buscar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public DatosPersonalesBean Buscar(DatosPersonalesBean datos) {
		
		DatosPersonalesBean bean = new DatosPersonalesBean();
		
		
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Listar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public List<DatosPersonalesBean> Listar() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from view_datospersonales", new DatPerRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosPersonales#Actualizar(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public int Modificar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarpersona01(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdestadocivil());
				ps.setString(6, datos.getNombrepersona());
				ps.setString(7, datos.getSegundonombre());
				ps.setString(8, datos.getApellidopaterno());
				ps.setString(9, datos.getApellidomaterno());
				ps.setString(10, datos.getSexo());
				ps.setString(11, datos.getFechanacimiento());
				ps.setString(12, datos.getNacionalidad());
				ps.setString(13, datos.getCalle());
				ps.setString(14, datos.getColonia());
				ps.setString(15, datos.getNumerointerior());
				ps.setString(16, datos.getNumeroexterior());
				ps.setLong(17, datos.getIdcodigopostal());
				ps.setString(18, datos.getUrlfoto());
				ps.setString(19, datos.getResumen());
				ps.setString(20, datos.getObjetivolaboral());
				ps.setInt(21,datos.getIdidioma());
				ps.setInt(22,datos.getPcjescrito());
				ps.setInt(23,datos.getPcjhablado());
				ps.setInt(24,datos.getPcjentendido());
				ps.setString(25,datos.getDescripciondominio());
				ps.setString(26,datos.getIdiomanativa());
				ps.setInt(27, datos.getIdtipotelefono());
				ps.setString(28, datos.getTelefono());
				ps.setString(29, datos.getCorreo());
				ps.setInt(30, datos.getIdtipocorreo());	
				ps.setInt(31, datos.getIddocumento());
				ps.setString(32, datos.getDescripciondoc());
				ps.setString(33, datos.getUrldoc());
				ps.setInt(34, datos.getIdotrodocs());
				ps.setInt(35, datos.getIdherramienta());
				ps.setInt(36, datos.getPorcentaje());
				ps.setInt(37, datos.getAños());
				ps.setString(38, datos.getDescripcion());
				ps.setInt(39, datos.getIdgrado());
				ps.setInt(40, datos.getIdlocalidad());
				ps.setString(41, datos.getInstitutoestudio());
				ps.setString(42, datos.getPeriodoinicial());
				ps.setString(43, datos.getPeriodofinal());
				ps.setString(44, datos.getNombrecarrera());
				ps.setString(45, datos.getNombrecurso());
				ps.setString(46, datos.getInstitutocurso());
				ps.setString(47, datos.getFechainicioc());
				ps.setString(48, datos.getFechaterminoc());
				ps.setString(49, datos.getNombrecertificado());
				ps.setString(50, datos.getNombreempresa());
				ps.setInt(51, datos.getIdmotivotermino());
				ps.setString(52, datos.getPuesto());
				ps.setString(53, datos.getFechainical());
				ps.setString(54, datos.getFechafinal());
				ps.setString(55, datos.getActividadesrealizadas());
				ps.setString(56, datos.getLogros());
				ps.setInt(57, datos.getIdtipocontrato());
				ps.setString(58, datos.getDescripcionmotivo());
				ps.setInt(59, datos.getIdherramientau());
				ps.setInt(60, datos.getPorcentajeu());
				ps.setInt(61, datos.getAñosexpu());
				ps.setString(62, datos.getDescripcionherram());
				ps.setLong(63, datos.getIddireccion());
				ps.setLong(64, datos.getIdpersona());
				ps.setInt(65, datos.getIddetallepersona());
				ps.setInt(66, datos.getIdcarrera());
				ps.setInt(67, datos.getIdcurso());
				ps.setInt(68, datos.getIdcertificado());
				ps.setInt(69, datos.getIdestudio());
				ps.setInt(70, datos.getIddominio());
				ps.setInt(71, datos.getIdexplaboral());
				
				ps.setInt(72, datos.getIdempresa());
				ps.setInt(73, datos.getIddescmotivo());
				ps.setInt(74, datos.getIddocumento());
				ps.setInt(75, datos.getIdherramientacon());
				ps.setInt(76, datos.getIdherramientausa());
				ps.setInt(77, datos.getIdtipotelefono());
				ps.setInt(78, datos.getIdtipocorreo());
				
				return ps;
			}
		});
		return respuesta;
	}


}
class DatPerRowMapper implements RowMapper<DatosPersonalesBean> {
	@Override
	public DatosPersonalesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosPersonalesBean datos = new DatosPersonalesBean();
		datos.setIduser(rs.getInt(1));
		datos.setFormulario(rs.getString(2));
		datos.setAccion(rs.getString(3));
		datos.setIpequipo(rs.getString(4));
		datos.setIdestadocivil(rs.getInt(5));
		datos.setNombrepersona(rs.getString(6));
		datos.setSegundonombre(rs.getString(7));
		datos.setApellidopaterno(rs.getString(8));
		datos.setApellidomaterno(rs.getString(9));
		datos.setSexo(rs.getString(10));
		datos.setFechanacimiento(rs.getString(11));
		datos.setNacionalidad(rs.getString(12));
		datos.setCalle(rs.getString(13));
		datos.setColonia(rs.getString(14));
		datos.setNumerointerior(rs.getString(15));
		datos.setNumeroexterior(rs.getString(16));
		datos.setIdcodigopostal(rs.getLong(17));
		datos.setUrlfoto(rs.getString(18));
		datos.setResumen(rs.getString(19));
		datos.setObjetivolaboral(rs.getString(20));
		datos.setIdidioma(rs.getInt(21));
		datos.setPcjescrito(rs.getInt(22));
		datos.setPcjhablado(rs.getInt(23));
		datos.setPcjentendido(rs.getInt(24));
		datos.setDescripciondominio(rs.getString(25));
		datos.setIdiomanativa(rs.getString(26));
		datos.setIdtipotelefono(rs.getInt(27));
		datos.setTelefono(rs.getString(28));
		datos.setCorreo(rs.getString(29));
		datos.setIdtipocorreo(rs.getInt(30));	
		datos.setIddocumento(rs.getInt(31));
		datos.setDescripciondoc(rs.getString(32));
		datos.setUrldoc(rs.getString(33));
		datos.setIdotrodocs(rs.getInt(34));
		datos.setIdherramienta(rs.getInt(35));
		datos.setPorcentaje(rs.getInt(36));
		datos.setAños(rs.getInt(37));
		datos.setDescripcion(rs.getString(38));
		datos.setIdgrado(rs.getInt(39));
		datos.setIdlocalidad(rs.getInt(40));
		datos.setInstitutoestudio(rs.getString(41));
		datos.setPeriodoinicial(rs.getString(42));
		datos.setPeriodofinal(rs.getString(43));
		datos.setNombrecarrera(rs.getString(44));
		datos.setNombrecurso(rs.getString(45));
		datos.setInstitutocurso(rs.getString(46));
		datos.setFechainicioc(rs.getString(47));
		datos.setFechaterminoc(rs.getString(48));
		datos.setNombrecertificado(rs.getString(49));
		datos.setNombreempresa(rs.getString(50));
		datos.setIdmotivotermino(rs.getInt(51));
		datos.setPuesto(rs.getString(52));
		datos.setFechainical(rs.getString(53));
		datos.setFechafinal(rs.getString(54));
		datos.setActividadesrealizadas(rs.getString(55));
		datos.setLogros(rs.getString(56));
		datos.setIdtipocontrato(rs.getInt(57));
		datos.setDescripcionmotivo(rs.getString(58));
		datos.setIdherramientau(rs.getInt(59));
		datos.setPorcentajeu(rs.getInt(60));
		datos.setAñosexpu(rs.getInt(61));
		datos.setDescripcionherram(rs.getString(62));

		return datos;
	}
}

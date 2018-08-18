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
	public DatosPersonalesBean Crear(DatosPersonalesBean datos) {
		
		final String sql="execute SP_AGREGARPERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIP());
				ps.setLong(5, datos.getIdarea());
				ps.setLong(6, datos.getIdcodpost());
				ps.setLong(7, datos.getIdedocivil());
				ps.setLong(8, datos.getIdtipotelefono());
				ps.setLong(9, datos.getIdtipocorreo());
				ps.setLong(10, datos.getIddoc());
				ps.setLong(11, datos.getIdestudio());
				ps.setLong(12, datos.getIdherramientas());
				ps.setString(13, datos.getNombre());
				ps.setString(14, datos.getSegnombre());
				ps.setString(15, datos.getApellidop());
				ps.setString(16, datos.getApellidom());
				ps.setString(17, datos.getSexo());
				ps.setString(18, datos.getFechanac());
				ps.setString(19, datos.getNacionalidad());
				ps.setString(20, datos.getUrlfoto());
				ps.setString(21, datos.getStatus());
				ps.setString(22, datos.getResumen());
				ps.setString(23, datos.getObjlaboral());
				ps.setString(24, datos.getNcontrol());
				ps.setString(25, datos.getCalle());
				ps.setString(26, datos.getColonia());
				ps.setString(27, datos.getNuminter());
				ps.setString(28, datos.getNumext());
				ps.setString(29, datos.getDescripcion());
				ps.setString(30, datos.getUrldoc());
				ps.setString(31, datos.getCorreo());
				ps.setString(32, datos.getTelefono());
				ps.setString(33, datos.getPorcentaje());
				ps.setInt(34, datos.getAñosexp());
				ResultSet rs = ps.executeQuery();
				rs.next();
				datos.setResp(rs.getString(1));
				return ps;
			}
		});
		return datos;
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
	public DatosPersonalesBean Actualizar(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		return null;
	}


}
class DatPerRowMapper implements RowMapper<DatosPersonalesBean> {
	@Override
	public DatosPersonalesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosPersonalesBean datos = new DatosPersonalesBean();
		datos.setIdp(rs.getLong("IDP"));
		datos.setNombre(rs.getString("NOMBREPERSONA"));
		datos.setSegnombre(rs.getString("SEGUNDONOMBRE"));
		datos.setApellidop(rs.getString("APELLIDOPATERNO"));
		datos.setApellidom(rs.getString("APELLIDOMATERNO"));
		datos.setSexo(rs.getString("SEXO"));
		datos.setFechanac(rs.getString("FECHANACIMIENTO"));
		datos.setNacionalidad(rs.getString("NACIONALIDAD"));
		datos.setResumen(rs.getString("RESUMEN"));
		datos.setObjlaboral(rs.getString("OBJETIVOLABORAL"));
		datos.setSueldo(rs.getString("SUELDO"));
		datos.setNcontrol(rs.getString("NUMEROCONTROL"));
		datos.setEstadoCivil(rs.getString("ESTADOCIVIL"));
		datos.setStatus(rs.getString("STATUS"));
		datos.setNombrearea(rs.getString("NOMBREAREA"));
		datos.setTelefono(rs.getString("TELEFONO"));
		datos.setCorreo(rs.getString("CORREO"));
		datos.setTipocorreo(rs.getString("TIPOCORREO"));
		datos.setNombredocumento(rs.getString("NOMBREDOCUMENTO"));
		datos.setNombreherramienta(rs.getString("NOMBREHERRAMIENTA"));
		datos.setVersionherramienta(rs.getString("VERSIONHERRAMIENTA"));
		datos.setPorcentaje(rs.getString("PORCENTAJECONECERLA"));
		datos.setAñosexp(rs.getInt("AÑOSEXPERIENCIA"));
		datos.setEstado(rs.getString("NOMBREESTADO"));
		datos.setMunicipio(rs.getString("NOMBREMUNICIPIO"));
		datos.setLocalidad(rs.getString("LOCALIDAD"));
		datos.setCodpostal(rs.getString("CODIGOPOSTAL"));
		datos.setCalle(rs.getString("CALLE"));
		datos.setColonia(rs.getString("COLONIA"));
		datos.setNuminter(rs.getString("NUMEROINTERIOR"));
		datos.setNumext(rs.getString("NUMEROEXTERIOR"));
		return datos;
	}
}

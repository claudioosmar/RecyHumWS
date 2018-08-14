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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vector.BO.BODatosPersonales;
import com.vector.Beans.Model;
import com.vector.Beans.DatosPersonales.DatosPersonalesBean;

/**
 * @author Claudio
 *
 */
@Repository
public class DAODatosPersonalesImpl implements BODatosPersonales  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Create(com.vector.model.Modelo)
	 */
	
	@Transactional(readOnly = true)
	public String Create(DatosPersonalesBean datos) {
		
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
				ps.setInt(33, datos.getPorcentaje());
				ps.setInt(34, datos.getAñosexp());
				ResultSet rs = ps.executeQuery();
				rs.next();
				datos.setResp(rs.getString(1));
				return ps;
			}
		});
		return datos.getResp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Delete(int)
	 */
	@Transactional(readOnly = true)
	public String Delete(int id) {
		//final String  sql = "";
		
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Buscar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public Model Buscar(DatosPersonalesBean datos) {
		
		DatosPersonalesBean bean = new DatosPersonalesBean();
		
		
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Listar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public List<Model> Listar(DatosPersonalesBean  datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.SesionDAO#Listar()
	 */

	public List<DatosPersonalesBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

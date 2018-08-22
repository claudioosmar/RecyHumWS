/**
 * 
 */
package com.vector.DAO.Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;
import com.vector.Beans.Model;
import com.vector.DAO.DAODatosSesion;
import com.vector.Utileria.*;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosSesionImpl implements DAODatosSesion {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private List<DatosFormularioBean> listaform;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Create(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Create(DatosInicioSesionBean datos) {
		final String sql = "begin sp_agregarusuario(?,?,?,?,?,?,?,?,?); end;";
		datos.setContraseña(new Encriptarsha1().Encriptar(datos.getContraseña()));
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3,datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdtipouser());
				ps.setLong(6, datos.getIdpersonaalta());
				ps.setString(7, datos.getContraseña());
				ps.setLong(8, datos.getIdpersona());
				ps.setString(9, datos.getObservacion());
							
				return ps;
			}
		});
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Delete(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public String Delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Buscar(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public Model Buscar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Listar(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosInicioSesionBean> Listar() {
		// TODO Auto-generated method stub

		final String sql = "select * from view_usuario";
		return jdbcTemplate.query(sql, new SesionRowMapper());
	
		/*jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				sesion=convert.InicioSesion(ps.executeQuery());
				return ps;
			}
		});
		return sesion;*/
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.SesionDAO#VerificarLogin(com.vector.Beans.InicioSesionBean)
	 */
	@Override
	public List<DatosFormularioBean> VerificarLogin(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblusers where Nombre=(?)and contraseña=(?) from dual";
		datos.setContraseña(new Encriptarsha1().Encriptar(datos.getContraseña()));
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getUsuario());
				ps.setString(2, datos.getContraseña());
				ResultSet rs = ps.executeQuery();
				rs.next();
				datos.setIdtipouser(rs.getInt(2));
				PreparedStatement ps2 = con.prepareStatement("select * from tblpiv12 where idtipouser=(?)");
				ps2.setInt(1, datos.getIdtipouser());
				ResultSet rs2 = ps2.executeQuery();
				List<Integer> idprivilegio = new ArrayList<Integer>();
				while(rs2.next()) {
					idprivilegio.add(rs.getInt(1));
				}
				DatosFormularioBean var2 =new DatosFormularioBean();
				List<DatosFormularioBean> resp = new ArrayList<DatosFormularioBean>();
				for (int i = 0; i < idprivilegio.size(); i++) {
					PreparedStatement ps3 = con.prepareStatement("select * from tblpiv10 where idprivilegio =(?)");
					ps3.setInt(1, idprivilegio.get(i));
					ResultSet rs3 = ps3.executeQuery();
					rs3.next();
					
					var2.setNomformulario(String.valueOf(rs3.getInt(2)));
					var2.setStatus(rs3.getBoolean(3));
					resp.add(var2);
				}
				for (int i = 0; i < idprivilegio.size(); i++) {
					PreparedStatement ps4 = con.prepareStatement("select * from tblformularios where idformulario =(?)");
					ps4.setInt(1, Integer.parseInt(resp.get(i).getNomformulario()));
					ResultSet rs4 = ps4.executeQuery();
					rs4.next();
					resp.get(i).setNomformulario(rs4.getString(2));
				}
				listaform = resp;
				return ps;
			}
		});
		
		
		return listaform;
		
	

}
}

class SesionRowMapper implements RowMapper<DatosInicioSesionBean> {
	@Override
	public DatosInicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosInicioSesionBean user = new DatosInicioSesionBean();
		user.setIduser(0);
		user.setFormulario("unsigned");
		user.setAccion("unsigned");
		user.setIdpersona(0);
		user.setIdpersonaalta(0);
		user.setObservacion("unsigned");
		user.setID_User(rs.getInt(1));
		user.setIP(rs.getString(4));
		user.setUsuario(rs.getString(2));
		user.setContraseña("unsigned");
		user.setStatus(rs.getString(7));
		user.setToken(rs.getString(3));
		user.setMovimiento(rs.getString(6));
		user.setIdtipouser(rs.getInt(5));
		user.setIpequipo("");
		return user;
	}
}
class FormularioRowMapper implements RowMapper<DatosFormularioBean>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DatosFormularioBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosFormularioBean form = new DatosFormularioBean();
		form.setNomformulario(rs.getString(1));
		form.setStatus(rs.getBoolean(2));
		return null;
	}
	
}

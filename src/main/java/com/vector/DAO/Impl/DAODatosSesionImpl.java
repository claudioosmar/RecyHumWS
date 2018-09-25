/**
 * 
 */
package com.vector.DAO.Impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosFormularioBean;
import com.vector.Beans.DatosInicioSesionBean;

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
	private AutoIncrementablesBDOracle autoin;
	private SimpleDateFormat formateador;
	private String fecha;
	private Date date;
	List<DatosInicioSesionBean> datos;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Create(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Create(DatosInicioSesionBean datos) {
		autoin = new AutoIncrementablesBDOracle();
		date = new Date();
		formateador = new SimpleDateFormat ("dd/MM/yy"); 
		fecha = formateador.format(date);
		System.out.println("DAO -- contraseña:--"+datos.getContraseña()+"--");
		int IDUser = autoin.UsuarioIDUltimo(jdbcTemplate);
		String contraseña=datos.getContraseña().trim();
		datos.setContraseña(new Encriptarsha1().Encriptar(contraseña));
		final String sql = "INSERT INTO TBLUSERS VALUES(?,?,?,?,?,?,?,?,?)";
		//datos.setContraseña(new Encriptarsha1().Encriptar(datos.getContraseña()));
		System.out.println("DAO -- contraseña encrip:"+datos.getContraseña());
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(1, IDUser);
				ps.setInt(2, datos.getIdtipouser());
				ps.setLong(3,datos.getIdpersonaalta());
				ps.setString(4, datos.getNombre());
				ps.setString(5, datos.getContraseña());
				ps.setString(6, fecha);
				ps.setString(7, fecha);
				ps.setLong(8, datos.getIdpersona());
				ps.setString(9, " ");
							
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
	public int Delete(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		final String sql = "DELETE TBLUSERS WHERE IDUSER=(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getID_User());
				
				return ps; 
			}
		});
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Buscar(java.lang.Object)
	 */
	@Override
	@Transactional(readOnly = true)
	public DatosInicioSesionBean Buscar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		final String sql="select * from tbldetspersonas dets, tblusers us, tblpersonas pers, tblareas ar\r\n" + 
				"where pers.idpersona = dets.idpersona and pers.idpersona=us.idpersona and pers.idarea=ar.idarea and us.idpersona =(?)";
		DatosInicioSesionBean respuesta = new DatosInicioSesionBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();		
				rs.next();
				respuesta.setNombre(rs.getString(15));		
				respuesta.setArea(rs.getString(31));			
				respuesta.setNombrecompleto(rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
				respuesta.setIdpersona(rs.getLong(2));
				
				return ps;
			}
		});
		return respuesta;
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
		System.out.println("DAO Verificar:--"+datos.getContraseña()+"--");
		final String sql = "select * from tblusers ur, tblpersonas pr where ur.idpersona = pr.idpersona and ur.nombre = (?) and ur.contraseña =(?)";
		String contraseña=datos.getContraseña().trim();
		datos.setContraseña(new Encriptarsha1().Encriptar(contraseña));
		System.out.println("DAO Verificar encrip: "+datos.getContraseña());
		List<DatosFormularioBean> resp = new ArrayList<DatosFormularioBean>();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1, datos.getUsuario());
				ps.setString(2, datos.getContraseña());
				DatosFormularioBean date = new DatosFormularioBean();
				System.out.println("DAO Datos Usuario "+datos.getUsuario()+" "+datos.getContraseña());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) 
				date.setIdtipousuario(rs.getInt(2));
				date.setIdpersona(rs.getLong(8));
				date.setStatus(rs.getBoolean(13));
				resp.add(date);
				return ps;
			}
		});
		
		
		return resp;
		
	

}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#Modificar(com.vector.Beans.DatosInicioSesionBean)
	 */
	@Override
	public int Modificar(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		final String sql = "update tblusers set contraseña=(?) where iduser=(?)";
		datos.setContraseña(new Encriptarsha1().Encriptar(datos.getContraseña()));
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				System.out.println("id user: "+datos.getID_User());
				ps.setLong(2, datos.getID_User());
				ps.setString(1, datos.getContraseña());
		
							
				return ps;
			}
		});
		return respuesta;
	}
	
}

class SesionRowMapper implements RowMapper<DatosInicioSesionBean> {
	@Override
	public DatosInicioSesionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosInicioSesionBean user = new DatosInicioSesionBean();
		user.setIdpersona(0);
		user.setIdpersonaalta(0);
		user.setObservacion("unsigned");
		user.setID_User(rs.getInt(1));
		user.setIP(rs.getString(4));
		user.setUsuario(rs.getString(2));
		user.setContraseña("unsigned");
		user.setStatus(rs.getBoolean(7));
		user.setToken(rs.getString(3));
		user.setMovimiento(rs.getString(6));
		user.setIdtipouser(rs.getInt(5));
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

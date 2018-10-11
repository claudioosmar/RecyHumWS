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
 *   Vector México
 *   Clase: DAODatosSesionImpl.java
 *   Descripción:  crea, modifica, elimina y verifica usuarios
 *   
 * 
 *   Control de Cambios:
 *  10/10/2018 Claudio Osmar Osorio Zuñiga - Creacion
 *  10/10/2018 Jair de jesus Barcenas Gomez - Modificacion: Mensajes en LOG
 *   
 */
@Service
public class DAODatosSesionImpl extends Log implements DAODatosSesion {
	
	/**
	 * The jdbc template.
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * The autoin.
	 */
	private AutoIncrementablesBDOracle autoin;
	
	/**
	 * The formateador.
	 */
	private SimpleDateFormat formateador;
	
	/**
	 * The fecha.
	 */
	private String fecha;
	
	/**
	 * The date.
	 */
	private Date date;
	
	/**
	 * The datos.
	 */
	List<DatosInicioSesionBean> datos;


	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#Create(com.vector.Beans.DatosInicioSesionBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Create(DatosInicioSesionBean datos) {
		autoin = new AutoIncrementablesBDOracle();
		date = new Date();
		formateador = new SimpleDateFormat ("dd/MM/yy"); 
		fecha = formateador.format(date);
		int IDUser = autoin.UsuarioIDUltimo(jdbcTemplate);
		String contraseña=datos.getContraseña().trim();
		datos.setContraseña(new Encriptarsha1().Encriptar(contraseña));
		final String sql = "INSERT INTO TBLUSERS VALUES(?,?,?,?,?,?,?,?,?)";
		//datos.setContraseña(new Encriptarsha1().Encriptar(datos.getContraseña()));
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para sql: IDTIPOUSER["+datos.getIdtipouser()+"], IDPERSONAALTA"+datos.getIdpersonaalta()
				+"], NOMBREUSER["+datos.getNombre()+"], IDPERSONA["+datos.getIdpersona()+"], OBSERVACION["+datos.getObservacion()
				+"], FECHACREACION["+fecha+"], FECHAMODIFICACION["+fecha+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, IDUser);
				ps.setInt(2, datos.getIdtipouser());
				ps.setLong(3,datos.getIdpersonaalta());
				ps.setString(4, datos.getNombre());
				ps.setString(5, datos.getContraseña());
				ps.setString(6, fecha);
				ps.setString(7, fecha);
				ps.setLong(8, datos.getIdpersona());	
				ps.setString(9, datos.getObservacion());
				info("ejecucion de la sentecia sql: "+sql);
				return ps;
			}
		});
		warn("datos enviados: RESPUESTA["+respuesta+"]");
		return respuesta;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#Delete(long)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.DAO.SesionDAO#Delete(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Delete(long id) {
		
		// TODO Auto-generated method stub
		final String sql = "DELETE TBLUSERS WHERE IDUSER=(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para sql: IDSER["+id+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				info("ejecucion de la sentencia sql: "+sql);
				return ps; 
				
			}
		});
		
		warn("datos enviados: RESPUESTA["+respuesta+ "]");
		return respuesta;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#Buscar(com.vector.Beans.DatosInicioSesionBean)
	 */
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
				debug("datos entrantes para sql: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();	
				info("ejecucion de la sentencia sql: "+ sql);
				rs.next();
				respuesta.setNombre(rs.getString(15));		
				respuesta.setArea(rs.getString(31));			
				respuesta.setNombrecompleto(rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
				respuesta.setIdpersona(rs.getLong(2));
				warn("datos enviados: NOMBRE["+rs.getString(15)+"], AREA["+rs.getString(31)+"],NOMBRECOMPLETO["+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+"], IDPERSONA["+rs.getLong(2)+"]");
				return ps;
			}
		});
		warn("envio datos: RESPUESTA["+respuesta+"]");
		return respuesta;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#Listar()
	 */
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
		info("ejecucion del sql: "+ sql);
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

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#VerificarLogin(com.vector.Beans.DatosInicioSesionBean)
	 */
	/* (non-Javadoc)
	 * @see com.vector.DAO.SesionDAO#VerificarLogin(com.vector.Beans.InicioSesionBean)
	 */
	@Override
	public List<DatosFormularioBean> VerificarLogin(DatosInicioSesionBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblusers ur, tblpersonas pr where ur.idpersona = pr.idpersona and ur.nombre = (?) and ur.contraseña =(?)";
		String contraseña=datos.getContraseña().trim();
		datos.setContraseña(new Encriptarsha1().Encriptar(contraseña));
		List<DatosFormularioBean> resp = new ArrayList<DatosFormularioBean>();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				debug("datos entrantes para sql: USUARIO["+datos.getUsuario()+"]");
				ps.setString(1, datos.getUsuario());
				ps.setString(2, datos.getContraseña());
				DatosFormularioBean date = new DatosFormularioBean();
				ResultSet rs = ps.executeQuery();
				info("ejecucion de la sentencia sql: "+sql);
				if(rs.next()) 
					info("entra en la sentencia if");
				date.setIdtipousuario(rs.getInt(2));
				date.setIdpersona(rs.getLong(8));
				date.setStatus(rs.getBoolean(13));
				resp.add(date);
				warn("datos enviado: IDTIPOUSER["+rs.getInt(2)+"], IDPERSONA["+rs.getLong(8)+"], STATUS["+rs.getBoolean(13)+"]");
				return ps;
			}
		});
		
		warn("datos enviados: RESPUESTA["+resp+"]");
		return resp;
		
	

}

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosSesion#Modificar(com.vector.Beans.DatosInicioSesionBean)
	 */
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
				debug("datos entrantes para el sql: IDUSER["+datos.getiduser()+"]");
				ps.setLong(2, datos.getiduser());
				ps.setString(1, datos.getContraseña());
				info("ejecucion de la sentencia sql: "+sql);
				return ps;
			}
		});
		warn("datos enviado: RESPUESTA["+respuesta+"]");
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
		user.setiduser(rs.getInt(1));
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

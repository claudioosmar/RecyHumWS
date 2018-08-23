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
import org.springframework.stereotype.Service;

import com.vector.Beans.DatosLaboralesBean;
import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.DAO.DAODatosPistaAuditora;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosPistaAuditoraImpl implements DAODatosPistaAuditora {
@Autowired
private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @
	 * see com.vector.DAO.DAOPistaAuditora#agregaracceso(com.vector.Beans.PistaAuditoraBean)
	 */
	@Override
	public String agregaracceso(DatosPistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosPistaAuditora#Crear(com.vector.Beans.DatosPistaAuditoraBean)
	 */
	@Override
	public int Crear(DatosPistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregarpistaaudit(?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIp());
				
				return ps;
			}
		});
		return respuesta;
	}
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosPistaAuditora#Modificar(com.vector.Beans.DatosPistaAuditoraBean)
	 */
	@Override
	public int Modificar(DatosPistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarpistaaudit(?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIp());
				
				return ps;
			}
		});
		return respuesta;
	}
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosPistaAuditora#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosPistaAuditora#Buscar(com.vector.Beans.DatosPistaAuditoraBean)
	 */
	@Override
	public DatosPistaAuditoraBean Buscar(DatosPistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		final String sql = "indefinido";
		DatosPistaAuditoraBean respuesta = new DatosPistaAuditoraBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ResultSet rs = ps.executeQuery();
				
				
				return ps;
			}
		});
		return respuesta;
	}
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosPistaAuditora#Listar()
	 */
	@Override
	public List<DatosPistaAuditoraBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

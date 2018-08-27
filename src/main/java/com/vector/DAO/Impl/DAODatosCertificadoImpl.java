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

import com.vector.Beans.DatosCertificadoBean;

import com.vector.DAO.DAODatosCertificado;
import com.vector.Utileria.AutoIncrementablesBDOracle;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosCertificadoImpl implements DAODatosCertificado {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private AutoIncrementablesBDOracle autoin;
	
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Crear(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub	
		autoin = new AutoIncrementablesBDOracle();
		int IDCertificado = autoin.CertificadoIDUltimo(jdbcTemplate);
		//int IDestudio = autoin.EstudiosIDUltimo(jdbcTemplate);
		System.out.println(IDCertificado);
		//System.out.println(IDestudio);
		final String sql="INSERT INTO tblcertificado VALUES (?,?,?)";
		final String sql2="INSERT INTO tblpiv05 VALUES(?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, IDCertificado);
				ps.setInt(2, datos.getIddocumentoNw());
				ps.setString(3, datos.getNomcertificadoNw());
				ps.execute();
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setLong(1, datos.getIdestudio());
				ps2.setInt(2, IDCertificado);
			
				 return ps2;
				 
			}
		});
		return respuesta;
		
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Modificar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosCertificadoBean datos) {
		//int IDCertificado = autoin.CertificadoIDUltimo(jdbcTemplate);
		// TODO Auto-generated method stub
		final String sql= "update tblcertificado set iddoc = (?), nomcertificado = (?) where idcertificado = (?) and iddoc = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(3, datos.getIdcertificado());
				ps.setInt(4, datos.getIddocumentoNw());
				ps.setString(2, datos.getNomcertificadoNw());
				ps.setInt(1, datos.getIddocumentoLt());
				
				 return ps;
				 
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		final String sql="delete tblcertificado where idcertificado = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Buscar(com.vector.Beans.DatosCertificadoBean)
	 */
	@Override
	@Transactional//(readOnly = true)
	public DatosCertificadoBean Buscar(DatosCertificadoBean datos) {
		// TODO Auto-generated method stub
		final String sql="select * from TBLCERTIFICADO where idcertificado = (?)";
		DatosCertificadoBean respuesta = new DatosCertificadoBean();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdcertificado());
				ResultSet rs = ps.executeQuery();
				rs.next();
				respuesta.setNomcertificadoNw(rs.getString(3));
				return ps;
			}
		});
		
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCertificado#Listar()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosCertificadoBean> Listar(int id) {
		// TODO Auto-generated method stub
		final String sql="select * from tblcertificado where idcertificado = '"+id+"'";
		System.out.println(sql);
		return jdbcTemplate.query(sql, new DatPerRowMapper());
	}
	
	class DatPerRowMapper implements RowMapper<DatosCertificadoBean> {
		@Override
		public DatosCertificadoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DatosCertificadoBean retorno = new DatosCertificadoBean();
			retorno.setNomcertificadoNw(rs.getString(3));
			retorno.setIddocumentoNw(2);	

			return retorno;
		}
	}

}

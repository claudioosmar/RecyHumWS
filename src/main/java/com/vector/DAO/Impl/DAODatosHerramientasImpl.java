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

import com.vector.Beans.DatosHerramientasBean;
import com.vector.DAO.DAODatosHerramientas;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosHerramientasImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
// clase de herramientas conocidas implements 
@Service
public class DAODatosHerramientasImpl implements DAODatosHerramientas {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The datos. */
	List<DatosHerramientasBean> datos ;


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Crear(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		final String sql="insert into tblpiv09 values(?,?,?,?,?)";	
		final String sql2="select * from tblpiv09 where idpersona=(?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				if(datos.getIdpersona()!=0) {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ps.setInt(2, datos.getIdherramienta());
				ps.setInt(3, datos.getPorcentajeherra());
				ps.setInt(4,datos.getAnosexpherra());
				ps.setString(5, datos.getDescripcionherra());
				ps.execute();
				}
				
				PreparedStatement ps1 = con.prepareStatement(sql2);
				System.out.println("si esta la persona con ID: "+datos.getIdpersona());
				ps1.setLong(1, datos.getIdpersona());
				return ps1;
	
			}
		});
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		final String sql="update tblpiv09 set idherramienta=(?),porcentaje=(?),añosexpe=(?),descripcion=(?) where idpersona =(?) and idherramienta=(?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(5, datos.getIdpersona());
				ps.setInt(6, datos.getIdherramienta());
				ps.setInt(2, datos.getPorcentajeherra());
				ps.setInt(3,datos.getAnosexpherra());
				ps.setString(4, datos.getDescripcionherra());
				ps.setInt(1, datos.getIdherramientaNw());
				
				return ps;
			}
		});
		return respuesta;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Eliminar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
final String sql="delete tblpiv09 where idpersona =(?) and idherramienta=(?)";
final String sql2 = "delete tblpiv09 where idherramienta=(?) and idpersona=(?) and descripcion=(?)";
final String sql3 ="select * from tblpiv09";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				if(datos.getIdherramienta()!=6) {
					PreparedStatement ps = con.prepareStatement(sql);
					System.out.println("se elimino herramienta conocida por id de herramienta: "+datos.getIdherramienta());
					ps.setLong(1, datos.getIdpersona());
					ps.setInt(2, datos.getIdherramienta());
					ps.execute();
				}else{
					PreparedStatement ps2 = con.prepareStatement(sql2);
					System.out.println("se elimino herramienta conocida por descripción: "+datos.getDescripcionherra());
					ps2.setInt(1, 6);
					ps2.setLong(2, datos.getIdpersona());
					ps2.setString(3, datos.getDescripcionherra());
					ps2.execute();
				}
				PreparedStatement ps3 = con.prepareStatement(sql3);
				
				System.out.println("se encontro herramienta: "+datos.getIdherramienta());
				return ps3;
			}
		});
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasBean> Buscar(DatosHerramientasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv09 piv,tblherramientas her where piv.idherramienta=her.idherramienta and idpersona =(?)";
		final String sql2 = "select * from tbldetspersonas where idpersona =(?)";
		DatosHerramientasBean respuesta = new DatosHerramientasBean();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				List<Integer> idherr = new ArrayList<Integer>();
				ResultSet rs = ps.executeQuery();
				setDatosHerramientas(rs);
				for (int i = 0; i < idherr.size(); i++) {				
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setLong(1, datos.getIdpersona());
				ResultSet rs2 = ps2.executeQuery();
				rs2.next();
				respuesta.setNombrecompleto(rs2.getString("nombre")+" "+rs2.getString("segnombre")+" "+rs2.getString("apellidop")+" "+rs2.getString("apellidom"));
				}
				//PreparedStatement ps3 = con.prepareStatement(sql);
				return ps;
			}
		});
		List<DatosHerramientasBean> retorno =getDatosherramientas();
		return retorno;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblherramientas";
		return jdbcTemplate.query(sql, new HerrRowMapper());
	}
	
/**
 * Sets the datos herramientas.
 *
 * @param rs the new datos herramientas
 * @throws SQLException the SQL exception
 */
private void setDatosHerramientas(ResultSet rs) throws SQLException {
	datos= new ArrayList<DatosHerramientasBean>();
	DatosHerramientasBean respuesta ;
	while(rs.next()) {
	respuesta = new DatosHerramientasBean();
	respuesta.setIdpersona(rs.getLong(1));
	respuesta.setIdherramienta(rs.getInt(2));
	respuesta.setPorcentajeherra(rs.getInt(3));
	respuesta.setAnosexpherra(rs.getInt(4));
	respuesta.setDescripcionherra(rs.getString(5));
	respuesta.setNombreherramienta(rs.getString(7));
	respuesta.setVersion(rs.getString(8));
	this.datos.add(respuesta);
	}
}

/**
 * Gets the datosherramientas.
 *
 * @return the datosherramientas
 */
private List<DatosHerramientasBean>getDatosherramientas(){
	return this.datos;
}
}
class HerrRowMapper implements RowMapper<DatosHerramientasBean>{


	@Override
	public DatosHerramientasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosHerramientasBean retorno = new DatosHerramientasBean();
		retorno.setIdherramienta(rs.getInt(1));
		retorno.setNombreherramienta(rs.getString(2));
		retorno.setVersion(rs.getString(3));
		return retorno;
	}
	
}
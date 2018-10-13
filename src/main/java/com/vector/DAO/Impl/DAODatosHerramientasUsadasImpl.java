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

import com.vector.Beans.DatosHerramientasUsadasBean;
import com.vector.DAO.DAODatosHerramientasUsadas;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosHerramientasUsadasImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
@Service
public class DAODatosHerramientasUsadasImpl implements DAODatosHerramientasUsadas {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The datos. */
	List<DatosHerramientasUsadasBean> datos ;

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Crear(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		final String sql="insert into tblpiv07 values(?,?,?,?,?)";	
		final String sql2 ="select * from tblpiv07 where idexplaboral =(?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				if(datos.getIdexplaboral()!=0) {
			
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(2, datos.getIdexplaboral());
				ps.setInt(1, datos.getIdherramienta());
				ps.setInt(3, datos.getPorcentajeherra());
				ps.setInt(4,datos.getAnosexpherra());
				ps.setString(5, datos.getDescripcionherra());
				ps.execute();
				}
				PreparedStatement ps1 = con.prepareStatement(sql2);
				System.out.println("si esta la experiencia laboral con ID: "+datos.getIdexplaboral());
						ps1.setLong(1, datos.getIdexplaboral());
				return ps1;

			}
		});
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		final String sql="update tblpiv07 set idherramienta=(?),porcentaje=(?),añosexp=(?),descripcion=(?) where idexplaboral =(?) and idherramienta=(?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(5, datos.getIdexplaboral());
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
	public int Eliminar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		final String sql="delete tblpiv07 where idexplaboral =(?) and idherramienta=(?)";
		final String sql2 = "delete tblpiv07 where idpersona=(?) and descripcion=(?)";
		final String sql3 ="select * from tblpiv07";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				if(datos.getDescripcionherra() == "") {
					PreparedStatement ps = con.prepareStatement(sql);
					System.out.println("se elimino herramienta usada por id de herramienta: "+datos.getIdherramienta());
					ps.setLong(1, datos.getIdexplaboral());
					ps.setInt(2, datos.getIdherramienta());
					ps.execute();
					}else {
						PreparedStatement ps2 = con.prepareStatement(sql2);
						System.out.println("se elimino herramiemta usada por descripción: "+datos.getDescripcionherra());
						ps2.setLong(1, datos.getIdexplaboral());
						ps2.setString(2, datos.getDescripcionherra());
						ps2.execute();
					}
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ps3.setLong(1, datos.getIdexplaboral());
					ResultSet rs3 = ps3.executeQuery();
					datos.setIdherramienta(rs3.getInt(2));
					rs3.next();
					return ps3;
			}
		});
		return respuesta;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Buscar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv07 piv, tblherramientas herm where piv.idherramienta=herm.idherramienta and idexplaboral =(?)";
		final String sql2 = "select * from tblexpslaborales where idexplaboral =(?)";
		DatosHerramientasUsadasBean respuesta = new DatosHerramientasUsadasBean();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdexplaboral());
				List<Integer> idherramientau = new ArrayList<Integer>();
				ResultSet rs = ps.executeQuery();
				setDatosHerramientasusadas(rs);
				
				for (int i = 0; i < idherramientau.size(); i++) {
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setLong(1, datos.getIdexplaboral());
				ResultSet rs2 = ps2.executeQuery();
				rs2.next();
				respuesta.setIdexplaboral(rs2.getLong(1));

			}
				return ps;
			}
		});
		List<DatosHerramientasUsadasBean> retorno =getDatosherramientasusadas();
		return retorno;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv07 piv, tblherramientas herrm where piv.idherramienta = herrm.idherramienta";
		return jdbcTemplate.query(sql, new Herr2RowMapper());
	}
	
/**
 * Sets the datos herramientasusadas.
 *
 * @param rs the new datos herramientasusadas
 * @throws SQLException the SQL exception
 */
private void setDatosHerramientasusadas(ResultSet rs) throws SQLException {
		datos= new ArrayList<DatosHerramientasUsadasBean>();
		DatosHerramientasUsadasBean respuesta ;
		while(rs.next()) {
		respuesta = new DatosHerramientasUsadasBean();
		respuesta.setIdexplaboral(rs.getInt(2));
		respuesta.setIdherramienta(rs.getInt(1));
		respuesta.setPorcentajeherra(rs.getInt(3));
		respuesta.setAnosexpherra(rs.getInt(4));
		respuesta.setDescripcionherra(rs.getString(5));					
		respuesta.setNombreherramienta(rs.getString(7));
		respuesta.setVersion(rs.getString(8));
		this.datos.add(respuesta);
		}
	}
	
	/**
	 * Gets the datosherramientasusadas.
	 *
	 * @return the datosherramientasusadas
	 */
	private List<DatosHerramientasUsadasBean>getDatosherramientasusadas(){
		return this.datos;
	}
}

class Herr2RowMapper implements RowMapper<DatosHerramientasUsadasBean>{

	@Override
	public DatosHerramientasUsadasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosHerramientasUsadasBean retorno = new DatosHerramientasUsadasBean();
		retorno.setIdexplaboral(rs.getInt(2));
		retorno.setIdherramienta(rs.getInt(1));
		retorno.setPorcentajeherra(rs.getInt(3));
		retorno.setAnosexpherra(rs.getInt(4));
		retorno.setDescripcionherra(rs.getString(5));
		retorno.setNombreherramienta(rs.getString(7));
		retorno.setVersion(rs.getString(8));
		return retorno;
	}
	
}

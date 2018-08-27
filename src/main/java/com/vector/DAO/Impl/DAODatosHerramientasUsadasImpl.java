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

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosHerramientasUsadasImpl implements DAODatosHerramientasUsadas {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	List<DatosHerramientasUsadasBean> datos ;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientasUsadas#Crear(com.vector.Beans.DatosHerramientasUsadasBean)
	 */
	@Override
	public int Crear(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		final String sql="insert into tblpiv07 values(?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setLong(2, datos.getIdexplaboral());
				ps.setInt(1, datos.getIdherramienta());
				ps.setInt(3, datos.getPorcentajeherra());
				ps.setInt(4,datos.getAñosexpherra());
				ps.setString(5, datos.getDescripcionherra());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientasUsadas#Modificar(com.vector.Beans.DatosHerramientasUsadasBean)
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
				ps.setInt(3,datos.getAñosexpherra());
				ps.setString(4, datos.getDescripcionherra());
				ps.setInt(1, datos.getIdherramientaNw());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientasUsadas#Eliminar(com.vector.Beans.DatosHerramientasUsadasBean)
	 */
	@Override
	public int Eliminar(DatosHerramientasUsadasBean datos) {
		// TODO Auto-generated method stub
		final String sql="delete tblpiv07 where idexplaboral =(?) and idherramienta=(?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdexplaboral());
				ps.setInt(2, datos.getIdherramienta());
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientasUsadas#Buscar(com.vector.Beans.DatosHerramientasUsadasBean)
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

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosHerramientasUsadas#Listar(long)
	 */
	@Override
	public List<DatosHerramientasUsadasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv07 piv, tblherramientas herrm where piv.idherramienta = herrm.idherramienta";
		return jdbcTemplate.query(sql, new Herr2RowMapper());
	}
	
private void setDatosHerramientasusadas(ResultSet rs) throws SQLException {
		datos= new ArrayList<DatosHerramientasUsadasBean>();
		DatosHerramientasUsadasBean respuesta ;
		while(rs.next()) {
		respuesta = new DatosHerramientasUsadasBean();
		respuesta.setIdexplaboral(rs.getInt(2));
		respuesta.setIdherramienta(rs.getInt(1));
		respuesta.setPorcentajeherra(rs.getInt(3));
		respuesta.setAñosexpherra(rs.getInt(4));
		respuesta.setDescripcionherra(rs.getString(5));					
		respuesta.setNombreherramienta(rs.getString(7));
		respuesta.setVersion(rs.getString(8));
		this.datos.add(respuesta);
		}
	}
	private List<DatosHerramientasUsadasBean>getDatosherramientasusadas(){
		return this.datos;
	}
}

class Herr2RowMapper implements RowMapper<DatosHerramientasUsadasBean>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public DatosHerramientasUsadasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DatosHerramientasUsadasBean retorno = new DatosHerramientasUsadasBean();
		retorno.setIdexplaboral(rs.getInt(2));
		retorno.setIdherramienta(rs.getInt(1));
		retorno.setPorcentajeherra(rs.getInt(3));
		retorno.setAñosexpherra(rs.getInt(4));
		retorno.setDescripcionherra(rs.getString(5));
		retorno.setNombreherramienta(rs.getString(7));
		retorno.setVersion(rs.getString(8));
		return retorno;
	}
	
}

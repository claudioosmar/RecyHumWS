/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.vector.Beans.DatosLaboralesBean;
import com.vector.DAO.DAODatosLaborales;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosLaboralesImpl implements DAODatosLaborales {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Crear(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public int Crear(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_agregarexplaboral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdmotivotermino());
				ps.setString(6, datos.getPuesto());
				ps.setString(7,datos.getFechainicioexp());
				ps.setString(8,datos.getFechafinalexp());
				ps.setString(9,datos.getActividadesreal());
				ps.setString(10,datos.getLogros());
				ps.setInt(11,datos.getIdtipocontrato());
				ps.setString(12,datos.getDescripcionexp());
				ps.setString(13,datos.getNombreempresa());
				ps.setLong(14,datos.getIdpersona());
				ps.setInt(15,datos.getIdherramienta());
				ps.setInt(16,datos.getPorsentajeherra());
				ps.setInt(17,datos.getAñosexp());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Modificar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public int Modificar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql="execute sp_modificarexplaboral(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIduser());
				ps.setString(2, datos.getFormulario());
				ps.setString(3, datos.getAccion());
				ps.setString(4, datos.getIpequipo());
				ps.setInt(5, datos.getIdmotivotermino());
				ps.setString(6, datos.getPuesto());
				ps.setString(7,datos.getFechainicioexp());
				ps.setString(8,datos.getFechafinalexp());
				ps.setString(9,datos.getActividadesreal());
				ps.setString(10,datos.getLogros());
				ps.setInt(11,datos.getIdtipocontrato());
				ps.setString(12,datos.getDescripcionexp());
				ps.setString(13,datos.getNombreempresa());
				ps.setLong(14,datos.getIdpersona());
				ps.setInt(15,datos.getIdherramienta());
				ps.setInt(16,datos.getPorsentajeherra());
				ps.setInt(17,datos.getAñosexp());
				
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Eliminar(int)
	 */
	@Override
	public int Eliminar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Buscar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public DatosLaboralesBean Buscar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Listar()
	 */
	@Override
	public List<DatosLaboralesBean> Listar() {
		// TODO Auto-generated method stub
		return null;
	}

}

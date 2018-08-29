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
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosIdiomasBean;
import com.vector.DAO.DAODatosIdiomas;
import com.vector.Utileria.AutoIncrementablesBDOracle;

import java.util.logging.Logger;
/**
 * @author vectormx
 *
 */
@Service
public class DAODatosIdiomasImpl implements DAODatosIdiomas {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final static Logger LOGGER = Logger.getLogger("com.vector.BO.Impl");
	private AutoIncrementablesBDOracle autoin;
	List<DatosIdiomasBean> datos ;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Crear(com.vector.Beans.DatosIdiomasBean)
	 */
	@Transactional(readOnly = true)
	public int Crear(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		autoin= new AutoIncrementablesBDOracle();
		long iddominio=autoin.DominioIDUltimo(jdbcTemplate);
		LOGGER.info("Este es el id de estudio: " +autoin);
		System.out.println("Este es el id de estudio:" +autoin);
		
		final String sql = "insert into tbldominio values(?,?,?,?,?,?,?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("datos enviados: "+iddominio+" id persona "+datos.getIdpersona()+" id idioma "+datos.getIdidioma()+" pcjescritura "+datos.getPcjescrito()+" pcjhabla "+datos.getPcjhablado()+" pcjentendido "+datos.getPcjentendido()+" Descripcion "+datos.getDescripciondominio()+" nativo "+datos.getIdiomanativa());
				ps.setLong(1, iddominio);
				ps.setLong(5, datos.getIdpersona());	
				ps.setInt(8, datos.getIdidioma());
				ps.setInt(2, datos.getPcjescrito());
				ps.setInt(3, datos.getPcjhablado());
				ps.setInt(4, datos.getPcjentendido());
				ps.setString(6, datos.getDescripciondominio());
				ps.setString(7, datos.getIdiomanativa());
							
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Modificar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		final String sql = "update tbldominio set pctescrito = (?), pcthablado = (?), pctentendido =(?), descripcion =(?), idiomanativa=(?),ididioma=(?) where idpersona =(?) and iddominio= (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(1, datos.getPcjescrito());
				ps.setInt(2, datos.getPcjhablado());
				ps.setInt(3, datos.getPcjentendido());
				ps.setString(4, datos.getDescripciondominio());
				ps.setString(5, datos.getIdiomanativa());
				ps.setInt(6, datos.getIdidioma());
				ps.setLong(7, datos.getIdpersona());
				ps.setInt(8, datos.getIddominio());
							
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		final String sql="delete tbldominio where iddominio = (?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIddominio());
				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Buscar(com.vector.Beans.DatosIdiomasBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosIdiomasBean> Buscar(DatosIdiomasBean datos) {
		// TODO Auto-generated method stub
		final String sql="select * from tbldominio dom, tbldetspersonas dts, tblidiomas ido where dom.ididioma=ido.ididioma and dts.idpersona=dom.idpersona and dom.idpersona = (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				setDatosIdiomas(rs);
			
				return ps;
			}
		});
		List<DatosIdiomasBean> retorno = getDatosIdiomas();
		return retorno;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosIdiomas#Listar()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosIdiomasBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tbldominio dom, tblidiomas idio where dom.ididioma=idio.ididioma";
		return jdbcTemplate.query(sql, new IdiomaRowMapper());
	}
	
		private void setDatosIdiomas(ResultSet rs) throws SQLException{
			datos= new ArrayList<DatosIdiomasBean>();
			DatosIdiomasBean respuesta;
			while(rs.next()) {
				respuesta = new DatosIdiomasBean();
				respuesta.setPcjescrito(rs.getInt(2));
				respuesta.setPcjhablado(rs.getInt(3));
				respuesta.setPcjentendido(rs.getInt(4));
				respuesta.setDescripciondominio(rs.getNString(6));
				respuesta.setIdiomanativa(rs.getString(7));
				respuesta.setIdidioma(rs.getInt(8));
				respuesta.setNombrecompleto(rs.getString(13)+" "+rs.getString(14)+" "+rs.getString(15)+" "+rs.getString(16));
				respuesta.setNombreidioma(rs.getString(21));
				this.datos.add(respuesta);
				}
		}

		private List<DatosIdiomasBean>getDatosIdiomas(){
			return this.datos;
		}	
	}
	
	
	class IdiomaRowMapper implements RowMapper<DatosIdiomasBean> {
		@Override
		public DatosIdiomasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DatosIdiomasBean idioma = new DatosIdiomasBean();
			idioma.setIddominio(rs.getInt(1));
			idioma.setIdidioma(rs.getInt(8));
			idioma.setNombreidioma(rs.getString(10));
			return idioma;
		}

	}


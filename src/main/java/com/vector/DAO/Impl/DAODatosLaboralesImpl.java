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
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.vector.Beans.DatosLaboralesBean;
import com.vector.DAO.DAODatosLaborales;
import com.vector.Utileria.AutoIncrementablesBDOracle;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosLaboralesImpl implements DAODatosLaborales {
	private final static Logger LOGGER = Logger.getLogger("com.vector.DAO.Impl");
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private AutoIncrementablesBDOracle ids;
	private List<DatosLaboralesBean> listalabo;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Crear(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public int Crear(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		ids = new AutoIncrementablesBDOracle();
		int IDExpLaboral =ids.IDExpLaboralIDUltimo(jdbcTemplate);
		int IDEmpresas = ids.EmpresasIDUltimo(jdbcTemplate);
		//LOGGER.info("Este es el IDEXplaboral: " + IDExpLaboral);
		//LOGGER.info("Este es el IDEempresas: " + IDEmpresas);
		System.out.println(IDExpLaboral);
		System.out.println(IDEmpresas);
		final String sql="INSERT INTO TBLEXPSLABORALES VALUES (?,?,?,?,?,?,?,?,?)";		
		final String sql2="INSERT INTO TBLPIV06 VALUES (?,?)";
		final String sql3 = "INSERT INTO TBLEMPRESAS VALUES (?,?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//Insersion en tabla empresas
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setInt(1, IDEmpresas);
				ps3.setString(2, datos.getNombreempresa());
				ps3.setString(3, "1");
				ps3.execute();
				//Insersion en tabla Experiencia Laboral
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, IDExpLaboral);
				ps.setInt(2, datos.getIdmotivotermino());
				ps.setInt(3, IDEmpresas);
				ps.setString(4, datos.getPuesto());
				ps.setString(5, datos.getFechainicioexp());
				ps.setString(6, datos.getFechafinalexp());
				ps.setString(7,datos.getActividadesreal());
				ps.setString(8,datos.getLogros());
				ps.setInt(9,datos.getIdtipocontrato());
				ps.execute();
				//Insersion en tabla piv06
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setLong(1, datos.getIdpersona());
				ps2.setInt(2, IDExpLaboral);
				
				return ps2;
			}
		});
		if (respuesta==1) {
			return IDExpLaboral;
		}else {
			return 0;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Modificar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public int Modificar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql="UPDATE TBLEXPSLABORALES SET IDMOTIVOTER=(?), IDEMPRESA=(?), PUESTO=(?), FINICIAL=(?), FFINAL=(?), ACTREALIZADAS=(?), LOGROS=(?), IDTIPOCONTRATA=(?) WHERE IDEXPLABORAL=(?)";		
		final String sql2 = "UPDATE TBLEMPRESAS SET NOMEMPRESA=(?) WHERE IDEMPRESA=(?)  ";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//Insersion en tabla empresas
				PreparedStatement ps3 = con.prepareStatement(sql2);
				ps3.setInt(2, datos.getIdempresa());
				ps3.setString(1, datos.getNombreempresa());
				ps3.execute();
				//Insersion en tabla Experiencia Laboral
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(9, datos.getIdexplaborl());
				ps.setInt(1, datos.getIdmotivotermino());
				ps.setInt(2, datos.getIdempresa());
				ps.setString(3, datos.getPuesto());
				ps.setString(4, datos.getFechainicioexp());
				ps.setString(5, datos.getFechafinalexp());
				ps.setString(6,datos.getActividadesreal());
				ps.setString(7,datos.getLogros());
				ps.setInt(8,datos.getIdtipocontrato());
				
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
		final String sql = "DELETE TBLEXPSLABORALES WHERE IDEXPLABORAL=(?) ";
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
	 * @see com.vector.DAO.DAODatosLaborales#Buscar(com.vector.Beans.DatosLaboralesBean)
	 */
	@Override
	public List<DatosLaboralesBean> Buscar(DatosLaboralesBean datos) {
		// TODO Auto-generated method stub
		final String sql = "SELECT * FROM TBLEXPSLABORALES expa,tblempresas emp WHERE expa.idempresa=emp.idempresa and  expa.IDEXPLABORAL =?";
		final String sql3 = "SELECT * FROM TBLPIV06 WHERE IDPERSONA =?";
		
		DatosLaboralesBean respuesta = new DatosLaboralesBean();
		List<DatosLaboralesBean> retorno = new ArrayList<DatosLaboralesBean>();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//PreparedStatement ps3 = con.prepareStatement(sql2);
				
				//Consulta piv06
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setLong(1, datos.getIdpersona());
				ResultSet rs3 = ps3.executeQuery();
				List<Integer> idexplaboral = new ArrayList<Integer>();
				while(rs3.next()) {
					idexplaboral.add(rs3.getInt(2));
				}
				listalabo = new ArrayList<DatosLaboralesBean>();
				System.out.println("IDExperiencia Laboral "+idexplaboral+" Numero de Experiencias Laborales "+idexplaboral.size());
				for (int i = 0; i < idexplaboral.size(); i++) {
					//Consulta TBLEXPLABORALES
					PreparedStatement ps2 = con.prepareStatement(sql);
					ps2.setInt(1, idexplaboral.get(i));
					
					setBuscarDatosLaborales( ps2.executeQuery());
					
					/*ps.setInt(1, respuesta.getIdempresa());
					ResultSet rs = ps.executeQuery();
					rs.next();
					respuesta.setNombreempresa(rs.getString(2));
					retorno.add(respuesta);*/
					
				}
	
				
				return ps3;
			}
		});
		
		return getListaDatosLaborales();
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosLaborales#Listar()
	 */
	@Override
	public List<DatosLaboralesBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblexpslaborales";
		return jdbcTemplate.query(sql, new labRowMapper());
	}
	private void setBuscarDatosLaborales(ResultSet rs2)throws SQLException {
		
		DatosLaboralesBean respuesta = new DatosLaboralesBean();
		rs2.next();
		respuesta.setIdexplaborl(rs2.getInt(1));
		respuesta.setIdmotivotermino(rs2.getInt(2));
		respuesta.setIdempresa(rs2.getInt(3));
		respuesta.setPuesto(rs2.getString(4));
		respuesta.setFechainicioexp(rs2.getString(5));
		respuesta.setFechafinalexp(rs2.getString(6));
		respuesta.setActividadesreal(rs2.getString(7));
		respuesta.setLogros(rs2.getString(8));
		respuesta.setIdtipocontrato(rs2.getInt(9));
		respuesta.setIdempresa(rs2.getInt(10));
		respuesta.setNombreempresa(rs2.getString(11));
		listalabo.add(respuesta);
		
	}
	private List<DatosLaboralesBean> getListaDatosLaborales(){
		 return this.listalabo;
	}
}class labRowMapper implements RowMapper<DatosLaboralesBean> {
	@Override
	public DatosLaboralesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosLaboralesBean respuesta = new DatosLaboralesBean();
		respuesta.setIdexplaborl(rs.getInt(1));
		respuesta.setIdmotivotermino(rs.getInt(2));
		respuesta.setIdempresa(rs.getInt(3));
		respuesta.setPuesto(rs.getString(4));
		respuesta.setFechainicioexp(rs.getString(5));
		respuesta.setFechafinalexp(rs.getString(6));
		respuesta.setActividadesreal(rs.getString(7));
		respuesta.setLogros(rs.getString(8));
		respuesta.setIdtipocontrato(rs.getInt(9));
		

		return respuesta;
	}

}



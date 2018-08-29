/**
 * DAODatosCursoImpl.java -- 25/08/2018
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

import com.vector.Beans.DatosCursoBean;
import com.vector.DAO.DAODatosCurso;
import com.vector.Utileria.AutoIncrementablesBDOracle;

/**
 * @author Jair
 *
 */
@Service
public class DAODatosCursoImpl implements DAODatosCurso {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private AutoIncrementablesBDOracle autoin;
	List<DatosCursoBean> datos ;
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Crear(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		autoin= new AutoIncrementablesBDOracle();
		long idcurso=autoin.CursoIDUltimo(jdbcTemplate);
		long idcertificado=autoin.CertificadoIDUltimo(jdbcTemplate);
		
		final String sql = "insert into tblcursos values (?,?,?,?,?)";
		final String sql2 ="insert into tblpiv04 values(?,?)";
		final String sql3 ="insert into tblpiv14 values(?,?)";
		final String sql4 ="insert into tblcertificado values(?,?,?)";
		final String sql5 ="select * from tblcursos where idcurso=(?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				/*primera insercion*/
				PreparedStatement ps1 = con.prepareStatement(sql);
				System.out.println("datos de curso: "+idcurso+" " +datos.getNombrecurso()+" "+datos.getInstitutocurso()+" "+datos.getFechainicioc()+" "+ datos.getFechaterminoc()+"\n");
				ps1.setLong(1, idcurso);
				ps1.setString(2, datos.getNombrecurso());
				ps1.setString(3, datos.getInstitutocurso());
				ps1.setString(4, datos.getFechainicioc());
				ps1.setString(5, datos.getFechaterminoc());
				ps1.execute();
				
				if(datos.getIdcertificado()!=0) {
					/*segunda insercion si se cumple*/
						PreparedStatement ps3 = con.prepareStatement(sql4);
						System.out.println("datos de certificado: "+idcertificado+" "+datos.getNombrecertificado()+"\n");
						ps3.setLong(1, idcertificado);
						ps3.setString(3, datos.getNombrecertificado());
						ps3.setInt(2, 8);
						ps3.execute();
					/*tercera insercion si se cumple la segunda*/
						PreparedStatement ps = con.prepareStatement(sql2);
						System.out.println("datos de la pivote 04: "+idcurso+" "+idcertificado+"\n");
						ps.setLong(1, idcurso);
						ps.setLong(2, idcertificado);
						ps.execute();
				}else{
					
				}
				/*cuarta insercion si se cumple*/
				if(datos.getIdestudio()!=0) {
				PreparedStatement ps3 = con.prepareStatement(sql3);
				System.out.println("datos de la pivote 14: "+idcurso+" "+datos.getIdestudio()+"\n");
				ps3.setLong(2,idcurso);
				ps3.setLong(1, datos.getIdestudio());
				ps3.execute();
				}
				PreparedStatement ps4 = con.prepareStatement(sql5);
				System.out.println("si esta el curso con nombre "+datos.getNombrecurso());
					ps4.setInt(1, datos.getIdcurso());
				return ps4;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Modificar(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Modificar(DatosCursoBean datos) {
		autoin= new AutoIncrementablesBDOracle();
		long idcertificado=autoin.CertificadoIDUltimo(jdbcTemplate);
		// TODO Auto-generated method stub
		final String sql = "update tblcursos set nombre =(?), institucion =(?),finicio=(?),ftermino=(?) where idcurso =(?)";
		final String sql7 ="update tblcertificado set nomcertificado = (?) where idcertificado=(?)";
		final String sql2 ="insert into tblcertificado values(?,?,?)";
		final String sql4 = "select * from tblpiv04 where idcurso=(?) and idcertificado=(?)";
		final String sql5 ="insert into tblpiv04 values(?,?)";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				System.out.println("modifico datos con id curso "+datos.getIdcurso()+" e id certificado "+datos.getIdcertificado()+" nombre certificado "+datos.getNombrecertificado()+"\n");
				/*preparando sentencia de select tblpiv04*/
				PreparedStatement ps1 = con.prepareStatement(sql4);
				System.out.println("datos de la pivote 4: idcertificado: "+datos.getIdcertificado()+" idcurso: "+datos.getIdcurso()+"\n");
				ps1.setLong(2, datos.getIdcertificado());
				ps1.setLong(1, datos.getIdcurso());
				ResultSet rs1=ps1.executeQuery();
				
				System.out.println("aun sigue el valor");
				/*actualizar si existen datos*/
				if(rs1.next()) {
					System.out.println("primer if si entra "+datos.getIdcurso()+" "+datos.getIdcertificado());
					    PreparedStatement ps = con.prepareStatement(sql);
					    System.out.println("datos curso: "+"idcurso "+ datos.getIdcurso()+" nombre "+datos.getNombrecurso()+" intstituto "+datos.getInstitutocurso()+" fechainicio "+datos.getFechainicioc()+" fechafinal "+datos.getFechaterminoc()+"\n");
						ps.setLong(5, datos.getIdcurso());
						ps.setString(1, datos.getNombrecurso());
						ps.setString(2, datos.getInstitutocurso());
						ps.setString(3, datos.getFechainicioc());
						ps.setString(4, datos.getFechaterminoc());
						ps.execute();
						PreparedStatement ps7 = con.prepareStatement(sql7);
						System.out.println("datos certificado: "+"idcertificado "+ datos.getIdcertificado()+" nombre certificado "+datos.getNombrecurso()+"\n");
						ps7.setLong(2, datos.getIdcertificado());
						ps7.setString(1, datos.getNombrecertificado());
						ps7.execute();
	
				}
				else if(datos.getIdcertificado()==0){
					System.out.println("segundo if si entra "+datos.getIdcurso()+" "+datos.getIdcertificado());
					PreparedStatement ps = con.prepareStatement(sql);
						System.out.println("datos curso: "+"idcurso "+ datos.getIdcurso()+" nombre "+datos.getNombrecurso()+" intstituto "+datos.getInstitutocurso()+" fechainicio "+datos.getFechainicioc()+" fechafinal "+datos.getFechaterminoc()+"\n");
						ps.setLong(5, datos.getIdcurso());
						ps.setString(1, datos.getNombrecurso());
						ps.setString(2, datos.getInstitutocurso());
						ps.setString(3, datos.getFechainicioc());
						ps.setString(4, datos.getFechaterminoc());
						ps.execute();
				}
				else {
							System.out.println("else entra "+datos.getIdcurso()+" "+datos.getIdcertificado());	
							PreparedStatement ps3 = con.prepareStatement(sql2);
							System.out.println("datos de la certifiacado insert: idcertificado "+idcertificado+" nombrecertificado "+datos.getNombrecertificado()+"\n");
							ps3.setLong(1, idcertificado);
							ps3.setString(3, datos.getNombrecertificado());
							ps3.setInt(2, 8);
							ps3.execute();
							PreparedStatement ps5 = con.prepareStatement(sql5);
							System.out.println("datos de la pivote 04: idcurso "+datos.getIdcurso()+" idcertificado "+idcertificado+"\n");
							ps5.setLong(1, datos.getIdcurso());
							ps5.setLong(2, idcertificado);
							ps5.execute();                 
						}
				
				return ps1;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Eliminar(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public int Eliminar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		final String sql="delete tblcursos where idcurso = (?)";
		
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, datos.getIdcurso());

				return ps;
			}
		});
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Buscar(com.vector.Beans.DatosCursoBean)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosCursoBean> Buscar(DatosCursoBean datos) {
		// TODO Auto-generated method stub
		final String sql = "select * from tblpiv15 piv15, tblpiv14 piv14 ,tblcursos cur where piv15.idestudio=piv14.idestudio and piv14.idcurso=cur.idcurso and piv15.idpersona =(?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				setDatosCurso(rs);
				return ps;
			}
		});
		List<DatosCursoBean> retorno = getDatosCurso();
		return retorno;
	}
	/* (non-Javadoc)
	 * @see com.vector.DAO.DAODatosCurso#Listar()
	 */
	@Override
	public List<DatosCursoBean> Listar() {
		// TODO Auto-generated method stub
		final String sql = "select * from tblcursos";
		return jdbcTemplate.query(sql, new CursoRowMapper());
	}
	
	private void setDatosCurso(ResultSet rs) throws SQLException{
		datos= new ArrayList<DatosCursoBean>();
		DatosCursoBean respuesta;
		while(rs.next()) {
			respuesta = new DatosCursoBean();
			respuesta.setIdcurso(rs.getInt(4));
			respuesta.setNombrecurso(rs.getString(6));
			respuesta.setInstitutocurso(rs.getString(7));
			respuesta.setFechainicioc(rs.getString(8));
			respuesta.setFechaterminoc(rs.getString(9));
			respuesta.setIdpersona(rs.getLong(2));
						
			this.datos.add(respuesta);
			}
	}

	private List<DatosCursoBean>getDatosCurso(){
		return this.datos;
	}

}

class CursoRowMapper implements RowMapper<DatosCursoBean> {
	@Override
	public DatosCursoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosCursoBean respuesta = new DatosCursoBean();
		respuesta.setIdcurso(rs.getInt(1));
		respuesta.setNombrecurso(rs.getString(2));
		respuesta.setInstitutocurso(rs.getString(3));
		respuesta.setFechainicioc(rs.getString(4));
		respuesta.setFechaterminoc(rs.getString(5));
		return respuesta;
	}
}

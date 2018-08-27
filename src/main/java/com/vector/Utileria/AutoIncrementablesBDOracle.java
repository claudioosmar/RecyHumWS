/**
 * 
 */
package com.vector.Utileria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vectormx
 *
 */

@Service
public class AutoIncrementablesBDOracle {

	private int respuesta = 0;
	
	@RequestMapping(value = "/UltimoID/Dominio",method=RequestMethod.POST)
	public int DominioIDUltimo(JdbcTemplate jdbcTemplate) {
		final String sql = "select max(iddominio) from tbldominio";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				rs.next();
				respuesta = (rs.getInt(1))+1;
				return ps;
			}
		});
		return respuesta ;
	}
	
@RequestMapping(value = "/UltimoID/Estudio",method=RequestMethod.POST)
public int EstudioIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idestudio) from tblestudios";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}

	@RequestMapping(value = "/UltimoID/Persona",method=RequestMethod.POST)
public int PersonaIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idpersona) from tblpersonas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}
@RequestMapping(value = "/UltimoID/PersonaDetalle",method=RequestMethod.POST)
public int PersonaDetalleIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(iddetpersona) from tbldetspersonas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}@RequestMapping(value = "/UltimoID/Area",method=RequestMethod.POST)
public int AreaIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idarea) from tblareas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}
@RequestMapping(value = "/UltimoID/Usuario",method=RequestMethod.POST)
public int UsuarioIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(iduser) from tblusers";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}
@RequestMapping(value = "/UltimoID/ExperienciaLaboral",method=RequestMethod.POST)
public int IDExpLaboralIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idexplaboral) from tblexpslaborales";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}
@RequestMapping(value = "/UltimoID/Empresas",method=RequestMethod.POST)
public int EmpresasIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idempresa) from tblempresas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}
@RequestMapping(value = "/UltimoID/Direccion",method=RequestMethod.POST)
public int DireccionIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(iddireccion) from tbldirecciones";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}

@RequestMapping(value = "/UltimoID/Certificado",method=RequestMethod.POST)
public int CertificadoIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idcertificado) from tblcertificado";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}


@RequestMapping(value = "/UltimoID/Curso",method=RequestMethod.POST)
public int CursoIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idcurso) from tblcursos";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}

@RequestMapping(value = "/UltimoID/Carrera",method=RequestMethod.POST)
public int CarreraIDUltimo(JdbcTemplate jdbcTemplate) {
	final String sql = "select max(idcarrera) from tblcarreras";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			respuesta = (rs.getInt(1))+1;
			return ps;
		}
	});
	return respuesta ;
}

}

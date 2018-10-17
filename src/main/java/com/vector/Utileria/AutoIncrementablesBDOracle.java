/**
 * 
 */
package com.vector.Utileria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: AutoIncrementablesBDOracle.java
 *   Descripción:  secuencia de autoincremento para las tablas
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  17/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: se agrego nueva sentencia para pistas auditoras
 *   
 */
//Clase pa incrementar las tablas al insertar en ellas
@Service
public class AutoIncrementablesBDOracle {
	
	/** The respuesta. */
	//variable de retorno
	private int respuesta = 0;
	
	/**
	 * Clase: DominioIDUltimo 
	 * Descripcion:.
	 *
	 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
	 * @return Retorna int
	 */
	//request mapping, url para llamar este metodo,metodo post
	@RequestMapping(value = "/UltimoID/Dominio",method=RequestMethod.POST)
	public int DominioIDUltimo(JdbcTemplate jdbcTemplate) {
		//sentencia sql para seleccionar la maxima fila encontrada en la tabla
		final String sql = "select max(iddominio) from tbldominio";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//se prepara la sentencia sql
				PreparedStatement ps = con.prepareStatement(sql);
				//obtencion de resultados al ejecutar la sentencia sql
				ResultSet rs = ps.executeQuery();
				//busca el siguiente valor si existe
				rs.next();
				//se le da el valor a la variable y encuentre el id +1
				respuesta = (rs.getInt(1))+1;
				//retorna el resultado del prepared
				return ps;
			}
		});
		//retorna el resultado
		return respuesta ;
	}
	
	/**
	 * Clase: EstudioIDUltimo 
	 * Descripcion:.
	 *
	 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
	 * @return Retorna int
	 */
	//request mapping, url para llamar este metodo,metodo post	
@RequestMapping(value = "/UltimoID/Estudio",method=RequestMethod.POST)
public int EstudioIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idestudio) from tblestudios";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: PersonaIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
	@RequestMapping(value = "/UltimoID/Persona",method=RequestMethod.POST)
public int PersonaIDUltimo(JdbcTemplate jdbcTemplate) {
		//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idpersona) from tblpersonas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}
	
	/**
	 * Clase: PersonaDetalleIDUltimo 
	 * Descripcion:.
	 *
	 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
	 * @return Retorna int
	 */
	//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/PersonaDetalle",method=RequestMethod.POST)
public int PersonaDetalleIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(iddetpersona) from tbldetspersonas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: AreaIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Area",method=RequestMethod.POST)
public int AreaIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idarea) from tblareas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: UsuarioIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Usuario",method=RequestMethod.POST)
public int UsuarioIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(iduser) from tblusers";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: IDExpLaboralIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/ExperienciaLaboral",method=RequestMethod.POST)
public int IDExpLaboralIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idexplaboral) from tblexpslaborales";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: EmpresasIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Empresas",method=RequestMethod.POST)
public int EmpresasIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idempresa) from tblempresas";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: DireccionIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Direccion",method=RequestMethod.POST)
public int DireccionIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(iddireccion) from tbldirecciones";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: CertificadoIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Certificado",method=RequestMethod.POST)
public int CertificadoIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idcertificado) from tblcertificado";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: CursoIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Curso",method=RequestMethod.POST)
public int CursoIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idcurso) from tblcursos";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}

/**
 * Clase: CarreraIDUltimo 
 * Descripcion:.
 *
 * @param jdbcTemplate Tipo de Dato resivido JdbcTemplate
 * @return Retorna int
 */
//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/Carrera",method=RequestMethod.POST)
public int CarreraIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idcarrera) from tblcarreras";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}


//request mapping, url para llamar este metodo,metodo post
@RequestMapping(value = "/UltimoID/PistaAud",method=RequestMethod.POST)
public int PistaIDUltimo(JdbcTemplate jdbcTemplate) {
	//sentencia sql para seleccionar la maxima fila encontrada en la tabla
	final String sql = "select max(idpista) from tblpistasaudit";
	jdbcTemplate.update(new PreparedStatementCreator() {
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			//se prepara la sentencia sql
			PreparedStatement ps = con.prepareStatement(sql);
			//obtencion de resultados al ejecutar la sentencia sql
			ResultSet rs = ps.executeQuery();
			//busca el siguiente valor si existe
			rs.next();
			//se le da el valor a la variable y encuentre el id +1
			respuesta = (rs.getInt(1))+1;
			//retorna el resultado del prepared
			return ps;
		}
	});
	//retorna el resultado
	return respuesta ;
}
//fin de la clase
}

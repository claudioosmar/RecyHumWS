/**
 * BusquedaAutomatica.java -- 28/08/2018
 */
package com.vector.Utileria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: BusquedaAutomatica.java
 *   Descripción:  busqueda automatica de listado
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  16/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: nuevo meto de busqueda por codigo postal
 *   
 */
@RestController
public class BusquedaAutomatica extends Log{

/** The idestado. */
/*variables*/
	private int idestado=0;
	
	/** The idmunicipio. */
	private int idmunicipio=0;
	
	/** The idlocalidad. */
	private int idlocalidad=0;
	
	/** The nombreestado. */
	private String nombreestado="";
	
	/** The nombremunicipio. */
	private String nombremunicipio="";
	
	/** The nombrelocalidad. */
	private String nombrelocalidad="";
	
	/** The codigopost. */
	private int codigopost=0;
	
	/** The datos. */
	List<BusquedaAutomatica> datos;
	
	/** The datos 2. */
	List<BusquedaAutomatica> datos2;
	
	/** The datos 3. */
	List<BusquedaAutomatica> datos3;
	
	/** The datos 4. */
	List<BusquedaAutomatica> datos4;
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Clase: BusquedaCP 
	 * Descripcion:.
	 *
	 * @param datos4 Tipo de Dato resivido BusquedaAutomatica
	 * @return Retorna list
	 */
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarCP",method=RequestMethod.POST)
	public List<BusquedaAutomatica>BusquedaCP(BusquedaAutomatica datos4) {
		info("entra en el metodo: codpost["+datos4.getCodigopost()+"]");
		//sentencia sql para recuperar los estados
		final String sql4 = "SELECT * FROM tbllocalidades WHERE codpost = (?)";
		final String sql5 = "SELECT idlocalidad, idmunicipio, nombre FROM tbllocalidades WHERE codpost = (?)";
		final String sql6 = "SELECT idestado, nombre FROM tblmunicipios WHERE idmunicipio = (?)";
		final String sql7 = "SELECT nombre FROM tblestados WHERE idestado = (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//preparacion de la sentencia
				info("datos en entrada para el sql5: CODIGOPOSTAL["+datos4.getCodigopost()+"]");
				PreparedStatement ps4 = con.prepareStatement(sql5);	
				ps4.setInt(1, datos4.getCodigopost());
				ResultSet rs4 = ps4.executeQuery();		
				if(rs4.next());
				info("ejecucion de la sentencia sql5: "+sql5);
				int idmunicipio = rs4.getInt(2);
				warn("datos enviados: IDMUNICIPIO["+idmunicipio+"]");	
				datos4.setIdlocalidad(rs4.getInt(1));
				datos4.setNombrelocalidad(rs4.getString(3));
				warn("datos enviados: IDLOCALIDAD["+rs4.getInt(1)+"], NOMBRELOCALIDAD["+rs4.getString(3)+"]");
				
				info("datos entrantes para el sql6: IDMUNICIPIO["+idmunicipio+"]");
				PreparedStatement ps5 = con.prepareStatement(sql6);
				ps5.setInt(1, idmunicipio);
				ResultSet rs5 = ps5.executeQuery();
				if(rs5.next());
				info("ejecucion de la sentencia sql5: "+sql5);
				datos4.setNombremunicipio(rs5.getString(2));
				int idestado = rs5.getInt(1);
				warn("datos enviados: NOMBREMUNICIPIO["+rs5.getString(2)+"], IDESTADO["+idestado+"]");
				
				info("datos entrantes para el sql7: IDESTADO["+idestado+"]");
				PreparedStatement ps6 = con.prepareStatement(sql7);
				ps6.setInt(1, idestado);
				ResultSet rs6 = ps6.executeQuery();
				if(rs6.next());
				info("ejecucion de la sentencia sql5: "+sql5);
				datos4.setNombreestado(rs6.getString(1));
				warn("datos enviados: NOMBREESTADO["+rs6.getString(1)+"]");
				
				info("datos en entrada para el sql5: CODIGOPOSTAL["+datos4.getCodigopost()+"]");
				PreparedStatement ps7 = con.prepareStatement(sql4);	
				ps7.setInt(1, datos4.getCodigopost());
				info("ejecucion de la sentencia sql4: "+sql4);
				
				info("llamada al metodo setDatosBusquedaCP(rs4)");
				setDatosBusquedaCP(rs4);
				return ps7;
		
			}
		});
		//variable de retorno que obtiene la lista de la opbencion de datos
		info("llamada al metodo getDatosBusquedaCP()");
		List<BusquedaAutomatica> retorno4 = getDatosBusquedaCP();
		//retorna retorno
		return retorno4;
	}
	
	
	/**
	 * Sets the datos busqueda CP.
	 *
	 * @param rs4 the new datos busqueda CP
	 * @throws SQLException the SQL exception
	 */
	private void setDatosBusquedaCP(ResultSet rs4) throws SQLException{
		datos4= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica datos4;
		info("entra en el while");
		while(rs4.next()) {
			datos4 = new BusquedaAutomatica();
			
			this.datos4.add(datos4);
			}
		info("se enlisto todo");
	}
	
	/**
	 * Gets the datos busqueda CP.
	 *
	 * @return the datos busqueda CP
	 */
	private List<BusquedaAutomatica>getDatosBusquedaCP(){
		return this.datos4;
	}
	
	
	/**
	 * Clase: Busqueda 
	 * Descripcion:.
	 *
	 * @param datos Tipo de Dato resivido BusquedaAutomatica
	 * @return Retorna list
	 */
	/*metodo para enlistar los estados desde la base de datos*/
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarEstado",method=RequestMethod.POST)
	public List<BusquedaAutomatica>Busqueda(BusquedaAutomatica datos) {
		//sentencia sql para recuperar los estados
		final String sql = "select * from tblestados order by nombre asc";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//preparacion de la sentencia
				PreparedStatement ps = con.prepareStatement(sql);	
				//mensaje en consola
				info("ejecucion de la sentencia sql: "+sql);
				// recuperando los datos
				ResultSet rs = ps.executeQuery();
				//metodo set que retorna las filas de la sentencia
				info("llamada al metodo setDatosBusquedaEstados(rs)");
				setDatosBusquedaEstados(rs);
				//retorna la sentencia
				return ps;
		
			}
		});
		//variable de retorno que obtiene la lista de la opbencion de datos
		info("llamada al metodo getDatosBusquedaEstados()");
		List<BusquedaAutomatica> retorno = getDatosBusquedaEstados();
		//retorna retorno
		return retorno;
	}
	
	/**
	 * Sets the datos busqueda estados.
	 *
	 * @param rs the new datos busqueda estados
	 * @throws SQLException the SQL exception
	 */
	private void setDatosBusquedaEstados(ResultSet rs) throws SQLException{
		datos= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica respuesta;
		info("entra en el while");
		while(rs.next()) {
			respuesta = new BusquedaAutomatica();
			respuesta.setIdestado(rs.getInt(1));
			respuesta.setNombreestado(rs.getString(3));
			this.datos.add(respuesta);
			}
		info("se enlistaron los estados");
	}

	/**
	 * Gets the datos busqueda estados.
	 *
	 * @return the datos busqueda estados
	 */
	private List<BusquedaAutomatica>getDatosBusquedaEstados(){
		return this.datos;
	}

	/**
	 * Clase: BusquedaMun 
	 * Descripcion:.
	 *
	 * @param datos1 Tipo de Dato resivido BusquedaAutomatica
	 * @return Retorna list
	 */
	/*metodo para enlistar los municipios desde la base de datos*/
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarMunicipio",method=RequestMethod.POST)
	public List<BusquedaAutomatica>BusquedaMun(@RequestBody BusquedaAutomatica datos1) {
		final String sql2 = "select * from tblmunicipios  where idestado=(?) order by nombre asc";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps2 = con.prepareStatement(sql2);
				debug("datos entrantes para la sentencia sql2: IDESTADO["+datos1.getIdestado()+"]");
				ps2.setInt(1, datos1.getIdestado());
				ResultSet rs = ps2.executeQuery();
				info("ejecucion de la sentencia sql2: "+sql2);
				info("llamada al metodo setDatosBusquedaMunicipio(rs)");
				setDatosBusquedaMunicipio(rs);
				return ps2;		
			}
		});
		info("llamada al metodo getDatosBusquedaMunicipio()");
		List<BusquedaAutomatica> retorno = getDatosBusquedaMunicipio();
		return retorno;
	}
	
	/**
	 * Sets the datos busqueda municipio.
	 *
	 * @param rs the new datos busqueda municipio
	 * @throws SQLException the SQL exception
	 */
	private void setDatosBusquedaMunicipio(ResultSet rs) throws SQLException{
		datos2= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica respuesta;
		info("entra en el while");
		while(rs.next()) {
			respuesta = new BusquedaAutomatica();
			respuesta.setIdmunicipio(rs.getInt(1));
			respuesta.setNombremunicipio(rs.getString(4));
			respuesta.setIdestado(rs.getInt(2));
			this.datos2.add(respuesta);
			}
		info("se enlistaron los municipios");
	}

	/**
	 * Gets the datos busqueda municipio.
	 *
	 * @return the datos busqueda municipio
	 */
	private List<BusquedaAutomatica>getDatosBusquedaMunicipio(){
		return this.datos2;
	}
	
	/**
	 * Clase: BusquedaLoc 
	 * Descripcion:.
	 *
	 * @param datos2 Tipo de Dato resivido BusquedaAutomatica
	 * @return Retorna list
	 */
	/*metodo para enlistar las localidades desde la base de datos*/
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarLocalidad",method=RequestMethod.POST)
	public List<BusquedaAutomatica>BusquedaLoc(@RequestBody BusquedaAutomatica datos2) {
		final String sql3 = "select * from tbllocalidades where idmunicipio=(?) order by nombre asc";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps3 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: IDMUNICIPIO["+datos2.getIdmunicipio()+"]");
				ps3.setInt(1, datos2.getIdmunicipio());
				ResultSet rs = ps3.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				info("llamada al metodo setDatosBusquedaLocalidad(rs)");
				setDatosBusquedaLocalidad(rs);
				return ps3;
				
				
			}
		});
		info("llamada al metodo getDatosBusquedaLocalidad()");
		List<BusquedaAutomatica> retorno = getDatosBusquedaLocalidad();
		return retorno;
	}
	
	/**
	 * Sets the datos busqueda localidad.
	 *
	 * @param rs the new datos busqueda localidad
	 * @throws SQLException the SQL exception
	 */
	private void setDatosBusquedaLocalidad(ResultSet rs) throws SQLException{
		datos3= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica respuesta;
		info("entra en el while");
		while(rs.next()) {
			respuesta = new BusquedaAutomatica();
			respuesta.setIdlocalidad(rs.getInt(1));
			respuesta.setNombrelocalidad(rs.getString(4));
			respuesta.setIdmunicipio(rs.getInt(2));
			this.datos3.add(respuesta);
			}
		info("se enlistaron las localidades");
	}

	/**
	 * Gets the datos busqueda localidad.
	 *
	 * @return the datos busqueda localidad
	 */
	private List<BusquedaAutomatica>getDatosBusquedaLocalidad(){
		return this.datos3;
	}
	
	/*getters y setters*/
	
	/**
	 * Gets the idestado.
	 *
	 * @return Obtienes el valor de idestado
	 */
	
	public int getIdestado() {
		return idestado;
	}


	
	/**
	 * Sets the idestado.
	 *
	 * @param idestado the new idestado
	 */
	
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}


	
	/**
	 * Gets the idmunicipio.
	 *
	 * @return Obtienes el valor de idmunicipio
	 */
	
	public int getIdmunicipio() {
		return idmunicipio;
	}


	
	/**
	 * Sets the idmunicipio.
	 *
	 * @param idmunicipio the new idmunicipio
	 */
	
	public void setIdmunicipio(int idmunicipio) {
		this.idmunicipio = idmunicipio;
	}


	
	/**
	 * Gets the idlocalidad.
	 *
	 * @return Obtienes el valor de idlocalidad
	 */
	
	public int getIdlocalidad() {
		return idlocalidad;
	}


	
	/**
	 * Sets the idlocalidad.
	 *
	 * @param idlocalidad the new idlocalidad
	 */
	
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}


	/**
	 * Gets the nombreestado.
	 *
	 * @return Obtienes el valor de nombreestado
	 */
	
	public String getNombreestado() {
		return nombreestado;
	}

	
	/**
	 * Sets the nombreestado.
	 *
	 * @param nombreestado the new nombreestado
	 */
	
	public void setNombreestado(String nombreestado) {
		this.nombreestado = nombreestado;
	}

	
	/**
	 * Gets the nombremunicipio.
	 *
	 * @return Obtienes el valor de nombremunicipio
	 */
	
	public String getNombremunicipio() {
		return nombremunicipio;
	}

	
	/**
	 * Sets the nombremunicipio.
	 *
	 * @param nombremunicipio the new nombremunicipio
	 */
	
	public void setNombremunicipio(String nombremunicipio) {
		this.nombremunicipio = nombremunicipio;
	}

	
	/**
	 * Gets the nombrelocalidad.
	 *
	 * @return Obtienes el valor de nombrelocalidad
	 */
	
	public String getNombrelocalidad() {
		return nombrelocalidad;
	}

	
	/**
	 * Sets the nombrelocalidad.
	 *
	 * @param nombrelocalidad the new nombrelocalidad
	 */
	
	public void setNombrelocalidad(String nombrelocalidad) {
		this.nombrelocalidad = nombrelocalidad;
	}

	
	/**
	 * Gets the codigopost.
	 *
	 * @return Obtienes el valor de codigopost del tipo int
	 */
	
	public int getCodigopost() {
		return codigopost;
	}

	
	/**
	 * Sets the codigopost.
	 *
	 * @param codigopost the new codigopost
	 */
	
	public void setCodigopost(int codigopost) {
		this.codigopost = codigopost;
	}
	
	
}

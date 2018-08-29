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



/**
 * @author Claudio
 *RecyHumWS2--com.vector.Utileria--BusquedaAutomatica
 */

@RestController
public class BusquedaAutomatica {
/*variables*/
	private int idestado=0;
	private int idmunicipio=0;
	private int idlocalidad=0;
	private String nombreestado="";
	private String nombremunicipio="";
	private String nombrelocalidad="";
	List<BusquedaAutomatica> datos;
	List<BusquedaAutomatica> datos2;
	List<BusquedaAutomatica> datos3;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*metodo para enlistar los estados desde la base de datos*/
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarEstado",method=RequestMethod.POST)
	public List<BusquedaAutomatica>Busqueda(BusquedaAutomatica datos) {
		final String sql = "select * from tblestados";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);	
				System.out.println("se enlistaron los estados");
				ResultSet rs = ps.executeQuery();
				setDatosBusquedaEstados(rs);
				return ps;
		
			}
		});
		List<BusquedaAutomatica> retorno = getDatosBusquedaEstados();
		return retorno;
	}
	
	private void setDatosBusquedaEstados(ResultSet rs) throws SQLException{
		datos= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica respuesta;
		while(rs.next()) {
			respuesta = new BusquedaAutomatica();
			respuesta.setIdestado(rs.getInt(1));
			respuesta.setNombreestado(rs.getString(3));
			this.datos.add(respuesta);
			}
	}

	private List<BusquedaAutomatica>getDatosBusquedaEstados(){
		return this.datos;
	}

	/*metodo para enlistar los municipios desde la base de datos*/
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarMunicipio",method=RequestMethod.POST)
	public List<BusquedaAutomatica>BusquedaMun(@RequestBody BusquedaAutomatica datos1) {
		final String sql2 = "select * from tblmunicipios where idestado=(?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps2 = con.prepareStatement(sql2);
				System.out.println("se enlistaron los municipios del estado "+datos1.getIdestado()+"\n ");
				ps2.setInt(1, datos1.getIdestado());
				ResultSet rs = ps2.executeQuery();
				setDatosBusquedaMunicipio(rs);
				return ps2;		
			}
		});
		List<BusquedaAutomatica> retorno = getDatosBusquedaMunicipio();
		return retorno;
	}
	
	private void setDatosBusquedaMunicipio(ResultSet rs) throws SQLException{
		datos2= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica respuesta;
		while(rs.next()) {
			respuesta = new BusquedaAutomatica();
			respuesta.setIdmunicipio(rs.getInt(1));
			respuesta.setNombremunicipio(rs.getString(4));
			respuesta.setIdestado(rs.getInt(2));
			this.datos2.add(respuesta);
			}
	}

	private List<BusquedaAutomatica>getDatosBusquedaMunicipio(){
		return this.datos2;
	}
	
	/*metodo para enlistar las localidades desde la base de datos*/
	@RequestMapping(value = "/SGRHWebService/BusquedaAutomatica/ListarLocalidad",method=RequestMethod.POST)
	public List<BusquedaAutomatica>BusquedaLoc(@RequestBody BusquedaAutomatica datos2) {
		final String sql3 = "select * from tbllocalidades where idmunicipio=(?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps3 = con.prepareStatement(sql3);
				System.out.println("se enlistaron las localidades del municipio "+datos2.getIdmunicipio()+"\n ");
				ps3.setInt(1, datos2.getIdmunicipio());
				ResultSet rs = ps3.executeQuery();
				setDatosBusquedaLocalidad(rs);
				return ps3;
				
				
			}
		});
		List<BusquedaAutomatica> retorno = getDatosBusquedaLocalidad();
		return retorno;
	}
	
	private void setDatosBusquedaLocalidad(ResultSet rs) throws SQLException{
		datos3= new ArrayList<BusquedaAutomatica>();
		BusquedaAutomatica respuesta;
		while(rs.next()) {
			respuesta = new BusquedaAutomatica();
			respuesta.setIdlocalidad(rs.getInt(1));
			respuesta.setNombrelocalidad(rs.getString(4));
			respuesta.setIdmunicipio(rs.getInt(2));
			this.datos3.add(respuesta);
			}
	}

	private List<BusquedaAutomatica>getDatosBusquedaLocalidad(){
		return this.datos3;
	}
	
	/*getters y setters*/
	
	/**
	 * @return Obtienes el valor de idestado
	 */
	
	public int getIdestado() {
		return idestado;
	}


	
	/**
	 * @param Agregar el valor a idestado
	 */
	
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}


	
	/**
	 * @return Obtienes el valor de idmunicipio
	 */
	
	public int getIdmunicipio() {
		return idmunicipio;
	}


	
	/**
	 * @param Agregar el valor a idmunicipio
	 */
	
	public void setIdmunicipio(int idmunicipio) {
		this.idmunicipio = idmunicipio;
	}


	
	/**
	 * @return Obtienes el valor de idlocalidad
	 */
	
	public int getIdlocalidad() {
		return idlocalidad;
	}


	
	/**
	 * @param Agregar el valor a idlocalidad
	 */
	
	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}


	/**
	 * @return Obtienes el valor de nombreestado
	 */
	
	public String getNombreestado() {
		return nombreestado;
	}

	
	/**
	 * @param Agregar el valor a nombreestado
	 */
	
	public void setNombreestado(String nombreestado) {
		this.nombreestado = nombreestado;
	}

	
	/**
	 * @return Obtienes el valor de nombremunicipio
	 */
	
	public String getNombremunicipio() {
		return nombremunicipio;
	}

	
	/**
	 * @param Agregar el valor a nombremunicipio
	 */
	
	public void setNombremunicipio(String nombremunicipio) {
		this.nombremunicipio = nombremunicipio;
	}

	
	/**
	 * @return Obtienes el valor de nombrelocalidad
	 */
	
	public String getNombrelocalidad() {
		return nombrelocalidad;
	}

	
	/**
	 * @param Agregar el valor a nombrelocalidad
	 */
	
	public void setNombrelocalidad(String nombrelocalidad) {
		this.nombrelocalidad = nombrelocalidad;
	}
	
	
}
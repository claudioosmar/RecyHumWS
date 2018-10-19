/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.ConvertirFecha;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: DAODatosPersonalesImpl.java
 *   Descripción:  contiene los metedos crear, modificar, eliminar, buscar, listar implementadas del DAO y las sentenicas sql
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *  16/10/2018 Jair de Jesus Barcenas Gomez - Modificacion: nuevos arreglos en los metodos de insercion y modificacion
 *   
 */
@Service
public class DAODatosPersonalesImpl extends Log implements DAODatosPersonales {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The ultimoid. */
	AutoIncrementablesBDOracle ultimoid;
	
	/** The c. */
	Calendar c;
	
	/** The dia. */
	String dia = "";
	
	/** The mes. */
	String mes = "";
	
	/** The annio. */
	String annio = "";

	/** 
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	public int Crear(DatosPersonalesBean datos) {
		info("se mando a llamar este metodo");
		ultimoid = new AutoIncrementablesBDOracle();
		// Ultimas ID´s en la base de datos
		int iDpersona = ultimoid.PersonaIDUltimo(jdbcTemplate);
		int IDpersonadetalle = ultimoid.PersonaDetalleIDUltimo(jdbcTemplate);
		int IDDireccion = ultimoid.DireccionIDUltimo(jdbcTemplate);

		// Sentencias SQL a ejecutar
		final String sql = "INSERT INTO TBLPERSONAS VALUES(?,?,?,?,?,?,?,?)";
		final String sql2 = "INSERT INTO TBLDETSPERSONAS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		final String sql3 = "INSERT INTO TBLDIRECCIONES VALUES(?,?,?,?,?,?,?)";
		final String sql4 = "INSERT INTO TBLpiv03 VALUES(?,?,?,?)";
		final String sql5 = "INSERT INTO TBLPIV11 VALUES(?,?)";
		final String sql6 = "INSERT INTO TBLPIV01 VALUES(?,?,?)";
		final String sql7 = "INSERT INTO TBLPIV02 VALUES(?,?,?)";
		final String sql8 = "select * from tblpersonas where idpersona =(?)";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos entrantes para el sql: IDPERSONA["+iDpersona+"], URLFOTO["+datos.getUrlFoto()+"], RESUMEN["+datos.getResumen()+"], OBJETIVOLABORAL["+datos.getObjetivoLaboral()+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				// Primera Insersion TBLPersonas
				ps.setLong(1, iDpersona);
				ps.setInt(2, 1);
				ps.setString(3, datos.getUrlFoto());
				ps.setInt(4, 0);
				ps.setString(5, datos.getResumen());
				ps.setString(6, datos.getObjetivoLaboral());
				ps.setString(7, "0.0");
				ps.setString(8, "sin asignar");
				ResultSet rs = ps.executeQuery();
				info("ejecucion de la sentencia sql: "+sql);
				rs.next();

				// Segunda Insersion tbldireccion
				PreparedStatement ps3 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: IDDIRECCION["+IDDireccion+"], CALLE["+ datos.getCalle()+"], COLONIA["+datos.getColonia()+"], NUMEROINTERIO["+ datos.getNumeroInterior()+"], NUMEROEXTERIOR["+datos.getNumeroExterior()+"], CODIGOPOSTAL["+datos.getCodpost()+"], IDLOCALIDAD["+datos.getIdlocalidad()+"]");
				ps3.setInt(1, IDDireccion);
				ps3.setString(2, datos.getCalle());
				ps3.setString(3, datos.getColonia());
				ps3.setString(4, datos.getNumeroInterior());
				ps3.setString(5, datos.getNumeroExterior());
				ps3.setInt(6, datos.getCodpost());
				ps3.setInt(7, datos.getIdlocalidad());
				ResultSet rs3 = ps3.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				rs3.next();
				// Tercera insersion tbldetspersona
				debug("datos entrantes para el sql2: IDPERSONADETALLE["+IDpersonadetalle+"], IDPERSONA["+iDpersona+"], IDDIRECCION["+IDDireccion+"], ESTADOCIVIL["+datos.getIdEdoCivil()+"], NOMBRE["+datos.getPrimerNombre()+"], SEGUNDONOMBRE["+datos.getSegundoNombre()+"], APELLIDOPATERNO["+datos.getApellidPterno()+"], APELLIDOMATERNO["+datos.getApellidMaterno()+"], SEXO["+datos.getIdSexo()+"], FECHANACIMIENTO["+datos.getFechaNacimiento()+"], NACIONALIDAD["+datos.getNacionalidad()+"]");
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, IDpersonadetalle);
				ps2.setLong(2, iDpersona);
				ps2.setLong(3, IDDireccion);
				ps2.setLong(4, datos.getIdEdoCivil());
				ps2.setString(5, datos.getPrimerNombre());
				ps2.setString(6, datos.getSegundoNombre());
				ps2.setString(7, datos.getApellidPterno());
				ps2.setString(8, datos.getApellidMaterno());
				ps2.setString(9, datos.getIdSexo());
				ps2.setString(10, datos.getFechaNacimiento());
				ps2.setString(11, datos.getNacionalidad());
				ResultSet rs2 = ps2.executeQuery();
				info("ejecucion de la sentencia sql2: "+sql2);
				rs2.next();
				// Cuartar insersion piv03 --Documentos -- RFC
				debug("datos entrantes para el sql4: IDPERSONA["+iDpersona+"], RFC["+datos.getRfc()+"], URLRFC["+datos.getUrlRfc()+"]");
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setInt(1, iDpersona);
				ps4.setInt(2, 2);
				ps4.setString(3, datos.getRfc());
				ps4.setString(4, datos.getUrlRfc());
				ResultSet rs4 = ps4.executeQuery();
				info("ejecucion de la sentenca sql4: "+sql4);
				rs4.next();

				// Quinta insersion piv03 --Documentos -- Curp
				debug("datos entrantes para el sql4: IDPERSONA["+iDpersona+"], CURP["+datos.getcURP()+"], URLCURP["+datos.getUrlcURP()+"]");
				PreparedStatement ps5 = con.prepareStatement(sql4);
				ps5.setInt(1, iDpersona);
				ps5.setInt(2, 4);
				ps5.setString(3, datos.getcURP());
				ps5.setString(4, datos.getUrlcURP());
				ResultSet rs5 = ps5.executeQuery();
				info("ejecucion de la sentenca sql4: "+sql4);
				rs5.next();

				// Sexta insersion piv03 --Documentos -- Acta de nacimiento
				debug("datos entrantes para el sql4: IDPERSONA["+iDpersona+"], FECHANACIMIENTO["+datos.getFechaNacimiento()+"], URLFECHANACIMIENTO["+datos.getUrlFechaNacimiento()+"]");
				PreparedStatement ps6 = con.prepareStatement(sql4);
				ps6.setInt(1, iDpersona);
				ps6.setInt(2, 1);
				ps6.setString(3, datos.getFechaNacimiento());
				ps6.setString(4, datos.getUrlFechaNacimiento());
				ResultSet rs6 = ps6.executeQuery();
				info("ejecucion de la sentenca sql4: "+sql4);
				rs6.next();

				// Septima insersion piv03 --Documentos -- Numero del Seguro Social
				debug("datos entrantes para el sql4: IDPERSONA["+iDpersona+"], NSS["+datos.getSeguroSocial()+"], URLNSS["+datos.getUrlSeguroSocial()+"]");
				PreparedStatement ps7 = con.prepareStatement(sql4);
				ps7.setInt(1, iDpersona);
				ps7.setInt(2, 5);
				ps7.setString(3, datos.getSeguroSocial());
				ps7.setString(4, datos.getUrlSeguroSocial());
				ResultSet rs7 = ps7.executeQuery();
				info("ejecucion de la sentenca sql4: "+sql4);
				rs7.next();
				// Octava Insersion --Documentos -- Domicilio --nulo
				if (!datos.getUrlComprobanteDomicilio().equals(" ")) {
					info("entra en el if");
					debug("datos entrantes para el sql4: IDPERSONA["+iDpersona+"], COLONIA["+datos.getColonia()+"], URLCOMPROBANTEDOMICILIO["+datos.getUrlComprobanteDomicilio()+"]");
					PreparedStatement ps8 = con.prepareStatement(sql4);
					ps8.setInt(1, iDpersona);
					ps8.setInt(2, 3);
					ps8.setString(3, datos.getColonia());
					ps8.setString(4, datos.getUrlComprobanteDomicilio());
					ResultSet rs8 = ps8.executeQuery();
					info("ejecucion de la sentencia sql4: "+sql4);
					rs8.next();
				}
				// novena Insersion -- Otros Documentos -- infonavit --nulos
				if (datos.getIdInfonavit() != 0) {
					info("entra en el if");
					debug("datos entrantes en sql5: IDPERSONA[" + iDpersona + "]");
					PreparedStatement ps9 = con.prepareStatement(sql5);
					ps9.setInt(2, iDpersona);
					ps9.setInt(1, 5);
					ResultSet rs9 = ps9.executeQuery();
					info("ejecucion de la sentencia sql5: "+sql5);
					rs9.next();
				}
				// Decima insersion -- Otros Documentos -- Disponibilidad de viajar --nulos
				if (datos.getIdDisponibilidadViajar() != 0) {
					info("entra en el if");
					debug("datos entrantes en sql5: IDPERSONA[" + iDpersona + "]");
					PreparedStatement ps10 = con.prepareStatement(sql5);
					ps10.setInt(2, iDpersona);
					ps10.setInt(1, 1);
					ResultSet rs10 = ps10.executeQuery();
					info("ejecucion de la sentencia sql5: "+sql5);
					rs10.next();
				}
				// Onceava insersion -- Otros Documentos -- Disponibilidad de Cambio --nulos
				if (datos.getIdDisponibilidadCambio() != 0) {
					info("entra en el if");
					debug("datos entrantes en sql5: IDPERSONA[" + iDpersona + "]");
					PreparedStatement ps11 = con.prepareStatement(sql5);
					ps11.setInt(2, iDpersona);
					ps11.setInt(1, 2);
					ResultSet rs11 = ps11.executeQuery();
					info("ejecucion de la sentencia sql5: "+sql5);
					rs11.next();
				}
				debug("datos entrantes para el sql6: IDPERSONA["+iDpersona+"], IDTELEFONOPRINCIPAL["+datos.getIdTelefonoPrincipal()+"], TELEFONOPRINCIPAL"+datos.getTelefonoPrincipal()+"]");
				// Doceava insersion -- Telefonos -- Telefono Principal
				PreparedStatement ps12 = con.prepareStatement(sql6);
				ps12.setInt(1, iDpersona);
				ps12.setInt(2, datos.getIdTelefonoPrincipal());
				ps12.setString(3, datos.getTelefonoPrincipal());
				ResultSet rs12 = ps12.executeQuery();
				info("ejecucion de la sentencia sql6: "+sql6);
				rs12.next();
				// Treceava insersion -- Telefonos -- Telefono Secundario --nulos
				if (!datos.getTelefonoSecundario().equals(" ")) {
					info("entra en el if");
					debug("datos entrantes para el sql6: IDPERSONA["+iDpersona+"], IDTELEFONOSECUNDARIO["+datos.getIdTelefonoSecundario()+"], TELEFONOSECUNDARIOL"+datos.getTelefonoSecundario()+"]");
					PreparedStatement ps13 = con.prepareStatement(sql6);
					ps13.setInt(1, iDpersona);
					ps13.setInt(2, datos.getIdTelefonoSecundario());
					ps13.setString(3, datos.getTelefonoSecundario());
					ResultSet rs13 = ps13.executeQuery();
					info("ejecucion de la sentencia sql6: "+sql6);
					rs13.next();
				}
				debug("datos entrantes para el sql6: IDPERSONA["+iDpersona+"], TELEFONOEMERGENCIA"+datos.getTelefonoEmergencia()+"]");
				// Catorceava insersion -- Telefonos -- Telefono de Emergencia
				PreparedStatement ps14 = con.prepareStatement(sql6);
				ps14.setInt(1, iDpersona);
				ps14.setInt(2, 3);
				ps14.setString(3, datos.getTelefonoEmergencia());
				ResultSet rs14 = ps14.executeQuery();
				info("ejecucion de la sentencia sql6: "+sql6);
				rs14.next();
//				// Quinteava insersion -- Correos -- Correo Principal
//				debug("datos entrantes para el sql7: IDPERSONA["+iDpersona+"], CORREOPRINCIPAL"+datos.getCorreoPrincipal()+"]");
//				PreparedStatement ps15 = con.prepareStatement(sql7);
//				ps15.setInt(1, iDpersona);
//				ps15.setInt(2, 1);
//				ps15.setString(3, datos.getCorreoPrincipal());
//				ResultSet rs15 = ps15.executeQuery();
//				info("ejecucion de la sentencia sql7: "+sql7);
//				rs15.next();
				// dieciseisava insersion -- Correos -- Correo Secundario --nulos
				if (!datos.getCorreoSecundario().equals(" ")) {
					info("entra en el if");
					debug("datos entrantes para el sql7: IDPERSONA["+iDpersona+"], IDCORREOSECUNDARIO["+datos.getIdCorreoSecundario()+"], CORREOSECUNDARIOL"+datos.getCorreoSecundario()+"]");
					PreparedStatement ps16 = con.prepareStatement(sql7);
					ps16.setInt(1, iDpersona);
					ps16.setInt(2, datos.getIdCorreoSecundario());
					ps16.setString(3, datos.getCorreoSecundario());
					ResultSet rs16 = ps16.executeQuery();
					info("ejecucion de la sentencia sql7: "+sql7);
					rs16.next();
				}
				// Diesieteava insersion -- Otros Documentos -- Pasaporte --nulos
				if (datos.getIdpasaporte() != 0) {
					info("entra en el if");
					debug("datos entrantes en sql5: IDPERSONA[" + iDpersona + "]");
					PreparedStatement ps17 = con.prepareStatement(sql5);
					ps17.setInt(2, iDpersona);
					ps17.setInt(1, 3);
					ResultSet rs17 = ps17.executeQuery();
					info("ejecucion de la sentencia sql5: "+sql5);
					rs17.next();
				}
				// Dieciochoava insersion -- Otros Documentos -- Visa --nulos

				if (datos.getIdVisa() != 0) {
					info("entra en el if");
					debug("datos entrantes en sql5: IDPERSONA[" + iDpersona + "]");
					PreparedStatement ps18 = con.prepareStatement(sql5);
					ps18.setInt(2, iDpersona);
					ps18.setInt(1, 4);
					ResultSet rs18 = ps18.executeQuery();
					info("ejecucion de la sentencia sql5: "+sql5);
					rs18.next();
				}
				PreparedStatement ps19 = con.prepareStatement(sql8);
				info("datos de entrada para el sql8: IDPERSONA[" + iDpersona+"]");
				ps19.setInt(1, iDpersona);
				info("ejecucion de la sentencia sql8: " +sql8);
				return ps19;
			}
		});
		if (respuesta == 1) {
			warn("datos enviados: IDPERSONA["+iDpersona+"],RESPUESTA["+respuesta+"]");
			return iDpersona;
		} else {
			error("dato no enviado");
			return 0;
		}
	}


	/** 
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	public int Eliminar(long id) {
		info("se mando a llamar este metodo");
		final String sql = "DELETE TBLPERSONAS WHERE IDPERSONA = ?";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para sql: IDPERSONA["+id+"]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				info("ejecucion de la sentencias sql: "+sql);
				return ps;

			}
		});
		warn("envio respuesta: "+respuesta);
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	public DatosPersonalesBean Buscar(DatosPersonalesBean datos) {
		info("se mando a llamar este metodo");
		DatosPersonalesBean retorno = new DatosPersonalesBean();
		/* Sentencias SQL a ejecutar */
		// final String sql = "SELECT * FROM TBLPERSONAS PERS, TBLAREAS ARS,
		// tbldetspersonas dts, tblestadosciviles edo, tbldirecciones dir WHERE
		// dir.iddireccion = dts.iddireccion and dts.idedocivil=edo.idedocivil and
		// PERS.IDAREA=ARS.IDAREA and pers.idpersona=dts.idpersona AND PERS.IDPERSONA=
		// (?)";
		final String sql2 = "SELECT * FROM TBLPERSONAS per, tblareas ars WHERE per.idarea=ars.idarea and IDPERSONA=(?)";
		final String sql3 = "SELECT * FROM TBLDETSPERSONAS DTS, tblestadosciviles EDO WHERE DTS.IDEDOCIVIL=edo.idedocivil AND IDPERSONA=(?)";
		final String sql4 = "SELECT * FROM TBLPIV03 WHERE IDPERSONA=(?) AND IDDOC =(?)";
		final String sql5 = "SELECT * FROM TBLPIV11 WHERE IDPERSONA=(?) AND IDOTROSDOC =(?)";
		final String sql6 = "SELECT * FROM TBLDETSPERSONAS DTS,TBLDIRECCIONES TDS, tbllocalidades loc WHERE DTS.IDDIRECCION=TDS.IDDIRECCION and tds.idlocalidad=loc.idlocalidad AND IDPERSONA=(?)";
		final String sql7 = "SELECT * FROM TBLPIV11  WHERE IDPERSONA =(?) AND IDOTROSDOC=(?)";
		final String sql8 = "select * from tblpiv01 where idpersona=(?) and idtipotelefono =(?)";
		final String sql9 = "select * from tblpiv02 where idpersona=(?) and idtipocorreo =(?)";
		final String sql10 = "select * from view_datospersonales where idp=(?)";
		// Apartado de execuciones
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				debug("datos de entrada para sql2(1): IDPERSONA["+datos.getIdpersona()+"]");
				// consulta la tabla personas
				PreparedStatement ps0 = con.prepareStatement(sql2);
				ps0.setLong(1, datos.getIdpersona());
				ResultSet rs0 = ps0.executeQuery();
				info("ejecucin de la sentencia sql2(1) "+ sql2);
				if (rs0.next()) {
					info("entra en la sentencia if");
					retorno.setUrlFoto(rs0.getString(3));
					retorno.setResumen(rs0.getString(5));
					retorno.setObjetivoLaboral(rs0.getString(6));
					retorno.setSueldo(rs0.getInt(7));
					retorno.setNcontrol(rs0.getString(8));
					retorno.setNombreArea(rs0.getString(10));
					retorno.setCodArea(rs0.getString(11));
					warn("datos enviados: URLFOTO["+rs0.getString(3)+"], RESUMEN["+rs0.getString(5)+"], OBJETIVOLABORAL["+rs0.getString(6)+"], SUELDO["+rs0.getInt(7)+"], NUMEROCONTROL["+rs0.getString(8)+"], NOMBREAREA["+rs0.getString(10)+"], CODIGOAREA["+rs0.getString(11)+"]");
				}
				
				// consulta la tabla detalle persona
				debug("datos de entrada para sql3(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps01 = con.prepareStatement(sql3);
				ps01.setLong(1, datos.getIdpersona());
				ResultSet rs01 = ps01.executeQuery();
				info("ejecucin de la sentencia sql3(1)"+ sql3);
				if (rs01.next()) {
					info("entra en la sentencia if");
					retorno.setIdEdoCivil(rs01.getInt(4));
					retorno.setPrimerNombre(rs01.getString(5));
					retorno.setSegundoNombre(rs01.getString(6));
					retorno.setApellidPterno(rs01.getString(7));
					retorno.setApellidMaterno(rs01.getString(8));
					retorno.setIdSexo(rs01.getString(9));
					retorno.setFechaNacimiento(rs01.getString(10));
					retorno.setNacionalidad(rs01.getString(11));
					retorno.setEstadoCivil(rs01.getString(13));
					warn("datos enviados: IDESTADOCIVIL["+rs01.getInt(4)+"], ESTADOCIVIL["+rs01.getString(13)+"], NOMBRE["+rs01.getString(5)+"], SEGUNDONOMBRE["+rs01.getString(6)+"], APELLIDOPATERNO["+rs01.getString(7)+"], APELLIDOMATERNO["+rs01.getString(8)+"], SEXO["+rs01.getString(9)+"], FECHANACIMIENTO["+rs01.getString(10)+"], NACIONALIDAD["+rs01.getString(11)+"]");
				}
				// consulta la vista datos personales para la edad
				debug("datos de entrada para sql10(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps20 = con.prepareStatement(sql10);
				ps20.setLong(1, datos.getIdpersona());
				ResultSet rs20 = ps20.executeQuery();
				info("ejecucin de la sentencia sql10(1)"+ sql10);
				if (rs20.next()) {
					retorno.setEdad(rs20.getInt(7));
					warn("datos enviados: EDAD["+rs20.getInt(7)+"]");
				}
				// consulta la tabla piv03 para obtener el RFC
				debug("datos de entrada para sql4(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps02 = con.prepareStatement(sql4);
				ps02.setLong(1, datos.getIdpersona());
				ps02.setInt(2, 2);
				ResultSet rs02 = ps02.executeQuery();
				info("ejecucin de la sentencia sql4(1): "+ sql4);
				if (rs02.next()) {
					info("entra en la sentencia if");
					retorno.setRfc(rs02.getString(3));
					warn("datos enviados: RFC["+rs02.getString(3)+"]");
				}
				// consulta la tabla piv03 para obtener el CURP
				debug("datos de entrada para sql4(2): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps03 = con.prepareStatement(sql4);
				ps03.setLong(1, datos.getIdpersona());
				ps03.setInt(2, 4);
				ResultSet rs03 = ps03.executeQuery();
				info("ejecucin de la sentencia sql4(2): "+ sql4);
				if (rs03.next()) {
					info("entra en la sentencia if");
					retorno.setcURP(rs03.getString(3));
					warn("datos enviados: CURP["+rs03.getString(3)+"]");
				}

				// verifica que se tenga un valor para pasaporte
				debug("datos de entrada para sql7(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux004 = con.prepareStatement(sql7);
				psAux004.setLong(1, datos.getIdpersona());
				psAux004.setLong(2, 3);
				ResultSet rsAux004 = psAux004.executeQuery();
				info("ejecucin de la sentencia sql7(1): "+ sql7);

				// consulta la tabla piv11 para obetener pasaporte
				if (rsAux004.next()) {
					info("entra en la sentencia if");
					debug("datos de entrada para sql5(1): IDPERSONA["+datos.getIdpersona()+"]");
					PreparedStatement ps04 = con.prepareStatement(sql5);
					ps04.setLong(1, datos.getIdpersona());
					ps04.setInt(2, 3);
					ResultSet rs04 = ps04.executeQuery();
					info("ejecucin de la sentencia sql5(1): "+ sql5);
					rs04.next();
					retorno.setIdpasaporte(rs04.getInt(1));
					warn("datos enviados: PASAPORTE["+rs04.getInt(1)+"]");
				}

				// verifica que se tenga un valor para visa
				debug("datos de entrada para sql7(2): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux005 = con.prepareStatement(sql7);
				psAux005.setLong(1, datos.getIdpersona());
				psAux005.setLong(2, 4);
				ResultSet rsAux005 = psAux005.executeQuery();
				info("ejecucin de la sentencia sql7(2): "+ sql7);

				// consulta la tabla piv11 para obetener visa
				if (rsAux005.next()) {
					info("entra en la sentencia if");
					debug("datos de entrada para sql5(2): IDPERSONA["+datos.getIdpersona()+"]");
					PreparedStatement ps05 = con.prepareStatement(sql5);
					ps05.setLong(1, datos.getIdpersona());
					ps05.setInt(2, 4);
					ResultSet rs05 = ps05.executeQuery();
					info("ejecucin de la sentencia sql5(2): "+ sql5);
					rs05.next();
					retorno.setIdVisa(rs05.getInt(1));
					warn("datos enviados: VISA["+rs05.getInt(1)+"]");
				}
				// consulta la tabla piv03 para obtener el NSS
				debug("datos de entrada para sql4(3): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps06 = con.prepareStatement(sql4);
				ps06.setLong(1, datos.getIdpersona());
				ps06.setInt(2, 5);
				ResultSet rs06 = ps06.executeQuery();
				info("ejecucin de la sentencia sql4(3): "+ sql4);
				if (rs06.next()) {
					info("entra en la sentencia if");
					retorno.setcURP(rs06.getString(3));
					warn("datos enviados: CURP["+rs06.getString(3)+"]");
				}
				// verifica que se tenga un valor para infonavit
				debug("datos de entrada para sql7(3): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux007 = con.prepareStatement(sql7);
				psAux007.setLong(1, datos.getIdpersona());
				psAux007.setLong(2, 5);
				ResultSet rsAux007 = psAux007.executeQuery();
				info("ejecucin de la sentencia sql7(3): "+ sql7);

				// consulta la tabla piv11 para obetener INFONAVIT
				if (rsAux007.next()) {
					info("entra en la sentencia if");
					debug("datos de entrada para sql5(3): IDPERSONA["+datos.getIdpersona()+"]");
					PreparedStatement ps07 = con.prepareStatement(sql5);
					ps07.setLong(1, datos.getIdpersona());
					ps07.setInt(2, 5);
					ResultSet rs07 = ps07.executeQuery();
					info("ejecuciOn de la sentencia sql5(3): "+ sql5);
					rs07.next();
					retorno.setIdInfonavit(rs07.getInt(1));
					warn("datos enviados: INFONAVIT["+rs07.getInt(1)+"]");
				}

				// verifica que se tenga un valor para viajar
				debug("datos de entrada para sql7(4): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux008 = con.prepareStatement(sql7);
				psAux008.setLong(1, datos.getIdpersona());
				psAux008.setLong(2, 1);
				ResultSet rsAux008 = psAux008.executeQuery();
				info("ejecucin de la sentencia sql7(4): "+ sql7);

				// consulta la tabla piv11 para disponibilidad viajar
				if (rsAux008.next()) {
					info("entra en la sentencia if");
					debug("datos de entrada para sql5(4): IDPERSONA["+datos.getIdpersona()+"]");
					PreparedStatement ps08 = con.prepareStatement(sql5);
					ps08.setLong(1, datos.getIdpersona());
					ps08.setInt(2, 1);
					ResultSet rs08 = ps08.executeQuery();
					info("ejecuciOn de la sentencia sql5(4): "+ sql5);
					rs08.next();
					retorno.setIdDisponibilidadViajar(rs08.getInt(1));
					warn("datos enviados: DISPONIVILIDADVIAJAR["+rs08.getInt(1)+"]");
				}

				// verifica que se tenga un valor para cambio residencia
				debug("datos de entrada para sql7(5): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux009 = con.prepareStatement(sql7);
				psAux009.setLong(1, datos.getIdpersona());
				psAux009.setLong(2, 2);
				ResultSet rsAux009 = psAux009.executeQuery();
				info("ejecucin de la sentencia sql7(5): "+ sql7);

				// consulta la tabla piv11 para disponibilidad cambio residencia
				if (rsAux009.next()) {
					info("entra en la sentencia if");
					debug("datos de entrada para sql5(5): IDPERSONA["+datos.getIdpersona()+"]");
					PreparedStatement ps09 = con.prepareStatement(sql5);
					ps09.setLong(1, datos.getIdpersona());
					ps09.setInt(2, 2);
					ResultSet rs09 = ps09.executeQuery();
					info("ejecuciOn de la sentencia sql5(5): "+ sql5);
					rs09.next();
					retorno.setIdDisponibilidadCambio(rs09.getInt(1));
					warn("datos enviados: DISPONIBILIDADCAMBIO["+rs09.getInt(1)+"]");
				}
				// consulta la tabla piv3 para direccion
				debug("datos de entrada para sql6(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps10 = con.prepareStatement(sql6);
				ps10.setLong(1, datos.getIdpersona());
				ResultSet rs10 = ps10.executeQuery();
				info("ejecucin de la sentencia sql6(1): "+ sql6);
				if (rs10.next()) {
					retorno.setCalle(rs10.getString(13));
					retorno.setColonia(rs10.getString(14));
					retorno.setNumeroInterior(rs10.getString(15));
					retorno.setNumeroExterior(rs10.getString(16));
					retorno.setCodpost(rs10.getInt(17));
					retorno.setIdlocalidad(rs10.getInt(18));
					warn("datos enviados: CALLE["+rs10.getString(13)+"], COLONIA["+rs10.getString(14)+"], NUMEROINTERIOR["+rs10.getString(15)+"], NUMEROEXTERIOR["+rs10.getString(16)+"], CODIGOPOSTAL["+rs10.getInt(17)+"], IDLOCALIDAD["+rs10.getInt(18)+"]");
				}
				// consulta la tabla piv01 para obterner el telefono principal
				debug("datos de entrada para sql8(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps11 = con.prepareStatement(sql8);
				ps11.setLong(1, datos.getIdpersona());
				ps11.setInt(2, 1);
				ResultSet rs11 = ps11.executeQuery();
				info("ejecucin de la sentencia sql8(1): "+ sql8);
				if (rs11.next()) {
					retorno.setTelefonoPrincipal(rs11.getString(3));
					warn("datos enviados: TELEFONOPRINCIPAL["+rs11.getString(3)+"]");
				}else {
					warn("datos no existentes");
				}

				// consulta la tabla piv01 para obterner el telefono secundario
				debug("datos de entrada para sql8(2): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps12 = con.prepareStatement(sql8);
				ps12.setLong(1, datos.getIdpersona());
				ps12.setInt(2, 2);
				ResultSet rs12 = ps12.executeQuery();
				info("ejecucin de la sentencia sql8(2): "+ sql8);
				if (rs12.next()) {
					retorno.setTelefonoSecundario(rs12.getString(3));
					warn("datos enviados: TELEFONOSECUNDARIO["+rs12.getString(3)+"]");
				}else {
					warn("datos no existentes");
				}
				// consulta la tabla piv01 para obterner el telefono emergente
				debug("datos de entrada para sql8(3): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps13 = con.prepareStatement(sql8);
				ps13.setLong(1, datos.getIdpersona());
				ps13.setInt(2, 3);
				ResultSet rs13 = ps13.executeQuery();
				info("ejecucin de la sentencia sql8(3): "+ sql8);
				if (rs13.next()) {
					retorno.setTelefonoEmergencia(rs13.getString(3));
					warn("datos enviados: TELEFONOEMERGENCIA["+rs13.getString(3)+"]");
				}else {
					warn("datos no existentes");
				}

				// consulta la tabla piv02 para obterner el correo principal (vector)
				debug("datos de entrada para sql9(1): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps14 = con.prepareStatement(sql9);
				ps14.setLong(1, datos.getIdpersona());
				ps14.setInt(2, 4);
				ResultSet rs14 = ps14.executeQuery();
				info("ejecucin de la sentencia sql9(1): "+ sql9);
				debug("datos de entrada para sql9(2): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps15 = con.prepareStatement(sql9);
				ps15.setLong(1, datos.getIdpersona());
				ps15.setInt(2, 6);
				ResultSet rs15 = ps15.executeQuery();
				info("ejecucin de la sentencia sql9(2): "+ sql9);
				if (rs14.next()) {
					retorno.setCorreoPrincipal(rs14.getString(3) + "@ext.vectoritcgroup.com");
					warn("datos enviados: CORREOPRINCIPAL["+rs14.getString(3)+"]");
				} else if (rs15.next()) {
					retorno.setCorreoPrincipal(rs15.getString(3) + "@vectoritcgroup.com");
					warn("datos enviados: CORREOPRINCIPAL["+rs15.getString(3)+"]");
				}

				// consulta la tabla piv02 para obterner el correo secundario (personal)
				debug("datos de entrada para sql9(3): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps16 = con.prepareStatement(sql9);
				ps16.setLong(1, datos.getIdpersona());
				ps16.setInt(2, 1);
				ResultSet rs16 = ps16.executeQuery();
				if(rs16.next()) {
				info("ejecucin de la sentencia sql9(3): "+ sql9);
					retorno.setCorreoSecundario(rs16.getString(3));
					retorno.setIdCorreoSecundario(1);
					warn("datos enviados: CORREOsecundario["+rs16.getString(3)+"], IDCORREOSECUNDARIO["+1+"]");
				}else {
					warn("datos no existentes");
				}
				debug("datos de entrada para sql9(4): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps17 = con.prepareStatement(sql9);
				ps17.setLong(1, datos.getIdpersona());
				ps17.setInt(2, 2);
				ResultSet rs17 = ps17.executeQuery();
				if(rs17.next()) {
				info("ejecucin de la sentencia sql9(4): "+ sql9);

					retorno.setCorreoSecundario(rs17.getString(3));
					retorno.setIdCorreoSecundario(2);
					warn("datos enviados: CORREOSECUNDARIO["+rs17.getString(3)+"], IDCORREOSECUNDARIO["+2+"]");
			}else {
				warn("datos no existentes");
			}
				debug("datos de entrada para sql9(5): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps18 = con.prepareStatement(sql9);
				ps18.setLong(1, datos.getIdpersona());
				ps18.setInt(2, 3);
				ResultSet rs18 = ps18.executeQuery();
				if(rs18.next()) {
				info("ejecucin de la sentencia sql9(5): "+ sql9);

					retorno.setCorreoSecundario(rs18.getString(3));
					retorno.setIdCorreoSecundario(3);
					warn("datos enviados: CORRESECUNDARIO["+rs18.getString(3)+"], IDCORREOSECUNDARIO["+3+"]");
				}else {
					warn("datos no existentes");
				}
				debug("datos de entrada para sql9(6): IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps19 = con.prepareStatement(sql9);
				ps19.setLong(1, datos.getIdpersona());
				ps19.setInt(2, 5);
				ResultSet rs19 = ps19.executeQuery();
				if(rs19.next()) {
				info("ejecucin de la sentencia sql9(6): "+ sql9);

					retorno.setCorreoSecundario(rs19.getString(3));
					retorno.setIdCorreoSecundario(4);
					warn("datos enviados: CORREOSECUNDARIO["+rs19.getString(3)+"], IDCORREOSECUNDARIO["+5+"]");
				}else {
					warn("datos no existentes");
				}
				return ps01;
			}
		});
		return retorno;

	}


	/** 
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	public List<DatosPersonalesBean> Listar() {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		final String sql = "SELECT * FROM view_datospersonales2";
		info("ejecucion de la sentencia sql: "+sql);
		return jdbcTemplate.query(sql, new DatPerRowMapper());
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar(DatosPersonalesBean datos) {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		final String sql0 = "UPDATE TBLDETSPERSONAS SET  NOMBRE=(?), SEGNOMBRE =(?), APELLIDOP =(?), APELLIDOM=(?), SEXO=(?), FECHANAC=(?), IDEDOCIVIL=(?), NACIONALIDAD=(?) WHERE IDPERSONA=(?)";
		final String sql = "UPDATE TBLPERSONAS SET  URLFOTO=(?), RESUMEN =(?), OBJLABORAL =(?) WHERE IDPERSONA=(?) ";
		final String sql2 = "UPDATE TBLDIRECCIONES SET CODPOST=(?), CALLE=(?), COLONIA=(?), NUMINTERIOR=(?),NUMEXTERIOR=(?), IDLOCALIDAD=(?) WHERE IDDIRECCION=(?)";
		final String sql3 = "UPDATE TBLPIV03 SET IDDOC=(?),DESCRIPCION=(?),URLDOC=(?) WHERE IDPERSONA=(?) and IDDOC =(?)";
		// final String sql4 = "UPDATE TBLPIV11 SET IDOTROSDOC=(?) WHERE IDPERSONA=(?),
		// AND IDOTROSDOC=(?)";
		final String sql4 = "INSERT INTO TBLPIV11 VALUES(?,?)";
		final String sql04 = "DELETE TBLPIV11  WHERE IDPERSONA=(?) AND IDOTROSDOC=(?)";
		final String sql5 = "select * from tblpersonas where idpersona=(?)";

		// aux para la busqueda del id de direccion
		final String sqlaux = "select * from tbldirecciones dir, tbldetspersonas dts where dir.iddireccion = dts.iddireccion and dts.idpersona = (?)";
		// final String sqlAux2 ="select * from TBLDETSPERSONAS dtp where
		// dtp.idpersona=(?)";
		final String sqlAux3 = "SELECT * FROM TBLPIV11  WHERE IDPERSONA =(?) AND IDOTROSDOC=(?)";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// seleccion de busqueda de id de direccion
				debug("datos entrantes para el sqlaux: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux = con.prepareStatement(sqlaux);
				psAux.setLong(1, datos.getIdpersona());
				ResultSet rsAux = psAux.executeQuery();
				info("ejecucion de la sentencia sqlaux: "+sqlaux);
				rsAux.next();
				int idAux2 = Integer.parseInt(rsAux.getString(1));
				warn("datos enviados: IDDIRECCION["+idAux2+"]");
				
				if(idAux2 == 0) {
					info("no se encontraron datos");
				}else {
					debug("datos entrantes para el sql2: CODIGOPOSTAL[" + datos.getIdCodigoPostal() + "], CALLE["
							+ datos.getCalle() + "], COLONIA[" + datos.getColonia() + "NUMEROINTERIOR["
							+ datos.getNumeroInterior() + "], NUMEROEXTERIOR[" + datos.getNumeroExterior() + "], IDDIRECCCION["
							+ idAux2+ "], IDLOCALIDAD["+datos.getIdlocalidad()+"]");
				// segunda actualizacion tbldirecciones
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, datos.getIdCodigoPostal());
				ps2.setString(2, datos.getCalle());
				ps2.setString(3, datos.getColonia());
				ps2.setString(4, datos.getNumeroInterior());
				ps2.setString(5, datos.getNumeroExterior());
				ps2.setInt(6, datos.getIdlocalidad());
				ps2.setInt(7, idAux2);
				ResultSet rs2 = ps2.executeQuery();
//				rs2.next();
				info("ejecucion de la sentencia sql2: "+sql2);
				}
				
				// cero actualizada tabla detalle persona
				PreparedStatement ps0 = con.prepareStatement(sql0);
				debug("datos entrantes para el sql0: NOMBRE[" + datos.getPrimerNombre()
						+ "], SEGUNDONOMBRE[" + datos.getSegundoNombre() + "], APELLIDOPATERNO[" + datos.getApellidPterno()
						+ "], APELLIDOMATERNO[" + datos.getApellidMaterno() + "], SEXO[" + datos.getIdSexo() + "], FECHANACIMIENTO["
						+ datos.getFechaNacimiento() + "], IDESTADOCIVIL[" + datos.getIdEdoCivil() + "], NACIONALIDAD["
						+ datos.getNacionalidad() + "], IDPERSONA[" + datos.getIdpersona() + "]");
				ps0.setString(1, datos.getPrimerNombre());
				ps0.setString(2, datos.getSegundoNombre());
				ps0.setString(3, datos.getApellidPterno());
				ps0.setString(4, datos.getApellidMaterno());
				ps0.setString(5, datos.getIdSexo());
				ps0.setString(6, datos.getFechaNacimiento());
				ps0.setInt(7, datos.getIdEdoCivil());
				ps0.setString(8, datos.getNacionalidad());
				ps0.setLong(9, datos.getIdpersona());
				ResultSet rs0 = ps0.executeQuery();
				info("ejecucion de la sentencia sql0: "+sql0);
				if (rs0.next()) {

				}

				// primera Actualizacion TBLPersonas
				PreparedStatement ps = con.prepareStatement(sql);
				debug("datos de entrada para sql: URLFOTO[" + datos.getUrlFoto() + "], RESUMEN["
						+ datos.getResumen() + "], OBJETIVOLABORAL[" + datos.getObjetivoLaboral() + "], IDPERSONA["
						+ datos.getIdpersona() + "]");
				ps.setString(1, datos.getUrlFoto());
				ps.setString(2, datos.getResumen());
				ps.setString(3, datos.getObjetivoLaboral());
				ps.setLong(4, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				info("ejecucion de la sentencia sql: "+sql);
				if (rs.next()) {
					
				}

				// tercera actualizacion piv_03 --acta de nacimiento--
				PreparedStatement ps3 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: FECHANACIMIENTO["+datos.getFechaNacimiento()+"], URLFECHANACIMIENTO["+datos.getUrlFechaNacimiento()+"],IDPERSONA["+datos.getIdpersona()+"]");
				ps3.setInt(1, 1);
				ps3.setString(2, datos.getFechaNacimiento());
				ps3.setString(3, datos.getUrlFechaNacimiento());
				ps3.setLong(4, datos.getIdpersona());
				ps3.setInt(5, 1);
				ResultSet rs3 = ps3.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				if (rs3.next()) {
					info("entra en sentencia if");
				}

				// cuarta actualizacion piv_03 --RFC--
				PreparedStatement ps4 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: RFC["+datos.getRfc()+"], URLRFC["+datos.getUrlRfc()+"],IDPERSONA["+datos.getIdpersona()+"]");
				ps4.setInt(1, 2);
				ps4.setString(2, datos.getRfc());
				ps4.setString(3, datos.getUrlRfc());
				ps4.setLong(4, datos.getIdpersona());
				ps4.setInt(5, 2);
				ResultSet rs4 = ps4.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				if (rs4.next()) {
					info("entra en sentencia if");
				}

				// quinta actualizacion piv_03 --CURP--
				PreparedStatement ps5 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: CURP["+datos.getcURP()+"], URLCURP["+datos.getUrlcURP()+"],IDPERSONA["+datos.getIdpersona()+"]");
				ps5.setLong(1, 4);
				ps5.setString(2, datos.getcURP());
				ps5.setString(3, datos.getUrlcURP());
				ps5.setLong(4, datos.getIdpersona());
				ps5.setInt(5, 4);
				ResultSet rs5 = ps5.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				if (rs5.next()) {
					info("entra en sentencia if");
				}

				// seleccion para saber si hay valor en piv11 de id=3
				PreparedStatement psAux3 = con.prepareStatement(sqlAux3);
				debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
				psAux3.setLong(1, datos.getIdpersona());
				psAux3.setLong(2, 3);
				ResultSet rsAux3 = psAux3.executeQuery();
				info("ejecucion de la sentencia sqlaux3: "+sqlAux3);
				// sexta actualizacion piv11 --otrs Documentos -- pasaporte
				if (datos.getIdpasaporte() != 0) {
					if (rsAux3.next()) {
						info("entra en sentencia if");
					} else {
						PreparedStatement ps6 = con.prepareStatement(sql4);
						debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
						ps6.setInt(1, 3);
						ps6.setInt(2, datos.getIdpersona());
						ResultSet rs6 = ps6.executeQuery();
						info("ejecucion de la sentencia sqlaux4: "+sql4);
						rs6.next();
					}
				} else {
					PreparedStatement ps6 = con.prepareStatement(sql04);
					debug("datos entrantes para el sql04: IDPERSONA["+datos.getIdpersona()+"]");
					ps6.setInt(1, 3);
					ps6.setLong(2, datos.getIdpersona());
					ResultSet rs6 = ps6.executeQuery();
					info("ejecucion de la sentencia sql04: "+sql04);
					rs6.next();
				}

				// seleccion para saber si hay valor en piv11 de id=4
				PreparedStatement psAux4 = con.prepareStatement(sqlAux3);
				debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
				psAux4.setLong(1, datos.getIdpersona());
				psAux4.setLong(2, 4);
				ResultSet rsAux4 = psAux4.executeQuery();
				info("ejecucion de la sentencia sqlaux3: "+sqlAux3);
				// septima actualizacion piv11 --otrs Documentos -- visa
				if (datos.getIdpasaporte() != 0) {
					if (rsAux4.next()) {
						info("entra en sentencia if");
					} else {
						PreparedStatement ps7 = con.prepareStatement(sql4);
						debug("datos entrantes para el sql4: IDPERSONA["+datos.getIdpersona()+"]");
						ps7.setInt(1, 4);
						ps7.setLong(2, datos.getIdpersona());
						ResultSet rs7 = ps7.executeQuery();
						info("ejecucion de la sentencia sql4: "+sql4);
						rs7.next();
					}
				} else {
					PreparedStatement ps7 = con.prepareStatement(sql04);
					debug("datos entrantes para el sql04: IDPERSONA["+datos.getIdpersona()+"]");
					ps7.setInt(1, 4);
					ps7.setLong(2, datos.getIdpersona());
					ResultSet rs7 = ps7.executeQuery();
					info("ejecucion de la sentencia sql04: "+sql04);
					rs7.next();
				}

				// octava actualizacion piv03 --Documentos -- seguro social
				PreparedStatement ps8 = con.prepareStatement(sql3);
				debug("datos entrantes para el sql3: IDPERSONA["+datos.getIdpersona()+"], NSS["+datos.getSeguroSocial()+"], URLNSS["+datos.getUrlSeguroSocial()+"]");
				ps8.setLong(1, 5);
				ps8.setString(2, datos.getSeguroSocial());
				ps8.setString(3, datos.getUrlSeguroSocial());
				ps8.setLong(4, datos.getIdpersona());
				ps8.setLong(5, 5);
				ResultSet rs8 = ps8.executeQuery();
				info("ejecucion de la sentencia sql3: "+sql3);
				if (rs8.next()) {
					info("entra en la sentencia if");
				}

				// seleccion para saber si hay valor en piv11 de id=5
				PreparedStatement psAux5 = con.prepareStatement(sqlAux3);
				debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
				psAux5.setLong(1, datos.getIdpersona());
				psAux5.setLong(2, 5);
				ResultSet rsAux5 = psAux5.executeQuery();
				info("ejecucion de la sentencia sqlaux3: "+sqlAux3);
				// novena actualizacion piv03 --Documentos -- infonavit
				if (datos.getIdpasaporte() != 0) {
					if (rsAux5.next()) {
						info("entra en sentencia if");
					} else {
						PreparedStatement ps9 = con.prepareStatement(sql4);
						debug("datos entrantes para el sql4: IDPERSONA["+datos.getIdpersona()+"]");
						ps9.setInt(1, 5);
						ps9.setLong(2, datos.getIdpersona());
						ResultSet rs9 = ps9.executeQuery();
						info("ejecucion de la sentencia sql4: "+sql4);
						rs9.next();
					}
				} else {
					PreparedStatement ps9 = con.prepareStatement(sql04);
					debug("datos entrantes para el sql04: IDPERSONA["+datos.getIdpersona()+"]");
					ps9.setInt(1, 5);
					ps9.setLong(2, datos.getIdpersona());
					ResultSet rs9 = ps9.executeQuery();
					info("ejecucion de la sentencia sql04: "+sql04);
					rs9.next();
				}

				// seleccion para saber si hay valor en piv11 de id=1
				PreparedStatement psAux6 = con.prepareStatement(sqlAux3);
				debug("datos entrantes para el sqlqaux3: IDPERSONA["+datos.getIdpersona()+"]");
				psAux6.setLong(1, datos.getIdpersona());
				psAux6.setLong(2, 1);
				ResultSet rsAux6 = psAux6.executeQuery();
				info("ejecucion de la sentencia sqlaux3: "+sqlAux3);
				// Decima actualizacion -- Otros Documentos -- disponibilidad de viajar
				if (datos.getIdpasaporte() != 0) {
					if (rsAux6.next()) {
						info("entra en sentencia if");
					} else {
						PreparedStatement ps10 = con.prepareStatement(sql4);
						debug("datos entrantes para el sql4: IDPERSONA["+datos.getIdpersona()+"]");
						ps10.setInt(1, 1);
						ps10.setLong(2, datos.getIdpersona());
						ResultSet rs10 = ps10.executeQuery();
						info("ejecucion de la sentencia sql4: "+sql4);
						rs10.next();
					}
				} else {
					PreparedStatement ps10 = con.prepareStatement(sql04);
					debug("datos entrantes para el sql04: IDPERSONA["+datos.getIdpersona()+"]");
					ps10.setInt(1, 1);
					ps10.setLong(2, datos.getIdpersona());
					ResultSet rs6 = ps10.executeQuery();
					info("ejecucion de la sentencia sql04: "+sql04);
					rs6.next();
				}

				// seleccion para saber si hay valor en piv11 de id=2
				PreparedStatement psAux7 = con.prepareStatement(sqlAux3);
				debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
				psAux7.setLong(1, datos.getIdpersona());
				psAux7.setLong(2, 2);
				ResultSet rsAux7 = psAux7.executeQuery();
				info("ejecucion de la sentencia sqlaux3: "+sqlAux3);
				// onceava actualizacion -- Otros Documentos -- disponibilidad de cambio de
				// residencia
				if (datos.getIdpasaporte() != 0) {
					if (rsAux7.next()) {
						info("entra en sentencia if");
					} else {
						PreparedStatement ps11 = con.prepareStatement(sql4);
						debug("datos entrantes para el sql4: IDPERSONA["+datos.getIdpersona()+"]");
						ps11.setInt(1, 2);
						ps11.setLong(2, datos.getIdpersona());
						ResultSet rs11 = ps11.executeQuery();
						info("ejecucion de la sentencia sql4: "+sql4);
						rs11.next();
					}
				} else {
					PreparedStatement ps11 = con.prepareStatement(sql04);
					debug("datos entrantes para el sql04: IDPERSONA["+datos.getIdpersona()+"]");
					ps11.setInt(1, 2);
					ps11.setLong(2, datos.getIdpersona());
					ResultSet rs11 = ps11.executeQuery();
					info("ejecucion de la sentencia sql04: "+sql04);
					rs11.next();
				}
				// si existe la persona se ejecuta el update
				PreparedStatement ps12 = con.prepareStatement(sql5);
				info("datos entrantes para slq5: IDPERSONA[" + datos.getIdpersona()+"]");
				ps12.setLong(1, datos.getIdpersona());
				info("ejecucion de la sentencia sql5: "+sql5);
				return ps12;

			}
		});
		warn("datos enviado: RESPUESTA["+respuesta+"]");
		return respuesta;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar2(DatosPersonalesBean datos) {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		final String sql0 = "UPDATE TBLDETSPERSONAS SET  NOMBRE=(?), SEGNOMBRE =(?), APELLIDOP =(?), APELLIDOM=(?), SEXO=(?), FECHANAC=(?), IDEDOCIVIL=(?), NACIONALIDAD=(?) WHERE IDPERSONA=(?)";
		final String sql = "UPDATE TBLPERSONAS SET  URLFOTO=(?), RESUMEN =(?), OBJLABORAL =(?) WHERE IDPERSONA=(?) ";
		final String sql1 = "UPDATE TBLDIRECCIONES SET CALLE =(?), COLONIA=(?), NUMINTERIOR=(?), NUMEXTERIOR=(?), CODPOST=(?), IDLOCALIDAD=(?) WHERE IDDIRECCION =(?)";
		final String sql2 = "UPDATE TBLPIV01 SET TELEFONO=(?) WHERE IDTIPOTELEFONO=(?) AND IDPERSONA =(?)";
		final String sql3 = "UPDATE TBLPIV02 SET CORREO=(?), IDTIPOCORREO=(?) WHERE IDPERSONA=(?) AND IDTIPOCORREO=(?)";
		final String sql4 = "INSERT INTO TBLPIV01 VALUES (?,?,?)";
		final String sql5 = "INSERT INTO TBLPIV02 VALUES (?,?,?)";
		final String sql6 = "select * from tbldetspersonas where idpersona=(?)";

		// aux para la busqueda del id de direccion
		final String sqlaux = "select * from tbldirecciones dir, tbldetspersonas dts where dir.iddireccion = dts.iddireccion and dts.idpersona = (?)";
		// aux para la busqueda del telefono
		final String sqlaux3 = "select * from tblpiv01 where idtipotelefono=(?) and idpersona=(?)";
		// aux para la busqueda del correo
		final String sqlaux4 = "select * from tblpiv02 where idpersona=(?)";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				// cero actualizada tabla detalle persona
				debug("datos entrantes para el sql0: NOMBRE[" + datos.getPrimerNombre()
				+ "], SEGUNDONOMBRE[" + datos.getSegundoNombre() + "], APELLIDOPATERNO[" + datos.getApellidPterno()
				+ "], APELLIDOMATERNO[" + datos.getApellidMaterno() + "], SEXO[" + datos.getIdSexo() + "], FECHANACIMIENTO["
				+ datos.getFechaNacimiento() + "], IDESTADOCIVIL[" + datos.getIdEdoCivil() + "], NACIONALIDAD["
				+ datos.getNacionalidad() + "], IDPERSONA[" + datos.getIdpersona() + "]");
				PreparedStatement ps0 = con.prepareStatement(sql0);
				ps0.setString(1, datos.getPrimerNombre());
				ps0.setString(2, datos.getSegundoNombre());
				ps0.setString(3, datos.getApellidPterno());
				ps0.setString(4, datos.getApellidMaterno());
				ps0.setString(5, datos.getIdSexo());
				ps0.setString(6, datos.getFechaNacimiento());
				ps0.setInt(7, datos.getIdEdoCivil());
				ps0.setString(8, datos.getNacionalidad());
				ps0.setInt(9, datos.getIdpersona());
				ResultSet rs0 = ps0.executeQuery();
				info("ejecucion de la sentencia sql0: "+sql0);
				rs0.next();
				
				// primera Actualizacion TBLPersonas
				PreparedStatement ps = con.prepareStatement(sql);
				debug("datos de entrada para sql: URLFOTO[" + datos.getUrlFoto() + "], RESUMEN["
						+ datos.getResumen() + "], OBJETIVOLABORAL[" + datos.getObjetivoLaboral() + "], IDPERSONA["
						+ datos.getIdpersona() + "]");
				ps.setString(1, datos.getUrlFoto());
				ps.setString(2, datos.getResumen());
				ps.setString(3, datos.getObjetivoLaboral());
				ps.setLong(4, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				info("ejecucion de la sentencia sql: " + sql);
				rs.next();
				
				// seleccion de busqueda de id de direccion
				debug("datos entrantes para el sqlaux: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux = con.prepareStatement(sqlaux);
				psAux.setLong(1, datos.getIdpersona());
				ResultSet rsAux = psAux.executeQuery();
				info("ejecucion de la sentencia sqlaux: " + sqlaux);
				rsAux.next();
				int idAux2 = Integer.parseInt(rsAux.getString(1));
				warn("datos enviados: IDDIRECCION[" + idAux2+"]" );
				if (rsAux.next()) {
					info("entra en la sentencia if");
					// actualizacion en direccion
					debug("datos entrantes para el sql2: CODIGOPOSTAL[" + datos.getCodpost() + "], CALLE["
							+ datos.getCalle() + "], COLONIA[" + datos.getColonia() + "NUMEROINTERIOR["
							+ datos.getNumeroInterior() + "], NUMEROEXTERIOR[" + datos.getNumeroExterior() + "], IDDIRECCCION["
							+ idAux2+ "]");
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setString(1, datos.getCalle());
					ps1.setString(2, datos.getColonia());
					ps1.setString(3, datos.getNumeroInterior());
					ps1.setString(4, datos.getNumeroExterior());
					ps1.setInt(5, datos.getIdCodigoPostal());
					ps1.setInt(6, datos.getIdlocalidad());
					ps1.setLong(7, idAux2);
					ResultSet rs1 = ps1.executeQuery();
					info("ejecucion de la sentencia sql1: " + sql1);
					rs1.next();
				}
				debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
				// seleccion para saber si hay valor en piv01 por telefono
				PreparedStatement psAux5 = con.prepareStatement(sqlaux3);
				psAux5.setInt(1, 1);
				psAux5.setInt(2, datos.getIdpersona());
				ResultSet rsAux5 = psAux5.executeQuery();
				info("ejecucion de la sentencia sqlaux3: " + sqlaux3);
				rsAux5.next();
				String cdaux5 = (rsAux5.getString(3));
				warn("datos enviados: TELEFONOANTIGUO[" + cdaux5+"]" );
				// sentencia if para agregar o actualizar segun se cumpla la condicion
				// busca si el registro existe o no
				//System.err.println("telefono principal --> "+datos.getTelefonoprincipalNw());
				if (!datos.getTelefonoprincipalNw().equals(" ")) {
					if (rsAux5.next()) {
						info("entra a la sentecia if");
						// si encuentra algo actualizacion en la pivote 1 para telefono principal
						info("datos entrantes para sql2: TELEFONONW[" + datos.getTelefonoprincipalNw() + "], IDPERSONA["
								+ datos.getIdpersona() + "]");
						PreparedStatement ps2 = con.prepareStatement(sql2);
						ps2.setString(1, datos.getTelefonoprincipalNw());
						ps2.setInt(2, 1);
						ps2.setInt(3, datos.getIdpersona());
						ResultSet rs2 = ps2.executeQuery();
						info("ejecucion de la sentencia sql2: " + sql2);
						rs2.next();
						
					} else {
						info("entra en la sentecia else");
						// sino se encuentra que ingrese nuevo registro para telefono proncipal
						info("datos entrantes para sql4: TELEFONONW[" + datos.getTelefonoprincipalNw() + "], IDPERSONA[" + datos.getIdpersona() + "]");
						PreparedStatement ps9 = con.prepareStatement(sql4);
						ps9.setInt(1, datos.getIdpersona());
						ps9.setLong(2, 1);
						ps9.setString(3, datos.getTelefonoprincipalNw());
						ResultSet rs9 = ps9.executeQuery();
						info("ejecucion de la sentencia sql4: " + sql4);
						rs9.next();
						
					}
				} else {
					info("datos vacio");
				}
				debug("datos entrantes para el sqlaux3(1): IDPERSONA["+datos.getIdpersona()+"]");
				// seleccion para saber si hay valor en piv01 por telefono
				PreparedStatement psAux6 = con.prepareStatement(sqlaux3);
				psAux6.setInt(1, 2);
				psAux6.setInt(2, datos.getIdpersona());
				ResultSet rsAux6 = psAux6.executeQuery();
				info("ejecucion de la sentencia sqlaux3(1): " + sqlaux3);
				rsAux6.next();
				String cdaux6 = (rsAux6.getString(3));
				warn("datos enviados:  TELEFONOANTIGUO[" + cdaux6+"]");
				// sentencia if para agregar o actualizar segun se cumpla la condicion
				// busca si el registro existe o no
				if (!datos.getTelefonosecundarioNw().equals(" ")) {
					if (rsAux6.next()) {

						info("entra en la sentencia if 1");
						// si encuentra algo actualizacion en la pivote 1 para telefono secundario
						debug("datos entrantes para sql2(1): TELEFONOSECUNDARIONW["+datos.getTelefonosecundarioNw()+"], IDPERSONA["+datos.getIdpersona()+"]");
						PreparedStatement ps3 = con.prepareStatement(sql2);
						ps3.setString(1, datos.getTelefonosecundarioNw());
						ps3.setInt(2, 2);
						ps3.setInt(3, datos.getIdpersona());
						ResultSet rs3 = ps3.executeQuery();
						info("ejecucion de la sentencia sql2(1): " + sql2);
						rs3.next();
				
					} else {
						info("entrando en sentencia else (1)");
						// sino se encuentra que ingrese nuevo registro para telefono secundario
						debug("datos entrantes para sql4(1): TELEFONOSECUNDARIONW["+datos.getTelefonosecundarioNw()+"], IDPERSONA["+datos.getIdpersona()+"]");
						PreparedStatement ps10 = con.prepareStatement(sql4);
						ps10.setInt(1, datos.getIdpersona());
						ps10.setLong(2, 2);
						ps10.setString(3, datos.getTelefonosecundarioNw());
						ResultSet rs10 = ps10.executeQuery();
						info("ejecucion de la sentencia sql4(1): " + sql4);
						rs10.next();

					}
				} else {
					info("datos vacio");
				}

				// seleccion para saber si hay valor en piv01 por telefono
				debug("datos entrantes para el sqlaux3: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux7 = con.prepareStatement(sqlaux3);
				psAux7.setInt(1, 3);
				psAux7.setInt(2, datos.getIdpersona());
				ResultSet rsAux7 = psAux7.executeQuery();
				info("ejecucion de la sentencia sqlaux3: " + sqlaux3);
				rsAux7.next();
				String cdaux7 = (rsAux7.getString(3));
				info("datos enviados: TELEFONOANTIGUO[" + cdaux7+"]");
				// sentencia if para agregar o actualizar segun se cumpla la condicion
				// busca si el registro existe o no
				if (!datos.getTelefonoEmergenteNw().equals(" ")) {
					if (rsAux7.next()) {
						info("entra en sentencia if");
						// si encuentra algo actualizacion en la pivote 1 para telefono emergencia
						debug("datos entrantes para sql2: TELEFONOEMERGENCIANW["+datos.getTelefonoEmergenteNw()+"], IDPERSONA["+datos.getIdpersona()+"]");
						PreparedStatement ps4 = con.prepareStatement(sql2);
						ps4.setString(1, datos.getTelefonoEmergenteNw());
						ps4.setInt(2, 3);
						ps4.setInt(3, datos.getIdpersona());
				
						ResultSet rs4 = ps4.executeQuery();
						info("ejecucion de la sentencia sql2: " + sql2);
						rs4.next();

					} else {
						// sino se encuentra que ingrese nuevo registro para telefono emergencia
						debug("datos entrantes para sql4: TELEFONOSECUNDARIONW["+datos.getTelefonoEmergenteNw()+"], IDPERSONA["+datos.getIdpersona()+"]");
						PreparedStatement ps11 = con.prepareStatement(sql4);
						ps11.setInt(1, datos.getIdpersona());
						ps11.setLong(2, 3);
						ps11.setString(3, datos.getTelefonoEmergenteNw());
						ResultSet rs11 = ps11.executeQuery();
						info("ejecucion de la sentencia sql4: " + sql4);
						rs11.next();
					}
				} else {
					info("dato vacio");
				}

				// actualizacion en la pivote 2
				debug("datos entrantes para el sqlaux4: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement psAux9 = con.prepareStatement(sqlaux4);
				psAux9.setInt(1, datos.getIdCorreoSecundario());
				psAux9.setInt(1, datos.getIdpersona());
				ResultSet rsAux9 = psAux9.executeQuery();
				info("ejecucion de la sentencia sqlaux4: " + sqlaux4);
				rsAux9.next();
				int cdaux10 = (rsAux9.getInt(2));
				warn("datos enviados: IDCORREOSECUNDARIOVIEJO["+cdaux10+"]");
				
				
				
				// sentencia if para agregar o actualizar segun se cumpla la condicion
				// busca si el registro existe o no
				if (!datos.getCorresecundarioNw().equals(" ")) {
					if (rsAux9.next()) {
						info("entrando en la sentencia if");
						// si encuentra algo actualizacion en la pivote 2 para correo secundario
						debug("datos entrantes para sql3: CORREOSECUNDARIONW["+ datos.getCorreoprincipalNw()+"], IDPERSONA["+ datos.getIdpersona()+"], IDCORREOSECUNDARIOVIEJO"+cdaux10+"], IDTIPOCORREONw["+datos.getIdCorreoSecundario()+"]");
						PreparedStatement ps17 = con.prepareStatement(sql3);
						ps17.setString(1, datos.getCorresecundarioNw());
						ps17.setInt(2, datos.getIdCorreoSecundario());
						ps17.setInt(3, datos.getIdpersona());
						ps17.setInt(4, cdaux10);
						ResultSet rs17 = ps17.executeQuery();
						info("ejecucion de la sentencia sql3: " + sql3);
						rs17.next();
					} else {
						info("entrando a la sentencia else");
						// sino se encuentra que ingrese nuevo registro para correo secundario
						debug("datos entrantes para sql3: CORREOSECUNDARIONW["+ datos.getCorresecundarioNw()+"], IDPERSONA["+ datos.getIdpersona()+"], IDTIPOCORREO["+datos.getIdCorreoSecundario()+"]");
						PreparedStatement ps18 = con.prepareStatement(sql5);
						ps18.setInt(1, datos.getIdpersona());
						ps18.setLong(2, datos.getIdCorreoSecundario());
						ps18.setString(3, datos.getCorresecundarioNw());
						ResultSet rs18 = ps18.executeQuery();
						info("ejecucion de la sentencia sql5: " + sql5);
						rs18.next();
					}
				} else {
					info("dato vacio");
				}
				// System.out.println();
				
				debug("datos entrantes para el sql6: IDPERSONA["+datos.getIdpersona()+"]");
				PreparedStatement ps20 = con.prepareStatement(sql6);
				ps20.setLong(1, datos.getIdpersona());
				info("ejecucion de la sentencia sql6: " + sql6);
				return ps20;
			}

		});
		warn("dato enviado: RESPUESTA["+respuesta+"]");
		return respuesta;

	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public int Modificar3(DatosPersonalesBean datos) {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		final String sql = "UPDATE TBLPERSONAS SET  IDAREA=(?), SUELDO =(?) WHERE IDPERSONA=(?) ";
		
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				// primera Actualizacion TBLPersonas
				PreparedStatement ps = con.prepareStatement(sql);
				debug("datos entrantes para sql: IDPERSONA[" + datos.getIdpersona() + "], IDAREA["
						+ datos.getIdarea() + "], SUELDO[" + datos.getSueldo()+"]");
				ps.setInt(1, datos.getIdarea());
				ps.setInt(2, datos.getSueldo());
				ps.setLong(3, datos.getIdpersona());
				info("ejecucion de la sentencia sql: " + sql);
				return ps;

			}
		});
		warn("dato enviado: RESPUESTA["+respuesta+"]");
		return respuesta;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatosPersonalesBean> BusquedaEstudiosPersona(long id) {
		info("se mando a llamar este metodo");
		ConvertirFecha converter = new ConvertirFecha();
		c = Calendar.getInstance();
		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH)+1);
		annio = Integer.toString(c.get(Calendar.YEAR));
		// TODO Auto-generated method stub
	
		/** Sentencias SQL */
		// String prueba="midrench";
		final String sql = "select * from view_estudiosp where idp ='" + id + "'";
		info("ejecucion de la sentencia sql: " + sql);
		/** Consulta a la BD */
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		/** Inicializacion del Objeto para Retornar */
		DatosPersonalesBean barea;
		List<DatosPersonalesBean> listara = new ArrayList<DatosPersonalesBean>();
		info("entrando al ciclo for");
		/** Estableciendo valores obtenidos de la BD */
		for (Map<String, Object> row : rows) {
			barea = new DatosPersonalesBean();
			barea.setLocalidad((String) row.get("LOCALIDAD"));
			barea.setPeinicial(converter.converter((String) row.get("PEINICIAL").toString()));
			if (row.get("PEFINAL") == null) {
				info("entra en la sentencia if");
				barea.setPefinal(dia + "/" + mes + "/" + annio);
			} else {
				info("entran en la sentencia else");
				barea.setPefinal(converter.converter((String) row.get("PEFINAL").toString()));
			}
			barea.setInstituto((String) row.get("INSTITUTO"));
			barea.setNombrecarrera((String) row.get("NOMCARRERA"));
			if (row.get("DESCRIPCIONHERRA") == null) {
				info("entra en la sentencia if");
				barea.setDescripcionherra("No tiene conocimiento en ninguna herramienta");
			} else {
				info("entran en la sentencia else");
				barea.setDescripcionherra((String) row.get("DESCRIPCIONHERRA"));
			}			
			listara.add(barea);
		}
		warn("datos enviados: "+ listara.toString());
		return listara;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaPersonaNombreCompleto(String parametro) {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		Object parm;
		String sql = "";
		info("entra en el try");
		try {
			parm = Integer.parseInt(parametro);
			info("es Numero");
			sql = "select * from view_datospersonales2 where EDAD=" + parm + " order by apellidopaterno ASC";
		} catch (NumberFormatException e) {
			info("entra en el catch");
			info("es Cadena");
			sql = "select * from view_datospersonales2 where NOMBREPERSONA like '%" + parametro
					+ "%' or SEGUNDONOMBRE like '%" + parametro + "%' or APELLIDOPATERNO like '%" + parametro
					+ "%' or APELLIDOMATERNO like '%" + parametro + "%' or SEXO = '" + parametro + "' or NOMBREAREA = '"
					+ parametro + "' order by apellidopaterno ASC";
		}
		info("ejecucion de la sentencia sql: "+sql);
		List<DatosPersonalesBean> retorno = new ArrayList<DatosPersonalesBean>();
		DatosPersonalesBean datos;
		List<Map<String, Object>> ConsultaBD = jdbcTemplate.queryForList(sql);
		info("entra en el ciclo for");
		for (Map<String, Object> row : ConsultaBD) {
			datos = new DatosPersonalesBean();
			datos.setIdpersona(Integer.parseInt(row.get("IDP").toString()));
			if (row.get("IDU") == null) {
				info("entra en la sentencia if");
				datos.setIduser(0);
			} else {
				info("entran en la sentencia else");
				datos.setIduser(Integer.parseInt(row.get("IDU").toString()));
			}
			datos.setPrimerNombre((String) row.get("NOMBREPERSONA"));
			datos.setSegundoNombre((String) row.get("SEGUNDONOMBRE"));
			datos.setApellidPterno((String) row.get("APELLIDOPATERNO"));
			datos.setApellidMaterno((String) row.get("APELLIDOMATERNO"));
			datos.setIdSexo((String) row.get("SEXO"));
			datos.setEdad(Integer.parseInt(row.get("EDAD").toString()));
			datos.setSueldo(Integer.parseInt(row.get("SUELDO").toString()));
			datos.setStatus((String) row.get("STATUS"));
			datos.setNombreArea((String) row.get("NOMBREAREA"));
			datos.setUrlFoto((String) row.get("URLFOTO"));
			retorno.add(datos);
		}
		warn("datos enviados: "+ retorno.toString());
		return retorno;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaHerramientasConPersona(long id) {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		
		/** Sentencias SQL */
		// String prueba="midrench";
		final String sql = "select * from view_herramientascon where idp ='" + id + "'";
		info("ejecucion de la sentencia sql " + sql);
		/** Consulta a la BD */
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		/** Inicializacion del Objeto para Retornar */
		DatosPersonalesBean barea;
		List<DatosPersonalesBean> listara = new ArrayList<DatosPersonalesBean>();

		/** Estableciendo valores obtenidos de la BD */
		info("entra en el ciclo for");
		for (Map<String, Object> row : rows) {
			barea = new DatosPersonalesBean();
			if (row.get("DESCRIPCIONHERRA") == null) {
				info("entra en la sentencia if");
				barea.setDescripcionherra("No tiene conocimiento en ninguna herramienta");
			} else {
				info("entra en la sentencia else");
				barea.setDescripcionherra((String) row.get("DESCRIPCIONHERRA"));
			}
			if (row.get("NOMHERRAMIENTA") == null) {
				info("entra en la sentencia if");
				barea.setNombreherramienta("No tiene conocimiento en ninguna herramienta");
			} else {
				info("entra en la sentencia else");
				barea.setNombreherramienta((String) row.get("NOMHERRAMIENTA"));
			}			
			listara.add(barea);
		}
		warn("datos enviados: "+listara.toString());
		return listara;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaExpLaboralPersona(long id) {
		info("se mando a llamar este metodo");
		ConvertirFecha converter = new ConvertirFecha();
		c = Calendar.getInstance();
		dia = Integer.toString(c.get(Calendar.DATE));
		mes = Integer.toString(c.get(Calendar.MONTH)+1);
		annio = Integer.toString(c.get(Calendar.YEAR));
		// TODO Auto-generated method stub
		
		/** Sentencias SQL */
		// String prueba="midrench";
		final String sql = "select * from view_exlabp where idp ='" + id + "'";
		info("ejecucion de la sentencia sql: " + sql);
		/** Consulta a la BD */
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		/** Inicializacion del Objeto para Retornar */
		DatosPersonalesBean barea;
		List<DatosPersonalesBean> listara = new ArrayList<DatosPersonalesBean>();

		/** Estableciendo valores obtenidos de la BD */
		info("entra en el ciclo for");
		for (Map<String, Object> row : rows) {
			barea = new DatosPersonalesBean();

			if (row.get("DESCRIPCIONHERRA") == null) {
				info("entra en la sentencia if");
				barea.setDescripcionherra("No tiene conocimiento en ninguna herramienta");
			} else {
				info("entra en la sentencia else");
				barea.setDescripcionherra((String) row.get("DESCRIPCIONHERRA"));
			}
			if (row.get("NOMHERRAMIENTA") == null) {
				info("entra en la sentencia if");
				barea.setNombreherramienta("No tiene conocimiento en ninguna herramienta");
			} else {
				info("entra en la sentencia else");
				barea.setNombreherramienta((String) row.get("NOMHERRAMIENTA"));
			}			
			barea.setFinicial(converter.converter((String) row.get("FINICIAL").toString()));
			if (row.get("FFINAL") == null) {
				info("entra en la sentencia if");
				barea.setFfinal(dia + "/" + mes + "/" + annio);
			} else {
				info("entra en la sentencia else");
				barea.setFfinal(converter.converter((String) row.get("FFINAL").toString()));
			}
			if (row.get("NOMBREEMPRESA") == null) {
				info("entra en la sentencia if");
				barea.setNombreempresa("");
			} else {
				info("entra en la sentencia else");
				barea.setNombreempresa((String) row.get("NOMBREEMPRESA"));
			}
			if (row.get("ACTIVIDADES") == null) {
				info("entra en la sentencia if");
				barea.setActividades("");
			} else {
				info("entra en la sentencia else");
				barea.setActividades((String) row.get("ACTIVIDADES"));
			}
			
			listara.add(barea);
		}
		warn("datos enviados: "+listara.toString());
		return listara;
	}


	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<DatosPersonalesBean> BusquedaIdiomasPersona(long id) {
		info("se mando a llamar este metodo");
		// TODO Auto-generated method stub
		info("Busqueda el CV de la persona con ID " + id);
		/** Sentencias SQL */
		// String prueba="midrench";
		final String sql = "select * from view_idiomasp where idp ='" + id + "'";
		info("ejecucion de la sentencia sql: " + sql);
		/** Consulta a la BD */
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		/** Inicializacion del Objeto para Retornar */
		DatosPersonalesBean barea;
		List<DatosPersonalesBean> listara = new ArrayList<DatosPersonalesBean>();

		/** Estableciendo valores obtenidos de la BD */
		info("entra en el ciclo for");
		for (Map<String, Object> row : rows) {
			barea = new DatosPersonalesBean();

			if (row.get("IDIOMANATIVO") == "0") {
				info("entra en la sentencia if");
				barea.setIdiomanativo("No");
			} else {
				info("entra en la sentencia else");
				barea.setIdiomanativo("Si");
			}
			barea.setNombreidioma((String) row.get("NOMBREIDIOMA"));
			if (row.get("DESCRIPCIONIDIOMA") == null) {
				info("entra en la sentencia if");
				barea.setDescripcionidioma("");
			} else {
				info("entra en la sentencia else");
				barea.setDescripcionidioma((String) row.get("DESCRIPCIONIDIOMA"));
			}
	
			listara.add(barea);
		}
		warn("datos enviados: "+listara.toString());
		return listara;
	}
}

class DatPerRowMapper implements RowMapper<DatosPersonalesBean> {
	@Override
	public DatosPersonalesBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		DatosPersonalesBean retorno = new DatosPersonalesBean();

		retorno.setIdpersona(rs.getInt(1));
		retorno.setIduser(rs.getLong(2));
		retorno.setSueldo(rs.getInt(9));
		retorno.setNombreArea(rs.getString(11));
		retorno.setPrimerNombre(rs.getString(3));
		retorno.setSegundoNombre(rs.getString(4));
		retorno.setApellidPterno(rs.getString(5));
		retorno.setApellidMaterno(rs.getString(6));
		retorno.setIdSexo(rs.getString(7));
		retorno.setEdad(rs.getInt(8));
		retorno.setStatus(rs.getString(10));
		retorno.setUrlFoto(rs.getString(12));
		return retorno;
	}
}

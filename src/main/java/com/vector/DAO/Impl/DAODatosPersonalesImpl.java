/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosPersonales.DatosPersonalesBean;
import com.vector.DAO.DAODatosPersonales;
import com.vector.Utileria.AutoIncrementablesBDOracle;





/**
 * @author Claudio
 *
 */
@Service
public class DAODatosPersonalesImpl implements DAODatosPersonales {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	AutoIncrementablesBDOracle ultimoid;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Create(com.vector.model.Modelo)
	 */

	@Transactional(readOnly = true)
	public int Crear(DatosPersonalesBean datos) {
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
		final String sql8 ="select * from tblpersonas where idpersona =(?)";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
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
				rs.next();

				// Segunda Insersion tbldireccion
				PreparedStatement ps3 = con.prepareStatement(sql3);
				System.out.println("id localidad "+datos.getIdlocalidad());
				ps3.setInt(1, IDDireccion);
				ps3.setString(2, datos.getCalle());
				ps3.setString(3, datos.getColonia());
				ps3.setString(4, datos.getNumeroInterior());
				ps3.setString(5, datos.getNumeroExterior());
				ps3.setInt(6, datos.getCodpost());
				ps3.setInt(7, datos.getIdlocalidad());
				ResultSet rs3 = ps3.executeQuery();
				rs3.next();
				// Tercera insersion tbldetspersona
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
				rs2.next();
				// Cuartar insersion piv03 --Documentos -- RFC
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setInt(1, iDpersona);
				ps4.setInt(2, 2);
				ps4.setString(3, datos.getRfc());
				ps4.setString(4, datos.getUrlRfc());
				ResultSet rs4 = ps4.executeQuery();
				rs4.next();

				// Quinta insersion piv03 --Documentos -- Curp
				PreparedStatement ps5 = con.prepareStatement(sql4);
				ps5.setInt(1, iDpersona);
				ps5.setInt(2, 4);
				ps5.setString(3, datos.getcURP());
				ps5.setString(4, datos.getUrlcURP());
				ResultSet rs5 = ps5.executeQuery();
				rs5.next();

				// Sexta insersion piv03 --Documentos -- Acta de nacimiento
				PreparedStatement ps6 = con.prepareStatement(sql4);
				ps6.setInt(1, iDpersona);
				ps6.setInt(2, 1);
				ps6.setString(3, datos.getFechaNacimiento());
				ps6.setString(4, datos.getUrlFechaNacimiento());
				ResultSet rs6 = ps6.executeQuery();
				rs6.next();

				// Septima insersion piv03 --Documentos -- Numero del Seguro Social
				PreparedStatement ps7 = con.prepareStatement(sql4);
				ps7.setInt(1, iDpersona);
				ps7.setInt(2, 5);
				ps7.setString(3, datos.getSeguroSocial());
				ps7.setString(4, datos.getUrlSeguroSocial());
				ResultSet rs7 = ps7.executeQuery();
				rs7.next();
				// Octava Insersion --Documentos -- Domicilio --nulo
				if (!datos.getUrlComprobanteDomicilio().equals(" ")) {
					PreparedStatement ps8 = con.prepareStatement(sql4);
					ps8.setInt(1, iDpersona);
					ps8.setInt(2, 3);
					ps8.setString(3, datos.getColonia());
					ps8.setString(4, datos.getUrlComprobanteDomicilio());
					ResultSet rs8 = ps8.executeQuery();
					rs8.next();
				}
				// novena Insersion -- Otros Documentos -- infonavit --nulos
				if (datos.getIdInfonavit() != 0) {
					PreparedStatement ps9 = con.prepareStatement(sql5);
					ps9.setInt(2, iDpersona);
					System.out.println("Piv 11 IDPersona= " + iDpersona + " ID Documento=" + datos.getIdInfonavit());
					ps9.setInt(1, 5);
					ResultSet rs9 = ps9.executeQuery();
					rs9.next();
				}
				// Decima insersion -- Otros Documentos -- Disponibilidad de viajar --nulos
				if (datos.getIdDisponibilidadViajar() != 0) {
					PreparedStatement ps10 = con.prepareStatement(sql5);
					ps10.setInt(2, iDpersona);
					ps10.setInt(1, 1);
					ResultSet rs10 = ps10.executeQuery();
					rs10.next();
				}
				// Onceava insersion -- Otros Documentos -- Disponibilidad de Cambio --nulos
				if (datos.getIdDisponibilidadCambio() != 0) {
					PreparedStatement ps11 = con.prepareStatement(sql5);
					ps11.setInt(2, iDpersona);
					ps11.setInt(1, 2);
					ResultSet rs11 = ps11.executeQuery();
					rs11.next();
				}
				// Doceava insersion -- Telefonos -- Telefono Principal
				PreparedStatement ps12 = con.prepareStatement(sql6);
				ps12.setInt(1, iDpersona);
				ps12.setInt(2, datos.getIdTelefonoPrincipal());
				ps12.setString(3, datos.getTelefonoPrincipal());
				ResultSet rs12 = ps12.executeQuery();
				rs12.next();
				// Treceava insersion -- Telefonos -- Telefono Secundario --nulos
				if (!datos.getTelefonoSecundario().equals(" ")) {
					PreparedStatement ps13 = con.prepareStatement(sql6);
					ps13.setInt(1, iDpersona);
					ps13.setInt(2, datos.getIdTelefonoSecundario());
					ps13.setString(3, datos.getTelefonoSecundario());
					ResultSet rs13 = ps13.executeQuery();
					rs13.next();
				}
				// Catorceava insersion -- Telefonos -- Telefono de Emergencia
				PreparedStatement ps14 = con.prepareStatement(sql6);
				ps14.setInt(1, iDpersona);
				ps14.setInt(2, 3);
				ps14.setString(3, datos.getTelefonoEmergencia());
				ResultSet rs14 = ps14.executeQuery();
				rs14.next();
				// Quinteava insersion -- Correos -- Correo Principal
				PreparedStatement ps15 = con.prepareStatement(sql7);
				ps15.setInt(1, iDpersona);
				ps15.setInt(2, 1);
				ps15.setString(3, datos.getCorreoPrincipal());
				ResultSet rs15 = ps15.executeQuery();
				rs15.next();
				// dieciseisava insersion -- Correos -- Correo Secundario --nulos
				if (!datos.getCorreoSecundario().equals(" ")) {
					PreparedStatement ps16 = con.prepareStatement(sql7);
					ps16.setInt(1, iDpersona);
					ps16.setInt(2, datos.getIdCorreoSecundario());
					ps16.setString(3, datos.getCorreoSecundario());
					ResultSet rs16 = ps16.executeQuery();
					rs16.next();
				}
				// Diesieteava insersion -- Otros Documentos -- Pasaporte --nulos
				if (datos.getIdpasaporte() != 0) {
					PreparedStatement ps17 = con.prepareStatement(sql5);
					ps17.setInt(2, iDpersona);
					ps17.setInt(1, 3);
					ResultSet rs17 = ps17.executeQuery();
					rs17.next();
				}
				// Dieciochoava insersion -- Otros Documentos -- Visa --nulos
			
				if (datos.getIdVisa() != 0) {	
					PreparedStatement ps18 = con.prepareStatement(sql5);
					ps18.setInt(2, iDpersona);
					ps18.setInt(1, 4);
				}
				PreparedStatement ps19 = con.prepareStatement(sql8);
				System.out.println("se encontro la persona con id: "+iDpersona);
				ps19.setInt(1, iDpersona);
				return ps19;
			}
		});
		if(respuesta==1) {
			return iDpersona;
		}else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Delete(int)
	 */
	@Transactional(readOnly = true)
	public int Eliminar(long id) {
		final String sql = "DELETE TBLPERSONAS WHERE IDPERSONA = ?";
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				return ps;

			}
		});
		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Buscar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public DatosPersonalesBean Buscar(DatosPersonalesBean datos) {
		DatosPersonalesBean retorno = new DatosPersonalesBean();
		/* Sentencias SQL a ejecutar*/
		//final String sql = "SELECT * FROM TBLPERSONAS PERS, TBLAREAS ARS, tbldetspersonas dts, tblestadosciviles edo, tbldirecciones dir WHERE dir.iddireccion = dts.iddireccion and dts.idedocivil=edo.idedocivil and PERS.IDAREA=ARS.IDAREA and pers.idpersona=dts.idpersona AND PERS.IDPERSONA= (?)";
		final String sql2 ="SELECT * FROM TBLPERSONAS per, tblareas ars WHERE per.idarea=ars.idarea and IDPERSONA=(?)";
		final String sql3 ="SELECT * FROM TBLDETSPERSONAS DTS, tblestadosciviles EDO WHERE DTS.IDEDOCIVIL=edo.idedocivil AND IDPERSONA=(?)";
		final String sql4 ="SELECT * FROM TBLPIV03 WHERE IDPERSONA=(?) AND IDDOC =(?)";
		final String sql5 ="SELECT * FROM TBLPIV11 WHERE IDPERSONA=(?) AND IDOTROSDOC =(?)";
		final String sql6 ="SELECT * FROM TBLDETSPERSONAS DTS,TBLDIRECCIONES TDS, tbllocalidades loc WHERE DTS.IDDIRECCION=TDS.IDDIRECCION and tds.idlocalidad=loc.idlocalidad AND IDPERSONA=(?)";
		final String sql7="SELECT * FROM TBLPIV11  WHERE IDPERSONA =(?) AND IDOTROSDOC=(?)";
		final String sql8="select * from tblpiv01 where idpersona=(?) and idtipotelefono =(?)";
		final String sql9="select * from tblpiv02 where idpersona=(?) and idtipocorreo =(?)";
		final String sql10="select * from view_datospersonales where idp=(?)";
		// Apartado de execuciones
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				//consulta la tabla personas
				PreparedStatement ps0 =con.prepareStatement(sql2);
				ps0.setLong(1,datos.getIdpersona());
				ResultSet rs0 = ps0.executeQuery();
				if(rs0.next()) {
				retorno.setUrlFoto(rs0.getString(3));
				retorno.setResumen(rs0.getString(5));
				retorno.setObjetivoLaboral(rs0.getString(6));
				retorno.setSueldo(rs0.getInt(7));
				retorno.setNcontrol(rs0.getString(8));
				retorno.setNombreArea(rs0.getString(10));
				retorno.setCodArea(rs0.getString(11));
				}
				//consulta la tabla detalle persona
				PreparedStatement ps01 = con.prepareStatement(sql3);
				ps01.setLong(1,datos.getIdpersona());
				ResultSet rs01 = ps01.executeQuery();
				if(rs01.next()) {
				retorno.setIdEdoCivil(rs01.getInt(4));
				retorno.setPrimerNombre(rs01.getString(5));
				retorno.setSegundoNombre(rs01.getString(6));
				retorno.setApellidPterno(rs01.getString(7));
				retorno.setApellidMaterno(rs01.getString(8));
				retorno.setIdSexo(rs01.getString(9));
				retorno.setFechaNacimiento(rs01.getString(10));
				retorno.setNacionalidad(rs01.getString(11));
				retorno.setEstadoCivil(rs01.getString(13));
				}
				//consulta la vista datos personales para la edad
				PreparedStatement ps20 =con.prepareStatement(sql10);
				ps20.setLong(1,datos.getIdpersona());
				ResultSet rs20 = ps20.executeQuery();
				if(rs20.next()) {
				retorno.setEdad(rs20.getInt(7));
				}
				//consulta la tabla piv03 para obtener el RFC
				PreparedStatement ps02 = con.prepareStatement(sql4);
				ps02.setLong(1, datos.getIdpersona());
				ps02.setInt(2,2);
				ResultSet rs02 = ps02.executeQuery();
				if(rs02.next()) {
				retorno.setRfc(rs02.getString(3));
				}
				//consulta la tabla piv03 para obtener el CURP
				PreparedStatement ps03 = con.prepareStatement(sql4);
				ps03.setLong(1, datos.getIdpersona());
				ps03.setInt(2,4);
				ResultSet rs03 = ps03.executeQuery();
				if(rs03.next()) {
				retorno.setcURP(rs03.getString(3));
				}
				
				//verifica que se tenga un valor para pasaporte
				PreparedStatement psAux004 = con.prepareStatement(sql7);
				psAux004.setLong(1, datos.getIdpersona());
				psAux004.setLong(2, 3);
				ResultSet rsAux004 = psAux004.executeQuery();
				
				//consulta la tabla piv11 para obetener pasaporte
				if (rsAux004.next()) {
				PreparedStatement ps04 = con.prepareStatement(sql5);
				ps04.setLong(1, datos.getIdpersona());
				ps04.setInt(2, 3);
				ResultSet rs04= ps04.executeQuery();
				rs04.next();
				retorno.setIdpasaporte(rs04.getInt(1));
				}
				
				//verifica que se tenga un valor para visa
				PreparedStatement psAux005 = con.prepareStatement(sql7);
				psAux005.setLong(1, datos.getIdpersona());
				psAux005.setLong(2, 4);
				ResultSet rsAux005 = psAux005.executeQuery();
				
				//consulta la tabla piv11 para obetener visa
				if(rsAux005.next()) {
				PreparedStatement ps05 = con.prepareStatement(sql5);
				ps05.setLong(1, datos.getIdpersona());
				ps05.setInt(2, 4);
				ResultSet rs05= ps05.executeQuery();
				rs05.next();
				retorno.setIdVisa(rs05.getInt(1));
				}
				//consulta la tabla piv03 para obtener el NSS
				PreparedStatement ps06 = con.prepareStatement(sql4);
				ps06.setLong(1, datos.getIdpersona());
				ps06.setInt(2,5);
				ResultSet rs06 = ps06.executeQuery();
				if(rs06.next()) {
				retorno.setcURP(rs06.getString(3));
				}
				//verifica que se tenga un valor para infonavit
				PreparedStatement psAux007 = con.prepareStatement(sql7);
				psAux007.setLong(1, datos.getIdpersona());
				psAux007.setLong(2, 5);
				ResultSet rsAux007 = psAux007.executeQuery();
				
				//consulta la tabla piv11 para obetener INFONAVIT
				if(rsAux007.next()) {
				PreparedStatement ps07 = con.prepareStatement(sql5);
				ps07.setLong(1, datos.getIdpersona());
				ps07.setInt(2, 5);
				ResultSet rs07= ps07.executeQuery();
				rs07.next();
				retorno.setIdInfonavit(rs07.getInt(1));
				}
				
				//verifica que se tenga un valor para viajar
				PreparedStatement psAux008 = con.prepareStatement(sql7);
				psAux008.setLong(1, datos.getIdpersona());
				psAux008.setLong(2, 1);
				ResultSet rsAux008 = psAux008.executeQuery();
				
				//consulta la tabla piv11 para disponibilidad viajar
				if(rsAux008.next()) {
				PreparedStatement ps08 = con.prepareStatement(sql5);
				ps08.setLong(1, datos.getIdpersona());
				ps08.setInt(2, 1);
				ResultSet rs08= ps08.executeQuery();
				rs08.next();
				retorno.setIdDisponibilidadViajar(rs08.getInt(1));
				}
				
				//verifica que se tenga un valor para cambio residencia
				PreparedStatement psAux009 = con.prepareStatement(sql7);
				psAux009.setLong(1, datos.getIdpersona());
				psAux009.setLong(2, 2);
				ResultSet rsAux009 = psAux009.executeQuery();
				
				//consulta la tabla piv11 para disponibilidad cambio residencia
				if(rsAux009.next()) {
				PreparedStatement ps09 = con.prepareStatement(sql5);
				ps09.setLong(1, datos.getIdpersona());
				ps09.setInt(2, 2);
				ResultSet rs09= ps09.executeQuery();
				rs09.next();
				retorno.setIdDisponibilidadCambio(rs09.getInt(1));
				}
				//consulta la tabla piv3 para direccion
				PreparedStatement ps10 = con.prepareStatement(sql6);
				ps10.setLong(1,datos.getIdpersona());
				ResultSet rs10 = ps10.executeQuery();
				if(rs10.next()) {
				retorno.setCalle(rs10.getString(13));
				retorno.setColonia(rs10.getString(14));
				retorno.setNumeroInterior(rs10.getString(15));
				retorno.setNumeroExterior(rs10.getString(16));
				retorno.setCodpost(rs10.getInt(17));
				retorno.setIdlocalidad(rs10.getInt(18));
				}
				//consulta la tabla piv01 para obterner el telefono principal
				PreparedStatement ps11 = con.prepareStatement(sql8);
				ps11.setLong(1, datos.getIdpersona());
				ps11.setInt(2,1);
				ResultSet rs11 = ps11.executeQuery();
				if(rs11.next()) {
				retorno.setTelefonoPrincipal(rs11.getString(3));
				}
				
				//consulta la tabla piv01 para obterner el telefono secundario
				PreparedStatement ps12 = con.prepareStatement(sql8);
				ps12.setLong(1, datos.getIdpersona());
				ps12.setInt(2,2);
				ResultSet rs12 = ps12.executeQuery();
				if(rs12.next()) {
				retorno.setTelefonoSecundario(rs12.getString(3));
				}
				//consulta la tabla piv01 para obterner el telefono emergente
				PreparedStatement ps13 = con.prepareStatement(sql8);
				ps13.setLong(1, datos.getIdpersona());
				ps13.setInt(2,3);
				ResultSet rs13 = ps13.executeQuery();
				if(rs13.next()) {
				retorno.setTelefonoEmergencia(rs13.getString(3));
				}
				
				//consulta la tabla piv02 para obterner el correo principal (vector)
				PreparedStatement ps14 = con.prepareStatement(sql9);
				ps14.setLong(1, datos.getIdpersona());
				ps14.setInt(2,4);
				ResultSet rs14 = ps14.executeQuery();
				PreparedStatement ps15 = con.prepareStatement(sql9);
				ps15.setLong(1, datos.getIdpersona());
				ps15.setInt(2,6);
				ResultSet rs15 = ps15.executeQuery();
				if(rs14.next()) {
				retorno.setCorreoPrincipal(rs14.getString(3)+"@ext.vectoritcgroup.com");
				}else if(rs15.next()){
					retorno.setCorreoPrincipal(rs15.getString(3)+"@vectoritcgroup.com");
				}
				
				//consulta la tabla piv02 para obterner el correo secundario (personal)
				PreparedStatement ps16 = con.prepareStatement(sql9);
				ps16.setLong(1, datos.getIdpersona());
				ps16.setInt(2,1);	
				ResultSet rs16 = ps16.executeQuery();
				if(rs16.next()) {
				retorno.setCorreoSecundario(rs16.getString(3));
				}
				PreparedStatement ps17 = con.prepareStatement(sql9);
				ps17.setLong(1, datos.getIdpersona());
				ps17.setInt(2,2);	
				ResultSet rs17 = ps17.executeQuery();
				if(rs17.next()) {
				retorno.setCorreoSecundario(rs17.getString(3));
				}
				PreparedStatement ps18 = con.prepareStatement(sql9);
				ps18.setLong(1, datos.getIdpersona());
				ps18.setInt(2,3);	
				ResultSet rs18 = ps18.executeQuery();
				if(rs18.next()) {
				retorno.setCorreoSecundario(rs18.getString(3));
				}
				PreparedStatement ps19 = con.prepareStatement(sql9);
				ps19.setLong(1, datos.getIdpersona());
				ps19.setInt(2,5);	
				ResultSet rs19 = ps19.executeQuery();
				if(rs19.next()) {
				retorno.setCorreoSecundario(rs19.getString(3));
				}
					
				return ps01;
			}
		});
		return retorno;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vector.service.ModelABCLD#Listar(com.vector.model.Modelo)
	 */
	@Transactional(readOnly = true)
	public List<DatosPersonalesBean> Listar() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM view_datospersonales", new DatPerRowMapper());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vector.DAO.DAODatosPersonales#Actualizar(com.vector.Beans.DatosPersonales
	 * .DatosPersonalesBean)
	 */
	@Override
	public int Modificar(DatosPersonalesBean datos) {
		
		
		// TODO Auto-generated method stub
		final String sql0 ="UPDATE TBLDETSPERSONAS SET  NOMBRE=(?), SEGNOMBRE =(?), APELLIDOP =(?), APELLIDOM=(?), SEXO=(?), FECHANAC=(?), IDEDOCIVIL=(?), NACIONALIDAD=(?) WHERE IDPERSONA=(?)";
		final String sql = "UPDATE TBLPERSONAS SET  URLFOTO=(?), RESUMEN =(?), OBJLABORAL =(?) WHERE IDPERSONA=(?) ";
		final String sql2 = "UPDATE TBLDIRECCIONES SET CODPOST=(?), CALLE=(?), COLONIA=(?), NUMINTERIOR=(?),NUMEXTERIOR=(?) WHERE IDDIRECCION=(?)";
		final String sql3 = "UPDATE TBLPIV03 SET IDDOC=(?),DESCRIPCION=(?),URLDOC=(?) WHERE IDPERSONA=(?) and IDDOC =(?)";
		//final String sql4 = "UPDATE TBLPIV11 SET IDOTROSDOC=(?) WHERE IDPERSONA=(?),  AND IDOTROSDOC=(?)";
		final String sql4 = "INSERT INTO TBLPIV11 VALUES(?,?)";
		final String sql04="DELETE TBLPIV11  WHERE IDPERSONA=(?) AND IDOTROSDOC=(?)";
		final String sql5 ="select * from tblpersonas where idpersona=(?)";

		//aux para la busqueda del id de direccion
		final String sqlaux = "select * from tbldirecciones dir, tbldetspersonas dts where dir.iddireccion = dts.iddireccion and dts.idpersona = (?)";
	//	final String sqlAux2 ="select * from TBLDETSPERSONAS dtp where dtp.idpersona=(?)";
		final String sqlAux3="SELECT * FROM TBLPIV11  WHERE IDPERSONA =(?) AND IDOTROSDOC=(?)";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				
				
				//cero actualizada tabla detalle persona				
				PreparedStatement ps0 = con.prepareStatement(sql0);
				System.out.println("DAO modificar -- detalle persona: nombre: "+datos.getPrimerNombre()+", segundo nombre: "+datos.getSegundoNombre()+", apellido p: "+datos.getApellidPterno()
				+", apellido m: "+datos.getApellidMaterno()+",sexo: "+datos.getIdSexo()+",fecha: "+datos.getFechaNacimiento()+",civil: "+datos.getIdEdoCivil()
				+",nacionalidad: "+datos.getNacionalidad()+", idpersona: "+datos.getIdpersona()+"\n");
				ps0.setString(1, datos.getPrimerNombre());
				ps0.setString(2, datos.getSegundoNombre());
				ps0.setString(3, datos.getApellidPterno());
				ps0.setString(4, datos.getApellidMaterno());
				ps0.setString(5, datos.getIdSexo());		
				ps0.setString(6, datos.getFechaNacimiento());
				ps0.setInt(7, datos.getIdEdoCivil());
				ps0.setString(8, datos.getNacionalidad());
				ps0.setLong(9,datos.getIdpersona());
				ResultSet rs0 =ps0.executeQuery();
				if(rs0.next()) {
					
				}

				// primera Actualizacion TBLPersonas
				PreparedStatement ps = con.prepareStatement(sql);
				System.out.println("DAO modificar -- persona: Urlfoto: "+datos.getUrlFoto()+", resumen: "+datos.getResumen()+", objetivo: "+datos.getObjetivoLaboral()
				+", idpersona: "+datos.getIdpersona()+"\n");
				ps.setString(1, datos.getUrlFoto());
				ps.setString(2, datos.getResumen());
				ps.setString(3, datos.getObjetivoLaboral());
				ps.setLong(4, datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					
				}
				
				//seleccion de busqueda de id de direccion
				PreparedStatement psAux = con.prepareStatement(sqlaux);
				psAux.setLong(1, datos.getIdpersona());
				ResultSet rsAux = psAux.executeQuery();
				rsAux.next();
				int idAux2=Integer.parseInt(rsAux.getString(1));
				
				// segunda actualizacion tbldirecciones
				PreparedStatement ps2 = con.prepareStatement(sql2);
				System.out.println("DAO modificar -- direccion: codigo: "+datos.getCodpost()+", calle: "+datos.getCalle()+", colonia: "+datos.getColonia()
				+", numero interior: "+datos.getNumeroInterior()+",exterior: "+datos.getNumeroExterior()+", idpersona: "+datos.getIdpersona()+"\n");
				ps2.setInt(1, datos.getCodpost());
				ps2.setString(2, datos.getCalle());
				ps2.setString(3, datos.getColonia());
				ps2.setString(4, datos.getNumeroInterior());
				ps2.setString(5, datos.getNumeroExterior());
				ps2.setInt(6, idAux2);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					
				}

				// tercera actualizacion piv_03 --acta de nacimiento--
				PreparedStatement ps3 = con.prepareStatement(sql3);
			
				ps3.setInt(1, 1);
				ps3.setString(2, datos.getFechaNacimiento());
				ps3.setString(3, datos.getUrlFechaNacimiento());
				ps3.setLong(4, datos.getIdpersona());
				ps3.setInt(5, 1);
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next()) {
					
				}
				
				// cuarta actualizacion piv_03 --RFC--
				PreparedStatement ps4 = con.prepareStatement(sql3);
				ps4.setInt(1, 2);
				ps4.setString(2, datos.getRfc());
				ps4.setString(3, datos.getUrlRfc());
				ps4.setLong(4, datos.getIdpersona());
				ps4.setInt(5, 2);
				ResultSet rs4 = ps4.executeQuery();
				if(rs4.next()) {
					
				}
				
				// quinta actualizacion piv_03 --CURP--
				PreparedStatement ps5 = con.prepareStatement(sql3);
				ps5.setLong(1, 4);
				ps5.setString(2, datos.getcURP());
				ps5.setString(3, datos.getUrlcURP());
				ps5.setLong(4, datos.getIdpersona());
				ps5.setInt(5,4);
				ResultSet rs5 = ps5.executeQuery();
				if(rs5.next()) {
					
				}
				
				//seleccion para saber si hay valor en piv11 de id=3
				PreparedStatement psAux3 = con.prepareStatement(sqlAux3);
				psAux3.setLong(1, datos.getIdpersona());
				psAux3.setLong(2, 3);
				ResultSet rsAux3 = psAux3.executeQuery();
								
				// sexta actualizacion piv11 --otrs Documentos -- pasaporte
				if (datos.getIdpasaporte() != 0) {
					if(rsAux3.next()) {
						
					}else {
						PreparedStatement ps6 = con.prepareStatement(sql4);
						ps6.setInt(1, 3);
						ps6.setInt(2, datos.getIdpersona());
						ResultSet rs6 = ps6.executeQuery();
						rs6.next();	
					}
					}else {
					PreparedStatement ps6 = con.prepareStatement(sql04);
					ps6.setInt(1,3);
					ps6.setLong(2, datos.getIdpersona());
					ResultSet rs6 = ps6.executeQuery();
					rs6.next();
				}
				
				//seleccion para saber si hay valor en piv11 de id=4
				PreparedStatement psAux4 = con.prepareStatement(sqlAux3);
				psAux4.setLong(1, datos.getIdpersona());
				psAux4.setLong(2, 4);
				ResultSet rsAux4 = psAux4.executeQuery();
				
				// septima actualizacion piv11 --otrs Documentos -- visa
				if (datos.getIdpasaporte() != 0) {
					if(rsAux4.next()) {
						
					}else {
						PreparedStatement ps7 = con.prepareStatement(sql4);
						ps7.setInt(1, 4);
						ps7.setLong(2, datos.getIdpersona());
						ResultSet rs7 = ps7.executeQuery();
						rs7.next();	
					}
					}else {
					PreparedStatement ps7 = con.prepareStatement(sql04);
					ps7.setInt(1,4);
					ps7.setLong(2, datos.getIdpersona());
					ResultSet rs7 = ps7.executeQuery();
					rs7.next();
				}
				
				
				// octava actualizacion piv03 --Documentos -- seguro social
				PreparedStatement ps8 = con.prepareStatement(sql3);
				ps8.setLong(1, 5);
				ps8.setString(2, datos.getSeguroSocial());
				ps8.setString(3, datos.getUrlSeguroSocial());
				ps8.setLong(4, datos.getIdpersona());
				ps8.setLong(5, 5);
				ResultSet rs8 = ps8.executeQuery();
				if(rs8.next()) {
					
				}


				//seleccion para saber si hay valor en piv11 de id=5
				PreparedStatement psAux5 = con.prepareStatement(sqlAux3);
				psAux5.setLong(1, datos.getIdpersona());
				psAux5.setLong(2, 5);
				ResultSet rsAux5 = psAux5.executeQuery();
				
				// novena actualizacion piv03 --Documentos -- infonavit
				if (datos.getIdpasaporte() != 0) {
					if(rsAux5.next()) {
						
					}else {
						PreparedStatement ps9 = con.prepareStatement(sql4);
						ps9.setInt(1, 5);
						ps9.setLong(2, datos.getIdpersona());
						ResultSet rs9 = ps9.executeQuery();
						rs9.next();	
					}
					}else {
					PreparedStatement ps9 = con.prepareStatement(sql04);
					ps9.setInt(1, 5);
					ps9.setLong(2, datos.getIdpersona());
					ResultSet rs9 = ps9.executeQuery();
					rs9.next();
				}
				
				//seleccion para saber si hay valor en piv11 de id=1
				PreparedStatement psAux6 = con.prepareStatement(sqlAux3);
				psAux6.setLong(1, datos.getIdpersona());
				psAux6.setLong(2, 1);
				ResultSet rsAux6 = psAux6.executeQuery();

				// Decima actualizacion -- Otros Documentos -- disponibilidad de viajar
				if (datos.getIdpasaporte() != 0) {
					if(rsAux6.next()) {
						
					}else {
						PreparedStatement ps10 = con.prepareStatement(sql4);
						ps10.setInt(1, 1);
						ps10.setLong(2, datos.getIdpersona());
						ResultSet rs10 = ps10.executeQuery();
						rs10.next();	
					}
					}else {
					PreparedStatement ps10 = con.prepareStatement(sql04);
					ps10.setInt(1,1);
					ps10.setLong(2, datos.getIdpersona());
					ResultSet rs6 = ps10.executeQuery();
					rs6.next();
				}
				
				//seleccion para saber si hay valor en piv11 de id=2
				PreparedStatement psAux7 = con.prepareStatement(sqlAux3);
				psAux7.setLong(1, datos.getIdpersona());
				psAux7.setLong(2, 2);
				ResultSet rsAux7 = psAux7.executeQuery();
				
				// onceava actualizacion -- Otros Documentos -- disponibilidad de cambio de residencia
				if (datos.getIdpasaporte() != 0) {
					if(rsAux7.next()) {
						
					}else {
						PreparedStatement ps11 = con.prepareStatement(sql4);
						ps11.setInt(1, 2);
						ps11.setLong(2, datos.getIdpersona());
						ResultSet rs11 = ps11.executeQuery();
						rs11.next();	
					}
					}else {
					PreparedStatement ps11 = con.prepareStatement(sql04);
					ps11.setInt(1,2);
					ps11.setLong(2, datos.getIdpersona());
					ResultSet rs11 = ps11.executeQuery();
					rs11.next();
				}
				//si existe la persona se ejecuta el update 
				PreparedStatement ps12 = con.prepareStatement(sql5);
				System.out.println("si esta la persona con ID: "+datos.getIdpersona());
				ps12.setLong(1, datos.getIdpersona());
				return ps12;
				
			}
		});
		return respuesta;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosPersonales#Modificar2(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public int Modificar2(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		final String sql0 ="UPDATE TBLDETSPERSONAS SET  NOMBRE=(?), SEGNOMBRE =(?), APELLIDOP =(?), APELLIDOM=(?), SEXO=(?), FECHANAC=(?), IDEDOCIVIL=(?), NACIONALIDAD=(?) WHERE IDPERSONA=(?)";
		final String sql = "UPDATE TBLPERSONAS SET  URLFOTO=(?), RESUMEN =(?), OBJLABORAL =(?) WHERE IDPERSONA=(?) ";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				
				
				//cero actualizada tabla detalle persona				
				PreparedStatement ps0 = con.prepareStatement(sql0);
				ps0.setString(1, datos.getPrimerNombre());
				ps0.setString(2, datos.getSegundoNombre());
				ps0.setString(3, datos.getApellidPterno());
				ps0.setString(4, datos.getApellidMaterno());
				ps0.setString(5, datos.getIdSexo());		
				ps0.setString(6, datos.getFechaNacimiento());
				ps0.setInt(7, datos.getIdEdoCivil());
				ps0.setString(8, datos.getNacionalidad());
				ps0.setInt(9,datos.getIdpersona());
				ResultSet rs0 =ps0.executeQuery();
				rs0.next();	

				// primera Actualizacion TBLPersonas
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, datos.getUrlFoto());
				ps.setString(2, datos.getResumen());
				ps.setString(3, datos.getObjetivoLaboral());
				ps.setLong(4, datos.getIdpersona());
				//ResultSet rs = ps.executeQuery();
				//rs.next();
				
				
				return ps;
				
			}
		});
		return respuesta;
	}

	/* (Claudio-Javadoc)
	 * @see com.vector.DAO.DAODatosPersonales#Modificar3(com.vector.Beans.DatosPersonales.DatosPersonalesBean)
	 */
	@Override
	public int Modificar3(DatosPersonalesBean datos) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE TBLPERSONAS SET  IDAREA=(?), SUELDO =(?) WHERE IDPERSONA=(?) ";
		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				


				// primera Actualizacion TBLPersonas
				PreparedStatement ps = con.prepareStatement(sql);
				System.out.println("DAO -- se actualizo datos persona con id: "+datos.getIdpersona()+", id area: "+datos.getIdarea()+", y sueldo: "+datos.getSueldo());
				ps.setInt(1, datos.getIdarea());
				ps.setInt(2, datos.getSueldo());
				ps.setLong(3, datos.getIdpersona());
	
				
				return ps;
				
			}
		});
		return respuesta;
	}

}

class DatPerRowMapper implements RowMapper<DatosPersonalesBean> {
	@Override
	public DatosPersonalesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DatosPersonalesBean retorno = new DatosPersonalesBean();

		retorno.setIdpersona(rs.getInt(1));
		retorno.setSueldo(rs.getInt(8));
		retorno.setNombreArea(rs.getString(10));
		retorno.setPrimerNombre(rs.getString(2));
		retorno.setSegundoNombre(rs.getString(3));
		retorno.setApellidPterno(rs.getString(4));
		retorno.setApellidMaterno(rs.getString(5));
		retorno.setIdSexo(rs.getString(6));
		retorno.setEdad(rs.getInt(7));
		retorno.setStatus(rs.getString(9));
		retorno.setUrlFoto(rs.getString(15));
		retorno.setCorreoPrincipal(rs.getString(13)+rs.getString(14));
		retorno.setTelefonoPrincipal(rs.getString(12));
		return retorno;
	}
}

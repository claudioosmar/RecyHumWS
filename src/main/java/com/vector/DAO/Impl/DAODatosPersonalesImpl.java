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
		final String sql3 = "INSERT INTO TBLDIRECCIONES VALUES(?,?,?,?,?,?)";
		final String sql4 = "INSERT INTO TBLpiv03 VALUES(?,?,?,?)";
		final String sql5 = "INSERT INTO TBLPIV11 VALUES(?,?)";
		final String sql6 = "INSERT INTO TBLPIV01 VALUES(?,?,?)";
		final String sql7 = "INSERT INTO TBLPIV02 VALUES(?,?,?)";

		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				// Primera Insersion TBLPersonas
				ps.setLong(1, iDpersona);
				ps.setInt(2, 1);
				ps.setString(3, datos.getUrlFoto());
				ps.setInt(4, 1);
				ps.setString(5, datos.getResumen());
				ps.setString(6, datos.getObjetivoLaboral());
				ps.setString(7, "0.0");
				ps.setString(8, "sin asignar");
				ResultSet rs = ps.executeQuery();
				rs.next();

				// Segunda Insersion tbldireccion
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.setInt(1, IDDireccion);
				ps3.setString(2, datos.getCalle());
				ps3.setString(3, datos.getColonia());
				ps3.setString(4, datos.getNumeroInterior());
				ps3.setString(5, datos.getNumeroExterior());
				ps3.setInt(6, datos.getCodigoPostal());
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
				ps14.setInt(2, datos.getIdTelefonoEmergencia());
				ps14.setString(3, datos.getTelefonoEmergencia());
				ResultSet rs14 = ps14.executeQuery();
				rs14.next();
				// Quinteava insersion -- Correos -- Correo Principal
				PreparedStatement ps15 = con.prepareStatement(sql7);
				ps15.setInt(1, iDpersona);
				ps15.setInt(2, datos.getIdCorreoPrincipal());
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
				PreparedStatement ps18 = con.prepareStatement(sql5);
				if (datos.getIdVisa() != 0) {
					ps18.setInt(2, iDpersona);
					ps18.setInt(1, 4);
				}
				return ps18;
			}
		});
		return respuesta;
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
		final String sql = "SELECT * FROM TBLPERSONAS PERS, TBLAREAS ARS, tbldetspersonas dts, tblestadosciviles edo, tbldirecciones dir WHERE dir.iddireccion = dts.iddireccion and dts.idedocivil=edo.idedocivil and PERS.IDAREA=ARS.IDAREA and pers.idpersona=dts.idpersona AND PERS.IDPERSONA= (?)";
	/*
		final String sql4 = "INSERT INTO TBLpiv03 VALUES(?,?,?,?)";
		final String sql5 = "INSERT INTO TBLPIV11 VALUES(?,?)";
		final String sql6 = "INSERT INTO TBLPIV01 VALUES(?,?,?)";
		final String sql7 = "INSERT INTO TBLPIV02 VALUES(?,?,?)";*/

		/*
		 * final String
		 * sql="SELECT * FROM TBLPERSONAS pr, TBLDETSPERSONAS dts,TBLDIRECCIONES dir, TBLPIV01 piv01, TBLPIV02 piv02, TBLPIV03 piv03"
		 * +
		 * "WHERE pr.IDPERSONA=dts.IDPERSONA AND dts.IDDIRECCION=dir.IDDIRECCION AND piv01.IDPERSONA=pr.IDPERSONA AND piv02.IDPERSONA=pr.IDPERSONA"
		 * + "AND piv03.IDPERSONA=pr.IDPERSONA AND pr.IDPERSONA = (?)";
		 */

		// Apartado de execuciones
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				// Primera Insersion TBLPersonas
				ps.setLong(1,datos.getIdpersona());
				ResultSet rs = ps.executeQuery();
				rs.next();
				retorno.setUrlFoto(rs.getString(3));
				retorno.setStatus(rs.getString(4));
				retorno.setResumen(rs.getString(5));
				retorno.setObjetivoLaboral(rs.getString(6));
				retorno.setSueldo(rs.getInt(7));
				retorno.setNcontrol(rs.getString(8));
				retorno.setNombreArea(rs.getString(10));
				retorno.setCodArea(rs.getString(11));
				retorno.setPrimerNombre(rs.getString(17));
				retorno.setSegundoNombre(rs.getString(18));
				retorno.setApellidPterno(rs.getString(19));
				retorno.setApellidMaterno(rs.getString(20));
				retorno.setIdSexo(rs.getString(21));
				retorno.setFechaNacimiento(rs.getString(22));
				retorno.setNacionalidad(rs.getString(23));
				retorno.setIdEdoCivil(rs.getInt(24));
				retorno.setEstadoCivil(rs.getString(25));
				retorno.setCalle(rs.getString(28));
				retorno.setColonia(rs.getString(29));
				retorno.setNumeroInterior(rs.getString(30));
				retorno.setNumeroExterior(rs.getString(31));
				retorno.setCodigoPostal(rs.getInt(32));
				return ps;
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
		return jdbcTemplate.query("SELECT * FROM TBLPERSONAS PERS, TBLAREAS ARS, tbldetspersonas dts, tblestadosciviles edo, tbldirecciones dir WHERE dir.iddireccion = dts.iddireccion and dts.idedocivil=edo.idedocivil and PERS.IDAREA=ARS.IDAREA and pers.idpersona=dts.idpersona", new DatPerRowMapper());
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
		final String sql = "UPDATE TBLPERSONAS SET IDAREA = (?), URLFOTO=(?), STATUS=(?), RESUMEN =(?), OBJLABORAL =(?) WHERE IDPERSONA=(?) ";
		final String sql2 = "UPDATE TBLDETSPERSONAS SET IDDIRECCION =(?), IDEDOCIVIL=(?), NOMBRE=(?), SEGNOMBRE=(?), APELLIDOP=(?), APELLIDOM=(?), SEXO=(?), FECHANAC=(?), NACIONALIDAD=(?) WHERE IDPERSONA=(?)";
		// Sentencias SQL a ejecutar
		//final String sql = "INSERT INTO TBLPERSONAS VALUES(?,?,?,?,?,?,?,?)";
		//final String sql2 = "INSERT INTO TBLDETSPERSONAS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		final String sql3 = "INSERT INTO TBLDIRECCIONES VALUES(?,?,?,?,?,?)";
		final String sql4 = "INSERT INTO TBLpiv03 VALUES(?,?,?,?)";
		final String sql5 = "INSERT INTO TBLPIV11 VALUES(?,?)";
		final String sql6 = "INSERT INTO TBLPIV01 VALUES(?,?,?)";
		final String sql7 = "INSERT INTO TBLPIV02 VALUES(?,?,?)";

		// Apartado de execuciones
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				// Primera Actualizacion TBLPersonas
				ps.setLong(1, datos.getIdpersona());
				ps.setInt(2, 1);
				ps.setString(3, datos.getUrlFoto());
				ps.setInt(4, 1);
				ps.setString(5, datos.getResumen());
				ps.setString(6, datos.getObjetivoLaboral());
				ps.setString(7, "0.0");
				ps.setString(8, "sin asignar");
				ResultSet rs = ps.executeQuery();
				rs.next();

				// Segunda Insersion tbldetspersonas
				PreparedStatement ps2 = con.prepareStatement(sql2);
				//ps2.setInt(1, IDpersonadetalle);
				ps2.setLong(2, datos.getIdpersona());
				//ps2.setLong(3, IDDireccion);
				ps2.setLong(4, datos.getIdEdoCivil());
				ps2.setString(5, datos.getPrimerNombre());
				ps2.setString(6, datos.getSegundoNombre());
				ps2.setString(7, datos.getApellidPterno());
				ps2.setString(8, datos.getApellidMaterno());
				ps2.setString(9, datos.getIdSexo());
				ps2.setString(10, datos.getFechaNacimiento());
				ps2.setString(11, datos.getNacionalidad());

				// Tercera insersion tbldirecciones
				PreparedStatement ps3 = con.prepareStatement(sql3);
				//ps3.setInt(1, IDDireccion);
				ps3.setString(2, datos.getCalle());
				ps3.setString(3, datos.getColonia());
				ps3.setString(4, datos.getNumeroInterior());
				ps3.setString(5, datos.getNumeroExterior());
				ps3.setInt(6, datos.getCodigoPostal());
				ResultSet rs3 = ps3.executeQuery();
				rs3.next();
				// Cuartar insersion piv03 --Documentos -- RFC
				PreparedStatement ps4 = con.prepareStatement(sql4);
				ps4.setInt(1, datos.getIdpersona());
				ps4.setInt(2, 2);
				ps4.setString(3, datos.getRfc());
				ps4.setString(5, datos.getUrlRfc());
				ResultSet rs4 = ps4.executeQuery();
				rs4.next();

				// Quinta insersion piv03 --Documentos -- Curp
				PreparedStatement ps5 = con.prepareStatement(sql4);
				ps4.setInt(1, datos.getIdpersona());
				ps4.setInt(2, 4);
				ps4.setString(3, datos.getcURP());
				ps4.setString(5, datos.getUrlcURP());
				ResultSet rs5 = ps5.executeQuery();
				rs5.next();

				// Sexta insersion piv03 --Documentos -- Acta de nacimiento
				PreparedStatement ps6 = con.prepareStatement(sql4);
				ps4.setInt(1, datos.getIdpersona());
				ps4.setInt(2, 1);
				ps4.setString(3, datos.getFechaNacimiento());
				ps4.setString(5, datos.getUrlFechaNacimiento());
				ResultSet rs6 = ps6.executeQuery();
				rs6.next();

				// Septima insersion piv03 --Documentos -- Numero del Seguro Social
				PreparedStatement ps7 = con.prepareStatement(sql4);
				ps7.setInt(1, datos.getIdpersona());
				ps7.setInt(2, 5);
				ps7.setString(3, datos.getSeguroSocial());
				ps7.setString(4, datos.getUrlSeguroSocial());
				ResultSet rs7 = ps7.executeQuery();
				rs7.next();
				// Octava Insersion --Documentos -- Domicilio
				PreparedStatement ps8 = con.prepareStatement(sql4);
				ps8.setInt(1, datos.getIdpersona());
				ps8.setInt(2, 3);
				ps8.setString(3, datos.getColonia());
				ps8.setString(4, datos.getUrlComprobanteDomicilio());
				ResultSet rs8 = ps8.executeQuery();
				rs8.next();
				// novena Insersion -- Otros Documentos -- infonavit
				PreparedStatement ps9 = con.prepareStatement(sql5);
				ps9.setInt(1, datos.getIdpersona());
				ps9.setInt(2, datos.getIdInfonavit());
				ResultSet rs9 = ps9.executeQuery();
				rs9.next();
				// Decima insersion -- Otros Documentos -- Disponibilidad de viajar
				PreparedStatement ps10 = con.prepareStatement(sql5);
				ps10.setInt(1, datos.getIdpersona());
				ps10.setInt(2, datos.getIdDisponibilidadViajar());
				ResultSet rs10 = ps10.executeQuery();
				rs10.next();
				// Onceava insersion -- Otros Documentos -- Disponibilidad de Cambio
				PreparedStatement ps11 = con.prepareStatement(sql5);
				ps11.setInt(1, datos.getIdpersona());
				ps11.setInt(2, datos.getIdDisponibilidadCambio());
				ResultSet rs11 = ps11.executeQuery();
				rs11.next();
				// Doceava insersion -- Telefonos -- Telefono Principal
				PreparedStatement ps12 = con.prepareStatement(sql6);
				ps12.setInt(1, datos.getIdpersona());
				ps12.setInt(2, datos.getIdTelefonoPrincipal());
				ps12.setString(3, datos.getTelefonoPrincipal());
				ResultSet rs12 = ps12.executeQuery();
				rs12.next();
				// Treceava insersion -- Telefonos -- Telefono Secundario
				PreparedStatement ps13 = con.prepareStatement(sql6);
				ps13.setInt(1, datos.getIdpersona());
				ps13.setInt(2, datos.getIdTelefonoSecundario());
				ps13.setString(3, datos.getTelefonoSecundario());
				ResultSet rs13 = ps13.executeQuery();
				rs13.next();
				// Catorceava insersion -- Telefonos -- Telefono de Emergencia
				PreparedStatement ps14 = con.prepareStatement(sql6);
				ps14.setInt(1, datos.getIdpersona());
				ps14.setInt(2, datos.getIdTelefonoEmergencia());
				ps14.setString(3, datos.getTelefonoEmergencia());
				ResultSet rs14 = ps14.executeQuery();
				rs14.next();
				// Quinteava insersion -- Correos -- Correo Principal
				PreparedStatement ps15 = con.prepareStatement(sql7);
				ps15.setInt(1, datos.getIdpersona());
				ps15.setInt(2, datos.getIdCorreoPrincipal());
				ps15.setString(3, datos.getCorreoPrincipal());
				ResultSet rs15 = ps15.executeQuery();
				rs15.next();
				// dieciseisava insersion -- Correos -- Correo Secundario
				PreparedStatement ps16 = con.prepareStatement(sql7);
				ps16.setInt(1, datos.getIdpersona());
				ps16.setInt(2, datos.getIdCorreoSecundario());
				ps16.setString(3, datos.getCorreoSecundario());
				ResultSet rs16 = ps16.executeQuery();
				rs16.next();
				// Diesieteava insersion -- Otros Documentos -- Pasaporte
				PreparedStatement ps17 = con.prepareStatement(sql5);
				ps17.setInt(1, datos.getIdpersona());
				ps17.setInt(2, datos.getIdpasaporte());
				ResultSet rs17 = ps17.executeQuery();
				rs17.next();
				// Dieciochoava insersion -- Otros Documentos -- Visa
				PreparedStatement ps18 = con.prepareStatement(sql5);
				ps18.setInt(1, datos.getIdpersona());
				ps18.setInt(2, datos.getIdVisa());
				return ps18;
			}
		});
		return respuesta;
	}

}

class DatPerRowMapper implements RowMapper<DatosPersonalesBean> {
	@Override
	public DatosPersonalesBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatosPersonalesBean retorno = new DatosPersonalesBean();
		retorno.setUrlFoto(rs.getString(3));
		retorno.setStatus(rs.getString(4));
		retorno.setResumen(rs.getString(5));
		retorno.setObjetivoLaboral(rs.getString(6));
		retorno.setSueldo(rs.getInt(7));
		retorno.setNcontrol(rs.getString(8));
		retorno.setNombreArea(rs.getString(10));
		retorno.setCodArea(rs.getString(11));
		retorno.setPrimerNombre(rs.getString(17));
		retorno.setSegundoNombre(rs.getString(18));
		retorno.setApellidPterno(rs.getString(19));
		retorno.setApellidMaterno(rs.getString(20));
		retorno.setIdSexo(rs.getString(21));
		retorno.setFechaNacimiento(rs.getString(22));
		retorno.setNacionalidad(rs.getString(23));
		retorno.setIdEdoCivil(rs.getInt(24));
		retorno.setEstadoCivil(rs.getString(25));
		retorno.setCalle(rs.getString(28));
		retorno.setColonia(rs.getString(29));
		retorno.setNumeroInterior(rs.getString(30));
		retorno.setNumeroExterior(rs.getString(31));
		retorno.setCodigoPostal(rs.getInt(32));
		return retorno;
	}
}

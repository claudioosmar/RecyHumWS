/**
 * DAODatosPistaAuditoraImpl.java -- 17/10/2018
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.DAO.DAODatosPistaAuditora;
import com.vector.Utileria.AutoIncrementablesBDOracle;
import com.vector.Utileria.Log;

// TODO: Auto-generated Javadoc
/**
 * Vector México Clase: DAODatosPistaAuditoraImpl.java Descripción: contiene los
 * metedos crear
 * 
 * 
 * Control de Cambios: 17/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 * 
 */
@Service
public class DAODatosPistaAuditoraImpl extends Log implements DAODatosPistaAuditora {
	/**
	 * The jdbc template.
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * The autoin.
	 */
	private AutoIncrementablesBDOracle autoin;

	/**
	 * The formateador.
	 */
	private SimpleDateFormat formateador;
	
	/** The formateador 2. */
	private SimpleDateFormat formateador2;

	/**
	 * The fecha.
	 */
	private String fecha;

	/**
	 * The date.
	 */
	private Date date;

	/** The hora. */
	private String hora;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public int Crear(DatosPistaAuditoraBean datos) {
		info("pista auditora ingresada");
		autoin = new AutoIncrementablesBDOracle();
		date = new Date();
		formateador = new SimpleDateFormat("dd/MM/yy");
		formateador2 = new SimpleDateFormat("HH:mm:ss");

		hora = formateador2.format(date);
		fecha = formateador.format(date);
		int idpista = autoin.PistaIDUltimo(jdbcTemplate);
		// TODO Auto-generated method stub
		final String sql = "insert into tblpistasaudit values (?,?,?,?,?,?,?,?,?)";
		// datos.setContraseña(new Encriptarsha1().Encriptar(datos.getContraseña()));
		int respuesta = jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				debug("datos entrantes para el sql3: IDPISTA[" + idpista + "], IDUSER[" + datos.getIduser()
						+ "], FECHA[" + fecha + "], HORA[" + hora + "], FORMULARIO[" + datos.getFormulario()
						+ "], SISTEMA[" + datos.getSistema() + "], ACCION[" + datos.getAccion() + "], IPEQUIPO["
						+ datos.getIpequipo() + "],STATUS[" + datos.getStatusOp() + "]");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, idpista);
				ps.setLong(2, datos.getIduser());
				ps.setString(3, fecha);
				ps.setString(4, hora);
				ps.setString(5, datos.getFormulario());
				ps.setString(6, datos.getSistema());
				ps.setString(7, datos.getAccion());
				ps.setString(8, datos.getIpequipo());
				ps.setString(9, datos.getStatusOp());

				return ps;
			}
		});
		warn("datos enviados: RESPUESTA[" + respuesta + "]");
		return respuesta;
	}

}

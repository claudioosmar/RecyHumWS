/**
 * 
 */
package com.vector.Utileria;

import org.springframework.jdbc.core.JdbcTemplate;

// TODO: Auto-generated Javadoc
/**
 *   Vector México
 *   Clase: comandoSQL.java
 *   Descripción:  ejecucion en sql automatico al realizar una accion
 *   
 * 
 *   Control de Cambios:
 *  12/10/2018 Jair de Jesus Barcenas Gomez - Creacion
 *   
 */
public class comandoSQL extends Log{
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;
	
/**
 * Clase: ConfirmarCambios
 * Descripcion:
 * Metodo sin valores de retorno.
 */
public void ConfirmarCambios () {
	jdbcTemplate.execute("commit");
	info("se ejecuto commit");
}

/**
 * Clase: DeshacerCambios
 * Descripcion:
 * Metodo sin valores de retorno.
 */
public void DeshacerCambios() {
	jdbcTemplate.execute("rollback");
	info("se ejecuto rollback");
}
}

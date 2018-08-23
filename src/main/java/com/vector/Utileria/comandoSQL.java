/**
 * 
 */
package com.vector.Utileria;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author vectormx
 *
 */
public class comandoSQL {
	private JdbcTemplate jdbcTemplate;
	
public void ConfirmarCambios () {
	jdbcTemplate.execute("commit");
}
public void DeshacerCambios() {
	jdbcTemplate.execute("rollback");
}
}

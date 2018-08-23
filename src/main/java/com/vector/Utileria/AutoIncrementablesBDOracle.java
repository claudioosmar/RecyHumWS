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

/**
 * @author vectormx
 *
 */
public class AutoIncrementablesBDOracle {
	private JdbcTemplate jdbcTemplate;
	int respuesta = 0;
	public int DominioIDUltimo() {

		final String sql = "select max(iduser) from tblusers";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				respuesta = rs.getInt(1);
				return ps;
			}
		});
		return respuesta + 1;
	}

}

/**
 * 
 */
package com.vector.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.vector.Beans.DatosPistaAuditoraBean;
import com.vector.DAO.DAODatosPistaAuditora;

/**
 * @author vectormx
 *
 */
@Service
public class DAODatosPistaAuditoraImpl implements DAODatosPistaAuditora {
@Autowired
private JdbcTemplate jdbctemplate;
	/* (non-Javadoc)
	 * @
	 * see com.vector.DAO.DAOPistaAuditora#agregaracceso(com.vector.Beans.PistaAuditoraBean)
	 */
	@Override
	public String agregaracceso(DatosPistaAuditoraBean datos) {
		// TODO Auto-generated method stub
		final String sql = "execute sp_agregaracceso(?,?,?,?,?,?)";
		
		jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				/*ps.setString(1, datos.);
				ps.setString(2, datos.getContra());
				ResultSet rs = ps.executeQuery();
				rs.next();
				bean.setResp(rs.getString(1));*/
				return ps;
			}
		});
		
		
		return null;
	}

}

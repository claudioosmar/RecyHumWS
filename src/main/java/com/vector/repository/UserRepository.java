/**
 * 
 */
package com.vector.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vector.model.User;

/**
 * @author Claudio
 *
 */
@Repository
public class UserRepository
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return jdbcTemplate.query("select * from tblusers", new UserRowMapper());		
	}

	@Transactional(readOnly=true)
	public User findUserById(int id) {
		return jdbcTemplate.queryForObject("select * from usuario where id=?", new Object[]{id}, new UserRowMapper());
	}
	@Transactional(readOnly=true)
	public User create(final User user) {
		final String sql = "insert into usuario(id,nombre) values(?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {           
                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, user.getId());
                    ps.setString(2, user.getNombre());
                    return ps;
                }
            });
		return user;
	}
	
	public String verificarusuario(User user) {
		User reto = new User(); 
		final String sql = "select fverificar_login(?,?) from dual";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getNombre());
				ps.setString(2, user.getContra());
				ResultSet rs = ps.executeQuery();
				rs.next();
				reto.setVerlogin(rs.getString(1));
				return ps;
			}
		});
		return reto.getVerlogin();
	}
	
}
class UserRowMapper implements RowMapper<User>
{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("iduser"));
		user.setNombre(rs.getString("nombre"));
		user.setStatus(rs.getString("STATUS"));
		return user;
	}
}
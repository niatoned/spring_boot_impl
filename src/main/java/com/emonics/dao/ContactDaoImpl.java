package com.emonics.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.emonics.beans.Contact;

public class ContactDaoImpl implements ContactDao {
	private JdbcTemplate jdbcTemplate;
	
	public ContactDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Contact contact) {
		if(contact.getContact_id() > 0) {
			String sql = "UPDATE contact SET name=?, email=?, address=?, telephone=? "
					+ " WHERE contact_id =?";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), 
					contact.getTelephone(), contact.getContact_id());	
		} else {
			String sql = "INSERT into contact (name, email, address, telephone) "
					+ " VALUES(?, ?, ?, ?)";
			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), 
					contact.getTelephone());
		}

	}

	@Override
	public void delete(int contactId) {
		String sql = "DELETE FROM contact WHERE contact_id=?";
		jdbcTemplate.update(sql, contactId);
	}

	@Override
	public Contact get(int contactId) {
		String sql = "SELECT * FROM contact WHERE contact_id=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Contact contact = new Contact();
					contact.setContact_id(rs.getInt("contact_id"));
					contact.setName(rs.getString("name"));
					contact.setEmail(rs.getString("email"));
					contact.setAddress(rs.getString("address"));
					contact.setTelephone(rs.getString("telephone"));
					return contact;
				}
				return null;
			}
			
		});
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM contact";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Contact.class));
	}

}

package com.data.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PupilJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*Custom Row Mapper | can be used istead of default row mappers*/
	class PupilRowMapper implements RowMapper<Pupil>{

		@Override
		public Pupil mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pupil pupil=new Pupil();
			pupil.setId(rs.getInt("ID"));
			pupil.setName(rs.getString("name"));
			pupil.setLocation(rs.getString("location"));
			pupil.setBirth_date(rs.getDate("birth_date"));
			return pupil;
		}
		
	}
	
	/* get all */	
	public List<Pupil> findAll() {
		String query = "select * from pupil";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper(Pupil.class));
	}

	/* get */
	public Pupil findById(int id) {
		String query = "select * from pupil where id=?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new BeanPropertyRowMapper<Pupil>(Pupil.class));
	}

	/* insert */
	public int insert(Pupil pupil) {
		String query = "insert into pupil(ID, NAME, LOCATION, BIRTH_DATE) values (? ,?, ?, ?)";
		return jdbcTemplate.update(query, new Object[] { pupil.getId(), pupil.getName(), pupil.getLocation(),
				new Timestamp(pupil.getBirth_date().getTime()) });
	}

	/* update */
	public int update(Pupil pupil) {
		String query = "update pupil set  NAME=? , LOCATION=? where id=? ";
		return jdbcTemplate.update(query, new Object[] { pupil.getName(), pupil.getLocation(), pupil.getId() });
	}

	/* delete */
	public int deleteById(int id) {
		String query = "delete from pupil  where id=? ";
		return jdbcTemplate.update(query, new Object[] { id });
	}
}

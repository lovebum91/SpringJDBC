package com.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.jdbc.models.Holiday;

@Service
public class HolidayService implements IHolidayService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Holiday> getAll() {
		String sql = "select * from Request_Holiday";
		List<Holiday> list = jdbcTemplate.query(sql, new RowMapper<Holiday>() {

			@Override
			public Holiday mapRow(ResultSet rs, int rowNum) throws SQLException {
				Holiday hd = new Holiday();
				hd.setHolidayID(rs.getString("holidayID"));
				hd.setDate(rs.getDate("date"));
				hd.setType(rs.getByte("type"));
				hd.setDescription(rs.getString("description"));
				hd.setCompanyID(rs.getString("companyID"));

				return hd;
			}

		});
		return list;

	}
	

	@Override
	public List<Holiday> getAllByStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Holiday findByID(UUID Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(Holiday holiday) {
		// TODO Auto-generated method stub
		var sql = "INSERT INTO Request_Holiday(holidayID, date, type, description, companyID) VALUES (?, ?, ?, ?, ?)";
		Object[] params = new Object[] { holiday.getHolidayID(), holiday.getDate(), holiday.getType(),
				holiday.getDescription(), holiday.getCompanyID() };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void InsertByStore(Holiday holiday) {
		// TODO Auto-generated method stub
		String sql = "{call dbo.Request_Holiday_Insert(?, ?, ?, ?)}";
		Object[] params = new Object[] { holiday.getDate(), holiday.getType(), holiday.getDescription(),
				holiday.getCompanyID() };
		jdbcTemplate.update(sql, params);

	}

	@Override
	public void Update(Holiday holiday) {
		// TODO Auto-generated method stub
		String sql = "update Request_Holiday set date = ?, type =?, description =?, companyID =? where holidayID = ?";
		jdbcTemplate.update(sql, holiday.getDate(), holiday.getType(), holiday.getDescription(), holiday.getCompanyID(),
				holiday.getHolidayID());
	}

	@Override
	public void Delete(String holidayId) {
		// TODO Auto-generated method stub
		String sql = "delete Request_Holiday where holidayID = ?";
		jdbcTemplate.update(sql, holidayId);
	}

}

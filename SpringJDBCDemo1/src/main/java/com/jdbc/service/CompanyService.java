package com.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.jdbc.models.Company;

@Service
public class CompanyService implements ICompanyService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Company findByID(UUID Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company> getAll() {
		String sql = "select * from Common_Company";
		List<Company> list = jdbcTemplate.query(sql, new RowMapper<Company>() {

			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				Company cp = new Company();
				cp.setCompanyID(rs.getString("companyID"));
				cp.setName(rs.getString("name"));
				cp.setCode(rs.getString("code"));
				cp.setLanguage(rs.getString("language"));
				cp.setSortOrder(rs.getInt("sortOrder"));
				cp.setIsActive(rs.getBoolean("isActive"));
				cp.setCalendarKey(rs.getString("calendarKey"));
				cp.setIsApplyEnglishName(rs.getBoolean("isApplyEnglishName"));
				
				return cp;
			}

		});
		return list;
	}

}

package com.jdbc.service;

import java.util.List;
import java.util.UUID;

import com.jdbc.models.Company;

public interface ICompanyService {
	Company findByID(UUID Id);
	List<Company> getAll();
}

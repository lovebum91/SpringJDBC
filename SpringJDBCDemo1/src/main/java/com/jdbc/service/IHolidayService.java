package com.jdbc.service;

import java.util.List;
import java.util.UUID;

import com.jdbc.models.Holiday;

public interface IHolidayService {
	Holiday findByID(UUID Id);
	List<Holiday> getAll();
	List<Holiday> getAllByStore();
	void Insert(Holiday holiday);
	void InsertByStore(Holiday holiday);
	void Update(Holiday holiday);
	void Delete(String holidayId);
}

package com.jdbc.models;

public class Company {

	 private String companyID;
	 private String name;
     private String code;
     private String language;
     private String abbreviation;
     private Integer sortOrder;
     private Boolean isActive;
     private String calendarKey;
     private Boolean isApplyEnglishName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCalendarKey() {
		return calendarKey;
	}

	public void setCalendarKey(String calendarKey) {
		this.calendarKey = calendarKey;
	}

	public Boolean getIsApplyEnglishName() {
		return isApplyEnglishName;
	}

	public void setIsApplyEnglishName(Boolean isApplyEnglishName) {
		this.isApplyEnglishName = isApplyEnglishName;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanyID() {
		return companyID;
	}
	
	public Company() {
		super();
	}
	public Company(String companyID, String name, String code, String language, String abbreviation, Integer sortOrder, Boolean isActive, String calendarKey, Boolean isApplyEnglishName ) {
		super();
		this.companyID = companyID;
		this.name = name;
	     this.code = code;
	     this.language = language;
	     this.abbreviation = abbreviation;
	     this.sortOrder = sortOrder;
	     this.isActive = isActive;
	     this.calendarKey = calendarKey;
	     this.isApplyEnglishName = isApplyEnglishName;
	}
}

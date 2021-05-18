package com.jdbc.models;

import java.util.Date;

	public class Holiday {
		private String holidayID;
		private Date date;
	    private Byte type;
	    private String description;
	    private String companyID;
	    
		public String getHolidayID() {
			return holidayID;
		}

		public void setHolidayID(String holidayID) {
			this.holidayID = holidayID;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Byte getType() {
			return type;
		}

		public void setType(Byte type) {
			this.type = type;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getCompanyID() {
			return companyID;
		}

		public void setCompanyID(String companyID) {
			this.companyID = companyID;
		}

		public Holiday() {
			super();
		}
		public Holiday(String holidayID, Date date, Byte type, String description, String companyID) {
			super();
			this.holidayID = holidayID;
			this.date = date;
			this.type = type;
			this.description = description;
			this.companyID = companyID;
		}
}

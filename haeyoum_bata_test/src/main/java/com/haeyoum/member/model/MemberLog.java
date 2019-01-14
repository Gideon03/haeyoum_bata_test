package com.haeyoum.member.model;

import java.util.Date;

public class MemberLog {
	private String email;
	private Date recent_date;
	
	public MemberLog() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRecent_date() {
		return recent_date;
	}

	public void setRecent_date(Date recent_date) {
		this.recent_date = recent_date;
	}

}

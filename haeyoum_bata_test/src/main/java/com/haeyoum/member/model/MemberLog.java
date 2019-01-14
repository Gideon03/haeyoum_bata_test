package com.haeyoum.member.model;

import java.util.Date;

public class MemberLog {
	private String id;
	private Date recent_date;
	
	public MemberLog() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRecent_date() {
		return recent_date;
	}

	public void setRecent_date(Date recent_date) {
		this.recent_date = recent_date;
	}

}

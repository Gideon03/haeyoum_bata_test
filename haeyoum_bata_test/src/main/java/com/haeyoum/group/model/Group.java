package com.haeyoum.group.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Group {  
	
	private int group_id;
	private String group_name;
	private int group_max;
	private Date group_regdate;
	private String group_admin_id;
	private String group_code;
	private SimpleDateFormat toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Group() {
	}

	public Group(int group_id, String group_name, int group_max, Date group_regdate, String group_admin_id,
			String group_code) {
		this.group_id = group_id;
		this.group_name = group_name;
		this.group_max = group_max;
		this.group_regdate = group_regdate;
		this.group_admin_id = group_admin_id;  
		this.group_code = group_code;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public int getGroup_max() {
		return group_max;
	}

	public void setGroup_max(int group_max) {
		this.group_max = group_max;
	}

	public Date getGroup_regdate() {
		return group_regdate;
	}

	public void setGroup_regdate(Date group_regdate) {
		this.group_regdate = group_regdate;
	}

	public String getGroup_admin_id() {
		return group_admin_id;
	}

	public void setGroup_admin_id(String group_admin_id) {
		this.group_admin_id = group_admin_id;
	}

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}
	
	public String getRegDate() {
		return toDate.format(group_regdate);
	}
	
}

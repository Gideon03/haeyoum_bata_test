package com.haeyoum.group.model;

import java.util.Date;

public class PlanContent {
	
	private int con_id;
	private Date plan_st_time;
	private Date plan_end_time;
	private String plan_name;
	private String plan_text;
	private String plan_writer;
	private Date plan_regdate;
	
	public PlanContent() {
	}

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public Date getPlan_st_time() {
		return plan_st_time;
	}

	public void setPlan_st_time(Date plan_st_time) {
		this.plan_st_time = plan_st_time;
	}

	public Date getPlan_end_time() {
		return plan_end_time;
	}

	public void setPlan_end_time(Date plan_end_time) {
		this.plan_end_time = plan_end_time;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getPlan_text() {
		return plan_text;
	}

	public void setPlan_text(String plan_text) {
		this.plan_text = plan_text;
	}

	public String getPlan_writer() {
		return plan_writer;
	}

	public void setPlan_writer(String plan_writer) {
		this.plan_writer = plan_writer;
	}

	public Date getPlan_regdate() {
		return plan_regdate;
	}

	public void setPlan_regdate(Date plan_regdate) {
		this.plan_regdate = plan_regdate;
	}

}

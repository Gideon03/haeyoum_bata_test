package com.haeyoum.group.model;

public class PlanList {
	
	private int group_id;
	private int con_id;
	private String plan_name;
	private String plan_st_time;
	private String plan_end_time;
	private String Plan_yearMonth;
	private int Plan_day;
	
	public PlanList() {
	}

	public PlanList(int group_id, int con_id, String plan_name, String plan_st_time, String plan_end_time, String plan_yearMonth, int plan_day) {
		super();
		this.plan_name = plan_name;
		this.plan_st_time = plan_st_time;
		this.plan_end_time = plan_end_time;
		Plan_yearMonth = plan_yearMonth;
		Plan_day = plan_day;
		this.group_id = group_id;
		this.con_id = con_id;
		
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public String getPlan_yearMonth() {
		return Plan_yearMonth;
	}
	public void setPlan_yearMonth(String plan_yearMonth) {
		Plan_yearMonth = plan_yearMonth;
	}
	public int getPlan_day() {
		return Plan_day;
	}
	public void setPlan_day(int plan_day) {
		Plan_day = plan_day;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getPlan_st_time() {
		return plan_st_time;
	}
	public void setPlan_st_time(String plan_st_time) {
		this.plan_st_time = plan_st_time;
	}
	public String getPlan_end_time() {
		return plan_end_time;
	}
	public void setPlan_end_time(String plan_end_time) {
		this.plan_end_time = plan_end_time;
	}

}

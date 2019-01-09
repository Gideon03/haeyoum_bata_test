package com.haeyoum.group.model;

public class Plan {
	private int group_id;
	private int sort_id;
	private int con_id;
	private int plan_year;
	private int plan_month;
	private int plan_day;

	public Plan() {
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getSort_id() {
		return sort_id;
	}

	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public int getPlan_year() {
		return plan_year;
	}

	public void setPlan_year(int plan_year) {
		this.plan_year = plan_year;
	}

	public int getPlan_month() {
		return plan_month;
	}

	public void setPlan_month(int plan_month) {
		this.plan_month = plan_month;
	}

	public int getPlan_day() {
		return plan_day;
	}

	public void setPlan_day(int plan_day) {
		this.plan_day = plan_day;
	}

}


package com.haeyoum.group.model;

import java.util.Date;

public class Vote {

	private int group_id;
	private String sort_id;
	private int con_id;
	private String vote_name;
	private String vote_writer;
	private Date vote_startdate;
	private Date vote_enddate;
	
	public Vote() {}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getSort_id() {
		return sort_id;
	}

	public void setSort_id(String sort_id) {
		this.sort_id = sort_id;
	}

	public int getCon_id() {
		return con_id;
	}

	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}

	public String getVote_name() {
		return vote_name;
	}

	public void setVote_name(String vote_name) {
		this.vote_name = vote_name;
	}

	public String getVote_writer() {
		return vote_writer;
	}

	public void setVote_writer(String vote_writer) {
		this.vote_writer = vote_writer;
	}

	public Date getVote_startdate() {
		return vote_startdate;
	}

	public void setVote_startdate(Date vote_startdate) {
		this.vote_startdate = vote_startdate;
	}

	public Date getVote_enddate() {
		return vote_enddate;
	}

	public void setVote_enddate(Date vote_enddate) {
		this.vote_enddate = vote_enddate;
	}
	
}

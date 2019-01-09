package com.haeyoum.group.model;

import java.util.Date;

public class VoteReq {

	private int group_id;
	private String sort_id;
	private int con_id;
	private String vote_name;
	private String vote_writer;
	private String vote_startdate;
	private String vote_enddate;
	
	public VoteReq() {}

	public VoteReq(int group_id, String sort_id, int con_id, String vote_name, String vote_writer,
			String vote_startdate, String vote_enddate) {
		super();
		this.group_id = group_id;
		this.sort_id = sort_id;
		this.con_id = con_id;
		this.vote_name = vote_name;
		this.vote_writer = vote_writer;
		this.vote_startdate = vote_startdate;
		this.vote_enddate = vote_enddate;
	}

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

	public String getVote_startdate() {
		return vote_startdate;
	}

	public void setVote_startdate(String vote_startdate) {
		this.vote_startdate = vote_startdate;
	}

	public String getVote_enddate() {
		return vote_enddate;
	}

	public void setVote_enddate(String vote_enddate) {
		this.vote_enddate = vote_enddate;
	}

	
}

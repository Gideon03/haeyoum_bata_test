package com.haeyoum.group.model;

public class VoteUser {

	private int group_id;
	private int con_id;
	private int vote_list_id;
	private String member_id;
	

	public VoteUser() {}
	
	public VoteUser(int con_id, String member_id) {
		this.con_id = con_id;
		this.member_id = member_id;
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
	public int getVote_list_id() {
		return vote_list_id;
	}
	public void setVote_list_id(int vote_list_id) {
		this.vote_list_id = vote_list_id;
	}
	public String getMember_id() {
		return member_id; 
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


}

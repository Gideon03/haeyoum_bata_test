package com.haeyoum.group.model;

public class VoteUser {

	private int room_id;
	private int vote_id;
	private int list_id;
	private String member_id;
	
	public VoteUser() {}

	public VoteUser(int vote_id, String member_id) {
		this.vote_id = vote_id;
		this.member_id = member_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getVote_id() {
		return vote_id;
	}

	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}

	public int getList_id() {
		return list_id;
	}

	public void setList_id(int list_id) {
		this.list_id = list_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
}

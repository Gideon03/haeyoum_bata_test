package com.haeyoum.room.model;

public class VoteContent {

	private int room_id;
	private int vote_id;
	private int list_id;
	private String content;
	
	public VoteContent() {}

	public VoteContent(int room_id, int vote_id, String content) {
		this.room_id = room_id;
		this.vote_id = vote_id;
		this.content = content;
	}

	public VoteContent(int room_id, int vote_id, int list_id, String content) {
		this.room_id = room_id;
		this.vote_id = vote_id;
		this.list_id = list_id;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

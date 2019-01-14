package com.haeyoum.room.model;

public class VoteResult {

	private int room_id;
	private int vote_id;
	private int list_id;
	private String content;
	private int voteCount;

	public VoteResult() {
	}

	public VoteResult(int room_id, int vote_id, int list_id, String content, int voteCount) {
		this.room_id = room_id;
		this.vote_id = vote_id;
		this.list_id = list_id;
		this.content = content;
		this.voteCount = voteCount;
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

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

}

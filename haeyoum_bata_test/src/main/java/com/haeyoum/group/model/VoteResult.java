package com.haeyoum.group.model;

public class VoteResult {

	private int group_id;
	private int con_id;
	private int vote_list_id;
	private String vote_list;
	private int voteCount;

	public VoteResult() {
	}

	public VoteResult(int group_id, int con_id, int vote_list_id, String vote_list, int voteCount) {
		super();
		this.group_id = group_id;
		this.con_id = con_id;
		this.vote_list_id = vote_list_id;
		this.vote_list = vote_list;
		this.voteCount = voteCount;
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

	public String getVote_list() {
		return vote_list;
	}

	public void setVote_list(String vote_list) {
		this.vote_list = vote_list;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

}

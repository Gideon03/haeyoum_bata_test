package com.haeyoum.room.model;

public class VoteReq {

	private int room_id;
	private int sort_id;
	private int vote_id;
	private String title;
	private String writer;
	private String start_date;
	private String end_date;
	
	public VoteReq() {}
	
	public VoteReq(int room_id, int sort_id, int vote_id, String title, String writer, String start_date,
			String end_date) {
		this.room_id = room_id;
		this.sort_id = sort_id;
		this.vote_id = vote_id;
		this.title = title;
		this.writer = writer;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getSort_id() {
		return sort_id;
	}

	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}

	public int getVote_id() {
		return vote_id;
	}

	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	

}

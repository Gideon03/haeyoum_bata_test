package com.haeyoum.group.model;

public class ChatReq {

	private int room_id;
	private int chat_id;
	private String member_id;
	private String content;
	private String send_date;
	
	public ChatReq() {
	}

	public ChatReq(int room_id, int chat_id, String member_id, String content, String send_date) {
		this.room_id = room_id;
		this.chat_id = chat_id;
		this.member_id = member_id;
		this.content = content;
		this.send_date = send_date;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSend_date() {
		return send_date;
	}

	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}

}

package com.haeyoum.group.model;

public class ChatReq {

	private int group_id;
	private int chat_id;
	private String member_id;
	private String message_text;
	private String message_senddate;
	
	public ChatReq() {
	}

	public ChatReq(int group_id, int chat_id, String member_id, String message_text, String message_senddate) {
		this.group_id = group_id;
		this.chat_id = chat_id;
		this.member_id = member_id;
		this.message_text = message_text;
		this.message_senddate = message_senddate;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
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

	public String getMessage_text() {
		return message_text;
	}

	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	public String getMessage_senddate() {
		return message_senddate;
	}

	public void setMessage_senddate(String message_senddate) {
		this.message_senddate = message_senddate;
	}

}

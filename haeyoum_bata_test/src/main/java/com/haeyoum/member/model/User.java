package com.haeyoum.member.model;

public class User {

	private String member_id;
	private boolean login = false;
	private int room_id = 0;

	public User() {
	}

	public User(String member_id, boolean login) {
		this.member_id = member_id;
		this.login = login;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

}

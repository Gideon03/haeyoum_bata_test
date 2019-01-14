package com.haeyoum.member.model;

public class User {

	private String member_id;
	private boolean login = false;
	private int group_id = 0;

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

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

}

package com.haeyoum.member.model;

public class User {

	private String member_id;
	private boolean Login = false;
	private int group_id = 0;

	public User() {
	}

	public User(String member_id, boolean login) {
		this.member_id = member_id;
		Login = login;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public boolean isLogin() {
		return Login;
	}

	public void setLogin(boolean login) {
		Login = login;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

}

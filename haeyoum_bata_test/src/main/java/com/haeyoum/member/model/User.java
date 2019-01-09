package com.haeyoum.member.model;

public class User {

	private String m_email;
	private boolean Login = false;
	private int group_id = 0;

	public User() {
	}

	public User(String member_id, boolean login) {
		this.m_email = member_id;
		Login = login;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
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

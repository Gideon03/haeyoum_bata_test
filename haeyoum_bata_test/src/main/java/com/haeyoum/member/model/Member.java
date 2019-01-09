package com.haeyoum.member.model;

public class Member {
	private String m_email;
	private String m_password;
	private String m_name;
	private String m_authkey;
	private int m_activation;
	private int m_role;
	
	public Member() {
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_authkey() {
		return m_authkey;
	}

	public void setM_authkey(String m_authkey) {
		this.m_authkey = m_authkey;
	}

	public int getM_activation() {
		return m_activation;
	}

	public void setM_activation(int m_activation) {
		this.m_activation = m_activation;
	}

	public int getM_role() {
		return m_role;
	}

	public void setM_role(int m_role) {
		this.m_role = m_role;
	}
	
}

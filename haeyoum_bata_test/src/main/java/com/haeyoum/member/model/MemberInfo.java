package com.haeyoum.member.model;

public class MemberInfo {				
				
	private String m_email;			
	private String m_image;			
	private String m_phone;			
				
	public MemberInfo() {			
	}
	
	public MemberInfo(String m_email) {
		this.m_email = m_email;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_image() {
		return m_image;
	}

	public void setM_image(String m_image) {
		this.m_image = m_image;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}			

}				
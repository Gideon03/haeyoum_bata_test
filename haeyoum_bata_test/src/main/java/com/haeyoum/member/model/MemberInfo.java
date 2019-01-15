package com.haeyoum.member.model;

public class MemberInfo {				
	private String email;
	private String image;			
	private String phone;			
				
	public MemberInfo() {			
	}
	
	public MemberInfo(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}				
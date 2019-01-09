package com.haeyoum.m.model;

public class MemberRestModel {
	
	private String member_id;			
	private String member_password;
	private String member_name;			
	private String member_nick_name;			
	private String member_email;			
	private String member_birthday;
	
	public MemberRestModel() {
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_nick_name() {
		return member_nick_name;
	}
	public void setMember_nick_name(String member_nickname) {
		this.member_nick_name = member_nickname;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_birthday() {
		return member_birthday;
	}
	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}
}


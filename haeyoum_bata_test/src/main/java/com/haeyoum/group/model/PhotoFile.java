package com.haeyoum.group.model;

public class PhotoFile {
	
	private int group_id;
	private int con_id;
	private String photo_file;
	
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int photo_con_id) {
		this.con_id = photo_con_id;
	}
	public String getPhoto_file() {
		return photo_file;
	}
	public void setPhoto_file(String photo_file) {
		this.photo_file = photo_file;
	}

}

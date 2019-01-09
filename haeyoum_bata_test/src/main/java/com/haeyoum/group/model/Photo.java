package com.haeyoum.group.model;

import java.util.Date;

public class Photo {
	private int group_id;
	private int sort_id;
	private int con_id;
	private String photo_name;
	private String photo_file;
	private String photo_text;
	private String photo_writer;
	private Date photo_regdate;
	private Date photo_moddate;

	public Photo() {
	}
	public String getPhoto_file() {
		return photo_file;
	}
	public void setPhoto_file(String photo_file) {
		this.photo_file = photo_file;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getSort_id() {
		return sort_id;
	}
	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getPhoto_text() {
		return photo_text;
	}
	public void setPhoto_text(String photo_text) {
		this.photo_text = photo_text;
	}
	public String getPhoto_writer() {
		return photo_writer;
	}
	public void setPhoto_writer(String photo_writer) {
		this.photo_writer = photo_writer;
	}
	public Date getPhoto_regdate() {
		return photo_regdate;
	}
	public void setPhoto_regdate(Date photo_regdate) {
		this.photo_regdate = photo_regdate;
	}
	public Date getPhoto_moddate() {
		return photo_moddate;
	}
	public void setPhoto_moddate(Date photo_moddate) {
		this.photo_moddate = photo_moddate;
	}
}

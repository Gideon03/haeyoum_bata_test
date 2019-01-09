package com.haeyoum.group.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
	
	private int group_id;
	private int sort_id;
	private int con_id;
	private String note_name;
	private String note_text;
	private String note_writer;
	private Date note_regdate;
	private Date note_moddate;
	private int note_readcount;
	private SimpleDateFormat toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Note() {
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
	public String getNote_name() {
		return note_name;
	}
	public void setNote_name(String note_name) {
		this.note_name = note_name;
	}
	public String getNote_text() {
		return note_text;
	}
	public void setNote_text(String note_text) {
		this.note_text = note_text;
	}
	public String getNote_writer() {
		return note_writer;
	}
	public void setNote_writer(String note_writer) {
		this.note_writer = note_writer;
	}
	public Date getNote_regdate() {
		return note_regdate;
	}
	public void setNote_regdate(Date note_regdate) {
		this.note_regdate = note_regdate;
	}
	public Date getNote_moddate() {
		return note_moddate;
	}
	public void setNote_moddate(Date note_moddate) {
		this.note_moddate = note_moddate;
	}
	public int getNote_readcount() {
		return note_readcount;
	}
	public void setNote_readcount(int note_readcount) {
		this.note_readcount = note_readcount;
	}
	
	public String getRegDate() {
		return toDate.format(note_regdate);
	}
	
	
}

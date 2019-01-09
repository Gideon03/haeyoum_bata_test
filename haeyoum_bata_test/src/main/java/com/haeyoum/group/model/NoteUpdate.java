package com.haeyoum.group.model;

public class NoteUpdate {
	
	private int con_id;
	private String note_name;
	private String note_text;

	public NoteUpdate() {
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
	
}

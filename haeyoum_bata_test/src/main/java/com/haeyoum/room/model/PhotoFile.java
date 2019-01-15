package com.haeyoum.room.model;

public class PhotoFile {
	
	private int room_id;
	private int photo_id;
	private String photo_file;

	public PhotoFile() {
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public String getPhoto_file() {
		return photo_file;
	}

	public void setPhoto_file(String photo_file) {
		this.photo_file = photo_file;
	}
	
}

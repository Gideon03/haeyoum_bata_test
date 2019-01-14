package com.haeyoum.room.model;

import java.util.Date;

public class Room {  
	
	private int room_id;
	private String title;
	private int max;
	private String room_master;
	private String roomkey;
	private Date regdate;

	public Room() {
	}

	public Room(int room_id, String title, int max, String room_master, String roomkey, Date regdate) {
		this.room_id = room_id;
		this.title = title;
		this.max = max;
		this.room_master = room_master;
		this.roomkey = roomkey;
		this.regdate = regdate;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getRoom_master() {
		return room_master;
	}

	public void setRoom_master(String room_master) {
		this.room_master = room_master;
	}

	public String getRoomkey() {
		return roomkey;
	}

	public void setRoomkey(String roomkey) {
		this.roomkey = roomkey;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}

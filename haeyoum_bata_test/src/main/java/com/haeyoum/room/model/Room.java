package com.haeyoum.room.model;

import java.util.Date;

public class Room {  
	
	private int id;
	private String room_name;
	private int max;
	private String room_master;
	private String roomkey;
	private Date regdate;

	public Room() {
	}

	public Room(int id, String room_name, int max, String room_master, String roomkey, Date regdate) {
		super();
		this.id = id;
		this.room_name = room_name;
		this.max = max;
		this.room_master = room_master;
		this.roomkey = roomkey;
		this.regdate = regdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
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

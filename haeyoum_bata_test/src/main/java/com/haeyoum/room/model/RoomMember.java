package com.haeyoum.room.model;

public class RoomMember {
	
	private int room_id;
	private String member_id;

	public RoomMember() {
	}

	public RoomMember(int room_id, String member_id) {
		super();
		this.room_id = room_id;
		this.member_id = member_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

}

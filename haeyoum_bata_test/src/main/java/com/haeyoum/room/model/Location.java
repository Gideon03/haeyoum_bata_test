package com.haeyoum.room.model;

public class Location {
	
	private int room_id;
	private int sort_id;
	private int photo_id;
	private int video_id;
	private String map_longitude;
	private String map_latitude;
	
	public Location() {
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getSort_id() {
		return sort_id;
	}

	public void setSort_id(int sort_id) {
		this.sort_id = sort_id;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public String getMap_longitude() {
		return map_longitude;
	}

	public void setMap_longitude(String map_longitude) {
		this.map_longitude = map_longitude;
	}

	public String getMap_latitude() {
		return map_latitude;
	}

	public void setMap_latitude(String map_latitude) {
		this.map_latitude = map_latitude;
	}
	
}

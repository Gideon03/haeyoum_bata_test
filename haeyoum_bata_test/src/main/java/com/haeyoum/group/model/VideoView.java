package com.haeyoum.group.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoView {

	private int group_id;
	private int sort_id;
	private int con_id;
	private String video_name;
	private String video_file;
	private String video_text;
	private String video_writer;
	private Date video_regdate;
	private Date video_moddate;
	private String map_longitude;
	private String map_latitude;
	private SimpleDateFormat toDate = new SimpleDateFormat("yy년MM월dd일 HH시mm분");

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
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_file() {
		return video_file;
	}
	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}
	public String getVideo_text() {
		return video_text;
	}
	public void setVideo_text(String video_text) {
		this.video_text = video_text;
	}
	public String getVideo_writer() {
		return video_writer;
	}
	public void setVideo_writer(String video_writer) {
		this.video_writer = video_writer;
	}
	public Date getVideo_regdate() {
		return video_regdate;
	}
	public void setVideo_regdate(Date video_regdate) {
		this.video_regdate = video_regdate;
	}
	public Date getVideo_moddate() {
		return video_moddate;
	}
	public void setVideo_moddate(Date video_moddate) {
		this.video_moddate = video_moddate;
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
	
	public String getRegDate() {
		return toDate.format(video_regdate);
	}
	public String getModDate() {
		return toDate.format(video_moddate);
	}
	
}

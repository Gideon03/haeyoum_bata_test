package com.haeyoum.group.model;

import java.util.Date;

public class Plannew {
		
		private int group_id;
		private int con_id;
		private String plan_name;
		private String plan_text;
		private String plan_st_time;
		private String plan_end_time;
		
		
		public Plannew() {
		}
		
		public Plannew(int group_id, int con_id, String plan_name, String plan_text, String plan_st_time,
				String plan_end_time) {
			super();
			this.group_id = group_id;
			this.con_id = con_id;
			this.plan_name = plan_name;
			this.plan_text = plan_text;
			this.plan_st_time = plan_st_time;
			this.plan_end_time = plan_end_time;
		}

		public int getGroup_id() {
			return group_id;
		}

		public void setGroup_id(int group_id) {
			this.group_id = group_id;
		}

		public int getCon_id() {
			return con_id;
		}

		public void setCon_id(int con_id) {
			this.con_id = con_id;
		}

		public String getPlan_name() {
			return plan_name;
		}
		public void setPlan_name(String plan_name) {
			this.plan_name = plan_name;
		}
		public String getPlan_text() {
			return plan_text;
		}
		public void setPlan_text(String plan_text) {
			this.plan_text = plan_text;
		}
		public String getPlan_st_time() {
			return plan_st_time;
		}
		public void setPlan_st_time(String plan_st_time) {
			this.plan_st_time = plan_st_time;
		}
		public String getPlan_end_time() {
			return plan_end_time;
		}
		public void setPlan_end_time(String plan_end_time) {
			this.plan_end_time = plan_end_time;
		}

		
		
		
}

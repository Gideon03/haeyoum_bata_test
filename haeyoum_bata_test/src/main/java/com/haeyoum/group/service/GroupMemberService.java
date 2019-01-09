package com.haeyoum.group.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.group.model.GroupMember;
import com.haeyoum.group.repository.GroupMemberDAO;

@Service
public class GroupMemberService {
	
	@Autowired
	private GroupMemberDAO GMDAO;
	
	public int insertGroupMember(int group_id, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);
		map.put("group_member_id", member_id);
		return GMDAO.insertGroupMember(map);
	}
	
	public List<GroupMember> getGroupMember(int group_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);
		return GMDAO.getGroupMember(map);
	}
	
	public int confirmGroupMember(int group_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);
		return GMDAO.confirmGroupMember(map);
	}
	
	public int countGroupMember(int group_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);
		return GMDAO.countGroupMember(map);
	}
	
}

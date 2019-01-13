package com.haeyoum.group.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.group.model.Room;
import com.haeyoum.group.model.RoomList;
import com.haeyoum.group.repository.GroupDAO;

@Service
public class GroupService {
	
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private GroupMemberService groupMemberSvc;
	
	@Transactional
	public Room createGroup(Room group) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = groupDAO.insertGroup(group);
		if (result != 0) {
			groupMemberSvc.insertGroupMember(group.getId(), group.getRoom_master());
			map.put("group_id", group.getId());
			group = groupDAO.selectGroup(map);
		}
		return group;
	}
	
	public Room selectGroup(int group_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);
		return groupDAO.selectGroup(map);
	}
	
	public int confirmGroup(String conCode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("conCode", conCode);
		return groupDAO.confirmCode(map);
	}
	 
	public List<RoomList> groupList(int stPage, String member_id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stPage", stPage);
		map.put("member_id", member_id);
		return groupDAO.groupList(map);
	}
	
	public Room inviteGroup(String reqCode, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_code", reqCode);
		map.put("group_member_id", member_id);
		return groupDAO.inviteGroup(map);
	}

}

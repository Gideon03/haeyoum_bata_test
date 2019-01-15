package com.haeyoum.room.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.room.model.Room;
import com.haeyoum.room.model.RoomList;
import com.haeyoum.room.repository.GroupDAO;

@Service
public class RoomService {
	
	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private RoomMemberService groupMemberSvc;
	
	@Transactional
	public Room createGroup(Room room) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = groupDAO.insertGroup(room);
		if (result != 0) {
			groupMemberSvc.insertGroupMember(room.getRoom_id(), room.getRoom_master());
			map.put("room_id", room.getRoom_id());
			room = groupDAO.selectGroup(map);
		}
		return room;
	}
	
	public Room selectGroup(int room_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("room_id", room_id);
		return groupDAO.selectGroup(map);
	}
	
	public int confirmGroup(String roomkey) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roomkey", roomkey);
		return groupDAO.confirmCode(map);
	}
	 
	public List<RoomList> groupList(int stPage, String member_id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stPage", stPage);
		map.put("member_id", member_id);
		return groupDAO.groupList(map);
	}
	
	public Room inviteGroup(String roomkey, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roomkey", roomkey);
		map.put("member_id", member_id);
		return groupDAO.inviteGroup(map);
	}

}

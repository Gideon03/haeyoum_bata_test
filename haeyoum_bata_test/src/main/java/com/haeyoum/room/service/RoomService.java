package com.haeyoum.room.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.room.model.Room;
import com.haeyoum.room.model.RoomList;
import com.haeyoum.room.repository.RoomDAO;

@Service
public class RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	@Autowired
	private RoomMemberService roomMemberSvc;
	
	@Transactional
	public Room createRoom(Room room) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int result = roomDAO.insertRoom(room);
		if (result != 0) {
			roomMemberSvc.insertRoomMember(room.getRoom_id(), room.getRoom_master());
			map.put("room_id", room.getRoom_id());
			room = roomDAO.selectRoom(map);
		}
		return room;
	}
	
	public Room selectRoom(int room_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("room_id", room_id);
		return roomDAO.selectRoom(map);
	}
	
	public int confirmKey(String roomkey) {
		return roomDAO.confirmKey(roomkey);
	}
	 
	public List<RoomList> roomList(int stPage, String member_id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stPage", stPage);
		map.put("member_id", member_id);
		return roomDAO.roomList(map);
	}
	
	public Room inviteRoom(String roomkey, String member_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roomkey", roomkey);
		map.put("member_id", member_id);
		return roomDAO.inviteRoom(map);
	}

}

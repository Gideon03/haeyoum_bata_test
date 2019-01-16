package com.haeyoum.room.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.room.model.Room;
import com.haeyoum.room.model.RoomList;
import com.haeyoum.room.model.RoomMember;
import com.haeyoum.room.repository.RoomDAO;
import com.haeyoum.room.repository.RoomMemberDAO;

@Service
public class RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	@Autowired
	private RoomMemberDAO GMDAO;
	
	@Transactional
	public Room createRoom(Room room) {
		
		int result = roomDAO.insertRoom(room);
		if (result != 0) {
			room = roomDAO.selectRoom(room.getRoom_id());
			
			RoomMember rm = new RoomMember(room.getRoom_id(), room.getRoom_master());
			GMDAO.insertRoomMember(rm);
		}
		return room;
	}
	
	public Room selectRoom(int room_id) {
		Room room = null;
		try {
			room = roomDAO.selectRoom(room_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room;
	}
	
	public int confirmKey(String roomkey) {
		int confirm = 0;
		try {
			confirm = roomDAO.confirmKey(roomkey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return confirm;
	}
	 
	public List<RoomList> roomList(int stPage, String member_id){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stPage", stPage);
		map.put("member_id", member_id);
		
		List<RoomList> list = null;
		try {
			list = roomDAO.roomList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Room inviteRoom(String roomkey) {
		
		Room room = null;
		try {
			room = roomDAO.inviteRoom(roomkey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return room;
	}

}

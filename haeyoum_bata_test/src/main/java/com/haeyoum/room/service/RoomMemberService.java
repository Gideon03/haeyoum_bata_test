package com.haeyoum.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.room.model.RoomMember;
import com.haeyoum.room.repository.RoomMemberDAO;

@Service
public class RoomMemberService {
	
	@Autowired
	private RoomMemberDAO GMDAO;
	
	public int insertRoomMember(int room_id, String member_id) {
		RoomMember rm = new RoomMember(room_id, member_id);
		return GMDAO.insertRoomMember(rm);
	}
	
	public List<RoomMember> getRoomMember(int room_id) {
		return GMDAO.getRoomMember(room_id);
	}
	
	public int confirmRoomMember(int room_id, String member_id) {
		RoomMember rm = new RoomMember(room_id, member_id);
		return GMDAO.confirmRoomMember(rm);
	}
	
	public int countRoomMember(int room_id) {
		return GMDAO.countRoomMember(room_id);
	}
	
}

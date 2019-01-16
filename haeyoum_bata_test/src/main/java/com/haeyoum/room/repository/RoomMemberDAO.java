package com.haeyoum.room.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.room.model.RoomMember;

@Repository
public class RoomMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strName = "room.model.RoomMemberMapper";
	
	public int insertRoomMember(RoomMember roomMember) {
		return sqlSession.insert(strName + ".insertRoomMember", roomMember);
	}
	
	public List<RoomMember> getRoomMember(int room_id) {
		return sqlSession.selectList(strName + ".selectRoomMember", room_id);
	}
	
	public int confirmRoomMember(RoomMember roomMember) {
		return sqlSession.selectOne(strName + ".confirmRoomMember", roomMember);
	}
	
	public int countRoomMember(int room_id) {
		return sqlSession.selectOne(strName + ".countRoomMember", room_id);
	}

}

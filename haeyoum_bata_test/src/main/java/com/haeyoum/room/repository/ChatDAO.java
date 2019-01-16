package com.haeyoum.room.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.room.model.Chat;

@Repository
public class ChatDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strName = "room.model.ChatMapper";

	public int insertChat(Chat chat) {
		int result=0;
		try {
			result =sqlSession.insert(strName + ".insertMsg" , chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Chat> chatList(int room_id) {
		return sqlSession.selectList(strName + ".msgList", room_id);
	} 
	
	public Chat selectChat(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".selectMsg", map);
	}
	
}

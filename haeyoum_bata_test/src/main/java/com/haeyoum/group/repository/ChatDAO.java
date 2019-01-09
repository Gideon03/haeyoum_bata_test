package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Chat;
import com.haeyoum.group.model.Group;
import com.haeyoum.group.model.GroupList;

@Repository
public class ChatDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strName = "group.model.ChatMapper";

	public int insertChat(Chat chat) {
		int result=0;
		try {
			result =sqlSession.insert(strName + ".insertMsg" , chat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Chat> chatList(HashMap<String, Object> map) {
		return sqlSession.selectList(strName + ".msgList", map);
	} 
	
	public Chat selectChat(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".selectMsg", map);
	}
	
}

package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Room;
import com.haeyoum.group.model.RoomList;

@Repository
public class GroupDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strName = "group.model.GroupMapper";

	public int insertGroup(Room group) {
		return sqlSession.insert(strName + ".insertGroup" , group);
	}
	
	public List<RoomList> groupList(HashMap<String, Object> map) {
		return sqlSession.selectList(strName + ".groupList", map);
	} 
	
	public int confirmCode(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".confirmCode" , map);
	}
	
	public Room selectGroup(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".selectGroup", map);
	}
	
	public Room inviteGroup(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".inviteGroup", map);
	}

}

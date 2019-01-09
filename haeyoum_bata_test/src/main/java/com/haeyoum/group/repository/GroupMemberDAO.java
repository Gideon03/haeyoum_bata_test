package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.GroupMember;

@Repository
public class GroupMemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strName = "group.model.GroupMemberMapper";
	
	public int insertGroupMember(HashMap<String, Object> map) {
		return sqlSession.insert(strName + ".insertGroupMember", map);
	}
	
	public List<GroupMember> getGroupMember(HashMap<String, Object> map) {
		return sqlSession.selectList(strName + ".selectGroupMember", map);
	}
	
	public int confirmGroupMember(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".confirmGroupMember", map);
	}
	
	public int countGroupMember(HashMap<String, Object> map) {
		return sqlSession.selectOne(strName + ".countGroupMember", map);
	}

}

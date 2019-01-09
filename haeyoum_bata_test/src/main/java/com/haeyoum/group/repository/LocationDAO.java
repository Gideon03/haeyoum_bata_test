package com.haeyoum.group.repository;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Location;


@Repository
public class LocationDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strNameSpace = "group.model.LocationMapper";
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(HashMap<String, Object> map) {
		return sqlSession.insert(strNameSpace + ".insert", map);
	}
	public int videoDelete(Location location) {
		return sqlSession.delete(strNameSpace + ".videodelete", location);
	}
	public int photoDelete(Location location) {
		return sqlSession.delete(strNameSpace + ".photodelete", location);
	}
	public int videoUpdate(HashMap<String, Object> map) {
		return sqlSession.update(strNameSpace+".videoupdate",map);
	}
	public int photoUpdate(HashMap<String, Object> map) {
		return sqlSession.update(strNameSpace+".photoupdate",map);
	}
}

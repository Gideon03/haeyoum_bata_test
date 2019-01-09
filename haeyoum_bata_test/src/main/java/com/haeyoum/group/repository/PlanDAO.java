package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Plan;
import com.haeyoum.group.model.PlanContent;



@Repository
public class PlanDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strNameSpace = "group.model.PlanMapper";
	
	// ---------------------- create plan --------------------------------
	public int createPlan(Plan plan) {
		return sqlSession.insert(strNameSpace + ".insertPlan", plan);
	}
	public int createPlanContent(PlanContent planCon) {
		return sqlSession.insert(strNameSpace + ".insertPlanCon", planCon);
	}
	
	public List<Plan> select(HashMap<String, Object> map) {
		return sqlSession.selectList(strNameSpace + ".select", map);
	}
	public int getRecordCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(strNameSpace + ".count", map);
	}
	public int update(Plan plan) {
		return sqlSession.update(strNameSpace + ".update", plan);
	}
	public Plan selectupdate(HashMap<String, Object> map) {
		return sqlSession.selectOne(strNameSpace + ".selectupdate", map);
	}
	public int plandelete(HashMap<String, Object> map) {
		return sqlSession.delete(strNameSpace + ".plandelete", map);
	}
	
}
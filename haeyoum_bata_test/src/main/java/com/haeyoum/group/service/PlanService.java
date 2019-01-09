package com.haeyoum.group.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.group.model.Plan;
import com.haeyoum.group.model.PlanContent;
import com.haeyoum.group.repository.PlanDAO;



@Service
public class PlanService {
	
	@Autowired
	private PlanDAO planDAO;
	
	// ---------------------- create plan --------------------------------
	public int createPlan(Plan plan) {
		return planDAO.createPlan(plan);
	} 
	
	public int createPlanContent(PlanContent planCon) {
		return planDAO.createPlanContent(planCon);
	}
	
	/*public List<Plan> select(String yearMonth, int group_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("strToday", yearMonth);
		map.put("group_id", group_id);
		return dao.select(map);
	}*/
	
}
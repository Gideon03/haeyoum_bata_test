package com.haeyoum.room.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.member.model.User;
import com.haeyoum.room.model.Plan;
import com.haeyoum.room.model.PlanList;
import com.haeyoum.room.model.Plannew;
import com.haeyoum.room.service.PlanService;
import com.haeyoum.util.DateUtil;

@Controller
@SessionAttributes("user")
@RequestMapping("/group/plan")
public class PlanController {

	private final String PLANNER = "plan/plan";
	
	@Autowired
	private PlanService planSvc;
	private DateUtil dateUtil = new DateUtil();

	@RequestMapping("/planList")
	public String planList3(@ModelAttribute("user") User user, Model model) {
		return PLANNER;
	}
	/*
	@ResponseBody
	@RequestMapping("/scheduleData")
	public Map<String, List<PlanList>> ScheData(@RequestParam("ym")String ym, 
			@ModelAttribute("user") LoginUser user) {
		
		List<Plan> plan = planSvc.select(ym, user.getGroup_id());
				
		List<PlanList> planlist = new ArrayList<PlanList>();
		for( Plan p : plan) {
			planlist.add(
					new PlanList(
							p.getGroup_id(),
							p.getCon_id(),
							p.getPlan_name(), 
							dateUtil.convertTime(p.getPlan_st_time()),
							dateUtil.convertTime(p.getPlan_end_time()),
							p.getPlan_yearMonth(),
							p.getPlan_day()));
		}
		
		Map<String, List<PlanList>> planmap = new HashMap<String, List<PlanList>>();
		
		planmap.put("schedule", planlist );
		
		return planmap;
	}
	
	@RequestMapping(value = "/scheduleForm", method = RequestMethod.GET)
	public String planInsert(@ModelAttribute("user") LoginUser user, 
			@RequestParam("yearMonth") String plan_yearMonth,
			@RequestParam("day")int plan_day, Model model,
			Plan plan) {
		
		String plan_st_date = plan_yearMonth + "-" + plan_day;
		System.out.println("get방식 date : " + plan_st_date);
		model.addAttribute("srt3", plan_day);
		model.addAttribute("srt2", plan_yearMonth);
		model.addAttribute("srt", plan_st_date);
		return "plan/planInsertForm";
	}

	@RequestMapping(value = "/scheduleForm", method = RequestMethod.POST)
	public String planInsert(@ModelAttribute("user") LoginUser user, Plan plan, Model model) {
			if (plan.getPlan_st_date() == null) {
			return "plan/plan3";
		}
		plan.setGroup_id(user.getGroup_id());
		plan.setPlan_writer(user.getMember_id());

		planSvc.insert(plan);
		return "plan/result";
	}
	
	@RequestMapping(value = "/planUpdateForm", method = RequestMethod.GET)
	public String planUpdate(@ModelAttribute("user") LoginUser user, HttpServletRequest httpServletRequest, Model model,
			Plan plan) {
		
		int con_id = Integer.parseInt(httpServletRequest.getParameter("con_id"));
		int group_id = Integer.parseInt(httpServletRequest.getParameter("group_id"));
		
		String plan_yearMonth = httpServletRequest.getParameter("yearMonth");
		int plan_day = Integer.parseInt(httpServletRequest.getParameter("day"));
		
		String plan_st_date = plan_yearMonth + "-" + plan_day;
		
		model.addAttribute("con_id", con_id);
		model.addAttribute("group_id", group_id);
		model.addAttribute("srt", plan_st_date);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("con_id", con_id);
		map.put("group_id", group_id);
		
		plan = planSvc.selectupdate(map);
		
		Plannew plannew = new Plannew(plan.getCon_id(), plan.getGroup_id(), plan.getPlan_name(), plan.getPlan_text(),
				dateUtil.convertTime(plan.getPlan_st_time()), dateUtil.convertTime(plan.getPlan_end_time()));
		model.addAttribute("plan", plannew);
		
		return "plan/planUpdateForm";
	}
	
	@RequestMapping(value = "/planUpdateForm", method = RequestMethod.POST)
	public String planUpdate(@ModelAttribute("user") LoginUser user, Plan plan, Model model) {
		 
		planSvc.update(plan);
	
		return "plan/resultUpdate";
	}
	 
	@RequestMapping(value = "/planDelete", method = RequestMethod.GET)
	public String planDelete(@ModelAttribute("user") LoginUser user, HttpServletRequest httpServletRequest, Model model,
			Plan plan) {
		
		int con_id = Integer.parseInt(httpServletRequest.getParameter("con_id"));
		int group_id = Integer.parseInt(httpServletRequest.getParameter("group_id"));

		model.addAttribute("con_id", con_id);
		model.addAttribute("group_id", group_id);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("con_id", con_id);
		map.put("group_id", group_id);
		
		planSvc.plandelete(map);
		
		return "plan/plan3";
	}*/
		
}
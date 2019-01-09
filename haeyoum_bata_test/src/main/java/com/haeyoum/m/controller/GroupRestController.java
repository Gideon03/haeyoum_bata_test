package com.haeyoum.m.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.group.model.GroupList;
import com.haeyoum.group.service.GroupMemberService;
import com.haeyoum.group.service.GroupService;
import com.haeyoum.member.model.User;

@RestController
@RequestMapping("/m")
@SessionAttributes("user")
public class GroupRestController {
	
	@Autowired
	private GroupService groupSvc;
	@Autowired
	private GroupMemberService groupMemberSvc;
	
	@RequestMapping("/groupList")
	public String groupList(@ModelAttribute("user") User user, Model model,HttpSession session,GroupList groupList) {
		user.setGroup_id(0);
		int stPage = 0;
		groupList.setGroup_id(user.getGroup_id());
		
		List<GroupList> list = groupSvc.groupList(stPage, user.getM_email());
	
		model.addAttribute("groupList", list);
		
		String strJson = null;
		return strJson;
		
	}
	
	
	@RequestMapping("/iphone/groupList")
	public List<GroupList> groupList() {

		List<GroupList> list = new ArrayList<GroupList>();
		
		for (int i = 1 ; i <= 100 ; i++) {
			GroupList group = new GroupList();
			group.setGroup_id(i);
			group.setGroup_name("group_" + i);
			list.add(group);
		}
		
		return list;
	}
	
	
	
	
	
}
















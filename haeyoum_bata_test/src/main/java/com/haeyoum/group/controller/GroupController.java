package com.haeyoum.group.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.group.model.Group;
import com.haeyoum.group.model.GroupList;
import com.haeyoum.group.model.GroupMember;
import com.haeyoum.group.service.GroupMemberService;
import com.haeyoum.group.service.GroupService;
import com.haeyoum.member.model.User;

@Controller
@RequestMapping("/group")
@SessionAttributes("user")

public class GroupController {

	private final String GROUP_FORM = "group/groupRegForm";
	private final String GROUP_CONFIRM = "group/groupConfirm";
	private final String GROUP_LIST = "group/groupList";
	private final String GROUP_INVITE = "group/inviteUser";
	private final String GROUP_ROOM = "group/groupRoom";
	
	// redirect 할 때 이동경로에 "/" 존재하면 웹 어플리케이션 기준으로 주소생성
	// "/" 없으면 현재 페이지 주소값을 이용하여 주소를 생성
	// ex) redirect:/update => http://localhost:8080/Haeyoum/update
	//     redirect:update => http://localhost:8080/Haeyoum/member/update
	private final String REDIRECT_GROUP_LIST = "redirect:groupList";

	@Autowired
	private GroupService groupSvc;
	@Autowired
	private GroupMemberService groupMemberSvc;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String groupReg(@ModelAttribute("user") User user) {
		return GROUP_FORM;
	}

	@ResponseBody
	@RequestMapping(value = "/registcode", method = RequestMethod.POST)
	public String code() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String code = null;
		StringBuffer sb = new StringBuffer();
		while (true) {
			for (int i = 0; i < 8; i++) {
				int idx = (int) (charSet.length * Math.random());
				// 36 * 생성된 난수를 Int로 추출 (소숫점제거)
				sb.append(charSet[idx]);
			}
			String confirmCode = sb.toString();
			int result = groupSvc.confirmGroup(confirmCode);

			if (result == 0) {
				code = "{\"value\" : \"" + sb.toString() + "\"}";
				break;
			}
		}
		return code;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String groupReg(@ModelAttribute("user") User user, Group group, Model model) {

		HashMap<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (group.getGroup_code() == null || group.getGroup_code().trim().length() == 0) {
			errors.put("emptyCode", Boolean.TRUE);
		} 
		if (group.getGroup_code().equals("errorCode")) {
			errors.put("errorCode", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			System.out.println();
			return GROUP_FORM;
		}
		
		group.setGroup_admin_id(user.getM_email());
		Group newGroup = groupSvc.createGroup(group);

		user.setGroup_id(newGroup.getGroup_id()); 
		model.addAttribute("group", newGroup);

		return GROUP_CONFIRM;
	}

	@RequestMapping("/groupList")
	public String groupList(@ModelAttribute("user") User user, Model model) {
		user.setGroup_id(0);
		int stPage = 0;
		
		List<GroupList> list = groupSvc.groupList(stPage, user.getM_email());
	
		model.addAttribute("groupList", list);
		return GROUP_LIST;
	}

	@ResponseBody
	@RequestMapping("/groupList/{stPage}")
	public Map<String, List<GroupList>> groupList(@PathVariable("stPage") int stPage,
			@ModelAttribute("user") User user) {
		stPage *= 11;

		Map<String, List<GroupList>> groupList = new HashMap<>();
		List<GroupList> list = groupSvc.groupList(stPage, user.getM_email());
		
		groupList.put("list", list);
		return groupList;
	}

	@RequestMapping(value = "/inviteCode", method = RequestMethod.GET)
	public String inviteCode() {
		return GROUP_INVITE;
	}

	@ResponseBody
	@RequestMapping("/inviteCode/{inviteCode}")
	public String confirmCode(@PathVariable("inviteCode") String reqCode) {
		
		int result = groupSvc.confirmGroup(reqCode);
		String code = "{\"value\" : \"" + result + "\"}";
		
		return code;
	}

	@RequestMapping(value = "/inviteCode", method = RequestMethod.POST)
	public String inviteCode(@ModelAttribute("user") User user, @RequestParam("inviteCode") String reqCode,
			Model model) {

		HashMap<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (reqCode == null) {
			errors.put("emptyCode", Boolean.TRUE);
		}
		if (reqCode.equals("errorCode")) {
			errors.put("errorCode", Boolean.TRUE);
		}
		
		Group inGroup = groupSvc.inviteGroup(reqCode, user.getM_email());
		if(inGroup == null) {
			errors.put("emptyGroup", Boolean.TRUE);
		}
		 
		int confirmMember = groupMemberSvc.confirmGroupMember(inGroup.getGroup_id());
		if (confirmMember != 0) {
			errors.put("joined", Boolean.TRUE);
		}
		
		int countMember = groupMemberSvc.countGroupMember(inGroup.getGroup_id());
		if (countMember >= inGroup.getGroup_max()) {
			errors.put("fullMember", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) {
			return GROUP_INVITE;
		}
		
		groupMemberSvc.insertGroupMember(inGroup.getGroup_id(), user.getM_email());

		return REDIRECT_GROUP_LIST;
	}
	
	@RequestMapping("/room")
	public String room(@ModelAttribute("user") User user, 
						@RequestParam("group_id") int group_id, Model model) {

		Group group = groupSvc.selectGroup(group_id);
		if(group == null) {
			return GROUP_LIST;
		}
		int countMember = groupMemberSvc.countGroupMember(group_id);
		user.setGroup_id(group_id);
		
		List<GroupMember> memberList = groupMemberSvc.getGroupMember(group_id);
		
		model.addAttribute("group", group);
		model.addAttribute("memberList", memberList);
		model.addAttribute("countMember", countMember);
		
		return GROUP_ROOM;
	}
	
}

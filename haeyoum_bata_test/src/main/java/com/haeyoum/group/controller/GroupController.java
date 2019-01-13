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

import com.haeyoum.group.model.Room;
import com.haeyoum.group.model.RoomList;
import com.haeyoum.group.model.RoomMember;
import com.haeyoum.group.service.GroupMemberService;
import com.haeyoum.group.service.GroupService;
import com.haeyoum.member.model.User;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.util.TempKey;

@Controller
@RequestMapping("/room")
@SessionAttributes("user")

public class GroupController {

	private final String GROUP_FORM = "room/regForm";
	private final String GROUP_CONFIRM = "room/confirm";
	private final String GROUP_LIST = "room/list";
	private final String GROUP_INVITE = "room/inviteUser";
	private final String GROUP_ROOM = "room/main";
	
	// redirect 할 때 이동경로에 "/" 존재하면 웹 어플리케이션 기준으로 주소생성
	// "/" 없으면 현재 페이지 주소값을 이용하여 주소를 생성
	// ex) redirect:/update => http://localhost:8080/Haeyoum/update
	//     redirect:update => http://localhost:8080/Haeyoum/member/update
	private final String REDIRECT_GROUP_LIST = "redirect:roomList";

	@Autowired
	private GroupService groupSvc;
	@Autowired
	private GroupMemberService groupMemberSvc;
	@Autowired
	private MemberService memberSvc;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String roomReg(@ModelAttribute("user") User user) {
		return GROUP_FORM;
	}

	@ResponseBody
	@RequestMapping(value = "/roomkey", method = RequestMethod.POST)
	public String code() {
		
		String generateKey = new TempKey().generateKey(8);  // key 생성
		String key = null;
		
		// key 중복값 확인
		while (true) {
			int result = groupSvc.confirmGroup(generateKey);

			if (result == 0) {
				key = "{\"value\" : \"" + generateKey + "\"}";
				break;
			}
		}
		return key;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String groupReg(@ModelAttribute("user") User user, Room group, Model model) {

		HashMap<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (group.getRoomkey() == null || group.getRoomkey().trim().length() == 0) {
			errors.put("emptyCode", Boolean.TRUE);
		} 
		if (group.getRoomkey().equals("errorCode")) {
			errors.put("errorCode", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			System.out.println();
			return GROUP_FORM;
		}
		
		try {
			group.setRoom_master(memberSvc.selectByUser(user.getMember_id()).getUser_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Room newGroup = groupSvc.createGroup(group);

		user.setGroup_id(newGroup.getId()); 
		model.addAttribute("group", newGroup);

		return GROUP_CONFIRM;
	}

	@RequestMapping("/list")
	public String groupList(@ModelAttribute("user") User user, Model model) {
		user.setGroup_id(0);
		int stPage = 0;
		
		List<RoomList> list = groupSvc.groupList(stPage, user.getMember_id());
	
		model.addAttribute("list", list);
		return GROUP_LIST;
	}

	@ResponseBody
	@RequestMapping("/list/{stPage}")
	public Map<String, List<RoomList>> groupList(@PathVariable("stPage") int stPage,
			@ModelAttribute("user") User user) {
		stPage *= 11;

		Map<String, List<RoomList>> groupList = new HashMap<>();
		List<RoomList> list = groupSvc.groupList(stPage, user.getMember_id());
		
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
		
		Room inGroup = groupSvc.inviteGroup(reqCode, user.getMember_id());
		if(inGroup == null) {
			errors.put("emptyGroup", Boolean.TRUE);
		}
		 
		int confirmMember = groupMemberSvc.confirmGroupMember(inGroup.getId());
		if (confirmMember != 0) {
			errors.put("joined", Boolean.TRUE);
		}
		
		int countMember = groupMemberSvc.countGroupMember(inGroup.getId());
		if (countMember >= inGroup.getMax()) {
			errors.put("fullMember", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) {
			return GROUP_INVITE;
		}
		
		groupMemberSvc.insertGroupMember(inGroup.getId(), user.getMember_id());

		return REDIRECT_GROUP_LIST;
	}
	
	@RequestMapping("/room")
	public String room(@ModelAttribute("user") User user, 
						@RequestParam("group_id") int group_id, Model model) {

		Room group = groupSvc.selectGroup(group_id);
		if(group == null) {
			return GROUP_LIST;
		}
		int countMember = groupMemberSvc.countGroupMember(group_id);
		user.setGroup_id(group_id);
		
		List<RoomMember> memberList = groupMemberSvc.getGroupMember(group_id);
		
		model.addAttribute("group", group);
		model.addAttribute("memberList", memberList);
		model.addAttribute("countMember", countMember);
		
		return GROUP_ROOM;
	}
	
}

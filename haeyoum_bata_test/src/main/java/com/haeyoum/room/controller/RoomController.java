package com.haeyoum.room.controller;

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

import com.haeyoum.member.model.User;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.room.model.Room;
import com.haeyoum.room.model.RoomList;
import com.haeyoum.room.model.RoomMember;
import com.haeyoum.room.service.RoomMemberService;
import com.haeyoum.room.service.RoomService;
import com.haeyoum.util.TempKey;

@Controller
@RequestMapping("/room")
@SessionAttributes("user")

public class RoomController {

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
	private RoomService RoomSvc;
	@Autowired
	private RoomMemberService roomMemberSvc;
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
			int result = RoomSvc.confirmGroup(generateKey);

			if (result == 0) {
				key = "{\"value\" : \"" + generateKey + "\"}";
				break;
			}
		}
		return key;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String roomReg(@ModelAttribute("user") User user, Room group, Model model) {

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
		Room newGroup = RoomSvc.createGroup(group);

		user.setRoom_id(newGroup.getRoom_id()); 
		model.addAttribute("group", newGroup);

		return GROUP_CONFIRM;
	}

	@RequestMapping("/list")
	public String roomList(@ModelAttribute("user") User user, Model model) {
		user.setRoom_id(0);
		int stPage = 0;
		
		List<RoomList> list = RoomSvc.groupList(stPage, user.getMember_id());
	
		model.addAttribute("list", list);
		return GROUP_LIST;
	}

	@ResponseBody
	@RequestMapping("/list/{stPage}")
	public Map<String, List<RoomList>> groupList(@PathVariable("stPage") int stPage,
			@ModelAttribute("user") User user) {
		stPage *= 11;

		Map<String, List<RoomList>> groupList = new HashMap<>();
		List<RoomList> list = RoomSvc.groupList(stPage, user.getMember_id());
		
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
		
		int result = RoomSvc.confirmGroup(reqCode);
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
		
		Room inGroup = RoomSvc.inviteGroup(reqCode, user.getMember_id());
		if(inGroup == null) {
			errors.put("emptyGroup", Boolean.TRUE);
		}
		 
		int confirmMember = roomMemberSvc.confirmGroupMember(inGroup.getRoom_id());
		if (confirmMember != 0) {
			errors.put("joined", Boolean.TRUE);
		}
		
		int countMember = roomMemberSvc.countGroupMember(inGroup.getRoom_id());
		if (countMember >= inGroup.getMax()) {
			errors.put("fullMember", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) {
			return GROUP_INVITE;
		}
		
		roomMemberSvc.insertGroupMember(inGroup.getRoom_id(), user.getMember_id());

		return REDIRECT_GROUP_LIST;
	}
	
	@RequestMapping("/room")
	public String room(@ModelAttribute("user") User user, 
						@RequestParam("group_id") int group_id, Model model) {

		Room group = RoomSvc.selectGroup(group_id);
		if(group == null) {
			return GROUP_LIST;
		}
		int countMember = roomMemberSvc.countGroupMember(group_id);
		user.setRoom_id(group_id);
		
		List<RoomMember> memberList = roomMemberSvc.getGroupMember(group_id);
		
		model.addAttribute("group", group);
		model.addAttribute("memberList", memberList);
		model.addAttribute("countMember", countMember);
		
		return GROUP_ROOM;
	}
	
}

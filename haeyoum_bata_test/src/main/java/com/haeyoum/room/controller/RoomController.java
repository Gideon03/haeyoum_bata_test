package com.haeyoum.room.controller;

import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.haeyoum.member.model.User;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.room.model.Room;
import com.haeyoum.room.model.RoomMember;
import com.haeyoum.room.service.RoomMemberService;
import com.haeyoum.room.service.RoomService;
import com.haeyoum.util.TempKey;

@Controller
@RequestMapping("/haeyoum")
@SessionAttributes("user")

public class RoomController {

	private final String CREATA_VIEW = "haeyoum/create";
	private final String HOME_VIEW = "haeyoum/home";
	private final String INVITE_VIEW = "haeyoum/inviteUser";
	
	// redirect 할 때 이동경로에 "/" 존재하면 웹 어플리케이션 기준으로 주소생성
	// "/" 없으면 현재 페이지 주소값을 이용하여 주소를 생성
	// ex) redirect:/update => http://localhost:8080/Haeyoum/update
	//     redirect:update => http://localhost:8080/Haeyoum/member/update
	private final String REDIRECT_USER_HOME = "redirect:/user/home";
	private final String REDIRECT_HAEYOUM_ROOM = "redirect:/haeyoum/room/";

	@Autowired
	private RoomService RoomSvc;
	@Autowired
	private RoomMemberService roomMemberSvc;
	@Autowired
	private MemberService memberSvc;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createRoom(@ModelAttribute("user") User user) {
		return CREATA_VIEW;
	}

	@ResponseBody
	@RequestMapping(value = "/roomkey", method = RequestMethod.POST)
	public String code() {
		
		String generateKey = new TempKey().generateKey(8);  // key 생성
		String key = null;
		
		// key 중복값 확인
		while (true) {
			int result = RoomSvc.confirmKey(generateKey);

			if (result == 0) {
				key = "{\"value\" : \"" + generateKey + "\"}";
				break;
			}
		}
		return key;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createRoom(@ModelAttribute("user") User user, Room room, Model model, RedirectAttributes redirAtt) {

		HashMap<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (room.getRoomkey() == null || room.getRoomkey().trim().length() == 0) {
			errors.put("emptyCode", Boolean.TRUE);
		} 
		if (room.getRoomkey().equals("errorCode")) {
			errors.put("errorCode", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			return CREATA_VIEW;
		}
		System.out.println(room.getTitle());
		try {
			room.setRoom_master(user.getMember_id());
			
			Room newRoom = RoomSvc.createRoom(room);
			
			user.setRoom_id(newRoom.getRoom_id()); 
			
			return REDIRECT_HAEYOUM_ROOM + newRoom.getRoom_id() + "/";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("aaa");
			model.addAttribute("msg", "방을 개설중 문제가 발생하였습니다.\n지속적인 문제가 발생할 경우 관리자에게 문의 하시기 바랍니다.");
			return CREATA_VIEW;
		}

		
	}

	@RequestMapping(value = "/invite", method = RequestMethod.GET)
	public String invite() {
		return INVITE_VIEW;
	}

	@ResponseBody
	@RequestMapping("/roomkey/{roomkey}")
	public String confirmKey(@PathVariable("roomkey") String roomkey) {
		
		int result = RoomSvc.confirmKey(roomkey);
		String confirmKey = "{\"value\" : \"" + result + "\"}";
		
		return confirmKey;
	}

	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	public String invite(@ModelAttribute("user") User user, @RequestParam("roomkey") String roomkey,
			Model model) {

		HashMap<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (roomkey == null) {
			errors.put("emptyCode", Boolean.TRUE);
		}
		if (roomkey.equals("errorCode")) {
			errors.put("errorCode", Boolean.TRUE);
		}
		
		Room inRoom = RoomSvc.inviteRoom(roomkey);
		if(inRoom == null) {
			errors.put("emptyGroup", Boolean.TRUE);
		}
		 
		int confirmMember = roomMemberSvc.confirmRoomMember(inRoom.getRoom_id(), user.getMember_id());
		if (confirmMember != 0) {
			errors.put("joined", Boolean.TRUE);
		}
		
		int countMember = roomMemberSvc.countRoomMember(inRoom.getRoom_id());
		if (countMember >= inRoom.getMax()) {
			errors.put("fullMember", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) {
			return INVITE_VIEW;
		}
		
		roomMemberSvc.insertRoomMember(inRoom.getRoom_id(), user.getMember_id());

		return REDIRECT_USER_HOME;
	}
	
	@RequestMapping("/{room_id}/")
	public String room(@ModelAttribute("user") User user, 
			@PathVariable int room_id, Model model) {
		Room room = RoomSvc.selectRoom(room_id);
		if(room == null) {
			return REDIRECT_USER_HOME;
		}
		int countMember = roomMemberSvc.countRoomMember(room_id);
		user.setRoom_id(room_id);
		
		List<RoomMember> memberList = roomMemberSvc.getRoomMember(room_id);
		
		model.addAttribute("room", room);
		model.addAttribute("memberList", memberList);
		model.addAttribute("countMember", countMember);
		
		return HOME_VIEW;
	}
	
}

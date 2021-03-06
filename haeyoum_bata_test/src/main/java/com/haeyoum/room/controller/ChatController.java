package com.haeyoum.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.member.model.User;
import com.haeyoum.room.model.ChatReq;
import com.haeyoum.room.service.ChatService;

@Controller
@RequestMapping("/group")
@SessionAttributes("user")
public class ChatController {
	
	private final String GROUP_LIST = "group/groupList";
	private final String GROUP_CHAT = "chat/chatRoom";
	
	@Autowired
	private ChatService chatSvc;

	@RequestMapping("/chat")
	public String chat(@ModelAttribute("user") User user, Model model) {
		if(user.getRoom_id() == 0) {
			return GROUP_LIST;
		}
		
		List<ChatReq> reqChatList = chatSvc.chatList(user.getRoom_id());
		
		model.addAttribute("msgList", reqChatList);
		return GROUP_CHAT;
	}

}

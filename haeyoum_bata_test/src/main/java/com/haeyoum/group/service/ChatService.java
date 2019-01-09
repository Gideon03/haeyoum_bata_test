package com.haeyoum.group.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.group.model.Chat;
import com.haeyoum.group.model.ChatReq;
import com.haeyoum.group.repository.ChatDAO;
import com.haeyoum.util.DateUtil;

@Service
public class ChatService {
	
	@Autowired
	private ChatDAO chatDAO;
	private DateUtil du = new DateUtil();
	
	public Chat insertChat(Chat chat) {
		int result = chatDAO.insertChat(chat);
		if(result != 0) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("chat_id", chat.getChat_id());
			
			return chatDAO.selectChat(map); 
		}
		return null;
	}
	
	public List<ChatReq> chatList(HashMap<String, Object> map) {
		
		List<ChatReq> reqChatList = new ArrayList<>();
		// 날짜 변환작업
		for( Chat chat : chatDAO.chatList(map)) {
			reqChatList.add(
					new ChatReq(chat.getGroup_id(), 
							chat.getChat_id(), 
							chat.getMember_id(), 
							chat.getMessage_text(),
							du.convertTime(chat.getMessage_senddate())));
		}
		return reqChatList;
	} 
	
	public Chat selectChat(HashMap<String, Object> map) {
		return chatDAO.selectChat(map);
	}
	
	

}

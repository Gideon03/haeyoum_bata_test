package com.haeyoum.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.haeyoum.member.model.User;
import com.haeyoum.room.model.Chat;
import com.haeyoum.room.service.ChatService;
import com.haeyoum.util.DateUtil;

import java.util.*;

public class EchoHandler extends TextWebSocketHandler {
	
	@Autowired
	private ChatService chatSvc;
	private DateUtil du = new DateUtil();
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	
	// 클라이언트와 연결 이후에 실행되는 메서드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		sessionList.add(session);
		// HttpSession에 저장된 정보를 WebSocketSession 에서 사용
		Map<String, Object> attrMap = session.getAttributes();
		User user = (User) attrMap.get("user");
		System.out.printf("%s 연결됨\n", user.getMember_id());
	}

	// 클라이언트가 서버로 메시지를 전송했을 때 실행되는 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		Map<String, Object> attrMap = session.getAttributes();
		User user = (User) attrMap.get("user");
		System.out.printf("%s로 부터 %s 받음\n", user.getMember_id(), message.getPayload());
		
		Chat chat = chatSvc.insertChat(
				new Chat(user.getRoom_id(), 
						user.getMember_id(), 
						message.getPayload()));
		
		for (WebSocketSession sess : sessionList) {
			
			Map<String, Object> reqMap = sess.getAttributes();
			User reqUser = (User) reqMap.get("user");
			
			if (reqUser.getRoom_id() == user.getRoom_id()) {
				
				sess.sendMessage(
						new TextMessage(user.getMember_id() 
								+ "|" 
								+ message.getPayload()
								+ "|" 
								+ du.convertTime(chat.getSend_date())));
			}
		}
	}

	// 클라이언트와 연결을 끊었을 때 실행되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		// System.out.printf("%s 연결 끊김\n", session.getId());
		Map<String, Object> attrMap = session.getAttributes();
		User user = (User) attrMap.get("user");
		System.out.printf("%s 연결 끊김\n", user.getMember_id());
	}
}

package com.haeyoum.m.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haeyoum.member.model.Member;
import com.haeyoum.member.service.MemberService;

@RestController
@RequestMapping("/m/member")
public class MemberRestController {

	@Autowired
	private MemberService memberSvc;

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public Map<String, Integer> regist(Member member) throws Exception {

		System.out.printf("(POST) id -> %s\n", member.getEmail());

		Map<String, Integer> json = new HashMap<>();

		memberSvc.regist(member);

		json.put("result", 1);

		return json;
	}

	@RequestMapping(value="/androidLogin", method=RequestMethod.POST)
	public String restful_1(
			String loginId, 
			String loginPasswords,
			HttpSession session) {
		
			
		return null;
		
		
	}
	
	@RequestMapping(value="/restful/login/check", method=RequestMethod.GET)
	public void restful_login( HttpSession session ) {
		String id = (String)session.getAttribute("login_id");
		if( id != null )
			System.out.printf("로그인 확인 완료 - 로그인 아이디는 %s 입니다.\n", id);
		else
			System.out.println("로그인이 확인되지 않음");
	}
	
	@RequestMapping(value="/androidLoginCheck", method=RequestMethod.GET)
	public String restful_1( HttpSession session, String message ) {
		
		System.out.printf("Session ID : %s\n", session.getId());
		System.out.printf("(GET) message -> %s\n", message);
		
		Member member = new Member();
		member.setEmail("1");
		member.setPassword("asd");
		member.setUser_name("asdfasd");
		
		String strJson = null;
		return strJson;
	}
	
}








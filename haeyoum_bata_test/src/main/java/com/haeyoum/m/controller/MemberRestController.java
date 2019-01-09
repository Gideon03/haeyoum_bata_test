package com.haeyoum.m.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haeyoum.m.model.MemberRestModel;
import com.haeyoum.member.model.Member;
import com.haeyoum.member.service.MemberService;

@RestController
@RequestMapping("/m/member")
public class MemberRestController {

	@Autowired
	private MemberService memberSvc;

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public Map<String, Integer> regist(MemberRestModel member) throws Exception {

		System.out.printf("(POST) id -> %s\n", member.getMember_id());
		System.out.printf("(POST) bd -> %s\n", member.getMember_birthday());

		Map<String, Integer> json = new HashMap<>();

		Member regMember = new Member();
		regMember.setM_email(member.getMember_id());
		regMember.setM_password(member.getMember_password());
		regMember.setM_name(member.getMember_name());

		memberSvc.regist(regMember);

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
		member.setM_email("1");
		member.setM_password("asd");
		member.setM_name("asdfasd");
		
		String strJson = null;
		return strJson;
	}
	
}








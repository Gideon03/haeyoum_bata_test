package com.haeyoum.member.controller;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.haeyoum.error.LoginError;
import com.haeyoum.member.model.Member;
import com.haeyoum.member.model.User;
import com.haeyoum.member.service.MemberService;

@Controller
@SessionAttributes("user")
public class SignController {
	private final String HOME = "redirect:/";
	private final String USER_HOME = "redirect:/user/home";
	private final String HOME_VIEW = "index";
	private final String SIGN_UP_VIEW = "sign/sign-up";
	private final String SIGN_IN_VIEW = "sign/sign-in";
	private final String SIGN_OUT_VIEW = "sign/sign-out";
	private final String EMAIL_CONFIRM_VIEW = "sign/emailConfirm";

	@Autowired
	private MemberService memberSvc;

	// FlashAttribute 를 사용하기 위해 강제로 "/" url 가져오기(dispatcherServlet 으로 보내기)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return HOME_VIEW;
	}
	
//	------------------------------------- 회원가입 --------------------------------------
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String registerGet() {
		return SIGN_UP_VIEW;
	}

	@ResponseBody
	@RequestMapping(value="/checkId/{member_id}", method=RequestMethod.POST)
	public String checkId(@PathVariable("member_id") String member_id) {
//		int result = memberSvc.checkId(member_id);
		
		String msg = null;
//		if (result == 0)
//			msg = "";
//		else
//			msg = "중복된 아이디가 있어윰..ㅠㅠ";

		return "{\"value\" : \"" + msg + "\"}";
	}
	
	//회원가입 요청
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String registerPost(Member user,Model model,RedirectAttributes rttr) throws Exception{
    
        System.out.println("regesterPost 진입 ");
        memberSvc.regist(user);
        rttr.addFlashAttribute("msg" , "가입시 사용한 이메일로 인증해주세요");
        return HOME;
    }
	
	//이메일 인증 코드 검증
    @RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
    public String emailConfirm(@RequestParam("authKey")String authkey, Model model, RedirectAttributes rttr) throws Exception { 
        
        System.out.println("cont get user : " + authkey);
        if(authkey == null) {
            rttr.addFlashAttribute("msg", "비정상적인 접근 입니다. 다시 인증해 주세요");
            return HOME;
        }
        
        Member member = memberSvc.userAuth(authkey);
        if(member == null) {
            rttr.addFlashAttribute("msg", "비정상적인 접근 입니다. 다시 인증해 주세요");
            return HOME;
        }
        model.addAttribute("user", member);
        return EMAIL_CONFIRM_VIEW;
    }
//	-------------------------------------------------------------------------------------
    
//	------------------------------------- 로 그 인 --------------------------------------
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String loginGet() {
		return SIGN_IN_VIEW;
	}

	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	public String login(Model model, String email, String password) {
		System.out.println(email);
		Member member = null;
		try {
			member = memberSvc.selectByUser(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LoginError errors = memberSvc.confirmMember(member, password);
		if (errors.isIdError() || errors.isPwError() || errors.isNotConfirmUser()) {
			model.addAttribute("errors", errors);
			return SIGN_IN_VIEW;
		} else {
			User user = memberSvc.loginUser(member);
			model.addAttribute("user", user);
			return USER_HOME;
		}
		
	}
//	-------------------------------------------------------------------------------------
	
//	------------------------------------- 로그아웃 --------------------------------------
	@RequestMapping(value = "/sign-out", method = RequestMethod.GET)
	public String logout() {
		return SIGN_OUT_VIEW;
	}

	@RequestMapping(value = "/sign-out", method = RequestMethod.POST)
	public String logout(Model model, @ModelAttribute("user") User user, SessionStatus status) {
		if (user.isLogin()) {
			user.setLogin(false);
		}
		status.setComplete();
		if (status.isComplete()) {
			System.out.println("세션 만료됨");
		}
		return HOME;
	}

}

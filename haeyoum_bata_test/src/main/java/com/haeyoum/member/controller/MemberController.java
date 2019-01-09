package com.haeyoum.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.member.model.FileVo;
import com.haeyoum.member.model.MemberInfo;
import com.haeyoum.member.model.User;
import com.haeyoum.member.service.FileUploadService;
import com.haeyoum.member.service.MemberService;

@Controller
@SessionAttributes("user")
public class MemberController {

	private final String USER_HOME_VIEW = "user/home";
	private final String USER_EDIT_VIEW = "user/info-edit";
	private final String REDIRECT_EDIT_VIEW = "redirect:/user-edit";

	@Autowired
	private MemberService memberSvc;

	@Autowired
	private FileUploadService fileService;
	
	@RequestMapping("user-home")
	public String userHome(@ModelAttribute("user") User user, Model model) {
		return USER_HOME_VIEW;
	}
	
	// 파일업로드를 위한 기본경로 설정
	@ModelAttribute("realPath")
	public String getRealPath(HttpServletRequest request) {
		String realPath = request.getRealPath("/WEB-INF/resources/upload/");
		return realPath;
	}

	@RequestMapping(value = "user-edit", method = RequestMethod.GET)
	public String update(@ModelAttribute("user") User user, Model model) {
		// 접속 유저의 정보 가져오기
		MemberInfo memInfo = memberSvc.selectInfo(user.getM_email());
		model.addAttribute("memberInfo", memInfo);
		return USER_EDIT_VIEW;
	}

	
	@RequestMapping(value = "user-edit", method = RequestMethod.POST)	
	public String update(Model model, FileVo file, MemberInfo memInfo, 
			@ModelAttribute("realPath") String realPath,
			@ModelAttribute("user") User user){
		
		memInfo.setM_email(user.getM_email());	//정보 수정할 유저 ID 설정
		
		// 유저프로필 이미지 저장
		fileService.saveFile(realPath, file);
		String fileName = file.getFile().getOriginalFilename();
		System.out.println("파일네임 : " + fileName);
		System.out.println("리얼패스 : " + realPath);
		
		// 이미지가 없을경우 null
		if (fileName.length() != 0) {
			memInfo.setM_image(fileName);
		}
		
		int result = memberSvc.updateInfo(memInfo);
		
		return REDIRECT_EDIT_VIEW;
	}

}

package com.haeyoum.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.member.model.FileVo;
import com.haeyoum.member.model.MemberInfo;
import com.haeyoum.member.model.User;
import com.haeyoum.member.service.FileUploadService;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.room.model.RoomList;
import com.haeyoum.room.service.RoomService;

@Controller
@RequestMapping("user")
@SessionAttributes("user")
public class MemberController {

	private final String USER_HOME_VIEW = "user/home";
	private final String USER_EDIT_VIEW = "user/info-edit";
	private final String REDIRECT_EDIT_VIEW = "redirect:/user/edit";

	@Autowired
	private MemberService memberSvc;
	@Autowired
	private RoomService RoomSvc;
	@Autowired
	private FileUploadService fileService;
	
	@RequestMapping("/home")
	public String userHome(@ModelAttribute("user") User user, Model model) {
		return USER_HOME_VIEW;
	}
	
	// ajax 통신을 통한 가입 목록 불러오기
	@ResponseBody
	@RequestMapping("/home/list/{stPage}")
	public Map<String, List<RoomList>> groupList(@PathVariable("stPage") int stPage,
			@ModelAttribute("user") User user) {
		stPage *= 11;

		Map<String, List<RoomList>> groupList = new HashMap<>();
		List<RoomList> list = RoomSvc.groupList(stPage, user.getMember_id());
		
		groupList.put("list", list);
		return groupList;
	}
	
	// 파일업로드를 위한 기본경로 설정
	@ModelAttribute("realPath")
	public String getRealPath(HttpServletRequest request) {
		String realPath = request.getRealPath("/WEB-INF/resources/upload/");
		return realPath;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String update(@ModelAttribute("user") User user, Model model) {
		// 접속 유저의 정보 가져오기
		MemberInfo memInfo = memberSvc.selectInfo(user.getMember_id());
		model.addAttribute("memberInfo", memInfo);
		return USER_EDIT_VIEW;
	}

	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)	
	public String update(Model model, FileVo file, MemberInfo memInfo, 
			@ModelAttribute("realPath") String realPath,
			@ModelAttribute("user") User user){
		
		memInfo.setEmail(user.getMember_id());	//정보 수정할 유저 ID 설정
		
		// 유저프로필 이미지 저장
		fileService.saveFile(realPath, file);
		String fileName = file.getFile().getOriginalFilename();
		System.out.println("파일네임 : " + fileName);
		System.out.println("리얼패스 : " + realPath);
		
		// 이미지가 없을경우 null
		if (fileName.length() != 0) {
			memInfo.setImage(fileName);
		}
		
		int result = memberSvc.updateInfo(memInfo);
		
		return REDIRECT_EDIT_VIEW;
	}

}

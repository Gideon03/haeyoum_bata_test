package com.haeyoum.group.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.haeyoum.group.model.Location;
import com.haeyoum.group.model.Video;
import com.haeyoum.group.model.VideoView;
import com.haeyoum.group.service.LocationService;
import com.haeyoum.group.service.VideoService;
import com.haeyoum.member.model.FileVo;
import com.haeyoum.member.model.User;
import com.haeyoum.member.service.FileUploadService;

@Controller
@RequestMapping("/group/video")
@SessionAttributes("user")
public class VideoController {

	private static final String LIST = "video/videoList";
	private static final String VIDEOADD = "video/videoAdd";
	private static final String CONFIRM = "video/videoConfirm";
	private static final String UPDATE = "video/videoModify";

	@Autowired
	private VideoService videoSvc;

	@Autowired
	private LocationService mapSvc;

	@Autowired
	private FileUploadService fileService;

	@ModelAttribute("user")
	public User emptySession() {
		return new User();
	}

	@ModelAttribute("realPath")
	public String getRealPath(HttpServletRequest request) {
		String realPath = request.getRealPath("/WEB-INF/resources/mp4/");
		return realPath;
	}

	// 리스트
	@RequestMapping(value = "/videoList", method = RequestMethod.GET)
	public String VideoList(Model model, @ModelAttribute("user") User user) {

		List<VideoView> videoView = videoSvc.selectList();
		model.addAttribute("user", user);
		model.addAttribute("list", videoView);

		return LIST;
	}

	@RequestMapping(value = "/videoAdd", method = RequestMethod.GET)
	public String addVideo() {

		return VIDEOADD;
	}

	// 추가
	@RequestMapping(value = "/videoAdd", method = RequestMethod.POST)
	public String addVideo(Model model, Video video, Location location,
			@RequestParam("file") MultipartFile mf,
			@ModelAttribute("realPath") String realPath,
			@ModelAttribute("user") User user) {
		FileVo file = new FileVo();
		file.setFile(mf);

		
		
		video.setVideo_writer(user.getM_email());
		video.setGroup_id(user.getGroup_id());

		fileService.saveFile(realPath, file);
		
		String fileName = file.getFile().getOriginalFilename();

		video.setVideo_file(fileName);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("map_latitude", location.getMap_latitude());
		map.put("map_longitude", location.getMap_longitude());

		Object result = videoSvc.insert(video, map);
		if (result != null) {
			model.addAttribute("regist", 1);
		}

		return CONFIRM;
	}

	// 삭제
	@RequestMapping(value = "/videoDelete")
	public String videodelete(Video video, Location location, @RequestParam("sort_id") int sort_id,
			@RequestParam("con_id") int con_id) {
		Object result = videoSvc.delete(video, location);
		
		return CONFIRM;
	}

	// 수정화면 뿌리기
	@RequestMapping(value = "/videoModify", method = RequestMethod.GET)
	public String videomodify(VideoView videoView, Model model, @ModelAttribute("user") User user) {

		VideoView videoView1 = videoSvc.videoone(videoView);
		model.addAttribute("videoView", videoView1);

		return UPDATE;
	}

	// 수정 정보 받아온뒤
	@RequestMapping(value = "/videoModify", method = RequestMethod.POST)
	public String videomodify(Model model, Video video, Location location, @RequestParam("flie") MultipartFile mf,
			@ModelAttribute("realPath") String realPath, @ModelAttribute("user") User user) {
		FileVo file = new FileVo();
		file.setFile(mf);
		
		fileService.saveFile(realPath, file);
		
		String fileName = file.getFile().getOriginalFilename();
		
		video.setVideo_writer(user.getM_email());
		video.setVideo_file(fileName);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("map_latitude", location.getMap_latitude());
		map.put("map_longitude", location.getMap_longitude());
		map.put("con_id", video.getCon_id());
		
		Object result = videoSvc.update(video, map);

		if (result != null) {
			model.addAttribute("regist", 1);
		}
		return CONFIRM;
	}

}
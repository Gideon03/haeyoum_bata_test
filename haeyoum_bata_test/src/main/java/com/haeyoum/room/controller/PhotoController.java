package com.haeyoum.room.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.haeyoum.member.model.FileVo;
import com.haeyoum.member.model.User;
import com.haeyoum.member.service.FileUploadService;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.room.model.Location;
import com.haeyoum.room.model.Photo;
import com.haeyoum.room.model.PhotoFile;
import com.haeyoum.room.model.PhotoView;
import com.haeyoum.room.service.LocationService;
import com.haeyoum.room.service.PhotoService;

@Controller
@RequestMapping("/photo")
@SessionAttributes("user")
public class PhotoController {

	private static final String LIST = "photo/list";
	private static final String PHOTOADD = "photo/create";
	private static final String CONFIRM = "photo/confirm";
	private static final String UPDATE = "photo/modify";

	@Autowired
	private PhotoService photoSvc;
	@Autowired
	private LocationService mapSvc;
	@Autowired
	private FileUploadService fileService;
	@Autowired
	private MemberService memberSvc;
	

	@ModelAttribute("user")
	public User emptySession() {
		return new User();
	}

	@ModelAttribute("realPath")
	public String getRealPath(HttpServletRequest request) {
		String realPath = request.getRealPath("/WEB-INF/resources/photoimg/");
		return realPath;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String photolist(Photo photo, PhotoFile photoFile, Model model, @ModelAttribute("user") User user) {
		
		photo.setRoom_id(user.getGroup_id());
		List<PhotoView> photoView = photoSvc.selectList();
		photoFile.setPhoto_id(photo.getPhoto_id());
		List<PhotoFile> file = photoSvc.selectFile(photo);

		model.addAttribute("user", user);
		model.addAttribute("list", photoView);
		model.addAttribute("filelist", file);

		return LIST;
	}

	@RequestMapping(value = "/photoAdd", method = RequestMethod.GET)
	public String addphoto() {

		return PHOTOADD;
	}

	@RequestMapping(value = "/photoAdd", method = RequestMethod.POST)
	public String addphoto(Model model, Photo photo, Location location, @RequestParam ArrayList<MultipartFile> files,
			@ModelAttribute("realPath") String realPath, @ModelAttribute("user") User user) throws Exception {

		photo.setWriter(memberSvc.selectByUser(user.getMember_id()).getUser_name());
		photo.setRoom_id(user.getGroup_id());

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("map_latitude", location.getMap_latitude());
		map.put("map_longitude", location.getMap_longitude());

		Object result = photoSvc.insert(photo, map);
		
		if(result != null) {
			
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		
		map2.put("con_id", photo.getPhoto_id());
		map2.put("group_id", photo.getRoom_id());
		
		for (MultipartFile mf : files) {
			FileVo file = new FileVo();
			file.setFile(mf);
			fileService.saveFile(realPath, file);
			map2.put("photo_file", mf.getOriginalFilename());
			photoSvc.fileinsert(map2);
			}
		model.addAttribute("regist", 1);
		}

		return CONFIRM;
	}

	// 삭제
	@RequestMapping(value = "/photoDelete")
	public String photodelete(Photo photo, Location location, PhotoFile photoFile, @RequestParam("sort_id") int sort_id,
			@RequestParam("con_id") int con_id) {

		photo.setPhoto_id(con_id);
		photoFile.setRoom_id(photo.getRoom_id());
		Object result = photoSvc.delete(photo, location, photoFile);

		if (result != null) {
		}
		return CONFIRM;
	}

	@RequestMapping(value = "/photoModify", method = RequestMethod.GET)
	public String videomodify(PhotoView photoView,Model model, @ModelAttribute("user") User user) {
		PhotoView photoView1 = photoSvc.photoone(photoView);
		model.addAttribute("photoView", photoView1);
			
		return UPDATE;
	}

	@RequestMapping(value = "/photoModify", method = RequestMethod.POST)
	public String videomodify(Model model, PhotoFile photoFile, Photo photo, Location location,
			@RequestParam ArrayList<MultipartFile> files,
			@ModelAttribute("realPath") String realPath,
			@ModelAttribute("user") User user) throws Exception {
		
		photo.setWriter(memberSvc.selectByUser(user.getMember_id()).getUser_name());
		photo.setRoom_id(user.getGroup_id());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("map_latitude", location.getMap_latitude());
		map.put("map_longitude", location.getMap_longitude());
		map.put("con_id", photo.getPhoto_id());
		
		
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("con_id", photo.getPhoto_id());
		map2.put("group_id", photo.getRoom_id());
		
		Object result = photoSvc.update(photo, map);
		System.out.println("1 : "+result);
		if(result != null) {
		Object c= photoSvc.filedelete(photoFile);
		System.out.println("2 : "+c);
		if(c!=null) {
			for( MultipartFile mf : files ) {
	    		FileVo file = new FileVo();
	    		file.setFile(mf);
	    		fileService.saveFile(realPath, file);
	    		map2.put("photo_file", mf.getOriginalFilename());
	    		photoSvc.fileinsert(map2);
				}
			}
		}
		if (result != null) {
			model.addAttribute("regist", 1);
		}
	return CONFIRM;
	}
	
}
	
	
	
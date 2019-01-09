package com.haeyoum.group.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.group.model.Location;
import com.haeyoum.group.model.Photo;
import com.haeyoum.group.model.PhotoFile;
import com.haeyoum.group.model.PhotoView;
import com.haeyoum.group.model.Video;
import com.haeyoum.group.model.VideoView;
import com.haeyoum.group.repository.PhotoDAO;

@Service
public class PhotoService {

	@Autowired
	private PhotoDAO photoDAO;
	@Autowired
	private LocationService locationSvc;
	
	@Transactional
	public Photo insert(Photo photo, HashMap<String, Object> map) {
		
		int result = photoDAO.insert(photo);
		
		map.put("group_id", photo.getGroup_id());
		map.put("sort_id", photo.getSort_id());
		map.put("photo_con_id", photo.getCon_id());
		if (result != 0) {
			locationSvc.insert(map);
		}
		return photo;
	}
	@Transactional
	public Photo delete(Photo photo, Location location,PhotoFile photoFile) {
		 
		int a = locationSvc.photoDelete(location);
		if (a != 0) {
			int b =photoDAO.delete(photo);
			if(b!=0) {
			photoDAO.filedelete(photoFile);
			}
		}
		return photo;
	}
	
	public PhotoFile filedelete(PhotoFile photoFile) {
		photoDAO.filedelete(photoFile);
		return photoFile;
	}
	
	
	public int fileinsert(HashMap<String, Object> map2) {
		System.out.println("3 : "+map2.size());
		return photoDAO.fileinsert(map2);	
	}
	
	public List<PhotoView> selectList() {
		return this.photoDAO.selectList();
	}
	public List<PhotoFile> selectFile(Photo photo) {
		return this.photoDAO.selectFile(photo);
	}
	
	
	public PhotoView photoone(PhotoView photoView) {
		return this.photoDAO.photoone(photoView);
	}
	
	@Transactional
	public Photo update(Photo photo, HashMap<String, Object> map) {

		int a = photoDAO.update(photo);
		if (a != 0) {
			locationSvc.videoUpdate(map);
		}
		return photo;
	}
}

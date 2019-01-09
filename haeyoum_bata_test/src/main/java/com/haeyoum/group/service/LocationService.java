package com.haeyoum.group.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.group.model.Location;
import com.haeyoum.group.model.Note;
import com.haeyoum.group.repository.LocationDAO;



@Service
public class LocationService {
	
	@Autowired
	private LocationDAO dao;
	
	public int insert(HashMap<String, Object> map) {
		return this.dao.insert(map);
	}

	public int videoDelete(Location location) {
		return dao.videoDelete(location);
	}
	public int photoDelete(Location location) {
		return dao.photoDelete(location);
	}
	public int videoUpdate(HashMap<String, Object> map) {
		return dao.videoUpdate(map);
	}
	public int photoUpdate(HashMap<String, Object> map) {
		return dao.photoUpdate(map);
	}
}
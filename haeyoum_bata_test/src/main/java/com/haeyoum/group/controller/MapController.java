package com.haeyoum.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haeyoum.group.model.Location;
import com.haeyoum.group.service.GroupService;
import com.haeyoum.group.service.LocationService;


@Controller
@RequestMapping("/group/map")
public class MapController {
	
	@Autowired
	private LocationService mapSvc;

	public void setService(LocationService service) {
		this.mapSvc = mapSvc;
	}  
	
	@RequestMapping("/map1")
	public String mapClick(Location map) {
//		mapSvc.insert(map);
		return "map/clickedLocation";
	}
	
	@RequestMapping("/map2")
	public String mapCurrent(Location map) {
//		mapSvc.insert(map);
		return "map/currentLocation";
	}
	@RequestMapping("/map3")
	public String mapList(Location map) {
//		mapSvc.insert(map);
		return "map/mapList";
	}
}
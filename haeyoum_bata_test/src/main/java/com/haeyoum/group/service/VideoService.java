package com.haeyoum.group.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.group.model.Location;
import com.haeyoum.group.model.Note;
import com.haeyoum.group.model.Video;
import com.haeyoum.group.model.VideoView;
import com.haeyoum.group.repository.VideoDAO;

@Service
public class VideoService {

	@Autowired
	private VideoDAO videoDAO;
	@Autowired
	private LocationService locationSvc;

	@Transactional
	public Video insert(Video video, HashMap<String, Object> map) {

		int result = videoDAO.insert(video);

		map.put("group_id", video.getGroup_id());
		map.put("sort_id", video.getSort_id());
		map.put("video_con_id", video.getCon_id());
		if (result != 0) {
			locationSvc.insert(map);
		}
		return video;

	}

	@Transactional
	public Video delete(Video video, Location location) {

		int a = locationSvc.videoDelete(location);
		if (a != 0) {
			videoDAO.delete(video);
		}

		return video;
	}

	public List<VideoView> selectList() {
		return this.videoDAO.selectList();
	}

	public VideoView videoone(VideoView videoView) {
		return this.videoDAO.videoone(videoView);
	}

	@Transactional
	public Video update(Video video, HashMap<String, Object> map) {

		int a = videoDAO.update(video);
		if (a != 0) {
			locationSvc.videoUpdate(map);
		}
		return video;
	}

}

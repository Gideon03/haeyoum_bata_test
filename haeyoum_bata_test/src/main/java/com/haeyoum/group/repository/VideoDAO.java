package com.haeyoum.group.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Note;
import com.haeyoum.group.model.Video;
import com.haeyoum.group.model.VideoView;

@Repository
public class VideoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String strVideoSpace = "group.model.VideoMapper";

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Video video) {
		return sqlSession.insert(strVideoSpace + ".insert" , video);
	}
	
	public int delete(Video video) {
		return sqlSession.delete(strVideoSpace + ".delete", video);
	}
	
	public int update(Video video) {
		return sqlSession.update(strVideoSpace + ".update", video);
	}

	public List<VideoView> selectList() {
		return sqlSession.selectList(strVideoSpace + ".allRecord");
	}
	
	public VideoView videoone(VideoView videoView) {
		return sqlSession.selectOne(strVideoSpace+".videoone",videoView);
	}
	
}

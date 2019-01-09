package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Photo;
import com.haeyoum.group.model.PhotoFile;
import com.haeyoum.group.model.PhotoView;
import com.haeyoum.group.model.VideoView;

@Repository
public class PhotoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String strPhotoSpace = "group.model.PhotoMapper";

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Photo photo) {
		return sqlSession.insert(strPhotoSpace + ".insert" , photo);
	}
	
	public int fileinsert(HashMap<String, Object> map2) {
		return sqlSession.insert(strPhotoSpace+ ".fileinsert",map2);
	}
	
	public int delete(Photo photo) {
		return sqlSession.delete(strPhotoSpace + ".delete", photo);
	}
	
	public int filedelete(PhotoFile photoFile) {
		return sqlSession.delete(strPhotoSpace + ".filedelete", photoFile);
	}
	
	public int update(Photo photo) {
		return sqlSession.update(strPhotoSpace + ".update", photo);
	}

	public List<PhotoView> selectList() {
		return sqlSession.selectList(strPhotoSpace + ".allRecord");
	}
	public List<PhotoFile> selectFile(Photo photo) {
		return sqlSession.selectList(strPhotoSpace + ".fileselect",photo);
	}

	public PhotoView photoone(PhotoView photoView) {
		return sqlSession.selectOne(strPhotoSpace+".photoone",photoView);
	}
}

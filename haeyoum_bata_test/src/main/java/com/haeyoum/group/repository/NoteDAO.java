package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Note;
import com.haeyoum.group.model.NoteUpdate;

@Repository
public class NoteDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strNoteSpace = "group.model.NoteMapper";

	public List<Note> selectList(HashMap<String, Object> map) {
		return sqlSession.selectList(strNoteSpace + ".noteList", map);
	}
	
	public int insert(Note note) {
		return sqlSession.insert(strNoteSpace + ".insert" , note);
	}
	
	public Note readNote(HashMap<String, Object> map) {
		return sqlSession.selectOne(strNoteSpace+".readNote", map);
	}
	
	public int readupdate(HashMap<String, Object> map) {
		return sqlSession.update(strNoteSpace+".readupdate", map);	
	}
	
	public int updateNote(NoteUpdate updateNote) {
		return sqlSession.update(strNoteSpace + ".updateNote", updateNote);
	}

	public int deleteNote(int con_id) {
		return sqlSession.delete(strNoteSpace + ".deleteNote", con_id);
	}
	
}

package com.haeyoum.group.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.group.model.Note;
import com.haeyoum.group.model.NoteUpdate;
import com.haeyoum.group.repository.NoteDAO;

@Service
public class NoteService {

	@Autowired
	private NoteDAO noteDAO;
	
	
	public List<Note> selectList(int group_id) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("group_id", group_id);
		return noteDAO.selectList(map);
	}
	
	public int insertNote(Note note) {
		return noteDAO.insert(note);
	}
	
	public Note readNote(int con_id, boolean isRead) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("con_id", con_id);
		
		Note note = noteDAO.readNote(map);
		if (note != null && isRead ) {
			noteDAO.readupdate(map);
		}
		return note;
	}
	
	public int updateNote(NoteUpdate updateNote) {
		return noteDAO.updateNote(updateNote);
	}

	public int deleteNote(int con_id) {
		return noteDAO.deleteNote(con_id);
	}

}

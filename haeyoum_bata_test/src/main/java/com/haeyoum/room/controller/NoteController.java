package com.haeyoum.room.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.member.model.User;
import com.haeyoum.error.LoginError;
import com.haeyoum.member.model.Member;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.room.model.Note;
import com.haeyoum.room.model.NoteUpdate;
import com.haeyoum.room.service.NoteService;

@Controller
@RequestMapping("/note")
@SessionAttributes("user")
public class NoteController {
	private static final String READ = "note/noteText";
	private static final String LIST = "note/noteList";
	private static final String CREATENOTE = "note/addNote";
	private static final String CONFIRM = "note/noteConfirm";
	private static final String DELETE = "note/deleteNote";
	private static final String UPDATE = "note/updateNote";
	
	private static final boolean SUCCESSE = true;
	private static final boolean FAIL = false;

	@Autowired
	private NoteService noteSvc;
	@Autowired
	private MemberService memberSvc;

	@RequestMapping("/list")
	public String note_list(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("list", noteSvc.selectList(user.getRoom_id()));
		return LIST;
	}

	@RequestMapping("/read")
	public String readNote(Model model, @RequestParam("con_id") int con_id, 
			@ModelAttribute("user") User user) {
		Note result = noteSvc.readNote(con_id, true);
		model.addAttribute("note", result);
		return READ;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createNote() {
		return CREATENOTE;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNote(Model model, Note note, @ModelAttribute("user") User user) throws Exception {
		note.setWriter(memberSvc.selectByUser(user.getMember_id()).getUser_name());
		note.setRoom_id(user.getRoom_id());
		
		int result = noteSvc.insertNote(note);
		if (result != 0) {
			model.addAttribute("createResult", SUCCESSE);
		} else {
			model.addAttribute("createResult", FAIL);
		}
		return CONFIRM;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update_note(Model model, @RequestParam("con_id") int con_id) {
		model.addAttribute("note", noteSvc.readNote(con_id, false));
		return UPDATE;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update_note(Model model, NoteUpdate updateNote, @ModelAttribute("user") User user) {

		int result = noteSvc.updateNote(updateNote);
		if (result != 0) {
			model.addAttribute("updateResult", SUCCESSE);
			model.addAttribute("con_id", updateNote.getNote_id());
		} else {
			model.addAttribute("updateResult", FAIL);
		}
		return CONFIRM;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("con_id") int con_id, Model model) {
		model.addAttribute("con_id", con_id);
		return DELETE;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, @ModelAttribute("user") User user, 
			@RequestParam("con_id") int con_id, @RequestParam("delete_pw")String delete_pw ) throws Exception {
		
		Member member = memberSvc.selectByUser(user.getMember_id());
		
LoginError errors = memberSvc.confirmMember(member, delete_pw);
		
		if (errors.isIdError() || errors.isPwError() || errors.isNotConfirmUser()) {
			model.addAttribute("errors", errors);
			model.addAttribute("con_id", con_id);
			return DELETE;
		}
	
		int result = noteSvc.deleteNote(con_id);
		model.addAttribute("user", user);
		if (result != 0) {
			model.addAttribute("deleteResult", SUCCESSE);
		} else {
			model.addAttribute("deleteResult", FAIL);
		}
		return CONFIRM;
		}
}

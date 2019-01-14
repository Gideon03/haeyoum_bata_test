package com.haeyoum.room.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haeyoum.member.model.User;
import com.haeyoum.member.model.Member;
import com.haeyoum.member.service.MemberService;
import com.haeyoum.room.model.Vote;
import com.haeyoum.room.model.VoteContent;
import com.haeyoum.room.model.VoteReq;
import com.haeyoum.room.model.VoteRequest;
import com.haeyoum.room.model.VoteResult;
import com.haeyoum.room.model.VoteUser;
import com.haeyoum.room.service.GroupMemberService;
import com.haeyoum.room.service.VoteService;
import com.haeyoum.room.service.VoteUserService;

@Controller
@RequestMapping("/group/vote")
@SessionAttributes("user")
public class VoteController {

	private static final String CREATE_VOTE = "vote/voteForm";
	private static final String VOTE_LIST = "vote/voteList";
	private static final String VOTE_CONTENT = "vote/voteContent";
	private static final String VOTE_UPDATE = "vote/updateForm";
	private static final String VOTE_DELETE ="vote/deleteForm";
	
	@Autowired
	private VoteService voteSvc;
	@Autowired
	private VoteUserService userSvc;
	@Autowired
	private MemberService memberSvc;
	@Autowired
	private GroupMemberService groupMemberSvc;
	
//	--------------------------------- Vote List ----------------------------------------
	@RequestMapping("/voteList")
	public String voteList(Model model, @ModelAttribute("user") User user) {
		List<VoteReq> voteReqList = voteSvc.voteList(user.getGroup_id());
		
		model.addAttribute("voteList", voteReqList);
		
		return VOTE_LIST;
	}
	
//	--------------------------------- Create Vote ----------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String vote(HttpServletRequest request) {
		return CREATE_VOTE;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String vote(
			Model model, Vote vote, 
			@RequestParam("con_text") ArrayList<String> conText,
			@ModelAttribute("user") User user) throws Exception {
		
		vote.setWriter(memberSvc.selectByUser(user.getMember_id()).getUser_name());
		int con_id = voteSvc.createVote(vote, conText);
		
		if (con_id == 0) {
			model.addAttribute("create", 0);
			return CREATE_VOTE;
		}
		
		VoteRequest voteReq = voteSvc.getVote(con_id);
		model.addAttribute("vote", voteReq);

		return VOTE_CONTENT;
	}
	
//	--------------------------------- Read Vote ----------------------------------------
	@RequestMapping(value = "/voteContent", method=RequestMethod.GET)
	public String readVoteContent(Model model, 
			@RequestParam("con_id") int con_id,
			@ModelAttribute("user") User user) {

		VoteRequest selectVote = voteSvc.getVote(con_id);
		if( selectVote != null) {
			model.addAttribute("vote", selectVote);
		}
		VoteUser voteUser = new VoteUser(con_id, user.getMember_id());
		int confirm = userSvc.confirmVote(voteUser);
		if(confirm != 0) {
			VoteUser voteCom = userSvc.selectVoteUser(voteUser);
			model.addAttribute("voteUser", voteCom);
			model.addAttribute("voteComplet", 1);
		}
		
		return VOTE_CONTENT;
	}
	
	@ResponseBody
	@RequestMapping(value = "/voteContent/", method=RequestMethod.POST)
	public Map<String, Object>  conFirm_con_id(Model model,
			@ModelAttribute("user") User user,
			VoteUser voteUser) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<VoteResult> list = new ArrayList<>();
		
		VoteRequest selectVote = voteSvc.getVote(voteUser.getList_id());
		List<VoteContent> voteList = selectVote.getVoteCon();
		for ( VoteContent con : voteList) {
			VoteResult votecon = 
					new VoteResult(
							con.getRoom_id(), 
							con.getVote_id(), 
							con.getList_id(), 
							con.getContent(), 
							userSvc.voteCount(con.getList_id()));
			list.add(votecon);
		}
		result.put("voteList", list);
		
		return result;
	}
//	--------------------------------- Vote ----------------------------------------
	@RequestMapping(value="/voteResult", method=RequestMethod.GET)
	public String result() {
		return VOTE_LIST;
	}
	
	@ResponseBody
	@RequestMapping(value="/voteResult", method=RequestMethod.POST)
	public Map<String, Object> result(Model model, 
			@ModelAttribute("user") User user,
			VoteUser voteUser ) {
		
		// VoteContent Constructor
		Map<String, Object> result = new HashMap<String, Object>();
		List<VoteResult> list = new ArrayList<>();
		
		// User vote
		voteUser.setRoom_id(user.getGroup_id());
		voteUser.setMember_id(user.getMember_id());
		int confirm = userSvc.confirmVote(voteUser);
		if(confirm != 0) {
			result.put("voteComplet", 1);
		} else {
			int newVoter = userSvc.newVoteUser(voteUser);
			if(newVoter == 0) {
				result.put("voteFail", 1);
			}
		}
		
		// Vote Result
		VoteRequest selectVote = voteSvc.getVote(voteUser.getList_id());
		List<VoteContent> voteList = selectVote.getVoteCon();
		for ( VoteContent con : voteList) {
			VoteResult votecon = 
					new VoteResult(
							con.getRoom_id(), 
							con.getVote_id(), 
							con.getList_id(), 
							con.getContent(), 
							userSvc.voteCount(con.getList_id()));
			list.add(votecon);
		}
		result.put("voteList", list);
		
		
		return result;
	}
	
//  --------------------------------- Vote Update ----------------------------------------
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(Model model, 
			@RequestParam("con_id") int con_id) {
		
		VoteRequest selectVote = voteSvc.getVote(con_id);
		if( selectVote != null) {
			model.addAttribute("vote", selectVote);
		}
		
		return VOTE_UPDATE;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateVote(Model model, 
			@ModelAttribute("user") User user,
			@RequestParam("con_id") int con_id,
			@RequestParam("vote_name") String vote_name,
			@RequestParam("vote_list") String[] conList) {
		
		// 등록된 데이터 가져오기
		VoteRequest selectVote = voteSvc.getVote(con_id);
		Vote vote = selectVote.getVote();
		List<VoteContent> votConList = selectVote.getVoteCon();
		
		// 새로 값 넣어주기
		List<VoteContent> reqVoteCon = new ArrayList<>();
		vote.setTitle(vote_name);
		
		for(int i = 0; i < votConList.size(); i++) {
			VoteContent list = votConList.get(i);
			list.setContent(conList[i]);
			reqVoteCon.add(list);
			System.out.println(i +"aaa : "+ conList[i]);
		}
		
		// 업데이트 시작
		int updateResult = voteSvc.updateVote(vote, votConList);
		
		if( updateResult == 0) {
			model.addAttribute("updateFail", Boolean.TRUE);
			return VOTE_UPDATE;
		}
		VoteRequest newVote = voteSvc.getVote(con_id);
		model.addAttribute("vote", newVote);
		
		return "vote/updateResult";
	}
	
//  --------------------------------- Vote Delete ----------------------------------------
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, @RequestParam("con_id") int con_id) {
		model.addAttribute("con_id", con_id);
		return VOTE_DELETE;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, @ModelAttribute("user") User user, 
			@RequestParam("con_id") int con_id, @RequestParam("delete_pw")String delete_pw) throws Exception {
		
		Member member = memberSvc.selectByUser(user.getMember_id());
		
		HashMap<String, Object> errors = memberSvc.confirmMember(member, delete_pw);
		model.addAttribute("errors", errors);
		
		if (errors.containsKey("notFoundUser")) {
			errors.put("idError", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			model.addAttribute("con_id", con_id);
			return VOTE_DELETE;
		} 
	
		return VOTE_DELETE;
	
	}

}

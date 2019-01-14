package com.haeyoum.group.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haeyoum.group.model.Vote;
import com.haeyoum.group.model.VoteContent;
import com.haeyoum.group.model.VoteReq;
import com.haeyoum.group.model.VoteRequest;
import com.haeyoum.group.repository.VoteDAO;
import com.haeyoum.util.DateUtil;

@Service
public class VoteService {

	@Autowired
	private VoteDAO voteDAO;
	private DateUtil util = new DateUtil();
	
	public Vote selectVote(int con_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("con_id", con_id);
		return voteDAO.selectVote(map);
	}
	
	public VoteRequest getVote(int con_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("con_id", con_id);
		VoteRequest voteReq = new VoteRequest(voteDAO.selectVote(map), voteDAO.selectVoteCon(map));
		return voteReq;
	}
	
	public List<VoteReq> voteList(int group_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("group_id", group_id);
		List<VoteReq> voteReqList = new ArrayList<>();
		
		for (Vote vote : voteDAO.selectList(map)) {
			VoteReq voteReq = new VoteReq(
					vote.getRoom_id(),
					vote.getSort_id(),
					vote.getVote_id(),
					vote.getTitle(),
					vote.getWriter(),
					util.convertDayTime(vote.getStart_date()),
					util.convertDayTime(vote.getEnd_date()));
			voteReqList.add(voteReq);
		}
		
		return voteReqList;
	}
	
	@Transactional
	public int createVote(Vote vote, ArrayList<String> conText) {
		voteDAO.insert(vote);
		
		for(int i= 0 ; i < conText.size() ; i++) {
			if(conText.get(i).trim().length() != 0) {
				VoteContent voteCon = new VoteContent(vote.getRoom_id(), vote.getVote_id(), conText.get(i));
				voteDAO.insertVoteCon(voteCon); 
			}
		}
		return vote.getVote_id();
	}
	
	public int deleteVote(Vote vote) {
		return voteDAO.deleteVote(vote);
		
	}

	@Transactional
	public int updateVote(Vote vote, List<VoteContent> votConList) {
		int result = voteDAO.updateVote(vote);
		int conResult = 0;
		
		if(result != 0) {
			for(VoteContent voteCon : votConList) {
				System.out.println(voteCon.getList_id());
				conResult = voteDAO.updateVoteCon(voteCon);
			}
		}
		return conResult;
	}

}
 


package com.haeyoum.group.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeyoum.group.model.VoteUser;
import com.haeyoum.group.repository.VoteDAO;

@Service
public class VoteUserService {

	@Autowired
	private VoteDAO voteUserDAO;
	
	public int confirmVote(VoteUser vote_user) {
		return voteUserDAO.confirmVote(vote_user);
	}
	
	public VoteUser selectVoteUser(VoteUser voteUser) {
		return voteUserDAO.selectVoteUser(voteUser);
	}
	
	public int newVoteUser(VoteUser vote_user) {
		return voteUserDAO.newVoteUser(vote_user);
	}
	
	public int voteCount(int vote_list_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("vote_list_id", vote_list_id);
		return voteUserDAO.voteCount(map);
	}
	
}

package com.haeyoum.group.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.group.model.Vote;
import com.haeyoum.group.model.VoteContent;
import com.haeyoum.group.model.VoteUser;

@Repository
public class VoteDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strVoteSpace = "group.model.VoteMapper";
	private String strVoteUserSpace = "group.model.VoteUserMapper";
	
//	------------------------- vote -----------------------------------------
	public List<Vote> selectList(HashMap<String, Object> map) {
		return sqlSession.selectList(strVoteSpace + ".selectVoteList", map);
	}
	public Vote selectVote(HashMap<String, Object> map) {
		return sqlSession.selectOne(strVoteSpace + ".selectVote", map);
	}
	public int insert(Vote vote) {
		return sqlSession.insert(strVoteSpace + ".insert", vote);
	}
	public int updateVote(Vote vote) {
		return sqlSession.update(strVoteSpace + ".updateVote", vote);
	}
	public int deleteVote(Vote vote) {
		return sqlSession.delete(strVoteSpace + ".deleteVote", vote); 
	}
	
// 	------------------------- content -----------------------------------------
	public List<VoteContent> selectVoteCon(HashMap<String, Object> map){
		return sqlSession.selectList(strVoteSpace + ".selectVoteCon", map);
	}
	public int insertVoteCon(VoteContent voteCon) {
		return sqlSession.insert(strVoteSpace + ".insertVoteCon", voteCon);
	}
	public int updateVoteCon(VoteContent voteCon) {
		return sqlSession.update(strVoteSpace + ".updateVoteCon", voteCon);
	}
	public int deleteVoteCon(VoteContent voteCon) {
		return sqlSession.delete(strVoteSpace + ".deleteVoteCon", voteCon);
	}
	
	
//	------------------------- vote user -----------------------------------------
	public int confirmVote(VoteUser voteUser) {
		return sqlSession.selectOne(strVoteUserSpace + ".confirmVote", voteUser);
	}
	public VoteUser selectVoteUser(VoteUser voteUser) {
		return sqlSession.selectOne(strVoteUserSpace + ".selectVoteUser", voteUser);
	}
	public int newVoteUser(VoteUser voteUser) {
		return sqlSession.insert(strVoteUserSpace + ".newVoteUser", voteUser);
	}
	public int voteCount(HashMap<String, Object> map) {
		return sqlSession.selectOne(strVoteUserSpace + ".voteCount", map);
	}
	public int deleteVoteUser(HashMap<String, Object> map) {
		return sqlSession.delete(strVoteUserSpace + ".deleteVoteUser", map);
	}
	
}

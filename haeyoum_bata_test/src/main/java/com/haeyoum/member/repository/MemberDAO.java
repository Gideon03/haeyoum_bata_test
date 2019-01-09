package com.haeyoum.member.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haeyoum.member.model.Member;
import com.haeyoum.member.model.MemberInfo;
import com.haeyoum.member.model.MemberLog;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String nameSpace = "member.model.MemberMapper";

//	------------------------------------- Member --------------------------------------
	//가입
	public void signUp(Member member) throws Exception {
        sqlSession.insert(nameSpace+".insertUser", member);
    }
	
    //email 중복 확인
    public Member checkEmail(String m_email) throws Exception {
        return sqlSession.selectOne(nameSpace+".chkEmail", m_email);
    }
 
    //이메일 인증 코드 확인
    public Member chkAuth(String m_authkey) throws Exception {
        return sqlSession.selectOne(nameSpace + ".chkAuthkey", m_authkey);
    }
    
    //인증 후 계정 활성화
    public void successAuthkey(Member member) throws Exception {
        sqlSession.update(nameSpace + ".keyConfirm", member);
    }
    
    //로그인 아이디 찾기
    public Member selectByUser(String m_email) throws Exception {
        return sqlSession.selectOne(nameSpace+".selectByUser", m_email);
    }
    
//	------------------------------------- Member Info --------------------------------------
    //유저정보 생성
    public int createInfo(MemberInfo memInfo) {
    	return sqlSession.insert(nameSpace+".insertInfo", memInfo);
    }
   
    //유저정보 조회
    public MemberInfo selectInfo(String m_email) {
    	return sqlSession.selectOne(nameSpace+".selectInfo", m_email);
    }
    
    //유저정보 변경
    public int updateInfo(MemberInfo memInfo) {
    	return sqlSession.selectOne(nameSpace+".editInfo", memInfo);
    }

    //	------------------------------------- Member Log --------------------------------------
    //유저 접속정보 생성
    public int createLog(String m_email) {
    	return sqlSession.insert(nameSpace+".insertLog", m_email);
    }
   
    //유저 접속정보 조회
    public MemberLog selectLog(String m_email) {
    	return sqlSession.selectOne(nameSpace+".selectLog", m_email);
    }
    
    //유저 접속정보 변경
    public int updateLog(String m_email) {
    	return sqlSession.selectOne(nameSpace+".updateLog", m_email);
    }
    
}

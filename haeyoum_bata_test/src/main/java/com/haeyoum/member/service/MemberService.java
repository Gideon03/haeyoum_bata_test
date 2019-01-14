package com.haeyoum.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.haeyoum.error.LoginError;
import com.haeyoum.handler.MailHandler;
import com.haeyoum.member.model.User;
import com.haeyoum.member.model.Member;
import com.haeyoum.member.model.MemberInfo;
import com.haeyoum.member.model.MemberLog;
import com.haeyoum.member.repository.MemberDAO;
import com.haeyoum.util.TempKey;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	@Autowired
	private JavaMailSender mailSender;
	
//	------------------------------------- Member --------------------------------------
	public void regist(Member member) throws Exception {
		String key = new TempKey().generateKey(30);  // 인증키 생성
        member.setAuthkey(key);
        System.out.println("key : " + key);
        
        //DB에 가입정보등록
		dao.signUp(member);
        
        //메일 전송
        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject("HAEYOUM 서비스 이메일 인증");
        sendMail.setText(
                new StringBuffer()
                .append("<h1>메일인증</h1>")
                .append("<a href='http://localhost:8080/haeyoum_beta_test/emailConfirm?authKey=")
                .append(key)
                .append("' target='_blank'>이메일 인증 확인</a>")
                .toString());
        
        sendMail.setFrom("haeyoum.auth@gmail.com", "Haeyoum");
        sendMail.setTo(member.getEmail());
        sendMail.send();
    }

    //이메일 인증 키 검증
    public Member userAuth(String m_authkey) throws Exception {
        Member member = new Member();
        member = dao.chkAuth(m_authkey);
   
        if(member!=null){
            try{
                dao.successAuthkey(member);
                dao.createInfo(new MemberInfo(member.getEmail()));
                dao.createLog(member.getEmail());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return member;
    }
    
    //로그인 유저 데이터 가져오기
    public Member selectByUser(String m_email) throws Exception {
		return dao.selectByUser(m_email);
	}
    
    //로그인 유저 데이터 검증
    public LoginError confirmMember(Member member, String password) {
		LoginError errors = new LoginError();
    	if (member == null) {
			errors.setIdError(true);
			System.out.println("id");
			return errors;
		} else if (!member.getPassword().equals(password)) {
			System.out.println("password");
			errors.setPwError(true);
		} else if (!member.getAuthkey().equals("0")) {
			System.out.println("key");
			errors.setNotConfirmUser(true);
		}
		return errors;
	}
    //세션에 저장할 유저데이터 생성 
    public User loginUser(Member member) {
    	//유저 접속시간 갱신
    	MemberLog memLog = dao.selectLog(member.getEmail());
    	if (memLog == null) {
    		System.out.println("1");
    		dao.createLog(member.getEmail());
    	}
    	dao.updateLog(member.getEmail());
		return new User(member.getEmail(), true);
	}
    
//	------------------------------------- Member Info --------------------------------------
    //유저정보 조회
    public MemberInfo selectInfo(String m_email) {
    	return dao.selectInfo(m_email);
    }
    
    //유저정보 변경
    public int updateInfo(MemberInfo memInfo) {
    	if (dao.selectInfo(memInfo.getEmail()) == null) {
    		dao.createInfo(memInfo);
    	}
    	return dao.updateInfo(memInfo);
    }
    
}

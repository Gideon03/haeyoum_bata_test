package com.haeyoum.member.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
		String key = new TempKey().getKeyCode(30);  // 인증키 생성
        member.setM_authkey(key);
        System.out.println("key : " + key);
        
        //DB에 가입정보등록
		dao.signUp(member);
        
        //메일 전송
        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject("HAEYOUM 서비스 이메일 인증");
        sendMail.setText(
                new StringBuffer()
                .append("<h1>메일인증</h1>")
                .append("<a href='http://localhost:8080/haeyoum_bata_test/emailConfirm?memberAuthKey=")
                .append(key)
                .append("' target='_blank'>이메일 인증 확인</a>")
                .toString());
        
        sendMail.setFrom("haeyoum.auth@gmail.com", "Haeyoum");
        sendMail.setTo(member.getM_email());
        sendMail.send();
    }

    //이메일 인증 키 검증
    public Member userAuth(String m_authkey) throws Exception {
        Member member = new Member();
        member = dao.chkAuth(m_authkey);
   
        if(member!=null){
            try{
                dao.successAuthkey(member);
                dao.createInfo(new MemberInfo(member.getM_email()));
                dao.createLog(member.getM_email());
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
    public HashMap<String, Object> confirmMember(Member member, String m_password) {
		HashMap<String, Object> errors = new HashMap<String, Object>();
		if (member == null) {
			errors.put("notFoundUser", Boolean.TRUE);
			return errors;
		} else if (!member.getM_password().equals(m_password)) {
			errors.put("pwError", Boolean.TRUE);
		} else if (!member.getM_authkey().equals("0")) {
			errors.put("notConfirmUser", Boolean.TRUE);
		}
		return errors;
	}
    //세션에 저장할 유저데이터 생성 
    public User loginUser(Member member) {
    	//유저 접속시간 갱신
    	MemberLog memLog = dao.selectLog(member.getM_email());
    	if (memLog == null) {
    		System.out.println("1");
    		dao.createLog(member.getM_email());
    	}
    	dao.updateLog(member.getM_email());
		return new User(member.getM_email(), true);
	}
    
//	------------------------------------- Member Info --------------------------------------
    //유저정보 조회
    public MemberInfo selectInfo(String m_email) {
    	return dao.selectInfo(m_email);
    }
    
    //유저정보 변경
    public int updateInfo(MemberInfo memInfo) {
    	if (dao.selectInfo(memInfo.getM_email()) == null) {
    		dao.createInfo(memInfo);
    	}
    	return dao.updateInfo(memInfo);
    }
    
}

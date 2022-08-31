package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public void customSignup(MemberVO member) {
		member.setUserpw(pwEncoder.encode(member.getUserpw()));
		log.info(member.getUserpw());
		
		mapper.insertMember(member);
		//mapper.insertMemberAuth(member);
	}

}

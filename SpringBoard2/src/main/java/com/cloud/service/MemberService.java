package com.cloud.service;

import com.cloud.domain.MemberVO;

public interface MemberService {
	
	//회원 가입
	public void signup(MemberVO member);
}

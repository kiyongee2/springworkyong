package com.cloud.mapper;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userid); //회원 조회(검색)
	
	public void insertMember(MemberVO member); //회원 가입
	
}

package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	//회원 조회(검색)
	//public MemberVO read(String userid); 
	
	public List<MemberVO> getMemberList();
}

package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	//ȸ�� ��ȸ(�˻�)
	//public MemberVO read(String userid); 
	
	public List<MemberVO> getMemberList();
}

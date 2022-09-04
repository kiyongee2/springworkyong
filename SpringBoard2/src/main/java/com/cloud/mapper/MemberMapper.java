package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	public void insertMember(MemberVO member); //회원 가입
	
	public List<MemberVO> getMemberList(); //회원 목록
	
	public MemberVO read(String userid); //회원 조회(검색)
	
	public void deleteMember(MemberVO member);  //회원 탈퇴
	
	public void updateMember(MemberVO member);  //회원 수정
	
}

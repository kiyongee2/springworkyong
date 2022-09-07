package com.cloud.service;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberService {
	
	public void signup(MemberVO member); //회원 가입
	
	public List<MemberVO> getMemberList(); //회원 목록
	
	public MemberVO read(String userid);  //회원 상세보기
	
	public void delete(MemberVO member);  //회원 삭제
	
	public void update(MemberVO member);  //회원 수정
	
	public int checkID(String userid);  //ID 중복 체크
}

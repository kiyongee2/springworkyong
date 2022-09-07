package com.cloud.service;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberService {
	
	public void signup(MemberVO member); //ȸ�� ����
	
	public List<MemberVO> getMemberList(); //ȸ�� ���
	
	public MemberVO read(String userid);  //ȸ�� �󼼺���
	
	public void delete(MemberVO member);  //ȸ�� ����
	
	public void update(MemberVO member);  //ȸ�� ����
	
	public int checkID(String userid);  //ID �ߺ� üũ
}

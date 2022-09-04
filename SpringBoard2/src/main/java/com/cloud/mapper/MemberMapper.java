package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	public void insertMember(MemberVO member); //ȸ�� ����
	
	public List<MemberVO> getMemberList(); //ȸ�� ���
	
	public MemberVO read(String userid); //ȸ�� ��ȸ(�˻�)
	
	public void deleteMember(MemberVO member);  //ȸ�� Ż��
	
	public void updateMember(MemberVO member);  //ȸ�� ����
	
}

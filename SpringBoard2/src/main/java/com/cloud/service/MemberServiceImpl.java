package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public List<MemberVO> getMemberList() {
		return mapper.getMemberList();
	}

}

package com.cloud.mapper;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO read(String userid);
}

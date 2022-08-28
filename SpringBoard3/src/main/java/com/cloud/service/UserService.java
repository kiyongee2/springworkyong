package com.cloud.service;

import com.cloud.domain.UserVO;

public interface UserService {
	
	public boolean login(UserVO vo);  //로그인 처리
}

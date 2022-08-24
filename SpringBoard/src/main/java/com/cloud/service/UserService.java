package com.cloud.service;

import com.cloud.repository.UserVO;

public interface UserService {
	
	public boolean login(UserVO vo);  //로그인 처리
}

package com.cloud.service;

import java.util.List;

import com.cloud.repository.UserVO;

public interface UserService {
	
	public List<UserVO> getUserList(); 
	
	public void insert(UserVO user);
	
	public int login(UserVO vo);  //로그인 처리
	
	public UserVO getUser(String id);
	
	public boolean duplicatedID(String id);
}

package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.UserDAO;
import com.cloud.repository.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO dao;

	@Override
	public boolean login(UserVO vo) {
		return dao.login(vo);
	}
}

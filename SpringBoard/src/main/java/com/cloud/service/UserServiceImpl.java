package com.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.repository.UserDAO;
import com.cloud.repository.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO dao;

	@Override
	public int login(UserVO vo) {
		return dao.login(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public void insert(UserVO user) {
		dao.insertUser(user);
	}

	@Override
	public UserVO getUser(String id) {
		return dao.getUser(id);
	}

	@Override
	public boolean duplicatedID(String id) {
		return dao.duplicatedID(id);
	}
}

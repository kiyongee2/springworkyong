package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.UserVO;
import com.cloud.service.UserService;

@Controller
public class UserController{

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView() { //로그인 폼 페이지 요청
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) { //로그인 처리 요청
		boolean result = service.login(vo);

		if(result) {
			session.setAttribute("sessionId", vo.getId()); //세션 발급
			return "redirect:boardList";
		}else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { //로그 아웃 처리 요청
		session.invalidate(); //세션 삭제
		return "index";
	}
}

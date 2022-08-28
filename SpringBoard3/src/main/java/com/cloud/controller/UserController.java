package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.domain.UserVO;
import com.cloud.service.UserService;

@Controller
public class UserController{

	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public String loginView() { //로그인 폼 페이지 요청
		return "login";
	}
	
	//로그인 처리 요청
	@PostMapping("/login")
	public String login(UserVO vo, HttpSession session, Model model) { 
		boolean result = service.login(vo);
		System.out.println(result);
		if(result==true) {
			session.setAttribute("sessionId", vo.getId()); //세션 발급
			return "redirect:/board/boardList";
		}else {
			int error = 1;
			model.addAttribute("error", error);
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { //로그 아웃 처리 요청
		session.invalidate(); //세션 삭제
		return "index";
	}
}

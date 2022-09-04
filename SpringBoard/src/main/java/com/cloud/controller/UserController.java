package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.repository.BoardVO;
import com.cloud.repository.UserVO;
import com.cloud.service.UserService;

@RequestMapping("/user/*")
@Controller
public class UserController{

	@Autowired
	private UserService service;
	
	//회원 목록
	@RequestMapping("/userList")
	public String getBoardList(Model model, HttpSession session) {  //게시글 목록 요청
		List<UserVO> userList = service.getUserList();
		String id = (String)session.getAttribute("sessionId");
		model.addAttribute("userList", userList); //model-"boardList"
		model.addAttribute("id", id);
		return "/user/userList";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signUp(){ 
		return "/user/signup";
	}
	
	//회원 가입
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signUp(UserVO user){ 
		service.insert(user);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView() { //로그인 폼 페이지 요청
		return "/user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO user, HttpSession session, Model model) { //로그인 처리 요청
		if(user.getId() == null || user.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		
		int result = service.login(user);
		System.out.println(result);
		if(result==1) {
			session.setAttribute("sessionId", user.getId()); //세션 발급
			return "redirect:/user/userList";
		}else {
			int error = 1;
			model.addAttribute("error", error);
			return "/user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { //로그 아웃 처리 요청
		session.invalidate(); //세션 삭제
		return "index";
	}
	
	//회원 정보
	@GetMapping("/userView")
	public String getUser(String id, Model model) {
		UserVO user = service.getUser(id);
		model.addAttribute("user", user);
		return "/user/userView";
	}
}

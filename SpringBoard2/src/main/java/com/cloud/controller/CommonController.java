package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.MemberVO;
import com.cloud.service.CommonService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	@Autowired
	private CommonService service;

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	//로그인
	@GetMapping("/customLogin")
	public void login(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout:" + logout);
		
		if(error != null) {
			model.addAttribute("error", "아이디나 비밀번호를 확인해주세요");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!");
		}
	}
	
	//로그아웃
	@GetMapping("/customLogout")
	public void logout() {
		log.info("custom logout");
	}
	
	/*//회원 가입 폼 요청
	@GetMapping("/customSignup")
	public void signUp() {
		log.info("회원 가입 폼");
	}
	
	//회원 가입 처리
	@PostMapping("/customSignup")
	public String signUp(MemberVO member, RedirectAttributes rttr) {
		service.customSignup(member);
		rttr.addFlashAttribute("result", member.getUserName());
		return "redirect:/board/boardList";
	}*/
}









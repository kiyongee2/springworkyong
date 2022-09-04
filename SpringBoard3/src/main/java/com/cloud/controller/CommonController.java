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

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "�ش� �޴��� �����ڿ��Ը� �����˴ϴ�.");
	}
	
	//�α���
	@GetMapping("/customLogin")
	public void login(String error, String logout, Model model, HttpSession session) {
		log.info("error: " + error);
		log.info("logout:" + logout);
		
		if(error != null) {
			model.addAttribute("error", "���̵� ��й�ȣ�� Ȯ�����ּ���");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "�α׾ƿ�!!");
		}
	}
	
	//�α׾ƿ�
	@GetMapping("/customLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		log.info("custom logout");
		return "redirect:/";
	}
}









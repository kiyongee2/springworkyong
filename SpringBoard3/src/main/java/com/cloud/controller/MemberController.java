package com.cloud.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.MemberVO;
import com.cloud.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	private MemberService service;  //생성자 주입
	
	//회원 가입 폼 요청
	@GetMapping("/signup")
	public void signUp() {
		log.info("회원 가입 폼");
	}
	
	@PostMapping("/signup")
	public String signUp(MemberVO member, RedirectAttributes rttr) {
		service.signup(member);
		//rttr.addFlashAttribute("result", member.getUserid());
		return "redirect:/customLogin";
	}
	
	//회원 목록 보기
	@GetMapping("/memberList")
	@PreAuthorize("isAuthenticated()")
	public String getMemberList(Model model) {
		List<MemberVO> memberList = service.getMemberList();
		model.addAttribute("memberList", memberList);
		return "/member/memberList";
	}
	
	//회원 상세 보기
	@GetMapping("/memberView")
	public String read(String userid, Model model) {
		MemberVO member = service.read(userid);
		model.addAttribute("member", member);
		return "/member/memberView";
	}
	
	//회원 삭제
	@GetMapping("/delete")
	public String delete(MemberVO member) {
		service.delete(member);
		return "redirect:/member/memberList";
	}
	
	//회원 수정
	@PostMapping("/update")
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:/member/memberList";
	}
	
	//테스트 - jstl functions 태그
	@GetMapping("/functions")
	public String myFunction() {
		return "/member/functions";
	}
}









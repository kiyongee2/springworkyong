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
	
	private MemberService service;  //������ ����
	
	//ȸ�� ���� �� ��û
	@GetMapping("/signup")
	public void signUp() {
		log.info("ȸ�� ���� ��");
	}
	
	@PostMapping("/signup")
	public String signUp(MemberVO member, RedirectAttributes rttr) {
		service.signup(member);
		//rttr.addFlashAttribute("result", member.getUserid());
		return "redirect:/customLogin";
	}
	
	//ȸ�� ��� ����
	@GetMapping("/memberList")
	@PreAuthorize("isAuthenticated()")
	public String getMemberList(Model model) {
		List<MemberVO> memberList = service.getMemberList();
		model.addAttribute("memberList", memberList);
		return "/member/memberList";
	}
	
	//ȸ�� �� ����
	@GetMapping("/memberView")
	public String read(String userid, Model model) {
		MemberVO member = service.read(userid);
		model.addAttribute("member", member);
		return "/member/memberView";
	}
	
	//ȸ�� ����
	@GetMapping("/delete")
	public String delete(MemberVO member) {
		service.delete(member);
		return "redirect:/member/memberList";
	}
	
	//ȸ�� ����
	@PostMapping("/update")
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:/member/memberList";
	}
	
	//�׽�Ʈ - jstl functions �±�
	@GetMapping("/functions")
	public String myFunction() {
		return "/member/functions";
	}
}









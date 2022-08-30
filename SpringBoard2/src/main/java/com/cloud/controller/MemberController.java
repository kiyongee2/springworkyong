package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.domain.MemberVO;
import com.cloud.service.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		List<MemberVO> memberList = service.getMemberList();
		model.addAttribute("memberList", memberList);
		return "/member/memberList";
	}
	
	@GetMapping("/insertMember")
	public String insertMember() {
		return "/member/insertMember";
	}
}

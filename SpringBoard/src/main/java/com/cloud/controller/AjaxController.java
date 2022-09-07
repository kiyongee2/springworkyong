package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/ajax/*")
@Controller
public class AjaxController {
	
	@GetMapping("/jquery1")
	public void jquery1() {
	}
	
	@GetMapping("/calc")
	public String calcView() {
		return "/ajax/calc";
	}
	
	//���ϱ� ���
	/*@RequestMapping("/doPlus")
	@ResponseBody   //������ ���
	public int doPlus(int num1, int num2) {
		return num1 + num2;
	}*/
	
	//���ϱ� �� �޽��� ó��
	@RequestMapping(value="/doPlus", produces="application/text; charset=UTF-8")
	@ResponseBody   //������ ���
	public String doPlus(int num1, int num2) {
		int sum = num1 + num2;
		String msg = "���ϱ⿡ �����߽��ϴ�.";
		return sum + " / " + msg;
	}
}

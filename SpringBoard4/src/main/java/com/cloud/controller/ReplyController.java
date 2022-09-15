package com.cloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.domain.Criteria;
import com.cloud.domain.ReplyVO;
import com.cloud.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RequestMapping("/replies/*")
@RestController
public class ReplyController {
	
	private ReplyService service;

	@PostMapping("/insert")
	public String insert(@RequestBody ReplyVO vo) {
		log.info("´ñ±Û µî·Ï");
		service.register(vo);
		return "insertSuccess";
	}
	
	@GetMapping("/getList/{bno}")
	public Map<String, Object> getList(Criteria cri, @PathVariable int bno) {
		log.info("´ñ±Û ¸ñ·Ï º¸±â");
		List<ReplyVO> list = service.getList(cri, bno);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/board/boardView");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		return map;
	}
}





package com.cloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	/*@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("list", service.getList());
	}*/
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info(cri);
		log.info("/list");
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 123));
	}
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void registerGet() {
		log.info("/get..page");
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("board: " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno()); 
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));  //蹂대궪 媛앹껜 ���옣
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove..." + bno);
		service.remove(bno);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("remove..." + board);
		service.modify(board);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}
}
